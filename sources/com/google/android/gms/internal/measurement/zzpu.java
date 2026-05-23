package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpu {
    public static final /* synthetic */ int zza = 0;
    private static final zzvb zzb = new zzvb(zznu.zzb());
    private static final Object zzc = new Object();
    private static volatile zztt zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListenableFuture zza(zzlk zzlkVar, final String str, String str2) {
        zztq zzh = zztr.zzh();
        zzrz zza2 = zzsa.zza(zzlkVar.zzc());
        zza2.zzb("phenotype");
        zza2.zzc("all_accounts.pb");
        zzh.zza(zza2.zzd());
        zzh.zzb(zznu.zzb());
        zzh.zzc(zzb);
        zzh.zzf(false);
        zztr zzg = zzh.zzg();
        zztt zzttVar = zzd;
        if (zzttVar == null) {
            synchronized (zzc) {
                zzttVar = zzd;
                if (zzttVar == null) {
                    zztu zztuVar = new zztu();
                    zztuVar.zza(zzlkVar.zzg());
                    zztuVar.zzb(zzlkVar.zzi());
                    zztuVar.zzc(zzui.zza());
                    zzttVar = zztuVar.zzd();
                    zzd = zzttVar;
                }
            }
        }
        return zzttVar.zza(zzg).zzb(new Function(str, "") { // from class: com.google.android.gms.internal.measurement.zzpt
            private final /* synthetic */ String zza;

            @Override // com.google.common.base.Function
            public final /* synthetic */ Object apply(Object obj) {
                zznu zznuVar = (zznu) obj;
                int i = zzpu.zza;
                String str3 = this.zza;
                zznq zznqVar = (zznq) zznuVar.zza(str3, zznr.zzb()).zzco();
                if (!zznqVar.zza().contains("")) {
                    zznqVar.zzb("");
                }
                zznt zzntVar = (zznt) zznuVar.zzco();
                zznqVar.zzc("");
                zzntVar.zza(str3, (zznr) zznqVar.zzbd());
                return (zznu) zzntVar.zzbd();
            }
        }, zzlkVar.zzg());
    }
}
