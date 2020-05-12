package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


        bouttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login=bouttonLogin.getText().toString();
                String mdp=bouttonMdp.getText().toString();
                if(mdp.equals(login)&&mdp.isEmpty()==false){
                    Intent menu=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(menu);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Mauvais identifiants", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



