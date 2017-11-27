package br.com.a3passos.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class InputsActivity extends AppCompatActivity {
    private RadioGroup genero;
    private CheckBox cao,gato,coala;
    private Button bt;
    private TextView result,lindo_descricao;
    private SeekBar lindisse;

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
        lindo_descricao = (TextView) findViewById(R.id.lindo_descricao);
        lindisse = (SeekBar) findViewById(R.id.nivel_lindisse) ;

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


        lindisse.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i){
                    case 1:
                    lindo_descricao.setText("Demônio parido");
                    break;
                    case 2:
                        lindo_descricao.setText("Horrivel");
                        break;
                    case 3:
                        lindo_descricao.setText("Feioso");
                        break;
                    case 4:
                        lindo_descricao.setText("Coitado");
                        break;
                    case 5:
                        lindo_descricao.setText("+-");
                        break;
                    case 6:
                        lindo_descricao.setText("bonitinho");
                        break;
                    case 7:
                        lindo_descricao.setText("Guapo");
                        break;
                    case 8:
                        lindo_descricao.setText("Bonitão");
                        break;
                    case 9:
                        lindo_descricao.setText("Galo Cinza");
                        break;
                    default:
                        lindo_descricao.setText("Lllllllindoooo!");


                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }



}
