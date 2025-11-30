package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0101a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f786a;

    public C0101a(Context context) {
        this.f786a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0302hj.a(new StringBuilder(this.f786a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0302hj.a(this.f786a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
