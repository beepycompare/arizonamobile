package com.google.android.gms.internal.play_billing;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzgs implements zzhm {
    private static final zzgz zza = new zzgq();
    private final zzgz zzb;

    public zzgs() {
        zzgz zzgzVar = zza;
        int i = zzei.zza;
        zzgr zzgrVar = new zzgr(zzfp.zza(), zzgzVar);
        byte[] bArr = zzga.zzb;
        this.zzb = zzgrVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final zzhl zza(Class cls) {
        int i = zzhn.zza;
        if (!zzfu.class.isAssignableFrom(cls)) {
            int i2 = zzei.zza;
        }
        zzgy zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            int i3 = zzei.zza;
            return zzhe.zzl(cls, zzb, zzhh.zza(), zzgl.zza(), zzhn.zzn(), zzb.zzc() + (-1) != 1 ? zzfk.zza() : null, zzgx.zza());
        }
        int i4 = zzei.zza;
        return zzhf.zzc(zzhn.zzn(), zzfk.zza(), zzb.zza());
    }
}
