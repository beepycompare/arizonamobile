package kotlin.time;

import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Duration.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bH\u0086\u0088\u0004ø\u0001\u0000JA\u0010\u0010\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bH\u0082\u0088\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lkotlin/time/FractionalParser;", "", "<init>", "()V", "parse", "", "value", "", "startIndex", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "endIndex", "", "parseDigits", "maxDigits", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FractionalParser {
    public static final FractionalParser INSTANCE = new FractionalParser();

    private FractionalParser() {
    }

    private final int parseDigits(String str, int i, int i2, Function1<? super Integer, Unit> function1) {
        int min = Math.min(i + i2, str.length());
        int i3 = i;
        int i4 = 0;
        while (i3 < min) {
            char charAt = str.charAt(i3);
            if ('0' > charAt || charAt >= ':') {
                break;
            }
            i4 = (i4 << 3) + (i4 << 1) + (charAt - '0');
            i3++;
        }
        for (int i5 = 0; i5 < i2 - (i3 - i); i5++) {
            i4 = (i4 << 3) + (i4 << 1);
        }
        function1.invoke(Integer.valueOf(i3));
        return i4;
    }

    public final long parse(String value, int i, Function1<? super Integer, Unit> callback) {
        char charAt;
        char charAt2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int min = Math.min(i + 6, value.length());
        int i2 = i;
        int i3 = 0;
        while (i2 < min && '0' <= (charAt2 = value.charAt(i2)) && charAt2 < ':') {
            i3 = (i3 << 3) + (i3 << 1) + (charAt2 - '0');
            i2++;
        }
        int i4 = 6 - (i2 - i);
        for (int i5 = 0; i5 < i4; i5++) {
            i3 = (i3 << 1) + (i3 << 3);
        }
        int min2 = Math.min(i2 + 9, value.length());
        int i6 = 0;
        int i7 = i2;
        while (i7 < min2) {
            char charAt3 = value.charAt(i7);
            if ('0' > charAt3 || charAt3 >= ':') {
                break;
            }
            i6 = (i6 << 3) + (i6 << 1) + (charAt3 - '0');
            i7++;
        }
        for (int i8 = 0; i8 < 9 - (i7 - i2); i8++) {
            i6 = (i6 << 1) + (i6 << 3);
        }
        while (i7 < value.length() && '0' <= (charAt = value.charAt(i7)) && charAt < ':') {
            i7++;
        }
        callback.invoke(Integer.valueOf(i7));
        return (i3 * C.NANOS_PER_SECOND) + i6;
    }
}
