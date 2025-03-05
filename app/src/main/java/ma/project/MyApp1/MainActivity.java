package ma.project.MyApp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nom, phone, email, adress;
    private Button bn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        adress = findViewById(R.id.adress);
        bn = findViewById(R.id.bn);
        Spinner spinner = findViewById(R.id.spinner);

        String[] options = {"Marrakech", "Rabat", "Casa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        bn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String Nom = nom.getText().toString();
                String Phone = phone.getText().toString();
                String Email = email.getText().toString();
                String Adress = adress.getText().toString();
                String Ville = spinner.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, RecapActivity.class);
                intent.putExtra("Nom", Nom);
                intent.putExtra("Phone", Phone);
                intent.putExtra("Email", Email);
                intent.putExtra("Adress", Adress);
                intent.putExtra("Ville", Ville);

                startActivity(intent);
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}