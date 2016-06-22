package gcascade.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button newGame = (Button)findViewById(R.id.button2);
        Button cont = (Button)findViewById(R.id.button3);
        Button options = (Button)findViewById(R.id.button4);
        setContentView(R.layout.activity_menu);
        newGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Menu.this, Battle.class);
        startActivity(intent);
    }
}
