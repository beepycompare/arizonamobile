package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzkz extends zzla {
    final /* synthetic */ zzlg zza;
    private int zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkz(zzlg zzlgVar) {
        Objects.requireNonNull(zzlgVar);
        this.zza = zzlgVar;
        this.zzb = 0;
        this.zzc = zzlgVar.zzc();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
