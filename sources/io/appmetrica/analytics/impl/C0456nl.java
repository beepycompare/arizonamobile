package io.appmetrica.analytics.impl;

import android.telephony.TelephonyManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* renamed from: io.appmetrica.analytics.impl.nl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0456nl implements FunctionWithThrowable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0481ol f1118a;

    public C0456nl(C0481ol c0481ol) {
        this.f1118a = c0481ol;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        C0481ol c0481ol = this.f1118a;
        if (c0481ol.b.hasPermission(c0481ol.f1137a, "android.permission.READ_PHONE_STATE")) {
            return Boolean.valueOf(telephonyManager.isNetworkRoaming());
        }
        return null;
    }
}
