package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public final class zae {
    public final PendingResult zaa(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zac(this, googleApiClient));
    }
}
