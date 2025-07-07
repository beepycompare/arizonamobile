package androidx.media3.common.util;

import androidx.media3.common.C;
/* loaded from: classes2.dex */
public interface TimestampIterator {
    TimestampIterator copyOf();

    default long getLastTimestampUs() {
        return C.TIME_UNSET;
    }

    boolean hasNext();

    long next();
}
