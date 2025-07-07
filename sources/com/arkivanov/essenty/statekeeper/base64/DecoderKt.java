package com.arkivanov.essenty.statekeeper.base64;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: Decoder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"base64ToByteArray", "", "", "decode", "encoded", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DecoderKt {
    public static final byte[] base64ToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return decode(str);
    }

    public static final byte[] decode(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        int i = 0;
        if (StringsKt.isBlank(encoded)) {
            return new byte[0];
        }
        int length = encoded.length();
        byte[] bArr = new byte[length];
        int[] backDictionary = DictionariesKt.getBackDictionary();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < encoded.length()) {
            int i6 = i2 + 1;
            char charAt = encoded.charAt(i2);
            if (Intrinsics.compare((int) charAt, 32) > 0) {
                if (charAt == '=') {
                    break;
                }
                int i7 = (charAt < 0 || charAt >= backDictionary.length) ? -1 : backDictionary[charAt];
                if (i7 == -1) {
                    throw new IllegalStateException(("Unexpected character " + charAt + " (" + ((int) charAt) + ")) in " + encoded).toString());
                }
                i4 = (i4 << 6) | i7;
                i5++;
                if (i5 == 4) {
                    bArr[i3] = (byte) (i4 >> 16);
                    bArr[i3 + 1] = (byte) ((i4 >> 8) & 255);
                    bArr[i3 + 2] = (byte) (i4 & 255);
                    i3 += 3;
                    i4 = 0;
                    i5 = 0;
                }
            }
            i2 = i6;
        }
        int i8 = 0;
        while (i2 < encoded.length()) {
            int i9 = i2 + 1;
            char charAt2 = encoded.charAt(i2);
            if (Intrinsics.compare((int) charAt2, 32) > 0) {
                if (charAt2 != '=') {
                    throw new IllegalStateException("Check failed.");
                }
                i8++;
                i4 <<= 6;
                i5++;
            }
            i2 = i9;
        }
        if (i5 == 4) {
            bArr[i3] = (byte) (i4 >> 16);
            bArr[i3 + 1] = (byte) ((i4 >> 8) & 255);
            bArr[i3 + 2] = (byte) (i4 & 255);
            i3 = (i3 + 3) - i8;
        } else {
            i = i5;
        }
        if (i == 0) {
            if (i3 < length) {
                byte[] copyOf = Arrays.copyOf(bArr, i3);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            return bArr;
        }
        throw new IllegalStateException(("buffered: " + i).toString());
    }
}
