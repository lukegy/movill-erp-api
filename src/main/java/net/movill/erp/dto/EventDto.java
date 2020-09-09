package net.movill.erp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.movill.erp.enums.EventType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto implements Serializable {

    @NotNull(message = "msg.required.params")
    @JsonProperty("site_idx")
    private Long siteIdx;

    @NotNull(message = "msg.required.params")
    private String dong;

    @NotNull(message = "msg.required.params")
    private String ho;

    @NotNull(message = "msg.required.params")
    private EventType event;

    @NotNull(message = "msg.required.params")
    private String type;

    private Long aptIdx;

}
