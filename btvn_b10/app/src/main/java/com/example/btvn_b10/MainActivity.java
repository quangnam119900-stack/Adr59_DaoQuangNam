package com.example.btvn_b10;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        postList = new ArrayList<>();

        postAdapter = new PostAdapter(postList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

        getPosts();
    }

    private void getPosts() {

        ApiService apiService = RetrofitClient.getApiService();

        Call<List<Post>> call = apiService.getPosts();

        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(
                    Call<List<Post>> call,
                    Response<List<Post>> response) {

                if (response.isSuccessful() && response.body() != null) {

                    postList.clear();
                    postList.addAll(response.body());

                    postAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Không lấy được dữ liệu",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

            @Override
            public void onFailure(
                    Call<List<Post>> call,
                    Throwable t) {

                Toast.makeText(
                        MainActivity.this,
                        "Lỗi: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}