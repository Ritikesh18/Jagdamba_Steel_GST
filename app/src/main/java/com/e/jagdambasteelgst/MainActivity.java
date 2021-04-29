package com.e.jagdambasteelgst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView txt_gst_amount,txt_total_amount,txt_cgst_amount,txt_sgst_amount;
    EditText txt_amount,txt_gst_percent;
    Button btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_amount=findViewById(R.id.txt_amount);
        txt_gst_amount=findViewById(R.id.txt_gst_amount);
        txt_cgst_amount=findViewById(R.id.txt_cgst_amount);
        txt_sgst_amount=findViewById(R.id.txt_sgst_amount);
        txt_gst_percent=findViewById(R.id.txt_gst_percent);
        txt_total_amount=findViewById(R.id.txt_total_amount);
        btn_calculate=findViewById(R.id.btn_calculate);

        DecimalFormat currency=new DecimalFormat("###,###.##");


        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float total=Float.parseFloat(txt_amount.getText().toString());
                float gst_percent=Float.parseFloat(txt_gst_percent.getText().toString());
                float gst_amount=  (total -(total*100/(100+gst_percent)));
                txt_gst_amount.setText("GST Amount is : "+currency.format( gst_amount));
                txt_sgst_amount.setText("SGST Amount is: "+currency.format(gst_amount/2));
                txt_cgst_amount.setText("CGST Amount is : "+currency.format(gst_amount/2));

                float total_amount = total - gst_amount;
                txt_total_amount.setText("The net total amount : "+currency.format(total_amount));

            }
        });

    }

}
