 package com.dachen.st.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LightAppMessage {

    @ApiModelProperty(value = "启用消息频道")
    private Boolean enable;

    @ApiModelProperty(value = "默认自动订阅")
    private Boolean autoSub;

    @ApiModelProperty(value = "允许取消订阅")
    private Boolean allowCancel;

    @ApiModelProperty(value = "折叠消息显示")
    private Boolean foldShow;

    @ApiModelProperty(value = "推送消息提醒")
    private Boolean pushRemind;

    public void init() {
        this.enable = false;
        this.autoSub = false;
        this.allowCancel = true;
        this.foldShow = true;
        this.pushRemind = true;
    }
}
