package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.*;
import umc.study.web.dto.StoreRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;



    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.createReviewDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(memberRepository.findById(memberId).get());
        newReview.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(newReview);
    }

    @Override
    public Store createStore(Long regionId, StoreRequestDTO.createStoreDTO request) {
        Store newStore = StoreConverter.toStore(request);
        newStore.setRegion(regionRepository.findById(regionId).get());

        return storeRepository.save(newStore);
    }

    @Override
    public Mission challengeMission(Long missionId, Long memberId) {
        Mission mission = missionRepository.findById(missionId).get();
        Member member = memberRepository.findById(memberId).get();

//        MemberMission newMemberMission = MemberMission.builder().build();
//        newMemberMission.setMission(mission);
//        newMemberMission.setMember(member);

        //entity 자동 등록
        MemberMission newMemberMission =  MemberMission.builder()
                .mission(mission)
                .member(member)
                .build();
        newMemberMission.setMember(member);

        return missionRepository.save(mission);
    }


}
