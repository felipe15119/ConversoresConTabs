package com.ugb.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TabHost tbhConversores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbhConversores = (TabHost)findViewById(R.id.tbhConversores);
        tbhConversores.setup();

        ///////
        tbhConversores.addTab(tbhConversores.newTabSpec("L").setContent(R.id.tabLongitud).setIndicator("Longuitud"));
        tbhConversores.addTab(tbhConversores.newTabSpec("M").setContent(R.id.tabMasa).setIndicator("Masa"));
        tbhConversores.addTab(tbhConversores.newTabSpec("V").setContent(R.id.tabVolumen).setIndicator("Volumen"));
        tbhConversores.addTab(tbhConversores.newTabSpec("S").setContent(R.id.tabAlmacenamiento).setIndicator("Almacenamiento"));
        tbhConversores.addTab(tbhConversores.newTabSpec("T").setContent(R.id.tabTranf).setIndicator("Transferencia"));
        tbhConversores.addTab(tbhConversores.newTabSpec("M").setContent(R.id.tabMonedas).setIndicator("Monedas"));
        tbhConversores.addTab(tbhConversores.newTabSpec("T").setContent(R.id.tabTiempo).setIndicator("Tiempo"));
    }
    public void calcular(View v){
        TextView tmpVal = (TextView)findViewById(R.id.txtCantidad);
        double cantidad  = Double.parseDouble(tmpVal.getText().toString());

        Spinner spn;
        double valores[][] = {

                new double[]{1,0.001,100,1000,1000000,1000000000,0.0006,1.0936,3.2808,39.9701,0.00053996}, //longitud
                new double[]{1,0.00045359,0.4535923,453.5923,453592.37,0.00000004535923,0.0004464286,0.0005,0.0089285714,0.01,16}, //masa
              new double[]{1,0.00045359,0.4535923,453.5923,453592.37,0.00000004535923,0.0004464286,0.0005,0.0089285714,0.01,16},

        };
        int de=0, a=0;
        double resp = 0;
        switch (tbhConversores.getCurrentTabTag()){

            case "L":
                spn = (Spinner)findViewById(R.id.cboDeL);
                de = spn.getSelectedItemPosition();
                spn = (Spinner)findViewById(R.id.cboAL);
                a = spn.getSelectedItemPosition();
                resp = valores[0][a] / valores[0][de] * cantidad;
                break;
            case "Ma":
                spn = (Spinner)findViewById(R.id.cboDema);
                de = spn.getSelectedItemPosition();
                spn = (Spinner)findViewById(R.id.cboma);
                a = spn.getSelectedItemPosition();
                resp = valores[1][a] / valores[1][de] * cantidad;
                break;

        }
        tmpVal = (TextView)findViewById(R.id.lblrespuesta);
        tmpVal.setText("Respuesta: "+ resp);
    }
}