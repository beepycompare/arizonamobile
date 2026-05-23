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

    public static C0175cg a(Context context, T6 t6) {
        return new C0175cg(context, t6);
    }

    public static Qi a(C0175cg c0175cg, Context context, ICommonExecutor iCommonExecutor) {
        C0546r0 c0546r0 = new C0546r0(context, iCommonExecutor);
        return new Qi(c0546r0, new C0674vo(new Nb()), new V4(c0175cg), new Ak(context, c0546r0));
    }

    public static C0543qm a(Context context, Qi qi, Handler handler) {
        return new C0543qm(qi, C0576s4.l().d(context), handler);
    }

    public static C0770zg a(Qi qi, C0665vf c0665vf, Handler handler) {
        return new C0770zg(qi, c0665vf, handler, c0665vf.s());
    }

    public static Di a(Context context, C0175cg c0175cg, Qi qi, Handler handler, C0543qm c0543qm) {
        return new Di(context, c0175cg, qi, handler, c0543qm);
    }

    public static Cd a(Context context) {
        return new Cd(C0576s4.l().c.a(), C0576s4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
