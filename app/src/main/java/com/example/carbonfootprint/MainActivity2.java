package com.example.carbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
private RadioGroup radioGrouptransportation;
private Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        radioGrouptransportation=findViewById(R.id.radioGroup);
        buttonNext=findViewById(R.id.btn_1);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=radioGrouptransportation.getCheckedRadioButtonId();
                RadioButton selectedRadioButton=findViewById(selectedId);
                String transportationChoice=selectedRadioButton.getText().toString();

                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("transportation_choice",transportationChoice);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onRadioButtonClicked(View view) {
    }
}