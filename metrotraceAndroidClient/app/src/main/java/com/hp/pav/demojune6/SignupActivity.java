package com.hp.pav.demojune6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class SignupActivity extends AppCompatActivity {

    EditText username, password;
    Button signup;
    String url = "http://silptech.com.np/phpscripts/registerRoutine.php";
    RequestQueue requestQueue;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    @Override
    protected void onStart() {
        super.onStart();

        username = (EditText)findViewById(R.id.etusername);
        password = (EditText)findViewById(R.id.etpassword);
        signup = (Button)findViewById(R.id.signup);
        requestQueue = Volley.newRequestQueue(SignupActivity.this);

        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setMessage("Register in progress...");
        progressDialog.setIndeterminate(true);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();

                StringRequest srq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj1 = new JSONObject(response);
                            int success = obj1.getInt("success");


                            if(success == 1){
                                progressDialog.dismiss();
                                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(i);
                            }else{
                                progressDialog.dismiss();
                                Toast.makeText(SignupActivity.this," Registeration failed. Please use a unique name with letters and numbers.", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(SignupActivity.this, " JSON exception caught", Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(SignupActivity.this, " volley error. No connection to server.", Toast.LENGTH_LONG).show();

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String>myboundedData = new HashMap<String, String>();

                        myboundedData.put("username", username.getText().toString());
                        myboundedData.put("password", password.getText().toString());

                        return myboundedData;
                    }
                };

                requestQueue.add(srq);

            }
        });
    }
}
