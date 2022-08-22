package com.appectools.cuttingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class layout_final extends AppCompatActivity {

    ImageView image_metal_prof ; // final_imageView
    TextView text_result;       //final_result_textView
    Button button_back;     //back_button
    Button button_go_to_start;  //go_to_strat_button
    Button button_share;    //send_button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_final);

        image_metal_prof = findViewById(R.id.final_imageView);
        text_result = findViewById(R.id.final_result_textView);
        button_back = findViewById(R.id.back_button);
        button_go_to_start = findViewById(R.id.go_to_strat_button);
        button_share = findViewById(R.id.send_button);

        Bundle bundle = getIntent().getExtras();
        String metal_type = bundle.getString("profil_name");
        if (metal_type.equals("Winkle")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_winkle);
        }else if (metal_type.equals("z_profil")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_z_profil);
        }else if (metal_type.equals("c_u_profil")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_u_profil_c_profil);
        }else if (metal_type.equals("fensterbank")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_fensterbank_tropfbleche);
        }else if (metal_type.equals("seitenabdeckung")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_seitenabdeckung);
        }else if (metal_type.equals("u_profil")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_u_profil);
        }else if (metal_type.equals("all_kanalschachtabdeckung")){
            image_metal_prof.setImageResource(R.drawable.metallaprofi_all_kanalschachtabdeckung);
        }else if (metal_type.equals("hut_profil")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_hut_profil);
        }else if (metal_type.equals("mauerwerkandackung")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_mauerwerkabdeckung);
        }else if (metal_type.equals("wanne3seitig_object")){
            image_metal_prof.setImageResource(R.drawable.metallprofil_wanne3_seitig);
        }else  {
            image_metal_prof.setImageResource(R.drawable.metallprofil_wanne);
        }
        String result = bundle.getString("Result");
        text_result.setText(result);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (metal_type.equals("Winkle")){
                    intent = new Intent(layout_final.this, layout_category_first.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("z_profil")){
                    intent = new Intent(layout_final.this, layout_category_second.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("c_u_profil")){
                    intent = new Intent(layout_final.this, layout_category_second.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("fensterbank")){
                    intent = new Intent(layout_final.this, layout_category_third.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("seitenabdeckung")){
                    intent = new Intent(layout_final.this, layout_category_third.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("u_profil")){
                    intent = new Intent(layout_final.this, layout_category_third.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("all_kanalschachtabdeckung")){
                    intent = new Intent(layout_final.this, layout_category_fourth.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("hut_profil")) {
                    intent = new Intent(layout_final.this, layout_category_fourth.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("mauerwerkandackung")){
                    intent = new Intent(layout_final.this, layout_category_fourth.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("wanne3seitig_object")){
                    intent = new Intent(layout_final.this, layout_category_fifth.class);
                    intent.putExtra("profil_name",metal_type);
                }else if (metal_type.equals("wanne")){
                    intent = new Intent(layout_final.this, layout_category_fifth.class);
                    intent.putExtra("profil_name",metal_type);
                }else{
                    intent = new Intent(layout_final.this, MainActivity.class);
                }
                startActivity(intent);
            }
        }); // end Method

        button_go_to_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layout_final.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });// ende Method

//        button_share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent share_intent = new Intent();
//                share_intent.setAction(Intent.ACTION_SEND);
//                // share_intent.setType("text/plain");
//                share_intent.setType("image/*");
//                File photofile =new File (getFilesDir(),"image_metal_prof");
//                share_intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photofile));
//                share_intent.putExtra(Intent.EXTRA_TEXT,text_result.toString());
//                share_intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                startActivity(Intent.createChooser(share_intent,getString(R.string.app_name)));
//            }
//        });


        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share_intent = new Intent();
                share_intent.setAction(Intent.ACTION_SEND);
                File photofile =new File (getFilesDir(),"image_metal_prof");
                Uri screenshotUri = Uri.parse(MediaStore.Images.Media.EXTERNAL_CONTENT_URI + "/" + Uri.fromFile(photofile));

                share_intent.setType("image/jpeg");
                share_intent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                share_intent.putExtra(Intent.EXTRA_TEXT,text_result.toString());
                share_intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(share_intent,getString(R.string.app_name)));
            }
        });


    }
}