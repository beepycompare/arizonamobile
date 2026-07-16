package ru.mrlargha.commonui.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.elements.hud.presentation.models.ServerInfoItem;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0012\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 \u001a\n\u0010!\u001a\u00020\"*\u00020#\u001a\n\u0010$\u001a\u00020 *\u00020#\u001a\"\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 2\b\b\u0002\u0010*\u001a\u00020(\u001a\"\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(\u001a\u0018\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(\u001a\u0018\u0010,\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(\u001a\u0012\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020/H\u0002\u001a \u00100\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020 H\u0002\u001aM\u00104\u001a\u0002H5\"\u0004\b\u0000\u00105*\u0002H52\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u000e07¢\u0006\u0002\b82\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001d07¢\u0006\u0002\b8H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010:\u001a&\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0007b\f\b@\u0012\b\bA\u0012\u0004\b\u0003\u00100\u001a\f\u0010B\u001a\u0004\u0018\u00010C*\u00020D\u001a\u000e\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(\u001a\u000e\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 \u001a\u0018\u0010I\u001a\u0004\u0018\u00010(2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020(\u001a\u000e\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020 \u001a\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020(0\u00012\u0006\u0010P\u001a\u00020#\u001a\u001e\u0010Q\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020 2\u0006\u0010P\u001a\u00020#\u001a\u001e\u0010Q\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020S2\u0006\u0010R\u001a\u00020 2\u0006\u0010P\u001a\u00020#\u001a\u000e\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020(\u001a\u0016\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020&\u001a\u0016\u0010Z\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020X2\u0006\u0010J\u001a\u00020K\u001a\u0016\u0010[\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020K2\u0006\u0010\\\u001a\u00020\u000e\u001a\"\u0010]\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020K2\u0006\u0010^\u001a\u00020 2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`\u001a&\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020=2\u0006\u0010f\u001a\u00020=\u001a\u001a\u0010g\u001a\u0004\u0018\u00010=2\b\u0010h\u001a\u0004\u0018\u00010=2\u0006\u0010i\u001a\u00020=\u001a\u000e\u0010j\u001a\u00020(2\u0006\u0010k\u001a\u00020(\u001a\u0016\u0010l\u001a\u00020(2\u0006\u0010J\u001a\u00020K2\u0006\u0010)\u001a\u00020 \u001a\u0016\u0010m\u001a\u00020(2\u0006\u0010J\u001a\u00020K2\u0006\u0010)\u001a\u00020 \u001a\u0006\u0010n\u001a\u00020(\u001a\u0012\u0010o\u001a\u00020(2\b\u0010p\u001a\u0004\u0018\u00010(H\u0002\u001a\u000e\u0010q\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020K\u001a\u000e\u0010r\u001a\u00020s2\u0006\u0010J\u001a\u00020K\u001a\u000e\u0010t\u001a\u00020(2\u0006\u0010u\u001a\u00020 \u001a\u000e\u0010v\u001a\u00020(2\u0006\u0010w\u001a\u00020x\u001a\u001a\u0010y\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010z\u001a\u00020(2\u0006\u0010H\u001a\u00020 \u001a\n\u0010{\u001a\u00020|*\u00020K\u001a&\u0010}\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020X2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0086@¢\u0006\u0002\u0010~\u001a\u001e\u0010\u007f\u001a\u00020\u001d*\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020(2\t\b\u0002\u0010\u0081\u0001\u001a\u00020(\u001a#\u0010\u0082\u0001\u001a\u00020\u001d*\u00020X2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0086@¢\u0006\u0002\u0010~\u001a#\u0010\u0083\u0001\u001a\u00020\u001d*\u00020X2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0086@¢\u0006\u0002\u0010~\u001a#\u0010\u0084\u0001\u001a\u00020\u001d*\u00020X2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0086@¢\u0006\u0002\u0010~\u001a&\u0010\u0085\u0001\u001a\u00020\u001d*\u00020X2\b\b\u0002\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 H\u0086@¢\u0006\u0003\u0010\u0086\u0001\" \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"\u0011\u0010\u0013\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010\"\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012\"\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010\"\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012\"\u0011\u0010\u001b\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010\"\u000e\u0010+\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0087\u0001"}, d2 = {"itemsName", "", "Lru/mrlargha/commonui/utils/ItemsInfo;", "getItemsName", "()Ljava/util/List;", "setItemsName", "(Ljava/util/List;)V", "zipFileIcons", "Ljava/util/zip/ZipFile;", "getZipFileIcons", "()Ljava/util/zip/ZipFile;", "setZipFileIcons", "(Ljava/util/zip/ZipFile;)V", "_isArizonaType", "", "get_isArizonaType", "()Z", "set_isArizonaType", "(Z)V", "isArizonaType", "_isBrazilType", "get_isBrazilType", "set_isBrazilType", "isBrazilType", "_isDebug", "get_isDebug", "set_isDebug", "isDebug", "setTextTimeFormat", "", "Landroid/widget/TextView;", "time", "", "getAnimationScale", "", "Landroid/app/Activity;", "getKeyboardHeightOrNull", "getIconFromArchive", "Landroid/graphics/Bitmap;", "folderName", "", "item", "gearsIconName", "MAX_DIM", "getIconFromArchiveWithFormat", "getBitmapFromEntry", "entry", "Ljava/util/zip/ZipEntry;", "calculateInSampleSizeToMax", "srcW", "srcH", "maxDim", "applyIf", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setDragClick", "itemVal", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "view", "Landroid/view/View;", "Landroidx/annotation/RequiresApi;", "value", "getInventoryDragState", "Lru/mrlargha/commonui/utils/InventoryDragState;", "Landroid/view/DragEvent;", "updateJsonString", "jsonString", "getColorTint", "color", "getJsonFromAssets", "context", "Landroid/content/Context;", "fileName", "nextMultipleOfFive", "x", "getItemsDescription", "targetActivity", "setDrawableEnd", "viewInt", "Landroid/widget/EditText;", "deleteSvgWord", "svg", "setImage", "imageView", "Landroid/widget/ImageView;", "bitmap", "setNotLoadedImage", "checkItemsName", "isArizona", "getItemsJson", "type", "dir", "Ljava/io/File;", "sendData", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "backendID", "fromItem", "toItem", "updateInventoryItem", "originalItem", "newItem", "convertPngToWebp", "png", "defineArzMenuText", "defineRodMenuText", "getDeviceName", "capitalize", CmcdData.STREAMING_FORMAT_SS, "getArizonaType", "getServerId", "Lru/mrlargha/commonui/elements/hud/presentation/models/ServerInfoItem;", "formatNumberWithSpaces", "number", "formatTime", "millisUntilFinished", "", "setColoredTextBeforeDot", "fullText", "getBaseShredPref", "Landroid/content/SharedPreferences;", "loadGifFromZipAsync", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gifLoadFromCdn", "url", "fallbackImage", "gifGetFromZipAcyncGif", "gifGetFromZipAcync", "setImageFromZipAcync", "setImageFromArchive", "(Landroid/widget/ImageView;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    private static final int MAX_DIM = 1024;
    private static boolean _isBrazilType;
    private static ZipFile zipFileIcons;
    private static List<ItemsInfo> itemsName = CollectionsKt.emptyList();
    private static boolean _isArizonaType = true;
    private static boolean _isDebug = true;

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

    public static final boolean get_isArizonaType() {
        return _isArizonaType;
    }

    public static final void set_isArizonaType(boolean z) {
        _isArizonaType = z;
    }

    public static final boolean isArizonaType() {
        return _isArizonaType;
    }

    public static final boolean get_isBrazilType() {
        return _isBrazilType;
    }

    public static final void set_isBrazilType(boolean z) {
        _isBrazilType = z;
    }

    public static final boolean isBrazilType() {
        return _isBrazilType;
    }

    public static final boolean get_isDebug() {
        return _isDebug;
    }

    public static final void set_isDebug(boolean z) {
        _isDebug = z;
    }

    public static final boolean isDebug() {
        return _isDebug;
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x005a A[Catch: Exception -> 0x0060, TRY_LEAVE, TryCatch #0 {Exception -> 0x0060, blocks: (B:3:0x000b, B:6:0x0015, B:8:0x0019, B:14:0x005a, B:9:0x0033, B:11:0x0037), top: B:20:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getIconFromArchive(String folderName, int i, String gearsIconName) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(gearsIconName, "gearsIconName");
        try {
            if (Intrinsics.areEqual(folderName, "gears")) {
                ZipFile zipFile = zipFileIcons;
                if (zipFile != null) {
                    entry = zipFile.getEntry(folderName + "/" + gearsIconName);
                    if (entry == null) {
                        return getBitmapFromEntry(entry);
                    }
                    return null;
                }
                entry = null;
                if (entry == null) {
                }
            } else {
                ZipFile zipFile2 = zipFileIcons;
                if (zipFile2 != null) {
                    entry = zipFile2.getEntry(folderName + "/" + i + ".webp");
                    if (entry == null) {
                    }
                }
                entry = null;
                if (entry == null) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Bitmap getIconFromArchive$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return getIconFromArchive(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x0010, B:6:0x001a, B:8:0x001e, B:14:0x0059, B:9:0x0038, B:11:0x003c), top: B:20:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getIconFromArchive(String folderName, String item, String gearsIconName) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(gearsIconName, "gearsIconName");
        try {
            if (Intrinsics.areEqual(folderName, "gears")) {
                ZipFile zipFile = zipFileIcons;
                if (zipFile != null) {
                    entry = zipFile.getEntry(folderName + "/" + gearsIconName);
                    if (entry == null) {
                        return getBitmapFromEntry(entry);
                    }
                    return null;
                }
                entry = null;
                if (entry == null) {
                }
            } else {
                ZipFile zipFile2 = zipFileIcons;
                if (zipFile2 != null) {
                    entry = zipFile2.getEntry(folderName + "/" + item);
                    if (entry == null) {
                    }
                }
                entry = null;
                if (entry == null) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final Bitmap getIconFromArchive(String folderName, String item) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        ZipFile zipFile = zipFileIcons;
        if (zipFile == null || (entry = zipFile.getEntry(folderName + "/" + item + ".webp")) == null) {
            return null;
        }
        return getBitmapFromEntry(entry);
    }

    public static final Bitmap getIconFromArchiveWithFormat(String folderName, String item) {
        ZipEntry entry;
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(item, "item");
        ZipFile zipFile = zipFileIcons;
        if (zipFile == null || (entry = zipFile.getEntry(folderName + "/" + item)) == null) {
            return null;
        }
        return getBitmapFromEntry(entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap getBitmapFromEntry(ZipEntry zipEntry) {
        ZipFile zipFile = zipFileIcons;
        if (zipFile == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inScaled = false;
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 32768);
                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                CloseableKt.closeFinally(bufferedInputStream, null);
                CloseableKt.closeFinally(inputStream, null);
                int i = options.outWidth;
                int i2 = options.outHeight;
                if (i <= 0 || i2 <= 0) {
                    return null;
                }
                int calculateInSampleSizeToMax = calculateInSampleSizeToMax(i, i2, 1024);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = calculateInSampleSizeToMax;
                options2.inDither = true;
                options2.inScaled = false;
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream, 32768);
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                    CloseableKt.closeFinally(bufferedInputStream2, null);
                    CloseableKt.closeFinally(inputStream, null);
                    if (decodeStream == null) {
                        return null;
                    }
                    if (decodeStream.getWidth() > 1024 || decodeStream.getHeight() > 1024) {
                        float min = Math.min(1024.0f / decodeStream.getWidth(), 1024.0f / decodeStream.getHeight());
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, RangesKt.coerceAtLeast((int) (decodeStream.getWidth() * min), 1), RangesKt.coerceAtLeast((int) (decodeStream.getHeight() * min), 1), true);
                        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
                        if (createScaledBitmap != decodeStream) {
                            decodeStream.recycle();
                        }
                        return createScaledBitmap;
                    }
                    return decodeStream;
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final int calculateInSampleSizeToMax(int i, int i2, int i3) {
        int i4 = 1;
        int i5 = i;
        int i6 = i2;
        while (true) {
            if (i5 <= i3 && i6 <= i3) {
                return i4;
            }
            i4 <<= 1;
            i5 = i / i4;
            i6 = i2 / i4;
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

    public static final boolean setDragClick(InventoryItem itemVal, View view) {
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        Intrinsics.checkNotNullParameter(view, "view");
        view.startDragAndDrop(null, new View.DragShadowBuilder(view), new InventoryDragState(InventoryItem.copy$default(itemVal, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, 66846719, null), view), 0);
        return true;
    }

    public static final InventoryDragState getInventoryDragState(DragEvent dragEvent) {
        Intrinsics.checkNotNullParameter(dragEvent, "<this>");
        Object localState = dragEvent.getLocalState();
        if (localState instanceof InventoryDragState) {
            return (InventoryDragState) localState;
        }
        return null;
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
        if (isArizonaType()) {
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
        imageView.setImageBitmap(bitmap);
    }

    public static final void setNotLoadedImage(ImageView imageView, Context context) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(context, "context");
        imageView.setImageResource(R.drawable.baseline_warning_24);
    }

    public static final void checkItemsName(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (itemsName.isEmpty()) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(applicationContext, 0);
            BuildersKt.launch$default(arizonaRetrofit.getScope(), Dispatchers.getIO(), null, new UtilsKt$checkItemsName$1((InventoryApi) ArizonaRetrofit.create$default(arizonaRetrofit, InventoryApi.class, false, null, null, 14, null), null), 2, null);
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

    public static final void sendData(IBackendNotifier frontendNotifier, int i, InventoryItem fromItem, InventoryItem toItem) {
        long j;
        Intrinsics.checkNotNullParameter(frontendNotifier, "frontendNotifier");
        Intrinsics.checkNotNullParameter(fromItem, "fromItem");
        Intrinsics.checkNotNullParameter(toItem, "toItem");
        if (fromItem.getAmount() != null) {
            Long amount = fromItem.getAmount();
            j = amount != null ? amount.longValue() : 0L;
        } else {
            j = 1;
        }
        long j2 = j;
        if (fromItem.getSlot() == toItem.getSlot() && fromItem.getInventoryType() == toItem.getInventoryType()) {
            Log.d("TAG_SEND", "EQUAL ITEMS");
            return;
        }
        Log.d("TAG_SEND", "backendID: " + i + " ====== from : " + fromItem + " ===== toItem : " + toItem);
        byte[] bytes = StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(fromItem.getSlot(), fromItem.getInventoryType(), j2, fromItem.getId()), new ChangeToSlot(toItem.getSlot(), toItem.getInventoryType()))).getBytes(Charsets.UTF_8);
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
            Long amount = newItem.getAmount();
            if (amount == null) {
                amount = inventoryItem.getAmount();
            }
            Long l = amount;
            Integer background = newItem.getBackground();
            Integer color = newItem.getColor();
            if (color == null) {
                color = inventoryItem.getColor();
            }
            Integer num3 = color;
            Integer bits = newItem.getBits();
            if (bits == null) {
                bits = inventoryItem.getBits();
            }
            Integer num4 = bits;
            Integer available = newItem.getAvailable();
            if (available == null) {
                available = inventoryItem.getAvailable();
            }
            Integer num5 = available;
            Integer enchant = newItem.getEnchant();
            if (enchant == null) {
                enchant = inventoryItem.getEnchant();
            }
            Integer num6 = enchant;
            Integer blackout = newItem.getBlackout();
            if (blackout == null) {
                blackout = inventoryItem.getBlackout();
            }
            Integer num7 = blackout;
            Long time = newItem.getTime();
            if (time == null) {
                time = inventoryItem.getTime();
            }
            Long l2 = time;
            Integer itemStrength = newItem.getItemStrength();
            if (itemStrength == null) {
                itemStrength = inventoryItem.getItemStrength();
            }
            Integer num8 = itemStrength;
            Integer isActive = newItem.isActive();
            if (isActive == null) {
                isActive = inventoryItem.isActive();
            }
            Integer num9 = isActive;
            Integer breaks = newItem.getBreaks();
            if (breaks == null) {
                breaks = inventoryItem.getBreaks();
            }
            Integer num10 = breaks;
            int inventoryType = newItem.getInventoryType();
            Integer acsSlot = newItem.getAcsSlot();
            if (acsSlot == null) {
                acsSlot = inventoryItem.getAcsSlot();
            }
            Integer num11 = acsSlot;
            Bitmap photoBitmap = newItem.getPhotoBitmap();
            if (photoBitmap == null) {
                photoBitmap = inventoryItem.getPhotoBitmap();
            }
            Bitmap bitmap = photoBitmap;
            String effect = newItem.getEffect();
            if (effect == null) {
                effect = inventoryItem.getEffect();
            }
            String str2 = effect;
            String customIcon = newItem.getCustomIcon();
            if (customIcon == null) {
                customIcon = inventoryItem.getCustomIcon();
            }
            String str3 = customIcon;
            Boolean loading = newItem.getLoading();
            return InventoryItem.copy$default(inventoryItem, slot, num, id, str, num2, l, background, num3, num4, num5, num6, num7, l2, num8, num9, num10, inventoryType, num11, bitmap, false, false, str2, null, null, str3, Boolean.valueOf(loading != null ? loading.booleanValue() : false), 14155776, null);
        }
        return null;
    }

    public static final String convertPngToWebp(String png) {
        Intrinsics.checkNotNullParameter(png, "png");
        return StringsKt.replace$default(png, "png", "webp", false, 4, (Object) null);
    }

    public static final String defineArzMenuText(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == ArzInventoryButtonTypes.BUTTON_INVENTORY.ordinal()) {
            String string = context.getString(R.string.inventory);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == ArzInventoryButtonTypes.BUTTON_CAR_INVENTORY.ordinal()) {
            String string2 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (i == ArzInventoryButtonTypes.BUTTON_CHEST.ordinal()) {
            String string3 = context.getString(R.string.warehouse_chest);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (i == ArzInventoryButtonTypes.BUTTON_HOTEL_ROOM.ordinal()) {
            String string4 = context.getString(R.string.warehouse_house);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else if (i == ArzInventoryButtonTypes.BUTTON_TRUNK.ordinal()) {
            String string5 = context.getString(R.string.warehouse_trunk);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        } else if (i == ArzInventoryButtonTypes.BUTTON_FAM_FLAT.ordinal()) {
            String string6 = context.getString(R.string.warehouse_family);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        } else if (i == ArzInventoryButtonTypes.BUTTON_HOUSE.ordinal()) {
            String string7 = context.getString(R.string.warehouse_house);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        } else if (i == ArzInventoryButtonTypes.BUTTON_TRAILER.ordinal()) {
            String string8 = context.getString(R.string.warehouse_house);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        } else if (i == ArzInventoryButtonTypes.BUTTON_STOREHOUSE.ordinal()) {
            String string9 = context.getString(R.string.warehouse_storehouse);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        } else if (i == ArzInventoryButtonTypes.BUTTON_PAWNSHOP.ordinal()) {
            String string10 = context.getString(R.string.warehouse_lombard_menu);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        } else if (i == ArzInventoryButtonTypes.BUTTON_TRASH.ordinal()) {
            String string11 = context.getString(R.string.warehouse_trash);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            return string11;
        } else if (i == ArzInventoryButtonTypes.BUTTON_SECURITY.ordinal()) {
            String string12 = context.getString(R.string.security_guards);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            return string12;
        } else if (i == ArzInventoryButtonTypes.BUTTON_CARS.ordinal()) {
            String string13 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return string13;
        } else if (i == ArzInventoryButtonTypes.BUTTON_BIZ.ordinal()) {
            String string14 = context.getString(R.string.my_businesses);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            return string14;
        } else if (i == ArzInventoryButtonTypes.BUTTON_HOUSES.ordinal()) {
            String string15 = context.getString(R.string.my_houses);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            return string15;
        } else {
            return "";
        }
    }

    public static final String defineRodMenuText(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == RodInventoryButtonTypes.BUTTON_INVENTORY.ordinal()) {
            String string = context.getString(R.string.inventory);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == RodInventoryButtonTypes.BUTTON_CAR_INVENTORY.ordinal()) {
            String string2 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (i == RodInventoryButtonTypes.BUTTON_TRASH.ordinal()) {
            String string3 = context.getString(R.string.warehouse_trash);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (i == RodInventoryButtonTypes.BUTTON_TRUNK.ordinal()) {
            String string4 = context.getString(R.string.warehouse_trunk);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else if (i == RodInventoryButtonTypes.BUTTON_HOUSE.ordinal()) {
            String string5 = context.getString(R.string.warehouse_home_wardrobe);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        } else if (i == RodInventoryButtonTypes.BUTTON_DRAWER.ordinal()) {
            String string6 = context.getString(R.string.warehouse_nightstand);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        } else if (i == RodInventoryButtonTypes.BUTTON_SHIP.ordinal()) {
            String string7 = context.getString(R.string.warehouse_ship);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        } else if (i == RodInventoryButtonTypes.BUTTON_CAMPER.ordinal()) {
            String string8 = context.getString(R.string.warehouse_motorhome);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        } else if (i == RodInventoryButtonTypes.BUTTON_BANK_VAULT.ordinal()) {
            String string9 = context.getString(R.string.warehouse_bank_vault);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        } else if (i == RodInventoryButtonTypes.BUTTON_FRACTION_WAREHOUSE.ordinal()) {
            String string10 = context.getString(R.string.warehouse_fraction);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        } else if (i == RodInventoryButtonTypes.BUTTON_FAMILY_WAREHOUSE.ordinal()) {
            String string11 = context.getString(R.string.warehouse_family);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            return string11;
        } else if (i == RodInventoryButtonTypes.BUTTON_GARDENING_BARN.ordinal()) {
            String string12 = context.getString(R.string.warehouse_barn);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            return string12;
        } else if (i == RodInventoryButtonTypes.BUTTON_GARAGE.ordinal()) {
            String string13 = context.getString(R.string.garage);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return string13;
        } else if (i == RodInventoryButtonTypes.BUTTON_SECURITY.ordinal()) {
            String string14 = context.getString(R.string.security_guards);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            return string14;
        } else if (i == RodInventoryButtonTypes.BUTTON_CARS.ordinal()) {
            String string15 = context.getString(R.string.my_transport);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            return string15;
        } else if (i == RodInventoryButtonTypes.BUTTON_BIZ.ordinal()) {
            String string16 = context.getString(R.string.my_businesses);
            Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
            return string16;
        } else if (i == RodInventoryButtonTypes.BUTTON_HOUSES.ordinal()) {
            String string17 = context.getString(R.string.my_houses);
            Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
            return string17;
        } else if (i == RodInventoryButtonTypes.BUTTON_TRAILER.ordinal()) {
            String string18 = context.getString(R.string.trailer);
            Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
            return string18;
        } else if (i == RodInventoryButtonTypes.BUTTON_LABORATORY.ordinal()) {
            String string19 = context.getString(R.string.warehouse_laboratory);
            Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
            return string19;
        } else if (i == RodInventoryButtonTypes.BUTTON_WAREHOUSE_GARAGE.ordinal()) {
            String string20 = context.getString(R.string.garage);
            Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
            return string20;
        } else if (i == RodInventoryButtonTypes.BUTTON_LABORATORY_LOOT.ordinal()) {
            String string21 = context.getString(R.string.warehouse_laboratory_loot);
            Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
            return string21;
        } else {
            return "";
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

    public static final boolean getArizonaType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isArizonaType();
    }

    public static final ServerInfoItem getServerId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences baseShredPref = getBaseShredPref(context);
        int i = baseShredPref.getInt(ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys.SERVER_ID.getKeyName(), 0);
        String string = baseShredPref.getString(ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys.API_TOKEN.getKeyName(), "");
        return new ServerInfoItem(string != null ? string : "", i, baseShredPref.getInt(ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys.ACCOUNT_ID.getKeyName(), 0));
    }

    public static final String formatNumberWithSpaces(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringsKt.replace$default(format, StringUtils.COMMA, " ", false, 4, (Object) null);
    }

    public static final String formatTime(long j) {
        long j2 = j / 1000;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final void setColoredTextBeforeDot(TextView textView, String fullText, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(fullText, "fullText");
        String str = fullText;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            textView.setText(str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, indexOf$default, 33);
        textView.setText(spannableString);
    }

    public static final SharedPreferences getBaseShredPref(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences sharedPreferences = context.getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object loadGifFromZipAsync(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$loadGifFromZipAsync$1 utilsKt$loadGifFromZipAsync$1;
        int i;
        byte[] bArr;
        if (continuation instanceof UtilsKt$loadGifFromZipAsync$1) {
            utilsKt$loadGifFromZipAsync$1 = (UtilsKt$loadGifFromZipAsync$1) continuation;
            if ((utilsKt$loadGifFromZipAsync$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$loadGifFromZipAsync$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$loadGifFromZipAsync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$loadGifFromZipAsync$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$loadGifFromZipAsync$1.L$0 = imageView;
                    utilsKt$loadGifFromZipAsync$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$loadGifFromZipAsync$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$loadGifFromZipAsync$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$loadGifFromZipAsync$bytes$1(str, str2, null), utilsKt$loadGifFromZipAsync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$loadGifFromZipAsync$1.L$2;
                    String str4 = (String) utilsKt$loadGifFromZipAsync$1.L$1;
                    imageView = (ImageView) utilsKt$loadGifFromZipAsync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return Unit.INSTANCE;
                }
                Glide.with(imageView).asGif().load(bArr).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
                return Unit.INSTANCE;
            }
        }
        utilsKt$loadGifFromZipAsync$1 = new UtilsKt$loadGifFromZipAsync$1(continuation);
        Object obj2 = utilsKt$loadGifFromZipAsync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$loadGifFromZipAsync$1.label;
        if (i != 0) {
        }
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    public static /* synthetic */ void gifLoadFromCdn$default(ImageView imageView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        gifLoadFromCdn(imageView, str, str2);
    }

    public static final void gifLoadFromCdn(ImageView imageView, String url, String fallbackImage) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
        ImageView imageView2 = imageView;
        RequestBuilder<Drawable> load = Glide.with(imageView2).load(fallbackImage);
        Intrinsics.checkNotNullExpressionValue(load, "load(...)");
        Glide.with(imageView2).asGif().load(url).placeholder(R.drawable.loading_gif).error((Object) load).into(imageView);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object gifGetFromZipAcyncGif(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$gifGetFromZipAcyncGif$1 utilsKt$gifGetFromZipAcyncGif$1;
        int i;
        byte[] bArr;
        if (continuation instanceof UtilsKt$gifGetFromZipAcyncGif$1) {
            utilsKt$gifGetFromZipAcyncGif$1 = (UtilsKt$gifGetFromZipAcyncGif$1) continuation;
            if ((utilsKt$gifGetFromZipAcyncGif$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$gifGetFromZipAcyncGif$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$gifGetFromZipAcyncGif$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$gifGetFromZipAcyncGif$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$gifGetFromZipAcyncGif$1.L$0 = imageView;
                    utilsKt$gifGetFromZipAcyncGif$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$gifGetFromZipAcyncGif$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$gifGetFromZipAcyncGif$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$gifGetFromZipAcyncGif$bytes$1(str, str2, null), utilsKt$gifGetFromZipAcyncGif$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$gifGetFromZipAcyncGif$1.L$2;
                    String str4 = (String) utilsKt$gifGetFromZipAcyncGif$1.L$1;
                    imageView = (ImageView) utilsKt$gifGetFromZipAcyncGif$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return Unit.INSTANCE;
                }
                Glide.with(imageView).asGif().load(bArr).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
                return Unit.INSTANCE;
            }
        }
        utilsKt$gifGetFromZipAcyncGif$1 = new UtilsKt$gifGetFromZipAcyncGif$1(continuation);
        Object obj2 = utilsKt$gifGetFromZipAcyncGif$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$gifGetFromZipAcyncGif$1.label;
        if (i != 0) {
        }
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object gifGetFromZipAcync(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$gifGetFromZipAcync$1 utilsKt$gifGetFromZipAcync$1;
        int i;
        byte[] bArr;
        if (continuation instanceof UtilsKt$gifGetFromZipAcync$1) {
            utilsKt$gifGetFromZipAcync$1 = (UtilsKt$gifGetFromZipAcync$1) continuation;
            if ((utilsKt$gifGetFromZipAcync$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$gifGetFromZipAcync$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$gifGetFromZipAcync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$gifGetFromZipAcync$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$gifGetFromZipAcync$1.L$0 = imageView;
                    utilsKt$gifGetFromZipAcync$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$gifGetFromZipAcync$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$gifGetFromZipAcync$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$gifGetFromZipAcync$bytes$1(str, str2, null), utilsKt$gifGetFromZipAcync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$gifGetFromZipAcync$1.L$2;
                    String str4 = (String) utilsKt$gifGetFromZipAcync$1.L$1;
                    imageView = (ImageView) utilsKt$gifGetFromZipAcync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return Unit.INSTANCE;
                }
                Glide.with(imageView).load(bArr).dontAnimate().into(imageView);
                return Unit.INSTANCE;
            }
        }
        utilsKt$gifGetFromZipAcync$1 = new UtilsKt$gifGetFromZipAcync$1(continuation);
        Object obj2 = utilsKt$gifGetFromZipAcync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$gifGetFromZipAcync$1.label;
        if (i != 0) {
        }
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object setImageFromZipAcync(ImageView imageView, String str, String str2, Continuation<? super Unit> continuation) {
        UtilsKt$setImageFromZipAcync$1 utilsKt$setImageFromZipAcync$1;
        int i;
        Bitmap bitmap;
        if (continuation instanceof UtilsKt$setImageFromZipAcync$1) {
            utilsKt$setImageFromZipAcync$1 = (UtilsKt$setImageFromZipAcync$1) continuation;
            if ((utilsKt$setImageFromZipAcync$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$setImageFromZipAcync$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$setImageFromZipAcync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utilsKt$setImageFromZipAcync$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$setImageFromZipAcync$1.L$0 = imageView;
                    utilsKt$setImageFromZipAcync$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$setImageFromZipAcync$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    utilsKt$setImageFromZipAcync$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$setImageFromZipAcync$bytes$1(str, str2, null), utilsKt$setImageFromZipAcync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str3 = (String) utilsKt$setImageFromZipAcync$1.L$2;
                    String str4 = (String) utilsKt$setImageFromZipAcync$1.L$1;
                    imageView = (ImageView) utilsKt$setImageFromZipAcync$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    return Unit.INSTANCE;
                }
                imageView.setImageBitmap(bitmap);
                return Unit.INSTANCE;
            }
        }
        utilsKt$setImageFromZipAcync$1 = new UtilsKt$setImageFromZipAcync$1(continuation);
        Object obj2 = utilsKt$setImageFromZipAcync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utilsKt$setImageFromZipAcync$1.label;
        if (i != 0) {
        }
        bitmap = (Bitmap) obj2;
        if (bitmap != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object setImageFromArchive(ImageView imageView, String str, int i, Continuation<? super Unit> continuation) {
        UtilsKt$setImageFromArchive$1 utilsKt$setImageFromArchive$1;
        int i2;
        Bitmap bitmap;
        if (continuation instanceof UtilsKt$setImageFromArchive$1) {
            utilsKt$setImageFromArchive$1 = (UtilsKt$setImageFromArchive$1) continuation;
            if ((utilsKt$setImageFromArchive$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$setImageFromArchive$1.label -= Integer.MIN_VALUE;
                Object obj = utilsKt$setImageFromArchive$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = utilsKt$setImageFromArchive$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    utilsKt$setImageFromArchive$1.L$0 = imageView;
                    utilsKt$setImageFromArchive$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    utilsKt$setImageFromArchive$1.I$0 = i;
                    utilsKt$setImageFromArchive$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilsKt$setImageFromArchive$bitmap$1(str, i, null), utilsKt$setImageFromArchive$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = utilsKt$setImageFromArchive$1.I$0;
                    String str2 = (String) utilsKt$setImageFromArchive$1.L$1;
                    imageView = (ImageView) utilsKt$setImageFromArchive$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bitmap = (Bitmap) obj;
                if (bitmap == null) {
                    setImage(imageView, bitmap);
                } else {
                    Context context = imageView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    setNotLoadedImage(imageView, context);
                }
                return Unit.INSTANCE;
            }
        }
        utilsKt$setImageFromArchive$1 = new UtilsKt$setImageFromArchive$1(continuation);
        Object obj2 = utilsKt$setImageFromArchive$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = utilsKt$setImageFromArchive$1.label;
        if (i2 != 0) {
        }
        bitmap = (Bitmap) obj2;
        if (bitmap == null) {
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object setImageFromArchive$default(ImageView imageView, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "items";
        }
        return setImageFromArchive(imageView, str, i, continuation);
    }
}
