package ru.rustore.sdk.core.util;

import androidx.collection.SieveCacheKt;
import kotlin.Metadata;
/* compiled from: PrimitivesExtension.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"safeToInt", "", "", "sdk-public-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrimitivesExtensionKt {
    public static final int safeToInt(long j) {
        if (SieveCacheKt.NodeMetaAndPreviousMask > j || j > SieveCacheKt.NodeLinkMask) {
            return 0;
        }
        return (int) j;
    }
}
