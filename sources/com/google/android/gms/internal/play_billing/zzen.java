package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;
import java.util.Objects;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzen extends zzeo {
    final /* synthetic */ zzev zza;
    private int zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzen(zzev zzevVar) {
        Objects.requireNonNull(zzevVar);
        this.zza = zzevVar;
        this.zzb = 0;
        this.zzc = zzevVar.zze();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeq
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
