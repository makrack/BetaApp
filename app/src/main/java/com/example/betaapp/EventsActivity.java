package com.example.betaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.betaapp.data.Result;
import com.example.betaapp.ui.Asistente.AsistenteViewModel;
import com.example.betaapp.data.model.EventosAsistente;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "ListView Title 1", "ListView Title 2", "ListView Title 3", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
    };


    int[] listviewImage = new int[]{
            R.drawable.conituar, R.drawable.conituar, R.drawable.conituar, R.drawable.conituar,
            R.drawable.conituar, R.drawable.conituar, R.drawable.conituar, R.drawable.conituar,
    };

    String[] listviewShortDescription = new String[]{
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
    };
    private AsistenteViewModel AsistenteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        AsistenteViewModel VM = new AsistenteViewModel();
        List<EventosAsistente> listEventos = VM.getEventoAsistente(1);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < listEventos.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            EventosAsistente eve = listEventos.get(i);

           hm.put("listview_title", eve.vchNombreEvento());
            hm.put("listview_discription", eve.datFechaInicio() + ' ' + eve.vchLugarEvento());
            hm.put("listview_image", Integer.toString(R.drawable.smalllogo));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);


    }
}
