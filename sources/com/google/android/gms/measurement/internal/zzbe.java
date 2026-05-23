package com.google.android.gms.measurement.internal;

import java.util.Iterator;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzbe implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzbf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(zzbf zzbfVar) {
        Objects.requireNonNull(zzbfVar);
        this.zzb = zzbfVar;
        this.zza = zzbfVar.zzg().keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator
    /* renamed from: zza */
    public final String next() {
        return (String) this.zza.next();
    }
}
