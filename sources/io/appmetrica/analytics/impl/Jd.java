package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class Jd {

    /* renamed from: a  reason: collision with root package name */
    public static P9 f491a;

    public static final synchronized P9 a(Context context) {
        P9 p9;
        synchronized (Jd.class) {
            p9 = f491a;
            if (p9 == null) {
                p9 = new P9(context, "uuid.dat");
                f491a = p9;
            }
        }
        return p9;
    }
}
