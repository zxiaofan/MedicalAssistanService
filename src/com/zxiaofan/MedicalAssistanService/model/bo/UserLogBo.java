
package com.zxiaofan.MedicalAssistanService.model.bo;

import java.util.Date;

/**
 * @author yunhai(Default)
 *
 */

public class UserLogBo {
    /**
     * @用户名
     */
    private String userName;

    /**
     * @上次登录时间
     */
    private Date lastLoginTime;

    /**
     * @登录IP
     */
    private String loginIP;

    /**
     * @搜索内容
     */
    private String searchRecord;

    /**
     * @修改密码时间
     */
    private String changePwdTime;

    /**
     * @ 构造函数
     */
    public UserLogBo() {
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
     * @return 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     *            上次登录时间.
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return 登录IP
     */
    public String getLoginIP() {
        return loginIP;
    }

    /**
     * @param loginIP
     *            登录IP.
     */
    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    /**
     * @return 搜索内容
     */
    public String getSearchRecord() {
        return searchRecord;
    }

    /**
     * @param searchRecord
     *            搜索内容.
     */
    public void setSearchRecord(String searchRecord) {
        this.searchRecord = searchRecord;
    }

    /**
     * @return 修改密码时间
     */
    public String getChangePwdTime() {
        return changePwdTime;
    }

    /**
     * @param changePwdTime
     *            修改密码时间.
     */
    public void setChangePwdTime(String changePwdTime) {
        this.changePwdTime = changePwdTime;
    }
}
