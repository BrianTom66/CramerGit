package com.example.brianyuchen.cramerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText etans;
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

//    EditText eta2 = (EditText) findViewById(R.id.ia2);
//    EditText eta3 = (EditText) findViewById(R.id.ia3);
//    EditText etb1 = (EditText) findViewById(R.id.ib1);
//    EditText etb2 = (EditText) findViewById(R.id.ib2);
//    EditText etb3 = (EditText) findViewById(R.id.ib3);
//    EditText etc1 = (EditText) findViewById(R.id.ic1);
//    EditText etc2 = (EditText) findViewById(R.id.ic2);
//    EditText etc3 = (EditText) findViewById(R.id.ic3);
//    EditText etd1 = (EditText) findViewById(R.id.id1);
//    EditText etd2 = (EditText) findViewById(R.id.id2);
//    EditText etd3 = (EditText) findViewById(R.id.id3);

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

        etans = (EditText) findViewById(R.id.ans1);
        Button btn1 = (Button) findViewById(R.id.sol_btn);



//        final int a2 = Integer.parseInt(eta2.getText().toString());
//        final int a3 = Integer.parseInt(eta3.getText().toString());
//        final int b1 = Integer.parseInt(etb1.getText().toString());
//        final int b2 = Integer.parseInt(etb2.getText().toString());
//        final int b3 = Integer.parseInt(etb3.getText().toString());
//        final int c1 = Integer.parseInt(etc1.getText().toString());
//        final int c2 = Integer.parseInt(etc2.getText().toString());
//        final int c3 = Integer.parseInt(etc3.getText().toString());
//        final int d1 = Integer.parseInt(etd1.getText().toString());
//        final int d2 = Integer.parseInt(etd2.getText().toString());
//        final int d3 = Integer.parseInt(etd3.getText().toString());



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
//                int deltaY = ((a1 * d2 * c3) + (d1 * c2 * a3) + (c1 * a2 * d3)) - ((c1 * d2 * a3) + (a1 * c2 * d3) + (d1 * a2 * c3));
//                int deltaZ = ((a1 * b2 * d3) + (b1 * d2 * a3) + (d1 * a2 * b3)) - ((d1 * b2 * a3) + (a1 * d2 * b3) + (b1 * a2 * d3));

                if (delta != 0) {
                    float X = deltaX / delta;
//                    float Y = deltaY/delta;
//                    float Z = deltaZ/delta;
//                    int tmp = Integer.parseInt(a1.getText().toString());
                    etans.setText(X + "");


//                } else if(delta == 0 && (deltaX != 0 || deltaY != 0 || deltaZ != 0)) {
//                    etans.setText("無解");
//                }
                }
            }

        });


    }
}
