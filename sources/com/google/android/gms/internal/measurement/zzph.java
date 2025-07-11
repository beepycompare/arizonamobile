package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzph implements Supplier {
    private static final zzph zza = new zzph();
    private final Supplier zzb = Suppliers.ofInstance(new zzpj());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzc */
    public final zzpi get() {
        return (zzpi) this.zzb.get();
    }
}
