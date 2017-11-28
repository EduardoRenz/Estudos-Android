package br.com.a3passos.adivinha;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class InputsActivity extends AppCompatActivity {
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";
    private RadioGroup genero;
    private CheckBox cao,gato,coala;
    private Button bt;
    private TextView result,lindo_descricao;
    private SeekBar lindisse;
    private ToggleButton chave;
    private EditText editor;
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
        chave = (ToggleButton) findViewById(R.id.chave);
        editor = (EditText) findViewById(R.id.escrita);
        getPreferencias();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                result.setText("CAO:" + cao.isChecked() + "\n" + "GATO:" + gato.isChecked() + "\n Coala:"+ coala.isChecked() + "\n");
                int radioButtonID = genero.getCheckedRadioButtonId();
                if(radioButtonID != -1){
                    View radioButton = genero.findViewById(radioButtonID);
                    int idx = genero.indexOfChild(radioButton);
                    RadioButton r = (RadioButton)  genero.getChildAt(idx);
                    String selectedtext = r.getText().toString();
                    result.setText(result.getText() + "\n" + selectedtext);
                }


                salvarPreferencias();

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

        chave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    editor.setEnabled(true);
                }
                else{
                    editor.setEnabled(false);
                }
                Log.d("checker", String.valueOf(b));
            }
        });
    }


    private  void salvarPreferencias(){
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("cao",cao.isChecked());
        editor.putBoolean("gato",gato.isChecked());
        editor.putBoolean("coala",coala.isChecked());


        int radioButtonID = genero.getCheckedRadioButtonId();
        if(radioButtonID != -1){
            editor.putInt("genero",radioButtonID);
        }

        editor.putInt("lindisse",lindisse.getProgress());
        editor.commit();
        Log.d("prefs","salvas");

    }
    private void getPreferencias(){
        Log.d("PREFs","Tentando achar preferencias");
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("cao")){
            Log.d("cao", String.valueOf(sharedPreferences.getBoolean("cao",true)));
            cao.setChecked(sharedPreferences.getBoolean("cao",true));
        }
        if(sharedPreferences.contains("gato")){
            gato.setChecked(sharedPreferences.getBoolean("gato",true));
        }
        if(sharedPreferences.contains("coala")){
            coala.setChecked(sharedPreferences.getBoolean("coala",true));
        }


        if(sharedPreferences.contains("genero")){
            View radioButton = genero.findViewById(sharedPreferences.getInt("genero",0));
            int idx = genero.indexOfChild(radioButton);
            RadioButton r = (RadioButton)  genero.getChildAt(idx);
            Log.d("ID DE GENERO", String.valueOf(r.getId()));
            r.setChecked(true);
        }


        if(sharedPreferences.contains("lindisse")){
            lindisse.setProgress(sharedPreferences.getInt("lindisse",1));
        }


    }

}
