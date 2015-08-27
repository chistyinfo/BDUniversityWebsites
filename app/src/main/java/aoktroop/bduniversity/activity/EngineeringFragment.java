package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import oaktroop.bduniversity.R;



public class EngineeringFragment extends Fragment {
    private ListView listViewUni;

    private Context context;
    private View view;

    String[] uniName ={
            "Bangabandhu Sheikh Mujibur Rahman Science and Technology University",
            "Bangladesh University of Engineering and Technology (BUET)",
            "Bangladesh University of Textiles (BUTex)",
            "Chittagong University of Engineering & Technology (CUET)",
            "Dhaka University of Engineering & Technology (DUET)",
            "Hajee Mohammad Danesh Science & Technology University",
            "Jessore University of Science & Technology (JUST)",
            "Khulna University of Engineering & Technology (KUET)",
            "Mawlana Bhashani Science and Technology University",
            "Military Institute of Science and Technology (MIST)",
            "Noakhali Science and Technology University",
            "Pabna University of Science and Technology",
            "Patuakhali Science and Technology University[",
            "Rajshahi University of Engineering & Technology (RUET)",
            "Shahjalal University of Science and Technology (SUST)"

    };


    String[] urlStrArray={
            "http://www.bsmrstu.edu.bd/",
            "http://www.buet.ac.bd/",
            "http://www.butex.edu.bd/",
            "http://www.cuet.ac.bd/",
            "http://www.duet.ac.bd/",
            "http://www.hstu.ac.bd/",
            "http://www.just.edu.bd/",
            "http://www.kuet.ac.bd/",
            "http://mbstu.ac.bd/",
            "http://mist.ac.bd/",
            "http://www.nstu.edu.bd/",
            "http://www.pust.ac.bd/",
            "http://www.pstu.ac.bd/",
            "http://www.ruet.ac.bd/",
            "http://www.sust.edu/"
    };


    public EngineeringFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_engineering, container, false);
        CustomListAdapter adapter = new CustomListAdapter( getActivity()
                ,uniName,null);
        listViewUni=(ListView)rootView.findViewById(R.id.list_view_engineering);
        listViewUni.setAdapter(adapter);


        addVisibile(rootView);
        view=rootView;

        listViewUni.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("uniName", uniName[position]);
                intent.putExtra("url", urlStrArray[position]);

                startActivity(intent);


            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context=activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
        addVisibile(view);
    }
    private void addVisibile(View view) {

        LinearLayout adLinearLayout=(LinearLayout)view.findViewById(R.id.adEni);
        if(isNetworkAvailable()) {
            adLinearLayout.setVisibility(View.VISIBLE);
            AdView mAdView = (AdView)view.findViewById(R.id.adViewEni);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
        else {
            adLinearLayout.setVisibility(View.GONE);
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
