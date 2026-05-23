package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public interface zzsx {
    String zzc();

    default InputStream zzd(Uri uri) throws IOException {
        String zzc = zzc();
        String.valueOf(zzc);
        throw new zzsk("openForRead not supported by ".concat(String.valueOf(zzc)));
    }

    default boolean zze(Uri uri) throws IOException {
        String zzc = zzc();
        String.valueOf(zzc);
        throw new zzsk("exists not supported by ".concat(String.valueOf(zzc)));
    }

    default File zzg(Uri uri) throws IOException {
        String zzc = zzc();
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Cannot convert uri to file ");
        sb.append(zzc);
        sb.append(" ");
        sb.append(valueOf);
        throw new zzsk(sb.toString());
    }

    default OutputStream zzj(Uri uri) throws IOException {
        String zzc = zzc();
        String.valueOf(zzc);
        throw new zzsk("openForWrite not supported by ".concat(String.valueOf(zzc)));
    }

    default void zzk(Uri uri) throws IOException {
        String zzc = zzc();
        String.valueOf(zzc);
        throw new zzsk("deleteFile not supported by ".concat(String.valueOf(zzc)));
    }

    default void zzl(Uri uri, Uri uri2) throws IOException {
        String zzc = zzc();
        String.valueOf(zzc);
        throw new zzsk("rename not supported by ".concat(String.valueOf(zzc)));
    }
}
