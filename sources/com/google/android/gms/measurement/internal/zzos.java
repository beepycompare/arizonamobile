package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzos extends zzol {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzos(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzg.zzae();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzav() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaw() {
        if (!zzav()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzax() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzbb();
        this.zzg.zzaf();
        this.zza = true;
    }

    protected abstract boolean zzbb();
}
