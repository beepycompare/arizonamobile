package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0109a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f781a;

    public C0109a(Context context) {
        this.f781a = context;
    }

    public final byte[] a() {
        try {
            return Cj.a(new StringBuilder(this.f781a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return Cj.a(this.f781a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
