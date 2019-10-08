package domain.entity;


public class Member {
    /**
     * 主键ID
     */
    private String memberId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 生日
     */
    private String birthday;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}