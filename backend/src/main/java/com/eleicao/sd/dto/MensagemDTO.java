package com.eleicao.sd.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO {
    private String batchId;
    private String sourceNodeId;
    private List<VotoDTO> dataPoints;

    @Override
    public String toString() {
        return "MensagemDTO{" +
                "batchId='" + batchId + '\'' +
                ", sourceNodeId='" + sourceNodeId + '\'' +
                ", dataPoints=" + dataPoints +
                '}';
    }
}
