package com.jakkarin.back.respon;

public class UserResponData {
    private String userId;
    private String tokenId;

    public UserResponData(String userId ,String tokenId ) {
        this.tokenId = tokenId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
