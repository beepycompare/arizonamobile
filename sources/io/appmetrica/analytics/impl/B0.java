package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes3.dex */
public abstract class B0 {
    public static I6 a(Handler handler, A0 a0) {
        return new I6(handler, a0);
    }

    public static Gf a(Context context, I6 i6) {
        return new Gf(context, i6);
    }

    public static Bi a(Gf gf, Context context, ICommonExecutor iCommonExecutor) {
        C0486p0 c0486p0 = new C0486p0(context, iCommonExecutor, C0338j4.l().e());
        return new Bi(c0486p0, new Un(new C0571sb()), new M4(gf), new C0200dk(context, c0486p0));
    }

    public static Sl a(Context context, Bi bi, C0117af c0117af, Handler handler) {
        return new Sl(bi, new C0124am(context, c0117af), handler);
    }

    public static C0477og a(Bi bi, C0117af c0117af, Handler handler) {
        return new C0477og(bi, c0117af, handler, c0117af.s());
    }

    public static C0479oi a(Context context, Gf gf, Bi bi, Handler handler, Sl sl) {
        return new C0479oi(context, gf, bi, handler, sl);
    }

    public static C0347jd a(Context context) {
        return new C0347jd(C0338j4.l().c.a(), C0338j4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
