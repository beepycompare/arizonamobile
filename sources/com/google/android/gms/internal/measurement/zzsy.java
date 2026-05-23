package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzsy implements zzsx {
    protected abstract zzsx zzb();

    /* JADX INFO: Access modifiers changed from: protected */
    public Uri zzf(Uri uri) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final OutputStream zzj(Uri uri) throws IOException {
        return zzb().zzj(zzf(uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzk(Uri uri) throws IOException {
        zzb().zzk(zzf(uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzl(Uri uri, Uri uri2) throws IOException {
        zzb().zzl(zzf(uri), zzf(uri2));
    }
}
