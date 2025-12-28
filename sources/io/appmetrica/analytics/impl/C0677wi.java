package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.wi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0677wi extends C0433mn {
    public final RunnableC0652vi d;
    public final ICommonExecutor e;

    public C0677wi(Y4 y4, Ll ll, ICommonExecutor iCommonExecutor) {
        super(y4, ll);
        this.d = new RunnableC0652vi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0433mn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0433mn
    public final void f() {
        this.b.a();
        C0402lh c0402lh = (C0402lh) ((Y4) this.f1114a).k.a();
        if (c0402lh.k.a(c0402lh.j)) {
            String str = c0402lh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(Wd.a((Y4) this.f1114a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0433mn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0402lh) ((Y4) this.f1114a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0402lh) ((Y4) this.f1114a).k.a()).g));
        }
    }
}
