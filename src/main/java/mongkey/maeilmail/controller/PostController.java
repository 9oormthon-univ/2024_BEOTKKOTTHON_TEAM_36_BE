package mongkey.maeilmail.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mongkey.maeilmail.common.response.ApiResponse;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.dto.post.LikePostRequestDto;
import mongkey.maeilmail.dto.post.SavePostRequestDto;
import mongkey.maeilmail.dto.post.UpdatePostRequestDto;
import mongkey.maeilmail.repository.PostRepository;
import mongkey.maeilmail.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private final PostService postService;

    @GetMapping("/post")
    public ApiResponse<?> findAllPost() {
        return postService.findAllPost();
    }

    @PostMapping("/post")
    public ApiResponse<?> savePost(@RequestBody SavePostRequestDto requestDto){
        String string = requestDto.toString();
        return postService.savePost(requestDto);
    }

    @PatchMapping("/post/{post_id}")
    public ApiResponse<?> updatePost(@PathVariable Long post_id,
                                     @RequestBody UpdatePostRequestDto requestDto){
        return postService.updatePost(post_id, requestDto);
    }

    @DeleteMapping("/post/{post_id}")
    public ApiResponse<?> deletePost(@PathVariable Long post_id){
        return postService.deletePost(post_id);
    }

    @GetMapping("/post/{post_id}/like")
    public ApiResponse<?> likePost(@PathVariable Long post_id,
                                   @RequestBody LikePostRequestDto requestDto) {

        return postService.likePost(post_id, requestDto);
    }

//    @GetMapping("/post/{post_id}/unlike")
//    public ApiResponse<?> unlikePost(@PathVariable Long post_id,
//                                     @RequestBody LikePostRequestDto requestDto) {
//
//        return postService.unlikePost(post_id);
//    }


}