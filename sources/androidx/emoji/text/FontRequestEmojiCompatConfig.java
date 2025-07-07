package androidx.emoji.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiCompat;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    /* loaded from: classes2.dex */
    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    /* loaded from: classes2.dex */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j) {
            this.mTotalMs = j;
        }

        @Override // androidx.emoji.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0L;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (uptimeMillis > this.mTotalMs) {
                return -1L;
            }
            return Math.min(Math.max(uptimeMillis, 1000L), this.mTotalMs - uptimeMillis);
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }

    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setHandler(handler);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    /* loaded from: classes2.dex */
    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private final FontProviderHelper mFontProviderHelper;
        private Runnable mHandleMetadataCreationRunner;
        private Handler mHandler;
        private final Object mLock = new Object();
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;
        private HandlerThread mThread;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        public void setHandler(Handler handler) {
            synchronized (this.mLock) {
                this.mHandler = handler;
            }
        }

        public void setRetryPolicy(RetryPolicy retryPolicy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = retryPolicy;
            }
        }

        @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                if (this.mHandler == null) {
                    HandlerThread handlerThread = new HandlerThread("emojiCompat", 10);
                    this.mThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mThread.getLooper());
                }
                this.mHandler.post(new Runnable() { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FontRequestMetadataLoader.this.mCallback = metadataRepoLoaderCallback;
                        FontRequestMetadataLoader.this.createMetadata();
                    }
                });
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fetchFonts.getStatusCode() != 0) {
                    throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
                }
                FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                if (fonts == null || fonts.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fonts[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void scheduleRetry(Uri uri, long j) {
            synchronized (this.mLock) {
                if (this.mObserver == null) {
                    ContentObserver contentObserver = new ContentObserver(this.mHandler) { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.2
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z, Uri uri2) {
                            FontRequestMetadataLoader.this.createMetadata();
                        }
                    };
                    this.mObserver = contentObserver;
                    this.mFontProviderHelper.registerObserver(this.mContext, uri, contentObserver);
                }
                if (this.mHandleMetadataCreationRunner == null) {
                    this.mHandleMetadataCreationRunner = new Runnable() { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FontRequestMetadataLoader.this.createMetadata();
                        }
                    };
                }
                this.mHandler.postDelayed(this.mHandleMetadataCreationRunner, j);
            }
        }

        private void cleanUp() {
            this.mCallback = null;
            ContentObserver contentObserver = this.mObserver;
            if (contentObserver != null) {
                this.mFontProviderHelper.unregisterObserver(this.mContext, contentObserver);
                this.mObserver = null;
            }
            synchronized (this.mLock) {
                this.mHandler.removeCallbacks(this.mHandleMetadataCreationRunner);
                HandlerThread handlerThread = this.mThread;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.mHandler = null;
                this.mThread = null;
            }
        }

        void createMetadata() {
            if (this.mCallback == null) {
                return;
            }
            try {
                FontsContractCompat.FontInfo retrieveFontInfo = retrieveFontInfo();
                int resultCode = retrieveFontInfo.getResultCode();
                if (resultCode == 2) {
                    synchronized (this.mLock) {
                        RetryPolicy retryPolicy = this.mRetryPolicy;
                        if (retryPolicy != null) {
                            long retryDelay = retryPolicy.getRetryDelay();
                            if (retryDelay >= 0) {
                                scheduleRetry(retrieveFontInfo.getUri(), retryDelay);
                                return;
                            }
                        }
                    }
                }
                if (resultCode != 0) {
                    throw new RuntimeException("fetchFonts result is not OK. (" + resultCode + ")");
                }
                Typeface buildTypeface = this.mFontProviderHelper.buildTypeface(this.mContext, retrieveFontInfo);
                ByteBuffer mmap = TypefaceCompatUtil.mmap(this.mContext, null, retrieveFontInfo.getUri());
                if (mmap == null) {
                    throw new RuntimeException("Unable to open file.");
                }
                this.mCallback.onLoaded(MetadataRepo.create(buildTypeface, mmap));
                cleanUp();
            } catch (Throwable th) {
                this.mCallback.onFailed(th);
                cleanUp();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class FontProviderHelper {
        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, null, fontRequest);
        }

        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public void registerObserver(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
}
