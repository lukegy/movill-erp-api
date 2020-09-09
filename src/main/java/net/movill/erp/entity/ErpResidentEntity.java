package net.movill.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.movill.erp.dto.ErpResidentDto;
import net.movill.erp.util.Utility;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "erp_resident")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ErpResidentEntity implements Serializable {
    private static final long serialVersionUID = -9142972500229842004L;

    public ErpResidentEntity(ErpResidentDto dto, Long aptIdx) {
        this.aptIdx = aptIdx;
        this.dong = dto.getDong();
        this.ho = dto.getHo();
        this.relations = dto.getRelation();
        this.phone = dto.getPhone();
        try {
            this.birthday = Utility.parseDate(dto.getBirth());
        } catch (Exception e) {
            this.birthday = new java.util.Date();
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

    @Column(name = "cretime")
    private LocalDateTime cretime;

}
