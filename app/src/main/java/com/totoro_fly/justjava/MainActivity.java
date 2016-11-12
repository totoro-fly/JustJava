package com.totoro_fly.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Add your package below.Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int sum = 0;
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(String.valueOf(quantityTextView.getText()));
        displayPrice(quantity * 5);
    }

    public void incerment(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(String.valueOf(quantityTextView.getText()));
        quantity++;
        display(quantity);
    }
    public void decerment(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(String.valueOf(quantityTextView.getText()));
        quantity--;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method display the given price on the screen
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayPrice(int number) {
        TextView pricetextview = (TextView) findViewById(R.id.price_text_view);
        pricetextview.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}