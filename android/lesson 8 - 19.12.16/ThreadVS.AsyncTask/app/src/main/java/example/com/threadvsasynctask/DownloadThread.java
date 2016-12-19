package example.com.threadvsasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 12/19/2016.
 */

public class DownloadThread extends Thread {

    private String imageLink;
    private ImageView imageView;
    private Handler handler;
    private ProgressBar progressBar;

    public DownloadThread(String imageLink, ImageView imageView, ProgressBar progressBar){
        this.imageLink = imageLink;
        this.imageView = imageView;
        this.progressBar = progressBar;
        handler = new Handler();
    }

    @Override
    public void run() {
        try {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.VISIBLE);
                }
            });
            URL url = new URL(imageLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            Log.d("Maayan", "connection: " + connection.getContentLength());
            final Bitmap bitmap = BitmapFactory.decodeStream(in);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.INVISIBLE);
                    imageView.setImageBitmap(bitmap);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
