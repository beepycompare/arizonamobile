package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class Yi {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f760a;
    public final String b;
    public final String c;

    public Yi(Context context, String str, String str2) {
        this.f760a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object a() {
        int identifier = this.f760a.getResources().getIdentifier(this.b, this.c, this.f760a.getPackageName());
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
