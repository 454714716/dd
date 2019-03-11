package com.dachen.st.po;

import lombok.Data;

@Data
public class PCaseWithBLOBs extends PCase {
    private String description;

    private String message;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}