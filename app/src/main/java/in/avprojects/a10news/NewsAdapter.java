package in.avprojects.a10news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import in.avprojects.sunrisenews.R;

/**
 * Created by anushank_av on 6/4/17.
 */

public class NewsAdapter extends ArrayAdapter<NewsFormat> {
    public NewsAdapter(Context context, List<NewsFormat> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsFormat nItem = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        TextView hText = (TextView)convertView.findViewById(R.id.headingText);
        TextView dtext = (TextView)convertView.findViewById(R.id.descriptionText);
        ImageView nImage = (ImageView)convertView.findViewById(R.id.urlImage);
        hText.setText(nItem.getHeadline());
        dtext.setText(nItem.getDescription());
        nImage.setImageResource(R.drawable.nothumb);


        return convertView;
    }
}
