package somdosbichos.example.com.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.caoId) ImageView cao;
    @BindView (R.id.gatoId) ImageView gato;
    @BindView(R.id.leaoId) ImageView leao;
    @BindView(R.id.macacoId) ImageView macaco;
    @BindView(R.id.ovelhaID) ImageView ovelha;
    @BindView(R.id.vacaId) ImageView vaca;



    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.caoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                playAudio();
                break;

            case R.id.gatoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                playAudio();
                break;

            case R.id.vacaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                playAudio();
                break;

            case R.id.leaoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                playAudio();
                break;
            case R.id.macacoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                playAudio();
                break;
            case R.id.ovelhaID:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                playAudio();
                break;

        }

    }

    private void playAudio() {
        if (mediaPlayer != null){
            mediaPlayer.start();
        }


    }
    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
