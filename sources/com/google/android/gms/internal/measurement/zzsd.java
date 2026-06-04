package com.google.android.gms.internal.measurement;

import android.net.Uri;
import coil3.util.UtilsKt;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzsd implements zzsx {
    public zzsd() {
        new zzsh();
    }

    public zzsd(zzsh zzshVar) {
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final String zzc() {
        return UtilsKt.SCHEME_FILE;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final InputStream zzd(Uri uri) throws IOException {
        return zzsl.zzb(zzsc.zza(uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final boolean zze(Uri uri) throws IOException {
        return zzsc.zza(uri).exists();
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final File zzg(Uri uri) throws IOException {
        return zzsc.zza(uri);
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final OutputStream zzj(Uri uri) throws IOException {
        File zza = zzsc.zza(uri);
        Files.createParentDirs(zza);
        return new zzsm(new FileOutputStream(zza), zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzk(Uri uri) throws IOException {
        File zza = zzsc.zza(uri);
        if (zza.isDirectory()) {
            throw new FileNotFoundException(String.format("%s is a directory", uri));
        }
        if (zza.delete()) {
            return;
        }
        if (!zza.exists()) {
            throw new FileNotFoundException(String.format("%s does not exist", uri));
        }
        throw new IOException(String.format("%s could not be deleted", uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzl(Uri uri, Uri uri2) throws IOException {
        File zza = zzsc.zza(uri);
        File zza2 = zzsc.zza(uri2);
        Files.createParentDirs(zza2);
        if (!zza.renameTo(zza2)) {
            throw new IOException(String.format("%s could not be renamed to %s", uri, uri2));
        }
    }
}
