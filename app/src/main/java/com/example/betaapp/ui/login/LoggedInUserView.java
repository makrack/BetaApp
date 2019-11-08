package com.example.betaapp.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI
    private Integer intAsistenteID;

    LoggedInUserView(String displayName, Integer intAsistenteID) {
        this.displayName = displayName;
        this.intAsistenteID = intAsistenteID;
    }

    //LoggedInUserView(Integer intAsistenteID) {
    //   this.intAsistenteID = intAsistenteID;
    //}

    String getDisplayName() {
        return displayName;
    }
    Integer getintAsistenteID() {
        return intAsistenteID;
    }
}
