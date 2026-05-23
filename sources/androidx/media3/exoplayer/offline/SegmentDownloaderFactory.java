package androidx.media3.exoplayer.offline;

import androidx.media3.common.MediaItem;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
interface SegmentDownloaderFactory {
    SegmentDownloader<?> create(MediaItem mediaItem);

    SegmentDownloaderFactory setDurationUs(long j);

    SegmentDownloaderFactory setExecutor(Executor executor);

    SegmentDownloaderFactory setMaxMergedSegmentStartTimeDiffMs(long j);

    SegmentDownloaderFactory setStartPositionUs(long j);
}
