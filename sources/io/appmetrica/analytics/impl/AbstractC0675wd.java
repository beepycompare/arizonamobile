package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.wd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0675wd {

    /* renamed from: a  reason: collision with root package name */
    public static C0696x9 f1291a;

    public static final synchronized C0696x9 a(Context context) {
        C0696x9 c0696x9;
        synchronized (AbstractC0675wd.class) {
            c0696x9 = f1291a;
            if (c0696x9 == null) {
                c0696x9 = new C0696x9(context, "uuid.dat");
                f1291a = c0696x9;
            }
        }
        return c0696x9;
    }
}
