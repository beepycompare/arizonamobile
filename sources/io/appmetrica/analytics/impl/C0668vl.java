package io.appmetrica.analytics.impl;

import android.telephony.TelephonyManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* renamed from: io.appmetrica.analytics.impl.vl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0668vl implements FunctionWithThrowable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0693wl f1131a;

    public C0668vl(C0693wl c0693wl) {
        this.f1131a = c0693wl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        C0693wl c0693wl = this.f1131a;
        if (c0693wl.b.hasPermission(c0693wl.f1144a, "android.permission.READ_PHONE_STATE")) {
            return Boolean.valueOf(telephonyManager.isNetworkRoaming());
        }
        return null;
    }
}
