package com.example.betaapp.data.model;

public class EventosAsistente {
    private Integer intAsistenteID;
    private Integer intRegistroID;
    private String vchNombreEvento;
    private String datFechaInicio;
    private String vchLugarEvento;

    public EventosAsistente(Integer intAsistenteID, Integer intRegistroID,  String vchNombreEvento, String datFechaInicio, String vchLugarEvento) {
        this.intAsistenteID = intAsistenteID;
        this.intRegistroID = intRegistroID;
        this.vchNombreEvento  = vchNombreEvento;
        this.datFechaInicio = datFechaInicio;
        this.vchLugarEvento = vchLugarEvento;
    }

    public Integer intAsistenteID() {
        return intAsistenteID;
    }

    public Integer intRegistroID() {
        return intRegistroID;
    }

    public String vchNombreEvento() {
        return vchNombreEvento;
    }

    public String datFechaInicio() {
        return datFechaInicio;
    }

    public String vchLugarEvento() {
        return vchLugarEvento;
    }

}
