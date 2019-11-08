package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
    }

    public void sendSMS(View view){
        EditText txtMobileNum = (EditText) findViewById(R.id.txtMobileNumber);
        EditText txtMessage = (EditText) findViewById(R.id.txtMessage);
        Button btnSend = (Button) findViewById(R.id.btnSend);
        try{
            //Send message by using SMS manager
            String mobileNum = txtMobileNum.getText().toString();
            String message = txtMessage.getText().toString();
            SmsManager smsMgr = SmsManager.getDefault();
            smsMgr.sendTextMessage(mobileNum,null,message,null,null);

            //Send message by opening default sms app
           /* Intent i = new Intent(Intent.ACTION_VIEW);
              i.setData(Uri.parse("smsto:"));
              i.setType("vnd.android-dir/mms-sms");
              i.putExtra("address", new String(mobileNum));
              i.putExtra("sms_body",message);
             startActivity(Intent.createChooser(i, "Send sms via:")); */
        }catch (Exception e){
            e.printStackTrace();

            Toast.makeText(this,"SMS failed to send. Try again later",Toast.LENGTH_LONG).show();
        }
    }
}
