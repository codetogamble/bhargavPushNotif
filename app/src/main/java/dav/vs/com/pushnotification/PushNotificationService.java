package dav.vs.com.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by touchy on 17/2/16.
 */
public class PushNotificationService extends GcmListenerService {
    int notifId = 2;

    @Override
    public void onMessageReceived(String from, Bundle data) {
        String message = data.getString("message");
        Intent intent = new Intent(this, MainActivity.class);
        intent.setAction("notification");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        if (message != null) {
            Log.d("reg", message);
            Notification.Builder nBuilder = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.bell)
                    .setContentTitle(message)
                    .setContentText("Hellooo !!").setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(notifId, nBuilder.build());
        } else {
            Log.d("reg", "message is null");
        }
        //createNotification(mTitle, push_msg);
    }
}
