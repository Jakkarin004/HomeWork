package com.jakkarin.back.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="sso_user_test",catalog="ssotest") //name="ssodev",catalog="sso_user_test" ชื่อตารางของเรา และของตัวหลัก
public class MainEntity {
    private String ssoType;
    private String systemId;
    private String systemName;
    private String systemTransactions;
    private String systemPrivileges;
    private String systemUserGroup;
    private String systemLocationGroup;
    private String userId;
    private String userFullName;
    private String userRdOfficeCode;
    private String userOfficeCode;
    private String clientLocation;
    private String locationMachineNumber;
    private String tokenId;
    private Date requestDate;

    public MainEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MainEntity(String ssoType, String systemId, String systemName,
                      String systemPrivileges,
                      String systemLocationGroup, String systemTransactions,
                      String systemUserGroup, String userId, String userFullName,
                      String userRdOfficeCode, String userOfficeCode, String clientLocation,
                      String locationMachineNumber, String tokenId, Date requestDate) {
        this.ssoType = ssoType;
        this.systemId = systemId;
        this.systemName = systemName;
        this.systemPrivileges = systemPrivileges;
        this.systemLocationGroup = systemLocationGroup;
        this.systemTransactions = systemTransactions;
        this.systemUserGroup = systemUserGroup;
        this.userId = userId;
        this.userFullName = userFullName;
        this.userRdOfficeCode = userRdOfficeCode;
        this.userOfficeCode = userOfficeCode;
        this.clientLocation = clientLocation;
        this.locationMachineNumber = locationMachineNumber;
        this.tokenId = tokenId;
        this.requestDate = requestDate;
    }

    @Column(name = "ssotype")
    public String getSsoType() {
        return ssoType;
    }

    public void setSsoType(String ssoType) {
        this.ssoType = ssoType;
    }

    @Column(name = "systemid")
    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    @Column(name = "systemname")
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Column(name = "systemtransactions")
    public String getSystemTransactions() {
        return systemTransactions;
    }

    public void setSystemTransactions(String systemTransactions) {
        this.systemTransactions = systemTransactions;
    }

    @Column(name = "systemprivileges")
    public String getSystemPrivileges() {
        return systemPrivileges;
    }

    public void setSystemPrivileges(String systemPrivileges) {
        this.systemPrivileges = systemPrivileges;
    }

    @Column(name = "systemusergroup")
    public String getSystemUserGroup() {
        return systemUserGroup;
    }

    public void setSystemUserGroup(String systemUserGroup) {
        this.systemUserGroup = systemUserGroup;
    }

    @Column(name = "systemlocationgroup")
    public String getSystemLocationGroup() {
        return systemLocationGroup;
    }

    public void setSystemLocationGroup(String systemLocationGroup) {
        this.systemLocationGroup = systemLocationGroup;
    }

    @Column(name = "userid")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "userfullname")
    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    @Column(name = "userrdofficecode")
    public String getUserRdOfficeCode() {
        return userRdOfficeCode;
    }

    public void setUserRdOfficeCode(String userRdOfficeCode) {
        this.userRdOfficeCode = userRdOfficeCode;
    }

    @Column(name = "userofficecode")
    public String getUserOfficeCode() {
        return userOfficeCode;
    }

    public void setUserOfficeCode(String userOfficeCode) {
        this.userOfficeCode = userOfficeCode;
    }

    @Column(name = "clientlocation")
    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    @Column(name = "locationmachinenumber")
    public String getLocationMachineNumber() {
        return locationMachineNumber;
    }

    public void setLocationMachineNumber(String locationMachineNumber) {
        this.locationMachineNumber = locationMachineNumber;
    }

    @Column(name = "tokenid")
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Id
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
