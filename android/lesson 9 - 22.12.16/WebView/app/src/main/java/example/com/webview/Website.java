package example.com.webview;

/**
 * Created by hackeru on 12/19/2016.
 */

public class Website {

    private String title;
    private String url;

    public Website(String title, String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return title;
    }
}
