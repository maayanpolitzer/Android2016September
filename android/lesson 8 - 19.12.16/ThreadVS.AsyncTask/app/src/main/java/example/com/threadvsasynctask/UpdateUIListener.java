package example.com.threadvsasynctask;

import android.graphics.Bitmap;

/**
 * Created by hackeru on 12/19/2016.
 */

public interface UpdateUIListener {

    void displayProgressBar(boolean display);

    void displayImage(Bitmap bitmap);

}
