package com.slenhtech_corp.tikkeo;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.slenhtech_corp.tikkeo.R;

/**
 * Created by lmbongue on 09/06/2016.
 */

public class MapartieActivity extends AppCompatActivity implements OnClickListener{
        private Button b = null;
        private Button b1 = null;
    @Override
    public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            setContentView(R.layout.mapartie);

            b = (Button) findViewById(R.id.Inscription);
            b.setOnClickListener(this);

            b1 = (Button)findViewById(R.id.Connexion);
            b1.setOnClickListener(this);
        }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
// Si l'identifiant de la vue est celui du premier bouton
            case R.id.Inscription:
/* Agir pour Inscription */
                break;
// Si l'identifiant de la vue est celui du deuxième bouton
            case R.id.Connexion:
/* Agir pour Connexion */
                break;
/* etc. */
        }

    }
}
