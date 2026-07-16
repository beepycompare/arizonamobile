package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0106a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f879a;

    public C0106a(Context context) {
        this.f879a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0402lb.a(new StringBuilder(this.f879a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0402lb.a(this.f879a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
