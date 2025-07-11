package com.arizona.launcher.util;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.io.File;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u0006*\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0082\u0004\u001a\u0006\u0010\u0011\u001a\u00020\u000e\u001a\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t¨\u0006\u0016"}, d2 = {"initZip", "", "context", "Landroid/content/Context;", "checkItemsName", "isArizona", "", "getItemsJson", "type", "", "dir", "Ljava/io/File;", "sendPurchaseToAppMetrika", "data", "", "hasFlag", "flag", "getDeviceName", "capitalize", CmcdData.STREAMING_FORMAT_SS, "sendAdjustAnalytics", "eventId", "app_arizonaRelease_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
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
        if (file == null) {
            Log.w("getItemsJson", "External files dir is null");
        } else {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UtilsKt$getItemsJson$1(i, file, context, null), 3, null);
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
