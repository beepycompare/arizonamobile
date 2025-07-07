package com.facebook.widget;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.Session;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import java.util.Date;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FacebookFragment extends Fragment {
    private SessionTracker sessionTracker;

    /* loaded from: classes3.dex */
    private class DefaultSessionStatusCallback implements Session.StatusCallback {
        private DefaultSessionStatusCallback() {
        }

        /* synthetic */ DefaultSessionStatusCallback(FacebookFragment facebookFragment, DefaultSessionStatusCallback defaultSessionStatusCallback) {
            this();
        }

        @Override // com.facebook.Session.StatusCallback
        public void call(Session session, SessionState sessionState, Exception exc) {
            FacebookFragment.this.onSessionStateChange(sessionState, exc);
        }
    }

    private void openSession(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i, SessionAuthorizationType sessionAuthorizationType) {
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker != null) {
            Session session = sessionTracker.getSession();
            if (session == null || session.getState().isClosed()) {
                session = new Session.Builder(getActivity()).setApplicationId(str).build();
                Session.setActiveSession(session);
            }
            if (session.isOpened()) {
                return;
            }
            Session.OpenRequest requestCode = new Session.OpenRequest(this).setPermissions(list).setLoginBehavior(sessionLoginBehavior).setRequestCode(i);
            if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                session.openForPublish(requestCode);
            } else {
                session.openForRead(requestCode);
            }
        }
    }

    protected final void closeSession() {
        Session openSession;
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker == null || (openSession = sessionTracker.getOpenSession()) == null) {
            return;
        }
        openSession.close();
    }

    protected final void closeSessionAndClearTokenInformation() {
        Session openSession;
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker == null || (openSession = sessionTracker.getOpenSession()) == null) {
            return;
        }
        openSession.closeAndClearTokenInformation();
    }

    protected final String getAccessToken() {
        Session openSession;
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker == null || (openSession = sessionTracker.getOpenSession()) == null) {
            return null;
        }
        return openSession.getAccessToken();
    }

    protected final Date getExpirationDate() {
        Session openSession;
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker == null || (openSession = sessionTracker.getOpenSession()) == null) {
            return null;
        }
        return openSession.getExpirationDate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Session getSession() {
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker != null) {
            return sessionTracker.getSession();
        }
        return null;
    }

    protected final List<String> getSessionPermissions() {
        Session session;
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker == null || (session = sessionTracker.getSession()) == null) {
            return null;
        }
        return session.getPermissions();
    }

    protected final SessionState getSessionState() {
        Session session;
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker == null || (session = sessionTracker.getSession()) == null) {
            return null;
        }
        return session.getState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isSessionOpen() {
        SessionTracker sessionTracker = this.sessionTracker;
        return (sessionTracker == null || sessionTracker.getOpenSession() == null) ? false : true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker(getActivity(), new DefaultSessionStatusCallback(this, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.sessionTracker.getSession().onActivityResult(getActivity(), i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.sessionTracker.stopTracking();
    }

    protected void onSessionStateChange(SessionState sessionState, Exception exc) {
    }

    protected final void openSession() {
        openSessionForRead(null, null);
    }

    protected final void openSessionForPublish(String str, List<String> list) {
        openSessionForPublish(str, list, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForPublish(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i) {
        openSession(str, list, sessionLoginBehavior, i, SessionAuthorizationType.PUBLISH);
    }

    protected final void openSessionForRead(String str, List<String> list) {
        openSessionForRead(str, list, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForRead(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i) {
        openSession(str, list, sessionLoginBehavior, i, SessionAuthorizationType.READ);
    }

    public void setSession(Session session) {
        SessionTracker sessionTracker = this.sessionTracker;
        if (sessionTracker != null) {
            sessionTracker.setSession(session);
        }
    }
}
