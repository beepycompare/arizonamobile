package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0734z0 {
    public static boolean a() {
        boolean z;
        synchronized (C0709y0.class) {
            z = C0709y0.f;
        }
        return z;
    }

    public static void b() {
        synchronized (C0709y0.class) {
            C0709y0.f = true;
        }
    }
}
