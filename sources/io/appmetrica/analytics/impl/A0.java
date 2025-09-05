package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public abstract class A0 {
    public static ResultReceiverC0116a7 a(Handler handler, C0746z0 c0746z0) {
        return new ResultReceiverC0116a7(handler, c0746z0);
    }

    public static Vf a(Context context, ResultReceiverC0116a7 resultReceiverC0116a7) {
        return new Vf(context, resultReceiverC0116a7);
    }

    public static Si a(Vf vf, Context context, ICommonExecutor iCommonExecutor) {
        C0471o0 c0471o0 = new C0471o0(context, iCommonExecutor, A4.l().e());
        return new Si(c0471o0, new Yn(new Lb()), new C0192d5(vf), new C0566rk(context, c0471o0));
    }

    public static Xl a(Context context, Si si, C0512pf c0512pf, Handler handler) {
        return new Xl(si, new C0260fm(context, c0512pf), handler);
    }

    public static Fg a(Si si, C0512pf c0512pf, Handler handler) {
        return new Fg(si, c0512pf, handler, c0512pf.s());
    }

    public static Fi a(Context context, Vf vf, Si si, Handler handler, Xl xl) {
        return new Fi(context, vf, si, handler, xl);
    }
}
