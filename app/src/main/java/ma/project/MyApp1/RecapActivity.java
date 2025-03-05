package ma.project.MyApp1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class    RecapActivity extends AppCompatActivity {

    private TextView ERecap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_recap);

        ERecap = findViewById(R.id.ERecap);

        String Nom = getIntent().getStringExtra("Nom");
        String Email = getIntent().getStringExtra("Email");
        String Phone = getIntent().getStringExtra("Phone");
        String Adress = getIntent().getStringExtra("Adress");
        String Ville = getIntent().getStringExtra("Ville");

        String recap = "Nom : " + Nom + "\n" +
                "Email : " + Email + "\n" +
                "Phone : " + Phone + "\n" +
                "Adresse : " + Adress + "\n" +
                "Ville : " + Ville ;


        ERecap.setText(recap);
    }

}
