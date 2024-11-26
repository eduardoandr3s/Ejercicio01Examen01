package educodedev.ejercicio01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtDistancia, txtUnidadDestino;
    Button btnEnviarMain;
    TextView lblResultadoMain;
    private ActivityResultLauncher<Intent> launcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK) {
                    if (o.getData() != null) {
                        Bundle bundle = o.getData().getExtras();
                        String resultadoFinal = bundle.getString(getString(R.string.resultado));
                        lblResultadoMain.setText(resultadoFinal);
                    }
                }
            }
        });



        btnEnviarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String distancia = txtDistancia.getText().toString();
                String unidadDestino = txtUnidadDestino.getText().toString();


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(getString(R.string.distancia), distancia);
                bundle.putString(getString(R.string.destino), unidadDestino);
                intent.putExtras(bundle);
               // startActivity(intent);
                launcher.launch(intent);

            }
        });
    }

    private void inicializarVistas() {

        txtDistancia = findViewById(R.id.txtDistanciaMain);
        txtUnidadDestino = findViewById(R.id.txtUnidadDestinoMain);
       btnEnviarMain  = findViewById(R.id.btnEnviarMain);
       lblResultadoMain = findViewById(R.id.lblResultadoMain);



    }
}