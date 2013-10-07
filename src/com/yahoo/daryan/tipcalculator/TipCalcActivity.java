package com.yahoo.daryan.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalcActivity extends Activity {

	public EditText etTotal;
	public TextView tvTip;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);
        etTotal = (EditText) findViewById(R.id.etTotal);
        tvTip = (TextView) findViewById(R.id.tvTip);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calc, menu);
        return true;
    }
    
    public void onSubmit10(View v){
    	String fieldValue = etTotal.getText().toString();
    	
    	double transAmt = 0;
		try {
			transAmt = Double.parseDouble(fieldValue);
		} catch (NumberFormatException e) {
			tvTip.setText("Not a valid number");
			etTotal.setText("");
			return;
		}
    	double tipAmt = calcPct(transAmt, .1);
       	tvTip.setText("Tip is:  $" + tipToString(tipAmt));
        etTotal.setText("");
    }

    public void onSubmit15(View v){
    	String fieldValue = etTotal.getText().toString();
    	
    	double transAmt = 0;
		try {
			transAmt = Double.parseDouble(fieldValue);
		} catch (NumberFormatException e) {
			tvTip.setText("Not a valid number");
			etTotal.setText("");
			return;
		}
    	double tipAmt = calcPct(transAmt, .15);
       	tvTip.setText("Tip is:  $" + tipToString(tipAmt));
        etTotal.setText("");
    }

    public void onSubmit20(View v){
    	String fieldValue = etTotal.getText().toString();
    	
    	double transAmt = 0;
		try {
			transAmt = Double.parseDouble(fieldValue);
		} catch (NumberFormatException e) {
			tvTip.setText("Not a valid number");
			etTotal.setText("");
			return;
		}
    	double tipAmt = calcPct(transAmt, .2);
       	tvTip.setText("Tip is:  $" + tipToString(tipAmt));
        etTotal.setText("");
    }
   
    public double calcPct(double transAmt, double pct){
    	double tipAmt = transAmt * pct;
    	return tipAmt;
    }

    public String tipToString(double tipAmt){
       	DecimalFormat df = new DecimalFormat("#.00");
        return df.format(tipAmt);  	
    }
    
    
}
