package educodedev.ejercicio01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView lblDistanciaSecond;
    TextView lblResultadoSecond;
    Button btnEnviarSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        inicializarVistas();

        String distancia = "";
        String unidadDestino = "";
        int resultado = 0;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {


            distancia = bundle.getString(getString(R.string.distancia));
            unidadDestino = bundle.getString(getString(R.string.destino));
            lblDistanciaSecond.setText(distancia);


            if (unidadDestino.equalsIgnoreCase(getString(R.string.vueltas_de_nube_voladora))) {

                resultado = Integer.parseInt(distancia) / 50;
                lblResultadoSecond.setText(String.valueOf(resultado));
            } else if (unidadDestino.equalsIgnoreCase(getString(R.string.saltos_instant_neos))) {

                resultado = Integer.parseInt(distancia) / 10000;
                lblResultadoSecond.setText(String.valueOf(resultado));

            } else if (unidadDestino.equalsIgnoreCase(getString(R.string.zenkai_metros))) {

                resultado = Integer.parseInt(distancia) * 1000;
                lblResultadoSecond.setText(String.valueOf(resultado));

            }

        }

        btnEnviarSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putString(getString(R.string.resultado), lblResultadoSecond.getText().toString());
                intent2.putExtras(bundle2);
                setResult(RESULT_OK, intent2);
                finish();
            }
        });


    }

    private void inicializarVistas() {

        lblDistanciaSecond = findViewById(R.id.lblDistanciaSecond);
        lblResultadoSecond = findViewById(R.id.lblResultadoSecond);
        btnEnviarSecond = findViewById(R.id.btnEnviarSecond);


    }
}