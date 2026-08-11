package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
/* compiled from: ArrayPools.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"MAX_CHARS_IN_POOL", "", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object m9915constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            m9915constructorimpl = Result.m9915constructorimpl(property != null ? StringsKt.toIntOrNull(property) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        Integer num = Result.m9921isFailureimpl(m9915constructorimpl) ? null : m9915constructorimpl;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
