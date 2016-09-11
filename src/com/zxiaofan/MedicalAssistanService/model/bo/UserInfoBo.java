
package com.zxiaofan.MedicalAssistanService.model.bo;

import java.util.Date;

/**
 * @author yunhai(Default)
 *
 */

public class UserInfoBo {
    /**
     * @用户名
     */
    private String userName;

    /**
     * @密码
     */
    private String passWord; // transient

    /**
     * @用户类型(0医生,1普通用户)
     */
    private Integer userType = 1;

    /**
     * @移动电话
     */
    private String telePhone;

    /**
     * @固话
     */
    private String fixedPhone;

    /**
     * @家庭地址
     */
    private String address;

    /**
     * @邮编
     */
    private String postcode;

    /**
     * @邮箱
     */
    private String email;

    /**
     * @生日
     */
    private Date birthday;

    /**
     * @证件类型
     */
    private String documenTType;

    /**
     * @证件号
     */
    private String documentID;

    /**
     * @修改时间
     */
    private Date modifyTime;

    /**
     * @ 构造函数
     */
    public UserInfoBo() {
    }

    /**
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            用户名.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return 密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord
     *            密码.
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * @return 用户类型
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * @param userType
     *            用户类型.
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * @return 移动电话
     */
    public String getTelePhone() {
        return telePhone;
    }

    /**
     * @param telePhone
     *            移动电话.
     */
    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    /**
     * @return 固话
     */
    public String getFixedPhone() {
        return fixedPhone;
    }

    /**
     * @param fixedPhone
     *            固话.
     */
    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    /**
     * @return 家庭地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            家庭地址.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode
     *            邮编.
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            邮箱.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            生日.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return 证件类型
     */
    public String getDocumenTType() {
        return documenTType;
    }

    /**
     * @param documenTType
     *            证件类型.
     */
    public void setDocumenTType(String documenTType) {
        this.documenTType = documenTType;
    }

    /**
     * @return 证件号
     */
    public String getDocumentID() {
        return documentID;
    }

    /**
     * @param documentID
     *            证件号.
     */
    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    /**
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     *            修改时间.
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
