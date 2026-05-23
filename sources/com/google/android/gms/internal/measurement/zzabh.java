package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzabh {
    private final int zza;
    private final zzza zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzabh(zzza zzzaVar, int i) {
        if (zzzaVar == null) {
            throw new IllegalArgumentException("format options cannot be null");
        }
        if (i >= 0) {
            this.zza = i;
            this.zzb = zzzaVar;
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 15);
        sb.append("invalid index: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    protected abstract void zzb(zzabi zzabiVar, Object obj);

    public final int zzc() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzza zzd() {
        return this.zzb;
    }

    public final void zze(zzabi zzabiVar, Object[] objArr) {
        int i = this.zza;
        if (i >= objArr.length) {
            zzabiVar.zze();
            return;
        }
        Object obj = objArr[i];
        if (obj != null) {
            zzb(zzabiVar, obj);
        } else {
            zzabiVar.zzf();
        }
    }
}
