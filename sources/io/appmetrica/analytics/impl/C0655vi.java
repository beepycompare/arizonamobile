package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0655vi extends C0411ln {
    public final RunnableC0630ui d;
    public final ICommonExecutor e;

    public C0655vi(X4 x4, Kl kl, ICommonExecutor iCommonExecutor) {
        super(x4, kl);
        this.d = new RunnableC0630ui(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0411ln
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0411ln
    public final void f() {
        this.b.a();
        C0380kh c0380kh = (C0380kh) ((X4) this.f1108a).k.a();
        if (c0380kh.k.a(c0380kh.j)) {
            String str = c0380kh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(Vd.a((X4) this.f1108a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0411ln
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0380kh) ((X4) this.f1108a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0380kh) ((X4) this.f1108a).k.a()).g));
        }
    }
}
