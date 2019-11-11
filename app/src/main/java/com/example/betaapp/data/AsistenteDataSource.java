package com.example.betaapp.data;

import android.widget.Toast;

import com.example.betaapp.data.model.EventosAsistente;
import com.example.betaapp.data.model.LoggedInUser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AsistenteDataSource {
    private static final String SVC_URL = "http://www.mexisoft.mx/WsRegistec/AsistenteService.svc/";

    public List<EventosAsistente> getEventosAsistente(Integer intAsistenteID) {


        HttpPost request = new HttpPost(SVC_URL + "/json/login");
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        String not = new String(" ");
        try {
            // Build JSON string
            JSONStringer vehicle = new JSONStringer()
                    .object()
                    .key("AsistenteID").value(intAsistenteID)
                    .endObject();

            StringEntity entity = new StringEntity(vehicle.toString());

            // Toast.makeText(this, vehicle.toString() + "\n", Toast.LENGTH_LONG).show() ;

            request.setEntity(entity);

            // Send request to WCF service
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpResponse response = httpClient.execute(request);

            HttpEntity entity2 = response.getEntity();

            //if entity contect lenght 0, means no employee exist in the system with these code
            if(entity2.getContentLength() != 0) {
                // stream reader object
                Reader employeeReader = new InputStreamReader(response.getEntity().getContent());
                //create a buffer to fill if from reader
                char[] buffer = new char[(int) response.getEntity().getContentLength()];
                //fill the buffer by the help of reader
                employeeReader.read(buffer);
                //close the reader streams
                employeeReader.close();

                //for the employee json object

                //JSONObject loginData =  new JSONObject(new String(buffer)).getJSONObject("GetEventosAsistenteResult");
                JSONObject loginData =  new JSONObject(new String(buffer));
                JSONArray arr = loginData.getJSONArray("GetEventosAsistenteResult");

                List<EventosAsistente> resultado = new ArrayList<EventosAsistente>();


                for (int i = 0; i < arr.length(); i++) {
                    JSONObject row = arr.getJSONObject(i);
                    EventosAsistente ev =
                            new EventosAsistente(row.getInt("intAsistenteID"), row.getInt("intRegistroID"), row.getString("vchNombreEvento"), row.getString("datFechaInicio"), row.getString("vchLugarEvento"));
                    resultado.add(ev);
                }





                return resultado;
            }
            else {
                return null;
                //linearLayoutEmp.setVisibility(View.GONE);
                //linearLayoutError.setVisibility(View.VISIBLE);
            }



        }catch (Exception e) {
            return null;
        }

    }


}
