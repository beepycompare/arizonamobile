package ru.mrlargha.commonui.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
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
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.elements.employmentNote.domain.FractionTasks;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u0015*\u00020\u0018\u001a\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u001a\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d\u001aM\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!*\u0002H!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020$0#¢\u0006\u0002\b%2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00120#¢\u0006\u0002\b%H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u0016\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0015\u001a\u0018\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007\u001a\u000e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001d\u001a\u000e\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0015\u001a\u0018\u00105\u001a\u0004\u0018\u00010\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u00106\u001a\u00020\u001d\u001a\u000e\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015\u001a\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00012\u0006\u0010:\u001a\u00020\u0018\u001a\u001e\u0010;\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0018\u001a\u001e\u0010;\u001a\u00020\u00122\u0006\u0010/\u001a\u00020=2\u0006\u0010<\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0018\u001a\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u001d\u001a\u0016\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001b\u001a\u0016\u0010D\u001a\u00020\u00122\u0006\u0010A\u001a\u00020B2\u0006\u0010)\u001a\u00020*\u001a\u0016\u0010E\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010F\u001a\u00020$\u001a\"\u0010G\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020\u00152\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J\u001a&\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020.\u001a\u001a\u0010Q\u001a\u0004\u0018\u00010.2\b\u0010R\u001a\u0004\u0018\u00010.2\u0006\u0010S\u001a\u00020.\u001a\u000e\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\u001d\u001a\u000e\u0010V\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015\u001a\u000e\u0010W\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015\u001a\u001e\u0010]\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u0015\u001a\u000e\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u001d\u001a\u0018\u0010b\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010^\u001a\u00020\u001dH\u0002\u001a\u0015\u0010c\u001a\u00020$*\u00020\u00152\u0006\u0010d\u001a\u00020\u0015H\u0082\u0004\u001a\u0006\u0010e\u001a\u00020\u001d\u001a\u0012\u0010f\u001a\u00020\u001d2\b\u0010g\u001a\u0004\u0018\u00010\u001dH\u0002\u001a\u0016\u0010h\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010^\u001a\u00020\u001d\u001a\u0016\u0010i\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010j\u001a\u00020\u001d\u001a\u0016\u0010k\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010j\u001a\u00020\u001d\u001a\u0016\u0010l\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010m\u001a\u00020\u0015\" \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006\"\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u000e\u0010X\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006n"}, d2 = {"fractionTasks", "", "Lru/mrlargha/commonui/elements/employmentNote/domain/FractionTasks;", "getFractionTasks", "()Ljava/util/List;", "setFractionTasks", "(Ljava/util/List;)V", "itemsName", "Lru/mrlargha/commonui/utils/ItemsInfo;", "getItemsName", "setItemsName", "zipFileIcons", "Ljava/util/zip/ZipFile;", "getZipFileIcons", "()Ljava/util/zip/ZipFile;", "setZipFileIcons", "(Ljava/util/zip/ZipFile;)V", "setTextTimeFormat", "", "Landroid/widget/TextView;", "time", "", "getAnimationScale", "", "Landroid/app/Activity;", "getKeyboardHeightOrNull", "getIconFromArchive", "Landroid/graphics/Bitmap;", "folderName", "", "item", "gearsIconName", "applyIf", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getBitmapFromVectorDrawable", "context", "Landroid/content/Context;", "drawableId", "setDragClick", "itemVal", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "view", "Landroid/view/View;", "updateJsonString", "jsonString", "getColorTint", "color", "getJsonFromAssets", "fileName", "nextMultipleOfFive", "x", "getItemsDescription", "targetActivity", "setDrawableEnd", "viewInt", "Landroid/widget/EditText;", "deleteSvgWord", "svg", "setImage", "imageView", "Landroid/widget/ImageView;", "bitmap", "setNotLoadedImage", "checkItemsName", "isArizona", "getItemsJson", "type", "dir", "Ljava/io/File;", "sendData", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "backendID", "fromItem", "toItem", "updateInventoryItem", "originalItem", "newItem", "convertPngToWebp", "png", "defineArzMenuText", "defineRodMenuText", "DEFAULT_ANALYTICS", "TRACK_US", "APP_METRIKA", "APP_ADJUST", "APP_METRIKA_COMMERCE", "sendDataAnalytics", NotificationCompat.CATEGORY_EVENT, "analyticsType", "sendPurchaseToAppMetrika", "data", "handleAdjustAnalytics", "hasFlag", "flag", "getDeviceName", "capitalize", CmcdData.STREAMING_FORMAT_SS, "sendAnalytics", "sendTrackUsRequest", "action", "sendAppMetricaAnalytics", "sendAdjustAnalytics", "eventId", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    public static final int APP_ADJUST = 8;
    public static final int APP_METRIKA = 4;
    public static final int APP_METRIKA_COMMERCE = 16;
    public static final int DEFAULT_ANALYTICS = 1;
    public static final int TRACK_US = 2;
    private static List<FractionTasks> fractionTasks = CollectionsKt.emptyList();
    private static List<ItemsInfo> itemsName = CollectionsKt.emptyList();
    private static ZipFile zipFileIcons;

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static final List<FractionTasks> getFractionTasks() {
        return fractionTasks;
    }

    public static final void setFractionTasks(List<FractionTasks> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        fractionTasks = list;
    }

    public static final List<ItemsInfo> getItemsName() {
        return itemsName;
    }

    public static final void setItemsName(List<ItemsInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        itemsName = list;
    }

    public static final ZipFile getZipFileIcons() {
        return zipFileIcons;
    }

    public static final void setZipFileIcons(ZipFile zipFile) {
        zipFileIcons = zipFile;
    }

    public static final void setTextTimeFormat(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }

    public static final float getAnimationScale(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            return Settings.Global.getFloat(activity.getContentResolver(), "animator_duration_scale", 1.0f);
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    public static final int getKeyboardHeightOrNull(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View findViewById = activity.findViewById(16908290);
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        int height = findViewById.getRootView().getHeight();
        int height2 = height - rect.height();
        if (height2 > height * 0.15d) {
            return height2;
        }
        return 0;
    }

    public static /* synthetic */ Bitmap getIconFromArchive$default(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return getIconFromArchive(str, i, str2);
    }

    public static final Bitmap getIconFromArchive(String folderName, int i, String gearsIconName) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(gearsIconName, "gearsIconName");
        try {
            if (Intrinsics.areEqual(folderName, "gears")) {
                ZipFile zipFile = zipFileIcons;
                if (zipFile != null) {
                    entry = zipFile.getEntry(folderName + RemoteSettings.FORWARD_SLASH_STRING + gearsIconName);
                }
                entry = null;
            } else {
                ZipFile zipFile2 = zipFileIcons;
                if (zipFile2 != null) {
                    entry = zipFile2.getEntry(folderName + RemoteSettings.FORWARD_SLASH_STRING + i + ".webp");
                }
                entry = null;
            }
            if (entry == null) {
                return null;
            }
            ZipFile zipFile3 = zipFileIcons;
            InputStream inputStream = zipFile3 != null ? zipFile3.getInputStream(entry) : null;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                CloseableKt.closeFinally(bufferedInputStream, null);
                CloseableKt.closeFinally(inputStream, null);
                return decodeStream;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final Bitmap getIconFromArchive(String folderName, String item) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            ZipFile zipFile = zipFileIcons;
            ZipEntry entry = zipFile != null ? zipFile.getEntry(folderName + RemoteSettings.FORWARD_SLASH_STRING + item + ".webp") : null;
            if (entry != null) {
                ZipFile zipFile2 = zipFileIcons;
                InputStream inputStream = zipFile2 != null ? zipFile2.getInputStream(entry) : null;
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                CloseableKt.closeFinally(bufferedInputStream, null);
                CloseableKt.closeFinally(inputStream, null);
                return decodeStream;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final <T> T applyIf(T t, Function1<? super T, Boolean> predicate, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(block, "block");
        if (predicate.invoke(t).booleanValue()) {
            block.invoke(t);
        }
        return t;
    }

    public static final Bitmap getBitmapFromVectorDrawable(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = ContextCompat.getDrawable(context, i);
        Intrinsics.checkNotNull(drawable);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static final boolean setDragClick(InventoryItem itemVal, View view) {
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        Intrinsics.checkNotNullParameter(view, "view");
        view.startDragAndDrop(new ClipData(String.valueOf(itemVal.getItem()), new String[]{"text/plain"}, new ClipData.Item(StringKt.toStringJson(itemVal))), new View.DragShadowBuilder(view), view, 0);
        return true;
    }

    public static final String updateJsonString(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JsonObject jsonObject = (JsonObject) new Gson().fromJson(jsonString, (Class<Object>) JsonObject.class);
        jsonObject.remove("photoBitmap");
        String json = new Gson().toJson((JsonElement) jsonObject);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public static final int getColorTint(int i) {
        return Color.argb(i & 255, (i >> 24) & 255, (i >> 16) & 255, (i >> 8) & 255);
    }

    public static final String getJsonFromAssets(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            InputStream open = context.getAssets().open(fileName);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int nextMultipleOfFive(int i) {
        return ((i + 4) / 5) * 5;
    }

    public static final List<String> getItemsDescription(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        if (targetActivity.getSharedPreferences("flavorType", 0).getBoolean("isArizonaType", false)) {
            return ConstantsKt.getItemsDescription();
        }
        return ConstantsKt.getRodinaItemsDescription();
    }

    public static final void setDrawableEnd(TextView view, int i, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        view.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(targetActivity, i), (Drawable) null);
    }

    public static final void setDrawableEnd(EditText view, int i, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        view.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(targetActivity, i), (Drawable) null);
    }

    public static final String deleteSvgWord(String svg) {
        Intrinsics.checkNotNullParameter(svg, "svg");
        return StringsKt.replace$default(svg, ".svg", "", false, 4, (Object) null);
    }

    public static final void setImage(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        imageView.setImageBitmap(Bitmap.createBitmap(bitmap));
    }

    public static final void setNotLoadedImage(ImageView imageView, Context context) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(context, "context");
        setImage(imageView, getBitmapFromVectorDrawable(context, R.drawable.baseline_warning_24));
    }

    public static final void checkItemsName(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (itemsName.isEmpty()) {
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

    public static final void sendData(IBackendNotifier frontendNotifier, int i, InventoryItem fromItem, InventoryItem toItem) {
        int i2;
        Intrinsics.checkNotNullParameter(frontendNotifier, "frontendNotifier");
        Intrinsics.checkNotNullParameter(fromItem, "fromItem");
        Intrinsics.checkNotNullParameter(toItem, "toItem");
        if (fromItem.getAmount() != null) {
            Integer amount = fromItem.getAmount();
            i2 = amount != null ? amount.intValue() : 0;
        } else {
            i2 = 1;
        }
        if (fromItem.getSlot() == toItem.getSlot() && fromItem.getInventoryType() == toItem.getInventoryType()) {
            Log.d("TAG_SEND", "EQUAL ITEMS");
            return;
        }
        Log.d("TAG_SEND", "backendID: " + i + " ====== from : " + fromItem + " ===== toItem : " + toItem);
        byte[] bytes = StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(fromItem.getSlot(), fromItem.getInventoryType(), i2, fromItem.getId()), new ChangeToSlot(toItem.getSlot(), toItem.getInventoryType()))).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        frontendNotifier.clickedWrapper(i, -1, 1, bytes);
    }

    public static final InventoryItem updateInventoryItem(InventoryItem inventoryItem, InventoryItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (inventoryItem != null) {
            int slot = newItem.getSlot();
            Integer item = newItem.getItem();
            if (item == null) {
                item = inventoryItem.getItem();
            }
            Integer num = item;
            int id = newItem.getId();
            String text = newItem.getText();
            if (text == null) {
                text = inventoryItem.getText();
            }
            String str = text;
            Integer item_type = newItem.getItem_type();
            if (item_type == null) {
                item_type = inventoryItem.getItem_type();
            }
            Integer num2 = item_type;
            Integer amount = newItem.getAmount();
            if (amount == null) {
                amount = inventoryItem.getAmount();
            }
            Integer num3 = amount;
            Integer background = newItem.getBackground();
            Integer color = newItem.getColor();
            if (color == null) {
                color = inventoryItem.getColor();
            }
            Integer num4 = color;
            Integer bits = newItem.getBits();
            if (bits == null) {
                bits = inventoryItem.getBits();
            }
            Integer num5 = bits;
            Integer available = newItem.getAvailable();
            if (available == null) {
                available = inventoryItem.getAvailable();
            }
            Integer num6 = available;
            Integer enchant = newItem.getEnchant();
            if (enchant == null) {
                enchant = inventoryItem.getEnchant();
            }
            Integer num7 = enchant;
            Integer blackout = newItem.getBlackout();
            if (blackout == null) {
                blackout = inventoryItem.getBlackout();
            }
            Integer num8 = blackout;
            Long time = newItem.getTime();
            if (time == null) {
                time = inventoryItem.getTime();
            }
            Long l = time;
            Integer itemStrength = newItem.getItemStrength();
            if (itemStrength == null) {
                itemStrength = inventoryItem.getItemStrength();
            }
            Integer num9 = itemStrength;
            Integer isActive = newItem.isActive();
            if (isActive == null) {
                isActive = inventoryItem.isActive();
            }
            Integer num10 = isActive;
            Integer breaks = newItem.getBreaks();
            if (breaks == null) {
                breaks = inventoryItem.getBreaks();
            }
            Integer num11 = breaks;
            int inventoryType = newItem.getInventoryType();
            Integer acsSlot = newItem.getAcsSlot();
            if (acsSlot == null) {
                acsSlot = inventoryItem.getAcsSlot();
            }
            Integer num12 = acsSlot;
            Bitmap photoBitmap = newItem.getPhotoBitmap();
            if (photoBitmap == null) {
                photoBitmap = inventoryItem.getPhotoBitmap();
            }
            return InventoryItem.copy$default(inventoryItem, slot, num, id, str, num2, num3, background, num4, num5, num6, num7, num8, l, num9, num10, num11, inventoryType, num12, photoBitmap, false, false, 1572864, null);
        }
        return null;
    }

    public static final String convertPngToWebp(String png) {
        Intrinsics.checkNotNullParameter(png, "png");
        return StringsKt.replace$default(png, "png", "webp", false, 4, (Object) null);
    }

    public static final String defineArzMenuText(int i) {
        return i == ArzInventoryButtonTypes.BUTTON_INVENTORY.ordinal() ? "Инвентарь" : i == ArzInventoryButtonTypes.BUTTON_CAR_INVENTORY.ordinal() ? "Транспорт" : i == ArzInventoryButtonTypes.BUTTON_CHEST.ordinal() ? "Сундук" : i == ArzInventoryButtonTypes.BUTTON_HOTEL_ROOM.ordinal() ? "Шкаф" : i == ArzInventoryButtonTypes.BUTTON_TRUNK.ordinal() ? "Багажник" : i == ArzInventoryButtonTypes.BUTTON_FAM_FLAT.ordinal() ? "Общак" : (i == ArzInventoryButtonTypes.BUTTON_HOUSE.ordinal() || i == ArzInventoryButtonTypes.BUTTON_TRAILER.ordinal()) ? "Шкаф" : i == ArzInventoryButtonTypes.BUTTON_STOREHOUSE.ordinal() ? "Склад" : i == ArzInventoryButtonTypes.BUTTON_PAWNSHOP.ordinal() ? "Меню ломбарда" : i == ArzInventoryButtonTypes.BUTTON_TRASH.ordinal() ? "Мусорка" : i == ArzInventoryButtonTypes.BUTTON_SECURITY.ordinal() ? "Охранники" : i == ArzInventoryButtonTypes.BUTTON_CARS.ordinal() ? "Мой транспорт" : i == ArzInventoryButtonTypes.BUTTON_BIZ.ordinal() ? "Мои бизнесы" : i == ArzInventoryButtonTypes.BUTTON_HOUSES.ordinal() ? "Мои дома" : "";
    }

    public static final String defineRodMenuText(int i) {
        return i == RodInventoryButtonTypes.BUTTON_INVENTORY.ordinal() ? "Инвентарь" : i == RodInventoryButtonTypes.BUTTON_CAR_INVENTORY.ordinal() ? "Транспорт" : i == RodInventoryButtonTypes.BUTTON_TRASH.ordinal() ? "Мусорка" : i == RodInventoryButtonTypes.BUTTON_TRUNK.ordinal() ? "Багажник" : i == RodInventoryButtonTypes.BUTTON_HOUSE.ordinal() ? "Домашний шкаф" : i == RodInventoryButtonTypes.BUTTON_DRAWER.ordinal() ? "Тумбочка" : i == RodInventoryButtonTypes.BUTTON_SHIP.ordinal() ? "Трюм корабля" : i == RodInventoryButtonTypes.BUTTON_CAMPER.ordinal() ? "Дом на колесах" : i == RodInventoryButtonTypes.BUTTON_BANK_VAULT.ordinal() ? "Банковское хранилище" : i == RodInventoryButtonTypes.BUTTON_FRACTION_WAREHOUSE.ordinal() ? "Общак фракции" : i == RodInventoryButtonTypes.BUTTON_FAMILY_WAREHOUSE.ordinal() ? "Общак семьи" : i == RodInventoryButtonTypes.BUTTON_GARDENING_BARN.ordinal() ? "Амбар" : i == RodInventoryButtonTypes.BUTTON_GARAGE.ordinal() ? "Гараж" : i == RodInventoryButtonTypes.BUTTON_SECURITY.ordinal() ? "Охранники" : i == RodInventoryButtonTypes.BUTTON_CARS.ordinal() ? "Мой транспорт" : i == RodInventoryButtonTypes.BUTTON_BIZ.ordinal() ? "Мои бизнесы" : i == RodInventoryButtonTypes.BUTTON_HOUSES.ordinal() ? "Мои дома" : i == RodInventoryButtonTypes.BUTTON_TRAILER.ordinal() ? "Трейлер" : "";
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
            String deviceName = getDeviceName();
            String str4 = Build.VERSION.RELEASE;
            String str5 = str4 == null ? "" : str4;
            String str6 = z ? "com.arizona21.game" : "com.rodina21.game";
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1));
            builder.addInterceptor(httpLoggingInterceptor);
            ((TrackUsAPI) new Retrofit.Builder().baseUrl("https://track-us.bidease.com/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(TrackUsAPI.class)).sendTrackUsReq(str3, action, "0", "1", "SampleManager", str6, deviceName, "Android", str5, "ru", "image").enqueue(new Callback<ResponseBody>() { // from class: ru.mrlargha.commonui.utils.UtilsKt$sendTrackUsRequest$1
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
