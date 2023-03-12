package com.mmjang.ankihelper.ui.translation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

import com.mmjang.ankihelper.R;
import com.mmjang.ankihelper.data.Settings;

public class CustomTranslationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Settings settings = Settings.getInstance(this);
        setContentView(R.layout.activity_custom_translation);
        if(Settings.getInstance(this).getPinkThemeQ()){
            setTheme(R.style.AppThemePink);
        }else{
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_custom_translation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView introduction = findViewById(R.id.textview_custom_translation_introduction);
        introduction.setMovementMethod(LinkMovementMethod.getInstance());

        EditText apiKey = findViewById(R.id.edittext_mstranslate_key);
        EditText apiRegion = findViewById(R.id.edittext_mstranslate_region);

        apiKey.setText(settings.getUserMstranslateKey());
        apiRegion.setText(settings.getUserMstranslateRegion());

        apiKey.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        settings.setUserMstranslateKey(charSequence.toString().trim());
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );

        apiRegion.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        settings.setUserMstranslateRegion(charSequence.toString().trim());
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );
    }
}
