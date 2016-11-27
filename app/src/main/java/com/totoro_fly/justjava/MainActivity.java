package com.totoro_fly.justjava;

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
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void incermentButton(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decermentButton(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }
    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {
//        displayPrice(quantity * 5);
        String priceMessage = createOrderSummary();
        dispalyMessage(priceMessage);
    }
    private String createOrderSummary() {
        String priceMessage = "Name:KK";
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal:$ " + calculatePrice();
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private void dispalyMessage(String Message) {
        TextView textView = (TextView) findViewById(R.id.order_summary_text_view);
        textView.setText(Message);
    }


}