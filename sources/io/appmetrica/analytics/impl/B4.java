package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* loaded from: classes3.dex */
public final class B4 implements InterfaceC0415m4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f406a;
    public final E4 b;
    public final ResultReceiver c;

    public B4(Context context, E4 e4, C0664w4 c0664w4) {
        this.f406a = context;
        this.b = e4;
        this.c = c0664w4.c;
        e4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0415m4
    public final void a(W5 w5, C0664w4 c0664w4) {
        this.b.a(c0664w4.b);
        this.b.a(w5, this);
    }

    public final E4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f406a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C0106a4 c0106a4) {
        I6.a(this.c, c0106a4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0415m4
    public final void a() {
        this.b.b(this);
    }
}
