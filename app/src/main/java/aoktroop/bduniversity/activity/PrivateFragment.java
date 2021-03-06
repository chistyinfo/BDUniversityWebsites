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



public class PrivateFragment extends Fragment {
    private ListView listViewUni;
    private Context context;

    private View view;

    String[] uniName ={
            "Ahsanullah University of Science and Technology (AUST)",
            "America Bangladesh University (ABU)",
            "American International University-Bangladesh (AIUB)",
            "ASA University Bangladesh (ASAUB)",
            "Asian University of Bangladesh(AUB)",
            "Atish Dipankar University of Science and Technology(ADUST)",
            "Bangladesh Islami University(BIU)",
            "Bangladesh University (BU)",
            "Bangladesh University of Business and Technology (BUBT)",
            "Begum Gulchemonara Trust University Bangladesh (BGCTUB)",
            "BRAC University (BRACU)",
            "Chittagong Independent University (CIU)",
            "City University, Bangladesh (CUB)",
            "Coxs Bazar International University (CBIU)",
            "Daffodil International University (DIU)",
            "Darul Ihsan University(DIU)",
            "Dhaka International University *(DIntU)",
            "East West University (EWU)",
            "Eastern University, Bangladesh (EU)",
            "European University of Bangladesh (EUB)",
            "Gono Bishwabidyalay (GB)",
            "Green University of Bangladesh (GUB)",
            "IBAIS University (IU)",
            "Independent University, Bangladesh (IUB)",
            "International University of Business Agriculture and Technology (IUBAT)",
            "North South University (NSU)",
            "North Western University, Bangladesh (NWU)",
            "Northern University, Bangladesh (NUB)",
            "People's University of Bangladesh (PUB)",
            "Prime University (PU)",
            "Primeasia University (PAU)",
            "Royal University of Dhaka (RUD)",
            "Shanto-Mariam University of Creative Technology (SMUCT)",
            "Sonargaon University (SU)",
            "Southeast University(SEU)",
            "Stamford University Bangladesh (SU)",
            "State University of Bangladesh(SUB)",
            "United International University(UIU)",
            "University of Asia Pacific (UAP)",
            "University of Information Technology and Sciences(UITS)",
            "University of Liberal Arts Bangladesh(ULAB)",
            "University of South Asia, Bangladesh(USAB)",
            "Uttara University(UU)",
            "Victoria University of Bangladesh(VUB)",
            "World University of Bangladesh(WU)"

    };

    String[] urlStrArray={
            "http://www.aust.edu/",
            "http://www.abuniversity.edu.bd/",
            "http://www.aiub.edu/",
            "http://www.asaub.edu.bd/",
            "http://www.aub-bd.org/",
            "http://www.atishdipankaruniversity.edu.bd/",
            "http://www.biu.ac.bd/",
            "http://www.bangladeshuniversity.edu.bd/",
            "http://www.bubt.edu.bd/",
            "http://www.bgctub-edu.com/",
            "http://www.bracuniversity.ac.bd/",
            "http://www.ciu.edu.bd/",
            "http://www.cityuniversity.edu.bd/aboutcu.htm",
            "http://www.cbiu.ac.bd/",
            "http://www.daffodilvarsity.edu.bd/about_diu.htm",
            "http://www.diu.ac.bd/",
            "http://www.diu-edu.net/",
            "http://www.ewubd.edu/",
            "http://www.easternuni.edu.bd/",
            "http://www.eub.edu.bd/",
            "http://www.gonouniversity.edu.bd/",
            "http://www.green.edu.bd/",
            "http://www.ibais.edu/",
            "http://www.iub.edu.bd/",
            "http://www.iubat.edu/",
            "http://www.northsouth.edu/",
            "http://www.nub.ac.bd/",
            "http://www.nub.ac.bd/",
            "http://www.pub.ac.bd/",
            "http://www.primeuniversity.edu.bd/",
            "http://www.primeasia.edu.bd/bottom.htm",
            "http://www.royal.edu.bd/",
            "http://www.smuct.edu.bd/",
            "http://su.edu.bd/",
            "http://www.seu.ac.bd/",
            "http://www.stamforduniversity.edu.bd/",
            "http://www.sub.edu.bd/",
            "http://www.uiu.ac.bd/",
            "http://www.uap-bd.edu/",
            "http://www.uits-bd.org/",
            "http://www.ulab.edu.bd/",
            "http://www.southasia-uni.org/",
            "http://www.uttarauniversity.com/",
            "http://www.vub.edu.bd/",
            "http://www.wub.edu/"

    };

    public PrivateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_private, container, false);
        CustomListAdapter adapter = new CustomListAdapter( getActivity()
                ,uniName,null);
        listViewUni=(ListView)rootView.findViewById(R.id.list_view_private_university);
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

        LinearLayout adLinearLayout=(LinearLayout)view.findViewById(R.id.adLaPri);
        if(isNetworkAvailable()) {
            adLinearLayout.setVisibility(View.VISIBLE);
            AdView mAdView = (AdView)view.findViewById(R.id.adViewPri);
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
