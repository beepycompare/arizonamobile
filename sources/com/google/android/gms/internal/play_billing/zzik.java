package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
class zzik {
    /* JADX INFO: Access modifiers changed from: protected */
    public static final int zza(String str, byte[] bArr, int i, int i2) {
        byte[] bytes = str.getBytes(zzga.zza);
        int length = bytes.length;
        if (length - i > i2) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }
        System.arraycopy(bytes, 0, bArr, i, length);
        return i + length;
    }
}
