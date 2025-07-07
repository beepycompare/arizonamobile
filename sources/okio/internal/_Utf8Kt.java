package okio.internal;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;
/* compiled from: -Utf8.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"commonToUtf8String", "", "", "beginIndex", "", "endIndex", "commonAsUtf8ToByteArray", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
        if ((r16[r5] & 192) == 128) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0105, code lost:
        if ((r16[r5] & 192) == 128) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i9 < 0 || i2 > bArr.length || i9 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i9 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i9];
        int i10 = 0;
        while (i9 < i2) {
            byte b = bArr[i9];
            if (b >= 0) {
                i3 = i10 + 1;
                cArr[i10] = (char) b;
                i9++;
                while (i9 < i2) {
                    byte b2 = bArr[i9];
                    if (b2 < 0) {
                        break;
                    }
                    i9++;
                    cArr[i3] = (char) b2;
                    i3++;
                }
                Unit unit = Unit.INSTANCE;
            } else if ((b >> 5) == -2) {
                int i11 = i9 + 1;
                if (i2 <= i11) {
                    i3 = i10 + 1;
                    cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b3 = bArr[i11];
                    if ((b3 & 192) == 128) {
                        int i12 = (b << 6) ^ (b3 ^ 3968);
                        if (i12 < 128) {
                            i3 = i10 + 1;
                            cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i3 = i10 + 1;
                            cArr[i10] = (char) i12;
                        }
                        Unit unit2 = Unit.INSTANCE;
                        i4 = 2;
                        i9 += i4;
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        i3 = i10 + 1;
                        cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                Unit unit4 = Unit.INSTANCE;
                i4 = 1;
                i9 += i4;
                Unit unit32 = Unit.INSTANCE;
            } else if ((b >> 4) == -2) {
                int i13 = i9 + 2;
                if (i2 <= i13) {
                    i3 = i10 + 1;
                    cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    Unit unit5 = Unit.INSTANCE;
                    int i14 = i9 + 1;
                    if (i2 > i14) {
                    }
                    i5 = 1;
                } else {
                    byte b4 = bArr[i9 + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = bArr[i13];
                        if ((b5 & 192) == 128) {
                            int i15 = (b << Ascii.FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                            if (i15 < 2048) {
                                i3 = i10 + 1;
                                cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else if (55296 > i15 || i15 >= 57344) {
                                i3 = i10 + 1;
                                cArr[i10] = (char) i15;
                            } else {
                                i3 = i10 + 1;
                                cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            }
                            Unit unit6 = Unit.INSTANCE;
                            i5 = 3;
                        } else {
                            i3 = i10 + 1;
                            cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit7 = Unit.INSTANCE;
                            i5 = 2;
                        }
                    } else {
                        i3 = i10 + 1;
                        cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit8 = Unit.INSTANCE;
                        i5 = 1;
                    }
                }
                i9 += i5;
                Unit unit9 = Unit.INSTANCE;
            } else {
                if ((b >> 3) == -2) {
                    int i16 = i9 + 3;
                    if (i2 <= i16) {
                        i6 = i10 + 1;
                        cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit10 = Unit.INSTANCE;
                        int i17 = i9 + 1;
                        if (i2 > i17 && (bArr[i17] & 192) == 128) {
                            int i18 = i9 + 2;
                            if (i2 > i18) {
                            }
                            i8 = 2;
                        }
                        i8 = 1;
                    } else {
                        byte b6 = bArr[i9 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i9 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i16];
                                if ((b8 & 192) == 128) {
                                    int i19 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF));
                                    if (i19 > 1114111) {
                                        i6 = i10 + 1;
                                        cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (55296 <= i19 && i19 < 57344) {
                                        i6 = i10 + 1;
                                        cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (i19 < 65536) {
                                        i6 = i10 + 1;
                                        cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                                    } else {
                                        if (i19 != 65533) {
                                            cArr[i10] = (char) ((i19 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            i7 = i10 + 2;
                                            cArr[i10 + 1] = (char) ((i19 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                                        } else {
                                            cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                                            i7 = i10 + 1;
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                        i6 = i7;
                                        i8 = 4;
                                    }
                                    Unit unit12 = Unit.INSTANCE;
                                    i8 = 4;
                                } else {
                                    i6 = i10 + 1;
                                    cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit13 = Unit.INSTANCE;
                                    i8 = 3;
                                }
                            } else {
                                i6 = i10 + 1;
                                cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit14 = Unit.INSTANCE;
                                i8 = 2;
                            }
                        } else {
                            i6 = i10 + 1;
                            cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit15 = Unit.INSTANCE;
                            i8 = 1;
                        }
                    }
                    i9 += i8;
                    Unit unit16 = Unit.INSTANCE;
                } else {
                    i6 = i10 + 1;
                    cArr[i10] = Utf8.REPLACEMENT_CHARACTER;
                    Integer.valueOf(i9);
                    i9++;
                }
                i10 = i6;
            }
            i10 = i3;
        }
        return StringsKt.concatToString(cArr, 0, i10);
    }

    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = str.charAt(i2);
            if (Intrinsics.compare((int) charAt2, 128) >= 0) {
                int length2 = str.length();
                int i3 = i2;
                while (i2 < length2) {
                    char charAt3 = str.charAt(i2);
                    if (Intrinsics.compare((int) charAt3, 128) < 0) {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) charAt3;
                        i2++;
                        while (true) {
                            i3 = i4;
                            if (i2 < length2 && Intrinsics.compare((int) str.charAt(i2), 128) < 0) {
                                i4 = i3 + 1;
                                bArr[i3] = (byte) str.charAt(i2);
                                i2++;
                            }
                        }
                    } else {
                        if (Intrinsics.compare((int) charAt3, 2048) < 0) {
                            bArr[i3] = (byte) ((charAt3 >> 6) | 192);
                            i3 += 2;
                            bArr[i3 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || charAt3 >= 57344) {
                            bArr[i3] = (byte) ((charAt3 >> '\f') | 224);
                            bArr[i3 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i3 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) charAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (charAt = str.charAt(i)) || charAt >= 57344) {
                            bArr[i3] = Utf8.REPLACEMENT_BYTE;
                            i2++;
                            i3++;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i)) - 56613888;
                            bArr[i3] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i3 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i3 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i3 += 4;
                            bArr[i3 + 3] = (byte) ((charAt4 & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i3);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            bArr[i2] = (byte) charAt2;
            i2++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        return copyOf2;
    }
}
