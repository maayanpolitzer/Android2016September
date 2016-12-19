package example.com.threadvsasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 12/19/2016.
 */

public class DownloadThread2 extends Thread {

    private UpdateUIListener listener;
    private String imageLink;
    private Handler handler;

    public DownloadThread2(UpdateUIListener listener, String imageLink){
        this.listener = listener;
        this.imageLink = imageLink;
        handler = new Handler();
    }

    @Override
    public void run() {

        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.displayProgressBar(true);
            }
        });
        try {
            URL url = new URL(imageLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            Log.d("Maayan", "connection: ");
            final Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.displayProgressBar(false);
                    listener.displayImage(bitmap);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
