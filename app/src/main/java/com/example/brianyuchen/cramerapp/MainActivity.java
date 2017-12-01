package com.example.brianyuchen.cramerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText etX;
    EditText etY;
    EditText etZ;
    EditText eta1;
    EditText eta2;
    EditText eta3;
    EditText etb1;
    EditText etb2;
    EditText etb3;
    EditText etc1;
    EditText etc2;
    EditText etc3;
    EditText etd1;
    EditText etd2;
    EditText etd3;
    TextView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eta1 = (EditText) findViewById(R.id.ia1);
        eta2 = (EditText) findViewById(R.id.ia2);
        eta3 = (EditText) findViewById(R.id.ia3);
        etb1 = (EditText) findViewById(R.id.ib1);
        etb2 = (EditText) findViewById(R.id.ib2);
        etb3 = (EditText) findViewById(R.id.ib3);
        etc1 = (EditText) findViewById(R.id.ic1);
        etc2 = (EditText) findViewById(R.id.ic2);
        etc3 = (EditText) findViewById(R.id.ic3);
        etd1 = (EditText) findViewById(R.id.id1);
        etd2 = (EditText) findViewById(R.id.id2);
        etd3 = (EditText) findViewById(R.id.id3);

        etX = (EditText) findViewById(R.id.X);
        etY = (EditText) findViewById(R.id.Y);
        etZ = (EditText) findViewById(R.id.Z);
        show = (TextView) findViewById(R.id.showMsg);
        Button btn1 = (Button) findViewById(R.id.sol_btn);


       // Button solBtn = (Button)findViewById(R.id.solbtn);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int a1 = Integer.parseInt(eta1.getText().toString());
                int a2 = Integer.parseInt(eta2.getText().toString());
                int a3 = Integer.parseInt(eta3.getText().toString());
                int b1 = Integer.parseInt(etb1.getText().toString());
                int b2 = Integer.parseInt(etb2.getText().toString());
                int b3 = Integer.parseInt(etb3.getText().toString());
                int c1 = Integer.parseInt(etc1.getText().toString());
                int c2 = Integer.parseInt(etc2.getText().toString());
                int c3 = Integer.parseInt(etc3.getText().toString());
                int d1 = Integer.parseInt(etd1.getText().toString());
                int d2 = Integer.parseInt(etd2.getText().toString());
                int d3 = Integer.parseInt(etd3.getText().toString());

                int delta = ((a1 * b2 * c3) + (b1 * c2 * a3) + (c1 * a2 * b3)) - ((c1 * b2 * a3) + (a1 * c2 * b3) + (b1 * a2 * c3));
                int deltaX = ((d1 * b2 * c3) + (b1 * c2 * d3) + (c1 * d2 * b3)) - ((c1 * b2 * d3) + (d1 * c2 * b3) + (b1 * d2 * c3));
                int deltaY = ((a1 * d2 * c3) + (d1 * c2 * a3) + (c1 * a2 * d3)) - ((c1 * d2 * a3) + (a1 * c2 * d3) + (d1 * a2 * c3));
                int deltaZ = ((a1 * b2 * d3) + (b1 * d2 * a3) + (d1 * a2 * b3)) - ((d1 * b2 * a3) + (a1 * d2 * b3) + (b1 * a2 * d3));

                if (delta != 0) {
                    float X = (float) deltaX / delta;
                    float Y = (float) deltaY / delta;
                    float Z = (float) deltaZ / delta;
//                    int tmp = Integer.parseInt(a1.getText().toString());
                    etX.setText(X + "");
                    etY.setText(Y + "");
                    etZ.setText(Z + "");
                    show.setText("恰有一解");


                } else if(delta == 0 && (deltaX != 0 || deltaY != 0 || deltaZ != 0)) {
                    show.setText("無解");
                    etX.setText("");
                    etY.setText("");
                    etZ.setText("");
                }
                else if(delta == 0 && deltaX == 0 && deltaY == 0 && deltaZ ==0) {

                    if(((a1*b2 - a2*b1) == 0 || (b2*a3 - b3*a2) == 0)) {
                        show.setText("無解");
                        etX.setText("");
                        etY.setText("");
                        etZ.setText("");
                    } else {
                        // X = ?? del Y
                        // (a1*b2 - a2*b1) >> A_T
                        // (c1*b2 - c2*b1) >> C_T
                        // (d1*b2 - d2*b1) >> D_T
                        // X = (D_T / A_T) - (C_T / A_T)
                        // Y = ?? del X
                        // (b2*a3 - b3*a2) >> B_T
                        // (d2*a3 - d3*a2) >> D_T
                        // (c2*a3 - c3*a2) >> C_T
                        // Y = (D_T / B_T) - (C_T / B_T)
                        float X_var = ((float) (d1 * b2 - d2 * b1) / (a1 * b2 - a2 * b1));
                        float X_t = ((float) (-(c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1))); // add minus
                        float Y_var = ((float) (d2 * a3 - d3 * a2) / (b2 * a3 - b3 * a2));
                        float Y_t = ((float) (-(c2 * a3 - c3 * a2) / (b2 * a3 - b3 * a2)));
                        if (X_t >= 0) {
                            etX.setText(X_var + "+" + X_t + "t");
                        } else {
                            etX.setText(X_var + "" + X_t + "t");
                        }
                        if (Y_t >= 0) {
                            etY.setText(Y_var + "+" + Y_t + "t");
                        } else {
                            etY.setText(Y_var + "" + Y_t + "t");
                        }
                        etZ.setText("t");
                        show.setText("無限多組解, t為實數");

                    }
                }

            }

        });


    }
}
