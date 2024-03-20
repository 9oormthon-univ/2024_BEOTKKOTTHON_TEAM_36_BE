package mongkey.maeilmail.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mongkey.maeilmail.common.response.ApiResponse;
import mongkey.maeilmail.common.response.Error;
import mongkey.maeilmail.common.response.Success;
import mongkey.maeilmail.domain.Admin;
import mongkey.maeilmail.domain.Template;
import mongkey.maeilmail.dto.post.request.FindPostsByCategoryRequestDto;
import mongkey.maeilmail.dto.template.request.SaveTemplateRequestDto;
import mongkey.maeilmail.dto.template.response.AllTemplateResponseDto;
import mongkey.maeilmail.dto.template.response.SaveTemplateResponseDto;
import mongkey.maeilmail.repository.AdminRepository;
import mongkey.maeilmail.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemplateService {

    @Autowired
    private final TemplateRepository templateRepository;

    @Autowired
    private final AdminRepository adminRepository;

    /*템플릿 등록*/
    @Transactional
    public ApiResponse<?> saveTemplate(SaveTemplateRequestDto requestDto){
        Optional<Admin> findAdmin = adminRepository.findById(requestDto.getAdmin_id());
        //해당 사용자가 유저라면
        if (!findAdmin.isPresent()){
            return ApiResponse.failure(Error.ERROR, "권한이 없습니다");
        }
        Template template = templateRepository.save(requestDto.toEntity(findAdmin.get()));
        return ApiResponse.success(Success.SUCCESS, "게시글 등록에 성공했습니다");
    }

    /*모든 템플릿 조회*/
    @Transactional
    public ApiResponse<?> findAllTemplate(){
        List<Template> allTemplate = templateRepository.findAll();
        for (Template template : allTemplate) {
            System.out.println("template = " + template);
        }

        return ApiResponse.success(Success.SUCCESS, setAllTemplateResponseDto(allTemplate));
    }

    /*특정 템플릿 조회*/
    @Transactional
    public ApiResponse<?> findTemplate(Long template_id){
        System.out.println("template_id = " + template_id);
        Optional<Template> findTemplate = templateRepository.findById(template_id);
        if(!findTemplate.isPresent()){
            return ApiResponse.failure(Error.ERROR, "찾으려는 템플릿이 없습니다");
        }
        return ApiResponse.success(Success.SUCCESS, findTemplate);
    }

    /*템플릿 복사*/
    public ApiResponse<?> copyTemplate(Long template_id){
        Optional<Template> findTemplate = templateRepository.findById(template_id);
        if(!findTemplate.isPresent()){
            return ApiResponse.failure(Error.ERROR, "찾으려는 템플릿이 없습니다");
        }
        Template template = findTemplate.get();
        template.setCopy_count(template.getCopy_count() + 1);
        Template saveTemplate = templateRepository.save(template);
        return ApiResponse.success(Success.SUCCESS, "템플릿을 성공적으로 복사했습니다");
    }

//    findTemplatesByCategory

    //Delete

    //Update

    private AllTemplateResponseDto setAllTemplateResponseDto(List<Template> template) {
        return AllTemplateResponseDto.builder()
                .allTemplateList(template)
                .build();
    }

    private SaveTemplateResponseDto setSaveTemplateResponseDto(Template template) {
        return SaveTemplateResponseDto.builder()
                .id(template.getId())
                .title(template.getTitle())
                .content(template.getContent())
                .build();
    }
}