package example.com.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

        new DownloadImageTask(true).execute("WOW");

    }

    private class DownloadImageTask extends AsyncTask<String, Integer, Integer>{

        private boolean age;

        public DownloadImageTask(boolean age){
            this.age = age;
        }

        @Override
        protected void onPreExecute() {
            // works on MainThread...
            textView.setText("STARTING...");
        }

        @Override
        protected Integer doInBackground(String... params) {
            for(int i = 0; i < 100; i++){
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i); // calls onProgressUpdate inside an handler...
            }
            return 6;   // send this data to onPostExecute
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // works on MainThread...
            textView.setText("downloading ( " + values[0] + "% )");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            // works on the MainThread...
            textView.setText("DONE (" + integer + ")");
        }
    }

}
