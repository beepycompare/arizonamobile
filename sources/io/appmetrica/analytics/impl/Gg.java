package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes4.dex */
public final class Gg {
    public Gg(InterfaceC0305hb interfaceC0305hb) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC0305hb a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0608tg c0608tg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0608tg = new C0608tg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0608tg != null ? new Fg() : c0608tg;
        }
        c0608tg = null;
        if (c0608tg != null) {
        }
    }
}
