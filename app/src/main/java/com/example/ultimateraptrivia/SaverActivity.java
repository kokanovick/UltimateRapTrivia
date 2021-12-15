package com.example.ultimateraptrivia;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SaverActivity extends AppCompatActivity{

    private boolean saved = false;

    private Button btnYes;
    private Button btnNo;

    private TextView tvHighscore;

    private long backPressTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saver);

        tvHighscore = findViewById(R.id.tvTotalScore);
        tvHighscore.setText("UKUPAN REZULTAT: " + getIntent().getIntExtra("EXTRA_SCORE", 0));

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(v -> {
            saved = true;
            moveToFinalScreen();
        });
        btnNo.setOnClickListener(v -> moveToFinalScreen());
    }


    private void moveToFinalScreen(){
        Intent intent = new Intent(this, FinalScreen.class);
        Bundle total = getIntent().getExtras();
        if(total != null){
            intent.putExtras(total);
        }
        intent.putExtra("BOOLEAN", saved);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if(backPressTime + 2000 > System.currentTimeMillis()){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Pritisnite opet ukoliko želite izaći.", Toast.LENGTH_SHORT).show();
        }
        backPressTime = System.currentTimeMillis();
    }
}