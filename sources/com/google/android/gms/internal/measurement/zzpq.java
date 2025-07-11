package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpq implements Supplier {
    private static final zzpq zza = new zzpq();
    private final Supplier zzb = Suppliers.ofInstance(new zzps());

    @SideEffectFree
    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return zza.get().zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return zza.get().zzd();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zze */
    public final zzpr get() {
        return (zzpr) this.zzb.get();
    }
}
