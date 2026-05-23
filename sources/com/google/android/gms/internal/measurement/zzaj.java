package com.google.android.gms.internal.measurement;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaj implements Iterator {
    final /* synthetic */ Iterator zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(Iterator it) {
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new zzas((String) this.zza.next());
    }
}
