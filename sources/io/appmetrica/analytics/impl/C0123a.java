package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0123a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f745a;

    public C0123a(Context context) {
        this.f745a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0545qj.a(new StringBuilder(this.f745a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0545qj.a(this.f745a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
