package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.Trace;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayDeque;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzvy {
    public static final /* synthetic */ int zzb = 0;
    private static final ImmutableSet zzc = ImmutableSet.of("androidx.fragment.app.FragmentViewLifecycleOwner.handleLifecycleEvent", "com.google.android.libraries.logging.logger.transmitters.clearcut", "com.google.android.libraries.performance.primes.transmitter.clearcut", "com.google.android.libraries.performance.primes.metrics.crash.CrashMetricServiceImpl", "com.google.android.libraries.performance.primes.metrics.crash.applicationexit.ApplicationExitMetricServiceImpl");
    private static final AtomicReference zzd = new AtomicReference(ImmutableSet.of());
    static final zzrg zza = new zzrg("tiktok_systrace");
    private static final WeakHashMap zze = new WeakHashMap();
    private static final zzvx zzf = new zzvx();

    static {
        new ArrayDeque();
        new ArrayDeque();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableSet zza() {
        return (ImmutableSet) zzd.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzws zzb(boolean z) {
        zzwq zzd2 = zzd();
        zzws zzwsVar = zzd2.zzb;
        return (zzwsVar == null || zzwsVar == zzwg.zza) ? zzwd.zzi(zzd2) : zzwsVar;
    }

    public static zzws zzc(zzwq zzwqVar, zzws zzwsVar) {
        boolean zza2;
        zzxb zzxbVar = zzwqVar.zzc;
        zzws zzwsVar2 = zzwqVar.zzb;
        if (zzwsVar2 != zzwsVar) {
            if (zzwsVar2 == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    zza2 = Trace.isEnabled();
                } else {
                    zza2 = zzrk.zza(zza);
                }
                zzwqVar.zza = zza2;
            }
            if (zzwqVar.zza) {
                zzwr.zza(zzwsVar2, zzwsVar);
            }
            if (zzwsVar2 != zzwsVar) {
                zzwqVar.zzb = zzwsVar;
                return zzwsVar2;
            }
        }
        return zzwsVar;
    }

    public static zzwq zzd() {
        return (zzwq) zzf.get();
    }
}
