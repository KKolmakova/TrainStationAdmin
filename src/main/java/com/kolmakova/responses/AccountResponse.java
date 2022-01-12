package com.kolmakova.responses;

public class AccountResponse {
    private boolean userAlreadyExists;

    public AccountResponse() {
    }

    public AccountResponse(boolean userAlreadyExists) {
        this.userAlreadyExists = userAlreadyExists;
    }

    public boolean isUserAlreadyExists() {
        return userAlreadyExists;
    }

    public void setUserAlreadyExists(boolean userAlreadyExists) {
        this.userAlreadyExists = userAlreadyExists;
    }

}
