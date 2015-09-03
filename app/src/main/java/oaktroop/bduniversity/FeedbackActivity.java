package oaktroop.bduniversity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONException;
import org.json.JSONObject;

import aoktroop.bduniversity.webService.MyInterface;
import aoktroop.bduniversity.webService.PostMethod;

public class FeedbackActivity extends AppCompatActivity implements MyInterface {

    Button button;
    EditText name;
    EditText email;
    EditText phone;
    EditText feedbackEditText;
    String nameString;
    String emailString;
    String phoneString;
    String feedbackString;
    PostMethod postMethod = new PostMethod(this);
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);
    String strJson;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        addVisibile();
        initialize();
        postMethod.myInterface = this;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNetworkAvailable()){

                    nameString = name.getText().toString();
                    emailString = email.getText().toString();
                    phoneString = phone.getText().toString();
                    feedbackString = feedbackEditText.getText().toString();

                    if(!feedbackString.isEmpty()){
                        postMethod.execute(nameString,emailString,phoneString,feedbackString);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"You must give feedback!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please check your Internet connection", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initialize() {
        button = (Button) findViewById(R.id.submitButton);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        feedbackEditText = (EditText) findViewById(R.id.feedback);
    }

    public void backButtonAction(View view){
        view.startAnimation(buttonClick);
        finish();
    }

    private void addVisibile() {

        LinearLayout adLinearLayout=(LinearLayout)findViewById(R.id.adMainActivity);
        if(isNetworkAvailable()) {
            adLinearLayout.setVisibility(View.VISIBLE);
            AdView mAdView;
            mAdView = (AdView) findViewById(R.id.adView1);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
        else {
            adLinearLayout.setVisibility(View.GONE);
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void processFinish(String output) {

        String message = null;

        try {
            JSONObject reader = new JSONObject(output);
            message = reader.getString("response");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        Integer feedbackNum = Integer.parseInt(message);

        if(feedbackNum!=null && feedbackNum>0){
            Toast.makeText(getApplicationContext(),"Thank you for your feedback!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Something wrong! Please mail us from Developer page!", Toast.LENGTH_SHORT).show();
        }

        finish();
    }


}
