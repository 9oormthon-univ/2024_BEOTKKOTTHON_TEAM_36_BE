package mongkey.maeilmail.common.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

    // Default
    ERROR(HttpStatus.BAD_REQUEST, "Request processing failed"),


    //403 Forbidden
    NO_PERMISSION_TO_POST(HttpStatus.FORBIDDEN, "게시글을 수정하거나 삭제할 권한이 없습니다."),


    // 404 NOT FOUND
    ACCESS_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "액세스 토큰 정보를 찾을 수 없습니다."),



    // 409 CONFLICT
    NICKNAME_ALREADY_EXIST(HttpStatus.CONFLICT, "해당 닉네임을 가진 유저가 이미 존재합니다."),




    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    ;



    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
