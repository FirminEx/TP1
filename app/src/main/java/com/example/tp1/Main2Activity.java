package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView proposer=(TextView)findViewById(R.id.texteProposer);
        proposer.setText(getResources().getString(R.string.proposer));

        Button bouttonOffre=(Button)findViewById(R.id.bouttonOffre);
        bouttonOffre.setText(getResources().getString(R.string.offre));

        Button bouttonDeconnecter=(Button)findViewById(R.id.bouttonDeconnecter);
        bouttonDeconnecter.setText(getResources().getString(R.string.deconnecter));

        Button bouttonPieton=(Button)findViewById(R.id.bouttonPieton);
        bouttonPieton.setText(getResources().getString(R.string.consulter));

        TextView textePieton=(TextView)findViewById(R.id.textePieton);
        textePieton.setText(getResources().getString(R.string.pieton));


        final Intent connection=new Intent(getApplicationContext(),MainActivity.class);
        final Intent offre=new Intent(getApplicationContext(),offre.class);
        final Intent carte=new Intent(getApplicationContext(),carte.class);

        bouttonPieton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(carte);
            }
        });


        bouttonOffre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(offre);
            }
        });

        bouttonDeconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(connection);
            }
        });
    }
}
