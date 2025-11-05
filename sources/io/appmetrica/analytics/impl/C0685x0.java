package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0685x0 {
    public static boolean a() {
        boolean z;
        synchronized (C0660w0.class) {
            z = C0660w0.f;
        }
        return z;
    }

    public static void b() {
        synchronized (C0660w0.class) {
            C0660w0.f = true;
        }
    }
}
