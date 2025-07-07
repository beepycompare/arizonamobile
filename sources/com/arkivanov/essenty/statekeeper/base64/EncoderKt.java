package com.arkivanov.essenty.statekeeper.base64;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Encoder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"toBase64", "", "", "encode", "array", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EncoderKt {
    public static final String toBase64(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return encode(bArr);
    }

    public static final String encode(byte[] array) {
        int i;
        Intrinsics.checkNotNullParameter(array, "array");
        StringBuilder sb = new StringBuilder(((array.length / 3) * 4) + 1);
        int i2 = 0;
        int i3 = 0;
        while (i3 < array.length && (i = i3 + 3) <= array.length) {
            int i4 = (array[i3 + 2] & 255) | ((array[i3] & 255) << 16) | ((array[i3 + 1] & 255) << 8);
            sb.append(DictionariesKt.getDictionary()[i4 >> 18]);
            sb.append(DictionariesKt.getDictionary()[(i4 >> 12) & 63]);
            sb.append(DictionariesKt.getDictionary()[(i4 >> 6) & 63]);
            sb.append(DictionariesKt.getDictionary()[i4 & 63]);
            i3 = i;
        }
        if (i3 < array.length) {
            while (i3 < array.length) {
                i2 = (i2 << 8) | (array[i3] & 255);
                i3++;
            }
            int i5 = 3 - (i3 % 3);
            int i6 = i2 << (i5 * 8);
            sb.append(DictionariesKt.getDictionary()[i6 >> 18]);
            sb.append(DictionariesKt.getDictionary()[(i6 >> 12) & 63]);
            char c = DictionariesKt.getDictionary()[(i6 >> 6) & 63];
            char c2 = DictionariesKt.getDictionary()[i6 & 63];
            if (i5 == 0) {
                sb.append(c);
                sb.append(c2);
            } else if (i5 == 1) {
                sb.append(c);
                sb.append('=');
            } else if (i5 == 2) {
                sb.append("==");
            }
        }
        return sb.toString();
    }
}
