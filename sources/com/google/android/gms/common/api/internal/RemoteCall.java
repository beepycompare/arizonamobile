package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public interface RemoteCall<T, U> {
    void accept(T t, U u) throws RemoteException;
}
