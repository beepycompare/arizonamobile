package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zaj implements GoogleApiClient.OnConnectionFailedListener {
    public final int zaa;
    public final GoogleApiClient zab;
    public final GoogleApiClient.OnConnectionFailedListener zac;
    final /* synthetic */ zak zad;

    public zaj(zak zakVar, int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Objects.requireNonNull(zakVar);
        this.zad = zakVar;
        this.zaa = i;
        this.zab = googleApiClient;
        this.zac = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        String.valueOf(valueOf);
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(valueOf)));
        this.zad.zaf(connectionResult, this.zaa);
    }
}
