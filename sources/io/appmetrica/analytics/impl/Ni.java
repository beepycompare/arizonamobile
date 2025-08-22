package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ni extends C0491on {
    public final Mi d;
    public final ICommonExecutor e;

    public Ni(C0572s5 c0572s5, Pl pl, ICommonExecutor iCommonExecutor) {
        super(c0572s5, pl);
        this.d = new Mi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C0491on
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.C0491on
    public final void f() {
        this.b.a();
        Ch ch = (Ch) ((C0572s5) this.f1003a).k.a();
        if (ch.k.a(ch.j)) {
            String str = ch.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0432me.a((C0572s5) this.f1003a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C0491on
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((Ch) ((C0572s5) this.f1003a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((Ch) ((C0572s5) this.f1003a).k.a()).g));
        }
    }
}
