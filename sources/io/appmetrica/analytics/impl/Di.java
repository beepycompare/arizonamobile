package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class Di {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f545a;
    public final String b;
    public final String c;

    public Di(Context context, String str, String str2) {
        this.f545a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object a() {
        int identifier = this.f545a.getResources().getIdentifier(this.b, this.c, this.f545a.getPackageName());
        if (identifier != 0) {
            try {
                return a(identifier);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public abstract Object a(int i);
}
