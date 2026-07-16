package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class Wd {

    /* renamed from: a  reason: collision with root package name */
    public static R9 f827a;

    public static final synchronized R9 a(Context context) {
        R9 r9;
        synchronized (Wd.class) {
            r9 = f827a;
            if (r9 == null) {
                r9 = new R9(context, "uuid.dat");
                f827a = r9;
            }
        }
        return r9;
    }
}
