package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Fi extends C0300gn {
    public final Ei d;
    public final ICommonExecutor e;

    public Fi(C0580s5 c0580s5, Hl hl, ICommonExecutor iCommonExecutor) {
        super(c0580s5, hl);
        this.d = new Ei(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0300gn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0300gn
    public final void f() {
        this.b.a();
        C0667vh c0667vh = (C0667vh) ((C0580s5) this.f858a).k.a();
        if (c0667vh.k.a(c0667vh.j)) {
            String str = c0667vh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0341ie.a((C0580s5) this.f858a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0300gn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0667vh) ((C0580s5) this.f858a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0667vh) ((C0580s5) this.f858a).k.a()).g));
        }
    }
}
