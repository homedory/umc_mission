package umc.study.service.StoreService;

import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.createReviewDTO request);

    Store createStore(Long regionId, StoreRequestDTO.createStoreDTO request);

    Mission challengeMission(Long missionId, Long memberId);
}
