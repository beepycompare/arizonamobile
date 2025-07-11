package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArrayPools.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"MAX_CHARS_IN_POOL", "", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object m8471constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
            m8471constructorimpl = Result.m8471constructorimpl(StringsKt.toIntOrNull(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m8471constructorimpl = Result.m8471constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m8477isFailureimpl(m8471constructorimpl)) {
            m8471constructorimpl = null;
        }
        Integer num = (Integer) m8471constructorimpl;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
