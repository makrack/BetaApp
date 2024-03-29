package com.example.betaapp.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer error;

    @Nullable
    private String Serror;



    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable String serror) {
        this.Serror = serror;
    }

    LoginResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }

    @Nullable
    String getStringError() {
        return Serror;
    }
}
