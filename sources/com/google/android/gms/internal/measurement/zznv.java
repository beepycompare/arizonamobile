package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zznv extends zzqo {
    private final zznd zza;
    private final zzqr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznv(zznd zzndVar, zzqr zzqrVar) {
        this.zza = zzndVar;
        this.zzb = zzqrVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzqo) {
            zzqo zzqoVar = (zzqo) obj;
            zznd zzndVar = this.zza;
            if (zzndVar != null ? zzndVar.equals(zzqoVar.zza()) : zzqoVar.zza() == null) {
                if (this.zzb.equals(zzqoVar.zzb())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        zzqr zzqrVar = this.zzb;
        String valueOf = String.valueOf(this.zza);
        String obj = zzqrVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 52 + obj.length() + 1);
        sb.append("SnapshotBlobAndResult{snapshotBlob=");
        sb.append(valueOf);
        sb.append(", snapshotResult=");
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzqo
    public final zznd zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzqo
    public final zzqr zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        zznd zzndVar = this.zza;
        return this.zzb.hashCode() ^ (((zzndVar == null ? 0 : zzndVar.hashCode()) ^ 1000003) * 1000003);
    }
}
