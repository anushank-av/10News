package in.avprojects.a10news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import in.avprojects.sunrisenews.R;

/**
 * Created by anush on 24-03-2017.
 */

public class NewsFragment extends Fragment {
    private String fragRequestURL;
    private static String tag = "ARG_TAG";

    private String mTitle;
    private int fragId;

    public static NewsFragment getFragmentInstance(String title,int reqId){
        Bundle bundle = new Bundle();
        bundle.putString(tag,title);
        bundle.putInt("id",reqId);
        NewsFragment newInst = new NewsFragment();
        newInst.setArguments(bundle);
        return newInst;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString(tag);
        fragId = getArguments().getInt("id");
        fragRequestURL = Utilities.returnUrl(fragId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.from(getContext()).inflate(R.layout.fragment_main,container,false);
        ListView listView = (ListView)v.findViewById(R.id.newsView);

        NewsAdapter mNewsAdapter = new NewsAdapter(getContext(),Utilities.getArraylistFromJSON(Utilities.returnUrl(fragId)));
        listView.setAdapter(mNewsAdapter);


        return v;

    }
}
