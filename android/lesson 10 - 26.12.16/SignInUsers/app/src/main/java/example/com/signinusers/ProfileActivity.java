package example.com.signinusers;

import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import example.com.signinusers.infrastructure.Validation;


public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private static final int LAUNCH_CAMERA_APP_REQUEST_CODE = 1;
    private static final int GALLERY_REQUEST_CODE = 2;

    private FrameLayout changeAvatarFrameLayout;
    private ImageView avatarImageView;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private View setProfileButtonView;

    private boolean isAvatarSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        avatarImageView = (ImageView) findViewById(R.id.activity_profile_avatar_image_view);
        changeAvatarFrameLayout = (FrameLayout) findViewById(R.id.activity_profile_change_avatar_frame_layout);
        firstNameEditText = (EditText) findViewById(R.id.activity_profile_first_name_edit_text);
        lastNameEditText = (EditText) findViewById(R.id.activity_profile_last_name_edit_text);
        phoneEditText = (EditText) findViewById(R.id.activty_profile_phone_edit_text);
        setProfileButtonView = findViewById(R.id.activity_profile_set_profile_button);

        changeAvatarFrameLayout.setOnClickListener(this);
        setProfileButtonView.setOnClickListener(this);

        getSupportActionBar().setTitle("Edit your profile");
    }

    @Override
    public void onClick(View v) {
        if (v == changeAvatarFrameLayout){
            // implicit intent - start activity that belongs to other apps.
            // explicit intent - start activity inside your app.
            /*
            // open dialer app with phone number.
            Uri uri = Uri.parse("tel:0527776661");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            */
            /*
            //display webpage in browser app
            Uri uri = Uri.parse("http://www.walla.co.il");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            */
            /*
            // pick a contact:
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
            */
            /*
            // launch the camera app...
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, LAUNCH_CAMERA_APP_REQUEST_CODE);
            */
            // launch gallery.
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_REQUEST_CODE);
        }else if(v == setProfileButtonView){
            if (Validation.validationProfile(this, firstNameEditText, lastNameEditText, phoneEditText, isAvatarSet)){
                moveToAnotherActivity(ActivationActivity.class, true);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LAUNCH_CAMERA_APP_REQUEST_CODE) {    // from where...
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                avatarImageView.setImageBitmap(bitmap);
                isAvatarSet = true;
            }else{
                Toast.makeText(this, "Cancelled!", Toast.LENGTH_LONG).show();
            }
        }else if(requestCode == GALLERY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Uri imageUri = data.getData();
                Crop.of(imageUri, imageUri).asSquare().start(this);
            }else{
                // cancel picking an image.
            }
        }else if(requestCode == Crop.REQUEST_CROP){
            if (resultCode == RESULT_OK){
                avatarImageView.setImageURI(Crop.getOutput(data));
                isAvatarSet = true;
            }else{
                // cancel cropping an image
            }
        }
    }
}
