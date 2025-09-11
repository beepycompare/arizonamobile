package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class Rd {

    /* renamed from: a  reason: collision with root package name */
    public static X9 f654a;

    public static final synchronized X9 a(Context context) {
        X9 x9;
        synchronized (Rd.class) {
            x9 = f654a;
            if (x9 == null) {
                x9 = new X9(context, "uuid.dat");
                f654a = x9;
            }
        }
        return x9;
    }
}
