package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzor extends zzok {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzor(zzpf zzpfVar) {
        super(zzpfVar);
        this.zzg.zzad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzax() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzay() {
        if (!zzax()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaz() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzbb();
        this.zzg.zzae();
        this.zza = true;
    }

    protected abstract boolean zzbb();
}
