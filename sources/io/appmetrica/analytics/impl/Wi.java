package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class Wi {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f826a;
    public final String b;
    public final String c;

    public Wi(Context context, String str, String str2) {
        this.f826a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object a() {
        int identifier = this.f826a.getResources().getIdentifier(this.b, this.c, this.f826a.getPackageName());
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
