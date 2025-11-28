package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes5.dex */
public final class Ag {
    public Ag(Va va) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Va a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0452ng c0452ng;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0452ng = new C0452ng(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0452ng != null ? new C0751zg() : c0452ng;
        }
        c0452ng = null;
        if (c0452ng != null) {
        }
    }
}
