package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzls {
    private static final Object zza = new Object();
    private static volatile boolean zzb = false;
    private static volatile zzlr zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzlr zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza() {
        zzd = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb() {
        synchronized (zza) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc() {
        if (zze == null) {
            zze = new zzlr(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd() {
        if (zzc == null) {
            zzc = new zzlr(null);
        }
    }
}
