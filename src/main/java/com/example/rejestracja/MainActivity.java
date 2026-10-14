package com.example.rejestracja;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    EditText email;
    EditText password;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> sprawdz());
    }

    void sprawdz() {

        String imie = name.getText().toString().trim();
        String nazwisko = surname.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String haslo = password.getText().toString().trim();


        if (imie.isEmpty() || nazwisko.isEmpty() || mail.isEmpty() || haslo.isEmpty()) {
            Toast.makeText(this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!mail.contains("@") || !mail.contains(".")) {
            Toast.makeText(this, "Podaj poprawny adres emailc ", Toast.LENGTH_SHORT).show();
            return;
        }


        boolean duza = false;
        boolean mala = false;
        boolean specjalny = false;

        for (int i = 0; i < haslo.length(); i++) {
            char c = haslo.charAt(i);
            if (Character.isUpperCase(c)) {
                duza = true;
            } else if (Character.isLowerCase(c)) {
                mala = true;
            } else if (!Character.isDigit(c)) {
                specjalny = true;
            }
        }

        String blad = "";

        if (haslo.length() < 8) {
            blad += "min. 8 znaków,";
        }

        if (!duza) {
            blad += "duża litera,";
        }

        if (!mala) {
            blad += "mała litera,";
        }

        if (!specjalny) {
            blad += "znak specjalny,";
        }
        if (!blad.isEmpty()) {
            Toast.makeText(this, "Hasło musi mieć:" + blad, Toast.LENGTH_LONG).show();
            return;
        }


        Toast.makeText(this, "Dane są poprawne", Toast.LENGTH_SHORT).show();
    }
}