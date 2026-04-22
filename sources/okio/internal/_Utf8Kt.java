package okio.internal;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;
/* compiled from: -Utf8.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"commonToUtf8String", "", "", "beginIndex", "", "endIndex", "commonAsUtf8ToByteArray", "okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
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

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        if ((r16[r5] & 192) == 128) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0103, code lost:
        if ((r16[r5] & 192) == 128) goto L67;
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
        int i8 = i;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i8 < 0 || i2 > bArr.length || i8 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i8 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i8];
        int i9 = 0;
        while (i8 < i2) {
            byte b = bArr[i8];
            if (b >= 0) {
                int i10 = i9 + 1;
                cArr[i9] = (char) b;
                i8++;
                while (i8 < i2) {
                    byte b2 = bArr[i8];
                    if (b2 < 0) {
                        break;
                    }
                    i8++;
                    cArr[i10] = (char) b2;
                    i10++;
                }
                Unit unit = Unit.INSTANCE;
                i9 = i10;
            } else {
                if ((b >> 5) == -2) {
                    int i11 = i8 + 1;
                    if (i2 <= i11) {
                        i3 = i9 + 1;
                        cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                    } else {
                        byte b3 = bArr[i11];
                        if ((b3 & 192) == 128) {
                            int i12 = (b << 6) ^ (b3 ^ 3968);
                            if (i12 < 128) {
                                i3 = i9 + 1;
                                cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                int i13 = i9 + 1;
                                cArr[i9] = (char) i12;
                                Unit unit3 = Unit.INSTANCE;
                                i3 = i13;
                            }
                            i7 = 2;
                            i8 += i7;
                            Unit unit4 = Unit.INSTANCE;
                        } else {
                            i3 = i9 + 1;
                            cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                        }
                    }
                    Unit unit5 = Unit.INSTANCE;
                    i7 = 1;
                    i8 += i7;
                    Unit unit42 = Unit.INSTANCE;
                } else if ((b >> 4) == -2) {
                    int i14 = i8 + 2;
                    if (i2 <= i14) {
                        i3 = i9 + 1;
                        cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit6 = Unit.INSTANCE;
                        int i15 = i8 + 1;
                        if (i2 > i15) {
                        }
                        i6 = 1;
                    } else {
                        byte b4 = bArr[i8 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i14];
                            if ((b5 & 192) == 128) {
                                int i16 = (b << Ascii.FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                if (i16 < 2048) {
                                    i3 = i9 + 1;
                                    cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                } else if (55296 > i16 || i16 >= 57344) {
                                    int i17 = i9 + 1;
                                    cArr[i9] = (char) i16;
                                    Unit unit7 = Unit.INSTANCE;
                                    i3 = i17;
                                    i6 = 3;
                                } else {
                                    i3 = i9 + 1;
                                    cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                }
                                Unit unit8 = Unit.INSTANCE;
                                i6 = 3;
                            } else {
                                i3 = i9 + 1;
                                cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit9 = Unit.INSTANCE;
                                i6 = 2;
                            }
                        } else {
                            i3 = i9 + 1;
                            cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit10 = Unit.INSTANCE;
                            i6 = 1;
                        }
                    }
                    i8 += i6;
                    Unit unit11 = Unit.INSTANCE;
                } else if ((b >> 3) == -2) {
                    int i18 = i8 + 3;
                    if (i2 <= i18) {
                        i3 = i9 + 1;
                        cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit12 = Unit.INSTANCE;
                        int i19 = i8 + 1;
                        if (i2 > i19 && (bArr[i19] & 192) == 128) {
                            int i20 = i8 + 2;
                            if (i2 > i20) {
                            }
                            i5 = 2;
                        }
                        i5 = 1;
                    } else {
                        byte b6 = bArr[i8 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i8 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i18];
                                if ((b8 & 192) == 128) {
                                    int i21 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF));
                                    if (i21 > 1114111) {
                                        i3 = i9 + 1;
                                        cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (55296 <= i21 && i21 < 57344) {
                                        i3 = i9 + 1;
                                        cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (i21 < 65536) {
                                        i3 = i9 + 1;
                                        cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                    } else {
                                        if (i21 != 65533) {
                                            cArr[i9] = (char) ((i21 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            i4 = i9 + 2;
                                            cArr[i9 + 1] = (char) ((i21 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                        } else {
                                            cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                            i4 = i9 + 1;
                                        }
                                        Unit unit13 = Unit.INSTANCE;
                                        i3 = i4;
                                        i5 = 4;
                                    }
                                    Unit unit14 = Unit.INSTANCE;
                                    i5 = 4;
                                } else {
                                    i3 = i9 + 1;
                                    cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit15 = Unit.INSTANCE;
                                    i5 = 3;
                                }
                            } else {
                                i3 = i9 + 1;
                                cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit16 = Unit.INSTANCE;
                                i5 = 2;
                            }
                        } else {
                            i3 = i9 + 1;
                            cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit17 = Unit.INSTANCE;
                            i5 = 1;
                        }
                    }
                    i8 += i5;
                    Unit unit18 = Unit.INSTANCE;
                } else {
                    i3 = i9 + 1;
                    cArr[i9] = Utf8.REPLACEMENT_CHARACTER;
                    Integer.valueOf(i8);
                    i8++;
                }
                i9 = i3;
            }
        }
        return StringsKt.concatToString(cArr, 0, i9);
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
