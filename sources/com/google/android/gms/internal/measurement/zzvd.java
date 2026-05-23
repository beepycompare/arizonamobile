package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzvd extends zzve {
    private final zzafc zza;
    private final zzadf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvd(zzafc zzafcVar, zzadf zzadfVar) {
        this.zza = zzafcVar;
        if (zzadfVar == null) {
            throw new NullPointerException("Null extensionRegistryLite");
        }
        this.zzb = zzadfVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzve) {
            zzve zzveVar = (zzve) obj;
            if (this.zza.equals(zzveVar.zzb()) && this.zzb.equals(zzveVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ ((this.zza.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        String obj = this.zza.toString();
        int length = obj.length();
        String obj2 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(length + 53 + obj2.length() + 1);
        sb.append("ProtoSerializer{defaultValue=");
        sb.append(obj);
        sb.append(", extensionRegistryLite=");
        sb.append(obj2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzve, com.google.android.gms.internal.measurement.zztv
    public final /* synthetic */ Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzafc zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzadf zzc() {
        return this.zzb;
    }
}
