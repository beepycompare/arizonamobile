package com.miami.game.core.downloader;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: AndroidDownloader.kt */
@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u001e¨\u0006\u001d"}, d2 = {"Lcom/miami/game/core/downloader/AndroidDownloader;", "Lcom/miami/game/core/downloader/Downloader;", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Ljavax/inject/Inject;", "downloadManager", "Landroid/app/DownloadManager;", "kotlin.jvm.PlatformType", "getDownloadManager", "()Landroid/app/DownloadManager;", "downloadManager$delegate", "Lkotlin/Lazy;", "downloadBytesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getDownloadBytesFlow", "()Lkotlinx/coroutines/flow/Flow;", DownloaderService.EXTRA_FILE_NAME, "downloadFile", "uri", "Landroid/net/Uri;", "destinationUri", "getDownloadProgress", "cancelDownloadFiles", "", "ids", "", "downloader", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidDownloader implements Downloader {
    private final Context applicationContext;
    private final Flow<Long> downloadBytesFlow;
    private long downloadId;
    private final Lazy downloadManager$delegate;

    @Inject
    public AndroidDownloader(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.downloadManager$delegate = LazyKt.lazy(new Function0() { // from class: com.miami.game.core.downloader.AndroidDownloader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AndroidDownloader.downloadManager_delegate$lambda$0(AndroidDownloader.this);
            }
        });
        this.downloadBytesFlow = FlowKt.flow(new AndroidDownloader$downloadBytesFlow$1(this, null));
        this.downloadId = -1L;
    }

    private final DownloadManager getDownloadManager() {
        return (DownloadManager) this.downloadManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DownloadManager downloadManager_delegate$lambda$0(AndroidDownloader androidDownloader) {
        return (DownloadManager) androidDownloader.applicationContext.getSystemService(DownloadManager.class);
    }

    public final Flow<Long> getDownloadBytesFlow() {
        return this.downloadBytesFlow;
    }

    @Override // com.miami.game.core.downloader.Downloader
    public Flow<Long> downloadBytesFlow() {
        return this.downloadBytesFlow;
    }

    @Override // com.miami.game.core.downloader.Downloader
    public long downloadFile(Uri uri, Uri destinationUri) throws Exception {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(destinationUri, "destinationUri");
        long enqueue = getDownloadManager().enqueue(new DownloadManager.Request(uri).setAllowedNetworkTypes(3).setNotificationVisibility(2).setDestinationUri(destinationUri));
        this.downloadId = enqueue;
        return enqueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getDownloadProgress(long j) {
        Cursor query = getDownloadManager().query(new DownloadManager.Query().setFilterById(j));
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    long j2 = cursor2.getInt(cursor2.getColumnIndexOrThrow("bytes_so_far"));
                    CloseableKt.closeFinally(cursor, null);
                    return j2;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return -1L;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return -1L;
    }

    @Override // com.miami.game.core.downloader.Downloader
    public void cancelDownloadFiles(List<Long> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        DownloadManager downloadManager = getDownloadManager();
        long[] longArray = CollectionsKt.toLongArray(ids);
        downloadManager.remove(Arrays.copyOf(longArray, longArray.length));
    }
}
