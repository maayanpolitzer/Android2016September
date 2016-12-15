package example.com.moviesapp;

import java.util.ArrayList;

/**
 * Created by hackeru on 12/15/2016.
 */

public interface OnWorkCompletedListener {

    void onSuccess(ArrayList<Movie> movies);

    void onError(String error);

}
