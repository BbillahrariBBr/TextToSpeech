package com.example.bakibillah.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech txttoSppech;
    EditText eT;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);

        txttoSppech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status!= TextToSpeech.ERROR){
                    txttoSppech.setLanguage(Locale.ENGLISH);
                }


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  tospeake = eT.getText().toString();
                Toast.makeText(getApplicationContext(),tospeake,Toast.LENGTH_LONG).show();
                txttoSppech.speak(tospeake,TextToSpeech.QUEUE_FLUSH,null);
                //txttoSppech.speak(tospeake,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    public void onPause(){
        if (txttoSppech!= null){
            txttoSppech.stop();
            txttoSppech.shutdown();
        }
        super.onPause();
    }

}
