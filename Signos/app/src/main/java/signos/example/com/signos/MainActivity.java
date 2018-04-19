package signos.example.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaSignos;
    private String[] signos = {"Áries",
    "Touro",
    "Gêmeos",
    "Câncer",
    "Leão",
    "Virgem",
    "Libra",
    "Escorpião",
    "Sagitário",
    "Capricórnio",
    "Aquário",
    "Peixes"};

    private String[] perfis={
            "Consegui o que achava que queria, até perdeu a graça.",
            "Eu quero mudar algumas coisas, mas não agora.",
            "Como é bom conversar com uma pessoa parecida comigo.",
            "Ontem foi o pior dia da minha vida, mas hoje está sendo o melhor.",
            "Para mim, a melhor coisa do mundo e me ter por perto.",
            "Se tudo estiver no lugar, eu nunca vou ficar irritado.",
            "Eu quero muito uma pizza, mas você pode escolher os sabores.",
            "E quem disse que isso não é da minha conta?",
            "Pela milésima vez, para de falar que eu exagero.",
            "Agora que tudo deu certo, teremos ótimos retornos.",
            "Dê tempo ao tempo! Sem pressão, por favor...",
            "Eu choro mesmo, o que tem isso?",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaSignos =(ListView) findViewById(R.id.listaView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );

        listaSignos.setAdapter(adaptador);

        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int codigoPosicao = i;
                Toast.makeText(getApplicationContext(),perfis[codigoPosicao],Toast.LENGTH_LONG ).show();
            }
        });

    }
}
