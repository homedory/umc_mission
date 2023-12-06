package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/register")
    public ApiResponse<StoreResponseDTO.createStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.createStoreDTO request,
                                                                          @RequestParam Long regionId) {
        Store store = storeCommandService.createStore(regionId, request);

        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.createReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.createReviewDTO request,
                                                                            @PathVariable("storeId") Long storeId,
                                                                            @RequestParam Long memberId) {
        Review review = storeCommandService.createReview(memberId, storeId, request);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }

    @GetMapping("/{storeId}/missions/{missionId}/challenge")
    public ApiResponse<StoreResponseDTO.challengeMissionResultDTO> challengeMission(@RequestParam Long memberId,
                                                                                    @PathVariable("storeId") Long storeId,
                                                                                    @PathVariable("missionId") Long missionId) {
        Mission mission = storeCommandService.challengeMission(missionId, memberId);

        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionResultDTO(mission));
    }


}
