package br.edu.fateczl.adivinhacao20232n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnJogar;
    private TextView tvResposta;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER_HORIZONTAL);
        btnJogar = findViewById(R.id.btnJogar);
        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setGravity(Gravity.CENTER_HORIZONTAL);

        num = (int)((Math.random() * 100) + 1);
        Log.i("num", String.valueOf(num));
        btnJogar.setOnClickListener(click -> jogo());
    }

    private void jogo() {
        int valor = Integer.parseInt(etNumero.getText().toString());
        Log.i("valor", String.valueOf(valor));
        if (valor > num) {
            tvResposta.setText(R.string.menor);
        } else if (valor < num) {
            tvResposta.setText(R.string.maior);
        } else {
            trocaTela();
        }
    }

    private void trocaTela() {
        Bundle b = new Bundle();
        b.putInt("num", num);
        Intent i = new Intent(this, ResActivity.class);
        i.putExtras(b);
        this.startActivity(i);
        this.finish();
    }
}