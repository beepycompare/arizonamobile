package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.Session;
import com.facebook.SessionState;
/* loaded from: classes3.dex */
public class SessionTracker {
    private final LocalBroadcastManager broadcastManager;
    private final Session.StatusCallback callback;
    private boolean isTracking;
    private final BroadcastReceiver receiver;
    private Session session;

    /* loaded from: classes3.dex */
    private class ActiveSessionBroadcastReceiver extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        /* synthetic */ ActiveSessionBroadcastReceiver(SessionTracker sessionTracker, ActiveSessionBroadcastReceiver activeSessionBroadcastReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Session activeSession;
            if (!Session.ACTION_ACTIVE_SESSION_SET.equals(intent.getAction()) || (activeSession = Session.getActiveSession()) == null) {
                return;
            }
            activeSession.addCallback(SessionTracker.this.callback);
        }
    }

    /* loaded from: classes3.dex */
    private class CallbackWrapper implements Session.StatusCallback {
        private final Session.StatusCallback wrapped;

        public CallbackWrapper(Session.StatusCallback statusCallback) {
            this.wrapped = statusCallback;
        }

        @Override // com.facebook.Session.StatusCallback
        public void call(Session session, SessionState sessionState, Exception exc) {
            if (this.wrapped != null && SessionTracker.this.isTracking()) {
                this.wrapped.call(session, sessionState, exc);
            }
            if (session == SessionTracker.this.session && sessionState.isClosed()) {
                SessionTracker.this.setSession(null);
            }
        }
    }

    public SessionTracker(Context context, Session.StatusCallback statusCallback) {
        this(context, statusCallback, null);
    }

    SessionTracker(Context context, Session.StatusCallback statusCallback, Session session) {
        this(context, statusCallback, session, true);
    }

    public SessionTracker(Context context, Session.StatusCallback statusCallback, Session session, boolean z) {
        this.isTracking = false;
        this.callback = new CallbackWrapper(statusCallback);
        this.session = session;
        this.receiver = new ActiveSessionBroadcastReceiver(this, null);
        this.broadcastManager = LocalBroadcastManager.getInstance(context);
        if (z) {
            startTracking();
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_SET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public Session getOpenSession() {
        Session session = getSession();
        if (session == null || !session.isOpened()) {
            return null;
        }
        return session;
    }

    public Session getSession() {
        Session session = this.session;
        return session == null ? Session.getActiveSession() : session;
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    public boolean isTrackingActiveSession() {
        return this.session == null;
    }

    public void setSession(Session session) {
        if (session == null) {
            Session session2 = this.session;
            if (session2 == null) {
                return;
            }
            session2.removeCallback(this.callback);
            this.session = null;
            addBroadcastReceiver();
            if (getSession() == null) {
                return;
            }
            session = getSession();
        } else {
            Session session3 = this.session;
            if (session3 == null) {
                Session activeSession = Session.getActiveSession();
                if (activeSession != null) {
                    activeSession.removeCallback(this.callback);
                }
                this.broadcastManager.unregisterReceiver(this.receiver);
            } else {
                session3.removeCallback(this.callback);
            }
            this.session = session;
        }
        session.addCallback(this.callback);
    }

    public void startTracking() {
        if (this.isTracking) {
            return;
        }
        if (this.session == null) {
            addBroadcastReceiver();
        }
        if (getSession() != null) {
            getSession().addCallback(this.callback);
        }
        this.isTracking = true;
    }

    public void stopTracking() {
        if (this.isTracking) {
            Session session = getSession();
            if (session != null) {
                session.removeCallback(this.callback);
            }
            this.broadcastManager.unregisterReceiver(this.receiver);
            this.isTracking = false;
        }
    }
}
