package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0656vi extends C0412ln {
    public final RunnableC0631ui d;
    public final ICommonExecutor e;

    public C0656vi(X4 x4, Kl kl, ICommonExecutor iCommonExecutor) {
        super(x4, kl);
        this.d = new RunnableC0631ui(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0412ln
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0412ln
    public final void f() {
        this.b.a();
        C0381kh c0381kh = (C0381kh) ((X4) this.f1103a).k.a();
        if (c0381kh.k.a(c0381kh.j)) {
            String str = c0381kh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(Vd.a((X4) this.f1103a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0412ln
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0381kh) ((X4) this.f1103a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0381kh) ((X4) this.f1103a).k.a()).g));
        }
    }
}
