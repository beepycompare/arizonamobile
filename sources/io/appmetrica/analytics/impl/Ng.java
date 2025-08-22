package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes4.dex */
public final class Ng {
    public Ng(InterfaceC0404lb interfaceC0404lb) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC0404lb a(Context context, IHandlerExecutor iHandlerExecutor) {
        Ag ag;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                ag = new Ag(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return ag != null ? new Mg() : ag;
        }
        ag = null;
        if (ag != null) {
        }
    }
}
