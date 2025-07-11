package okhttp3.internal.idn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
import okio.ByteString;
/* compiled from: Punycode.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J(\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0017H\u0002J\u001c\u0010\"\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0$*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\u00020\r*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lokhttp3/internal/idn/Punycode;", "", "<init>", "()V", "PREFIX_STRING", "", "getPREFIX_STRING", "()Ljava/lang/String;", "PREFIX", "Lokio/ByteString;", "getPREFIX", "()Lokio/ByteString;", "BASE", "", "TMIN", "TMAX", "SKEW", "DAMP", "INITIAL_BIAS", "INITIAL_N", "encode", TypedValues.Custom.S_STRING, "encodeLabel", "", "pos", "limit", "result", "Lokio/Buffer;", "decode", "decodeLabel", "adapt", "delta", "numpoints", "first", "requiresEncode", "codePoints", "", "punycodeDigit", "getPunycodeDigit", "(I)I", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Punycode {
    private static final int BASE = 36;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final int SKEW = 38;
    private static final int TMAX = 26;
    private static final int TMIN = 1;
    public static final Punycode INSTANCE = new Punycode();
    private static final String PREFIX_STRING = "xn--";
    private static final ByteString PREFIX = ByteString.Companion.encodeUtf8("xn--");

    private Punycode() {
    }

    public final String getPREFIX_STRING() {
        return PREFIX_STRING;
    }

    public final ByteString getPREFIX() {
        return PREFIX;
    }

    public final String encode(String string) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(string, "string");
        int length = string.length();
        Buffer buffer = new Buffer();
        for (int i = 0; i < length; i = indexOf$default + 1) {
            indexOf$default = StringsKt.indexOf$default((CharSequence) string, '.', i, false, 4, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = length;
            }
            if (!encodeLabel(string, i, indexOf$default, buffer)) {
                return null;
            }
            if (indexOf$default >= length) {
                break;
            }
            buffer.writeByte(46);
        }
        return buffer.readUtf8();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean encodeLabel(String str, int i, int i2, Buffer buffer) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        if (!requiresEncode(str, i, i2)) {
            buffer.writeUtf8(str, i, i2);
            return true;
        }
        buffer.write(PREFIX);
        List<Integer> codePoints = codePoints(str, i, i2);
        Iterator<Integer> it = codePoints.iterator();
        int i8 = 0;
        while (true) {
            i3 = 128;
            if (!it.hasNext()) {
                break;
            }
            int intValue = it.next().intValue();
            if (intValue < 128) {
                buffer.writeByte(intValue);
                i8++;
            }
        }
        if (i8 > 0) {
            buffer.writeByte(45);
        }
        int i9 = INITIAL_BIAS;
        int i10 = 0;
        int i11 = i8;
        while (i11 < codePoints.size()) {
            Iterator<T> it2 = codePoints.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (!it2.hasNext()) {
                int intValue2 = ((Number) next).intValue();
                i4 = (intValue2 - i3) * (i11 + 1);
                if (i10 <= Integer.MAX_VALUE - i4) {
                }
            } else {
                int intValue3 = ((Number) next).intValue();
                if (intValue3 < i3) {
                    intValue3 = Integer.MAX_VALUE;
                }
                do {
                    Object next2 = it2.next();
                    int intValue4 = ((Number) next2).intValue();
                    if (intValue4 < i3) {
                        intValue4 = Integer.MAX_VALUE;
                    }
                    if (intValue3 > intValue4) {
                        next = next2;
                        intValue3 = intValue4;
                    }
                } while (it2.hasNext());
                int intValue22 = ((Number) next).intValue();
                i4 = (intValue22 - i3) * (i11 + 1);
                if (i10 <= Integer.MAX_VALUE - i4) {
                    return false;
                }
                int i12 = i10 + i4;
                for (Integer num : codePoints) {
                    int intValue5 = num.intValue();
                    if (intValue5 < intValue22) {
                        if (i12 == Integer.MAX_VALUE) {
                            return false;
                        }
                        i12++;
                    } else if (intValue5 == intValue22) {
                        IntProgression step = RangesKt.step(RangesKt.until(36, Integer.MAX_VALUE), 36);
                        int first = step.getFirst();
                        int last = step.getLast();
                        int step2 = step.getStep();
                        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                            i6 = i12;
                            while (true) {
                                if (first <= i9) {
                                    i5 = i7;
                                } else {
                                    i5 = i7;
                                    i7 = first >= i9 + 26 ? 26 : first - i9;
                                }
                                if (i6 < i7) {
                                    break;
                                }
                                int i13 = i6 - i7;
                                int i14 = 36 - i7;
                                buffer.writeByte(getPunycodeDigit(i7 + (i13 % i14)));
                                i6 = i13 / i14;
                                if (first == last) {
                                    break;
                                }
                                first += step2;
                                i7 = i5;
                            }
                        } else {
                            i5 = i7;
                            i6 = i12;
                        }
                        buffer.writeByte(getPunycodeDigit(i6));
                        int i15 = i11 + 1;
                        i9 = adapt(i12, i15, i11 == i8 ? i5 : false);
                        i11 = i15;
                        i12 = 0;
                        i7 = i5;
                    }
                }
                i10 = i12 + 1;
                i3 = intValue22 + 1;
            }
        }
        return i7;
    }

    public final String decode(String string) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(string, "string");
        int length = string.length();
        Buffer buffer = new Buffer();
        for (int i = 0; i < length; i = indexOf$default + 1) {
            indexOf$default = StringsKt.indexOf$default((CharSequence) string, '.', i, false, 4, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = length;
            }
            if (!decodeLabel(string, i, indexOf$default, buffer)) {
                return null;
            }
            if (indexOf$default >= length) {
                break;
            }
            buffer.writeByte(46);
        }
        return buffer.readUtf8();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean decodeLabel(String str, int i, int i2, Buffer buffer) {
        int i3;
        int i4;
        int i5 = 1;
        if (!StringsKt.regionMatches(str, i, PREFIX_STRING, 0, 4, true)) {
            buffer.writeUtf8(str, i, i2);
            return true;
        }
        int i6 = i + 4;
        ArrayList<Number> arrayList = new ArrayList();
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '-', i2, false, 4, (Object) null);
        char c = '0';
        char c2 = AbstractJsonLexerKt.BEGIN_LIST;
        char c3 = AbstractJsonLexerKt.BEGIN_OBJ;
        boolean z = false;
        if (lastIndexOf$default >= i6) {
            while (i6 < lastIndexOf$default) {
                int i7 = i6 + 1;
                char charAt = str.charAt(i6);
                if (('a' > charAt || charAt >= '{') && (('A' > charAt || charAt >= '[') && (('0' > charAt || charAt >= ':') && charAt != '-'))) {
                    return false;
                }
                arrayList.add(Integer.valueOf(charAt));
                i6 = i7;
            }
            i6++;
        }
        int i8 = 128;
        int i9 = INITIAL_BIAS;
        int i10 = 0;
        while (i6 < i2) {
            int i11 = i5;
            boolean z2 = z;
            IntProgression step = RangesKt.step(RangesKt.until(36, Integer.MAX_VALUE), 36);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                i3 = i10;
                int i12 = i11;
                while (i6 != i2) {
                    int i13 = i6 + 1;
                    char charAt2 = str.charAt(i6);
                    if ('a' <= charAt2 && charAt2 < c3) {
                        i4 = charAt2 - 'a';
                    } else if ('A' <= charAt2 && charAt2 < c2) {
                        i4 = charAt2 - 'A';
                    } else if (c > charAt2 || charAt2 >= ':') {
                        return z2;
                    } else {
                        i4 = charAt2 - 22;
                    }
                    int i14 = i12;
                    int i15 = i4 * i14;
                    int i16 = i3;
                    if (i16 > Integer.MAX_VALUE - i15) {
                        return z2;
                    }
                    i3 = i16 + i15;
                    int i17 = first <= i9 ? i11 : first >= i9 + 26 ? 26 : first - i9;
                    if (i4 >= i17) {
                        int i18 = 36 - i17;
                        if (i14 > Integer.MAX_VALUE / i18) {
                            return z2;
                        }
                        i12 = i14 * i18;
                        if (first != last) {
                            first += step2;
                            i6 = i13;
                            c = '0';
                            c2 = AbstractJsonLexerKt.BEGIN_LIST;
                            c3 = AbstractJsonLexerKt.BEGIN_OBJ;
                        }
                    }
                    i6 = i13;
                }
                return z2;
            }
            i3 = i10;
            i9 = adapt(i3 - i10, arrayList.size() + 1, i10 == 0 ? i11 : z2);
            int size = i3 / (arrayList.size() + 1);
            if (i8 > Integer.MAX_VALUE - size) {
                return z2;
            }
            i8 += size;
            int size2 = i3 % (arrayList.size() + 1);
            if (i8 > 1114111) {
                return z2;
            }
            arrayList.add(size2, Integer.valueOf(i8));
            i10 = size2 + 1;
            z = z2;
            i5 = i11;
            c = '0';
            c2 = AbstractJsonLexerKt.BEGIN_LIST;
            c3 = AbstractJsonLexerKt.BEGIN_OBJ;
        }
        boolean z3 = i5;
        for (Number number : arrayList) {
            buffer.writeUtf8CodePoint(number.intValue());
        }
        return z3;
    }

    private final int adapt(int i, int i2, boolean z) {
        int i3;
        if (z) {
            i3 = i / 700;
        } else {
            i3 = i / 2;
        }
        int i4 = i3 + (i3 / i2);
        int i5 = 0;
        while (i4 > 455) {
            i4 /= 35;
            i5 += 36;
        }
        return i5 + ((i4 * 36) / (i4 + 38));
    }

    private final boolean requiresEncode(String str, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) >= 128) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [char] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    private final List<Integer> codePoints(String str, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            int charAt = str.charAt(i);
            ArrayList arrayList2 = arrayList;
            if (CharsKt.isSurrogate(charAt)) {
                int i3 = i + 1;
                char charAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                if (Character.isLowSurrogate(charAt) || !Character.isLowSurrogate(charAt2)) {
                    charAt = 63;
                } else {
                    charAt = 65536 + (((charAt & AnalyticsListener.EVENT_DRM_KEYS_LOADED) << 10) | (charAt2 & 1023));
                    i = i3;
                }
            }
            arrayList2.add(Integer.valueOf(charAt));
            i++;
        }
        return arrayList;
    }

    private final int getPunycodeDigit(int i) {
        if (i < 26) {
            return i + 97;
        }
        if (i < 36) {
            return i + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i).toString());
    }
}
