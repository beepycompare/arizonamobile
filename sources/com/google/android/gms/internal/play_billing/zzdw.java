package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzdw extends zzfu implements zzhc {
    private static final zzdw zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzdw zzdwVar = new zzdw();
        zzb = zzdwVar;
        zzfu.zzB(zzdw.class, zzdwVar);
    }

    private zzdw() {
    }

    public static zzdw zzc(byte[] bArr) throws zzgc {
        return (zzdw) zzfu.zzt(zzb, bArr);
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzdv(null);
            } else {
                return new zzdw();
            }
        }
        return (byte) 1;
    }

    public final String zze() {
        return this.zzf;
    }
}
