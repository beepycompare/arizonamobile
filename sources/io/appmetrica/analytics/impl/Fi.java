package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Fi extends C0292gn {
    public final Ei d;
    public final ICommonExecutor e;

    public Fi(C0572s5 c0572s5, Hl hl, ICommonExecutor iCommonExecutor) {
        super(c0572s5, hl);
        this.d = new Ei(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0292gn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0292gn
    public final void f() {
        this.b.a();
        C0659vh c0659vh = (C0659vh) ((C0572s5) this.f859a).k.a();
        if (c0659vh.k.a(c0659vh.j)) {
            String str = c0659vh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0333ie.a((C0572s5) this.f859a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0292gn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0659vh) ((C0572s5) this.f859a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0659vh) ((C0572s5) this.f859a).k.a()).g));
        }
    }
}
