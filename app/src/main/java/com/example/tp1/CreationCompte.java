package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;


public class CreationCompte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        TextView textCreation=(TextView) findViewById(R.id.textCreation);
        textCreation.setText(getResources().getString(R.string.creation));

        TextView textNom=(TextView)findViewById(R.id.textNom);
        textNom.setText(getResources().getString(R.string.nom));

        TextView textPrenom=(TextView)findViewById(R.id.textPrenom);
        textPrenom.setText(getResources().getString(R.string.prenom));

        TextView textMail=(TextView)findViewById(R.id.textMail);
        textMail.setText(getResources().getString(R.string.mail));

        TextView textTelephone=(TextView)findViewById(R.id.textTelephone);
        textTelephone.setText(getResources().getString(R.string.telephone));

        TextView textLogin=(TextView)findViewById(R.id.textLogin);
        textLogin.setText(getResources().getString(R.string.login));

        TextView textMdp=(TextView)findViewById(R.id.textMdp);
        textMdp.setText(getResources().getString(R.string.mdp));

        TextView textMdpConfirm=(TextView)findViewById(R.id.textMdpConfirm);
        textMdpConfirm.setText(getResources().getString(R.string.mdpConfirmation));

        final EditText eTextNom = (EditText)findViewById(R.id.eTextNom);

        final EditText eTextPrenom = (EditText)findViewById(R.id.eTextPrenom);

        final EditText eTextTelephone = (EditText)findViewById(R.id.eTextTelephone);

        final EditText eTextMail = (EditText)findViewById(R.id.eTextMail);

        final EditText eTextLogin = (EditText)findViewById(R.id.eTextLogin);

        final EditText eTextMdp = (EditText)findViewById(R.id.eTextMdp);

        final EditText eTextMdpConfirm = (EditText)findViewById(R.id.eTextMdpConfirm);

        Button bouttonCreation=(Button)findViewById(R.id.bouttonCreation);
        bouttonCreation.setText(getString(R.string.valider));

        Button bouttonAnnuler=(Button)findViewById(R.id.bouttonAnnuler);
        bouttonAnnuler.setText(getString(R.string.annuler));

        final baseDonnees BD=new baseDonnees(getApplicationContext(),"BD",null,1);
        final SQLiteDatabase bd=BD.getWritableDatabase();






        final Intent connexion=new Intent(getApplicationContext(),MainActivity.class);

        bouttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(connexion);
            }
        });

        bouttonCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pNom = eTextNom.getText().toString();
                String pPrenom=eTextPrenom.getText().toString();
                String pTelephone=eTextTelephone.getText().toString();
                String pMail=eTextMail.getText().toString();
                String pLogin=eTextLogin.getText().toString();
                String pMdp=eTextMdp.getText().toString();
                String pMdpConfirm=eTextMdpConfirm.getText().toString();

                if(pLogin.isEmpty()==false&&pMail.isEmpty()==false&&pMdp.isEmpty()==false&&pMdpConfirm.isEmpty()==false&&pNom.isEmpty()==false&&pPrenom.isEmpty()==false&&pTelephone.isEmpty()==false){
                    if(pMdp.equals(pMdpConfirm)){
                        ContentValues donnees= new ContentValues();
                        donnees.put("nom",pNom);
                        donnees.put("prenom",pPrenom);
                        donnees.put("telephone",pTelephone);
                        donnees.put("mail",pMail);
                        donnees.put("login",pLogin);
                        donnees.put("mdp",pMdp);

                        bd.insert("tableComptes",null,donnees);

                        connexion.putExtra("login",pLogin);
                        connexion.putExtra("mdp",pMdp);

                        startActivity(connexion);

                    }
                    else{
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.mdpincorrect),Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.champmanquant),Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
