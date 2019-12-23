package com.vp19.whautomate.Service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.vp19.whautomate.MainActivity;
import com.vp19.whautomate.R;

import java.net.URLEncoder;

import static android.content.Context.ALARM_SERVICE;

public class WhautomateService {

    public static  void sendWhatsappMessage(Context context , String message , String phone) {

        PackageManager packageManager= context.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        message = message + context.getApplicationContext ().getString (R.string.whatsapp_suffix);
        try {
            String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (i.resolveActivity(packageManager) != null) {
                context.startActivity(i);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
