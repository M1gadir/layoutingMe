package com.magad.layoutingme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_username)
    TextInputEditText edtUsername;
    @BindView(R.id.edt_password)
    TextInputEditText edtPassword;
    @BindView(R.id.tv_forpas)
    TextView tvForpas;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_signup)
    Button btnSignup;

    private boolean isButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_forpas, R.id.btn_login, R.id.btn_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forpas:

                break;
            case R.id.btn_login:
                isButtonClicked = !isButtonClicked;
                view.setBackgroundResource(isButtonClicked? R.drawable.round_btn : R.drawable.round_btn);


                if (edtUsername.getText().toString().trim().length() == 0 ){
                    edtUsername.setError("jangan Kosong");
                }else if (edtPassword.getText().toString().trim().length() == 0 ){
                    edtPassword.setError("jangan Kosong");
                }else if (edtPassword.getText().length() <= 6 ) {
                    edtPassword.setError("password harus lebih dari 6 karakter");
                }else {
                    Toast.makeText(this,"intent",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_signup:
                startActivity(new Intent(MainActivity.this , RegisterActivity.class ));
                break;
        }
    }
}
