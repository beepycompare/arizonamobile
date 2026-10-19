package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0099a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f882a;

    public C0099a(Context context) {
        this.f882a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0395lb.a(new StringBuilder(this.f882a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0395lb.a(this.f882a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
