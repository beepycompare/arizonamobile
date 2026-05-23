package com.google.android.gms.internal.measurement;

import android.os.Trace;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzwr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzws zzwsVar, zzws zzwsVar2) {
        if (zzwsVar != null) {
            if (zzwsVar2 != null) {
                if (zzwsVar.zzb() == zzwsVar2 && !zzd(zzwsVar)) {
                    Trace.endSection();
                    return;
                } else if (zzwsVar == zzwsVar2.zzb() && !zzd(zzwsVar2)) {
                    zze(zzwsVar2);
                    return;
                }
            }
            zzc(zzwsVar);
        }
        if (zzwsVar2 != null) {
            zzb(zzwsVar2);
        }
    }

    static void zzb(zzws zzwsVar) {
        if (!zzd(zzwsVar) && zzwsVar.zzb() != null) {
            zzb(zzwsVar.zzb());
            zze(zzwsVar);
            return;
        }
        Trace.beginSection(zzwsVar.zzd());
        zze(zzwsVar);
    }

    static void zzc(zzws zzwsVar) {
        if (!zzd(zzwsVar) && zzwsVar.zzb() != null) {
            Trace.endSection();
            zzc(zzwsVar.zzb());
            return;
        }
        Trace.endSection();
        Trace.endSection();
    }

    private static boolean zzd(zzws zzwsVar) {
        return zzwsVar.zza() != Thread.currentThread();
    }

    private static void zze(zzws zzwsVar) {
        String zze = zzwsVar.zze();
        int i = zzvy.zzb;
        if (zze.length() > 127) {
            zze = zze.substring(0, 127);
        }
        Trace.beginSection(zze);
    }
}
