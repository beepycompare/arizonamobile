package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzzw extends AbstractSet {
    final /* synthetic */ zzzy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzw(zzzy zzzyVar) {
        Objects.requireNonNull(zzzyVar);
        this.zza = zzzyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzzv(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.zzg();
    }
}
