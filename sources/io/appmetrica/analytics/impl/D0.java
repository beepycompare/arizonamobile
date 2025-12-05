package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes5.dex */
public abstract class D0 {
    public static C6 a(Handler handler, C0 c0) {
        return new C6(handler, c0);
    }

    public static Cf a(Context context, C6 c6) {
        return new Cf(context, c6);
    }

    public static C0702xi a(Cf cf, Context context, ICommonExecutor iCommonExecutor) {
        C0485p0 c0485p0 = new C0485p0(context, iCommonExecutor);
        return new C0702xi(c0485p0, new Tn(new C0421mb()), new G4(cf), new Zj(context, c0485p0));
    }

    public static Pl a(Context context, C0702xi c0702xi, We we, Handler handler) {
        return new Pl(c0702xi, new Xl(context, we), handler);
    }

    public static C0375kg a(C0702xi c0702xi, We we, Handler handler) {
        return new C0375kg(c0702xi, we, handler, we.s());
    }

    public static C0377ki a(Context context, Cf cf, C0702xi c0702xi, Handler handler, Pl pl) {
        return new C0377ki(context, cf, c0702xi, handler, pl);
    }

    public static C0192dd a(Context context) {
        return new C0192dd(C0157c4.l().c.a(), C0157c4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
