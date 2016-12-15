package example.com.moviesapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hackeru on 12/15/2016.
 */
public class MoviesAdapter extends ArrayAdapter<Movie>{

    private Context context;
    private ArrayList<Movie> movies;
    private Handler handler;

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
        handler = new Handler();
    }

    private class ViewHolder {
        ImageView posterIMageView;
        TextView nameTextView, yearTextView;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.posterIMageView = (ImageView) convertView.findViewById(R.id.list_item_poster);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.list_item_movie_name);
            viewHolder.yearTextView = (TextView) convertView.findViewById(R.id.list_item_year);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameTextView.setText(movies.get(position).getTitle());
        viewHolder.yearTextView.setText(movies.get(position).getYear());

        //new DownloadImageThread(handler, viewHolder.posterIMageView, movies.get(position).getPoster()).start();
        Picasso.with(context).load(movies.get(position).getPoster()).into(viewHolder.posterIMageView);

        return convertView;
    }
/*
    private class DownloadImageThread extends Thread {

        private ImageView imageView;
        private String posterLink;
        private Handler handler;

        public DownloadImageThread(Handler handler, ImageView imageView, String posterLink){
            this.handler = handler;
            this.imageView = imageView;
            this.posterLink = posterLink;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(posterLink);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                InputStream in = con.getInputStream();
                final Bitmap image = BitmapFactory.decodeStream(in);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(image);
                    }
                });
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
}
