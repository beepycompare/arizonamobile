package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class L4 implements InterfaceC0673w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f645a;
    public final N4 b;
    public final ResultReceiver c;

    public L4(Context context, N4 n4, G4 g4) {
        this.f645a = context;
        this.b = n4;
        this.c = g4.c;
        n4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0673w4
    public final void a(C0235f6 c0235f6, G4 g4) {
        this.b.a(g4.b);
        this.b.a(c0235f6, this);
    }

    public final N4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f645a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C0336j4 c0336j4) {
        T6.a(this.c, c0336j4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0673w4
    public final void a() {
        this.b.b(this);
    }
}
