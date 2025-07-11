package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0717y0 {
    public static T6 a(Handler handler, C0692x0 c0692x0) {
        return new T6(handler, c0692x0);
    }

    public static Nf a(Context context, T6 t6) {
        return new Nf(context, t6);
    }

    public static Gi a(Nf nf, Context context, ICommonExecutor iCommonExecutor) {
        C0418m0 c0418m0 = new C0418m0(context, iCommonExecutor, C0696x4.l().e());
        return new Gi(c0418m0, new Mn(new Eb()), new C0121a5(nf), new C0264fk(context, c0418m0));
    }

    public static Ll a(Context context, Gi gi, C0309hf c0309hf, Handler handler) {
        return new Ll(gi, new Tl(context, c0309hf), handler);
    }

    public static C0633ug a(Gi gi, C0309hf c0309hf, Handler handler) {
        return new C0633ug(gi, c0309hf, handler, c0309hf.s());
    }

    public static C0635ui a(Context context, Nf nf, Gi gi, Handler handler, Ll ll) {
        return new C0635ui(context, nf, gi, handler, ll);
    }
}
