package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznc implements zznx {
    private static final zznj zzb = new zzna();
    private final zznj zza;

    public zznc() {
        zznj zznjVar = zzb;
        int i = zznt.zza;
        zznb zznbVar = new zznb(zzlz.zza(), zznjVar);
        byte[] bArr = zzmo.zzb;
        this.zza = zznbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final zznw zza(Class cls) {
        int i = zzny.zza;
        if (!zzme.class.isAssignableFrom(cls)) {
            int i2 = zznt.zza;
        }
        zzni zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            int i3 = zznt.zza;
            return zzno.zzl(cls, zzc, zznr.zza(), zzmy.zza(), zzny.zzA(), zzc.zzc() + (-1) != 1 ? zzlt.zza() : null, zznh.zza());
        }
        int i4 = zznt.zza;
        return zznp.zzg(zzny.zzA(), zzlt.zza(), zzc.zzb());
    }
}
