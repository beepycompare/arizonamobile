package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes3.dex */
public final class zznd implements zzny {
    private static final zznk zzb = new zznb();
    private final zznk zza;

    public zznd() {
        zznk zznkVar = zzb;
        int i = zznu.zza;
        zznc zzncVar = new zznc(zzma.zza(), zznkVar);
        byte[] bArr = zzmp.zzb;
        this.zza = zzncVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzny
    public final zznx zza(Class cls) {
        int i = zznz.zza;
        if (!zzmf.class.isAssignableFrom(cls)) {
            int i2 = zznu.zza;
        }
        zznj zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            int i3 = zznu.zza;
            return zznp.zzl(cls, zzc, zzns.zza(), zzmz.zza(), zznz.zzA(), zzc.zzc() + (-1) != 1 ? zzlu.zza() : null, zzni.zza());
        }
        int i4 = zznu.zza;
        return zznq.zzg(zznz.zzA(), zzlu.zza(), zzc.zzb());
    }
}
