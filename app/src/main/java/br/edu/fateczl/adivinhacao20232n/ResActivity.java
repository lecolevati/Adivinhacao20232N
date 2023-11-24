package br.edu.fateczl.adivinhacao20232n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVoltar;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        tvResultado = findViewById(R.id.tvResultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        int num = b.getInt("num");

        Toast.makeText(this, R.string.parabens, Toast.LENGTH_LONG).show();

        tvResultado.setText(getString(R.string.resultado) + " " + num);
        btnVoltar.setOnClickListener(click -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}