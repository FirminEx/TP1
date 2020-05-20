package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class offre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);

        TextView textePrenom=(TextView)findViewById(R.id.textePrenom);
        textePrenom.setText(getResources().getString(R.string.prenom));

        TextView texteNom=(TextView)findViewById(R.id.texteNom);
        texteNom.setText(getResources().getString(R.string.nom));

        TextView texteModele=(TextView)findViewById(R.id.texteModele);
        texteModele.setText(getResources().getString(R.string.modele));

        TextView texteCouleur=(TextView)findViewById(R.id.texteCouleur);
        texteCouleur.setText(getResources().getString(R.string.couleur));

        TextView textePlaque=(TextView)findViewById(R.id.textePlaque);
        textePlaque.setText(getResources().getString(R.string.plaque));

        TextView texteRdv=(TextView)findViewById(R.id.texteRDV);
        texteRdv.setText(getResources().getString(R.string.lieu));

        TextView texteDestination=(TextView)findViewById(R.id.texteDestination);
        texteDestination.setText(getResources().getString(R.string.destination));

        TextView texteHeure=(TextView)findViewById(R.id.texteHeure);
        texteHeure.setText(getResources().getString(R.string.heure));

        TextView textePlaces=(TextView)findViewById(R.id.textePlaces);
        textePlaces.setText(getResources().getString(R.string.places));

        TextView texteFormulaire=(TextView)findViewById(R.id.texteFormulaire);
        texteFormulaire.setText(getResources().getString(R.string.offre));

        final EditText eTexteNom=(EditText)findViewById(R.id.eTexteNom);

        final EditText eTextePrenom=(EditText)findViewById(R.id.eTextePrenom);

        final EditText eTexteModele=(EditText)findViewById(R.id.eTexteModele);

        final EditText eTexteCouleur=(EditText)findViewById(R.id.eTexteCouleur);

        final EditText eTextePlaque=(EditText)findViewById(R.id.eTextePlaque);

        final EditText eTexteRdv=(EditText)findViewById(R.id.eTexteRDV);

        final EditText eTexteDestination=(EditText)findViewById(R.id.eTexteDestination);

        final EditText eTexteHeure=(EditText)findViewById(R.id.eTexteHeure);

        final EditText eTextePlaces=(EditText)findViewById(R.id.eTextPlaces);

        Button bouttonValider=(Button)findViewById(R.id.bouttonValider);
        bouttonValider.setText(getResources().getString(R.string.confirmer));

        final baseOffre BDO=new baseOffre(getApplicationContext(),"BDO",null,1);
        final SQLiteDatabase bdo=BDO.getWritableDatabase();
        final Intent menu=new Intent(getApplicationContext(),confirmationOffre.class);

        bouttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pNom=eTexteNom.getText().toString();
                String pPrenom=eTextePrenom.getText().toString();
                String pModele=eTexteModele.getText().toString();
                String pCouleur=eTexteCouleur.getText().toString();
                String pPlaque=eTextePlaque.getText().toString();
                String pRdv=eTexteRdv.getText().toString();
                String pDestination=eTexteDestination.getText().toString();
                String pHeure=eTexteHeure.getText().toString();
                String pPlaces=eTextePlaces.getText().toString();

                if(pNom.isEmpty()==false&&pPrenom.isEmpty()==false&&pModele.isEmpty()==false&&pCouleur.isEmpty()==false&&pPlaces.isEmpty()==false&&pPlaque.isEmpty()==false&&pRdv.isEmpty()==false&&pDestination.isEmpty()==false&&pHeure.isEmpty()==false){
                    ContentValues donnes=new ContentValues();
                    donnes.put("nom",pNom);
                    donnes.put("prenom",pPrenom);
                    donnes.put("modele",pModele);
                    donnes.put("couleur",pCouleur);
                    donnes.put("plaque",pPlaque);
                    donnes.put("lieurdv",pRdv);
                    donnes.put("destination",pDestination);
                    donnes.put("heure",pHeure);
                    donnes.put("places",pPlaces);

                    bdo.insert("tableOffres",null,donnes);


                    startActivity(menu);


                }
                else{
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.champmanquant), Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}
