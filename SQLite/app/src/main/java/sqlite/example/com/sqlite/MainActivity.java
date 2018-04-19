package sqlite.example.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) )");
            //bancoDados.execSQL("DROP TABLE pessoas");

            //inserir dados na tabela
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Jonas', 26)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Silvia', 24)");
            bancoDados.execSQL("UPDATE pessoas SET idade = 26 WHERE id = 1");
            //bancoDados.execSQL(("DELETE FROM pessoas WHERE nome = 'Ana'"));

            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");


            cursor.moveToFirst();

            while (cursor != null) {

                Log.i("RESULTADO - nome ", cursor.getString(indiceColunaNome));

                Log.i("RESULTADO - idade ", cursor.getString(indiceColunaIdade));

                Log.i("RESULTADO - id ", cursor.getString(indiceColunaId));


                cursor.moveToNext();

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
