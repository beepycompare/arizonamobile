package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0725y0 {
    public static T6 a(Handler handler, C0700x0 c0700x0) {
        return new T6(handler, c0700x0);
    }

    public static Nf a(Context context, T6 t6) {
        return new Nf(context, t6);
    }

    public static Gi a(Nf nf, Context context, ICommonExecutor iCommonExecutor) {
        C0426m0 c0426m0 = new C0426m0(context, iCommonExecutor, C0704x4.l().e());
        return new Gi(c0426m0, new Mn(new Eb()), new C0129a5(nf), new C0272fk(context, c0426m0));
    }

    public static Ll a(Context context, Gi gi, C0317hf c0317hf, Handler handler) {
        return new Ll(gi, new Tl(context, c0317hf), handler);
    }

    public static C0641ug a(Gi gi, C0317hf c0317hf, Handler handler) {
        return new C0641ug(gi, c0317hf, handler, c0317hf.s());
    }

    public static C0643ui a(Context context, Nf nf, Gi gi, Handler handler, Ll ll) {
        return new C0643ui(context, nf, gi, handler, ll);
    }
}
