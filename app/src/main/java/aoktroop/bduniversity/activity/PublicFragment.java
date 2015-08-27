package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import oaktroop.bduniversity.R;



public class PublicFragment extends Fragment {
   private ListView listViewUni;
    private Context context;
    private View view;

    String[] uniName ={
            "University of Dhaka",
            "Jahangirnagar University",
            "University of Rajshahi",
            "Jagannath University",
            "University of Chittagong",
            "Bangladesh Agricultural University",
            "Sher-e-Bangla Agricultural University",
            "Khulna University",
            "Islamic University",
            "Bangabandhu Sheikh Mujibur Rahman Maritime University",
            "Jatiya Kabi Kazi Nazrul Islam University",
            "Comilla University",
            "Begum Rokeya University",
            "Bangladesh University of Professionals",
            "University of Barisal",
            "Chittagong Veterinary and Animal Sciences University",
            "Sylhet Agricultural University"


    };


    String[] urlStrArray={
            "http://www.du.ac.bd/",
            "http://www.juniv.edu/",
            "http://www.ru.ac.bd/",
            "http://jnu.ac.bd/",
            "http://cu.ac.bd",
            "http://www.bau.edu.bd/",
            "http://www.sau.edu.bd",
            "http://ku.ac.bd",
            "http://iu.ac.bd",
            "http://www.bsmrmu.edu.bd/",
            "http://www.jkkniu.edu.bd/",
            "http://www.cou.ac.bd/",
            "http://www.brur.ac.bd/",
            "http://www.bup.edu.bd/",
            "http://www.barisaluniv.edu.bd/",
            "http://www.cvasu.ac.bd/",
            "http://www.sau.ac.bd/"


    };
    public PublicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_public, container, false);
        CustomListAdapter adapter = new CustomListAdapter( getActivity()
                ,uniName,null);
        listViewUni=(ListView)rootView.findViewById(R.id.list_view_univer);
        listViewUni.setAdapter(adapter);
//        AdView mAdView = (AdView)rootView.findViewById(R.id.adViewPub);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
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

        LinearLayout adLinearLayout=(LinearLayout)view.findViewById(R.id.adLaPub);
        if(isNetworkAvailable()) {
            adLinearLayout.setVisibility(View.VISIBLE);
            AdView mAdView = (AdView)view.findViewById(R.id.adViewPub);
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
