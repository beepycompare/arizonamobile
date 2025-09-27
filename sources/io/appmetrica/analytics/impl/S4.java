package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class S4 implements D4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f665a;
    public final V4 b;
    public final ResultReceiver c;

    public S4(Context context, V4 v4, N4 n4) {
        this.f665a = context;
        this.b = v4;
        this.c = n4.c;
        v4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.D4
    public final void a(C0477o6 c0477o6, N4 n4) {
        this.b.a(n4.b);
        this.b.a(c0477o6, this);
    }

    public final V4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f665a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C0550r4 c0550r4) {
        ResultReceiverC0116a7.a(this.c, c0550r4);
    }

    @Override // io.appmetrica.analytics.impl.D4
    public final void a() {
        this.b.b(this);
    }
}
