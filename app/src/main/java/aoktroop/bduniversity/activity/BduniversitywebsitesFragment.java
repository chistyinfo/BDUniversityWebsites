package aoktroop.bduniversity.activity;

/**
 * Created by Ravi on 29/07/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rzlts.appinbox.AppInbox;
import com.rzlts.appinbox.model.Gender;
import com.rzlts.appinbox.views.InboxView;

import oaktroop.bduniversity.R;


public class BduniversitywebsitesFragment extends Fragment {

    ImageView button;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);

    public BduniversitywebsitesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bduniversitywebsites, container, false);



        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        AppInbox.startInbox(getActivity(), "c1mkKqWWNaPSzE0e9GIHkgAyD0fvlslXZeosmJTmg2E", "89485377970", null, null, null, "Oak", "Troop", "oaktroop2015@gmail.com", Gender.MALE, 0);


        FrameLayout rlLayout = (FrameLayout) rootView.findViewById(R.id.rlLayout);
        final InboxView inbox = new InboxView(getActivity());
        rlLayout.addView(inbox);

        button = (ImageView) rootView.findViewById(R.id.feedbackButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(), FeedbackActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
