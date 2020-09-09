package net.movill.erp.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErpResidentDto {
    private String dong;
    private String ho;
    private String relation;
    private String phone;

    @JsonAlias({"is_household", "is_house_hold"})
    private Boolean isHousehold;
    private String birth;
}
