package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0676wg {
    public C0676wg(Pa pa) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pa a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0350jg c0350jg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0350jg = new C0350jg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0350jg != null ? new C0651vg() : c0350jg;
        }
        c0350jg = null;
        if (c0350jg != null) {
        }
    }
}
