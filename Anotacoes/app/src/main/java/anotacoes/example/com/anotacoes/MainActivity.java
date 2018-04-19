package anotacoes.example.com.anotacoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText texto;
    private Button botao;
    private static final String NOME_ARQUIVO ="arquivo_anotacao.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.anotacoesId);
        botao = (Button) findViewById(R.id.botaoSalvarId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = texto.getText().toString();
                gravarNoArquivo(textoDigitado);
                Toast.makeText(MainActivity.this, "Anotacao Salva com Sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        if (lerArquivo()!=null){
            texto.setText(lerArquivo());
        }
    }

    private void gravarNoArquivo(String texto) {

        try{

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(NOME_ARQUIVO, Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();

        }catch (IOException e){
            Log.v("MainActivity", e.toString());

        }


    }

    private String lerArquivo (){

        String resultado = "";
        try{

            InputStream arquivo = openFileInput(NOME_ARQUIVO);
                    if(arquivo != null){

                        InputStreamReader inputStreamReader = new InputStreamReader(arquivo);
                        //gerar buffer

                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String linhasArquivo = "";
                        while ((linhasArquivo = bufferedReader.readLine()) !=null){
                            resultado += linhasArquivo;
                        }
                        arquivo.close();

                    }


        }catch (IOException e){

            Log.v("MainActivity", e.toString());
        }

        return resultado;
    }
}
