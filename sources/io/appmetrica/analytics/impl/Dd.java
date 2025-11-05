package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class Dd {

    /* renamed from: a  reason: collision with root package name */
    public static E9 f440a;

    public static final synchronized E9 a(Context context) {
        E9 e9;
        synchronized (Dd.class) {
            e9 = f440a;
            if (e9 == null) {
                e9 = new E9(context, "uuid.dat");
                f440a = e9;
            }
        }
        return e9;
    }
}
