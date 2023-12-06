package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.ReviewImage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class createReviewDTO {
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
    }

    @Getter
    public static class createStoreDTO {
        @NotBlank
        String name;
        @NotBlank
        String address;
    }
}
