package io.appmetrica.analytics.impl;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
/* loaded from: classes5.dex */
public final class Ge implements FunctionWithThrowable {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        ConnectivityManager connectivityManager = (ConnectivityManager) obj;
        if (AndroidUtils.isApiAchieved(23)) {
            return He.a(connectivityManager);
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return (NetworkType) He.f590a.a(Integer.valueOf(activeNetworkInfo.getType()));
        }
        return NetworkType.OFFLINE;
    }
}
