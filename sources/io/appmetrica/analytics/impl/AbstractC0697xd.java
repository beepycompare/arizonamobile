package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.xd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0697xd {

    /* renamed from: a  reason: collision with root package name */
    public static C0718y9 f1282a;

    public static final synchronized C0718y9 a(Context context) {
        C0718y9 c0718y9;
        synchronized (AbstractC0697xd.class) {
            c0718y9 = f1282a;
            if (c0718y9 == null) {
                c0718y9 = new C0718y9(context, "uuid.dat");
                f1282a = c0718y9;
            }
        }
        return c0718y9;
    }
}
