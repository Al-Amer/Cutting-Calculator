package com.appectools.cuttingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ListView objectListView;
    GridView objectLis_Grid_View;

    // Adapter Variables Declaration und Assigning
    ArrayList<VariablesForObjectForListView> list_view;
    AdapterBetweenMainAndList_view adapterBetweenMainAndList_view;
    VariablesForObjectForListView winkle_object;
    VariablesForObjectForListView all_kanalschachtabdeckung_object ;
    VariablesForObjectForListView fensterbank_tropfbleche_object;
    VariablesForObjectForListView hut_profil_object;
    VariablesForObjectForListView mauerwerkandackung_object;
    VariablesForObjectForListView seitenabdeckung_object;
    VariablesForObjectForListView u_profil_object;
    VariablesForObjectForListView c_u_profil_object;        //u_profil__c_profil
    VariablesForObjectForListView z_profil_object;
    VariablesForObjectForListView wanne_object;
    VariablesForObjectForListView wanne2_2g_object;
    VariablesForObjectForListView wanne2n_object;
    VariablesForObjectForListView wanne3_1_object;
    VariablesForObjectForListView wanne3seitig_object;

    // log
    private static final String FACT_KEY = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        objectLis_Grid_View = findViewById(R.id.object_listView_2);
        list_view = new ArrayList<>();
        adapterBetweenMainAndList_view = new AdapterBetweenMainAndList_view(list_view,this);


        // object and view
        all_kanalschachtabdeckung_object = new VariablesForObjectForListView(R.drawable.all_kanalschachtabdeckung);
        fensterbank_tropfbleche_object = new VariablesForObjectForListView(R.drawable.fensterbank_tropfbleche);
        hut_profil_object = new VariablesForObjectForListView(R.drawable.hut_profil);
        mauerwerkandackung_object = new VariablesForObjectForListView(R.drawable.mauerwerkabdeckung);
        seitenabdeckung_object = new VariablesForObjectForListView(R.drawable.seitenabdeckung);
        z_profil_object = new VariablesForObjectForListView(R.drawable.z_profil);
        u_profil_object = new VariablesForObjectForListView(R.drawable.u_profil);
        c_u_profil_object = new VariablesForObjectForListView(R.drawable.u_profil__c_profil);
        winkle_object = new VariablesForObjectForListView(R.drawable.winkel);
        wanne_object = new VariablesForObjectForListView(R.drawable.wanne);
        wanne2_2g_object = new VariablesForObjectForListView(R.drawable.wanne2_2g);
        wanne2n_object = new VariablesForObjectForListView(R.drawable.wanne2_2n);
        wanne3_1_object = new VariablesForObjectForListView(R.drawable.wanne3_1);
        wanne3seitig_object = new VariablesForObjectForListView(R.drawable.wanne3_seitig);


        //Add to Arraylist
        list_view.add(wanne_object);
        list_view.add(wanne3seitig_object);
        list_view.add(winkle_object);
        list_view.add(all_kanalschachtabdeckung_object);
        list_view.add(fensterbank_tropfbleche_object);
        list_view.add(hut_profil_object);
        list_view.add(mauerwerkandackung_object);
        list_view.add(seitenabdeckung_object);
        list_view.add(z_profil_object);
        list_view.add(u_profil_object);
        list_view.add(c_u_profil_object);
        list_view.add(wanne2_2g_object);
        list_view.add(wanne2n_object);
        list_view.add(wanne3_1_object);


        //Add all to ListView

        objectLis_Grid_View.setAdapter(adapterBetweenMainAndList_view);

        //on Click
        objectLis_Grid_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Method for going to the next Layout
                be_click_on_view_list(list_view.get(position));
                finish();

            }
        });


    }   // end of onCreate

    public void be_click_on_view_list(VariablesForObjectForListView variablesForObjectForListView_object) {
        Intent intent;
        String metallprofil_name;

        //  object with 2 profil (winkle_object)
        if (variablesForObjectForListView_object.equals(winkle_object)) {
            intent = new Intent(MainActivity.this, layout_category_first.class);
            metallprofil_name = "Winkle";
            intent.putExtra("profil_name", metallprofil_name);
        }
        // all object with 3 profil (c_u_profil_object and z_profil)
        else if (variablesForObjectForListView_object.equals(z_profil_object)) {
            intent = new Intent(MainActivity.this, layout_category_second.class);
            metallprofil_name = "z_profil";
            intent.putExtra("profil_name", metallprofil_name);
        } else if (variablesForObjectForListView_object.equals(c_u_profil_object)) {
            intent = new Intent(MainActivity.this, layout_category_second.class);
            metallprofil_name = "c_u_profil";
            intent.putExtra("profil_name", metallprofil_name);
        }
        // all object with 4 profil (fensterbank_tropfbleche_object / seitenabdeckung_object / u_profil_object)
        else if (variablesForObjectForListView_object.equals(fensterbank_tropfbleche_object)) {
            intent = new Intent(MainActivity.this, layout_category_third.class);
            metallprofil_name = "fensterbank";
            intent.putExtra("profil_name", metallprofil_name);
        } else if (variablesForObjectForListView_object.equals(hut_profil_object)) {
            intent = new Intent(MainActivity.this, layout_category_fourth.class);
            metallprofil_name = "hut_profil";
            intent.putExtra("profil_name", metallprofil_name);
        } else if (variablesForObjectForListView_object.equals(mauerwerkandackung_object)) {
            intent = new Intent(MainActivity.this, layout_category_fourth.class);
            metallprofil_name = "mauerwerkandackung";
            intent.putExtra("profil_name", metallprofil_name);
        } else if (variablesForObjectForListView_object.equals(seitenabdeckung_object)) {
            intent = new Intent(MainActivity.this, layout_category_third.class);
            metallprofil_name = "seitenabdeckung";
            intent.putExtra("profil_name", metallprofil_name);
        } else if (variablesForObjectForListView_object.equals(u_profil_object)) {
            intent = new Intent(MainActivity.this, layout_category_third.class);
            metallprofil_name = "u_profil";
            intent.putExtra("profil_name", metallprofil_name);
        }
        // all object with 5 profil (all_kanalschachtabdeckung_object / hut_profil_object / mauerwerkandackung_object )
        else if (variablesForObjectForListView_object.equals(all_kanalschachtabdeckung_object)) {
            intent = new Intent(MainActivity.this, layout_category_fourth.class);
            metallprofil_name = "all_kanalschachtabdeckung";
            intent.putExtra("profil_name", metallprofil_name);
        } else {
            intent = new Intent(MainActivity.this, layout_category_fifth.class);
            if (variablesForObjectForListView_object.equals(wanne3seitig_object)) {
                metallprofil_name = "wanne3seitig_object";
                intent.putExtra("profil_name", metallprofil_name);
            } else {
                metallprofil_name = "wanne";
                intent.putExtra("profil_name", metallprofil_name);
            }
        }
        startActivity(intent);
        finish();
    }

}