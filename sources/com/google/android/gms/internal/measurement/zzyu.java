package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzyu implements zzyd {
    private final zzyd zza;
    private final Object zzb;

    private zzyu(zzyd zzydVar, Object obj) {
        zzabr.zza(zzydVar, "log site key");
        this.zza = zzydVar;
        zzabr.zza(obj, "log site qualifier");
        this.zzb = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzyd zza(zzyd zzydVar, Object obj) {
        return new zzyu(zzydVar, obj);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzyu) {
            zzyu zzyuVar = (zzyu) obj;
            return this.zza.equals(zzyuVar.zza) && this.zzb.equals(zzyuVar.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ this.zzb.hashCode();
    }

    public final String toString() {
        String obj = this.zza.toString();
        int length = obj.length();
        String obj2 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(length + 47 + obj2.length() + 3);
        sb.append("SpecializedLogSiteKey{ delegate='");
        sb.append(obj);
        sb.append("', qualifier='");
        sb.append(obj2);
        sb.append("' }");
        return sb.toString();
    }
}
