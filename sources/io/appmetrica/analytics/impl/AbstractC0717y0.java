package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0717y0 {
    public static X6 a(Handler handler, C0692x0 c0692x0) {
        return new X6(handler, c0692x0);
    }

    public static Rf a(Context context, X6 x6) {
        return new Rf(context, x6);
    }

    public static Oi a(Rf rf, Context context, ICommonExecutor iCommonExecutor) {
        C0418m0 c0418m0 = new C0418m0(context, iCommonExecutor, C0696x4.l().e());
        return new Oi(c0418m0, new Un(new Ib()), new C0114a5(rf), new C0463nk(context, c0418m0));
    }

    public static Tl a(Context context, Oi oi, C0408lf c0408lf, Handler handler) {
        return new Tl(oi, new C0157bm(context, c0408lf), handler);
    }

    public static Bg a(Oi oi, C0408lf c0408lf, Handler handler) {
        return new Bg(oi, c0408lf, handler, c0408lf.s());
    }

    public static Bi a(Context context, Rf rf, Oi oi, Handler handler, Tl tl) {
        return new Bi(context, rf, oi, handler, tl);
    }
}
