package okhttp3.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
/* compiled from: IsProbablyUtf8.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"isProbablyUtf8", "", "Lokio/BufferedSource;", "codePointLimit", "", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class IsProbablyUtf8Kt {
    public static /* synthetic */ boolean isProbablyUtf8$default(BufferedSource bufferedSource, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return isProbablyUtf8(bufferedSource, j);
    }

    public static final boolean isProbablyUtf8(BufferedSource bufferedSource, long j) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        try {
            BufferedSource peek = bufferedSource.peek();
            for (long j2 = 0; j2 < j; j2++) {
                if (peek.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = peek.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
