package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0105a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f893a;

    public C0105a(Context context) {
        this.f893a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0280gj.a(new StringBuilder(this.f893a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0280gj.a(this.f893a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
