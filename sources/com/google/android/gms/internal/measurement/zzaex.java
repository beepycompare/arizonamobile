package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
final class zzaex {
    public static final boolean zza(Object obj) {
        return !((zzaew) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzaew zzaewVar = (zzaew) obj;
        zzaew zzaewVar2 = (zzaew) obj2;
        if (!zzaewVar2.isEmpty()) {
            if (!zzaewVar.zze()) {
                zzaewVar = zzaewVar.zzc();
            }
            zzaewVar.zzb(zzaewVar2);
        }
        return zzaewVar;
    }
}
