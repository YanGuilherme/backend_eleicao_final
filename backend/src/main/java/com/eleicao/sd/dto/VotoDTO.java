package com.eleicao.sd.dto;

import java.time.LocalDateTime;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {
    private String type;
    private String objectIdentifier;
    private Long valor;
    private LocalDateTime eventDatetime;

    @Override
    public String toString() {
        return "VotoDTO{" +
                "type='" + type + '\'' +
                ", object='" + objectIdentifier + '\'' +
                ", valor=" + valor +
                ", datetime=" + eventDatetime +
                '}';
    }
}
