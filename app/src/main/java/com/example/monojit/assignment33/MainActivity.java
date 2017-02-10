package com.example.monojit.assignment33;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int SELECTIMAGE=99;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView);
    }
    public void getImage(View view) {
        Intent selectImage = new Intent();
        selectImage.setType("image/*");
        selectImage.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(selectImage,SELECTIMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SELECTIMAGE){
            if(resultCode==RESULT_OK){
              Uri selectedImage=data.getData();
                img.setImageURI(selectedImage);
            }else
                Toast.makeText(this, "Contact selection was aborted..", Toast.LENGTH_SHORT).show();

        }

    }
}
