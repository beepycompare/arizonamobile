package io.appmetrica.analytics.coreutils.internal.buffering;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¨\u0006\u0007"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/buffering/BatchProcessor;", ExifInterface.GPS_DIRECTION_TRUE, "", "processBatch", "", "tasks", "", "core-utils_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BatchProcessor<T> {
    void processBatch(List<? extends T> list);
}
