package cat.itb.testingexercice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button nextButton;
    EditText username;
    EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton = findViewById(R.id.botonTest);
        username = findViewById(R.id.userEditText);
        password = findViewById(R.id.passwordEditText);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                String usernameText = username.getText().toString();
                i.putExtra("username",usernameText);
                startActivity(i);
            }
        });
    }
}