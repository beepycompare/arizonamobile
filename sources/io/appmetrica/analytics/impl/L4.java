package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class L4 implements InterfaceC0679w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f642a;
    public final N4 b;
    public final ResultReceiver c;

    public L4(Context context, N4 n4, G4 g4) {
        this.f642a = context;
        this.b = n4;
        this.c = g4.c;
        n4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0679w4
    public final void a(C0241f6 c0241f6, G4 g4) {
        this.b.a(g4.b);
        this.b.a(c0241f6, this);
    }

    public final N4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f642a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C0342j4 c0342j4) {
        T6.a(this.c, c0342j4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0679w4
    public final void a() {
        this.b.b(this);
    }
}
