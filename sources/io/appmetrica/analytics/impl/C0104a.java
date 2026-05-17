package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0104a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f897a;

    public C0104a(Context context) {
        this.f897a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0279gj.a(new StringBuilder(this.f897a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0279gj.a(this.f897a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
