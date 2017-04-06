package sg.aa1;

//import android.content.Context;
import android.content.Context;
import android.content.Intent;
//import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;

//import java.io.FileOutputStream;


public class RegisterPage extends AppCompatActivity {
    //  Context context = getActivity();

    EditText userid;
    EditText password;
    EditText emailid;

    public String user_id_entered;
    String email_id_entered;
    String pass_entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        EditText userid = (EditText) (findViewById(R.id.RegUserID));
        EditText password = (EditText) (findViewById(R.id.RegPswd));
        EditText emailid = (EditText) (findViewById(R.id.emailid));

        String user_id_entered = userid.getText().toString();
        String email_id_entered = emailid.getText().toString();
        String pass_entered = password.getText().toString();


       /* Button SubmitButton = (Button) findViewById(R.id.SubmitButton);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });*/




      /*  SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.clear();
        edit.putString("username", RegUserID.getText().toString().trim());
        edit.putString("password", password.getText().toString().trim());
        edit.commit();
        Toast.makeText(context, "Login details are saved..", Toast.LENGTH_SHORT).show();*/


      /*  String filename = "RegDetails";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            }*/


    }

    public void attemptLogin(View view) {

        emailid.setError(null);
        password.setError(null);
        userid.setError(null);


        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(pass_entered) && !isPasswordValid(pass_entered)) {
            password.setError("This password is too short, you idiot");
            focusView = password;
            cancel = true;
        }

        // Check for a valid userid.
        if (TextUtils.isEmpty(user_id_entered) && !isUserValid(user_id_entered)) {
            userid.setError("Enter the id, man come on");
            focusView = userid;
            cancel = true;
        } else if (!isEmailValid(email_id_entered)) {
            emailid.setError("Enter a valid email id, motherfucker");
            focusView = emailid;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }

    }


    private boolean isEmailValid(String email) {

        return (email.contains("@") && email.contains("."));
    }

    private boolean isPasswordValid(String password) {

        return password.length() > 6;
    }

    private boolean isUserValid(String user) {
        return user.length() > 5;
    }






   /* public void FunMainPage(View view){
        Intent intentmain = new Intent(this, MainActivity.class);
        startActivity(intentmain);
    }*/


}


























