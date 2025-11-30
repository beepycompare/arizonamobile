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

    public static C0703xi a(Cf cf, Context context, ICommonExecutor iCommonExecutor) {
        C0486p0 c0486p0 = new C0486p0(context, iCommonExecutor);
        return new C0703xi(c0486p0, new Tn(new C0422mb()), new G4(cf), new Zj(context, c0486p0));
    }

    public static Pl a(Context context, C0703xi c0703xi, We we, Handler handler) {
        return new Pl(c0703xi, new Xl(context, we), handler);
    }

    public static C0376kg a(C0703xi c0703xi, We we, Handler handler) {
        return new C0376kg(c0703xi, we, handler, we.s());
    }

    public static C0378ki a(Context context, Cf cf, C0703xi c0703xi, Handler handler, Pl pl) {
        return new C0378ki(context, cf, c0703xi, handler, pl);
    }

    public static C0193dd a(Context context) {
        return new C0193dd(C0158c4.l().c.a(), C0158c4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
