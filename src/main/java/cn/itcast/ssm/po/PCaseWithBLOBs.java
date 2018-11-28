package cn.itcast.ssm.po;

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

    @Override
    public String toString() {
        return super.toString()+"==PCaseWithBLOBs{" +
                "description='" + description + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}