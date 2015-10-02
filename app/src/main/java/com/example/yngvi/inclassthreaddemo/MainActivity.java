package com.example.yngvi.inclassthreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView m_textView;

    Runnable m_runnable = new Runnable() {
        @Override
        public void run() {
          doWorkAndUpdateCounter();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_textView = (TextView) findViewById( R.id.text );

        // Take 1
        doWorkAndUpdateCounter();

        // Take 2
        //m_runnable.run();

        // Take 3
        //m_textView.post( m_runnable );

        // Take 4
        //m_textView.postDelayed( m_runnable, 100 );

        // Take 5
        // ... we need?
    }

    // Simulating some computing extensive work.
    void work( int sec ) {
        try {
            Thread.sleep( 1000 * sec );
        }
        catch ( Exception e ) {

        }
    }

    void updateCounter() {
        Integer number =  Integer.parseInt(m_textView.getText().toString());
        number = number + 1;
        m_textView.setText( number.toString() );
    }

    void doWorkAndUpdateCounter() {
        work( 20 );
        updateCounter();
    }

}
