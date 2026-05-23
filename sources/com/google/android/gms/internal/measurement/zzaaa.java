package com.google.android.gms.internal.measurement;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzaaa {
    private static final zzaaa zza = new zzzu();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaaa(byte[] bArr) {
    }

    public abstract void zza(zzzq zzzqVar, Object obj);

    public abstract int zzb();

    public abstract Set zzc();

    public static zzaaa zzh(zzzj zzzjVar, zzzj zzzjVar2) {
        int zza2 = zzzjVar2.zza();
        return zza2 == 0 ? zza : zza2 <= 28 ? new zzzy(zzzjVar, zzzjVar2, null) : new zzzz(zzzjVar, zzzjVar2, null);
    }
}
