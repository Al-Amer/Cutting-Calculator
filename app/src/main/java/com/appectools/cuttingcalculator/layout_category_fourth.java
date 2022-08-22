package com.appectools.cuttingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class layout_category_fourth extends AppCompatActivity {

    ImageView image_metal_prof ;
    // Measure input
    EditText measure_first_side;
    EditText measure_second_side;
    EditText measure_third_side;
    EditText measure_fourth_side;
    EditText measure_material;
    EditText measure_fifth_side;
    // Measure in INT
    int measure_first_side_int;
    int measure_second_side_int;
    int measure_third_side_int;
    int measure_fourth_side_int;
    int measure_fifth_side_int;
    int measure_material_int;
    //
    int measure_inside_first;
    int measure_inside_second;
    int measure_outside_first;
    int measure_outside_second;
    int measure_inside_third;
    int measure_outside_third;
    int measure_inside_fourth;
    int measure_outside_fourth;
    int measure_inside_fifth;
    int measure_outside_fifth;
    //
    Switch switch_first;
    Switch switch_second;
    Switch switch_third;
    Switch switch_fourth;
    Switch switch_fifth;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_category_fourth);

        image_metal_prof = findViewById(R.id.imageView_layout_second);
        measure_first_side = findViewById(R.id.measure_first);
        measure_second_side = findViewById(R.id.measure_second);
        measure_third_side = findViewById(R.id.measure_third);
        measure_fourth_side = findViewById(R.id.measure_fourth);
        measure_fifth_side = findViewById(R.id.measure_fifth);
        measure_material = findViewById(R.id.measure_material);
        calculate = findViewById(R.id.button_calculate);
        switch_first = findViewById(R.id.switch1);
        switch_second = findViewById(R.id.switch2);
        switch_third = findViewById(R.id.switch3);
        switch_fourth = findViewById(R.id.switch4);
        switch_fifth = findViewById(R.id.switch5);
        // Set Metal type
        Bundle bundle = getIntent().getExtras();
        String metal_type = bundle.getString("profil_name");
        // Set Image
        if (metal_type.equals("all_kanalschachtabdeckung")){
            image_metal_prof.setImageResource(R.drawable.metallaprofi_all_kanalschachtabdeckung);
        }else if (metal_type.equals("hut_profil")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_hut_profil);
        }else if (metal_type.equals("mauerwerkandackung")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_mauerwerkabdeckung);
        }else{

        }

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measure_material_int = Integer.parseInt(measure_material.getText().toString());
                measure_first_side_int = Integer.parseInt(measure_first_side.getText().toString());
                measure_second_side_int = Integer.parseInt(measure_second_side.getText().toString());
                measure_third_side_int = Integer.parseInt(measure_third_side.getText().toString());
                measure_fourth_side_int = Integer.parseInt(measure_fourth_side.getText().toString());
                measure_fifth_side_int = Integer.parseInt(measure_fifth_side.getText().toString());
                String result;


                if (metal_type.equals("all_kanalschachtabdeckung") || metal_type.equals("hut_profil")) {
                    if (switch_first.isChecked()) {
                        measure_outside_first = measure_first_side_int + measure_material_int;
                        measure_inside_first = measure_first_side_int;
                    } else {
                        measure_outside_first = measure_first_side_int;
                        measure_inside_first = measure_first_side_int - measure_material_int;
                    }
                    if (switch_second.isChecked()) {
                        measure_outside_second = measure_second_side_int;
                        measure_inside_second = measure_second_side_int;
                    } else {
                        measure_outside_second = measure_second_side_int;
                        measure_inside_second = measure_second_side_int;
                    }
                    if (switch_third.isChecked()) {
                        measure_outside_third = measure_third_side_int + (measure_material_int*2);
                        measure_inside_third = measure_third_side_int;
                    } else {
                        measure_outside_third = measure_third_side_int;
                        measure_inside_third = measure_third_side_int - (measure_material_int * 2);
                    }
                    if (switch_fourth.isChecked()) {
                        measure_outside_fourth = measure_fourth_side_int ;
                        measure_inside_fourth = measure_fourth_side_int;
                    } else {
                        measure_outside_fourth = measure_fourth_side_int;
                        measure_inside_fourth = measure_fourth_side_int ;
                    }
                    if (switch_fifth.isChecked()) {
                        measure_outside_fifth = measure_fifth_side_int + measure_material_int;
                        measure_inside_fifth = measure_fifth_side_int;
                    } else {
                        measure_outside_fifth = measure_fifth_side_int;
                        measure_inside_fifth = measure_fifth_side_int - measure_material_int;
                    }
                    int measure_inside = measure_inside_first + measure_inside_second + measure_inside_third + measure_inside_fourth+measure_inside_fifth;
                    int measure_outside = measure_outside_first + measure_outside_second + measure_outside_third + measure_outside_fourth+measure_outside_fifth;
                    result = "L1 "+getString(R.string.inside)+" = " + measure_inside_first + " & L1 "+getString(R.string.outside)+" = " + measure_outside_first +
                            "\nH1 "+getString(R.string.inside)+" = " + measure_inside_second + " & H1 "+getString(R.string.outside)+" = " + measure_outside_second +
                            "\nL2 "+getString(R.string.inside)+" = " + measure_inside_third + " & L2 "+getString(R.string.outside)+" = " + measure_outside_third +
                            "\nH2 "+getString(R.string.inside)+" = " + measure_inside_fourth + " & H2 "+getString(R.string.outside)+" = " + measure_outside_fourth +
                            "\nL3 "+getString(R.string.inside)+" = " + measure_inside_fifth + " & L3 "+getString(R.string.outside)+" = " + measure_outside_fifth +
                            "\n"+getString(R.string.all_inside)+" = " + measure_inside + " & "+getString(R.string.all_outside)+" = " + measure_outside;
                } else if (metal_type.equals("mauerwerkandackung")) {
                    if (switch_first.isChecked()) {
                        measure_outside_first = measure_first_side_int + measure_material_int;
                        measure_inside_first = measure_first_side_int;
                    } else {
                        measure_outside_first = measure_first_side_int;
                        measure_inside_first = measure_first_side_int - measure_material_int;
                    }
                    if (switch_second.isChecked()) {
                        measure_outside_second = measure_second_side_int + (measure_material_int * 2);
                        measure_inside_second = measure_second_side_int;
                    } else {
                        measure_outside_second = measure_second_side_int ;
                        measure_inside_second = measure_second_side_int - (measure_material_int * 2);
                    }
                    if (switch_third.isChecked()) {
                        measure_outside_third = measure_third_side_int + (measure_material_int * 2);
                        measure_inside_third = measure_third_side_int;
                    } else {
                        measure_outside_third = measure_third_side_int ;
                        measure_inside_third = measure_third_side_int - (measure_material_int * 2);
                    }
                    if (switch_fourth.isChecked()) {
                        measure_outside_fourth = measure_fourth_side_int + (measure_material_int * 2);
                        measure_inside_fourth = measure_fourth_side_int;
                    } else {
                        measure_outside_fourth = measure_fourth_side_int ;
                        measure_inside_fourth = measure_fourth_side_int - (measure_material_int * 2);
                    }
                    if (switch_fifth.isChecked()) {
                        measure_outside_fifth = measure_fifth_side_int + measure_material_int;
                        measure_inside_fifth = measure_fifth_side_int;
                    } else {
                        measure_outside_fifth = measure_fifth_side_int;
                        measure_inside_fifth = measure_fifth_side_int - measure_material_int;
                    }
                    int measure_inside = measure_inside_first + measure_inside_second + measure_inside_third + measure_inside_fourth+measure_inside_fifth;
                    int measure_outside = measure_outside_first + measure_outside_second + measure_outside_third + measure_outside_fourth+measure_outside_fifth;
                    result = "L1 "+getString(R.string.inside)+" = " + measure_inside_first + " & L1 "+getString(R.string.outside)+" = " + measure_outside_first +
                            "\nH1 "+getString(R.string.inside)+" = " + measure_inside_second + " & H1 "+getString(R.string.outside)+" = " + measure_outside_second +
                            "\nL2 "+getString(R.string.inside)+" = " + measure_inside_third + " & L2 "+getString(R.string.outside)+" = " + measure_outside_third +
                            "\nH2 "+getString(R.string.inside)+" = " + measure_inside_fourth + " & H2 "+getString(R.string.outside)+" = " + measure_outside_fourth +
                            "\nL3 "+getString(R.string.inside)+" = " + measure_inside_fifth + " & L3 "+getString(R.string.outside)+" = " + measure_outside_fifth +
                            "\n"+getString(R.string.all_inside)+" = " + measure_inside + " & "+getString(R.string.all_outside)+" = " + measure_outside;
                } else {
                    result = " ";
                }

                Intent intent = new Intent(layout_category_fourth.this, layout_final.class);
                intent.putExtra("profil_name", metal_type);
                intent.putExtra("Result", result);
                startActivity(intent);
            }
        });
    }
}