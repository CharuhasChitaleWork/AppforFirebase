package test.example.charuhaschitale.appforfirebase;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.text.DateFormat;
import java.util.Date;


public class screen12 extends AppCompatActivity {
    Button purchase,back;


    TextView ca,na,br,pr;
    Bundle bundle ;
    String cat,name,brand,str,p,toastt;
    Double price,value=0.0;
    Long Quan;
    int d;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen12);
        bundle = getIntent().getExtras();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ca = (TextView) findViewById(R.id.cat);
        na = (TextView) findViewById(R.id.name);
        br = (TextView) findViewById(R.id.brand);
        pr = (TextView) findViewById(R.id.price);
        cat = bundle.getString(FirebaseAnalytics.Param.ITEM_CATEGORY);
        name= bundle.getString(FirebaseAnalytics.Param.ITEM_NAME);
        //brand= bundle.getString(FirebaseAnalytics.Param.ITEM_BRAND);
        Quan = bundle.getLong(FirebaseAnalytics.Param.QUANTITY);
        price= bundle.getDouble(FirebaseAnalytics.Param.PRICE);
        p= price.toString();
        purchase = (Button) findViewById(R.id.buttonpurchase);
        brand = Quan.toString();
        back = (Button) findViewById(R.id.backButton);
        ca.setText(cat);
        na.setText(name);
        br.setText(brand);
        pr.setText(p);
        value = Quan*price;

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivypurchase();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivityback();
            }
        });
       // str= UUID.randomUUID().toString();
        str = DateFormat.getDateTimeInstance().format(new Date());
      /* Random r = null;
        d= r.nextInt((99999 - 10000) + 1) + 10000;
        str= Integer.toString(d);
        */
        Bundle screenParam = new Bundle();
        screenParam.putString("ScreenName","Screen12:purchase");
        mFirebaseAnalytics.logEvent("Page",screenParam);
        Bundle param2 = new Bundle();
        param2.putString(FirebaseAnalytics.Param.CHECKOUT_STEP,"3");
        mFirebaseAnalytics.logEvent("Step",param2);
        toastt="Trans_id :"+str+" || quantity :"+brand+" || value :"+value.toString();
        //toastt=str.concat(brand).concat(value.toString());
    }




    private void acitivypurchase() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.COUPON,"NewUser");
        bundle.putString(FirebaseAnalytics.Param.TRANSACTION_ID,str);
        bundle.putDouble(FirebaseAnalytics.Param.TAX,180.00);
        bundle.putString(FirebaseAnalytics.Param.CURRENCY,"INR");
        bundle.putDouble(FirebaseAnalytics.Param.SHIPPING,30.00);
        bundle.putDouble(FirebaseAnalytics.Param.PRICE,value);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE,bundle);
        Toast.makeText(getApplicationContext(), toastt,
                Toast.LENGTH_LONG).show();
        Bundle but = new Bundle();
        but.putString("ButtonName","Button_Purchase");
        but.putString("Screen","Screen12");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        finish();
    }

    private void acitivityback() {
        Bundle param = new Bundle();
        param.putString("Nav_From","screen12");
        param.putString("Nav_To","screen11");
        mFirebaseAnalytics.logEvent("Navigate",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Back");
        but.putString("Screen","Screen12");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        finish();
        //Intent intent= new Intent(this,screen11.class);
       // startActivity(intent);
    }
}
