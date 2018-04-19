package radiobutton.example.com.radiobutton;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonEscolhido;
    private Button botaoEscolher;
    private TextView textoExibicao;
    private ToggleButton toggleButton;
    private TextView textView;

    private Button botaoTocar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoEscolher = (Button) findViewById(R.id.botaoId);
        textoExibicao = (TextView) findViewById(R.id.textoId);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonId);
        textView = (TextView) findViewById(R.id.textoNovoId);


        botaoEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                if (idRadioButtonEscolhido > 0){
                    radioButtonEscolhido = (RadioButton) findViewById(idRadioButtonEscolhido);
                    textoExibicao.setText(radioButtonEscolhido.getText());
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                textView.setText("");
                if (b){
                    textView.setText("Mostrar...");
                }
            }
        });

        botaoTocar = (Button) findViewById(R.id.tocarId);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    pausarMusica();
                }else{
                    tocarMusica();
                }
            }
        });
    }
    private void tocarMusica(){

        if(mediaPlayer!=null){
            mediaPlayer.start();
            botaoTocar.setText("Pausar");
        }
    }
    private void pausarMusica(){
        if(mediaPlayer!=null){
            mediaPlayer.pause();
            botaoTocar.setText("Tocar");
        }
    }

}
