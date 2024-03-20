package mongkey.maeilmail.service;

import mongkey.maeilmail.dto.helper.request.HelperRequestDto;
import mongkey.maeilmail.dto.helper.response.HelperResponseDto;
import mongkey.maeilmail.dto.helper.response.HelperRetryResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface ChatGPTService {

    HelperResponseDto createEmail(HelperRequestDto helperRequestDto);

    HelperRetryResponseDto retryEmail(String retryEmail, HelperRequestDto helperRequestDto);
}