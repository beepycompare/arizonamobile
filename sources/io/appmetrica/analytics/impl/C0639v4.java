package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* renamed from: io.appmetrica.analytics.impl.v4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0639v4 implements InterfaceC0261g4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1161a;
    public final C0714y4 b;
    public final ResultReceiver c;

    public C0639v4(Context context, C0714y4 c0714y4, C0515q4 c0515q4) {
        this.f1161a = context;
        this.b = c0714y4;
        this.c = c0515q4.c;
        c0714y4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0261g4
    public final void a(Q5 q5, C0515q4 c0515q4) {
        this.b.a(c0515q4.b);
        this.b.a(q5, this);
    }

    public final C0714y4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f1161a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(T3 t3) {
        C6.a(this.c, t3);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0261g4
    public final void a() {
        this.b.b(this);
    }
}
