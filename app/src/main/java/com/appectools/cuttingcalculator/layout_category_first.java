package com.appectools.cuttingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class layout_category_first extends AppCompatActivity {

    ImageView image_metal_prof ;
    // Measure input
    EditText measure_first_side;
    EditText measure_second_side;
    EditText measure_material;
    // Measure in INT
    int measure_first_side_int;
    int measure_second_side_int;
    int measure_material_int;
    //
    int measure_inside_first;
    int measure_inside_second;
    int measure_outside_first;
    int measure_outside_second;
    //
    Switch switch_first;
    Switch switch_second;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_category_first);

        image_metal_prof = findViewById(R.id.imageView_layout_second);
        measure_first_side = findViewById(R.id.measure_first);
        measure_second_side = findViewById(R.id.measure_second);
        measure_material = findViewById(R.id.measure_material);
        calculate = findViewById(R.id.button_calculate);
        switch_first = findViewById(R.id.switch1);
        switch_second = findViewById(R.id.switch2);
        // Set Metal type
        Bundle bundle = getIntent().getExtras();
        String metal_type = bundle.getString("profil_name");
        // Set Image

        image_metal_prof.setImageResource(R.drawable.metallprofil_winkle);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measure_material_int = Integer.parseInt(measure_material.getText().toString());
                measure_first_side_int = Integer.parseInt(measure_first_side.getText().toString());
                measure_second_side_int = Integer.parseInt(measure_second_side.getText().toString());

                // Set Measure
                if (switch_first.isChecked()){
                    measure_outside_first = measure_first_side_int + measure_material_int;
                    measure_inside_first = measure_first_side_int;
                }else {
                    measure_outside_first = measure_first_side_int;
                    measure_inside_first = measure_first_side_int - measure_material_int;
                }
                if (switch_second.isChecked()){
                    measure_outside_second = measure_second_side_int + measure_material_int;
                    measure_inside_second = measure_second_side_int;
                }else{
                    measure_outside_second = measure_second_side_int ;
                    measure_inside_second = measure_second_side_int - measure_material_int;
                }
                int measure_inside = measure_inside_first + measure_inside_second;
                int measure_outside = measure_outside_first+measure_outside_second;
                String result = "L1 "+ getString(R.string.inside)+" = "+measure_inside_first + " & L1 "+ getString(R.string.outside)+" = "+measure_outside_first+
                        "\nH1 "+ getString(R.string.inside)+" = "+measure_inside_second+" & H1 "+getString(R.string.outside)+" = "+measure_outside_second+
                        "\n"+getString(R.string.all_inside)+" = "+measure_inside+" & "+getString(R.string.all_outside)+" = "+measure_outside;

                // send the Info and Result to the Last Layout
                Intent intent = new Intent(layout_category_first.this, layout_final.class);
                intent.putExtra("profil_name",metal_type);
                intent.putExtra("Result",result);
                startActivity(intent);

            }
        });

    }
}