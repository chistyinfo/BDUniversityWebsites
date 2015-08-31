package aoktroop.bduniversity.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import oaktroop.bduniversity.R;



public class NationalFragment extends Fragment {
    private ListView listViewUni;
    private Context context;
    private View view;

    String[] uniName ={
            "Bangladesh National University",
            "Bangladesh Open University",
            "Ananda Mohan College",
            "B L College, Khulna",
            "Bangla College",
            "Bangladesh institute of Science & Technology",
            "Carmichael College, Rangpur",
            "Chittagong College",
            "Comilla Victoria Government College",
            "Debendra College, Manikganj",
            "Dhaka City College",
            "Dhaka College",
            "Dhaka Commerce College",
            "Dinajpur Govt. College, Dinajpur",
            "Eden Mohila College",
            "Feni Govt. College",
            "Government College of Commerce, Chittagong",
            "Hazi Mohammad Mohshin College",
            "Kabi Nazrul Government College",
            "Khulna Govt. Mohila College",
            "Kumudini Government College",
            "M M College, Jessore",
            "Murari Chand College",
            "Nawabganj Government College, Chapainawabganj",
            "New Government Degree College, Rajshahi",
            "Notre Dame College",
            "Rajshahi College",
            "Shaheed Suhrawardy College",
            "Shaikh Burhanuddin Post Graduate College",
            "Sylhet Government Women's College",
            "Tejgaon College",
            "Titumir College"

    };


    String[] urlStrArray={
            "http://www.nu.edu.bd/",
            "http://www.bou.edu.bd/",
            "http://www.anandamohangovtcollege.edu.bd/",
            "http://blcollege.edu.bd/",
            "http://sarkaribanglacollege.gov.bd/",
            "http://www.bistbd.com/",
            "http://ccr.gov.bd/",
            "http://www.ctgcollege.gov.bd/",
            "http://www.cvgc.edu.bd/",
            "http://www.debendracollege.edu.bd/",
            "http://www.dhakacitycollege.edu.bd/",
            "http://www.dhakacollege.edu.bd/",
            "http://www.dcc.edu.bd/",
            "http://www.dgc.edu.bd/",
            "http://www.edenmohilacollege.com/",
            "http://www.fgc.gov.bd/",
            "http://www.ctgcommercecollege.gov.bd/",
            "http://www.mohsincollege.gov.bd/",
            "http://kncollege.gov.bd/",
            "http://kgmc.ac.bd/",
            "http://www.kgc.ac.bd/",
            "http://mmcollege.edu.bd/",
            "http://www.mccollege.edu.bd/",
            "http://nawabganjcollege.gov.bd/",
            "http://www.ngdc-raj.ac.bd/",
            "http://www.notredame.ac.bd/",
            "http://rc.edu.bd/",
            "http://www.gsc.edu.bd/",
            "http://www.sbpgc.edu.bd/",
            "http://www.sylhetwomenscollege.gov.bd/",
            "http://tejgaoncollegebd.com/",
            "http://www.titumircollege.gov.bd/"

    };

    public NationalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_national, container, false);
        CustomListAdapter adapter = new CustomListAdapter( getActivity()
                ,uniName,null);
        listViewUni=(ListView)rootView.findViewById(R.id.list_view_national);
        listViewUni.setAdapter(adapter);
          addVisibile(rootView);
          view=rootView;

        listViewUni.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(isNetworkAvailable()){
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("uniName", uniName[position]);
                    intent.putExtra("url", urlStrArray[position]);

                    startActivity(intent);
                }
                else{
                    Toast.makeText(context, "Please check your Internet Connection!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        listViewUni.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW);
                    String Url = null;
                    Url = urlStrArray[position];
                    webIntent.setData(Uri.parse(Url));
                    startActivity(webIntent);
                } catch (Exception e) {
                    Toast.makeText(context, "Something wrong!", Toast.LENGTH_SHORT).show();

                }
                return true;
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

        LinearLayout adLinearLayout=(LinearLayout)view.findViewById(R.id.adLaNat);
        if(isNetworkAvailable()) {
            adLinearLayout.setVisibility(View.VISIBLE);
            AdView mAdView = (AdView)view.findViewById(R.id.adViewNat);
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
