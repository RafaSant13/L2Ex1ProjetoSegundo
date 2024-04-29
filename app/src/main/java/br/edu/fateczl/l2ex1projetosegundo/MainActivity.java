package br.edu.fateczl.l2ex1projetosegundo;

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

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView tvDelta;
    private TextView tvRaiz1;
    private TextView tvRaiz2;



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

        etA = findViewById(R.id.etA);
        etA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        tvDelta = findViewById(R.id.tvDelta);
        tvDelta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRaiz1 = findViewById(R.id.tvRaiz1);
        tvRaiz1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRaiz2 = findViewById(R.id.tvRaiz2);
        tvRaiz2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        double a = Double.parseDouble(etA.getText().toString());
        double b = Double.parseDouble(etB.getText().toString());
        double c = Double.parseDouble(etC.getText().toString());
        if (a==0){
            String res = getString(R.string.nao_eh_segundo);
           tvDelta.setText(res);
        }
        else{
            double delta = (Math.pow(b, 2) - (4 * a * c));
            if (delta<0){
                String res = getString(R.string.nao_possui_raizes);
                tvDelta.setText(res);
                tvRaiz1.setText("");
                tvRaiz2.setText("");
            }
            else{
                double x1 =  (((b * (-1)) + (Math.sqrt(delta)))/(2*a));
                double x2 =  (((b * (-1)) - (Math.sqrt(delta)))/(2*a));

                String res = getString(R.string.delta) + delta;
                String res1 = getString(R.string.x1) + x1;
                String res2 = getString(R.string.x2) + x2;

                tvDelta.setText(res);
                tvRaiz1.setText(res1);
                tvRaiz2.setText(res2);
            }
        }
    }
}