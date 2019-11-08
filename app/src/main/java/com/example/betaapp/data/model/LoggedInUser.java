package com.example.betaapp.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private Integer intAsistenteID;
    private String displayName;
    private Boolean bitValido;
    private String vchMensaje;

    public LoggedInUser(Integer userId, String displayName, Boolean bitValido, String vchMensaje) {
        this.intAsistenteID = userId;
        this.displayName = displayName;
        this.bitValido  = bitValido;
        this.vchMensaje = vchMensaje;
    }

    public Integer getUserId() {
        return intAsistenteID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Boolean getBitValido() {
        return bitValido;
    }

    public String getVchMensaje() {
        return vchMensaje;
    }
}
