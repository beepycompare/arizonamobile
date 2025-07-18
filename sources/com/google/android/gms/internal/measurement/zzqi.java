package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzqi implements Supplier {
    private static final zzqi zza = new zzqi();
    private final Supplier zzb = Suppliers.ofInstance(new zzqk());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static long zzb() {
        return zza.get().zzb();
    }

    @SideEffectFree
    public static double zzc() {
        return zza.get().zzc();
    }

    @SideEffectFree
    public static long zzd() {
        return zza.get().zzd();
    }

    @SideEffectFree
    public static long zze() {
        return zza.get().zze();
    }

    @SideEffectFree
    public static String zzf() {
        return zza.get().zzf();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzg */
    public final zzqj get() {
        return (zzqj) this.zzb.get();
    }
}
