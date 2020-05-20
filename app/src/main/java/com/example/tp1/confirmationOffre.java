package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class confirmationOffre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_offre);

        TextView tvOffre=(TextView)findViewById(R.id.tvOffre);
        tvOffre.setText(getResources().getString(R.string.offreok));

        TextView tvMail=(TextView)findViewById(R.id.tvMail);
        tvMail.setText(getResources().getString(R.string.envoyermail));

        Button bouttonOk=(Button)findViewById(R.id.buttonOK);
        bouttonOk.setText(getResources().getString(R.string.ok));

        final Intent menu=new Intent(getApplicationContext(),Main2Activity.class);

        bouttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(menu);
            }
        });



    }
}
