package serkan.com.yazitosesders;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    EditText sayi1,sayi2;
    TextView txt1;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayi1=(EditText)findViewById(R.id.editText);
        sayi2=(EditText)findViewById(R.id.editText2);
        txt1=(TextView)findViewById(R.id.textView);
        sayi1.requestFocus();

        tts=new TextToSpeech(this,this);
        tts.setLanguage(new Locale("tr","TR"));

        txt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                konus();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void onInit(int status) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        tts.stop();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        tts.stop();
        finishAffinity();
    }

    public void konus(){

        tts.speak(sayi1.getText().toString()+"artı"+sayi2.getText().toString()+"nin toplamı"+txt1.getText().toString(),TextToSpeech.QUEUE_ADD,null);
    }

    public  void topla(View view){
        int topla=Integer.valueOf(sayi1.getText().toString())+Integer.valueOf(sayi2.getText().toString());
        txt1.setText(String.valueOf(topla));
    }
}
