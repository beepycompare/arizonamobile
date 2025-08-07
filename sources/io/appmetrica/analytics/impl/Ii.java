package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ii extends C0369jn {
    public final Hi d;
    public final ICommonExecutor e;

    public Ii(C0575s5 c0575s5, Kl kl, ICommonExecutor iCommonExecutor) {
        super(c0575s5, kl);
        this.d = new Hi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0369jn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0369jn
    public final void f() {
        this.b.a();
        C0712xh c0712xh = (C0712xh) ((C0575s5) this.f918a).k.a();
        if (c0712xh.k.a(c0712xh.j)) {
            String str = c0712xh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0385ke.a((C0575s5) this.f918a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0369jn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0712xh) ((C0575s5) this.f918a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0712xh) ((C0575s5) this.f918a).k.a()).g));
        }
    }
}
