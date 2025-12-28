package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes5.dex */
public final class Jd {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f637a;

    public Jd(Od od) {
        this.f637a = od;
    }

    public final Kd a(Context context, Tg tg) {
        return new Kd(context, tg, this.f637a, new Sd() { // from class: io.appmetrica.analytics.impl.Jd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.Sd
            public final InterfaceC0148bl a(G0 g0) {
                return Jd.a(g0);
            }
        }, EnumC0164cb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final Kd b(Context context, Tg tg) {
        return new Kd(context, tg, this.f637a, new Sd() { // from class: io.appmetrica.analytics.impl.Jd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Sd
            public final InterfaceC0148bl a(G0 g0) {
                return Jd.b(g0);
            }
        }, EnumC0164cb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0148bl a(G0 g0) {
        return new Hd(g0.f.d);
    }

    public static final InterfaceC0148bl b(G0 g0) {
        return new X();
    }
}
