package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzbp extends zzbm implements zzbq {
    public static zzbq zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return queryLocalInterface instanceof zzbq ? (zzbq) queryLocalInterface : new zzbo(iBinder);
    }
}
