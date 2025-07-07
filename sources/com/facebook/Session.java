package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AuthorizationClient;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Session implements Serializable {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$SessionState = null;
    public static final String ACTION_ACTIVE_SESSION_CLOSED = "com.facebook.sdk.ACTIVE_SESSION_CLOSED";
    public static final String ACTION_ACTIVE_SESSION_OPENED = "com.facebook.sdk.ACTIVE_SESSION_OPENED";
    public static final String ACTION_ACTIVE_SESSION_SET = "com.facebook.sdk.ACTIVE_SESSION_SET";
    public static final String ACTION_ACTIVE_SESSION_UNSET = "com.facebook.sdk.ACTIVE_SESSION_UNSET";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    private static final String AUTH_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.authBundleKey";
    public static final int DEFAULT_AUTHORIZE_ACTIVITY_CODE = 64206;
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String SESSION_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.saveSessionKey";
    public static final String TAG = "com.facebook.Session";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    public static final String WEB_VIEW_ERROR_CODE_KEY = "com.facebook.sdk.WebViewErrorCode";
    public static final String WEB_VIEW_FAILING_URL_KEY = "com.facebook.sdk.FailingUrl";
    private static Session activeSession = null;
    private static final long serialVersionUID = 1;
    private static volatile Context staticContext;
    private AppEventsLogger appEventsLogger;
    private String applicationId;
    private volatile Bundle authorizationBundle;
    private AuthorizationClient authorizationClient;
    private AutoPublishAsyncTask autoPublishAsyncTask;
    private final List<StatusCallback> callbacks;
    private volatile TokenRefreshRequest currentTokenRefreshRequest;
    private Handler handler;
    private Date lastAttemptedTokenExtendDate;
    private final Object lock;
    private AuthorizationRequest pendingAuthorizationRequest;
    private SessionState state;
    private TokenCachingStrategy tokenCachingStrategy;
    private AccessToken tokenInfo;
    private static final Object STATIC_LOCK = new Object();
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = new HashSet<String>() { // from class: com.facebook.Session.1
        {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    };

    /* loaded from: classes3.dex */
    public static class AuthorizationRequest implements Serializable {
        private static final long serialVersionUID = 1;
        private String applicationId;
        private final String authId;
        private SessionDefaultAudience defaultAudience;
        private boolean isLegacy;
        private final Map<String, String> loggingExtras;
        private SessionLoginBehavior loginBehavior;
        private List<String> permissions;
        private int requestCode;
        private final StartActivityDelegate startActivityDelegate;
        private StatusCallback statusCallback;
        private String validateSameFbidAsToken;

        /* loaded from: classes3.dex */
        private static class AuthRequestSerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -8748347685113614927L;
            private final String applicationId;
            private final String defaultAudience;
            private boolean isLegacy;
            private final SessionLoginBehavior loginBehavior;
            private final List<String> permissions;
            private final int requestCode;
            private final String validateSameFbidAsToken;

            private AuthRequestSerializationProxyV1(SessionLoginBehavior sessionLoginBehavior, int i, List<String> list, String str, boolean z, String str2, String str3) {
                this.loginBehavior = sessionLoginBehavior;
                this.requestCode = i;
                this.permissions = list;
                this.defaultAudience = str;
                this.isLegacy = z;
                this.applicationId = str2;
                this.validateSameFbidAsToken = str3;
            }

            /* synthetic */ AuthRequestSerializationProxyV1(SessionLoginBehavior sessionLoginBehavior, int i, List list, String str, boolean z, String str2, String str3, AuthRequestSerializationProxyV1 authRequestSerializationProxyV1) {
                this(sessionLoginBehavior, i, list, str, z, str2, str3);
            }

            private Object readResolve() {
                return new AuthorizationRequest(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience, this.isLegacy, this.applicationId, this.validateSameFbidAsToken, null);
            }
        }

        AuthorizationRequest(final Activity activity) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.authId = UUID.randomUUID().toString();
            this.loggingExtras = new HashMap();
            this.startActivityDelegate = new StartActivityDelegate() { // from class: com.facebook.Session.AuthorizationRequest.1
                @Override // com.facebook.Session.StartActivityDelegate
                public Activity getActivityContext() {
                    return activity;
                }

                @Override // com.facebook.Session.StartActivityDelegate
                public void startActivityForResult(Intent intent, int i) {
                    activity.startActivityForResult(intent, i);
                }
            };
        }

        AuthorizationRequest(final Fragment fragment) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.authId = UUID.randomUUID().toString();
            this.loggingExtras = new HashMap();
            this.startActivityDelegate = new StartActivityDelegate() { // from class: com.facebook.Session.AuthorizationRequest.2
                @Override // com.facebook.Session.StartActivityDelegate
                public Activity getActivityContext() {
                    return fragment.getActivity();
                }

                @Override // com.facebook.Session.StartActivityDelegate
                public void startActivityForResult(Intent intent, int i) {
                    fragment.startActivityForResult(intent, i);
                }
            };
        }

        private AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, List<String> list, String str, boolean z, String str2, String str3) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.authId = UUID.randomUUID().toString();
            this.loggingExtras = new HashMap();
            this.startActivityDelegate = new StartActivityDelegate() { // from class: com.facebook.Session.AuthorizationRequest.3
                @Override // com.facebook.Session.StartActivityDelegate
                public Activity getActivityContext() {
                    throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
                }

                @Override // com.facebook.Session.StartActivityDelegate
                public void startActivityForResult(Intent intent, int i2) {
                    throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
                }
            };
            this.loginBehavior = sessionLoginBehavior;
            this.requestCode = i;
            this.permissions = list;
            this.defaultAudience = SessionDefaultAudience.valueOf(str);
            this.isLegacy = z;
            this.applicationId = str2;
            this.validateSameFbidAsToken = str3;
        }

        /* synthetic */ AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, List list, String str, boolean z, String str2, String str3, AuthorizationRequest authorizationRequest) {
            this(sessionLoginBehavior, i, list, str, z, str2, str3);
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Cannot readObject, serialization proxy required");
        }

        String getApplicationId() {
            return this.applicationId;
        }

        String getAuthId() {
            return this.authId;
        }

        AuthorizationClient.AuthorizationRequest getAuthorizationClientRequest() {
            return new AuthorizationClient.AuthorizationRequest(this.loginBehavior, this.requestCode, this.isLegacy, this.permissions, this.defaultAudience, this.applicationId, this.validateSameFbidAsToken, new AuthorizationClient.StartActivityDelegate() { // from class: com.facebook.Session.AuthorizationRequest.4
                @Override // com.facebook.AuthorizationClient.StartActivityDelegate
                public Activity getActivityContext() {
                    return AuthorizationRequest.this.startActivityDelegate.getActivityContext();
                }

                @Override // com.facebook.AuthorizationClient.StartActivityDelegate
                public void startActivityForResult(Intent intent, int i) {
                    AuthorizationRequest.this.startActivityDelegate.startActivityForResult(intent, i);
                }
            }, this.authId);
        }

        StatusCallback getCallback() {
            return this.statusCallback;
        }

        SessionDefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        SessionLoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        int getRequestCode() {
            return this.requestCode;
        }

        StartActivityDelegate getStartActivityDelegate() {
            return this.startActivityDelegate;
        }

        String getValidateSameFbidAsToken() {
            return this.validateSameFbidAsToken;
        }

        boolean isLegacy() {
            return this.isLegacy;
        }

        void setApplicationId(String str) {
            this.applicationId = str;
        }

        AuthorizationRequest setCallback(StatusCallback statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        AuthorizationRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            if (sessionDefaultAudience != null) {
                this.defaultAudience = sessionDefaultAudience;
            }
            return this;
        }

        public void setIsLegacy(boolean z) {
            this.isLegacy = z;
        }

        AuthorizationRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            if (sessionLoginBehavior != null) {
                this.loginBehavior = sessionLoginBehavior;
            }
            return this;
        }

        AuthorizationRequest setPermissions(List<String> list) {
            if (list != null) {
                this.permissions = list;
            }
            return this;
        }

        AuthorizationRequest setPermissions(String... strArr) {
            return setPermissions(Arrays.asList(strArr));
        }

        AuthorizationRequest setRequestCode(int i) {
            if (i >= 0) {
                this.requestCode = i;
            }
            return this;
        }

        void setValidateSameFbidAsToken(String str) {
            this.validateSameFbidAsToken = str;
        }

        Object writeReplace() {
            return new AuthRequestSerializationProxyV1(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience.name(), this.isLegacy, this.applicationId, this.validateSameFbidAsToken, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class AutoPublishAsyncTask extends AsyncTask<Void, Void, Void> {
        private final Context mApplicationContext;
        private final String mApplicationId;

        public AutoPublishAsyncTask(String str, Context context) {
            this.mApplicationId = str;
            this.mApplicationContext = context.getApplicationContext();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            try {
                Settings.publishInstallAndWaitForResponse(this.mApplicationContext, this.mApplicationId, true);
                return null;
            } catch (Exception e) {
                Utility.logd("Facebook-publish", e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r3) {
            synchronized (Session.this) {
                Session.this.autoPublishAsyncTask = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private String applicationId;
        private final Context context;
        private TokenCachingStrategy tokenCachingStrategy;

        public Builder(Context context) {
            this.context = context;
        }

        public Session build() {
            return new Session(this.context, this.applicationId, this.tokenCachingStrategy);
        }

        public Builder setApplicationId(String str) {
            this.applicationId = str;
            return this;
        }

        public Builder setTokenCachingStrategy(TokenCachingStrategy tokenCachingStrategy) {
            this.tokenCachingStrategy = tokenCachingStrategy;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class NewPermissionsRequest extends AuthorizationRequest {
        private static final long serialVersionUID = 1;

        public NewPermissionsRequest(Activity activity, List<String> list) {
            super(activity);
            setPermissions(list);
        }

        public NewPermissionsRequest(Activity activity, String... strArr) {
            super(activity);
            setPermissions(strArr);
        }

        public NewPermissionsRequest(Fragment fragment, List<String> list) {
            super(fragment);
            setPermissions(list);
        }

        public NewPermissionsRequest(Fragment fragment, String... strArr) {
            super(fragment);
            setPermissions(strArr);
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final NewPermissionsRequest setCallback(StatusCallback statusCallback) {
            super.setCallback(statusCallback);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final NewPermissionsRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            super.setDefaultAudience(sessionDefaultAudience);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final NewPermissionsRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            super.setLoginBehavior(sessionLoginBehavior);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final NewPermissionsRequest setRequestCode(int i) {
            super.setRequestCode(i);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OpenRequest extends AuthorizationRequest {
        private static final long serialVersionUID = 1;

        public OpenRequest(Activity activity) {
            super(activity);
        }

        public OpenRequest(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final OpenRequest setCallback(StatusCallback statusCallback) {
            super.setCallback(statusCallback);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final OpenRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            super.setDefaultAudience(sessionDefaultAudience);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final OpenRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            super.setLoginBehavior(sessionLoginBehavior);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public /* bridge */ /* synthetic */ AuthorizationRequest setPermissions(List list) {
            return setPermissions((List<String>) list);
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final OpenRequest setPermissions(List<String> list) {
            super.setPermissions(list);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final OpenRequest setPermissions(String... strArr) {
            super.setPermissions(strArr);
            return this;
        }

        @Override // com.facebook.Session.AuthorizationRequest
        public final OpenRequest setRequestCode(int i) {
            super.setRequestCode(i);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    private static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 7663436173185080063L;
        private final String applicationId;
        private final Date lastAttemptedTokenExtendDate;
        private final AuthorizationRequest pendingAuthorizationRequest;
        private final boolean shouldAutoPublish;
        private final SessionState state;
        private final AccessToken tokenInfo;

        SerializationProxyV1(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest) {
            this.applicationId = str;
            this.state = sessionState;
            this.tokenInfo = accessToken;
            this.lastAttemptedTokenExtendDate = date;
            this.shouldAutoPublish = z;
            this.pendingAuthorizationRequest = authorizationRequest;
        }

        private Object readResolve() {
            return new Session(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, this.shouldAutoPublish, this.pendingAuthorizationRequest, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface StartActivityDelegate {
        Activity getActivityContext();

        void startActivityForResult(Intent intent, int i);
    }

    /* loaded from: classes3.dex */
    public interface StatusCallback {
        void call(Session session, SessionState sessionState, Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class TokenRefreshRequest implements ServiceConnection {
        final Messenger messageReceiver;
        Messenger messageSender = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TokenRefreshRequest() {
            this.messageReceiver = new Messenger(new TokenRefreshRequestHandler(Session.this, this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanup() {
            if (Session.this.currentTokenRefreshRequest == this) {
                Session.this.currentTokenRefreshRequest = null;
            }
        }

        private void refreshToken() {
            Bundle bundle = new Bundle();
            bundle.putString("access_token", Session.this.getTokenInfo().getToken());
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            obtain.replyTo = this.messageReceiver;
            try {
                this.messageSender.send(obtain);
            } catch (RemoteException unused) {
                cleanup();
            }
        }

        public void bind() {
            Intent createTokenRefreshIntent = NativeProtocol.createTokenRefreshIntent(Session.getStaticContext());
            if (createTokenRefreshIntent == null || !Session.staticContext.bindService(createTokenRefreshIntent, this, 1)) {
                cleanup();
            } else {
                Session.this.setLastAttemptedTokenExtendDate(new Date());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.messageSender = new Messenger(iBinder);
            refreshToken();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            cleanup();
            Session.staticContext.unbindService(this);
        }
    }

    /* loaded from: classes3.dex */
    static class TokenRefreshRequestHandler extends Handler {
        private WeakReference<TokenRefreshRequest> refreshRequestWeakReference;
        private WeakReference<Session> sessionWeakReference;

        TokenRefreshRequestHandler(Session session, TokenRefreshRequest tokenRefreshRequest) {
            super(Looper.getMainLooper());
            this.sessionWeakReference = new WeakReference<>(session);
            this.refreshRequestWeakReference = new WeakReference<>(tokenRefreshRequest);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string = message.getData().getString("access_token");
            Session session = this.sessionWeakReference.get();
            if (session != null && string != null) {
                session.extendTokenCompleted(message.getData());
            }
            TokenRefreshRequest tokenRefreshRequest = this.refreshRequestWeakReference.get();
            if (tokenRefreshRequest != null) {
                Session.staticContext.unbindService(tokenRefreshRequest);
                tokenRefreshRequest.cleanup();
            }
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$SessionState() {
        int[] iArr = $SWITCH_TABLE$com$facebook$SessionState;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SessionState.valuesCustom().length];
        try {
            iArr2[SessionState.CLOSED.ordinal()] = 7;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SessionState.CLOSED_LOGIN_FAILED.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SessionState.CREATED.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[SessionState.CREATED_TOKEN_LOADED.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[SessionState.OPENED.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[SessionState.OPENED_TOKEN_UPDATED.ordinal()] = 5;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[SessionState.OPENING.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        $SWITCH_TABLE$com$facebook$SessionState = iArr2;
        return iArr2;
    }

    public Session(Context context) {
        this(context, null, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session(Context context, String str, TokenCachingStrategy tokenCachingStrategy) {
        this(context, str, tokenCachingStrategy, true);
    }

    Session(Context context, String str, TokenCachingStrategy tokenCachingStrategy, boolean z) {
        this.lastAttemptedTokenExtendDate = new Date(0L);
        this.lock = new Object();
        if (context != null && str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        initializeStaticContext(context);
        tokenCachingStrategy = tokenCachingStrategy == null ? new SharedPreferencesTokenCachingStrategy(staticContext) : tokenCachingStrategy;
        this.applicationId = str;
        this.tokenCachingStrategy = tokenCachingStrategy;
        this.state = SessionState.CREATED;
        this.pendingAuthorizationRequest = null;
        this.callbacks = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        Bundle load = z ? tokenCachingStrategy.load() : null;
        if (!TokenCachingStrategy.hasTokenInformation(load)) {
            this.tokenInfo = AccessToken.createEmptyToken(Collections.emptyList());
            return;
        }
        Date date = TokenCachingStrategy.getDate(load, TokenCachingStrategy.EXPIRATION_DATE_KEY);
        Date date2 = new Date();
        if (date == null || date.before(date2)) {
            tokenCachingStrategy.clear();
            this.tokenInfo = AccessToken.createEmptyToken(Collections.emptyList());
            return;
        }
        this.tokenInfo = AccessToken.createFromCache(load);
        this.state = SessionState.CREATED_TOKEN_LOADED;
    }

    private Session(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest) {
        this.lastAttemptedTokenExtendDate = new Date(0L);
        this.lock = new Object();
        this.applicationId = str;
        this.state = sessionState;
        this.tokenInfo = accessToken;
        this.lastAttemptedTokenExtendDate = date;
        this.pendingAuthorizationRequest = authorizationRequest;
        this.handler = new Handler(Looper.getMainLooper());
        this.currentTokenRefreshRequest = null;
        this.tokenCachingStrategy = null;
        this.callbacks = new ArrayList();
    }

    /* synthetic */ Session(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest, Session session) {
        this(str, sessionState, accessToken, date, z, authorizationRequest);
    }

    private static boolean areEqual(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private void autoPublishAsync() {
        AutoPublishAsyncTask autoPublishAsyncTask;
        String str;
        synchronized (this) {
            if (this.autoPublishAsyncTask == null && Settings.getShouldAutoPublishInstall() && (str = this.applicationId) != null) {
                autoPublishAsyncTask = new AutoPublishAsyncTask(str, staticContext);
                this.autoPublishAsyncTask = autoPublishAsyncTask;
            } else {
                autoPublishAsyncTask = null;
            }
        }
        if (autoPublishAsyncTask != null) {
            autoPublishAsyncTask.execute(new Void[0]);
        }
    }

    private void finishAuthorization(AccessToken accessToken, Exception exc) {
        SessionState sessionState;
        SessionState sessionState2 = this.state;
        if (accessToken == null) {
            if (exc != null) {
                sessionState = SessionState.CLOSED_LOGIN_FAILED;
            }
            this.pendingAuthorizationRequest = null;
            postStateChange(sessionState2, this.state, exc);
        }
        this.tokenInfo = accessToken;
        saveTokenToCache(accessToken);
        sessionState = SessionState.OPENED;
        this.state = sessionState;
        this.pendingAuthorizationRequest = null;
        postStateChange(sessionState2, this.state, exc);
    }

    private void finishReauthorization(AccessToken accessToken, Exception exc) {
        SessionState sessionState = this.state;
        if (accessToken != null) {
            this.tokenInfo = accessToken;
            saveTokenToCache(accessToken);
            this.state = SessionState.OPENED_TOKEN_UPDATED;
        }
        this.pendingAuthorizationRequest = null;
        postStateChange(sessionState, this.state, exc);
    }

    public static final Session getActiveSession() {
        Session session;
        synchronized (STATIC_LOCK) {
            session = activeSession;
        }
        return session;
    }

    private AppEventsLogger getAppEventsLogger() {
        AppEventsLogger appEventsLogger;
        synchronized (this.lock) {
            if (this.appEventsLogger == null) {
                this.appEventsLogger = AppEventsLogger.newLogger(staticContext, this.applicationId);
            }
            appEventsLogger = this.appEventsLogger;
        }
        return appEventsLogger;
    }

    private Intent getLoginActivityIntent(AuthorizationRequest authorizationRequest) {
        Intent intent = new Intent();
        intent.setClass(getStaticContext(), LoginActivity.class);
        intent.setAction(authorizationRequest.getLoginBehavior().toString());
        intent.putExtras(LoginActivity.populateIntentExtras(authorizationRequest.getAuthorizationClientRequest()));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getStaticContext() {
        return staticContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorizationResult(int i, AuthorizationClient.Result result) {
        Exception exc;
        AccessToken accessToken;
        if (i == -1) {
            if (result.code == AuthorizationClient.Result.Code.SUCCESS) {
                accessToken = result.token;
                exc = null;
            } else {
                exc = new FacebookAuthorizationException(result.errorMessage);
                accessToken = null;
            }
        } else if (i == 0) {
            exc = new FacebookOperationCanceledException(result.errorMessage);
            accessToken = null;
        } else {
            exc = null;
            accessToken = null;
        }
        logAuthorizationComplete(result.code, result.loggingExtras, exc);
        this.authorizationClient = null;
        finishAuthOrReauth(accessToken, exc);
    }

    static void initializeStaticContext(Context context) {
        if (context == null || staticContext != null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        staticContext = context;
    }

    public static boolean isPublishPermission(String str) {
        if (str != null) {
            return str.startsWith(PUBLISH_PERMISSION_PREFIX) || str.startsWith(MANAGE_PERMISSION_PREFIX) || OTHER_PUBLISH_PERMISSIONS.contains(str);
        }
        return false;
    }

    private void logAuthorizationComplete(AuthorizationClient.Result.Code code, Map<String, String> map, Exception exc) {
        Bundle bundle;
        AuthorizationRequest authorizationRequest = this.pendingAuthorizationRequest;
        if (authorizationRequest == null) {
            bundle = AuthorizationClient.newAuthorizationLoggingBundle("");
            bundle.putString("2_result", AuthorizationClient.Result.Code.ERROR.getLoggingValue());
            bundle.putString("5_error_message", "Unexpected call to logAuthorizationComplete with null pendingAuthorizationRequest.");
        } else {
            Bundle newAuthorizationLoggingBundle = AuthorizationClient.newAuthorizationLoggingBundle(authorizationRequest.getAuthId());
            if (code != null) {
                newAuthorizationLoggingBundle.putString("2_result", code.getLoggingValue());
            }
            if (exc != null && exc.getMessage() != null) {
                newAuthorizationLoggingBundle.putString("5_error_message", exc.getMessage());
            }
            JSONObject jSONObject = !this.pendingAuthorizationRequest.loggingExtras.isEmpty() ? new JSONObject(this.pendingAuthorizationRequest.loggingExtras) : null;
            if (map != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            if (jSONObject != null) {
                newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
            }
            bundle = newAuthorizationLoggingBundle;
        }
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        getAppEventsLogger().logSdkEvent("fb_mobile_login_complete", null, bundle);
    }

    private void logAuthorizationStart() {
        Bundle newAuthorizationLoggingBundle = AuthorizationClient.newAuthorizationLoggingBundle(this.pendingAuthorizationRequest.getAuthId());
        newAuthorizationLoggingBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", this.pendingAuthorizationRequest.loginBehavior.toString());
            jSONObject.put("request_code", this.pendingAuthorizationRequest.requestCode);
            jSONObject.put("is_legacy", this.pendingAuthorizationRequest.isLegacy);
            jSONObject.put("permissions", TextUtils.join(StringUtils.COMMA, this.pendingAuthorizationRequest.permissions));
            jSONObject.put("default_audience", this.pendingAuthorizationRequest.defaultAudience.toString());
            newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
        } catch (JSONException unused) {
        }
        getAppEventsLogger().logSdkEvent("fb_mobile_login_start", null, newAuthorizationLoggingBundle);
    }

    private void open(OpenRequest openRequest, SessionAuthorizationType sessionAuthorizationType) {
        SessionState sessionState;
        validatePermissions(openRequest, sessionAuthorizationType);
        validateLoginBehavior(openRequest);
        synchronized (this.lock) {
            if (this.pendingAuthorizationRequest != null) {
                SessionState sessionState2 = this.state;
                postStateChange(sessionState2, sessionState2, new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request."));
                return;
            }
            SessionState sessionState3 = this.state;
            int i = $SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()];
            if (i == 1) {
                sessionState = SessionState.OPENING;
                this.state = sessionState;
                if (openRequest == null) {
                    throw new IllegalArgumentException("openRequest cannot be null when opening a new Session");
                }
                this.pendingAuthorizationRequest = openRequest;
            } else if (i != 2) {
                throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
            } else {
                if (openRequest != null && !Utility.isNullOrEmpty(openRequest.getPermissions()) && !Utility.isSubset(openRequest.getPermissions(), getPermissions())) {
                    this.pendingAuthorizationRequest = openRequest;
                }
                sessionState = this.pendingAuthorizationRequest == null ? SessionState.OPENED : SessionState.OPENING;
                this.state = sessionState;
            }
            if (openRequest != null) {
                addCallback(openRequest.getCallback());
            }
            postStateChange(sessionState3, sessionState, null);
            if (sessionState == SessionState.OPENING) {
                authorize(openRequest);
            }
        }
    }

    public static Session openActiveSession(Activity activity, boolean z, StatusCallback statusCallback) {
        return openActiveSession(activity, z, new OpenRequest(activity).setCallback(statusCallback));
    }

    public static Session openActiveSession(Context context, Fragment fragment, boolean z, StatusCallback statusCallback) {
        return openActiveSession(context, z, new OpenRequest(fragment).setCallback(statusCallback));
    }

    private static Session openActiveSession(Context context, boolean z, OpenRequest openRequest) {
        Session build = new Builder(context).build();
        if (SessionState.CREATED_TOKEN_LOADED.equals(build.getState()) || z) {
            setActiveSession(build);
            build.openForRead(openRequest);
            return build;
        }
        return null;
    }

    public static Session openActiveSessionFromCache(Context context) {
        return openActiveSession(context, false, (OpenRequest) null);
    }

    public static Session openActiveSessionWithAccessToken(Context context, AccessToken accessToken, StatusCallback statusCallback) {
        Session session = new Session(context, null, null, false);
        setActiveSession(session);
        session.open(accessToken, statusCallback);
        return session;
    }

    static void postActiveSessionAction(String str) {
        LocalBroadcastManager.getInstance(getStaticContext()).sendBroadcast(new Intent(str));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Cannot readObject, serialization proxy required");
    }

    private void requestNewPermissions(NewPermissionsRequest newPermissionsRequest, SessionAuthorizationType sessionAuthorizationType) {
        validatePermissions(newPermissionsRequest, sessionAuthorizationType);
        validateLoginBehavior(newPermissionsRequest);
        if (newPermissionsRequest != null) {
            synchronized (this.lock) {
                if (this.pendingAuthorizationRequest != null) {
                    throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that has a pending request.");
                }
                if (!this.state.isOpened()) {
                    if (!this.state.isClosed()) {
                        throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that is not currently open.");
                    }
                    throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that has been closed.");
                }
                this.pendingAuthorizationRequest = newPermissionsRequest;
            }
            newPermissionsRequest.setValidateSameFbidAsToken(getAccessToken());
            authorize(newPermissionsRequest);
        }
    }

    private boolean resolveIntent(Intent intent) {
        return getStaticContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static final Session restoreSession(Context context, TokenCachingStrategy tokenCachingStrategy, StatusCallback statusCallback, Bundle bundle) {
        byte[] byteArray;
        String str;
        String str2;
        if (bundle != null && (byteArray = bundle.getByteArray(SESSION_BUNDLE_SAVE_KEY)) != null) {
            try {
                Session session = (Session) new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
                initializeStaticContext(context);
                if (tokenCachingStrategy == null) {
                    tokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(context);
                }
                session.tokenCachingStrategy = tokenCachingStrategy;
                if (statusCallback != null) {
                    session.addCallback(statusCallback);
                }
                session.authorizationBundle = bundle.getBundle(AUTH_BUNDLE_SAVE_KEY);
                return session;
            } catch (IOException e) {
                e = e;
                str = TAG;
                str2 = "Unable to restore session.";
                Log.w(str, str2, e);
                return null;
            } catch (ClassNotFoundException e2) {
                e = e2;
                str = TAG;
                str2 = "Unable to restore session";
                Log.w(str, str2, e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runWithHandlerOrExecutor(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            Settings.getExecutor().execute(runnable);
        }
    }

    public static final void saveSession(Session session, Bundle bundle) {
        if (bundle == null || session == null || bundle.containsKey(SESSION_BUNDLE_SAVE_KEY)) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(session);
            bundle.putByteArray(SESSION_BUNDLE_SAVE_KEY, byteArrayOutputStream.toByteArray());
            bundle.putBundle(AUTH_BUNDLE_SAVE_KEY, session.authorizationBundle);
        } catch (IOException e) {
            throw new FacebookException("Unable to save session.", e);
        }
    }

    private void saveTokenToCache(AccessToken accessToken) {
        TokenCachingStrategy tokenCachingStrategy;
        if (accessToken == null || (tokenCachingStrategy = this.tokenCachingStrategy) == null) {
            return;
        }
        tokenCachingStrategy.save(accessToken.toCacheBundle());
    }

    public static final void setActiveSession(Session session) {
        synchronized (STATIC_LOCK) {
            Session session2 = activeSession;
            if (session != session2) {
                if (session2 != null) {
                    session2.close();
                }
                activeSession = session;
                if (session2 != null) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_UNSET);
                }
                if (session != null) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_SET);
                    if (session.isOpened()) {
                        postActiveSessionAction(ACTION_ACTIVE_SESSION_OPENED);
                    }
                }
            }
        }
    }

    private void tryLegacyAuth(AuthorizationRequest authorizationRequest) {
        AuthorizationClient authorizationClient = new AuthorizationClient();
        this.authorizationClient = authorizationClient;
        authorizationClient.setOnCompletedListener(new AuthorizationClient.OnCompletedListener() { // from class: com.facebook.Session.2
            @Override // com.facebook.AuthorizationClient.OnCompletedListener
            public void onCompleted(AuthorizationClient.Result result) {
                Session.this.handleAuthorizationResult(result.code == AuthorizationClient.Result.Code.CANCEL ? 0 : -1, result);
            }
        });
        this.authorizationClient.setContext(getStaticContext());
        this.authorizationClient.startOrContinueAuth(authorizationRequest.getAuthorizationClientRequest());
    }

    private boolean tryLoginActivity(AuthorizationRequest authorizationRequest) {
        Intent loginActivityIntent = getLoginActivityIntent(authorizationRequest);
        if (resolveIntent(loginActivityIntent)) {
            try {
                authorizationRequest.getStartActivityDelegate().startActivityForResult(loginActivityIntent, authorizationRequest.getRequestCode());
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
        return false;
    }

    private void validateLoginBehavior(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest == null || authorizationRequest.isLegacy) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getStaticContext(), LoginActivity.class);
        if (!resolveIntent(intent)) {
            throw new FacebookException(String.format("Cannot use SessionLoginBehavior %s when %s is not declared as an activity in AndroidManifest.xml", authorizationRequest.getLoginBehavior(), LoginActivity.class.getName()));
        }
    }

    private void validatePermissions(AuthorizationRequest authorizationRequest, SessionAuthorizationType sessionAuthorizationType) {
        if (authorizationRequest == null || Utility.isNullOrEmpty(authorizationRequest.getPermissions())) {
            if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                throw new FacebookException("Cannot request publish or manage authorization with no permissions.");
            }
            return;
        }
        for (String str : authorizationRequest.getPermissions()) {
            if (isPublishPermission(str)) {
                if (SessionAuthorizationType.READ.equals(sessionAuthorizationType)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                }
            } else if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                Log.w(TAG, String.format("Should not pass a read permission (%s) to a request for publish or manage authorization", str));
            }
        }
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, false, this.pendingAuthorizationRequest);
    }

    public final void addCallback(StatusCallback statusCallback) {
        synchronized (this.callbacks) {
            if (statusCallback != null) {
                if (!this.callbacks.contains(statusCallback)) {
                    this.callbacks.add(statusCallback);
                }
            }
        }
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        authorizationRequest.setApplicationId(this.applicationId);
        autoPublishAsync();
        logAuthorizationStart();
        boolean tryLoginActivity = tryLoginActivity(authorizationRequest);
        this.pendingAuthorizationRequest.loggingExtras.put("try_login_activity", tryLoginActivity ? "1" : "0");
        if (!tryLoginActivity && authorizationRequest.isLegacy) {
            this.pendingAuthorizationRequest.loggingExtras.put("try_legacy", "1");
            tryLegacyAuth(authorizationRequest);
            tryLoginActivity = true;
        }
        if (tryLoginActivity) {
            return;
        }
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            int i = $SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()];
            if (i != 6 && i != 7) {
                this.state = SessionState.CLOSED_LOGIN_FAILED;
                FacebookException facebookException = new FacebookException("Log in attempt failed: LoginActivity could not be started, and not legacy request");
                logAuthorizationComplete(AuthorizationClient.Result.Code.ERROR, null, facebookException);
                postStateChange(sessionState, this.state, facebookException);
            }
        }
    }

    public final void close() {
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            int i = $SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 && i != 5) {
                        }
                    }
                }
                SessionState sessionState2 = SessionState.CLOSED;
                this.state = sessionState2;
                postStateChange(sessionState, sessionState2, null);
            }
            SessionState sessionState3 = SessionState.CLOSED_LOGIN_FAILED;
            this.state = sessionState3;
            postStateChange(sessionState, sessionState3, new FacebookException("Log in attempt aborted."));
        }
    }

    public final void closeAndClearTokenInformation() {
        TokenCachingStrategy tokenCachingStrategy = this.tokenCachingStrategy;
        if (tokenCachingStrategy != null) {
            tokenCachingStrategy.clear();
        }
        Utility.clearFacebookCookies(staticContext);
        Utility.clearCaches(staticContext);
        close();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Session) {
            Session session = (Session) obj;
            return areEqual(session.applicationId, this.applicationId) && areEqual(session.authorizationBundle, this.authorizationBundle) && areEqual(session.state, this.state) && areEqual(session.getExpirationDate(), getExpirationDate());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void extendAccessToken() {
        TokenRefreshRequest tokenRefreshRequest;
        synchronized (this.lock) {
            try {
                if (this.currentTokenRefreshRequest == null) {
                    tokenRefreshRequest = new TokenRefreshRequest();
                    this.currentTokenRefreshRequest = tokenRefreshRequest;
                } else {
                    tokenRefreshRequest = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (tokenRefreshRequest != null) {
            tokenRefreshRequest.bind();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            extendAccessToken();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void extendTokenCompleted(Bundle bundle) {
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            int i = $SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()];
            if (i == 4) {
                SessionState sessionState2 = SessionState.OPENED_TOKEN_UPDATED;
                this.state = sessionState2;
                postStateChange(sessionState, sessionState2, null);
            } else if (i != 5) {
                Log.d(TAG, "refreshToken ignored in state " + this.state);
            }
            AccessToken createFromRefresh = AccessToken.createFromRefresh(this.tokenInfo, bundle);
            this.tokenInfo = createFromRefresh;
            TokenCachingStrategy tokenCachingStrategy = this.tokenCachingStrategy;
            if (tokenCachingStrategy != null) {
                tokenCachingStrategy.save(createFromRefresh.toCacheBundle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishAuthOrReauth(AccessToken accessToken, Exception exc) {
        if (accessToken != null && accessToken.isInvalid()) {
            exc = new FacebookException("Invalid access token.");
            accessToken = null;
        }
        synchronized (this.lock) {
            switch ($SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()]) {
                case 1:
                case 2:
                case 6:
                case 7:
                    Log.d(TAG, "Unexpected call to finishAuthOrReauth in state " + this.state);
                    break;
                case 3:
                    finishAuthorization(accessToken, exc);
                    break;
                case 4:
                case 5:
                    finishReauthorization(accessToken, exc);
                    break;
            }
        }
    }

    public final String getAccessToken() {
        String token;
        synchronized (this.lock) {
            AccessToken accessToken = this.tokenInfo;
            token = accessToken == null ? null : accessToken.getToken();
        }
        return token;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final Bundle getAuthorizationBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = this.authorizationBundle;
        }
        return bundle;
    }

    public final Date getExpirationDate() {
        Date expires;
        synchronized (this.lock) {
            AccessToken accessToken = this.tokenInfo;
            expires = accessToken == null ? null : accessToken.getExpires();
        }
        return expires;
    }

    Date getLastAttemptedTokenExtendDate() {
        return this.lastAttemptedTokenExtendDate;
    }

    public final List<String> getPermissions() {
        List<String> permissions;
        synchronized (this.lock) {
            AccessToken accessToken = this.tokenInfo;
            permissions = accessToken == null ? null : accessToken.getPermissions();
        }
        return permissions;
    }

    public final SessionState getState() {
        SessionState sessionState;
        synchronized (this.lock) {
            sessionState = this.state;
        }
        return sessionState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessToken getTokenInfo() {
        return this.tokenInfo;
    }

    public int hashCode() {
        return 0;
    }

    public final boolean isClosed() {
        boolean isClosed;
        synchronized (this.lock) {
            isClosed = this.state.isClosed();
        }
        return isClosed;
    }

    public final boolean isOpened() {
        boolean isOpened;
        synchronized (this.lock) {
            isOpened = this.state.isOpened();
        }
        return isOpened;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onActivityResult(Activity activity, int i, int i2, Intent intent) {
        FacebookException facebookOperationCanceledException;
        AuthorizationClient.Result.Code code;
        Validate.notNull(activity, "currentActivity");
        initializeStaticContext(activity);
        synchronized (this.lock) {
            AuthorizationRequest authorizationRequest = this.pendingAuthorizationRequest;
            if (authorizationRequest != null && i == authorizationRequest.getRequestCode()) {
                AuthorizationClient.Result.Code code2 = AuthorizationClient.Result.Code.ERROR;
                if (intent != null) {
                    AuthorizationClient.Result result = (AuthorizationClient.Result) intent.getSerializableExtra("com.facebook.LoginActivity:Result");
                    if (result != null) {
                        handleAuthorizationResult(i2, result);
                        return true;
                    }
                    AuthorizationClient authorizationClient = this.authorizationClient;
                    if (authorizationClient != null) {
                        authorizationClient.onActivityResult(i, i2, intent);
                        return true;
                    }
                } else if (i2 == 0) {
                    facebookOperationCanceledException = new FacebookOperationCanceledException("User canceled operation.");
                    code = AuthorizationClient.Result.Code.CANCEL;
                    if (facebookOperationCanceledException == null) {
                        facebookOperationCanceledException = new FacebookException("Unexpected call to Session.onActivityResult");
                    }
                    logAuthorizationComplete(code, null, facebookOperationCanceledException);
                    finishAuthOrReauth(null, facebookOperationCanceledException);
                    return true;
                }
                code = code2;
                facebookOperationCanceledException = null;
                if (facebookOperationCanceledException == null) {
                }
                logAuthorizationComplete(code, null, facebookOperationCanceledException);
                finishAuthOrReauth(null, facebookOperationCanceledException);
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        addCallback(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void open(AccessToken accessToken, StatusCallback statusCallback) {
        synchronized (this.lock) {
            if (this.pendingAuthorizationRequest != null) {
                throw new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request.");
            }
            if (this.state.isClosed()) {
                throw new UnsupportedOperationException("Session: an attempt was made to open a previously-closed session.");
            }
            if (this.state != SessionState.CREATED && this.state != SessionState.CREATED_TOKEN_LOADED) {
                throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
            }
            this.tokenInfo = accessToken;
            TokenCachingStrategy tokenCachingStrategy = this.tokenCachingStrategy;
            if (tokenCachingStrategy != null) {
                tokenCachingStrategy.save(accessToken.toCacheBundle());
            }
            SessionState sessionState = this.state;
            SessionState sessionState2 = SessionState.OPENED;
            this.state = sessionState2;
            postStateChange(sessionState, sessionState2, null);
        }
        autoPublishAsync();
    }

    public final void openForPublish(OpenRequest openRequest) {
        open(openRequest, SessionAuthorizationType.PUBLISH);
    }

    public final void openForRead(OpenRequest openRequest) {
        open(openRequest, SessionAuthorizationType.READ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postStateChange(SessionState sessionState, final SessionState sessionState2, final Exception exc) {
        if (sessionState == sessionState2 && sessionState != SessionState.OPENED_TOKEN_UPDATED && exc == null) {
            return;
        }
        if (sessionState2.isClosed()) {
            this.tokenInfo = AccessToken.createEmptyToken(Collections.emptyList());
        }
        synchronized (this.callbacks) {
            runWithHandlerOrExecutor(this.handler, new Runnable() { // from class: com.facebook.Session.3
                @Override // java.lang.Runnable
                public void run() {
                    for (final StatusCallback statusCallback : Session.this.callbacks) {
                        final SessionState sessionState3 = sessionState2;
                        final Exception exc2 = exc;
                        Session.runWithHandlerOrExecutor(Session.this.handler, new Runnable() { // from class: com.facebook.Session.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                statusCallback.call(Session.this, sessionState3, exc2);
                            }
                        });
                    }
                }
            });
        }
        if (this != activeSession || sessionState.isOpened() == sessionState2.isOpened()) {
            return;
        }
        postActiveSessionAction(sessionState2.isOpened() ? ACTION_ACTIVE_SESSION_OPENED : ACTION_ACTIVE_SESSION_CLOSED);
    }

    public final void removeCallback(StatusCallback statusCallback) {
        synchronized (this.callbacks) {
            this.callbacks.remove(statusCallback);
        }
    }

    public final void requestNewPublishPermissions(NewPermissionsRequest newPermissionsRequest) {
        requestNewPermissions(newPermissionsRequest, SessionAuthorizationType.PUBLISH);
    }

    public final void requestNewReadPermissions(NewPermissionsRequest newPermissionsRequest) {
        requestNewPermissions(newPermissionsRequest, SessionAuthorizationType.READ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentTokenRefreshRequest(TokenRefreshRequest tokenRefreshRequest) {
        this.currentTokenRefreshRequest = tokenRefreshRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLastAttemptedTokenExtendDate(Date date) {
        this.lastAttemptedTokenExtendDate = date;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTokenInfo(AccessToken accessToken) {
        this.tokenInfo = accessToken;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldExtendAccessToken() {
        if (this.currentTokenRefreshRequest != null) {
            return false;
        }
        Date date = new Date();
        return this.state.isOpened() && this.tokenInfo.getSource().canExtendToken() && date.getTime() - this.lastAttemptedTokenExtendDate.getTime() > 3600000 && date.getTime() - this.tokenInfo.getLastRefresh().getTime() > CalendarModelKt.MillisecondsIn24Hours;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("{Session state:").append(this.state).append(", token:");
        AccessToken accessToken = this.tokenInfo;
        String str = AbstractJsonLexerKt.NULL;
        if (accessToken == null) {
            accessToken = AbstractJsonLexerKt.NULL;
        }
        StringBuilder append2 = append.append(accessToken).append(", appId:");
        String str2 = this.applicationId;
        if (str2 != null) {
            str = str2;
        }
        return append2.append(str).append("}").toString();
    }
}
