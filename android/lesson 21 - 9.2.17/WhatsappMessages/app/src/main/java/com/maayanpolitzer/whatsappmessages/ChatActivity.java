package com.maayanpolitzer.whatsappmessages;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.maayanpolitzer.whatsappmessages.threads.SendMessageThread;

public class ChatActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private LinearLayout messagesLayout;
    private EditText messageInput;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        id = getIntent().getIntExtra("ID", -1);

        scrollView = (ScrollView) findViewById(R.id.scroll_view);
        messagesLayout = (LinearLayout) findViewById(R.id.messagesLayout);
        messageInput = (EditText) findViewById(R.id.activity_chat_message_edit_text);

        findViewById(R.id.activity_chat_send_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    private void sendMessage(){
        String message = messageInput.getText().toString().trim();
        if (!message.isEmpty()){
            displayMessage(message, false);
            // TODO: 09/02/2017 send to server!
            new SendMessageThread(new Message(message, 1, id)).start();
            messageInput.setText("");
        }
    }



    private void displayMessage(String message, boolean incoming){
        View view = getLayoutInflater().inflate(incoming ? R.layout.message_in : R.layout.message_out, null);
        TextView textView = (TextView) view.findViewById(R.id.message_body);
        textView.setText(message);
        messagesLayout.addView(view);
        scrollView.scrollTo(0, scrollView.getBottom());

    }

}
