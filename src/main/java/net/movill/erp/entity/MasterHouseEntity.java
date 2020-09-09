package net.movill.erp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "xperp_master_house")
@Data
@EqualsAndHashCode(callSuper = true)
public class MasterHouseEntity extends net.movill.common.entity.BaseEntity implements Serializable {

    private static final long serialVersionUID = 7167730857230573157L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Long idx;

    @Column(name = "apt_idx")
    private Long aptIdx;

    @Column(name = "dong", nullable = false)
    private String dong;

    @Column(name = "ho", nullable = false)
    private String ho;

    @Column(name = "distribution_area")
    private String distributionArea;

    @Column(name = "exclusive_area")
    private String exclusiveArea;

    @Column(name = "code_dong")
    private String codeDong;

    @Column(name = "code_ho")
    private String codeHo;

}
