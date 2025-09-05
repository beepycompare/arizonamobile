package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes4.dex */
public final class Rg {
    public Rg(InterfaceC0482ob interfaceC0482ob) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC0482ob a(Context context, IHandlerExecutor iHandlerExecutor) {
        Eg eg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                eg = new Eg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return eg != null ? new Qg() : eg;
        }
        eg = null;
        if (eg != null) {
        }
    }
}
