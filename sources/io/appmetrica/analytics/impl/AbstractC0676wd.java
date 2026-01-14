package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.wd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0676wd {

    /* renamed from: a  reason: collision with root package name */
    public static C0697x9 f1287a;

    public static final synchronized C0697x9 a(Context context) {
        C0697x9 c0697x9;
        synchronized (AbstractC0676wd.class) {
            c0697x9 = f1287a;
            if (c0697x9 == null) {
                c0697x9 = new C0697x9(context, "uuid.dat");
                f1287a = c0697x9;
            }
        }
        return c0697x9;
    }
}
