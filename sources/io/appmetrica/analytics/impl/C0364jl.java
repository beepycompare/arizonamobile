package io.appmetrica.analytics.impl;

import android.telephony.TelephonyManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* renamed from: io.appmetrica.analytics.impl.jl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0364jl implements FunctionWithThrowable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0389kl f896a;

    public C0364jl(C0389kl c0389kl) {
        this.f896a = c0389kl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        C0389kl c0389kl = this.f896a;
        if (c0389kl.b.hasPermission(c0389kl.f911a, "android.permission.READ_PHONE_STATE")) {
            return Boolean.valueOf(telephonyManager.isNetworkRoaming());
        }
        return null;
    }
}
