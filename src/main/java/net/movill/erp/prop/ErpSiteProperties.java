package net.movill.erp.prop;

import net.movill.erp.entity.ErpEventEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(
    prefix = "movill"
)
@PropertySource({"classpath:/application.yml"})
public class ErpSiteProperties {
    private Map<String, String> erp = new HashMap();

    public ErpSiteProperties() {}

    public String get(String key) {
        return erp.get(key);
    }

    public String getUrl(ErpEventEntity event) {
        return erp.get(event.getType() + "." + event.getEvent().name().toLowerCase() + ".url");
    }

    public Map<String, String> getErp() {
        return this.erp;
    }
}
