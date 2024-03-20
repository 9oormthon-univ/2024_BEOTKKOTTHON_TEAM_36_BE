package mongkey.maeilmail.controller;

import mongkey.maeilmail.common.response.ApiResponse;
import mongkey.maeilmail.common.response.Success;
import mongkey.maeilmail.dto.helper.request.HelperRequestDto;
import mongkey.maeilmail.dto.helper.response.HelperResponseDto;
import mongkey.maeilmail.dto.helper.response.HelperRetryResponseDto;
import mongkey.maeilmail.service.ChatGPTService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/helper")
public class HelperController {
    private final ChatGPTService chatGPTService;

    public HelperController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }


    // 이메일 생성
    @PostMapping("")
    public ApiResponse<?> getEmail(@RequestBody HelperRequestDto helperRequestDto) {
        HelperResponseDto result = chatGPTService.createEmail(helperRequestDto);
        return  ApiResponse.success(Success.CREATE_EMAIL_SUCCESS, result);
    }

    // 이메일 생성
    @PostMapping("")
    public ApiResponse<?> retryEmail(@RequestParam(name = "content-part") String contentPart, @RequestBody HelperRequestDto helperRequestDto) {
        HelperRetryResponseDto result = chatGPTService.retryEmail(contentPart, helperRequestDto);
        return  ApiResponse.success(Success.RECREATE_EMAIL_SUCCESS, result);
    }
}
