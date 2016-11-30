package com.totoro_fly.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

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
    Button nameButton;
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
        nameButton = (Button) findViewById(R.id.name_button);
    }

    public void nameClick(View view) {
        nameEditText.clearFocus();
        nameButton.setFocusable(true);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(nameButton.getWindowToken(), 0);
    }

    public void incermentButton(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, R.string.activity_main_java_不能点单超过100杯, Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }

    public void decermentButton(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, R.string.activity_main_java_请至少点1杯, Toast.LENGTH_SHORT).show();
            return;
        }
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void emailClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.activity_main_java_邮件地址)});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.activity_main_java_邮件主题) + name);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String createOrderSummary() {
        String priceMessage = getString(R.string.activity_main_java_create_order_summary, getName(), String.valueOf(hasWhippedCream()), String.valueOf(haschocolate()), String.valueOf(quantity), NumberFormat.getInstance().format(calculatePrice()));
//        String priceMessage = "Name:" + getName();
//        priceMessage = priceMessage + "\nAdd whipped cream? " + hasWhippedCream();
//        priceMessage = priceMessage + "\nAdd chocolate? " + haschocolate();
//        priceMessage = priceMessage + "\nQuantity: " + quantity;
//        priceMessage = priceMessage + "\nTotal: " + NumberFormat.getCurrencyInstance().format(calculatePrice());
//        priceMessage = priceMessage + "\nThank you!";
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
        int basePrice = 5;
        if (hasWhippedCream())
            basePrice++;
        if (haschocolate())
            basePrice = basePrice + 2;
        int price = quantity * basePrice;
        return price;
    }

    private void dispalyMessage(String Message) {
        submitTextView.setText(Message);
    }


}