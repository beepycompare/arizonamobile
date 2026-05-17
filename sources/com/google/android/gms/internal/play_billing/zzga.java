package com.google.android.gms.internal.play_billing;

import com.android.internal.http.multipart.FilePart;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzga {
    static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzb;

    static {
        Charset.forName(FilePart.DEFAULT_CHARSET);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i = zzey.zza;
        try {
            new zzew(bArr, 0, 0, false, null).zza(0);
        } catch (zzgc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
