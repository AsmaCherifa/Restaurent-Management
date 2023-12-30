package com.jovanovic.stefan.restaurant;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.jovanovic.stefan.restaurant.R;

public class signUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            ToggleButton tb = (ToggleButton) findViewById(R.id.toggleButton);
            Button createBtn = (Button) findViewById(R.id.createBtn);
            tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Toast msg = Toast.makeText(getBaseContext(), "YOU WILL GET NOTIFICATIONS ON THIS EMAIL", Toast.LENGTH_SHORT);
                        msg.show();

                    }
                }
            });
//spinner
            Spinner spinner = findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(signUp.this);


            //Button
            createBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText user = (EditText) findViewById(R.id.name);
                    EditText pass = (EditText) findViewById(R.id.pwd);
                    EditText email = (EditText) findViewById(R.id.email);
                    RadioGroup radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int selectedId = radioSexGroup.getCheckedRadioButtonId();
                    RadioButton radioSexButton = (RadioButton) findViewById(selectedId);

                    MyDatabaseHelper db = new MyDatabaseHelper(signUp.this);
                    Boolean insert = db.insertData(user.getText().toString(), pass.getText().toString());
                    if (insert == true) {
                        Toast.makeText(getBaseContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(signUp.this, MainActivity.class);
                        startActivity(i); } }});}

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
