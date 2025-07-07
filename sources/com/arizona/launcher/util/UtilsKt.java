package com.arizona.launcher.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0013\u001a\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0015\u0010\u0018\u001a\u00020\u0006*\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0082\u0004\u001a\u0016\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0006\u0010\u001b\u001a\u00020\u0013\u001a\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0002\u001a\u0016\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0013\u001a\u0016\u0010 \u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0013\u001a\u0016\u0010!\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\t\"\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"initZip", "", "context", "Landroid/content/Context;", "checkItemsName", "isArizona", "", "getItemsJson", "type", "", "dir", "Ljava/io/File;", "DEFAULT_ANALYTICS", "TRACK_US", "APP_METRIKA", "APP_ADJUST", "APP_METRIKA_COMMERCE", "sendDataAnalytics", NotificationCompat.CATEGORY_EVENT, "", "analyticsType", "sendPurchaseToAppMetrika", "data", "handleAdjustAnalytics", "hasFlag", "flag", "sendAnalytics", "getDeviceName", "capitalize", CmcdData.STREAMING_FORMAT_SS, "sendTrackUsRequest", "action", "sendAppMetricaAnalytics", "sendAdjustAnalytics", "eventId", "app_arizonaRelease_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final int APP_ADJUST = 8;
    public static final int APP_METRIKA = 4;
    public static final int APP_METRIKA_COMMERCE = 16;
    public static final int DEFAULT_ANALYTICS = 1;
    public static final int TRACK_US = 2;

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static final void initZip(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            ru.mrlargha.commonui.utils.UtilsKt.setZipFileIcons(new ZipFile(new File(externalFilesDir != null ? externalFilesDir.getPath() : null, "models.zip")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void checkItemsName(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ru.mrlargha.commonui.utils.UtilsKt.getItemsName().isEmpty()) {
            if (z) {
                getItemsJson$default(context, 1, null, 4, null);
            } else {
                getItemsJson$default(context, 3, null, 4, null);
            }
        }
    }

    public static /* synthetic */ void getItemsJson$default(Context context, int i, File file, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            file = context.getExternalFilesDir(null);
        }
        getItemsJson(context, i, file);
    }

    public static final void getItemsJson(Context context, int i, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (file != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UtilsKt$getItemsJson$1(i, file, context, null), 3, null);
        } else {
            Log.w("getItemsJson", "External files dir is null");
        }
    }

    public static final void sendDataAnalytics(Context context, String event, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(event, "event");
        Log.i("sendDataAnalytics", "event: " + event + ", " + i);
        if (hasFlag(i, 1)) {
            sendAnalytics(context, event);
        }
        if (hasFlag(i, 2)) {
            sendTrackUsRequest(context, event);
        }
        if (hasFlag(i, 4)) {
            sendAppMetricaAnalytics(context, event);
        }
        if (hasFlag(i, 8)) {
            handleAdjustAnalytics(context, event);
        }
        if (hasFlag(i, 16)) {
            sendPurchaseToAppMetrika(event);
        }
    }

    public static final void sendPurchaseToAppMetrika(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("sendDataAnalytics", "sendPurchaseToAppMetrika: " + data);
        PurchaseData purchaseData = (PurchaseData) new Gson().fromJson(data, (Class<Object>) PurchaseData.class);
        ECommercePrice eCommercePrice = new ECommercePrice(new ECommerceAmount(purchaseData.getAmount(), purchaseData.getCurrency()));
        ECommerceProduct name = new ECommerceProduct(purchaseData.getProductId()).setActualPrice(eCommercePrice).setName(purchaseData.getProductName());
        Intrinsics.checkNotNullExpressionValue(name, "setName(...)");
        ECommerceOrder eCommerceOrder = new ECommerceOrder(purchaseData.getOrderId(), CollectionsKt.listOf(new ECommerceCartItem(name, eCommercePrice, 1.0d)));
        ECommerceEvent beginCheckoutEvent = ECommerceEvent.beginCheckoutEvent(eCommerceOrder);
        Intrinsics.checkNotNullExpressionValue(beginCheckoutEvent, "beginCheckoutEvent(...)");
        AppMetrica.reportECommerce(beginCheckoutEvent);
        ECommerceEvent purchaseEvent = ECommerceEvent.purchaseEvent(eCommerceOrder);
        Intrinsics.checkNotNullExpressionValue(purchaseEvent, "purchaseEvent(...)");
        AppMetrica.reportECommerce(purchaseEvent);
    }

    private static final void handleAdjustAnalytics(Context context, String str) {
        Log.i("sendDataAnalytics", "handleAdjustAnalytics: " + str);
        int hashCode = str.hashCode();
        if (hashCode == -690213213) {
            if (str.equals("register")) {
                sendAdjustAnalytics(context, 0);
            }
        } else if (hashCode == -689618847) {
            if (str.equals("first_topup")) {
                sendAdjustAnalytics(context, 2);
            }
        } else if (hashCode == 22643575 && str.equals("one_played_hour")) {
            sendAdjustAnalytics(context, 1);
        }
    }

    public static final void sendAnalytics(Context context, String event) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(event, "event");
        String string = context.getSharedPreferences("SP_NAME", 0).getString("referrerUrl", "");
        if (string == null) {
            string = "";
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) string, new String[]{"&"}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) ((String) obj), (CharSequence) "=", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (String str : arrayList2) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null);
            Pair pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        long j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        String str2 = (String) linkedHashMap.get("utm_source");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (String) linkedHashMap.get("utm_medium");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = (String) linkedHashMap.get("utm_term");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = (String) linkedHashMap.get("utm_content");
        if (str5 == null) {
            str5 = "";
        }
        String str6 = (String) linkedHashMap.get("utm_campaign");
        String str7 = str6 != null ? str6 : "";
        Bundle bundle = new Bundle();
        bundle.putString("utm_source", str2);
        bundle.putString("utm_medium", str3);
        bundle.putString("utm_term", str4);
        bundle.putString("utm_content", str5);
        bundle.putString("utm_campaign", str7);
        bundle.putLong("first_install_time", j);
        FirebaseAnalytics.getInstance(context).logEvent(event, bundle);
    }

    public static final String getDeviceName() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String str2 = Build.MODEL;
        String str3 = str2 != null ? str2 : "";
        if (StringsKt.startsWith$default(str3, str, false, 2, (Object) null)) {
            return capitalize(str3);
        }
        return capitalize(str) + " " + str3;
    }

    private static final String capitalize(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return upperCase + substring;
    }

    public static final void sendTrackUsRequest(Context context, String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        String string = context.getSharedPreferences("SP_NAME", 0).getString("referrerUrl", "");
        if (string == null) {
            string = "";
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) string, new String[]{"&"}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) ((String) obj), (CharSequence) "=", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (String str : arrayList2) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null);
            Pair pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String str2 = (String) linkedHashMap.get("bidID");
        if (str2 == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            String deviceName = getDeviceName();
            String str3 = Build.VERSION.RELEASE;
            String str4 = str3 == null ? "" : str3;
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1));
            builder.addInterceptor(httpLoggingInterceptor);
            ((TrackUsAPI) new Retrofit.Builder().baseUrl("https://track-us.bidease.com/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(TrackUsAPI.class)).sendTrackUsReq(str2, action, "0", "1", "SampleManager", "com.arizona21.game", deviceName, "Android", str4, "ru", "image").enqueue(new Callback<ResponseBody>() { // from class: com.arizona.launcher.util.UtilsKt$sendTrackUsRequest$1
                @Override // retrofit2.Callback
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.w("Utils", "error get sendTrackUsReq");
                }
            });
        }
    }

    public static final void sendAppMetricaAnalytics(Context context, String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        String string = context.getSharedPreferences("SP_NAME", 0).getString("referrerUrl", "");
        if (string == null) {
            string = "";
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) string, new String[]{"&"}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) ((String) obj), (CharSequence) "=", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (String str : arrayList2) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null);
            Pair pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        long j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        String str2 = (String) linkedHashMap.get("utm_source");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (String) linkedHashMap.get("utm_medium");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = (String) linkedHashMap.get("utm_term");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = (String) linkedHashMap.get("utm_content");
        if (str5 == null) {
            str5 = "";
        }
        String str6 = (String) linkedHashMap.get("utm_campaign");
        AppMetrica.reportEvent(action, MapsKt.mapOf(TuplesKt.to("utm_source", str2), TuplesKt.to("utm_medium", str3), TuplesKt.to("utm_term", str4), TuplesKt.to("utm_content", str5), TuplesKt.to("utm_campaign", str6 != null ? str6 : ""), TuplesKt.to("first_install_time", Long.valueOf(j))));
    }

    public static final void sendAdjustAnalytics(Context context, int i) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = context.getSharedPreferences("flavorType", 0).getBoolean("isArizonaType", false);
        if (i == 0) {
            str = z ? "u8cswn" : "bb6dmh";
        } else if (i == 1) {
            str = z ? "qqj12v" : "aks398";
        } else if (i != 2) {
            str = "";
        } else {
            str = z ? "gohrb0" : "7xl8q1";
        }
        Adjust.trackEvent(new AdjustEvent(str));
        Log.d(Constants.LOGTAG, "Event sent to Adjust: event_token");
    }
}
