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

    public static C0173cg a(Context context, T6 t6) {
        return new C0173cg(context, t6);
    }

    public static Qi a(C0173cg c0173cg, Context context, ICommonExecutor iCommonExecutor) {
        C0544r0 c0544r0 = new C0544r0(context, iCommonExecutor);
        return new Qi(c0544r0, new C0672vo(new Nb()), new V4(c0173cg), new Ak(context, c0544r0));
    }

    public static C0541qm a(Context context, Qi qi, Handler handler) {
        return new C0541qm(qi, C0574s4.l().d(context), handler);
    }

    public static C0768zg a(Qi qi, C0663vf c0663vf, Handler handler) {
        return new C0768zg(qi, c0663vf, handler, c0663vf.s());
    }

    public static Di a(Context context, C0173cg c0173cg, Qi qi, Handler handler, C0541qm c0541qm) {
        return new Di(context, c0173cg, qi, handler, c0541qm);
    }

    public static Cd a(Context context) {
        return new Cd(C0574s4.l().c.a(), C0574s4.l().b(context), "client_modules", new SystemTimeProvider());
    }
}
