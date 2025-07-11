package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzqo implements Supplier {
    private static final zzqo zza = new zzqo();
    private final Supplier zzb = Suppliers.ofInstance(new zzqq());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzb */
    public final zzqp get() {
        return (zzqp) this.zzb.get();
    }
}
