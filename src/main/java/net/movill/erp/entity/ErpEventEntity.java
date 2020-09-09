package net.movill.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.movill.erp.dto.EventDto;
import net.movill.erp.enums.EventType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "erp_event")
@AllArgsConstructor
@NoArgsConstructor
public class ErpEventEntity implements Serializable {
    private static final long serialVersionUID = 2439394762290841898L;

    public ErpEventEntity(EventDto eventDto) {
        this.siteIdx = eventDto.getSiteIdx();
        this.dong = eventDto.getDong();
        this.ho = eventDto.getHo();
        this.event = eventDto.getEvent();
        this.type = eventDto.getType();
        this.aptIdx = eventDto.getAptIdx();
        this.cretime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Long idx;

    @Column(name = "site_idx", nullable = false)
    private Long siteIdx;

    @Column(nullable = false)
    private String dong;

    @Column(nullable = false)
    private String ho;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EventType event;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long aptIdx;

    @CreationTimestamp
    @Column(name = "cretime")
    private LocalDateTime cretime;

}
