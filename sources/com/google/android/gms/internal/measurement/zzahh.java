package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzahh implements Supplier {
    private static final zzahh zza = new zzahh();
    private final Supplier zzb = Suppliers.ofInstance(new zzahj());

    @SideEffectFree
    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzc */
    public final zzahi get() {
        return (zzahi) this.zzb.get();
    }
}
