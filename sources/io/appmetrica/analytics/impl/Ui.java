package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class Ui {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f680a;
    public final String b;
    public final String c;

    public Ui(Context context, String str, String str2) {
        this.f680a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object a() {
        int identifier = this.f680a.getResources().getIdentifier(this.b, this.c, this.f680a.getPackageName());
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
