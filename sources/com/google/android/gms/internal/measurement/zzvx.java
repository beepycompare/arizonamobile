package com.google.android.gms.internal.measurement;

import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzvx extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        zzwq zzwqVar = new zzwq(zzrn.zza(Thread.currentThread()));
        Thread currentThread = Thread.currentThread();
        weakHashMap = zzvy.zze;
        synchronized (weakHashMap) {
            weakHashMap2 = zzvy.zze;
            weakHashMap2.put(currentThread, zzwqVar);
        }
        return zzwqVar;
    }
}
