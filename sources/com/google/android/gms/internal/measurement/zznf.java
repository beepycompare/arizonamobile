package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes3.dex */
public final class zznf {
    private final zzne zza;

    private zznf(zzot zzotVar, Object obj, zzot zzotVar2, Object obj2) {
        this.zza = new zzne(zzotVar, "", zzotVar2, "");
    }

    public static zznf zza(zzot zzotVar, Object obj, zzot zzotVar2, Object obj2) {
        return new zznf(zzotVar, "", zzotVar2, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzlm zzlmVar, zzne zzneVar, Object obj, Object obj2) throws IOException {
        zzlw.zzf(zzlmVar, zzneVar.zza, 1, obj);
        zzlw.zzf(zzlmVar, zzneVar.zzc, 2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzne zzneVar, Object obj, Object obj2) {
        return zzlw.zzh(zzneVar.zza, 1, obj) + zzlw.zzh(zzneVar.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzne zzneVar = this.zza;
        int zzz = zzlm.zzz(i << 3);
        int zzc = zzc(zzneVar, obj, obj2);
        return zzz + zzlm.zzz(zzc) + zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzne zze() {
        return this.zza;
    }
}
