package mongkey.maeilmail.controller;

import mongkey.maeilmail.common.response.ApiResponse;
import mongkey.maeilmail.common.response.Success;
import mongkey.maeilmail.dto.helper.HelperRequestDto;
import mongkey.maeilmail.service.ChatGPTService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/helper")
public class HelperController {
    private final ChatGPTService chatGPTService;

    public HelperController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }


    // ChatGPT 모델 리스트를 조회합니다.
    @GetMapping("/modelList")
    public ResponseEntity<List<Map<String, Object>>> selectModelList() {
        List<Map<String, Object>> result = chatGPTService.modelList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 모델 검증
    @GetMapping("/model")
    public ResponseEntity<Map<String, Object>> isValidModel(@RequestParam(name = "modelName") String modelName) {
        Map<String, Object> result = chatGPTService.isValidModel(modelName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    // 이메일 생성
    @PostMapping("")
    public ApiResponse<?> getEmail(@RequestBody HelperRequestDto HelperRequestDto) {
        Map<String, Object> result = chatGPTService.createEmail(HelperRequestDto);
        return  ApiResponse.success(Success.SUCCESS, result);
    }
}
