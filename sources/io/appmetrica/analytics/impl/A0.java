package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public abstract class A0 {
    public static ResultReceiverC0117a7 a(Handler handler, C0747z0 c0747z0) {
        return new ResultReceiverC0117a7(handler, c0747z0);
    }

    public static Vf a(Context context, ResultReceiverC0117a7 resultReceiverC0117a7) {
        return new Vf(context, resultReceiverC0117a7);
    }

    public static Si a(Vf vf, Context context, ICommonExecutor iCommonExecutor) {
        C0472o0 c0472o0 = new C0472o0(context, iCommonExecutor, A4.l().e());
        return new Si(c0472o0, new Yn(new Lb()), new C0193d5(vf), new C0567rk(context, c0472o0));
    }

    public static Xl a(Context context, Si si, C0513pf c0513pf, Handler handler) {
        return new Xl(si, new C0261fm(context, c0513pf), handler);
    }

    public static Fg a(Si si, C0513pf c0513pf, Handler handler) {
        return new Fg(si, c0513pf, handler, c0513pf.s());
    }

    public static Fi a(Context context, Vf vf, Si si, Handler handler, Xl xl) {
        return new Fi(context, vf, si, handler, xl);
    }
}
