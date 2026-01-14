package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* renamed from: io.appmetrica.analytics.impl.vg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0654vg {
    public C0654vg(Oa oa) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Oa a(Context context, IHandlerExecutor iHandlerExecutor) {
        C0328ig c0328ig;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c0328ig = new C0328ig(context, iHandlerExecutor);
            } catch (Throwable unused) {
            }
            return c0328ig != null ? new C0629ug() : c0328ig;
        }
        c0328ig = null;
        if (c0328ig != null) {
        }
    }
}
