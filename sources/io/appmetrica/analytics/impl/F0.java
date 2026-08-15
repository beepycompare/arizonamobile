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

    public static C0174cg a(Context context, T6 t6) {
        return new C0174cg(context, t6);
    }

    public static Qi a(C0174cg c0174cg, Context context, ICommonExecutor iCommonExecutor) {
        C0545r0 c0545r0 = new C0545r0(context, iCommonExecutor);
        return new Qi(c0545r0, new C0673vo(new Nb()), new V4(c0174cg), new Ak(context, c0545r0));
    }

    public static C0542qm a(Context context, Qi qi, Handler handler) {
        return new C0542qm(qi, C0575s4.l().d(context), handler);
    }

    public static C0769zg a(Qi qi, C0664vf c0664vf, Handler handler) {
        return new C0769zg(qi, c0664vf, handler, c0664vf.s());
    }

    public static Di a(Context context, C0174cg c0174cg, Qi qi, Handler handler, C0542qm c0542qm) {
        return new Di(context, c0174cg, qi, handler, c0542qm);
    }

    public static Cd a(Context context) {
        return new Cd(C0575s4.l().c.a(), C0575s4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
