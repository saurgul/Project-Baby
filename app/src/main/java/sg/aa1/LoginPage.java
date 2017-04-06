package sg.aa1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    EditText LoginUserID;
    String user_id_entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button SubmitButton = (Button) findViewById(R.id.ButMainPage);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }

            EditText LoginUserID =  (EditText)(findViewById(R.id.LoginUserID));
            String user_id_entered = LoginUserID.getText().toString();

        });

    }

    private void attemptLogin() {
        LoginUserID.setError(null);

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(user_id_entered) && !isUserValid(user_id_entered)) {
            LoginUserID.setError("Enter the id, man come on");
            focusView = LoginUserID;
            cancel = true;
        }
    }
    private boolean isUserValid(String user){
        return user.length() > 5;
    }

    public void FunRegisterPage(View view){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
    public void FunMainPage(View view){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}
