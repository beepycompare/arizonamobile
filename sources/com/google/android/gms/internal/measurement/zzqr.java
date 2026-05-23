package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzqr {
    private final boolean zza;
    private final int zzb;
    private final int zzc;

    zzqr() {
        this.zzb = 2;
        this.zzc = 2;
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqr(int i) {
        this.zzb = 2;
        this.zzc = i;
        this.zza = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqr(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zza = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzmd zza() {
        if (this.zza) {
            return zzmd.zzb();
        }
        int i = this.zzb;
        zzmc zza = zzmd.zza();
        zza.zza(i);
        zza.zzb(this.zzc);
        return (zzmd) zza.zzbd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzc() {
        return this.zzb;
    }
}
