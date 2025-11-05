package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0101a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f791a;

    public C0101a(Context context) {
        this.f791a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0405lj.a(new StringBuilder(this.f791a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0405lj.a(this.f791a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
