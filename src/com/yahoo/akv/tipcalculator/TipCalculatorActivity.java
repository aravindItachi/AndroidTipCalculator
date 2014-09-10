package com.yahoo.akv.tipcalculator;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tipcalculator.R;

public class TipCalculatorActivity extends Activity {

	private EditText amount;
	private TextView tip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		amount = (EditText) findViewById(R.id.amount);
		tip = (TextView) findViewById(R.id.finaltip);
	}

	public void tipPercClicked(View v) {
		
		if (!amount.getText().toString().isEmpty()) {
			this.tip.setText("");
			Button tipClicked = (Button) v;
			Integer tipperc = Integer.parseInt(tipClicked.getText().toString()
					.substring(0, tipClicked.getText().length() -1));
			Float totamount = Float.parseFloat(amount.getText().toString());
			System.out.println("TIP Perc "+tipperc);
			System.out.println("Total amount "+totamount);
			Float tip = totamount * (float)((double)tipperc/100.0);
			System.out.println("Tip amount "+tip);
			BigDecimal bd = new BigDecimal(Float.toString(tip));
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			tip = bd.floatValue();
			this.tip.setText(Float.toString(tip));
			
		}

	}

}
