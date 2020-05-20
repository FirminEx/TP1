package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText bouttonLogin=(EditText) findViewById(R.id.bouttonLogin);
        String hintLogin=getResources().getString(R.string.demande_login);
        bouttonLogin.setHint(hintLogin);

        final EditText bouttonMdp=(EditText) findViewById(R.id.bouttonMdp);
        String hintMdp=getResources().getString(R.string.demande_mdp);
        bouttonMdp.setHint(hintMdp);

        Button bouttonConnexion=(Button)findViewById(R.id.bouttonConnexion);
        String hintSeConnecter=getResources().getString(R.string.se_connecter);
        bouttonConnexion.setText(hintSeConnecter);

        final TextView texteConnexion=(TextView)findViewById(R.id.texteConnexion);
        String hintConnexion=getResources().getString(R.string.connexion);
        texteConnexion.setText(hintConnexion);

        final Button bouttonCreation=(Button)findViewById(R.id.bouttonCreation);
        String hintCreation=getResources().getString(R.string.creation);
        bouttonCreation.setText(hintCreation);

        String login=getIntent().getStringExtra("login");
        String mdp=getIntent().getStringExtra("mdp");

        bouttonLogin.setText(login);
        bouttonMdp.setText(mdp);


        bouttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login=bouttonLogin.getText().toString();
                String mdp=bouttonMdp.getText().toString();

                baseDonnees bd =new baseDonnees(getApplicationContext(),"BD",null,1);


                String[] compte =new String[2];
                try{
                compte[0]=bd.getCompte(login)[0];
                compte[1]=bd.getCompte(login)[1];
                    if(compte[0].equals(login)&&compte[1].equals(mdp)){
                        Intent menu=new Intent(getApplicationContext(),Main2Activity.class);
                        startActivity(menu);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Mauvais identifiants", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.compteinexi), Toast.LENGTH_SHORT).show();
                    }
                }
            });


        bouttonCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creation=new Intent(getApplicationContext(),CreationCompte.class);
                startActivity(creation);
            }
        });
    }
}



