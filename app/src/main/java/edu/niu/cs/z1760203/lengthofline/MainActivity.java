package edu.niu.cs.z1760203.lengthofline;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {


    EditText EtX1,
             EtX2,
             EtY1,
             EtY2;

    TextView ResultTV1,
             ResultTV2;

    Double x1,
           x2,
           y1,
           y2,
           midPoint1,
            midPoint2,
           length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtX1 = (EditText)findViewById(R.id.editTextX1);
        EtX2 = (EditText)findViewById(R.id.editTextX2);
        EtY1 = (EditText)findViewById(R.id.editTextY1);
        EtY2 = (EditText)findViewById(R.id.editTextY2);
        ResultTV1 = (TextView)findViewById(R.id.textViewMid);
        ResultTV2 = (TextView)findViewById(R.id.textViewLen);

        Button calButton = (Button)findViewById(R.id.cal);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(EtX1.getText().toString().matches("") ||
                        EtX2.getText().toString().matches("") ||
                            EtY1.getText().toString().matches("") ||
                                EtY2.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "Cannot have an empty field", Toast.LENGTH_LONG).show();
                    return;
                }


                x1 = Double.parseDouble(EtX1.getText().toString());
                x2 = Double.parseDouble(EtX2.getText().toString());
                y1 = Double.parseDouble(EtY1.getText().toString());
                y2 = Double.parseDouble(EtY2.getText().toString());

                midPoint1 = ((x1 + x2)/2);

                midPoint2 = ((y1 + y2)/2);

                length = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));

                DecimalFormat df = new DecimalFormat("0.00");

                ResultTV1.setText(df.format(midPoint1).toString() + "," + df.format(midPoint2).toString());

                ResultTV2.setText(df.format(length).toString());

            }
        });


        //To clear the inputs

        Button clearBtn = (Button)findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EtX1.setText("");
                EtX2.setText("");
                EtY1.setText("");
                EtY2.setText("");
                ResultTV1.setText("");
                ResultTV2.setText("");
            }
        });



    }
}
