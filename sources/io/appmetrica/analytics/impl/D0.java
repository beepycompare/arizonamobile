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

    public static C0680wi a(Bf bf, Context context, ICommonExecutor iCommonExecutor) {
        C0488p0 c0488p0 = new C0488p0(context, iCommonExecutor);
        return new C0680wi(c0488p0, new Sn(new C0399lb()), new F4(bf), new Yj(context, c0488p0));
    }

    public static Ol a(Context context, C0680wi c0680wi, Ve ve, Handler handler) {
        return new Ol(c0680wi, new Wl(context, ve), handler);
    }

    public static C0353jg a(C0680wi c0680wi, Ve ve, Handler handler) {
        return new C0353jg(c0680wi, ve, handler, ve.s());
    }

    public static C0355ji a(Context context, Bf bf, C0680wi c0680wi, Handler handler, Ol ol) {
        return new C0355ji(context, bf, c0680wi, handler, ol);
    }

    public static C0170cd a(Context context) {
        return new C0170cd(C0135b4.l().c.a(), C0135b4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
