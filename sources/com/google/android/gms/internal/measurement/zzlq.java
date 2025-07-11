package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzlq {
    static final zzlq zza = new zzlq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzlq zzd;
    private final Map zze;

    zzlq() {
        this.zze = new HashMap();
    }

    public static zzlq zza() {
        zzlq zzlqVar = zzd;
        if (zzlqVar != null) {
            return zzlqVar;
        }
        synchronized (zzlq.class) {
            zzlq zzlqVar2 = zzd;
            if (zzlqVar2 != null) {
                return zzlqVar2;
            }
            int i = zznt.zza;
            zzlq zzb2 = zzly.zzb(zzlq.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzmd zzb(zznl zznlVar, int i) {
        return (zzmd) this.zze.get(new zzlp(zznlVar, i));
    }

    zzlq(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
