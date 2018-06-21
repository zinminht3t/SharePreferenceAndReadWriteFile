package me.zinminhtet.sharepreferenceandreadwritefile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreInstance(savedInstanceState);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                setTextView();
            }
        });
    }

    void setTextView(){
        TextView tv = findViewById(R.id.textView);
        tv.setText(String.valueOf(count));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Count", count);
    }

    void restoreInstance(Bundle state) {
        if (state != null) {
            count = state.getInt("Count");
            setTextView();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:
                startActivity(new Intent(this, MyPreferencesActivity.class));
                return (true);
            case R.id.option2:
                startActivity(new Intent(this, MyPreferenceActivity.class));
                return (true);
            case R.id.option3:
                startActivity(new Intent(this, ReadWriteFile.class));
                return (true);
            case R.id.option4:
//                startActivity(new Intent(this, ReadWriteStorage.class));
                return (true);
            case R.id.option5:
//                startActivity(new Intent(this, MyNetworkActivity.class));
                return (true);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
