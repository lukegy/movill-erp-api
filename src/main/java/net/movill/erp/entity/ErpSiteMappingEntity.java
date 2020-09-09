package net.movill.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(
        name = "erp_site_mapping",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"site_idx", "apt_idx", "type"}) })
@AllArgsConstructor
@NoArgsConstructor
public class ErpSiteMappingEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, name = "site_idx")
    private Long siteIdx;

    @Column(nullable = false, name = "apt_idx")
    private Long aptIdx;

    @Column(nullable = false)
    private String type;

}
