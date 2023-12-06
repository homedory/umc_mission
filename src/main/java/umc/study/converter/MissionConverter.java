package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.StoreResponseDTO;

public class MissionConverter {

    public static StoreResponseDTO.challengeMissionResultDTO toChallengeMissionResultDTO(Mission mission) {
        return StoreResponseDTO.challengeMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
