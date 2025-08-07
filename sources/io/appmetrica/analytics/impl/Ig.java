package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes4.dex */
public final class Ig {
    public Ig(InterfaceC0357jb interfaceC0357jb) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC0357jb a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0661vg c0661vg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0661vg = new C0661vg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0661vg != null ? new Hg() : c0661vg;
        }
        c0661vg = null;
        if (c0661vg != null) {
        }
    }
}
