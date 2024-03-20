package mongkey.maeilmail.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mongkey.maeilmail.common.response.ApiResponse;
//import mongkey.maeilmail.dto.post.SavePostRequestDto;
import mongkey.maeilmail.common.response.Error;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.PostLike;
import mongkey.maeilmail.domain.Template;
import mongkey.maeilmail.domain.User;
import mongkey.maeilmail.domain.enums.CategoryType;
import mongkey.maeilmail.dto.PageInfo;
import mongkey.maeilmail.dto.post.LikePostRequestDto;
import mongkey.maeilmail.dto.post.PostResponseDto;
import mongkey.maeilmail.dto.post.SavePostRequestDto;
import mongkey.maeilmail.dto.post.UpdatePostRequestDto;
import mongkey.maeilmail.dto.post.request.FindPostsByCategoryRequestDto;
import mongkey.maeilmail.dto.post.response.AllPostResponseDto;
import mongkey.maeilmail.dto.post.response.PostByCategoryDto;
import mongkey.maeilmail.repository.PostLikeRepository;
import mongkey.maeilmail.repository.PostRepository;
import mongkey.maeilmail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import mongkey.maeilmail.common.response.Success;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
//
    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final PostLikeRepository postLikeRepository;

    @Autowired
    private final UserRepository userRepository;
//
//    private Post post;
//
//
    @Transactional
    public ApiResponse<?> savePost(SavePostRequestDto requestDto){
        Post post = postRepository.save(requestDto.toEntity());
        return ApiResponse.success(Success.CREATE_POST_SUCCESS, setResponseDto(post));
    }

    @Transactional
    public ApiResponse<?> findAllPost(){
        List<Post> allPost = postRepository.findAll();
        for (Post post : allPost) {
            System.out.println("post = " + post);
        }

        return ApiResponse.success(Success.SUCCESS, AllPostResponseDto.builder().allPostList(allPost).build());
    }

//    /*카테고리별 게시글 조회*/
    public ApiResponse<?> findPostByCategory(CategoryType categoryType, Pageable pageable) {
        Page<Post> allPostByCategory = postRepository.findByCategory(pageable, categoryType.toString());
        System.out.println("allPostByCategory.toString() = " + allPostByCategory.toString());
        //set response
        //Set Response Dtos
        List<Post>postList = setPostList(allPostByCategory);
        PageInfo pageInfo = setPageInfo(allPostByCategory);
        return ApiResponse.success(Success.SUCCESS, PostByCategoryDto.builder()
                .pageInfo(pageInfo)
                .categoryType(categoryType)
                .postList(postList)
                .build());
//        //리턴할 때 json 형식 맞춰서 각 페이지 별 게시글 리턴
//        return ApiResponse.success(Success.SUCCESS, "카테고리별 게시글 조회에 성공했습니다");
    }

    @Transactional
    public ApiResponse<?> updatePost(Long post_id, UpdatePostRequestDto requestDto){
        Optional<Post> findPost = postRepository.findByPostIdAndUserId(post_id, requestDto.getUser_id());
        if (!findPost.isPresent()){
            return ApiResponse.failure(Error.NO_PERMISSION_TO_POST, "찾으려는 데이터가 없습니다");
        }
        Post post = findPost.get();

        List<UpdatePostRequestDto> list = new ArrayList<>();
        list.add(requestDto);

        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getCategory() != null) post.setCategory(list.get(i).getCategory());
            if(list.get(i).getTitle() != null) post.setTitle(list.get(i).getTitle());
            if(list.get(i).getContent() != null) post.setContent(list.get(i).getContent());
        }
        Post newPost = postRepository.save(post);

        return ApiResponse.success(Success.SUCCESS, setResponseDto(newPost));
    }

    @Transactional
    public ApiResponse<?> deletePost(Long post_id){
        Optional<Post> findPost = postRepository.findById(post_id);
        if (!findPost.isPresent()){
            return ApiResponse.failure(Error.NO_PERMISSION_TO_POST, "찾으려는 게시글이 없습니다");
        }
        postRepository.deleteById(post_id);
        return ApiResponse.success(Success.CREATE_POST_SUCCESS, "게시글 삭제를 완료했습니다");
    }


    @Transactional
    public ApiResponse<?> likePost(Long post_id, LikePostRequestDto requestDto){
        //해당 게시글 있는지 확인
        Optional<Post> findPost = postRepository.findById(post_id);

        // 해당 게시글을 찾을 수 없다면
        if (!findPost.isPresent()){
            return ApiResponse.failure(Error.NO_PERMISSION_TO_POST, "찾으려는 게시글이 없습니다");
        }

        String string = findPost.get().toString();
        System.out.println("string = " + string);

        // 게시글 존재시 유저가 해당 게시글에 좋아요 누른 상태인지 post_id, user_id를 통해 postlikes 테이블 조회
        Optional<PostLike> findPostLike = postLikeRepository.findByPostIdAndUserId(post_id, requestDto.toEntity().getUser_id());
        if (!findPostLike.isPresent()){
            // 이 시점에 user_id = String, post_id = Long
            PostLike savePostLike = postLikeRepository.save(new PostLike(requestDto.getUser_id(), post_id));
            return ApiResponse.success(Success.CREATE_POST_SUCCESS, "게시글 좋아요를 완료했습니다");
        }
        // 만약에 해당 게시글에 이미 좋아요 눌렀다면
        return ApiResponse.failure(Error.NO_PERMISSION_TO_POST, "게시글 좋아요를 실패했습니다");
    }

    public ApiResponse<?> unlikePost(Long post_id, LikePostRequestDto requestDto){
        Optional<Post> findPost = postRepository.findById(post_id);
        if (!findPost.isPresent()){
            return ApiResponse.failure(Error.NO_PERMISSION_TO_POST, "찾으려는 게시글이 없습니다");
        }

        // 해당 게시글이 있다면 -> postlikes 테이블에 post_id, user_id를 통해 유저가 해당 게시글에 좋아요 누른 상태인지 확인
        Optional<PostLike> findPostLike = postLikeRepository.findByPostIdAndUserId(post_id, requestDto.toEntity().getUser_id());
        if (findPostLike.isPresent()){
            postLikeRepository.deleteByPostIdAndUserId(requestDto.toEntity().getUser_id(), post_id);
            return ApiResponse.success(Success.CREATE_POST_SUCCESS, "게시글 좋아요 삭제를 완료했습니다");
        }
        // 해당 게시글이 좋아요 수가 0이라면

//        postRepository.deleteById(post_id);
        return ApiResponse.failure(Error.NO_PERMISSION_TO_POST, "해당 게시글 좋아요 수가 0이라서 삭제를 실패했습니다");
    }
    private PostResponseDto setResponseDto(Post post) {
        return PostResponseDto
                .builder()
                .user_id(post.getUser_id())
                .category(post.getCategory().toString())
                .title(post.getTitle())
                .content(post.getContent())
                .written_at(post.getCreated_at())
                .build();
    }

    private List<Post> setPostList(Page<Post> postPage){
        return postPage.stream()
                .map(post -> Post.builder()
                        .id(post.getId())
                        .user_id(post.getUser_id())
                        .category(post.getCategory())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build())
                .toList();
    }

    private PageInfo setPageInfo(Page<Post> postPage){
        return PageInfo.builder()
                .last(!postPage.hasNext())
                .previous(postPage.hasPrevious())
                .nowPage(postPage.getNumber())
                .totalPages(postPage.getTotalPages())
                .totalElements(postPage.getTotalElements())
                .build();
    }
}
