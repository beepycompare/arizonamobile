package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzkh extends zzfu implements zzhc {
    private static final zzkh zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzjr zzg;
    private zzju zzh;

    static {
        zzkh zzkhVar = new zzkh();
        zzb = zzkhVar;
        zzfu.zzB(zzkh.class, zzkhVar);
    }

    private zzkh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzG(zzkh zzkhVar, zzkr zzkrVar) {
        zzkhVar.zzf = zzkrVar;
        zzkhVar.zze = 4;
    }

    public static zzkf zza() {
        return (zzkf) zzb.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzkh zzkhVar, zziw zziwVar) {
        zzkhVar.zzf = zziwVar;
        zzkhVar.zze = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzkh zzkhVar, zzja zzjaVar) {
        zzkhVar.zzf = zzjaVar;
        zzkhVar.zze = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzkh zzkhVar, zzji zzjiVar) {
        zzjiVar.getClass();
        zzkhVar.zzf = zzjiVar;
        zzkhVar.zze = 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzkh zzkhVar, zzjr zzjrVar) {
        zzjrVar.getClass();
        zzkhVar.zzg = zzjrVar;
        zzkhVar.zzd |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzkh zzkhVar, zzkn zzknVar) {
        zzknVar.getClass();
        zzkhVar.zzf = zzknVar;
        zzkhVar.zze = 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.play_billing.zzfu
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                return zzy(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zziw.class, zzja.class, zzkr.class, zzjo.class, "zzh", zzji.class, zzkn.class});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        return zzb;
                    }
                    throw null;
                }
                return new zzkf(null);
            } else {
                return new zzkh();
            }
        }
        return (byte) 1;
    }
}
