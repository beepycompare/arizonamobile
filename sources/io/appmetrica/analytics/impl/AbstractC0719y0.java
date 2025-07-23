package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0719y0 {
    public static W6 a(Handler handler, C0694x0 c0694x0) {
        return new W6(handler, c0694x0);
    }

    public static Pf a(Context context, W6 w6) {
        return new Pf(context, w6);
    }

    public static Ji a(Pf pf, Context context, ICommonExecutor iCommonExecutor) {
        C0420m0 c0420m0 = new C0420m0(context, iCommonExecutor, C0698x4.l().e());
        return new Ji(c0420m0, new Pn(new Gb()), new C0121a5(pf), new C0340ik(context, c0420m0));
    }

    public static Ol a(Context context, Ji ji, C0360jf c0360jf, Handler handler) {
        return new Ol(ji, new Wl(context, c0360jf), handler);
    }

    public static C0685wg a(Ji ji, C0360jf c0360jf, Handler handler) {
        return new C0685wg(ji, c0360jf, handler, c0360jf.s());
    }

    public static C0687wi a(Context context, Pf pf, Ji ji, Handler handler, Ol ol) {
        return new C0687wi(context, pf, ji, handler, ol);
    }
}
