package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.UByte$$ExternalSyntheticBackport0;
/* loaded from: classes2.dex */
public class FontsContractCompat {
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";
    @Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    /* loaded from: classes2.dex */
    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    /* loaded from: classes2.dex */
    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @Deprecated
        public static final int RESULT_OK = 0;
        static final int RESULT_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TypefaceStyle {
    }

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        List m;
        m = UByte$$ExternalSyntheticBackport0.m(new Object[]{fontRequest});
        return FontProvider.getFontFamilyResult(context, m, cancellationSignal);
    }

    @Deprecated
    public static void requestFont(Context context, FontRequest fontRequest, FontRequestCallback fontRequestCallback, Handler handler) {
        List m;
        CallbackWrapper callbackWrapper = new CallbackWrapper(fontRequestCallback);
        Executor createHandlerExecutor = RequestExecutor.createHandlerExecutor(handler);
        Context applicationContext = context.getApplicationContext();
        m = UByte$$ExternalSyntheticBackport0.m(new Object[]{fontRequest});
        FontRequestWorker.requestFontAsync(applicationContext, m, 0, createHandlerExecutor, callbackWrapper);
    }

    public static void requestFont(Context context, FontRequest fontRequest, int i, Executor executor, Executor executor2, FontRequestCallback fontRequestCallback) {
        List m;
        CallbackWrapper callbackWrapper = new CallbackWrapper(fontRequestCallback, executor2);
        Context applicationContext = context.getApplicationContext();
        m = UByte$$ExternalSyntheticBackport0.m(new Object[]{fontRequest});
        FontRequestWorker.requestFontAsync(applicationContext, m, i, executor, callbackWrapper);
    }

    public static void requestFontWithFallbackChain(Context context, List<FontRequest> list, int i, Executor executor, Executor executor2, FontRequestCallback fontRequestCallback) {
        FontRequestWorker.requestFontAsync(context.getApplicationContext(), list, i, executor, new CallbackWrapper(fontRequestCallback, executor2));
    }

    public static Typeface requestFont(Context context, List<FontRequest> list, int i, boolean z, int i2, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(fontRequestCallback, RequestExecutor.createHandlerExecutor(handler));
        if (z) {
            if (list.size() > 1) {
                throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
            }
            return FontRequestWorker.requestFontSync(context, list.get(0), callbackWrapper, i, i2);
        }
        return FontRequestWorker.requestFontAsync(context, list, i, null, callbackWrapper);
    }

    public static Typeface requestFont(Context context, FontRequest fontRequest, int i, boolean z, int i2, Handler handler, FontRequestCallback fontRequestCallback) {
        List m;
        m = UByte$$ExternalSyntheticBackport0.m(new Object[]{fontRequest});
        return requestFont(context, m, i, z, i2, handler, fontRequestCallback);
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    /* loaded from: classes2.dex */
    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        @Deprecated
        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.mUri = (Uri) Preconditions.checkNotNull(uri);
            this.mTtcIndex = i;
            this.mWeight = i2;
            this.mItalic = z;
            this.mResultCode = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontInfo create(Uri uri, int i, int i2, boolean z, int i3) {
            return new FontInfo(uri, i, i2, z, i3);
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }

        public int getResultCode() {
            return this.mResultCode;
        }
    }

    /* loaded from: classes2.dex */
    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final List<FontInfo[]> mFonts;
        private final int mStatusCode;

        @Deprecated
        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.mStatusCode = i;
            this.mFonts = Collections.singletonList(fontInfoArr);
        }

        FontFamilyResult(int i, List<FontInfo[]> list) {
            this.mStatusCode = i;
            this.mFonts = list;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        public FontInfo[] getFonts() {
            return this.mFonts.get(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasFallback() {
            return this.mFonts.size() > 1;
        }

        public List<FontInfo[]> getFontsWithFallbacks() {
            return this.mFonts;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult create(int i, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i, fontInfoArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult create(int i, List<FontInfo[]> list) {
            return new FontFamilyResult(i, list);
        }
    }

    @Deprecated
    public static Typeface getFontSync(Context context, FontRequest fontRequest, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z, int i, int i2) {
        List m;
        TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter = new TypefaceCompat.ResourcesCallbackAdapter(fontCallback);
        Handler handler2 = ResourcesCompat.FontCallback.getHandler(handler);
        m = UByte$$ExternalSyntheticBackport0.m(new Object[]{fontRequest});
        return requestFont(context, m, i2, z, i, handler2, resourcesCallbackAdapter);
    }

    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
    }

    @Deprecated
    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.getProvider(packageManager, fontRequest, resources);
    }
}
