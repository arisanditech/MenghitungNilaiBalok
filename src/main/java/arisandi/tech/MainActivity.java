package arisandi.tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


    private EditText edtpanjang,edtlebar,edttinggi;
    private Button btnhitung;
    private TextView Rhasil;
//    private String parseToDouble;
    private static final String STATE_RESULT = "state_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtlebar = findViewById(R.id.edt_lebar);
        edttinggi = findViewById(R.id.edt_tinggi);
        edtpanjang = findViewById(R.id.edt_panjang);
        btnhitung = findViewById(R.id.btn_hitung);
        Rhasil = findViewById(R.id.hasil);

        btnhitung.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            Rhasil.setText(result);
        }
    }
        @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, Rhasil.getText().toString());

    }


//    public void klik (View view){
//        startActivity(new Intent(MainActivity.this,about.class));
//    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String inputLength = edtpanjang.getText().toString().trim();
            String inputWidth = edtlebar.getText().toString().trim();
            String inputHeight = edttinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtpanjang.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtlebar.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edttinggi.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double volume = Double.valueOf(inputLength) * Double.valueOf(inputWidth) * Double.valueOf(inputHeight);
                Rhasil.setText(String.valueOf(volume));
            }
        }
    }
//    private Double parseToDouble(String str) {
//        try {
//            return Double.valueOf(str);
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }
}
