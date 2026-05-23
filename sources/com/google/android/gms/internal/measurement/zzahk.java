package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzahk implements Supplier {
    private static final zzahk zza = new zzahk();
    private final Supplier zzb = Suppliers.ofInstance(new zzahm());

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

    @Override // com.google.common.base.Supplier
    /* renamed from: zzd */
    public final zzahl get() {
        return (zzahl) this.zzb.get();
    }
}
