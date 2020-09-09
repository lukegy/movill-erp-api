package net.movill.erp.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErpCarDto {
    private String dong;
    private String ho;
    @JsonAlias("car_name")
    private String carName;
    @JsonAlias("car_number")
    private String carNumber;
    @JsonAlias("reg_date")
    private String regDate;
    @JsonAlias("owner_name")
    private String ownerName;
    @JsonAlias("owner_phone")
    private String ownerPhone;
    private String etc;
}
