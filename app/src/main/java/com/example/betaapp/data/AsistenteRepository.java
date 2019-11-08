package com.example.betaapp.data;

import com.example.betaapp.data.model.EventosAsistente;

import java.util.List;

public class AsistenteRepository {
    private static volatile AsistenteRepository instance;

    private AsistenteDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private EventosAsistente user = null;

    // private constructor : singleton access
    private AsistenteRepository(AsistenteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static AsistenteRepository getInstance(AsistenteDataSource dataSource) {
        if (instance == null) {
            instance = new AsistenteRepository(dataSource);
        }
        return instance;
    }



    private void setLoggedInUser(EventosAsistente user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<List<EventosAsistente>> getEventosAsistente(Integer intAsistenteID) {
        // handle login
        Result<List<EventosAsistente>> result = dataSource.getEventosAsistente(intAsistenteID);
        //if (result instanceof Result.Success) {
        //    setLoggedInUser(((Result.Success<EventosAsistente>) result).getData());
        //}
        return result;
    }


}
