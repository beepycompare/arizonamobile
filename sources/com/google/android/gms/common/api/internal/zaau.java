package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaau implements GoogleApiClient.ConnectionCallbacks {
    final /* synthetic */ AtomicReference zaa;
    final /* synthetic */ StatusPendingResult zab;
    final /* synthetic */ zaaz zac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaau(zaaz zaazVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
        Objects.requireNonNull(zaazVar);
        this.zac = zaazVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        StatusPendingResult statusPendingResult = this.zab;
        this.zac.zah((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.zaa.get()), statusPendingResult, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
