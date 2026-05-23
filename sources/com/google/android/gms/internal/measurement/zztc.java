package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public interface zztc {
    String zza();

    default InputStream zzb(Uri uri, InputStream inputStream) throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
        String zza = zza();
        String.valueOf(zza);
        throw new zzsk("wrapForRead not supported by ".concat(String.valueOf(zza)));
    }

    default OutputStream zzc(Uri uri, OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
        String zza = zza();
        String.valueOf(zza);
        throw new zzsk("wrapForWrite not supported by ".concat(String.valueOf(zza)));
    }
}
