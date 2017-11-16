package br.com.a3passos.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IdadeCachorroActivity extends AppCompatActivity {

    private Button btConverter;
    private TextView txtResult;
    private EditText idade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idade_cachorro);

        btConverter = (Button) findViewById(R.id.btConverter);
        txtResult = (TextView) findViewById(R.id.lblResultado);
        idade = (EditText) findViewById(R.id.idade);


        btConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String digitado = String.valueOf(idade.getText());

                if(digitado.isEmpty()){
                    txtResult.setText("Idade invalida");
                    return;
                }

                int idadeHumano = Integer.parseInt(digitado) * 7;
                txtResult.setText(idadeHumano + " Anos");
            }
        });

    }
}
