package in.avprojects.a10news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import in.avprojects.sunrisenews.R;g

/**
 * Created by anush on 24-03-2017.
 */

public class NewsFragment extends Fragment {
    private static String fragRequestURL;
    private static String tag = "ARG_TAG";

    private String mTitle;

    public static NewsFragment getFragmentInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(tag,title);
        NewsFragment newInst = new NewsFragment();
        newInst.setArguments(bundle);
        return newInst;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString(tag);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.from(getContext()).inflate(R.layout.fragment_main,container,false);
        TextView textView = (TextView) v.findViewById(R.id.fragmentText);
        textView.setText(mTitle);

        return v;

    }
}
