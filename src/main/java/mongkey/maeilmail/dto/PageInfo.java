package mongkey.maeilmail.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageInfo {
    private Integer nowPage;
    private Integer totalPages;
    private Long totalElements;
    private Boolean previous;
    private Boolean last;
}
