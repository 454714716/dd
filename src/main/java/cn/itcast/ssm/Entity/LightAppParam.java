package cn.itcast.ssm.Entity;


import java.util.List;

public class LightAppParam extends PageVO{
    private boolean needPage = false;

    /**
     * 初始化类型 0-强制部署，1-可选部署，2-私有化部署
     */
    private Integer[] initializeType;

    /**
     * 可见场景 0-WEB 1-IOS 2-ANDROID
     */
    private Integer[] sceneType;

    /**
     * 1启用 2禁用 3-待上架
     */
    private Integer[] status;

    // 可见的企业范围Id
    private String scopeId;

    private List<String> inAppIds;

    /**
     * 不包含这些的appId
     */
    private List<String> notInAppIds;

    public boolean isNeedPage() {
        return needPage;
    }

    public void setNeedPage(boolean needPage) {
        this.needPage = needPage;
    }

    public Integer[] getInitializeType() {
        return initializeType;
    }

    public void setInitializeType(Integer[] initializeType) {
        this.initializeType = initializeType;
    }

    public Integer[] getSceneType() {
        return sceneType;
    }

    public void setSceneType(Integer[] sceneType) {
        this.sceneType = sceneType;
    }

    public Integer[] getStatus() {
        return status;
    }

    public void setStatus(Integer[] status) {
        this.status = status;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public List<String> getInAppIds() {
        return inAppIds;
    }

    public void setInAppIds(List<String> inAppIds) {
        this.inAppIds = inAppIds;
    }

    public List<String> getNotInAppIds() {
        return notInAppIds;
    }

    public void setNotInAppIds(List<String> notInAppIds) {
        this.notInAppIds = notInAppIds;
    }
}
