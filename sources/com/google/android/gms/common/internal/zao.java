package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zao {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zao() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (client.requiresGooglePlayServices()) {
            int minApkVersion = client.getMinApkVersion();
            int zab = zab(context, minApkVersion);
            if (zab != -1) {
                return zab;
            }
            SparseIntArray sparseIntArray = this.zaa;
            synchronized (sparseIntArray) {
                int i2 = 0;
                while (true) {
                    if (i2 >= sparseIntArray.size()) {
                        i = -1;
                        break;
                    }
                    int keyAt = sparseIntArray.keyAt(i2);
                    if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                        break;
                    }
                    i2++;
                }
                if (i == -1) {
                    i = this.zab.isGooglePlayServicesAvailable(context, minApkVersion);
                }
                sparseIntArray.put(minApkVersion, i);
            }
            return i;
        }
        return 0;
    }

    public final int zab(Context context, int i) {
        int i2;
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            i2 = sparseIntArray.get(i, -1);
        }
        return i2;
    }

    public final void zac() {
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
    }

    public zao(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
