package mongkey.maeilmail.dto.helper.request;

import lombok.Getter;

@Getter
public class HelperRequestDto {
    private String user_id;
    private String sender;
    private String sender_info;
    private String receiver;
    private String receiver_info;
    private String purpose;
}
