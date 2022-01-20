package com.swipeupwindowandbottomsheetdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    //Initial
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.bt_show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create Bottom Sheet Dialo
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                EditText etUsername = bottomSheetDialog.findViewById(R.id.et_username);
                EditText etPasswrt = bottomSheetDialog.findViewById(R.id.et_password);
                Button btSubmit = bottomSheetDialog.findViewById(R.id.bt_submit);

                btSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Set Verfication
                        if (etUsername.getText().toString().equals("admin") &&
                            etPasswrt.getText().toString().equals("admin")){

                            //On Success

                            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                            builder.setTitle("Login Successful");
                            builder.setMessage("Welcome to Android ");

                            builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();



                        }else {
                            Toast.makeText(view.getContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //Show BottonSheetDialog
                bottomSheetDialog.show();

            }
        });

    }
}