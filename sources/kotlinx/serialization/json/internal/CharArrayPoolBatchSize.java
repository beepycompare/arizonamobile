package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArrayPools.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lkotlinx/serialization/json/internal/CharArrayPoolBatchSize;", "Lkotlinx/serialization/json/internal/CharArrayPoolBase;", "<init>", "()V", "take", "", "release", "", "array", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CharArrayPoolBatchSize extends CharArrayPoolBase {
    public static final CharArrayPoolBatchSize INSTANCE = new CharArrayPoolBatchSize();

    private CharArrayPoolBatchSize() {
    }

    public final char[] take() {
        return super.take(16384);
    }

    public final void release(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length != 16384) {
            throw new IllegalArgumentException(("Inconsistent internal invariant: unexpected array size " + array.length).toString());
        }
        releaseImpl(array);
    }
}
