package cn.itcast.ssm.Entity;

import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Transient;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Data
@Entity(value= CompanyApp.COLLECTION_NAME, noClassnameStored = true)
public class CompanyApp implements Serializable {

    /**
     * mongondb中集合的名字
     * @author GengChao
     */
    @Transient
    public static final String COLLECTION_NAME="d_com_app";

    private static final long serialVersionUID = -1118068463732951718L;


    @Id
    private String id;

    /**appId*/
    private String appId;   //编号 自动生成4位字符串 0001,0002...

    /** 秘钥 */
    private String secret;

    /** 轻应用的名称 **/
    @Indexed
    private String drugCompanyId;

    /** 启用和禁用 */
    @Indexed
    private int status;   //1启用 2禁用

    /** 排序权重 **/
    private Integer weight;

    /** 可以使用的Role
     * {@link  }
     * -1-表示都不可以访问，0-其他非角色人员，1001-医药代表，1002-市场人员，103-部门主管，102-系统管理员，101-超级管理员
     * p1,p2,...
     * */
//	private CanUseRole roles = new CanUseRole();
    @Deprecated
    private String roles;

    /**
     *
     */
    private List<String> role;

    /** 创建人 **/
    private Integer creator;
    /** 创建时间 */
    private Long creatorDate;

    /** 更新人 **/
    private Integer updator;
    /** 更新时间 **/
    private Long updatorDate;

    /**
     * 应用的消息通道
     */
    private LightAppMessage message;

    /**
     * 应用的部署位置
     * 对于药企圈来说就是子系统目前使用到有如下四个值：MINE，WORKSPACE，WORKSPACE-WEB，OTHER
     */
    @Transient
    private List<String> location;

    @Transient
    private String name;

    /**
     * 是否已经硬删除了
     */
    @Transient
    private Boolean deleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDrugCompanyId() {
        return drugCompanyId;
    }

    public void setDrugCompanyId(String drugCompanyId) {
        this.drugCompanyId = drugCompanyId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Long getCreatorDate() {
        return creatorDate;
    }

    public void setCreatorDate(Long creatorDate) {
        this.creatorDate = creatorDate;
    }

    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    public Long getUpdatorDate() {
        return updatorDate;
    }

    public void setUpdatorDate(Long updatorDate) {
        this.updatorDate = updatorDate;
    }

    @Deprecated
    public String getRoles() {
        if(role==null || role.size()<1) return "";
        return String.join(",",role);
//		return roles;
    }

    @Deprecated
    public void setRoles(String roles) {
        this.roles = roles;
        if(roles!=null) this.role = Arrays.asList(roles.split(","));
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public LightAppMessage getMessage() {
        return message;
    }

    public void setMessage(LightAppMessage message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CompanyApp{" +
                "id='" + id + '\'' +
                ", appId='" + appId + '\'' +
                ", secret='" + secret + '\'' +
                ", drugCompanyId='" + drugCompanyId + '\'' +
                ", status=" + status +
                ", weight=" + weight +
                ", roles='" + roles + '\'' +
                ", role=" + role +
                ", creator=" + creator +
                ", creatorDate=" + creatorDate +
                ", updator=" + updator +
                ", updatorDate=" + updatorDate +
                ", message=" + message +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}