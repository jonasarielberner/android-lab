package autenticacaousuario.example.com.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        Log.i("createUser", "onCreate");

        //firebaseAuth.signOut();




       firebaseAuth.signInWithEmailAndPassword("jonasarielberner@gmail.com", "jota")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.i("createUser", "onComplete");
                        if (task.isSuccessful()){
                            Log.i("signIn", "Sucesso ao fazer login");
                        }else{//erro ao cadastrar o usuario
                            Log.i("sginIn", "Erro ao fazer login");

                        }
                    }
                });

        //cadastro
        /*firebaseAuth.createUserWithEmailAndPassword("jonasarielberner@gmail.com","jota2001")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Log.i("createUser", "Sucesso");
                        }else{//erro ao cadastrar o usuario
                            Log.i("createUser", "Erro");

                        }

                    }
                });*/
        if(firebaseAuth.getCurrentUser() != null){

            Log.i("logIn", "Usuario logado");

        }else{
            Log.i("logIn", "Usuario nao logado");

        }
    }
}
