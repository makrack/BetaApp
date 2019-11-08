package com.example.betaapp.data;

import android.widget.Toast;

import com.example.betaapp.data.model.LoggedInUser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private static final String SVC_URL = "http://10.0.2.2/Mexica/LoginService.svc/";

    public Result<LoggedInUser> login(String username, String password) {

        /*try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }

         */

        HttpPost request = new HttpPost(SVC_URL + "/json/login");
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        String not = new String(" ");
        try {
            // Build JSON string
            JSONStringer vehicle = new JSONStringer()
                    .object()
                    .key("DataValues")
                    .object()
                    .key("vchCorreo").value(username)
                    .key("vchContrasena").value(password)
                    .endObject()
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
                JSONObject loginData =  new JSONObject(new String(buffer)).getJSONObject("GetLogingResult");

                //JSONObject Data = new loginData.getJSONObject("GetLogingResult");
                //set the text of text view
                //tvEmployeeCode.setText("Code: " + employee.getString("EmployeeId"));
                //tvName.setText("Name: " + employee.getString("FirstName") + " " + employee.getString("LastName"));
                //tvAddress.setText("Address: " + employee.getString("Address"));
                //tvBloodGroup.setText("Blood Group: " + employee.getString("BloodGroup"));

                //show hide layout
                //linearLayoutError.setVisibility(View.GONE);
                //linearLayoutEmp.setVisibility(View.VISIBLE);

                LoggedInUser User =
                        new LoggedInUser(
                                loginData.getInt("intAsistenteID"),
                                loginData.getString("vchNombreCompleto"),
                                loginData.getBoolean("bitValido"),
                                loginData.getString("vchMensaje")
                        );
                return new Result.Success<>(User);
            }
            else {
                return null;
                //linearLayoutEmp.setVisibility(View.GONE);
                //linearLayoutError.setVisibility(View.VISIBLE);
            }



        }catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }

    }

    public void logout() {
        // TODO: revoke authentication
    }
}
