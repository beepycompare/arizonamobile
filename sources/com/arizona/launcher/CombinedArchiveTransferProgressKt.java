package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: CombinedArchiveTransferProgress.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"saturatedAdd", "", "first", "second", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedArchiveTransferProgressKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long saturatedAdd(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        long coerceAtLeast2 = RangesKt.coerceAtLeast(j2, 0L);
        if (Long.MAX_VALUE - coerceAtLeast < coerceAtLeast2) {
            return Long.MAX_VALUE;
        }
        return coerceAtLeast + coerceAtLeast2;
    }
}
