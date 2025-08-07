package com.google.android.gms.internal.measurement;

import com.android.internal.http.multipart.FilePart;
import com.android.internal.http.multipart.StringPart;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzmp {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName(StringPart.DEFAULT_CHARSET);
        zza = Charset.forName("UTF-8");
        Charset.forName(FilePart.DEFAULT_CHARSET);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i = zzlj.zza;
        try {
            new zzli(bArr, 0, 0, false, null).zza(0);
        } catch (zzmr e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int zzb(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd(zznm zznmVar) {
        if (zznmVar instanceof zzkt) {
            zzkt zzktVar = (zzkt) zznmVar;
            throw null;
        }
        return false;
    }
}
