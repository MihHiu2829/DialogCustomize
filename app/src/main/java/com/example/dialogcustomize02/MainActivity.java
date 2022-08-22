package com.example.dialogcustomize02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_center = findViewById(R.id.bt_center);
        Button bt_bottom = findViewById(R.id.bt_bottom);

        bt_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoDialog(Gravity.CENTER);
            }
        });

        bt_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoDialog(Gravity.BOTTOM);
            }
        });
    }

    private void gotoDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog);

        Window window = dialog.getWindow() ;
        if(window == null) return ;
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);


        WindowManager.LayoutParams windowAttributes = window.getAttributes() ;
        windowAttributes.gravity = gravity  ;
        window.setAttributes(windowAttributes);

        if(Gravity.BOTTOM == gravity)
        {
            dialog.setCancelable(true);
        }else dialog.setCancelable(false);

        Button bt_noTKS = dialog.findViewById(R.id.bt_notks);
        Button bt_Send = dialog.findViewById(R.id.btSend);

        bt_noTKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        bt_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Send nude :)", Toast.LENGTH_SHORT).show();
            }
        });
            dialog.show();
    }
}