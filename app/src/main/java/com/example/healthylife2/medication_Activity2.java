package com.example.healthylife2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class medication_Activity2 extends AppCompatActivity {
    CheckBox checkBoxNormal;
    CheckBox checkBoxDouble;
    Button buttonOrder;
    RadioGroup myradioGroup;
    RadioButton istype;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication2);
        buttonOrder=(Button) findViewById(R.id.btnorder);
        checkBoxNormal=(CheckBox) findViewById(R.id.cbthin);
        checkBoxDouble=(CheckBox) findViewById(R.id.cbdbcheese);
        myradioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        buttonOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                StringBuffer result=new StringBuffer();
                result.append("Your Medication topping is \n");
                if (checkBoxNormal.isChecked())
                {

                    result.append(checkBoxNormal.getText().toString()).append("\n");
                }
                if (checkBoxDouble.isChecked())
                {

                    result.append(checkBoxDouble.getText().toString()).append("\n");
                }
                int type= myradioGroup.getCheckedRadioButtonId();
                istype=(findViewById(type));
                if (istype!=null)
                {
                    result.append("\n on your ");
                    result.append(istype.getText().toString());
                    result.append("Medication ");
                }

                Toast.makeText(medication_Activity2.this,result.toString(),Toast.LENGTH_LONG).show
                        ();
            }
        });
    }
}



