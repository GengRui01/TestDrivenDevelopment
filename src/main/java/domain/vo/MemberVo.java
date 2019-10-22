package domain.vo;

import domain.entity.Member;
import org.springframework.beans.BeanUtils;

/**
 * Description:
 *
 * @ClassName: MemberVo
 * @Author: GengRui
 * @Date: 2019/10/17 15:07
 */
public class MemberVo {
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
    private String genderName;

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
        this.username = username;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public MemberVo(Member member) {
        BeanUtils.copyProperties(member, this);
    }

    public MemberVo() {
    }
}
