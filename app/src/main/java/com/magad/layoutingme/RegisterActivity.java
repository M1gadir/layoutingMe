package com.magad.layoutingme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edt_firnam)
    TextInputEditText edtFirnam;
    @BindView(R.id.edt_lasnam)
    TextInputEditText edtLasnam;
    @BindView(R.id.edt_emreg)
    TextInputEditText edtEmreg;
    @BindView(R.id.edt_nohp)
    TextInputEditText edtNohp;
    @BindView(R.id.edt_pasreg)
    TextInputEditText edtPasreg;
    @BindView(R.id.edt_retpasreg)
    TextInputEditText edtRetpasreg;
    @BindView(R.id.rb_ml)
    RadioButton rbMl;
    @BindView(R.id.rb_fml)
    RadioButton rbFml;
    @BindView(R.id.spin_reggis)
    Spinner spinReggis;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.tv_alred)
    TextView tvAlred;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private String[] listkota = {
            "-pilih-","Jakarta","Banten","Semarang","Kalimantan","Bogor","MeiKarta","Bekasi","Jonggol","Mars","Jupiter"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        spinReggis = findViewById(R.id.spin_reggis);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listkota);

        spinReggis.setAdapter(adapter);
        spinReggis.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    @OnClick({R.id.btn_signup, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signup:


                if (edtFirnam.getText().toString().trim().length() == 0 ) {
                    edtFirnam.setError("nama depan jangan Kosong");
                }else if (edtFirnam.getText().length() <= 3 ) {
                        edtFirnam.setError("Nama depan harus lebih dari 3 karakter");
                }else if (edtLasnam.getText().toString().trim().length() == 0 ) {
                    edtLasnam.setError("nama belakang jangan Kosong");
                }else if (edtLasnam.getText().length() <= 3 ) {
                        edtLasnam.setError("nama belakang harus lebih dari 3 karakter");
                }else if (edtEmreg.getText().toString().trim().length() == 0 ) {
                    edtEmreg.setError("Email jangan Kosong");
                }else if (edtNohp.getText().toString().trim().length() == 0 ) {
                    edtNohp.setError("no hp jangan Kosong");
                }else if (edtNohp.getText().length() <= 6 ) {
                    edtNohp.setError("no hp harus 13 angka");
                }else if (edtPasreg.getText().toString().trim().length() == 0 ) {
                    edtPasreg.setError("password jangan Kosong");
                }else if (edtPasreg.getText().length() <= 8 ) {
                    edtPasreg.setError("password harus lebih dari 8 karakter");
                }else if (edtRetpasreg.getText().toString().trim().length() == 0 ) {
                    edtRetpasreg.setError("jangan Kosong");
                }else if (edtRetpasreg.getText() != edtPasreg ) {
                    edtRetpasreg.setError("Password Tidak Sama");
                }else if (rbMl.isChecked()) {
                    Toast.makeText(this, "Laki Laki", Toast.LENGTH_SHORT).show();
                }else if (rbFml.isChecked()) {
                    Toast.makeText(this, "Laki Laki", Toast.LENGTH_SHORT).show();
                }else {

                }




                break;
            case R.id.btn_login:
                startActivity(new Intent(RegisterActivity.this , MainActivity.class ));
                break;
        }
    }
}
