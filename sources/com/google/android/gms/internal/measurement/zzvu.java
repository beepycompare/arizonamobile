package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzvu {
    private static final WeakHashMap zza = new WeakHashMap();
    private static final WeakHashMap zzb = new WeakHashMap();

    public static void zza(Throwable th) {
        Throwable th2;
        zzxc zzxcVar;
        zzws zzwsVar;
        WeakHashMap weakHashMap = zzb;
        synchronized (weakHashMap) {
            th2 = th;
            while (th2 != null) {
                try {
                    if (weakHashMap.containsKey(th2)) {
                        break;
                    }
                    th2 = th2.getCause();
                } finally {
                }
            }
            weakHashMap.put(th, Boolean.valueOf(th2 != null));
        }
        if (th2 != null) {
            return;
        }
        Preconditions.checkState(true, "Trace uncaught exception is disabled.");
        WeakHashMap weakHashMap2 = zza;
        synchronized (weakHashMap2) {
            Throwable th3 = th;
            while (th3 != null) {
                try {
                    if (weakHashMap2.containsKey(th3)) {
                        break;
                    }
                    th3 = th3.getCause();
                } finally {
                }
            }
            if (th3 == null) {
                zzxcVar = null;
            } else {
                zzww zzwwVar = (zzww) weakHashMap2.get(th3);
                weakHashMap2.put(th, zzwwVar);
                zzxcVar = new zzxc(th3, zzwwVar);
            }
        }
        if (zzxcVar != null || (zzwsVar = zzvy.zzd().zzb) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (zzwsVar = zzvy.zzd().zzb; zzwsVar != null; zzwsVar = zzwsVar.zzb()) {
            arrayList.add(zzwsVar);
        }
        zzvo zzvoVar = new zzvo();
        zzvoVar.zzc(((zzws) arrayList.get(0)).zzc());
        ((zzws) arrayList.get(0)).zzk();
        zzvoVar.zzd(-1L);
        ImmutableList.Builder builderWithExpectedSize = ImmutableList.builderWithExpectedSize(arrayList.size());
        ImmutableList.Builder builderWithExpectedSize2 = ImmutableList.builderWithExpectedSize(arrayList.size());
        for (zzws zzwsVar2 : Lists.reverse(arrayList)) {
            builderWithExpectedSize2.add((ImmutableList.Builder) zzwsVar2.zze());
            builderWithExpectedSize.add((ImmutableList.Builder) zzwsVar2.zzh());
        }
        WeakHashMap weakHashMap3 = zza;
        synchronized (weakHashMap3) {
            zzvoVar.zza(builderWithExpectedSize2.build());
            zzvoVar.zzb(builderWithExpectedSize.build());
            weakHashMap3.put(th, zzvoVar.zze());
        }
    }
}
