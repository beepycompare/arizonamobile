package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.a  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0115a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f757a;

    public C0115a(Context context) {
        this.f757a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC0613tj.a(new StringBuilder(this.f757a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC0613tj.a(this.f757a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
