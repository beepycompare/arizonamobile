package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ri extends C0595sn {
    public final Qi d;
    public final ICommonExecutor e;

    public Ri(C0652v5 c0652v5, Tl tl, ICommonExecutor iCommonExecutor) {
        super(c0652v5, tl);
        this.d = new Qi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0595sn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0595sn
    public final void f() {
        this.b.a();
        Gh gh = (Gh) ((C0652v5) this.f1086a).k.a();
        if (gh.k.a(gh.j)) {
            String str = gh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0537qe.a((C0652v5) this.f1086a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0595sn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((Gh) ((C0652v5) this.f1086a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((Gh) ((C0652v5) this.f1086a).k.a()).g));
        }
    }
}
