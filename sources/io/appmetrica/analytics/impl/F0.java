package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes5.dex */
public abstract class F0 {
    public static T6 a(Handler handler, E0 e0) {
        return new T6(handler, e0);
    }

    public static C0168cg a(Context context, T6 t6) {
        return new C0168cg(context, t6);
    }

    public static Qi a(C0168cg c0168cg, Context context, ICommonExecutor iCommonExecutor) {
        C0539r0 c0539r0 = new C0539r0(context, iCommonExecutor);
        return new Qi(c0539r0, new C0667vo(new Nb()), new V4(c0168cg), new Ak(context, c0539r0));
    }

    public static C0536qm a(Context context, Qi qi, Handler handler) {
        return new C0536qm(qi, C0569s4.l().d(context), handler);
    }

    public static C0763zg a(Qi qi, C0658vf c0658vf, Handler handler) {
        return new C0763zg(qi, c0658vf, handler, c0658vf.s());
    }

    public static Di a(Context context, C0168cg c0168cg, Qi qi, Handler handler, C0536qm c0536qm) {
        return new Di(context, c0168cg, qi, handler, c0536qm);
    }

    public static Cd a(Context context) {
        return new Cd(C0569s4.l().c.a(), C0569s4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
