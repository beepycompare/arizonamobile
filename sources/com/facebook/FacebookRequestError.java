package com.facebook;

import com.facebook.android.R;
import com.facebook.internal.Utility;
import com.google.firebase.messaging.ServiceStarter;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class FacebookRequestError {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int EC_APP_NOT_INSTALLED = 458;
    private static final int EC_APP_TOO_MANY_CALLS = 4;
    private static final int EC_EXPIRED = 463;
    private static final int EC_INVALID_SESSION = 102;
    private static final int EC_INVALID_TOKEN = 190;
    private static final int EC_PASSWORD_CHANGED = 460;
    private static final int EC_PERMISSION_DENIED = 10;
    private static final int EC_SERVICE_UNAVAILABLE = 2;
    private static final int EC_UNCONFIRMED_USER = 464;
    private static final int EC_UNKNOWN_ERROR = 1;
    private static final int EC_USER_CHECKPOINTED = 459;
    private static final int EC_USER_TOO_MANY_CALLS = 17;
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private static final int INVALID_MESSAGE_ID = 0;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorType;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final boolean shouldNotifyUser;
    private final int subErrorCode;
    private final int userActionMessageId;
    private static final Range EC_RANGE_PERMISSION = new Range(200, 299, null);
    private static final Range HTTP_RANGE_SUCCESS = new Range(200, 299, null);
    private static final Range HTTP_RANGE_CLIENT_ERROR = new Range(400, 499, null);
    private static final Range HTTP_RANGE_SERVER_ERROR = new Range(ServiceStarter.ERROR_UNKNOWN, 599, null);

    /* loaded from: classes3.dex */
    public enum Category {
        AUTHENTICATION_RETRY,
        AUTHENTICATION_REOPEN_SESSION,
        PERMISSION,
        SERVER,
        THROTTLING,
        OTHER,
        BAD_REQUEST,
        CLIENT;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Category[] valuesCustom() {
            Category[] valuesCustom = values();
            int length = valuesCustom.length;
            Category[] categoryArr = new Category[length];
            System.arraycopy(valuesCustom, 0, categoryArr, 0, length);
            return categoryArr;
        }
    }

    /* loaded from: classes3.dex */
    private static class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* synthetic */ Range(int i, int i2, Range range) {
            this(i, i2);
        }

        boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection) {
        this(i, i2, i3, str, str2, jSONObject, jSONObject2, obj, httpURLConnection, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private FacebookRequestError(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z;
        Category category;
        Category category2;
        int i4;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        boolean z2 = true;
        int i5 = 0;
        if (facebookException != null) {
            this.exception = facebookException;
            z = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            z = false;
        }
        if (z) {
            category2 = Category.CLIENT;
            z2 = false;
        } else {
            if (i2 == 1 || i2 == 2) {
                category = Category.SERVER;
            } else if (i2 == 4 || i2 == 17) {
                category = Category.THROTTLING;
            } else {
                if (i2 == 10 || EC_RANGE_PERMISSION.contains(i2)) {
                    category = Category.PERMISSION;
                    i4 = R.string.com_facebook_requesterror_permissions;
                } else if (i2 == 102 || i2 == 190) {
                    if (i3 == EC_USER_CHECKPOINTED || i3 == EC_UNCONFIRMED_USER) {
                        category = Category.AUTHENTICATION_RETRY;
                        i5 = R.string.com_facebook_requesterror_web_login;
                    } else {
                        category = Category.AUTHENTICATION_REOPEN_SESSION;
                        if (i3 == EC_APP_NOT_INSTALLED || i3 == EC_EXPIRED) {
                            i4 = R.string.com_facebook_requesterror_relogin;
                        } else if (i3 == EC_PASSWORD_CHANGED) {
                            i4 = R.string.com_facebook_requesterror_password_changed;
                        } else {
                            i5 = R.string.com_facebook_requesterror_reconnect;
                        }
                    }
                    category2 = category == null ? HTTP_RANGE_CLIENT_ERROR.contains(i) ? Category.BAD_REQUEST : HTTP_RANGE_SERVER_ERROR.contains(i) ? Category.SERVER : Category.OTHER : category;
                } else {
                    category = null;
                }
                z2 = false;
                i5 = i4;
                if (category == null) {
                }
            }
            z2 = false;
            if (category == null) {
            }
        }
        this.category = category2;
        this.userActionMessageId = i5;
        this.shouldNotifyUser = z2;
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d A[Catch: JSONException -> 0x00af, TryCatch #0 {JSONException -> 0x00af, blocks: (B:3:0x000b, B:5:0x0011, B:7:0x001b, B:9:0x001f, B:12:0x002b, B:25:0x007d, B:28:0x008a, B:30:0x0093, B:32:0x0099, B:34:0x00a2, B:13:0x0049, B:16:0x0053, B:18:0x0059, B:22:0x0066), top: B:38:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        String str;
        String optString;
        String optString2;
        int optInt;
        String str2;
        try {
            if (jSONObject.has("code")) {
                int i = jSONObject.getInt("code");
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", Response.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON == null || !(stringPropertyAsJSON instanceof JSONObject)) {
                    str = "body";
                } else {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    boolean z = true;
                    int i2 = -1;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, "error", null);
                        optString = jSONObject3.optString("type", null);
                        optString2 = jSONObject3.optString(ERROR_MESSAGE_FIELD_KEY, null);
                        int optInt2 = jSONObject3.optInt("code", -1);
                        int optInt3 = jSONObject3.optInt(ERROR_SUB_CODE_KEY, -1);
                        str = "body";
                        optInt = optInt3;
                        i2 = optInt2;
                    } else {
                        if (!jSONObject2.has(ERROR_CODE_KEY) && !jSONObject2.has(ERROR_MSG_KEY) && !jSONObject2.has(ERROR_REASON_KEY)) {
                            z = false;
                            str = "body";
                            str2 = null;
                            optString2 = null;
                            optInt = -1;
                            if (z) {
                                return new FacebookRequestError(i, i2, optInt, str2, optString2, jSONObject2, jSONObject, obj, httpURLConnection);
                            }
                        }
                        optString = jSONObject2.optString(ERROR_REASON_KEY, null);
                        optString2 = jSONObject2.optString(ERROR_MSG_KEY, null);
                        i2 = jSONObject2.optInt(ERROR_CODE_KEY, -1);
                        str = "body";
                        optInt = jSONObject2.optInt(ERROR_SUB_CODE_KEY, -1);
                    }
                    str2 = optString;
                    if (z) {
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i)) {
                    return new FacebookRequestError(i, -1, -1, null, null, jSONObject.has(str) ? (JSONObject) Utility.getStringPropertyAsJSON(jSONObject, str, Response.NON_JSON_RESPONSE_PROPERTY) : null, jSONObject, obj, httpURLConnection);
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public Category getCategory() {
        return this.category;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        String str = this.errorMessage;
        return str != null ? str : this.exception.getLocalizedMessage();
    }

    public String getErrorType() {
        return this.errorType;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public int getUserActionMessageId() {
        return this.userActionMessageId;
    }

    public boolean shouldNotifyUser() {
        return this.shouldNotifyUser;
    }

    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    }
}
