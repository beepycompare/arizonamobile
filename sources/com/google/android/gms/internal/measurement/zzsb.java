package com.google.android.gms.internal.measurement;

import android.net.Uri;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.io.File;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzsb {
    private final Uri.Builder zza = new Uri.Builder().scheme(UtilsKt.SCHEME_FILE).authority("").path("/");
    private final ImmutableList.Builder zzb = ImmutableList.builder();

    private zzsb() {
    }

    public final zzsb zza(File file) {
        this.zza.path(file.getAbsolutePath());
        return this;
    }

    public final Uri zzb() {
        return this.zza.encodedFragment(zzsp.zzb(this.zzb.build())).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzsb(byte[] bArr) {
    }
}
