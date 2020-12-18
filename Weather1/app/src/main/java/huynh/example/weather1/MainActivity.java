package huynh.example.weather1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText edtCity;
    Button Ok;
    TextView txtCity,txtCountry,txtTemp,txtStatus,txtHumidity,txtCloud,txtWind,txtDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = edtCity.getText().toString();
                GetWeatherData(City);
            }
        });

    }

    public  void GetWeatherData(String data){
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String url = "https://api.openweathermap.org/data/2.5/weather?q="+data+"&units=metric&appid=444a59a1d25fe586945b880dcc3b7c6b";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String Day = jsonObject.getString("dt");
                                String name = jsonObject.getString("name");
                                txtCity.setText("City : " + name);

                                long lg = Long.valueOf(Day);
                                Date date = new Date(lg*1000);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE YYYY-MM-dd");
                                String DDay = simpleDateFormat.format(date);
                                txtDay.setText(DDay);

                                JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
                                JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
                                String status = jsonObjectWeather.getString("main");
                                txtStatus.setText(status);

                                JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                                String nhietdo = jsonObjectMain.getString("temp");
                                String doam = jsonObjectMain.getString("humidity");

                                Double a = Double.valueOf(nhietdo);
                                String nhietdo2 = String.valueOf(a.intValue());

                                txtTemp.setText(nhietdo2+ "°C");
                                txtHumidity.setText(doam+"%");

                                JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                                String gio = jsonObjectWind.getString("speed");
                                txtWind.setText(gio+"m/s");

                                JSONObject jsonObjectClouds = jsonObject.getJSONObject("clouds");
                                String may = jsonObjectClouds.getString("all");
                                txtCloud.setText(may);

                                JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
                                String country = jsonObjectSys.getString("country");
                                txtCountry.setText("Country : " + country);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("AAA","loi");
                        }
                    }
            );
            requestQueue.add(stringRequest);
    }

    private void Anhxa(){
        edtCity = (EditText)findViewById(R.id.editSearch);
        Ok = (Button)findViewById(R.id.buttonSearch);
        txtCity = (TextView)findViewById(R.id.idcity);
        txtCountry = (TextView)findViewById(R.id.idCountry);
        txtTemp = (TextView)findViewById(R.id.idNhietdo);
        txtStatus = (TextView)findViewById(R.id.idTrangthai);
        txtHumidity = (TextView)findViewById(R.id.idDoam);
        txtCloud = (TextView)findViewById(R.id.idMay);
        txtWind = (TextView)findViewById(R.id.idGio);
        txtDay = (TextView)findViewById(R.id.idNgaythang);

    }
}
