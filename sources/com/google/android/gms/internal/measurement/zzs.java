package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        Objects.requireNonNull(zztVar);
        this.zzc = zztVar;
        this.zza = z;
        this.zzb = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    @Override // com.google.android.gms.internal.measurement.zzai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzao zza(zzg zzgVar, List list) {
        int i;
        int i2;
        zzh.zzb("log", 1, list);
        if (list.size() == 1) {
            zzt zztVar = this.zzc;
            zztVar.zzb().zza(3, zzgVar.zza((zzao) list.get(0)).zzc(), Collections.emptyList(), this.zza, this.zzb);
            return zzf;
        }
        int zzg = zzh.zzg(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
        if (zzg != 2) {
            i = 3;
            if (zzg == 3) {
                i2 = 1;
            } else if (zzg == 5) {
                i2 = 5;
            } else if (zzg == 6) {
                i2 = 2;
            }
            String zzc = zzgVar.zza((zzao) list.get(1)).zzc();
            if (list.size() != 2) {
                zzt zztVar2 = this.zzc;
                zztVar2.zzb().zza(i2, zzc, Collections.emptyList(), this.zza, this.zzb);
                return zzf;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 2; i3 < Math.min(list.size(), 5); i3++) {
                arrayList.add(zzgVar.zza((zzao) list.get(i3)).zzc());
            }
            this.zzc.zzb().zza(i2, zzc, arrayList, this.zza, this.zzb);
            return zzf;
        }
        i = 4;
        i2 = i;
        String zzc2 = zzgVar.zza((zzao) list.get(1)).zzc();
        if (list.size() != 2) {
        }
    }
}
