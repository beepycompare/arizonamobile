package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaev {
    private final zzaeu zza;

    private zzaev(zzagm zzagmVar, Object obj, zzagm zzagmVar2, Object obj2) {
        this.zza = new zzaeu(zzagmVar, "", zzagmVar2, obj2);
    }

    public static zzaev zza(zzagm zzagmVar, Object obj, zzagm zzagmVar2, Object obj2) {
        return new zzaev(zzagmVar, "", zzagmVar2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzada zzadaVar, zzaeu zzaeuVar, Object obj, Object obj2) throws IOException {
        zzadk.zzf(zzadaVar, zzaeuVar.zza, 1, obj);
        zzadk.zzf(zzadaVar, zzaeuVar.zzc, 2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzaeu zzaeuVar, Object obj, Object obj2) {
        return zzadk.zzh(zzaeuVar.zza, 1, obj) + zzadk.zzh(zzaeuVar.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzaeu zzaeuVar = this.zza;
        int zzE = zzada.zzE(i << 3);
        int zzc = zzc(zzaeuVar, obj, obj2);
        return zzE + zzada.zzE(zzc) + zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaeu zze() {
        return this.zza;
    }
}
