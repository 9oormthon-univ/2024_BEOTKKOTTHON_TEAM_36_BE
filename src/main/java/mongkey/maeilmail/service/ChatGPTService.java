package mongkey.maeilmail.service;

import mongkey.maeilmail.dto.helper.HelperRequestDto;
import mongkey.maeilmail.dto.helper.HelperResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ChatGPT 서비스 인터페이스
 *
 * @fileName : ChatGPTService
 * @since : 12/29/23
 */

@Service
public interface ChatGPTService {

    List<Map<String, Object>> modelList();

    Map<String, Object> isValidModel(String modelName);

    HelperResponseDto createEmail(HelperRequestDto helperRequestDto);
}