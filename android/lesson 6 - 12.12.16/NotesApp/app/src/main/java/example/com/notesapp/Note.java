package example.com.notesapp;

/**
 * Created by hackeru on 12/12/2016.
 */

public class Note {

    private String title;
    private String content;

    public Note(){

    }

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
