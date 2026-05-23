package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzbr extends zzbm implements zzbs {
    public static zzbs zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return queryLocalInterface instanceof zzbs ? (zzbs) queryLocalInterface : new zzbq(iBinder);
    }
}
