package com.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AppLinkData {
    private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
    private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
    private static final String APPLINK_VERSION_KEY = "version";
    public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
    private static final String BRIDGE_ARGS_METHOD_KEY = "method";
    private static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
    private static final String METHOD_ARGS_REF_KEY = "ref";
    private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
    private static final String TAG = "com.facebook.AppLinkData";
    private JSONObject arguments;
    private String[] ref;
    private Uri targetUri;
    private String version;

    /* loaded from: classes3.dex */
    public interface CompletionHandler {
        void onDeferredAppLinkDataFetched(AppLinkData appLinkData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DeferredAppLinkDataClient extends PlatformServiceClient {
        DeferredAppLinkDataClient(Context context, String str) {
            super(context, 65540, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY, NativeProtocol.PROTOCOL_VERSION_20130618, str);
        }

        @Override // com.facebook.internal.PlatformServiceClient
        protected void populateRequestBundle(Bundle bundle) {
            bundle.putString(NativeProtocol.EXTRA_GET_INSTALL_DATA_PACKAGE, getContext().getPackageName());
        }
    }

    private AppLinkData() {
    }

    public static AppLinkData createFromActivity(Activity activity) {
        Validate.notNull(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        AppLinkData createFromJson = createFromJson(intent.getStringExtra(BUNDLE_APPLINK_ARGS_KEY));
        return createFromJson == null ? createFromUri(intent.getData()) : createFromJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AppLinkData createFromJson(String str) {
        String string;
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string2 = jSONObject.getString("version");
            if (jSONObject.getJSONObject(APPLINK_BRIDGE_ARGS_KEY).getString("method").equals("applink") && string2.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                AppLinkData appLinkData = new AppLinkData();
                appLinkData.version = string2;
                JSONObject jSONObject2 = jSONObject.getJSONObject(APPLINK_METHOD_ARGS_KEY);
                appLinkData.arguments = jSONObject2;
                if (jSONObject2.has(METHOD_ARGS_REF_KEY) && (string = appLinkData.arguments.getString(METHOD_ARGS_REF_KEY)) != null) {
                    appLinkData.ref = string.split(StringUtils.COMMA);
                }
                if (appLinkData.arguments.has(METHOD_ARGS_TARGET_URL_KEY)) {
                    appLinkData.targetUri = Uri.parse(appLinkData.arguments.getString(METHOD_ARGS_TARGET_URL_KEY));
                }
                return appLinkData;
            }
        } catch (JSONException unused) {
            Log.d(TAG, "Unable to parse AppLink JSON");
        }
        return null;
    }

    private static AppLinkData createFromUri(Uri uri) {
        return null;
    }

    public static void fetchDeferredAppLinkData(Context context, CompletionHandler completionHandler) {
        fetchDeferredAppLinkData(context, null, completionHandler);
    }

    public static void fetchDeferredAppLinkData(Context context, String str, final CompletionHandler completionHandler) {
        Validate.notNull(context, "context");
        Validate.notNull(completionHandler, "completionHandler");
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        DeferredAppLinkDataClient deferredAppLinkDataClient = new DeferredAppLinkDataClient(context, str);
        deferredAppLinkDataClient.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.AppLinkData.1
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public void completed(Bundle bundle) {
                AppLinkData appLinkData;
                if (bundle != null) {
                    String string = bundle.getString(AppLinkData.BUNDLE_APPLINK_ARGS_KEY);
                    long j = bundle.getLong(AppLinkData.ARGUMENTS_TAPTIME_KEY, -1L);
                    appLinkData = AppLinkData.createFromJson(string);
                    if (j != -1) {
                        try {
                            appLinkData.getArguments().put(AppLinkData.ARGUMENTS_TAPTIME_KEY, j);
                        } catch (JSONException unused) {
                            Log.d(AppLinkData.TAG, "Unable to put tap time in AppLinkData.arguments");
                        }
                    }
                } else {
                    appLinkData = null;
                }
                CompletionHandler.this.onDeferredAppLinkDataFetched(appLinkData);
            }
        });
        if (deferredAppLinkDataClient.start()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.AppLinkData.2
            @Override // java.lang.Runnable
            public void run() {
                CompletionHandler.this.onDeferredAppLinkDataFetched(null);
            }
        });
    }

    public JSONObject getArguments() {
        return this.arguments;
    }

    public String[] getRef() {
        return this.ref;
    }

    public Uri getTargetUri() {
        return this.targetUri;
    }
}
