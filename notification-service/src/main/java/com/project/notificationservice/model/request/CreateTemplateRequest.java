package com.project.notificationservice.model.request;

import com.project.notificationservice.utils.NotificationServiceUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Map;

@Data
public class CreateTemplateRequest {

    @NotBlank(message = "Name Field Is Required")
    private String name;

    private Map<String, String> templateVariables;

    @NotBlank(message = "Message Template Field Is Required")
    private String messageTemplate;

    public boolean validateTemplateVariable() {
        return NotificationServiceUtil.isObjectNotEmpty(templateVariables) && templateVariables.size() <= 20;
    }

}