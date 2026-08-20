package com.example.btvn_b9;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private EditText edtNote;
    private Button btnAdd;
    private RecyclerView recyclerView;

    private NoteDatabase database;
    private NoteAdapter adapter;

    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNote = findViewById(R.id.edtNote);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        database = NoteDatabase.getInstance(this);

        executorService = Executors.newSingleThreadExecutor();

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        adapter = new NoteAdapter(new ArrayList<>());

        recyclerView.setAdapter(adapter);

        loadNotes();

        btnAdd.setOnClickListener(v -> {

            String content = edtNote.getText()
                    .toString()
                    .trim();

            if (content.isEmpty()) {

                Toast.makeText(
                        MainActivity.this,
                        "Vui lòng nhập ghi chú",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            Note note = new Note(content);

            executorService.execute(() -> {

                database.noteDao().insert(note);

                List<Note> noteList =
                        database.noteDao().getAllNotes();

                runOnUiThread(() -> {

                    adapter.updateData(noteList);

                    edtNote.setText("");

                    Toast.makeText(
                            MainActivity.this,
                            "Đã thêm ghi chú",
                            Toast.LENGTH_SHORT
                    ).show();
                });
            });
        });
    }

    private void loadNotes() {

        executorService.execute(() -> {

            List<Note> noteList =
                    database.noteDao().getAllNotes();

            runOnUiThread(() -> {
                adapter.updateData(noteList);
            });
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (executorService != null) {
            executorService.shutdown();
        }
    }
}