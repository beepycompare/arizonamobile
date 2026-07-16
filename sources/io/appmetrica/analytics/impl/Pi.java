package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Pi extends Mn {
    public final Oi d;
    public final ICommonExecutor e;

    public Pi(C0448n5 c0448n5, InterfaceC0439mm interfaceC0439mm, ICommonExecutor iCommonExecutor) {
        super(c0448n5, interfaceC0439mm);
        this.d = new Oi(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.Mn
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.Mn
    public final void f() {
        this.b.a();
        Eh eh = (Eh) ((C0448n5) this.f672a).k.a();
        if (eh.k.a(eh.j)) {
            String str = eh.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(C0690we.a((C0448n5) this.f672a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Mn
    public final void g() {
        this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(1L));
    }

    public final void h() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((Eh) ((C0448n5) this.f672a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((Eh) ((C0448n5) this.f672a).k.a()).g));
        }
    }
}
