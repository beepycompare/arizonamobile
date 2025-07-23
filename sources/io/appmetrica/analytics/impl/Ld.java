package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class Ld {

    /* renamed from: a  reason: collision with root package name */
    public static S9 f531a;

    public static final synchronized S9 a(Context context) {
        S9 s9;
        synchronized (Ld.class) {
            s9 = f531a;
            if (s9 == null) {
                s9 = new S9(context, "uuid.dat");
                f531a = s9;
            }
        }
        return s9;
    }
}
