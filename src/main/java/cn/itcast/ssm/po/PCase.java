package cn.itcast.ssm.po;

public class PCase {
    private Integer id;

    private Integer userId;

    private Integer checkInId;

    private Integer patientId;

    private String patientName;

    private Short sex;

    private Long birthday;

    private String phone;

    private String hospital;

    private String recordNum;

    private Long lastCureTime;

    private String diseaseId;

    @Override
    public String toString() {
        return "PCase{" +
                "id=" + id +
                ", userId=" + userId +
                ", checkInId=" + checkInId +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", hospital='" + hospital + '\'' +
                ", recordNum='" + recordNum + '\'' +
                ", lastCureTime=" + lastCureTime +
                ", diseaseId='" + diseaseId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum == null ? null : recordNum.trim();
    }

    public Long getLastCureTime() {
        return lastCureTime;
    }

    public void setLastCureTime(Long lastCureTime) {
        this.lastCureTime = lastCureTime;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId == null ? null : diseaseId.trim();
    }

}