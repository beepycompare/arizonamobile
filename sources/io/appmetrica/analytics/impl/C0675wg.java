package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0675wg {
    public C0675wg(Pa pa) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pa a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0349jg c0349jg;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0349jg = new C0349jg(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0349jg != null ? new C0650vg() : c0349jg;
        }
        c0349jg = null;
        if (c0349jg != null) {
        }
    }
}
