package com.ahsan.spam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SpamCheckHistory {

    @Id
    @SequenceGenerator(
            name = "spam_id_sequence",
            sequenceName = "spam_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "spam_id_sequence"
    )
    private Integer id;
    private Integer clientId;
    private Boolean isSpammer;
    private LocalDateTime createdAt;

}

