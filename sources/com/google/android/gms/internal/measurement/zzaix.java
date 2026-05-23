package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaix implements Supplier {
    private static final zzaix zza = new zzaix();
    private final Supplier zzb = Suppliers.ofInstance(new zzaiz());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzb */
    public final zzaiy get() {
        return (zzaiy) this.zzb.get();
    }
}
