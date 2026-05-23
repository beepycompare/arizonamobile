package com.google.android.gms.internal.measurement;

import java.nio.charset.StandardCharsets;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
class zzagi {
    /* JADX INFO: Access modifiers changed from: protected */
    public static final int zza(String str, byte[] bArr, int i, int i2) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        if (length - i > i2) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }
        System.arraycopy(bytes, 0, bArr, i, length);
        return i + length;
    }
}
