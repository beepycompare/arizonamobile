package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes5.dex */
public abstract class D0 {
    public static B6 a(Handler handler, C0 c0) {
        return new B6(handler, c0);
    }

    public static Bf a(Context context, B6 b6) {
        return new Bf(context, b6);
    }

    public static C0681wi a(Bf bf, Context context, ICommonExecutor iCommonExecutor) {
        C0489p0 c0489p0 = new C0489p0(context, iCommonExecutor);
        return new C0681wi(c0489p0, new Sn(new C0400lb()), new F4(bf), new Yj(context, c0489p0));
    }

    public static Ol a(Context context, C0681wi c0681wi, Ve ve, Handler handler) {
        return new Ol(c0681wi, new Wl(context, ve), handler);
    }

    public static C0354jg a(C0681wi c0681wi, Ve ve, Handler handler) {
        return new C0354jg(c0681wi, ve, handler, ve.s());
    }

    public static C0356ji a(Context context, Bf bf, C0681wi c0681wi, Handler handler, Ol ol) {
        return new C0356ji(context, bf, c0681wi, handler, ol);
    }

    public static C0171cd a(Context context) {
        return new C0171cd(C0136b4.l().c.a(), C0136b4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
