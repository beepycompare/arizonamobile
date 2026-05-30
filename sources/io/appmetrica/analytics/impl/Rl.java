package io.appmetrica.analytics.impl;

import android.telephony.TelephonyManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* loaded from: classes5.dex */
public final class Rl implements FunctionWithThrowable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sl f751a;

    public Rl(Sl sl) {
        this.f751a = sl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        Sl sl = this.f751a;
        if (sl.b.hasPermission(sl.f766a, "android.permission.READ_PHONE_STATE")) {
            return Boolean.valueOf(telephonyManager.isNetworkRoaming());
        }
        return null;
    }
}
