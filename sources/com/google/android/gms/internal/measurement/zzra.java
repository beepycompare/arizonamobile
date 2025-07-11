package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzra implements Supplier {
    private static final zzra zza = new zzra();
    private final Supplier zzb = Suppliers.ofInstance(new zzrc());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zzb */
    public final zzrb get() {
        return (zzrb) this.zzb.get();
    }
}
