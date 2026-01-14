package ru.mrlargha.commonui.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c\u001a\n\u0010\u001d\u001a\u00020\u001e*\u00020\u001f\u001a\n\u0010 \u001a\u00020\u001c*\u00020\u001f\u001a\"\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020$\u001a\"\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$\u001a\u0018\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$\u001a\u0018\u0010(\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$\u001a\u0012\u0010)\u001a\u0004\u0018\u00010\"2\u0006\u0010*\u001a\u00020+H\u0002\u001a \u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cH\u0002\u001aM\u00100\u001a\u0002H1\"\u0004\b\u0000\u00101*\u0002H12\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u00020\u000e03¢\u0006\u0002\b42\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b4H\u0086\bø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0016\u00107\u001a\u00020\"2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001c\u001a\u0018\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0007\u001a\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$\u001a\u000e\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001c\u001a\u0018\u0010D\u001a\u0004\u0018\u00010$2\u0006\u00108\u001a\u0002092\u0006\u0010E\u001a\u00020$\u001a\u000e\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u001c\u001a\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020$0\u00012\u0006\u0010I\u001a\u00020\u001f\u001a\u001e\u0010J\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010K\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001f\u001a\u001e\u0010J\u001a\u00020\u00192\u0006\u0010>\u001a\u00020L2\u0006\u0010K\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001f\u001a\u000e\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$\u001a\u0016\u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\"\u001a\u0016\u0010S\u001a\u00020\u00192\u0006\u0010P\u001a\u00020Q2\u0006\u00108\u001a\u000209\u001a\u0016\u0010T\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u0006\u0010U\u001a\u00020\u000e\u001a\"\u0010V\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u0006\u0010W\u001a\u00020\u001c2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y\u001a&\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020=2\u0006\u0010_\u001a\u00020=\u001a\u001a\u0010`\u001a\u0004\u0018\u00010=2\b\u0010a\u001a\u0004\u0018\u00010=2\u0006\u0010b\u001a\u00020=\u001a\u000e\u0010c\u001a\u00020$2\u0006\u0010d\u001a\u00020$\u001a\u000e\u0010e\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c\u001a\u000e\u0010f\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c\u001a\u0006\u0010g\u001a\u00020$\u001a\u0012\u0010h\u001a\u00020$2\b\u0010i\u001a\u0004\u0018\u00010$H\u0002\u001a\u000e\u0010j\u001a\u00020\u000e2\u0006\u00108\u001a\u000209\u001a\u000e\u0010k\u001a\u00020l2\u0006\u00108\u001a\u000209\u001a\u000e\u0010m\u001a\u00020$2\u0006\u0010n\u001a\u00020\u001c\u001a\u000e\u0010o\u001a\u00020$2\u0006\u0010p\u001a\u00020q\u001a\u001a\u0010r\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010s\u001a\u00020$2\u0006\u0010C\u001a\u00020\u001c\u001a\n\u0010t\u001a\u00020u*\u000209\" \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"\u0011\u0010\u0013\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010\"\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012\"\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010\"\u000e\u0010'\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006v"}, d2 = {"itemsName", "", "Lru/mrlargha/commonui/utils/ItemsInfo;", "getItemsName", "()Ljava/util/List;", "setItemsName", "(Ljava/util/List;)V", "zipFileIcons", "Ljava/util/zip/ZipFile;", "getZipFileIcons", "()Ljava/util/zip/ZipFile;", "setZipFileIcons", "(Ljava/util/zip/ZipFile;)V", "_isArizonaType", "", "get_isArizonaType", "()Z", "set_isArizonaType", "(Z)V", "isArizonaType", "_isDebug", "get_isDebug", "set_isDebug", "isDebug", "setTextTimeFormat", "", "Landroid/widget/TextView;", "time", "", "getAnimationScale", "", "Landroid/app/Activity;", "getKeyboardHeightOrNull", "getIconFromArchive", "Landroid/graphics/Bitmap;", "folderName", "", "item", "gearsIconName", "MAX_DIM", "getIconFromArchiveWithFormat", "getBitmapFromEntry", "entry", "Ljava/util/zip/ZipEntry;", "calculateInSampleSizeToMax", "srcW", "srcH", "maxDim", "applyIf", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getBitmapFromVectorDrawable", "context", "Landroid/content/Context;", "drawableId", "setDragClick", "itemVal", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "view", "Landroid/view/View;", "updateJsonString", "jsonString", "getColorTint", "color", "getJsonFromAssets", "fileName", "nextMultipleOfFive", "x", "getItemsDescription", "targetActivity", "setDrawableEnd", "viewInt", "Landroid/widget/EditText;", "deleteSvgWord", "svg", "setImage", "imageView", "Landroid/widget/ImageView;", "bitmap", "setNotLoadedImage", "checkItemsName", "isArizona", "getItemsJson", "type", "dir", "Ljava/io/File;", "sendData", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "backendID", "fromItem", "toItem", "updateInventoryItem", "originalItem", "newItem", "convertPngToWebp", "png", "defineArzMenuText", "defineRodMenuText", "getDeviceName", "capitalize", CmcdData.STREAMING_FORMAT_SS, "getArizonaType", "getServerId", "Lru/mrlargha/commonui/elements/hud/presentation/models/ServerInfoItem;", "formatNumberWithSpaces", "number", "formatTime", "millisUntilFinished", "", "setColoredTextBeforeDot", "fullText", "getBaseShredPref", "Landroid/content/SharedPreferences;", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    private static final int MAX_DIM = 1024;
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

    private static final Bitmap getBitmapFromEntry(ZipEntry zipEntry) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inScaled = false;
            ZipFile zipFile = zipFileIcons;
            InputStream inputStream = zipFile != null ? zipFile.getInputStream(zipEntry) : null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 32768);
                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                CloseableKt.closeFinally(bufferedInputStream, null);
                CloseableKt.closeFinally(inputStream, null);
                int i = options.outWidth;
                int i2 = options.outHeight;
                if (i > 0 && i2 > 0) {
                    int calculateInSampleSizeToMax = calculateInSampleSizeToMax(i, i2, 1024);
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = false;
                    options2.inSampleSize = calculateInSampleSizeToMax;
                    options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options2.inDither = true;
                    options2.inScaled = false;
                    ZipFile zipFile2 = zipFileIcons;
                    inputStream = zipFile2 != null ? zipFile2.getInputStream(zipEntry) : null;
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream, 32768);
                        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                        CloseableKt.closeFinally(bufferedInputStream2, null);
                        CloseableKt.closeFinally(inputStream, null);
                        if (decodeStream == null) {
                            return null;
                        }
                        if (decodeStream.getWidth() <= 1024 && decodeStream.getHeight() <= 1024) {
                            return decodeStream;
                        }
                        float min = Math.min(1024.0f / decodeStream.getWidth(), 1024.0f / decodeStream.getHeight());
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, RangesKt.coerceAtLeast((int) (decodeStream.getWidth() * min), 1), RangesKt.coerceAtLeast((int) (decodeStream.getHeight() * min), 1), true);
                        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
                        if (createScaledBitmap != decodeStream) {
                            decodeStream.recycle();
                        }
                        return createScaledBitmap;
                    } finally {
                    }
                }
                return null;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
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
        imageView.setImageBitmap(bitmap);
    }

    public static final void setNotLoadedImage(ImageView imageView, Context context) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(context, "context");
        setImage(imageView, getBitmapFromVectorDrawable(context, R.drawable.baseline_warning_24));
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
            Bitmap bitmap = photoBitmap;
            String effect = newItem.getEffect();
            if (effect == null) {
                effect = inventoryItem.getEffect();
            }
            return InventoryItem.copy$default(inventoryItem, slot, num, id, str, num2, num3, background, num4, num5, num6, num7, num8, l, num9, num10, num11, inventoryType, num12, bitmap, false, false, effect, null, 5767168, null);
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
        return getBaseShredPref(context).getBoolean("isArizonaType", false);
    }

    public static final ServerInfoItem getServerId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences baseShredPref = getBaseShredPref(context);
        int i = baseShredPref.getInt(SharedPreferenceKeys.SERVER_ID.getKeyName(), 0);
        String string = baseShredPref.getString(SharedPreferenceKeys.API_TOKEN.getKeyName(), "");
        return new ServerInfoItem(string != null ? string : "", i, baseShredPref.getInt(SharedPreferenceKeys.ACCOUNT_ID.getKeyName(), 0));
    }

    public static final String formatNumberWithSpaces(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringsKt.replace$default(format, StringUtils.COMMA, " ", false, 4, (Object) null);
    }

    public static final String formatTime(long j) {
        long j2 = j / 1000;
        long j3 = 60;
        long j4 = j2 / j3;
        long j5 = j2 % j3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j5)}, 2));
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
}
