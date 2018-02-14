package test.example.charuhaschitale.appforfirebase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
   Button b1,b2;
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)(findViewById(R.id.button1));
        b2= (Button)(findViewById(R.id.button2));
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openactivity2();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity3();
            }
        });
        Bundle screenParam = new Bundle();
        screenParam.putString("ScreenName","Home page");
        mFirebaseAnalytics.logEvent("Page",screenParam);

        String uniqueID = UUID.randomUUID().toString();
      // Random r = new Random() ;
       // int i= r.nextInt((10000-12)+1);

        mFirebaseAnalytics.setUserId(uniqueID);

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
                       //Toast.makeText(getApplicationContext(), "Link Worked", Toast.LENGTH_SHORT).show();
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

   /* public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context context) {
        return null;
    }*/

    private void openactivity3() {
        Bundle param = new Bundle();
        param.putString(FirebaseAnalytics.Param.CHECKOUT_STEP,"1");
        param.putString("ScreenView_Directed_to","cat2a");
        param.putString("LoanStep","1");
        mFirebaseAnalytics.logEvent("Step2Bank",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Banking");
        but.putString("Screen","MainScreen");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen21.class);
        startActivity(intent);
    }


    private void openactivity2() {
        Bundle param = new Bundle();

        param.putString("ScreenView_Directed_to","cat1a");
        mFirebaseAnalytics.logEvent("Step1Ecom",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Ecommerce");
        but.putString("Screen","MainScreen");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen11.class);
        startActivity(intent);
    }

}
