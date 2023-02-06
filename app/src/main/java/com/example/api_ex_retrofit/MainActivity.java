package com.example.api_ex_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv_display;
    String url = "https://jsonplaceholder.typicode.com/";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_display = findViewById(R.id.tv_display_data);

        tv_display.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        My_Api my_api = retrofit.create(My_Api.class);

        Call<List<Post_model>> call = my_api.getmodels();


        call.enqueue(new Callback<List<Post_model>>() {
            @Override
            public void onResponse(Call<List<Post_model>> call, Response<List<Post_model>> response) {
                List<Post_model> data = response.body();
                for (int i=0;i<data.size();i++){
                    tv_display.append(" SL No: "+data.get(i).getId()+" \nTitle : "+data.get(i).getTitle()+"\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<Post_model>> call, Throwable t) {

            }
        });


    }
}