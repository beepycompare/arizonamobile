package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class P4 implements A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f573a;
    public final S4 b;
    public final ResultReceiver c;

    public P4(Context context, S4 s4, K4 k4) {
        this.f573a = context;
        this.b = s4;
        this.c = k4.c;
        s4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0333i6 c0333i6, K4 k4) {
        this.b.a(k4.b);
        this.b.a(c0333i6, this);
    }

    public final S4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f573a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C0480o4 c0480o4) {
        T6.a(this.c, c0480o4);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a() {
        this.b.b(this);
    }
}
