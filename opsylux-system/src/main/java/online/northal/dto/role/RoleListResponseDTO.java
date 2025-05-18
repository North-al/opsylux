package online.northal.dto.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import online.northal.domain.entity.SysRole;

public class RoleListResponseDTO extends SysRole {
    @JsonProperty("status")
    public Integer getStatusCode() {
        return super.getStatus() != null ? super.getStatus().getCode() : null;
    }

    @JsonProperty("statusText")
    public String getStatusText() {
        return super.getStatus() != null ? super.getStatus().getText() : "未知";
    }

    @JsonProperty("scope")
    public Integer getScopeCode() {
        return super.getScope() != null ? super.getScope().getCode() : null;
    }

    @JsonProperty("scopeText")
    public String getScopeText() {
        return super.getScope() != null ? super.getScope().getText() : "未知";
    }

}
