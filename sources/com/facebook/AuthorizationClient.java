package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.Request;
import com.facebook.RequestBatch;
import com.facebook.android.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphUser;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.WebDialog;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AuthorizationClient implements Serializable {
    static final String EVENT_EXTRAS_APP_CALL_ID = "call_id";
    static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    static final String EVENT_EXTRAS_IS_LEGACY = "is_legacy";
    static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    static final String EVENT_EXTRAS_PROTOCOL_VERSION = "protocol_version";
    static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    static final String EVENT_EXTRAS_SERVICE_DISABLED = "service_disabled";
    static final String EVENT_EXTRAS_TRY_LEGACY = "try_legacy";
    static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    static final String EVENT_EXTRAS_WRITE_PRIVACY = "write_privacy";
    static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    private static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    private static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    static final String EVENT_PARAM_EXTRAS = "6_extras";
    static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    static final String EVENT_PARAM_METHOD = "3_method";
    private static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    private static final String TAG = "Facebook-AuthorizationClient";
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    private static final long serialVersionUID = 1;
    private transient AppEventsLogger appEventsLogger;
    transient BackgroundProcessingListener backgroundProcessingListener;
    transient boolean checkedInternetPermission;
    transient Context context;
    AuthHandler currentHandler;
    List<AuthHandler> handlersToTry;
    Map<String, String> loggingExtras;
    transient OnCompletedListener onCompletedListener;
    AuthorizationRequest pendingRequest;
    transient StartActivityDelegate startActivityDelegate;

    /* loaded from: classes3.dex */
    static class AuthDialogBuilder extends WebDialog.Builder {
        private static final String OAUTH_DIALOG = "oauth";
        static final String REDIRECT_URI = "fbconnect://success";
        private String e2e;

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, OAUTH_DIALOG, bundle);
        }

        @Override // com.facebook.widget.WebDialog.Builder, com.facebook.widget.WebDialog.BuilderBase
        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "fbconnect://success");
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.e2e);
            return new WebDialog(getContext(), OAUTH_DIALOG, parameters, getTheme(), getListener());
        }

        public AuthDialogBuilder setE2E(String str) {
            this.e2e = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public abstract class AuthHandler implements Serializable {
        private static final long serialVersionUID = 1;
        Map<String, String> methodLoggingExtras;

        AuthHandler() {
        }

        protected void addLoggingExtra(String str, String str2) {
            if (this.methodLoggingExtras == null) {
                this.methodLoggingExtras = new HashMap();
            }
            this.methodLoggingExtras.put(str, str2);
        }

        void cancel() {
        }

        abstract String getNameForLogging();

        boolean needsInternetPermission() {
            return false;
        }

        boolean needsRestart() {
            return false;
        }

        boolean onActivityResult(int i, int i2, Intent intent) {
            return false;
        }

        abstract boolean tryAuthorize(AuthorizationRequest authorizationRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AuthorizationRequest implements Serializable {
        private static final long serialVersionUID = 1;
        private final String applicationId;
        private final String authId;
        private final SessionDefaultAudience defaultAudience;
        private boolean isLegacy;
        private final SessionLoginBehavior loginBehavior;
        private List<String> permissions;
        private final String previousAccessToken;
        private final int requestCode;
        private final transient StartActivityDelegate startActivityDelegate;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, boolean z, List<String> list, SessionDefaultAudience sessionDefaultAudience, String str, String str2, StartActivityDelegate startActivityDelegate, String str3) {
            this.loginBehavior = sessionLoginBehavior;
            this.requestCode = i;
            this.isLegacy = z;
            this.permissions = list;
            this.defaultAudience = sessionDefaultAudience;
            this.applicationId = str;
            this.previousAccessToken = str2;
            this.startActivityDelegate = startActivityDelegate;
            this.authId = str3;
        }

        String getApplicationId() {
            return this.applicationId;
        }

        String getAuthId() {
            return this.authId;
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

        String getPreviousAccessToken() {
            return this.previousAccessToken;
        }

        int getRequestCode() {
            return this.requestCode;
        }

        StartActivityDelegate getStartActivityDelegate() {
            return this.startActivityDelegate;
        }

        boolean isLegacy() {
            return this.isLegacy;
        }

        boolean needsNewTokenValidation() {
            return (this.previousAccessToken == null || this.isLegacy) ? false : true;
        }

        void setIsLegacy(boolean z) {
            this.isLegacy = z;
        }

        void setPermissions(List<String> list) {
            this.permissions = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class GetTokenAuthHandler extends AuthHandler {
        private static final long serialVersionUID = 1;
        private transient GetTokenClient getTokenClient;

        GetTokenAuthHandler() {
            super();
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        void cancel() {
            GetTokenClient getTokenClient = this.getTokenClient;
            if (getTokenClient != null) {
                getTokenClient.cancel();
                this.getTokenClient = null;
            }
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        String getNameForLogging() {
            return "get_token";
        }

        void getTokenCompleted(AuthorizationRequest authorizationRequest, Bundle bundle) {
            this.getTokenClient = null;
            AuthorizationClient.this.notifyBackgroundProcessingStop();
            if (bundle != null) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
                List<String> permissions = authorizationRequest.getPermissions();
                if (stringArrayList != null && (permissions == null || stringArrayList.containsAll(permissions))) {
                    AuthorizationClient.this.completeAndValidate(Result.createTokenResult(AuthorizationClient.this.pendingRequest, AccessToken.createFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE)));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (String str : permissions) {
                    if (!stringArrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    addLoggingExtra(AuthorizationClient.EVENT_EXTRAS_NEW_PERMISSIONS, TextUtils.join(StringUtils.COMMA, arrayList));
                }
                authorizationRequest.setPermissions(arrayList);
            }
            AuthorizationClient.this.tryNextHandler();
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean tryAuthorize(final AuthorizationRequest authorizationRequest) {
            GetTokenClient getTokenClient = new GetTokenClient(AuthorizationClient.this.context, authorizationRequest.getApplicationId());
            this.getTokenClient = getTokenClient;
            if (getTokenClient.start()) {
                AuthorizationClient.this.notifyBackgroundProcessingStart();
                this.getTokenClient.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.AuthorizationClient.GetTokenAuthHandler.1
                    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
                    public void completed(Bundle bundle) {
                        GetTokenAuthHandler.this.getTokenCompleted(authorizationRequest, bundle);
                    }
                });
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    abstract class KatanaAuthHandler extends AuthHandler {
        private static final long serialVersionUID = 1;

        KatanaAuthHandler() {
            super();
        }

        protected boolean tryIntent(Intent intent, int i) {
            if (intent == null) {
                return false;
            }
            try {
                AuthorizationClient.this.getStartActivityDelegate().startActivityForResult(intent, i);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class KatanaLoginDialogAuthHandler extends KatanaAuthHandler {
        private static final long serialVersionUID = 1;
        private String applicationId;
        private String callId;

        KatanaLoginDialogAuthHandler() {
            super();
        }

        private Result createCancelOrErrorResult(AuthorizationRequest authorizationRequest, Intent intent) {
            String string;
            Bundle extras = intent.getExtras();
            String string2 = extras.getString(NativeProtocol.STATUS_ERROR_TYPE);
            if (NativeProtocol.ERROR_USER_CANCELED.equals(string2) || NativeProtocol.ERROR_PERMISSION_DENIED.equals(string2)) {
                return Result.createCancelResult(authorizationRequest, intent.getStringExtra(NativeProtocol.STATUS_ERROR_DESCRIPTION));
            }
            String string3 = extras.getString(NativeProtocol.STATUS_ERROR_JSON);
            if (string3 != null) {
                try {
                    string = new JSONObject(string3).getString("error_code");
                } catch (JSONException unused) {
                }
                return Result.createErrorResult(authorizationRequest, string2, intent.getStringExtra(NativeProtocol.STATUS_ERROR_DESCRIPTION), string);
            }
            string = null;
            return Result.createErrorResult(authorizationRequest, string2, intent.getStringExtra(NativeProtocol.STATUS_ERROR_DESCRIPTION), string);
        }

        private Result handleResultOk(Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString(NativeProtocol.STATUS_ERROR_TYPE);
            if (string == null) {
                return Result.createTokenResult(AuthorizationClient.this.pendingRequest, AccessToken.createFromNativeLogin(extras, AccessTokenSource.FACEBOOK_APPLICATION_NATIVE));
            }
            if (NativeProtocol.ERROR_SERVICE_DISABLED.equals(string)) {
                addLoggingExtra("service_disabled", "1");
                return null;
            }
            return createCancelOrErrorResult(AuthorizationClient.this.pendingRequest, intent);
        }

        private void logEvent(String str, String str2, String str3) {
            if (str3 != null) {
                AppEventsLogger newLogger = AppEventsLogger.newLogger(AuthorizationClient.this.context, this.applicationId);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", this.applicationId);
                bundle.putString(AnalyticsEvents.PARAMETER_ACTION_ID, str3);
                bundle.putLong(str2, System.currentTimeMillis());
                newLogger.logSdkEvent(str, null, bundle);
            }
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        String getNameForLogging() {
            return "katana_login_dialog";
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean onActivityResult(int i, int i2, Intent intent) {
            logEvent(AnalyticsEvents.EVENT_NATIVE_LOGIN_DIALOG_COMPLETE, AnalyticsEvents.PARAMETER_NATIVE_LOGIN_DIALOG_COMPLETE_TIME, this.callId);
            Result createCancelResult = intent == null ? Result.createCancelResult(AuthorizationClient.this.pendingRequest, "Operation canceled") : NativeProtocol.isServiceDisabledResult20121101(intent) ? null : i2 == 0 ? createCancelOrErrorResult(AuthorizationClient.this.pendingRequest, intent) : i2 != -1 ? Result.createErrorResult(AuthorizationClient.this.pendingRequest, "Unexpected resultCode from authorization.", null) : handleResultOk(intent);
            if (createCancelResult != null) {
                AuthorizationClient.this.completeAndValidate(createCancelResult);
                return true;
            }
            AuthorizationClient.this.tryNextHandler();
            return true;
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean tryAuthorize(AuthorizationRequest authorizationRequest) {
            this.applicationId = authorizationRequest.getApplicationId();
            Intent createLoginDialog20121101Intent = NativeProtocol.createLoginDialog20121101Intent(AuthorizationClient.this.context, authorizationRequest.getApplicationId(), new ArrayList(authorizationRequest.getPermissions()), authorizationRequest.getDefaultAudience().getNativeProtocolAudience());
            if (createLoginDialog20121101Intent == null) {
                return false;
            }
            String stringExtra = createLoginDialog20121101Intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
            this.callId = stringExtra;
            addLoggingExtra(AuthorizationClient.EVENT_EXTRAS_APP_CALL_ID, stringExtra);
            addLoggingExtra("protocol_version", createLoginDialog20121101Intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_VERSION));
            addLoggingExtra(AuthorizationClient.EVENT_EXTRAS_PERMISSIONS, TextUtils.join(StringUtils.COMMA, createLoginDialog20121101Intent.getStringArrayListExtra(NativeProtocol.EXTRA_PERMISSIONS)));
            addLoggingExtra(AuthorizationClient.EVENT_EXTRAS_WRITE_PRIVACY, createLoginDialog20121101Intent.getStringExtra(NativeProtocol.EXTRA_WRITE_PRIVACY));
            logEvent(AnalyticsEvents.EVENT_NATIVE_LOGIN_DIALOG_START, AnalyticsEvents.PARAMETER_NATIVE_LOGIN_DIALOG_START_TIME, this.callId);
            return tryIntent(createLoginDialog20121101Intent, authorizationRequest.getRequestCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class KatanaProxyAuthHandler extends KatanaAuthHandler {
        private static final long serialVersionUID = 1;
        private String applicationId;

        KatanaProxyAuthHandler() {
            super();
        }

        private Result handleResultOk(Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("error");
            if (string == null) {
                string = extras.getString("error_type");
            }
            String string2 = extras.getString("error_code");
            String string3 = extras.getString("error_message");
            if (string3 == null) {
                string3 = extras.getString("error_description");
            }
            String string4 = extras.getString("e2e");
            if (!Utility.isNullOrEmpty(string4)) {
                AuthorizationClient.this.logWebLoginCompleted(this.applicationId, string4);
            }
            if (string == null && string2 == null && string3 == null) {
                return Result.createTokenResult(AuthorizationClient.this.pendingRequest, AccessToken.createFromWebBundle(AuthorizationClient.this.pendingRequest.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB));
            } else if (ServerProtocol.errorsProxyAuthDisabled.contains(string)) {
                return null;
            } else {
                return ServerProtocol.errorsUserCanceled.contains(string) ? Result.createCancelResult(AuthorizationClient.this.pendingRequest, null) : Result.createErrorResult(AuthorizationClient.this.pendingRequest, string, string3, string2);
            }
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        String getNameForLogging() {
            return "katana_proxy_auth";
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
        @Override // com.facebook.AuthorizationClient.AuthHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean onActivityResult(int i, int i2, Intent intent) {
            Result createErrorResult;
            AuthorizationRequest authorizationRequest;
            String stringExtra;
            if (intent == null) {
                authorizationRequest = AuthorizationClient.this.pendingRequest;
                stringExtra = "Operation canceled";
            } else if (i2 != 0) {
                createErrorResult = i2 != -1 ? Result.createErrorResult(AuthorizationClient.this.pendingRequest, "Unexpected resultCode from authorization.", null) : handleResultOk(intent);
                if (createErrorResult == null) {
                    AuthorizationClient.this.completeAndValidate(createErrorResult);
                    return true;
                }
                AuthorizationClient.this.tryNextHandler();
                return true;
            } else {
                authorizationRequest = AuthorizationClient.this.pendingRequest;
                stringExtra = intent.getStringExtra("error");
            }
            createErrorResult = Result.createCancelResult(authorizationRequest, stringExtra);
            if (createErrorResult == null) {
            }
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean tryAuthorize(AuthorizationRequest authorizationRequest) {
            this.applicationId = authorizationRequest.getApplicationId();
            String access$0 = AuthorizationClient.access$0();
            Intent createProxyAuthIntent = NativeProtocol.createProxyAuthIntent(AuthorizationClient.this.context, authorizationRequest.getApplicationId(), authorizationRequest.getPermissions(), access$0);
            addLoggingExtra("e2e", access$0);
            return tryIntent(createProxyAuthIntent, authorizationRequest.getRequestCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Result implements Serializable {
        private static final long serialVersionUID = 1;
        final Code code;
        final String errorCode;
        final String errorMessage;
        Map<String, String> loggingExtras;
        final AuthorizationRequest request;
        final AccessToken token;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public enum Code {
            SUCCESS(FirebaseAnalytics.Param.SUCCESS),
            CANCEL(FacebookDialog.COMPLETION_GESTURE_CANCEL),
            ERROR("error");
            
            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static Code[] valuesCustom() {
                Code[] valuesCustom = values();
                int length = valuesCustom.length;
                Code[] codeArr = new Code[length];
                System.arraycopy(valuesCustom, 0, codeArr, 0, length);
                return codeArr;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public String getLoggingValue() {
                return this.loggingValue;
            }
        }

        private Result(AuthorizationRequest authorizationRequest, Code code, AccessToken accessToken, String str, String str2) {
            this.request = authorizationRequest;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        static Result createCancelResult(AuthorizationRequest authorizationRequest, String str) {
            return new Result(authorizationRequest, Code.CANCEL, null, str, null);
        }

        static Result createErrorResult(AuthorizationRequest authorizationRequest, String str, String str2) {
            return createErrorResult(authorizationRequest, str, str2, null);
        }

        static Result createErrorResult(AuthorizationRequest authorizationRequest, String str, String str2, String str3) {
            return new Result(authorizationRequest, Code.ERROR, null, TextUtils.join(": ", Utility.asListNoNulls(str, str2)), str3);
        }

        static Result createTokenResult(AuthorizationRequest authorizationRequest, AccessToken accessToken) {
            return new Result(authorizationRequest, Code.SUCCESS, accessToken, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface StartActivityDelegate {
        Activity getActivityContext();

        void startActivityForResult(Intent intent, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class WebViewAuthHandler extends AuthHandler {
        private static final long serialVersionUID = 1;
        private String applicationId;
        private String e2e;
        private transient WebDialog loginDialog;

        WebViewAuthHandler() {
            super();
        }

        private String loadCookieToken() {
            return AuthorizationClient.this.getStartActivityDelegate().getActivityContext().getSharedPreferences(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, "");
        }

        private void saveCookieToken(String str) {
            SharedPreferences.Editor edit = AuthorizationClient.this.getStartActivityDelegate().getActivityContext().getSharedPreferences(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_STORE, 0).edit();
            edit.putString(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, str);
            if (edit.commit()) {
                return;
            }
            Utility.logd(AuthorizationClient.TAG, "Could not update saved web view auth handler token.");
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        void cancel() {
            WebDialog webDialog = this.loginDialog;
            if (webDialog != null) {
                webDialog.dismiss();
                this.loginDialog = null;
            }
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        String getNameForLogging() {
            return "web_view";
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean needsInternetPermission() {
            return true;
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean needsRestart() {
            return true;
        }

        void onWebDialogComplete(AuthorizationRequest authorizationRequest, Bundle bundle, FacebookException facebookException) {
            String str;
            Result createErrorResult;
            if (bundle != null) {
                if (bundle.containsKey("e2e")) {
                    this.e2e = bundle.getString("e2e");
                }
                AccessToken createFromWebBundle = AccessToken.createFromWebBundle(authorizationRequest.getPermissions(), bundle, AccessTokenSource.WEB_VIEW);
                createErrorResult = Result.createTokenResult(AuthorizationClient.this.pendingRequest, createFromWebBundle);
                CookieSyncManager.createInstance(AuthorizationClient.this.context).sync();
                saveCookieToken(createFromWebBundle.getToken());
            } else if (facebookException instanceof FacebookOperationCanceledException) {
                createErrorResult = Result.createCancelResult(AuthorizationClient.this.pendingRequest, "User canceled log in.");
            } else {
                this.e2e = null;
                String message = facebookException.getMessage();
                if (facebookException instanceof FacebookServiceException) {
                    FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                    str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(requestError.getErrorCode()));
                    message = requestError.toString();
                } else {
                    str = null;
                }
                createErrorResult = Result.createErrorResult(AuthorizationClient.this.pendingRequest, null, message, str);
            }
            if (!Utility.isNullOrEmpty(this.e2e)) {
                AuthorizationClient.this.logWebLoginCompleted(this.applicationId, this.e2e);
            }
            AuthorizationClient.this.completeAndValidate(createErrorResult);
        }

        @Override // com.facebook.AuthorizationClient.AuthHandler
        boolean tryAuthorize(final AuthorizationRequest authorizationRequest) {
            String str;
            this.applicationId = authorizationRequest.getApplicationId();
            Bundle bundle = new Bundle();
            if (!Utility.isNullOrEmpty(authorizationRequest.getPermissions())) {
                String join = TextUtils.join(StringUtils.COMMA, authorizationRequest.getPermissions());
                bundle.putString("scope", join);
                addLoggingExtra("scope", join);
            }
            String previousAccessToken = authorizationRequest.getPreviousAccessToken();
            if (Utility.isNullOrEmpty(previousAccessToken) || !previousAccessToken.equals(loadCookieToken())) {
                Utility.clearFacebookCookies(AuthorizationClient.this.context);
                str = "0";
            } else {
                bundle.putString("access_token", previousAccessToken);
                str = "1";
            }
            addLoggingExtra("access_token", str);
            WebDialog.OnCompleteListener onCompleteListener = new WebDialog.OnCompleteListener() { // from class: com.facebook.AuthorizationClient.WebViewAuthHandler.1
                @Override // com.facebook.widget.WebDialog.OnCompleteListener
                public void onComplete(Bundle bundle2, FacebookException facebookException) {
                    WebViewAuthHandler.this.onWebDialogComplete(authorizationRequest, bundle2, facebookException);
                }
            };
            String access$0 = AuthorizationClient.access$0();
            this.e2e = access$0;
            addLoggingExtra("e2e", access$0);
            WebDialog build = ((WebDialog.Builder) new AuthDialogBuilder(AuthorizationClient.this.getStartActivityDelegate().getActivityContext(), this.applicationId, bundle).setE2E(this.e2e).setOnCompleteListener(onCompleteListener)).build();
            this.loginDialog = build;
            build.show();
            return true;
        }
    }

    static /* synthetic */ String access$0() {
        return getE2E();
    }

    private void addLoggingExtra(String str, String str2, boolean z) {
        if (this.loggingExtras == null) {
            this.loggingExtras = new HashMap();
        }
        if (this.loggingExtras.containsKey(str) && z) {
            str2 = String.valueOf(this.loggingExtras.get(str)) + StringUtils.COMMA + str2;
        }
        this.loggingExtras.put(str, str2);
    }

    private void completeWithFailure() {
        complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
    }

    private static String getE2E() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    private List<AuthHandler> getHandlerTypes(AuthorizationRequest authorizationRequest) {
        ArrayList arrayList = new ArrayList();
        SessionLoginBehavior loginBehavior = authorizationRequest.getLoginBehavior();
        if (loginBehavior.allowsKatanaAuth()) {
            if (!authorizationRequest.isLegacy()) {
                arrayList.add(new GetTokenAuthHandler());
                arrayList.add(new KatanaLoginDialogAuthHandler());
            }
            arrayList.add(new KatanaProxyAuthHandler());
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewAuthHandler());
        }
        return arrayList;
    }

    private void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        Bundle bundle;
        AuthorizationRequest authorizationRequest = this.pendingRequest;
        if (authorizationRequest == null) {
            bundle = newAuthorizationLoggingBundle("");
            bundle.putString(EVENT_PARAM_LOGIN_RESULT, Result.Code.ERROR.getLoggingValue());
            bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "Unexpected call to logAuthorizationMethodComplete with null pendingRequest.");
        } else {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(authorizationRequest.getAuthId());
            if (str2 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str2);
            }
            if (str3 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str3);
            }
            if (str4 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str4);
            }
            if (map != null && !map.isEmpty()) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(map).toString());
            }
            bundle = newAuthorizationLoggingBundle;
        }
        bundle.putString(EVENT_PARAM_METHOD, str);
        bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_COMPLETE, null, bundle);
    }

    private void logAuthorizationMethodStart(String str) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(this.pendingRequest.getAuthId());
        newAuthorizationLoggingBundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_START, null, newAuthorizationLoggingBundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logWebLoginCompleted(String str, String str2) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.context, str);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str2);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", str);
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle newAuthorizationLoggingBundle(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        bundle.putString(EVENT_PARAM_AUTH_LOGGER_ID, str);
        bundle.putString(EVENT_PARAM_METHOD, "");
        bundle.putString(EVENT_PARAM_LOGIN_RESULT, "");
        bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
        bundle.putString(EVENT_PARAM_ERROR_CODE, "");
        bundle.putString(EVENT_PARAM_EXTRAS, "");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStopped();
        }
    }

    private void notifyOnCompleteListener(Result result) {
        OnCompletedListener onCompletedListener = this.onCompletedListener;
        if (onCompletedListener != null) {
            onCompletedListener.onCompleted(result);
        }
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest == null) {
            return;
        }
        if (this.pendingRequest != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (!authorizationRequest.needsNewTokenValidation() || checkInternetPermission()) {
            this.pendingRequest = authorizationRequest;
            this.handlersToTry = getHandlerTypes(authorizationRequest);
            tryNextHandler();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelCurrentHandler() {
        AuthHandler authHandler = this.currentHandler;
        if (authHandler != null) {
            authHandler.cancel();
        }
    }

    boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") == 0) {
            this.checkedInternetPermission = true;
            return true;
        }
        complete(Result.createErrorResult(this.pendingRequest, this.context.getString(R.string.com_facebook_internet_permission_error_title), this.context.getString(R.string.com_facebook_internet_permission_error_message)));
        return false;
    }

    int checkPermission(String str) {
        return this.context.checkCallingOrSelfPermission(str);
    }

    void complete(Result result) {
        AuthHandler authHandler = this.currentHandler;
        if (authHandler != null) {
            logAuthorizationMethodComplete(authHandler.getNameForLogging(), result, this.currentHandler.methodLoggingExtras);
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            result.loggingExtras = map;
        }
        this.handlersToTry = null;
        this.currentHandler = null;
        this.pendingRequest = null;
        this.loggingExtras = null;
        notifyOnCompleteListener(result);
    }

    void completeAndValidate(Result result) {
        if (result.token == null || !this.pendingRequest.needsNewTokenValidation()) {
            complete(result);
        } else {
            validateSameFbidAndFinish(result);
        }
    }

    void continueAuth() {
        AuthHandler authHandler;
        if (this.pendingRequest == null || (authHandler = this.currentHandler) == null) {
            throw new FacebookException("Attempted to continue authorization without a pending request.");
        }
        if (authHandler.needsRestart()) {
            this.currentHandler.cancel();
            tryCurrentHandler();
        }
    }

    Request createGetPermissionsRequest(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", str);
        return new Request(null, "me/permissions", bundle, HttpMethod.GET, null);
    }

    Request createGetProfileIdRequest(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", str);
        return new Request(null, "me", bundle, HttpMethod.GET, null);
    }

    RequestBatch createReauthValidationBatch(final Result result) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        String token = result.token.getToken();
        Request.Callback callback = new Request.Callback() { // from class: com.facebook.AuthorizationClient.3
            @Override // com.facebook.Request.Callback
            public void onCompleted(Response response) {
                try {
                    GraphUser graphUser = (GraphUser) response.getGraphObjectAs(GraphUser.class);
                    if (graphUser != null) {
                        arrayList.add(graphUser.getId());
                    }
                } catch (Exception unused) {
                }
            }
        };
        String previousAccessToken = this.pendingRequest.getPreviousAccessToken();
        Request createGetProfileIdRequest = createGetProfileIdRequest(previousAccessToken);
        createGetProfileIdRequest.setCallback(callback);
        Request createGetProfileIdRequest2 = createGetProfileIdRequest(token);
        createGetProfileIdRequest2.setCallback(callback);
        Request createGetPermissionsRequest = createGetPermissionsRequest(previousAccessToken);
        createGetPermissionsRequest.setCallback(new Request.Callback() { // from class: com.facebook.AuthorizationClient.4
            @Override // com.facebook.Request.Callback
            public void onCompleted(Response response) {
                GraphObjectList<GraphObject> data;
                try {
                    GraphMultiResult graphMultiResult = (GraphMultiResult) response.getGraphObjectAs(GraphMultiResult.class);
                    if (graphMultiResult == null || (data = graphMultiResult.getData()) == null || data.size() != 1) {
                        return;
                    }
                    arrayList2.addAll(data.get(0).asMap().keySet());
                } catch (Exception unused) {
                }
            }
        });
        RequestBatch requestBatch = new RequestBatch(createGetProfileIdRequest, createGetProfileIdRequest2, createGetPermissionsRequest);
        requestBatch.setBatchApplicationId(this.pendingRequest.getApplicationId());
        requestBatch.addCallback(new RequestBatch.Callback() { // from class: com.facebook.AuthorizationClient.5
            @Override // com.facebook.RequestBatch.Callback
            public void onBatchCompleted(RequestBatch requestBatch2) {
                Result createErrorResult;
                try {
                    try {
                        if (arrayList.size() != 2 || arrayList.get(0) == null || arrayList.get(1) == null || !((String) arrayList.get(0)).equals(arrayList.get(1))) {
                            createErrorResult = Result.createErrorResult(AuthorizationClient.this.pendingRequest, "User logged in as different Facebook user.", null);
                        } else {
                            createErrorResult = Result.createTokenResult(AuthorizationClient.this.pendingRequest, AccessToken.createFromTokenWithRefreshedPermissions(result.token, arrayList2));
                        }
                        AuthorizationClient.this.complete(createErrorResult);
                    } catch (Exception e) {
                        AuthorizationClient authorizationClient = AuthorizationClient.this;
                        authorizationClient.complete(Result.createErrorResult(authorizationClient.pendingRequest, "Caught exception", e.getMessage()));
                    }
                } finally {
                    AuthorizationClient.this.notifyBackgroundProcessingStop();
                }
            }
        });
        return requestBatch;
    }

    BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    boolean getInProgress() {
        return (this.pendingRequest == null || this.currentHandler == null) ? false : true;
    }

    OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    StartActivityDelegate getStartActivityDelegate() {
        StartActivityDelegate startActivityDelegate = this.startActivityDelegate;
        if (startActivityDelegate != null) {
            return startActivityDelegate;
        }
        if (this.pendingRequest != null) {
            return new StartActivityDelegate() { // from class: com.facebook.AuthorizationClient.2
                @Override // com.facebook.AuthorizationClient.StartActivityDelegate
                public Activity getActivityContext() {
                    return AuthorizationClient.this.pendingRequest.getStartActivityDelegate().getActivityContext();
                }

                @Override // com.facebook.AuthorizationClient.StartActivityDelegate
                public void startActivityForResult(Intent intent, int i) {
                    AuthorizationClient.this.pendingRequest.getStartActivityDelegate().startActivityForResult(intent, i);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == this.pendingRequest.getRequestCode()) {
            return this.currentHandler.onActivityResult(i, i2, intent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContext(final Activity activity) {
        this.context = activity;
        this.startActivityDelegate = new StartActivityDelegate() { // from class: com.facebook.AuthorizationClient.1
            @Override // com.facebook.AuthorizationClient.StartActivityDelegate
            public Activity getActivityContext() {
                return activity;
            }

            @Override // com.facebook.AuthorizationClient.StartActivityDelegate
            public void startActivityForResult(Intent intent, int i) {
                activity.startActivityForResult(intent, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContext(Context context) {
        this.context = context;
        this.startActivityDelegate = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startOrContinueAuth(AuthorizationRequest authorizationRequest) {
        AppEventsLogger appEventsLogger = this.appEventsLogger;
        if (appEventsLogger == null || appEventsLogger.getApplicationId() != authorizationRequest.getApplicationId()) {
            this.appEventsLogger = AppEventsLogger.newLogger(this.context, authorizationRequest.getApplicationId());
        }
        if (getInProgress()) {
            continueAuth();
        } else {
            authorize(authorizationRequest);
        }
    }

    boolean tryCurrentHandler() {
        if (this.currentHandler.needsInternetPermission() && !checkInternetPermission()) {
            addLoggingExtra(EVENT_EXTRAS_MISSING_INTERNET_PERMISSION, "1", false);
            return false;
        }
        boolean tryAuthorize = this.currentHandler.tryAuthorize(this.pendingRequest);
        String nameForLogging = this.currentHandler.getNameForLogging();
        if (tryAuthorize) {
            logAuthorizationMethodStart(nameForLogging);
            return tryAuthorize;
        }
        addLoggingExtra(EVENT_EXTRAS_NOT_TRIED, nameForLogging, true);
        return tryAuthorize;
    }

    void tryNextHandler() {
        AuthorizationClient authorizationClient;
        AuthHandler authHandler = this.currentHandler;
        if (authHandler != null) {
            authorizationClient = this;
            authorizationClient.logAuthorizationMethodComplete(authHandler.getNameForLogging(), EVENT_PARAM_METHOD_RESULT_SKIPPED, null, null, this.currentHandler.methodLoggingExtras);
        } else {
            authorizationClient = this;
        }
        do {
            List<AuthHandler> list = authorizationClient.handlersToTry;
            if (list == null || list.isEmpty()) {
                if (authorizationClient.pendingRequest != null) {
                    completeWithFailure();
                    return;
                }
                return;
            }
            authorizationClient.currentHandler = authorizationClient.handlersToTry.remove(0);
        } while (!tryCurrentHandler());
    }

    void validateSameFbidAndFinish(Result result) {
        if (result.token == null) {
            throw new FacebookException("Can't validate without a token");
        }
        RequestBatch createReauthValidationBatch = createReauthValidationBatch(result);
        notifyBackgroundProcessingStart();
        createReauthValidationBatch.executeAsync();
    }
}
