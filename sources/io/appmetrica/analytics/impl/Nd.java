package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class Nd {

    /* renamed from: a  reason: collision with root package name */
    public static U9 f577a;

    public static final synchronized U9 a(Context context) {
        U9 u9;
        synchronized (Nd.class) {
            u9 = f577a;
            if (u9 == null) {
                u9 = new U9(context, "uuid.dat");
                f577a = u9;
            }
        }
        return u9;
    }
}
