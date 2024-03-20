package mongkey.maeilmail.controller;

import lombok.RequiredArgsConstructor;
import mongkey.maeilmail.common.response.ApiResponse;
import mongkey.maeilmail.dto.post.request.FindPostsByCategoryRequestDto;
import mongkey.maeilmail.dto.template.request.SaveTemplateRequestDto;
import mongkey.maeilmail.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TemplateController {
    @Autowired
    private final TemplateService templateService;

    /* 모든 템플릿 조회*/
    @GetMapping("/template")
    public ApiResponse<?> findAllPost() {
        return templateService.findAllTemplate();
    }

    /*템플릿 등록*/
    @PostMapping("/template")
    public ApiResponse<?> saveTemplate(@RequestBody SaveTemplateRequestDto requestDto){
        return templateService.saveTemplate(requestDto);
    }

    /*특정 템플릿 조회*/
    @GetMapping("/template/{template_id}")
    public ApiResponse<?> findTemplate(@PathVariable Long template_id){
        System.out.println("template_id = " + template_id);
        return templateService.findTemplate(template_id);
    }

    /*템플릿 복사*/
    @GetMapping("/template/{template_id}/copy")
    public ApiResponse<?> copyTemplate(@PathVariable Long template_id){
        return templateService.copyTemplate(template_id);
    }

//    /*카테고리별 템플릿 조회*/
//    @GetMapping("/template/category")
//    public ApiResponse<?> findTemplatesByCategory(@RequestBody FindPostsByCategoryRequestDto requestDto){
//        return templateService.findTemplatesByCategory(requestDto);
//    }
}
