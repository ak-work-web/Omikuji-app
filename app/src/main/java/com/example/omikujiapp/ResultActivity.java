package com.example.omikujiapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
private static final String KEY_OMIKUJI_NUMBER = "key_omikuji_number";
    /**
     *おみくじ結果画面のIntentを作成する
     *
     * @param context コンテキスト
     * @return
     */
    public static Intent createIntent(Context context, int omikujiNumber){
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(KEY_OMIKUJI_NUMBER, omikujiNumber);
        return  intent;
        }

        //おみくじ結果画像
        private ImageView resultImageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rsult);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultImageView = findViewById(R.id.result_image);

        //おみくじ番号取得
        int resultNum = getIntent().getIntExtra(KEY_OMIKUJI_NUMBER, -1);

        //おみくじ番号からリソースIDを取得する
        int resId;
        switch (resultNum) {
            case 0://大吉
                resId = R.drawable.omikuji_daikichi;
                break;
            case 1://中吉
                resId = R.drawable.omikuji_chuukichi;
                break;
            case 2://吉
                resId = R.drawable.omikuji_kichi;
                break;
            case 3://凶
                resId = R.drawable.omikuji_kyou;
                break;
            case 4://大凶
                resId = R.drawable.omikuji_daikyou;
                break;
            default: //その他
                resId = R.drawable.omikuji_daikyou;
                break;

        }
        //おみくじ結果を表示する
        resultImageView.setImageResource(resId);
    }
}