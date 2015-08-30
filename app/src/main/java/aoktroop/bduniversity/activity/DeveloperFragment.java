package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;


import oaktroop.bduniversity.R;


public class DeveloperFragment extends Fragment  {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);
    private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public DeveloperFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_developer, container, false);



        ImageView fbHasan = (ImageView) rootView.findViewById(R.id.hasan_fb);
        ImageView fbSunny = (ImageView) rootView.findViewById(R.id.sunny_fb);
        ImageView fbChisty = (ImageView) rootView.findViewById(R.id.chisty_fb);

        fbHasan.setOnClickListener(FbListener);
        fbSunny.setOnClickListener(FbListener);
        fbChisty.setOnClickListener(FbListener);


        ImageView emHasan=(ImageView)rootView.findViewById(R.id.emailHasan);
        ImageView emSunny=(ImageView)rootView.findViewById(R.id.sunny_email);
        ImageView emChisty=(ImageView)rootView.findViewById(R.id.chisty_email);

        ImageView emOakTroop=(ImageView)rootView.findViewById(R.id.emailOakTeam);

         emHasan.setOnClickListener(eMailListenr);
         emSunny.setOnClickListener(eMailListenr);
         emChisty.setOnClickListener(eMailListenr);

         emOakTroop.setOnClickListener(eMailListenr);

        ImageView cAllDev=(ImageView)rootView.findViewById(R.id.calldeve);
        cAllDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callToDeveloper(v);
            }
        });


        ImageView serverOak=(ImageView)rootView.findViewById(R.id.serverOakTeam);
        serverOak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActionOak(v);
            }
        });

        ImageView fbOak=(ImageView)rootView.findViewById(R.id.oak_team_fb);
        fbOak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FacebookActionOak(v);
            }
        });

        ImageView pLayStore=(ImageView)rootView.findViewById(R.id.play_store_id);
        pLayStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playStoreShow(v);
            }
        });

        return rootView;
    }
    private View.OnClickListener FbListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FacebookAction(v);

        }
    };
    private  View.OnClickListener eMailListenr= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            emailAction(v);
        }
    };


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context=activity;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void WebActionOak(View view){
        view.startAnimation(buttonClick);
        try{
            Intent webIntent=new Intent(Intent.ACTION_VIEW);
            String Url = null;
            Url = getString(R.string.title_team_server);
            webIntent.setData(Uri.parse(Url));
            startActivity(webIntent);
        }
        catch (Exception e){
            Toast.makeText(context, "Something wrong!", Toast.LENGTH_SHORT).show();

        }

    }
    public void callToDeveloper(View view){
        view.startAnimation(buttonClick);

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:01521208079"));
        startActivity(callIntent);

    }

    public void FacebookActionOak(View view){
        view.startAnimation(buttonClick);
        try{
            Intent webIntent=new Intent(Intent.ACTION_VIEW);
            String Url = null;
            Url = getString(R.string.title_team_fb);
            webIntent.setData(Uri.parse(Url));
            startActivity(webIntent);
        }
        catch (Exception e){
            Toast.makeText(context, "Something wrong!", Toast.LENGTH_SHORT).show();

        }

    }

    public void playStoreShow(View view){

        try{
            String Url = "https://play.google.com/store/apps/developer?id=The+Oak+Troop";

            Intent webIntent=new Intent(Intent.ACTION_VIEW);

            webIntent.setData(Uri.parse(Url));
            startActivity(webIntent);
        }
        catch (Exception e){
            Toast.makeText(context,"Something wrong. Report to Developer!", Toast.LENGTH_SHORT).show();
        }

    }

    public void FacebookAction(View view){
        view.startAnimation(buttonClick);
        try{

            String Url = null;
            switch (view.getId()){
                case R.id.hasan_fb:
                    Url=getString(R.string.title_hasan_fb);
                    break;
                case R.id.sunny_fb:
                    Url=getString(R.string.title_sunny_fb);
                    break;
                case R.id.chisty_fb:
                    Url=getString(R.string.title_chisty_fb);
                    break;


            }
            Intent webIntent=new Intent(Intent.ACTION_VIEW);

            webIntent.setData(Uri.parse(Url));
            startActivity(webIntent);

        }
        catch (Exception e){
            Toast.makeText(context,"Something wrong!",Toast.LENGTH_SHORT).show();
        }


    }

    public void emailAction(View view){
        view.startAnimation(buttonClick);

      // Log.i("Send email", "");
//        String[] TO = {"hasan_cse91@yahoo.com","sunny_mhs@hotmail.com","chistyinfo@gmail.com","shakirahmed1996@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
//        System.out.println("dhuru ja   "+TO[0]);

        if(view.getId()==R.id.emailHasan){
            String[] TO = {"hasan_cse91@yahoo.com"};
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        }
        else if(view.getId()==R.id.sunny_email){
            String[] TO = {"sunny_mhs@hotmail.com"};
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        }
        else if(view.getId()==R.id.chisty_email){
            String[] TO = {"chistyinfo@gmail.com"};
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        }
        else if(view.getId()==R.id.emailOakTeam){
            String[] TO = {"oakteam2015@gmail.com"};
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        }


        //emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "BD University Website");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
           // finish();
            Log.i("E-mail sent!", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }




}
