package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0720y0 {
    public static W6 a(Handler handler, C0695x0 c0695x0) {
        return new W6(handler, c0695x0);
    }

    public static Pf a(Context context, W6 w6) {
        return new Pf(context, w6);
    }

    public static Ji a(Pf pf, Context context, ICommonExecutor iCommonExecutor) {
        C0421m0 c0421m0 = new C0421m0(context, iCommonExecutor, C0699x4.l().e());
        return new Ji(c0421m0, new Pn(new Gb()), new C0122a5(pf), new C0341ik(context, c0421m0));
    }

    public static Ol a(Context context, Ji ji, C0361jf c0361jf, Handler handler) {
        return new Ol(ji, new Wl(context, c0361jf), handler);
    }

    public static C0686wg a(Ji ji, C0361jf c0361jf, Handler handler) {
        return new C0686wg(ji, c0361jf, handler, c0361jf.s());
    }

    public static C0688wi a(Context context, Pf pf, Ji ji, Handler handler, Ol ol) {
        return new C0688wi(context, pf, ji, handler, ol);
    }
}
