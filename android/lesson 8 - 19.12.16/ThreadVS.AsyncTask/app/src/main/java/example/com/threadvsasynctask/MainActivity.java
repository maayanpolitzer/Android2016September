package example.com.threadvsasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UpdateUIListener {

    private String imageUrl = "http://www.telegraph.co.uk/content/dam/Travel/leadAssets/22/98/CocoaIsland-Maldiv_2298195a-large.jpg";
    private String smallImageURL = "https://pbs.twimg.com/profile_images/749168195076968449/nde0ggXL_reasonably_small.jpg";

    private String largeImageUrl = "https://upload.wikimedia.org/wikipedia/en/6/6e/Maldives-beach.jpg";
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.start_button);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        imageView = (ImageView) findViewById(R.id.image_view);

        startBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // start a thread/asyncTask...
        //new DownloadThread(smallImageURL, imageView, progressBar).start();
        //new DownloadThread2(this, largeImageUrl).start();
        new DownloadTask().execute(imageUrl, "Maayan", "Politzer");
    }

    public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // works on a NEW THREAD!!!
            Log.d("Maayan", "Hello " + params[1] + " " + params[2]);
            try {
                URL url = new URL(params[0]);
                InputStream in = url.openStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                in.close();
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressBar.setVisibility(View.INVISIBLE);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }else{
                Toast.makeText(MainActivity.this, "Problem...", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void displayProgressBar(boolean display) {
        progressBar.setVisibility(display ? View.VISIBLE : View.INVISIBLE);
        /*
        if (display == true){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.INVISIBLE);
        }
        */
    }

    @Override
    public void displayImage(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

}
