package com.example.betaapp.ui.Asistente;
import androidx.annotation.Nullable;
import com.example.betaapp.data.model.EventosAsistente;

import java.util.List;

public class AsistenteResult {
    @Nullable
    private List<EventosAsistente> success;


    AsistenteResult(@Nullable List<EventosAsistente> success) {
        this.success = success;
    }

    List<EventosAsistente> getEventos() {
        return success;
    }
}
