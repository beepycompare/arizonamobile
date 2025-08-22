package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0108a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f765a;

    public C0108a(Context context) {
        this.f765a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0736yj.a(new StringBuilder(this.f765a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0736yj.a(this.f765a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
