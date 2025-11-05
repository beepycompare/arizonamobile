package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class Ai extends C0484on {
    public final RunnableC0753zi d;
    public final ICommonExecutor e;

    public Ai(C0210e5 c0210e5, Ol ol, ICommonExecutor iCommonExecutor) {
        super(c0210e5, ol);
        this.d = new RunnableC0753zi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0484on
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0484on
    public final void f() {
        this.b.a();
        C0503ph c0503ph = (C0503ph) ((C0210e5) this.f1045a).k.a();
        if (c0503ph.k.a(c0503ph.j)) {
            String str = c0503ph.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0168ce.a((C0210e5) this.f1045a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0484on
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0503ph) ((C0210e5) this.f1045a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0503ph) ((C0210e5) this.f1045a).k.a()).g));
        }
    }
}
