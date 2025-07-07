package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.Session;
import com.facebook.internal.NativeProtocol;
import com.facebook.widget.FacebookDialog;
import java.util.UUID;
/* loaded from: classes3.dex */
public class UiLifecycleHelper {
    private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
    private static final String DIALOG_CALL_BUNDLE_SAVE_KEY = "com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey";
    private final Activity activity;
    private AppEventsLogger appEventsLogger;
    private final LocalBroadcastManager broadcastManager;
    private final Session.StatusCallback callback;
    private FacebookDialog.PendingCall pendingFacebookDialogCall;
    private final BroadcastReceiver receiver;

    /* loaded from: classes3.dex */
    private class ActiveSessionBroadcastReceiver extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        /* synthetic */ ActiveSessionBroadcastReceiver(UiLifecycleHelper uiLifecycleHelper, ActiveSessionBroadcastReceiver activeSessionBroadcastReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Session activeSession;
            if (Session.ACTION_ACTIVE_SESSION_SET.equals(intent.getAction())) {
                Session activeSession2 = Session.getActiveSession();
                if (activeSession2 == null || UiLifecycleHelper.this.callback == null) {
                    return;
                }
                activeSession2.addCallback(UiLifecycleHelper.this.callback);
            } else if (!Session.ACTION_ACTIVE_SESSION_UNSET.equals(intent.getAction()) || (activeSession = Session.getActiveSession()) == null || UiLifecycleHelper.this.callback == null) {
            } else {
                activeSession.removeCallback(UiLifecycleHelper.this.callback);
            }
        }
    }

    public UiLifecycleHelper(Activity activity, Session.StatusCallback statusCallback) {
        if (activity == null) {
            throw new IllegalArgumentException(ACTIVITY_NULL_MESSAGE);
        }
        this.activity = activity;
        this.callback = statusCallback;
        this.receiver = new ActiveSessionBroadcastReceiver(this, null);
        this.broadcastManager = LocalBroadcastManager.getInstance(activity);
    }

    private void cancelPendingAppCall(FacebookDialog.Callback callback) {
        if (callback != null) {
            Intent requestIntent = this.pendingFacebookDialogCall.getRequestIntent();
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID, requestIntent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID));
            intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION, requestIntent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION));
            intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_VERSION, requestIntent.getIntExtra(NativeProtocol.EXTRA_PROTOCOL_VERSION, 0));
            intent.putExtra(NativeProtocol.STATUS_ERROR_TYPE, NativeProtocol.ERROR_UNKNOWN_ERROR);
            Activity activity = this.activity;
            FacebookDialog.PendingCall pendingCall = this.pendingFacebookDialogCall;
            FacebookDialog.handleActivityResult(activity, pendingCall, pendingCall.getRequestCode(), intent, callback);
        }
        this.pendingFacebookDialogCall = null;
    }

    private boolean handleFacebookDialogActivityResult(int i, int i2, Intent intent, FacebookDialog.Callback callback) {
        UUID fromString;
        FacebookDialog.PendingCall pendingCall = this.pendingFacebookDialogCall;
        if (pendingCall == null || pendingCall.getRequestCode() != i) {
            return false;
        }
        if (intent == null) {
            cancelPendingAppCall(callback);
            return true;
        }
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        if (stringExtra != null) {
            try {
                fromString = UUID.fromString(stringExtra);
            } catch (IllegalArgumentException unused) {
            }
            if (fromString == null && this.pendingFacebookDialogCall.getCallId().equals(fromString)) {
                FacebookDialog.handleActivityResult(this.activity, this.pendingFacebookDialogCall, i, intent, callback);
            } else {
                cancelPendingAppCall(callback);
            }
            this.pendingFacebookDialogCall = null;
            return true;
        }
        fromString = null;
        if (fromString == null) {
        }
        cancelPendingAppCall(callback);
        this.pendingFacebookDialogCall = null;
        return true;
    }

    public AppEventsLogger getAppEventsLogger() {
        Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            return null;
        }
        AppEventsLogger appEventsLogger = this.appEventsLogger;
        if (appEventsLogger == null || !appEventsLogger.isValidForSession(activeSession)) {
            if (this.appEventsLogger != null) {
                AppEventsLogger.onContextStop();
            }
            this.appEventsLogger = AppEventsLogger.newLogger(this.activity, activeSession);
        }
        return this.appEventsLogger;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent, null);
    }

    public void onActivityResult(int i, int i2, Intent intent, FacebookDialog.Callback callback) {
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            activeSession.onActivityResult(this.activity, i, i2, intent);
        }
        handleFacebookDialogActivityResult(i, i2, intent, callback);
    }

    public void onCreate(Bundle bundle) {
        Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            if (bundle != null) {
                activeSession = Session.restoreSession(this.activity, null, this.callback, bundle);
            }
            if (activeSession == null) {
                activeSession = new Session(this.activity);
            }
            Session.setActiveSession(activeSession);
        }
        if (bundle != null) {
            this.pendingFacebookDialogCall = (FacebookDialog.PendingCall) bundle.getParcelable(DIALOG_CALL_BUNDLE_SAVE_KEY);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
        Session activeSession;
        this.broadcastManager.unregisterReceiver(this.receiver);
        if (this.callback == null || (activeSession = Session.getActiveSession()) == null) {
            return;
        }
        activeSession.removeCallback(this.callback);
    }

    public void onResume() {
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            Session.StatusCallback statusCallback = this.callback;
            if (statusCallback != null) {
                activeSession.addCallback(statusCallback);
            }
            if (SessionState.CREATED_TOKEN_LOADED.equals(activeSession.getState())) {
                activeSession.openForRead(null);
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_SET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Session.saveSession(Session.getActiveSession(), bundle);
        bundle.putParcelable(DIALOG_CALL_BUNDLE_SAVE_KEY, this.pendingFacebookDialogCall);
    }

    public void onStop() {
        AppEventsLogger.onContextStop();
    }

    public void trackPendingDialogCall(FacebookDialog.PendingCall pendingCall) {
        if (this.pendingFacebookDialogCall != null) {
            Log.i("Facebook", "Tracking new app call while one is still pending; canceling pending call.");
            cancelPendingAppCall(null);
        }
        this.pendingFacebookDialogCall = pendingCall;
    }
}
