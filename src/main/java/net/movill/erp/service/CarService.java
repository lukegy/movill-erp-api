package net.movill.erp.service;

import net.movill.erp.entity.ErpEventEntity;
import net.movill.erp.prop.ErpSiteProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("carService")
public class CarService {

    @Autowired
    private ErpSiteProperties properties;

    public void syncCar(ErpEventEntity event) {
        String url = properties.getUrl(event);
        if (!StringUtils.isEmpty(url)) {

        }
    }

}
