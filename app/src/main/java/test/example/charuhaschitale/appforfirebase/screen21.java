package test.example.charuhaschitale.appforfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.text.DateFormat;
import java.util.Date;

public class screen21 extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button get1,get2,get3,get4,back;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen21);

        get1 = (Button) findViewById(R.id.get1);
        get2 = (Button) findViewById(R.id.get2);
        get3 = (Button) findViewById(R.id.get3);
        get4 = (Button) findViewById(R.id.get4);

        back =(Button) findViewById(R.id.backButton);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle paramb = new Bundle();
        paramb.putString("LoanStep","2");
        mFirebaseAnalytics.logEvent("Step",paramb);
        get1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall1();
            }
        });
        get2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall2();
            }
        });
        get3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall3();
            }
        });
        get4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivitycall4();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivityback();
            }
        });
        Bundle screenParam = new Bundle();
        screenParam.putString("ScreenName","Screen21:Bank");
        mFirebaseAnalytics.logEvent("Page",screenParam);
        str = DateFormat.getDateTimeInstance().format(new Date());
    }

    private void acitivitycall1() {
        Bundle param = new Bundle();
        param.putString("City","mumbai");
        param.putString("Date",str);
        param.putString("Category","BRONZ");
        param.putDouble("Amounnt",10000);
        param.putString(FirebaseAnalytics.Param.CURRENCY,"INR");
        mFirebaseAnalytics.logEvent("LOAN_CATEGORY",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Loan1");
        but.putString("Screen","Screen21");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen22.class);
        intent.putExtras(param);
        startActivity(intent);
    }
    private void acitivitycall2() {
        Bundle param = new Bundle();
        param.putString("City","mumbai");
        param.putString("Date",str);
        param.putString("Category","SILVER");
        param.putDouble("Amounnt",50000);
        param.putString(FirebaseAnalytics.Param.CURRENCY,"INR");
        mFirebaseAnalytics.logEvent("LOAN_CATEGORY",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Loan2");
        but.putString("Screen","Screen21");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen22.class);
        intent.putExtras(param);
        startActivity(intent);
    }

    private void acitivitycall3() {
        Bundle param = new Bundle();
        param.putString("City","mumbai");
        param.putString("Date",str);
        param.putString("Category","GOLD");
        param.putDouble("Amounnt",100000);
        param.putString(FirebaseAnalytics.Param.CURRENCY,"INR");
        mFirebaseAnalytics.logEvent("LOAN_CATEGORY",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Loan3");
        but.putString("Screen","Screen21");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen22.class);
        intent.putExtras(param);
        startActivity(intent);
    }

    private void acitivitycall4() {
        Bundle param = new Bundle();
        param.putString("City","mumbai");
        param.putString("Date",str);
        param.putString("Category","PLATINUM");
        param.putDouble("Amounnt",500000);
        param.putString(FirebaseAnalytics.Param.CURRENCY,"INR");
        mFirebaseAnalytics.logEvent("LOAN_CATEGORY",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Loan4");
        but.putString("Screen","Screen21");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        Intent intent= new Intent(this,screen22.class);
        intent.putExtras(param);
        startActivity(intent);
    }


    private void acitivityback() {
        Bundle param = new Bundle();
        param.putString("Nav_From","screen21");
        param.putString("Nav_To","HomeScreen");
        mFirebaseAnalytics.logEvent("Navigate",param);
        Bundle but = new Bundle();
        but.putString("ButtonName","Back");
        but.putString("Screen","Screen21");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        finish();
      //  Intent intent= new Intent(this,MainActivity.class);
       // startActivity(intent);
    }
}
