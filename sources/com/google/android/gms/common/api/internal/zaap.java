package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaap implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    final /* synthetic */ zaar zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zaap(zaar zaarVar, byte[] bArr) {
        Objects.requireNonNull(zaarVar);
        this.zaa = zaarVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zaar zaarVar = this.zaa;
        ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(zaarVar.zay());
        ((com.google.android.gms.signin.zae) Preconditions.checkNotNull(zaarVar.zav())).zaa(new zaao(zaarVar));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zaar zaarVar = this.zaa;
        zaarVar.zas().lock();
        try {
            if (!zaarVar.zan(connectionResult)) {
                zaarVar.zao(connectionResult);
            } else {
                zaarVar.zam();
                zaarVar.zak();
            }
        } finally {
            this.zaa.zas().unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
