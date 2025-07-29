package com.example.omikujiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //おみくじ結果の数
    public static final int OMIKUJI_RESULT_SIZE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                タップ処理
//                TODO:乱数を生成する
                Random random = new Random();
                int omikujiNumber = random.nextInt(OMIKUJI_RESULT_SIZE);//0~4の乱数生成する
//                TODO:おみくじ結果画面に遷移する
//                Intent intent = new Intent(MainActivity.this, RsultActivity.class);
                Intent intent = ResultActivity.createIntent(MainActivity.this, omikujiNumber);
                startActivity(intent);


            }
        });
    }
}