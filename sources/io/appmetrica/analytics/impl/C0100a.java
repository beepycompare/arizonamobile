package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0100a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f883a;

    public C0100a(Context context) {
        this.f883a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0301hj.a(new StringBuilder(this.f883a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0301hj.a(this.f883a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
