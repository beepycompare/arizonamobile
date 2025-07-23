package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes4.dex */
public final class Ig {
    public Ig(InterfaceC0356jb interfaceC0356jb) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC0356jb a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0660vg c0660vg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0660vg = new C0660vg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0660vg != null ? new Hg() : c0660vg;
        }
        c0660vg = null;
        if (c0660vg != null) {
        }
    }
}
