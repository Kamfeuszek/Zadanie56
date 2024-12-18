package com.example.zadanie56;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView likeCounter;
    private Button addLike;
    private Button removeLike;
    private EditText email;
    private EditText password;
    private EditText repeatPassword;
    private Button saveButton;
    private Button seeMember;
    private TextView response;

    private int likes = 0;
    private String registeredUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likeCounter = findViewById(R.id.likeCounter);
        addLike = findViewById(R.id.addLike);
        removeLike = findViewById(R.id.removeLike);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repeatPassword = findViewById(R.id.repeatPassword);
        saveButton = findViewById(R.id.saveButton);
        seeMember = findViewById(R.id.seeMember);
        response = findViewById(R.id.response);

        addLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likes++;
                likeCounter.setText(likes + " polubień");
            }
        });
        removeLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likes > 0) {
                    likes--;
                    likeCounter.setText(likes + " polubień");
                }
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();
                String repeatPasswordText = repeatPassword.getText().toString().trim();
                if(!emailText.contains("@")) {
                    response.setText("Niepoprawny adres e-mail");
                    registeredUser = null;
                } else if(!passwordText.equals(repeatPasswordText)) {
                    response.setText("Hasła się różnią");
                    registeredUser = null;
                } else {
                    response.setText("Zarejestrowano: " + emailText);
                    registeredUser = emailText;
                }
            }
        });
        seeMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(registeredUser != null) {
                    response.setText(registeredUser);
                }
            }
        });
    }
}