package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0116a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f756a;

    public C0116a(Context context) {
        this.f756a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0614tj.a(new StringBuilder(this.f756a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0614tj.a(this.f756a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
