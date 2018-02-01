package test.example.charuhaschitale.appforfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class screen22 extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button recbutton,back;
    TextView cate,amt;
    String cat,n;
    Double name;
    Bundle bundle;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen22);

        recbutton = (Button) findViewById(R.id.buttonreceive);
        cate =(TextView) findViewById(R.id.catText) ;
        amt =(TextView) findViewById(R.id.loamamtText) ;

        back =(Button) findViewById(R.id.backButton);
        bundle= getIntent().getExtras();
        cat = bundle.getString("Category");
        name= bundle.getDouble("Amounnt");
        n = name.toString();
        cate.setText(cat);
        amt.setText(n);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        recbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewProcess();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acitivityback();
            }
        });
        Bundle screenParam = new Bundle();
        screenParam.putString("ScreenName","Screen22:loanConfirm");
        mFirebaseAnalytics.logEvent("Page",screenParam);
        Random r = new Random() ;
        i= r.nextInt((999-111)+1);
    }


    private void NewProcess() {
        Bundle bundle =  new Bundle();
        bundle.putString("BANK_NAME","BOI");
        bundle.putLong("Account_no",53921000+i);
        mFirebaseAnalytics.logEvent("Selected_Loan",bundle);
        Bundle but = new Bundle();
        but.putString("ButtonName","Button_GetLoan");
        but.putString("Screen","Screen22");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        finish();
        //Intent intent= new Intent(this,MainActivity.class);
        //startActivity(intent);
    }


    private void acitivityback() {
        Bundle param = new Bundle();
        param.putString("Nav_From","screen22");
        param.putString("Nav_To","screen21");
        mFirebaseAnalytics.logEvent("Navigate",param);
        finish();
        Bundle but = new Bundle();
        but.putString("ButtonName","Back");
        but.putString("Screen","Screen22");
        mFirebaseAnalytics.logEvent("ButtonClick",but);
        //Intent intent= new Intent(this,screen21.class);
        //startActivity(intent);
    }
}
