package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes4.dex */
public final class Gg {
    public Gg(InterfaceC0313hb interfaceC0313hb) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC0313hb a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0616tg c0616tg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0616tg = new C0616tg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0616tg != null ? new Fg() : c0616tg;
        }
        c0616tg = null;
        if (c0616tg != null) {
        }
    }
}
