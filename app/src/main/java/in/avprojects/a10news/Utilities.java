package in.avprojects.a10news;

import android.accounts.NetworkErrorException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by anushank_av on 6/4/17.
 */

public class Utilities {

    public static String returnUrl(int index){
        return URLS.urlList[index];
    }
    public static ArrayList<NewsFormat> getArraylistFromJSON(String jsonResp)
    {
        ArrayList<NewsFormat> newsItems = new ArrayList<>();
        try {
            JSONObject collection = new JSONObject(jsonResp);
            String status = collection.getString("status");
            if (status.equalsIgnoreCase("ok")){
                JSONArray articles = collection.getJSONArray("articles");
                for(int i=0;i<articles.length();i++){
                    JSONObject article = articles.getJSONObject(i);
                    String title = article.getString("title");
                    String description = article.getString("description");
                    String imgUrl = article.getString("urlToImage");
                    newsItems.add(new NewsFormat(imgUrl,title,description));
                }
            }
            else
            {
                throw new NetworkErrorException("Unable to obtain results");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
        return newsItems;
    }

}
