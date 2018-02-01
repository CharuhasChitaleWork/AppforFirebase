package test.example.charuhaschitale.appforfirebase;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

import java.util.Random;

public class screen11 extends AppCompatActivity {
    Button buy1,buy2,buy3,buy4,back;
    int i;
    private static final String TAG = "screen11";
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen11);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        buy1 = (Button) findViewById(R.id.buy1);
        buy2 = (Button) findViewById(R.id.buy2);
        buy3 = (Button) findViewById(R.id.buy3);
        buy4 = (Button) findViewById(R.id.buy4);

        back =(Button) findViewById(R.id.backButton);
        Bundle paramb = new Bundle();
        paramb.putString(FirebaseAnalytics.Param.CHECKOUT_STEP,"2");
        mFirebaseAnalytics.logEvent("Step",paramb);

        buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall1();

            }
        });
        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall2();

            }
        });
        buy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall3();

            }
        });
        buy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall4();

            }
        });
       // Random r = new Random() ;
        //i= r.nextInt(15)+1;
        Bundle screenParam = new Bundle();
        screenParam.putString("ScreenName","Screen11:products");
        mFirebaseAnalytics.logEvent("Page",screenParam);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               acitivityback();
           }
       });

        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                        Uri deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();
                            Toast.makeText(getApplicationContext(), deepLink.toString(), Toast.LENGTH_SHORT).show();
                        }
                       // Toast.makeText(getApplicationContext(), "Link Worked! screen11", Toast.LENGTH_SHORT).show();
                        // Handle the deep link. For example, open the linked
                        // content, or apply promotional credit to the user's
                        // account.
                        // ...

                        // ...
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "getDynamicLink:onFailure", e);
                    }
                });
    }



    private void acitivitycall2() {
        Random r = new Random() ;
        i= r.nextInt(15)+1;
        Bundle param = new Bundle();
        param.putString(FirebaseAnalytics.Param.ITEM_CATEGORY,"Footwear");
        param.putString(FirebaseAnalytics.Param.ITEM_NAME," WoodLand Flips Brown");
        //param.putString(FirebaseAnalytics.Param.ITEM_BRAND,"WoodLand");
        param.putDouble(FirebaseAnalytics.Param.PRICE,225);
        param.putString(FirebaseAnalytics.Param.ITEM_ID,"2");
        param.putLong(FirebaseAnalytics.Param.QUANTITY,i);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_TO_CART,param);
        Toast.makeText(getApplicationContext(), "id:2", Toast.LENGTH_SHORT).show();
        Bundle but = new Bundle();
        but.putString("ButtonName","Buy2_footware");
        but.putString("Screen","Screen11");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen12.class);
        intent.putExtras(param);
        startActivity(intent);
    }
    private void acitivitycall3() {
        Random r = new Random() ;
        i= r.nextInt(15)+1;
        Bundle param = new Bundle();
        Bundle paramb = new Bundle();
        param.putString(FirebaseAnalytics.Param.ITEM_CATEGORY,"Bags");
        param.putString(FirebaseAnalytics.Param.ITEM_NAME,"WildCraft Black 35L 220");
      //  param.putString(FirebaseAnalytics.Param.ITEM_BRAND,"WildCraft");
        param.putDouble(FirebaseAnalytics.Param.PRICE,300);
        param.putLong(FirebaseAnalytics.Param.QUANTITY,i);
        param.putString(FirebaseAnalytics.Param.ITEM_ID,"3");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_TO_CART,param);
        Toast.makeText(getApplicationContext(), "id:3", Toast.LENGTH_SHORT).show();
        Bundle but = new Bundle();
        but.putString("ButtonName","Buy3_Bags");
        but.putString("Screen","Screen11");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen12.class);
        intent.putExtras(param);
        startActivity(intent);
    }

    private void acitivitycall4() {
        Random r = new Random() ;
        i= r.nextInt(15)+1;
        Bundle paramb = new Bundle();
        Bundle param = new Bundle();
        param.putString(FirebaseAnalytics.Param.ITEM_CATEGORY,"Watch");
        param.putString(FirebaseAnalytics.Param.ITEM_NAME,"Casio Edifice 100m");
       // param.putString(FirebaseAnalytics.Param.ITEM_BRAND,"Casio");
        param.putDouble(FirebaseAnalytics.Param.PRICE,1190);
        param.putLong(FirebaseAnalytics.Param.QUANTITY,i);
        param.putString(FirebaseAnalytics.Param.ITEM_ID,"4");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_TO_CART,param);
        Toast.makeText(getApplicationContext(), "id:4", Toast.LENGTH_SHORT).show();
        Bundle but = new Bundle();
        but.putString("ButtonName","Buy4_Watch");
        but.putString("Screen","Screen11");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen12.class);
        intent.putExtras(param);
        startActivity(intent);

    }


    private void acitivitycall1() {
        Random r = new Random() ;
        i= r.nextInt(15)+1;
        Bundle param = new Bundle();
        param.putString(FirebaseAnalytics.Param.ITEM_CATEGORY,"Clothing");
        param.putString(FirebaseAnalytics.Param.ITEM_NAME,"UCB Black Shirt");
       // param.putString(FirebaseAnalytics.Param.ITEM_BRAND,"UCB");
        param.putDouble(FirebaseAnalytics.Param.PRICE,345);
        param.putLong(FirebaseAnalytics.Param.QUANTITY,i);
        param.putString(FirebaseAnalytics.Param.ITEM_ID,"1");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_TO_CART,param);
        Toast.makeText(getApplicationContext(), "id:1", Toast.LENGTH_SHORT).show();
        Bundle but = new Bundle();
        but.putString("ButtonName","Buy1_clothing");
        but.putString("Screen","Screen11");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen12.class);
        intent.putExtras(param);
        startActivity(intent);
    }

    private void acitivityback() {
        Bundle param = new Bundle();
        param.putString("Nav_From","screen11");
        param.putString("Nav_To","HomeScreen");
        mFirebaseAnalytics.logEvent("Navigate",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Back");
        but.putString("Screen","Screen11");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        finish();
        //Intent intent= new Intent(this,MainActivity.class);
        // startActivity(intent);
    }

}
