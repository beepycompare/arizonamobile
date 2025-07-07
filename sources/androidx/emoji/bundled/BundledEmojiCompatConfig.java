package androidx.emoji.bundled;

import android.content.Context;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.MetadataRepo;
/* loaded from: classes2.dex */
public class BundledEmojiCompatConfig extends EmojiCompat.Config {
    public BundledEmojiCompatConfig(Context context) {
        super(new BundledMetadataLoader(context));
    }

    /* loaded from: classes2.dex */
    private static class BundledMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BundledMetadataLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "loaderCallback cannot be null");
            Thread thread = new Thread(new InitRunnable(this.mContext, metadataRepoLoaderCallback));
            thread.setDaemon(false);
            thread.start();
        }
    }

    /* loaded from: classes2.dex */
    private static class InitRunnable implements Runnable {
        private static final String FONT_NAME = "NotoColorEmojiCompat.ttf";
        private final Context mContext;
        private final EmojiCompat.MetadataRepoLoaderCallback mLoaderCallback;

        InitRunnable(Context context, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            this.mContext = context;
            this.mLoaderCallback = metadataRepoLoaderCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mLoaderCallback.onLoaded(MetadataRepo.create(this.mContext.getAssets(), FONT_NAME));
            } catch (Throwable th) {
                this.mLoaderCallback.onFailed(th);
            }
        }
    }
}
