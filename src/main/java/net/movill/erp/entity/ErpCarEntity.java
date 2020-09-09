package net.movill.erp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.movill.erp.dto.ErpCarDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "car_erp")
@NoArgsConstructor
public class ErpCarEntity extends net.movill.common.entity.BaseEntity implements Serializable {
    private static final long serialVersionUID = -3514533048735898205L;

    public ErpCarEntity(ErpCarDto dto) {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Long idx;

    @Column(name = "apt_idx")
    private Integer aptIdx;

    @Column(name = "dong", nullable = false)
    private String dong;

    @Column(name = "ho", nullable = false)
    private String ho;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "cancel_date")
    private Date cancelDate;

    @Column(name = "car_manage_number_issue_date")
    private Date carManageNumberIssueDate;

    @Column(name = "car_owner_name")
    private String carOwnerName;

    @Column(name = "car_owner_contact")
    private String carOwnerContact;

    @Column(name = "etc")
    private String etc;

    @Column(name = "car_manage_number")
    private String carManageNumber;

}
