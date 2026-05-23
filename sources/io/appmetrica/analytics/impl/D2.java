package io.appmetrica.analytics.impl;

import android.location.LocationManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* loaded from: classes5.dex */
public final class D2 implements FunctionWithThrowable {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        return ((LocationManager) obj).getProviders(true);
    }
}
