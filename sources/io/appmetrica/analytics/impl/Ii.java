package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ii extends C0368jn {
    public final Hi d;
    public final ICommonExecutor e;

    public Ii(C0574s5 c0574s5, Kl kl, ICommonExecutor iCommonExecutor) {
        super(c0574s5, kl);
        this.d = new Hi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0368jn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0368jn
    public final void f() {
        this.b.a();
        C0711xh c0711xh = (C0711xh) ((C0574s5) this.f919a).k.a();
        if (c0711xh.k.a(c0711xh.j)) {
            String str = c0711xh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0384ke.a((C0574s5) this.f919a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0368jn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C0711xh) ((C0574s5) this.f919a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C0711xh) ((C0574s5) this.f919a).k.a()).g));
        }
    }
}
