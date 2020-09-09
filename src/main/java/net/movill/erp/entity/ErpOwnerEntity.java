package net.movill.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.movill.erp.dto.ErpResidentDto;
import net.movill.erp.util.Utility;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "erp_owner")
@AllArgsConstructor
@NoArgsConstructor
public class ErpOwnerEntity implements Serializable {
    private static final long serialVersionUID = 7319551417824714857L;

    public ErpOwnerEntity(ErpResidentDto dto, Long aptIdx) {
        this.aptIdx = aptIdx;
        this.dong = dto.getDong();
        this.ho = dto.getHo();
        this.relations = dto.getRelation();
        this.phone = dto.getPhone();
        try {
            this.birthday = Utility.parseDate(dto.getBirth());
        } catch (Exception e) {
            this.birthday = new Date();
        }
        this.cretime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Long idx;

    @Column(name = "apt_idx", nullable = false)
    private Long aptIdx;

    @Column(name = "dong", nullable = false)
    private String dong;

    @Column(name = "ho", nullable = false)
    private String ho;

    @Column(name = "relations")
    private String relations;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "phone")
    private String phone;

    @Column(name = "house_live_type")
    private String houseLiveType;

    @Column(name = "birthday")
    private Date birthday;

    @CreationTimestamp
    @Column(name = "cretime")
    private LocalDateTime cretime;

}
