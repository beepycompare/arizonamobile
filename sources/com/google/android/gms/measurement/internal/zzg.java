package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzg extends zzf {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzib zzibVar) {
        super(zzibVar);
        this.zzu.zzF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb() {
        if (!zza()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzc() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zze()) {
            return;
        }
        this.zzu.zzG();
        this.zza = true;
    }

    public final void zzd() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzf();
        this.zzu.zzG();
        this.zza = true;
    }

    protected abstract boolean zze();

    protected void zzf() {
    }
}
