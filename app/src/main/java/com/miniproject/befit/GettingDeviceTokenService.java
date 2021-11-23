package com.miniproject.befit;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;


public class GettingDeviceTokenService extends MyFirebaseMessagingService{

   String TAG = "MyFirebaseInstanceIdService";

    @Override
    public void onNewToken( String s) {
        super.onNewToken(s);
        Log.d("NEW TOKEN",s);
    }
}