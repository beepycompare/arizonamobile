package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzjf extends zzje {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjf(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzF();
    }

    protected abstract boolean zza();

    protected void zzbb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzv() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw() {
        if (!zzv()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zza()) {
            return;
        }
        this.zzu.zzG();
        this.zza = true;
    }

    public final void zzy() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzbb();
        this.zzu.zzG();
        this.zza = true;
    }
}
