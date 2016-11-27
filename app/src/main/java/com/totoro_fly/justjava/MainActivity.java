package com.totoro_fly.justjava;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
    EditText nameEditText;
    CheckBox whippedCreamCheckBox;
    CheckBox chocolateCheckBox;
    TextView submitTextView;
    TextView quantityTextView;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        submitTextView = (TextView) findViewById(R.id.order_summary_text_view);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
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
        quantityTextView.setText(String.valueOf(number));
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {
        String priceMessage = createOrderSummary();
        dispalyMessage(priceMessage);
    }

    private String createOrderSummary() {
        String priceMessage = "Name:" + getName();
        priceMessage = priceMessage + "\nAdd whipped cream? " + hasWhippedCream();
        priceMessage = priceMessage + "\nAdd chocolate? " + haschocolate();
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal:$ " + calculatePrice();
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    private String getName() {
        return nameEditText.getText().toString();
    }

    private boolean hasWhippedCream() {
        return whippedCreamCheckBox.isChecked();
    }

    private boolean haschocolate() {
        return chocolateCheckBox.isChecked();
    }

    private int calculatePrice() {
        int basePrice=5;
        if(hasWhippedCream())
            basePrice++;
        if(haschocolate())
            basePrice=basePrice+2;
        int price = quantity * basePrice;
        return price;
    }

    private void dispalyMessage(String Message) {
        submitTextView.setText(Message);
    }


}