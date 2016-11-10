package com.totoro_fly.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
        *Add your package below.Package name can be found in the project's AndroidManifest.xml file.
        *This is the package name our example uses:
        *
        *package com.example.android.justjava;
        */

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int sum=0;
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView quantityTextView= (TextView) findViewById(R.id.quantity_text_view);
        int a= Integer.parseInt(String.valueOf(quantityTextView.getText()));
        a++;
        display(a);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}