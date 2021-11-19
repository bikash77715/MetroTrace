package com.hp.pav.demojune6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pav on 6/6/2017.
 */

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    TextView message;
    Button signup, login;
    String url = "http://silptech.com.np/phpscripts/loginRoutine.php";
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();

        sp = getSharedPreferences("State", MODE_PRIVATE);
        message = (TextView)findViewById(R.id.message);
        Boolean state = sp.getBoolean("state", false);

        if(state){
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
        }else{
            message.setText("state: "+state);
        }

        username = (EditText)findViewById(R.id.etusername);
        password = (EditText)findViewById(R.id.etpassword);
        login = (Button)findViewById(R.id.login);
        signup = (Button)findViewById(R.id.signup);
        progressDialog = new ProgressDialog(LoginActivity.this);
        requestQueue = Volley.newRequestQueue(LoginActivity.this);

        progressDialog.setMessage(" Please wait...");
        progressDialog.setIndeterminate(true);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();

                StringRequest srq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject obj1;
                        try {
                            obj1 = new JSONObject(response);
                            int success = obj1.getInt("success");

                            if (success == 1) {
                                progressDialog.dismiss();
                                SharedPreferences sp = getSharedPreferences("State", MODE_PRIVATE);
                                SharedPreferences.Editor sp_editor =  sp.edit();
                                sp_editor.putBoolean("state", true);

                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(i);
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, " Login failed.", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, " JSON exception error", Toast.LENGTH_LONG).show();

                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, " Connection lost...", Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> data = new HashMap<String, String>();
                        data.put("username", username.getText().toString());
                        data.put("password", password.getText().toString());

                        return data;
                    }
                };

                requestQueue.add(srq);
            }


        });

    }
}
