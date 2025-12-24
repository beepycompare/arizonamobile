package ru.mrlargha.commonui.utils.metrics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.Constants;
import com.arizona.game.BuildConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.utils.PurchaseData;
import ru.mrlargha.commonui.utils.TrackUsAPI;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: metricsFuns.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000e\u001a\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0082\u0004\u001a\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e\u001a\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e\u001a\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e\u001a\u0016\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e\u001a\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0001\u001a\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"DEFAULT_ANALYTICS", "", "TRACK_US", "APP_METRIKA", "APP_ADJUST", "APP_METRIKA_COMMERCE", "ADVGAME", "ADMITAD", "ADVERTISE", "sendDataAnalytics", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_EVENT, "", "analyticsType", "sendPurchaseToAppMetrika", "data", "handleAdjustAnalytics", "hasFlag", "", "flag", "sendAnalytics", "sendTrackUsRequest", "action", "sendAppMetricaAnalytics", "client", "Lokhttp3/OkHttpClient;", "sendAdmitadAnalytics", "sendAdvertiseAnalytics", "sendAdjustAnalytics", "eventId", "toNormalReferrer", "raw", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MetricsFunsKt {
    public static final int ADMITAD = 64;
    public static final int ADVERTISE = 128;
    public static final int ADVGAME = 32;
    public static final int APP_ADJUST = 8;
    public static final int APP_METRIKA = 4;
    public static final int APP_METRIKA_COMMERCE = 16;
    public static final int DEFAULT_ANALYTICS = 1;
    public static final int TRACK_US = 2;
    private static final OkHttpClient client = new OkHttpClient();

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) != 0;
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
        if (hasFlag(i, 128)) {
            sendAdvertiseAnalytics(context, event);
        }
        if (hasFlag(i, 64)) {
            sendAdmitadAnalytics(context, event);
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

    public static final void sendTrackUsRequest(Context context, String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        String string = context.getSharedPreferences("SP_NAME", 0).getString("referrerUrl", "");
        if (string == null) {
            string = "";
        }
        boolean z = context.getSharedPreferences("flavorType", 0).getBoolean("isArizonaType", false);
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
        String str3 = str2 == null ? "" : str2;
        if (str3.length() > 0) {
            String deviceName = UtilsKt.getDeviceName();
            String str4 = Build.VERSION.RELEASE;
            String str5 = str4 == null ? "" : str4;
            String str6 = z ? BuildConfig.APPLICATION_ID : "com.rodina21.game";
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1));
            builder.addInterceptor(httpLoggingInterceptor);
            ((TrackUsAPI) new Retrofit.Builder().baseUrl("https://track-us.bidease.com/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(TrackUsAPI.class)).sendTrackUsReq(str3, action, "0", "1", "SampleManager", str6, deviceName, "Android", str5, "ru", "image").enqueue(new Callback<ResponseBody>() { // from class: ru.mrlargha.commonui.utils.metrics.MetricsFunsKt$sendTrackUsRequest$1
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
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        String string = context.getSharedPreferences("SP_NAME", 0).getString("referrerUrl", "");
        String str = string != null ? string : "";
        if (StringsKt.isBlank(str)) {
            Log.e("appMetrica", "url is Empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null).iterator();
        while (true) {
            packageInfo = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (StringsKt.contains$default((CharSequence) ((String) next), (CharSequence) "=", false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (String str2 : arrayList2) {
            List split$default = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null);
            Pair pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        long j = packageInfo != null ? packageInfo.firstInstallTime : 0L;
        String str3 = (String) linkedHashMap.get("utm_source");
        if (str3 == null) {
            str3 = "unknown_source";
        }
        String str4 = (String) linkedHashMap.get("utm_medium");
        if (str4 == null) {
            str4 = "unknown_medium";
        }
        String str5 = (String) linkedHashMap.get("utm_term");
        if (str5 == null) {
            str5 = "unknown_term";
        }
        String str6 = (String) linkedHashMap.get("utm_content");
        if (str6 == null) {
            str6 = "unknown_content";
        }
        String str7 = (String) linkedHashMap.get("utm_campaign");
        if (str7 == null) {
            str7 = "unknown_campaign";
        }
        Map mapOf = MapsKt.mapOf(TuplesKt.to("utm_source", str3), TuplesKt.to("utm_medium", str4), TuplesKt.to("utm_term", str5), TuplesKt.to("utm_content", str6), TuplesKt.to("utm_campaign", str7), TuplesKt.to("first_install_time", Long.valueOf(j)));
        AppMetrica.reportEvent(action, mapOf);
        Log.e("appMetrica", "url is " + mapOf);
    }

    public static final void sendAdmitadAnalytics(Context context, String action) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        int hashCode = action.hashCode();
        if (hashCode != -689618847) {
            if (hashCode != 443600344) {
                if (hashCode != 2006065723 || !action.equals("effective_register")) {
                    return;
                }
                str = "1";
            } else if (!action.equals("third_topup")) {
                return;
            } else {
                str = ExifInterface.GPS_MEASUREMENT_3D;
            }
        } else if (!action.equals("first_topup")) {
            return;
        } else {
            str = ExifInterface.GPS_MEASUREMENT_2D;
        }
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
        for (String str2 : arrayList2) {
            List split$default = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null);
            Pair pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String str3 = (String) linkedHashMap.get("admitad_uid");
        if (str3 == null) {
            str3 = "unknown_uid";
        }
        String str4 = (String) linkedHashMap.get("utm_campaign");
        if (str4 == null) {
            str4 = "unknown_campaign";
        }
        client.newCall(new Request.Builder().url(new HttpUrl.Builder().scheme(Constants.SCHEME).host("ad.admitad.com").addPathSegment("r").addQueryParameter("campaign_code", str4).addQueryParameter("pb", "1").addQueryParameter("pk", "8E2e5c2c32A1BcCF695582A73c8a1f44").addQueryParameter("ac", str).addQueryParameter("uid", str3).addQueryParameter("oid", "").addQueryParameter("tc", "1").build()).get().build()).enqueue(new okhttp3.Callback() { // from class: ru.mrlargha.commonui.utils.metrics.MetricsFunsKt$sendAdmitadAnalytics$1
            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                Log.e("Admitad", "track fail", e);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call, okhttp3.Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Log.d("Admitad", "track ok: " + response.code());
                response.close();
            }
        });
    }

    public static final void sendAdvertiseAnalytics(Context context, String action) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        int hashCode = action.hashCode();
        if (hashCode != -689618847) {
            if (hashCode == 443600344) {
                if (!action.equals("third_topup")) {
                    return;
                } else {
                    str = ExifInterface.GPS_MEASUREMENT_3D;
                }
            } else {
                if (hashCode != 2006065723 || !action.equals("effective_register")) {
                    return;
                }
                str = "1";
            }
        } else if (!action.equals("first_topup")) {
            return;
        } else {
            str = ExifInterface.GPS_MEASUREMENT_2D;
        }
        String string = context.getSharedPreferences("SP_NAME", 0).getString("referrerUrl", "");
        String str3 = string != null ? string : "";
        ArrayList arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) str3, new String[]{"&"}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) ((String) obj), (CharSequence) "=", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (String str4 : arrayList2) {
            List split$default = StringsKt.split$default((CharSequence) str4, new String[]{"="}, false, 0, 6, (Object) null);
            Pair pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String str5 = (String) linkedHashMap.get("uid");
        if (str5 == null) {
            str5 = "unknown_uid";
        }
        int hashCode2 = action.hashCode();
        if (hashCode2 != -689618847) {
            if (hashCode2 == 443600344) {
                if (!action.equals("third_topup")) {
                    return;
                } else {
                    str2 = "2c0713f72a75426b";
                }
            } else {
                if (hashCode2 != 2006065723 || !action.equals("effective_register")) {
                    return;
                }
                str2 = "2c0713f72875426b";
            }
        } else if (!action.equals("first_topup")) {
            return;
        } else {
            str2 = "2c0713f72b75426b";
        }
        client.newCall(new Request.Builder().url(new HttpUrl.Builder().scheme(Constants.SCHEME).host("advertiseru.net").addPathSegment("postback").addPathSegment(str2).addQueryParameter("token", "0b31d2ebdf374ea02f71aa271b35c8d0").addQueryParameter("uid", str5).addQueryParameter("ac", str).build()).get().build()).enqueue(new okhttp3.Callback() { // from class: ru.mrlargha.commonui.utils.metrics.MetricsFunsKt$sendAdvertiseAnalytics$1
            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                Log.e("Advertise", "track fail", e);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call, okhttp3.Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Log.d("Advertise", "track ok: " + response.code());
                response.close();
            }
        });
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

    public static final String toNormalReferrer(String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        String substringAfter = StringsKt.substringAfter(raw, "referrer=", raw);
        for (int i = 0; i < 2; i++) {
            String decode = URLDecoder.decode(substringAfter, Charsets.UTF_8.name());
            if (!Intrinsics.areEqual(decode, substringAfter)) {
                Intrinsics.checkNotNull(decode);
                substringAfter = decode;
            }
        }
        return substringAfter;
    }
}
