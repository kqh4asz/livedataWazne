package com.example.prostaappka;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button dodaj,odejmij,wylosuj;
    EditText wpiszNumer;
    private LicznikHandling licznikHandling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dodaj = findViewById(R.id.dodaj);
        odejmij = findViewById(R.id.odejmij);
        wylosuj = findViewById(R.id.randomNumer);
        wpiszNumer = findViewById(R.id.numerEdycja);


        licznikHandling = new ViewModelProvider(this).get(LicznikHandling.class);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                wpiszNumer.setText(integer.toString());
            }
        };
        licznikHandling.getLicznik().observe(this, integerObserver);
        wylosuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int randomNumber = random.nextInt(99) + 1;
                licznikHandling.setLicznik(randomNumber);
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            licznikHandling.dodajDoLicznika(1);

            }
        });

        odejmij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                licznikHandling.dodajDoLicznika(-1);

            }
        });
        wpiszNumer.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (wpiszNumer.length() != 0) {
                    licznikHandling.setLicznik(Integer.valueOf(wpiszNumer.getText().toString()));
                }
                else {
                    licznikHandling.setLicznik(0);
                }
            }
        });
    }

}