package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableSet;
import java.util.UUID;
import java.util.function.Consumer;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzwd extends zzvn implements zzvs {
    static final zzvq zza = new zzvr();
    public static final /* synthetic */ int zzb = 0;
    private final Exception zzc;

    private zzwd(UUID uuid, String str, Exception exc, boolean z, zzwq zzwqVar) {
        super("<missing root>", uuid, str, zzwqVar);
        this.zzc = exc;
    }

    public static zzwd zzi(zzwq zzwqVar) {
        final UUID zzc = zzvz.zza().zzc();
        String zzcL = zzvn.zzcL(zzc);
        ImmutableSet zza2 = zzvy.zza();
        if (!zza2.isEmpty()) {
            zza2.forEach(new Consumer(zzc, null) { // from class: com.google.android.gms.internal.measurement.zzwc
                @Override // java.util.function.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    int i = zzwd.zzb;
                    ((zzwu) obj).zza();
                }
            });
        }
        return new zzwd(zzc, zzcL, zza, false, zzwqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzvs
    public final Exception zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzvs
    public final zzws zzg(String str, zzwl zzwlVar, boolean z, zzwq zzwqVar) {
        if (z) {
            int i = zzvy.zzb;
        }
        return new zzwf(str, this, zzwlVar, z, zzwqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzwl zzh() {
        return zzwk.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzws zzj(String str, String str2, String str3, int i, zzwl zzwlVar, zzwq zzwqVar) {
        int i2 = zzvy.zzb;
        return zzg(str, zzwlVar, true, zzwqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final long zzk() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzwl zzl() {
        throw null;
    }
}
