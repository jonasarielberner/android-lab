package checkbox.example.com.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botao;

    private CheckBox checkBoxCao;
    private CheckBox checkBoxGato;
    private CheckBox checkBoxPapagaio;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxCao=(CheckBox) findViewById(R.id.checkBox1);
        checkBoxGato=(CheckBox) findViewById(R.id.checkBox2);
        checkBoxPapagaio=(CheckBox) findViewById(R.id.checkBox3);

        textView = (TextView) findViewById(R.id.textViewMostrar);

        botao=(Button) findViewById(R.id.botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itensSelecionados = "";

                itensSelecionados += "Item: " + checkBoxCao.getText() + "Status: " + checkBoxCao.isChecked() + "\n";
                itensSelecionados += "Item: " + checkBoxGato.getText() + "Status: " + checkBoxGato.isChecked() + "\n";
                itensSelecionados += "Item: " + checkBoxPapagaio.getText() + "Status: " + checkBoxPapagaio.isChecked() + "\n";

                textView.setText(itensSelecionados);
            }
        });
    }
}
