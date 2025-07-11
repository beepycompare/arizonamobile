package com.miami.game.core.downloader;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
/* compiled from: Downloader.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/downloader/Downloader;", "", "downloadFile", "", "uri", "Landroid/net/Uri;", "destinationUri", "cancelDownloadFiles", "", "ids", "", "downloadBytesFlow", "Lkotlinx/coroutines/flow/Flow;", "downloader_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Downloader {
    void cancelDownloadFiles(List<Long> list);

    Flow<Long> downloadBytesFlow();

    long downloadFile(Uri uri, Uri uri2);
}
