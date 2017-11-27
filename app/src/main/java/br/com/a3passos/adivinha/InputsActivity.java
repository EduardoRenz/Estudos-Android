package br.com.a3passos.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class InputsActivity extends AppCompatActivity {
    private RadioGroup genero;
    private CheckBox cao,gato,coala;
    private Button bt;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputs);
        genero = (RadioGroup) findViewById(R.id.radios);
        cao = (CheckBox) findViewById(R.id.check_cachorro);
        gato = (CheckBox) findViewById(R.id.check_gato);
        coala = (CheckBox) findViewById(R.id.check_coala);
        bt = (Button) findViewById(R.id.bt_inputs);
        result = (TextView) findViewById(R.id.result);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("CAO:" + cao.isChecked() + "\n" + "GATO:" + gato.isChecked() + "\n Coala:"+ coala.isChecked() + "\n"
                );

                int radioButtonID = genero.getCheckedRadioButtonId();

                if(radioButtonID != -1){
                    View radioButton = genero.findViewById(radioButtonID);
                    int idx = genero.indexOfChild(radioButton);
                    RadioButton r = (RadioButton)  genero.getChildAt(idx);
                    String selectedtext = r.getText().toString();
                    result.setText(result.getText() + "\n" + selectedtext);
                }



            }
        });

    }



}
