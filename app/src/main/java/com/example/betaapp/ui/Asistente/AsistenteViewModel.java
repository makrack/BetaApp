package com.example.betaapp.ui.Asistente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.betaapp.data.AsistenteRepository;
import com.example.betaapp.data.Result;
import com.example.betaapp.data.model.EventosAsistente;
import com.example.betaapp.R;

import java.util.List;


public class AsistenteViewModel extends ViewModel{

    private MutableLiveData<List<EventosAsistente>> EventosResult = new MutableLiveData<>();

    private AsistenteRepository asistenteRepository;


    public  List<EventosAsistente> getEventoAsistente(Integer intAsistenteID) {
        // can be launched in a separate asynchronous job
        AsistenteRepository rep = new AsistenteRepository();

        List<EventosAsistente> result = rep.getEventosAsistente(intAsistenteID);
        return result;


        /*
        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            if(data.getBitValido()) {

                loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName(), data.getUserId())));
                // loginResult.setValue(new LoginResult(new LoggedInUserView(data.getUserId())));
            }
            else
            {
                loginResult.setValue(new LoginResult(data.getVchMensaje()));
            }
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
        */

    }

}
