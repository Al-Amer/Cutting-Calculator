package com.appectools.cuttingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class layout_category_fifth extends AppCompatActivity {

    ImageView image_metal_prof ;
    ImageView image_metal_profil_2;
    // Measure input
    EditText measure_first_side;
    EditText measure_second_side;
    EditText measure_third_side;
    EditText measure_fourth_side;
    EditText measure_fifth_side;
    EditText measure_sixth_side;
    EditText measure_material;
    // Measure in INT
    int measure_first_side_int;
    int measure_second_side_int;
    int measure_third_side_int;
    int measure_fourth_side_int;
    int measure_fifth_side_int;
    int measure_sixth_side_int;
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
    int measure_inside_sixth;
    int measure_outside_sixth;
    //
    Switch switch_first;
    Switch switch_second;
    Switch switch_third;
    Switch switch_fourth;
    Switch switch_fifth;
    Switch switch_sixth;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_category_fifth);

        image_metal_prof = findViewById(R.id.imageView_1);
        image_metal_profil_2 = findViewById(R.id.imageView_2);
        measure_first_side = findViewById(R.id.editTextNumber_1);
        measure_second_side = findViewById(R.id.editTextNumber_2);
        measure_third_side = findViewById(R.id.editTextNumber_3);
        measure_fourth_side = findViewById(R.id.editTextNumber_4);
        measure_fifth_side = findViewById(R.id.editTextNumber_5);
        measure_sixth_side = findViewById(R.id.editTextNumber_7);
        measure_material = findViewById(R.id.measure_material);
        calculate = findViewById(R.id.button_calculate);
        switch_first = findViewById(R.id.switch_1);
        switch_second = findViewById(R.id.switch_2);
        switch_third = findViewById(R.id.switch_3);
        switch_fourth = findViewById(R.id.switch_4);
        switch_fifth = findViewById(R.id.switch_5);
        switch_sixth = findViewById(R.id.switch_7);

        // Set Metal type
        Bundle bundle = getIntent().getExtras();
        String metal_type = bundle.getString("profil_name");
        if (metal_type.equals("wanne3seitig_object")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_wanne3_seitig);
            image_metal_profil_2.setImageResource(R.drawable.metallprofil_wanne3_seitig);
        }
        else if (metal_type.equals("wanne")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_wanne);
            image_metal_profil_2.setImageResource(R.drawable.metallprofil_wanne);
        }

        // Button

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measure_material_int = Integer.parseInt(measure_material.getText().toString());
                measure_first_side_int = Integer.parseInt(measure_first_side.getText().toString());
                measure_third_side_int = Integer.parseInt(measure_third_side.getText().toString());
                measure_second_side_int = Integer.parseInt(measure_second_side.getText().toString());
                measure_fourth_side_int = Integer.parseInt(measure_fourth_side.getText().toString());
                measure_fifth_side_int = Integer.parseInt(measure_fifth_side.getText().toString());
                measure_sixth_side_int = Integer.parseInt(measure_sixth_side.getText().toString());
                String result;


                if (metal_type.equals("wanne3seitig_object"))
                {
                    if (switch_first.isChecked()) {
                        measure_outside_first = measure_first_side_int + (measure_material_int * 2);
                        measure_inside_first = measure_first_side_int;
                    } else {
                        measure_outside_first = measure_first_side_int;
                        measure_inside_first = measure_first_side_int - (measure_material_int * 2);
                    }
                    if (switch_second.isChecked()) {
                        measure_outside_second = measure_second_side_int + measure_material_int ;
                        measure_inside_second = measure_second_side_int;
                    } else {
                        measure_outside_second = measure_second_side_int;
                        measure_inside_second = measure_second_side_int - measure_material_int ;
                    }
                    if (switch_third.isChecked()) {
                        measure_outside_third = measure_third_side_int + measure_material_int;
                        measure_inside_third = measure_third_side_int;
                    } else {
                        measure_outside_third = measure_third_side_int;
                        measure_inside_third = measure_third_side_int - measure_material_int;
                    }
                    if (switch_fourth.isChecked()) {
                        measure_outside_fourth = measure_fourth_side_int + measure_material_int;
                        measure_inside_fourth = measure_fourth_side_int;
                    } else {
                        measure_outside_fourth = measure_fourth_side_int;
                        measure_inside_fourth = measure_fourth_side_int - measure_material_int;
                    }
                    if (switch_fifth.isChecked()) {
                        measure_outside_fifth = measure_fifth_side_int + measure_material_int;
                        measure_inside_fifth = measure_fifth_side_int;
                    } else {
                        measure_outside_fifth = measure_fifth_side_int;
                        measure_inside_fifth = measure_fifth_side_int - measure_material_int;
                    }
                    if (switch_sixth.isChecked()) {
                        measure_outside_sixth = measure_sixth_side_int + measure_material_int;
                        measure_inside_sixth = measure_sixth_side_int;
                    } else {
                        measure_outside_sixth = measure_sixth_side_int;
                        measure_inside_sixth = measure_sixth_side_int - measure_material_int;
                    }

                }else{
                    if (switch_first.isChecked()) {
                        measure_outside_first = measure_first_side_int + (measure_material_int * 2);
                        measure_inside_first = measure_first_side_int;
                    } else {
                        measure_outside_first = measure_first_side_int;
                        measure_inside_first = measure_first_side_int - (measure_material_int * 2);
                    }
                    if (switch_second.isChecked()) {
                        measure_outside_second = measure_second_side_int + (measure_material_int * 2);
                        measure_inside_second = measure_second_side_int;
                    } else {
                        measure_outside_second = measure_second_side_int;
                        measure_inside_second = measure_second_side_int - (measure_material_int * 2);
                    }
                    if (switch_third.isChecked()) {
                        measure_outside_third = measure_third_side_int + measure_material_int;
                        measure_inside_third = measure_third_side_int;
                    } else {
                        measure_outside_third = measure_third_side_int;
                        measure_inside_third = measure_third_side_int - measure_material_int;
                    }
                    if (switch_fourth.isChecked()) {
                        measure_outside_fourth = measure_fourth_side_int + measure_material_int;
                        measure_inside_fourth = measure_fourth_side_int;
                    } else {
                        measure_outside_fourth = measure_fourth_side_int;
                        measure_inside_fourth = measure_fourth_side_int - measure_material_int;
                    }
                    if (switch_fifth.isChecked()) {
                        measure_outside_fifth = measure_fifth_side_int + measure_material_int;
                        measure_inside_fifth = measure_fifth_side_int;
                    } else {
                        measure_outside_fifth = measure_fifth_side_int;
                        measure_inside_fifth = measure_fifth_side_int - measure_material_int;
                    }
                    if (switch_sixth.isChecked()) {
                        measure_outside_sixth = measure_sixth_side_int + measure_material_int;
                        measure_inside_sixth = measure_sixth_side_int;
                    } else {
                        measure_outside_sixth = measure_sixth_side_int;
                        measure_inside_sixth = measure_sixth_side_int - measure_material_int;
                    }
                }
                int measure_inside = measure_inside_first + measure_inside_second + measure_inside_third + measure_inside_fourth+measure_inside_fifth;
                int measure_outside = measure_outside_first + measure_outside_second + measure_outside_third + measure_outside_fourth+measure_outside_fifth;
                result = "L1 " + getString(R.string.inside) + " = " + measure_inside_first + " & L1 " + getString(R.string.outside) + " = " + measure_outside_first +
                        "\nL2 " + getString(R.string.inside) + " = " + measure_inside_second + " & L2 " + getString(R.string.outside) + " = " + measure_outside_second +
                        "\nL3 " + getString(R.string.inside) + " = " + measure_inside_third + " & L3 " + getString(R.string.outside) + " = " + measure_outside_third +
                        "\nL4 " + getString(R.string.inside) + " = " + measure_inside_fourth + " & L4 " + getString(R.string.outside) + " = " + measure_outside_fourth +
                        "\nL5 " + getString(R.string.inside) + " = " + measure_inside_fifth + " & L5 " + getString(R.string.outside) + " = " + measure_outside_fifth +
                        "\nL6 " + getString(R.string.inside) + " = " + measure_inside_sixth + " & L6 " + getString(R.string.outside) + " = " + measure_outside_sixth +
                        "\n" + getString(R.string.all_inside) + " = " + measure_inside + " & " + getString(R.string.all_outside) + " = " + measure_outside;

                Intent intent = new Intent(layout_category_fifth.this, layout_final.class);
                intent.putExtra("profil_name", metal_type);
                intent.putExtra("Result", result);
                startActivity(intent);
            }
        });

    }
}