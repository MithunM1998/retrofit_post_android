package com.example.retrofit_post_andriod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    JsonPlaceholder jsonPlaceholder;
    EditText mtitle,mbody;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        mtitle=findViewById(R.id.enter_title);
        mbody=findViewById(R.id.enter_body);
        button=findViewById(R.id.post);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceholder=retrofit.create(JsonPlaceholder.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });


    }

    private  void createPost(){

        String title=mtitle.getText().toString();
        String body=mbody.getText().toString();

        Call<Post> call=jsonPlaceholder.createPost(title,body);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> postList=new ArrayList<>();
                postList.add(response.body());

                PostAdapter postAdapter=new PostAdapter(MainActivity.this,postList);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(postAdapter);

                Toast.makeText(MainActivity.this, response.code() + " Response", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}