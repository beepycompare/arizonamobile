package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzvl extends AbstractFuture {
    private final int zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvl(int i) {
        this.zza = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zza() {
        return this.zza;
    }
}
