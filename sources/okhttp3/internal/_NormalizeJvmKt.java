package okhttp3.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.text.Normalizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: -NormalizeJvm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"normalizeNfc", "", TypedValues.Custom.S_STRING, "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class _NormalizeJvmKt {
    public static final String normalizeNfc(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        String normalize = Normalizer.normalize(string, Normalizer.Form.NFC);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(...)");
        return normalize;
    }
}
