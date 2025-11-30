package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.xd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0698xd {

    /* renamed from: a  reason: collision with root package name */
    public static C0719y9 f1199a;

    public static final synchronized C0719y9 a(Context context) {
        C0719y9 c0719y9;
        synchronized (AbstractC0698xd.class) {
            c0719y9 = f1199a;
            if (c0719y9 == null) {
                c0719y9 = new C0719y9(context, "uuid.dat");
                f1199a = c0719y9;
            }
        }
        return c0719y9;
    }
}
