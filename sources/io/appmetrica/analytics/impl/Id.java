package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes5.dex */
public final class Id {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f627a;

    public Id(Nd nd) {
        this.f627a = nd;
    }

    public final Jd a(Context context, Sg sg) {
        return new Jd(context, sg, this.f627a, new Rd() { // from class: io.appmetrica.analytics.impl.Id$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Rd
            public final InterfaceC0127al a(G0 g0) {
                return Id.a(g0);
            }
        }, EnumC0143bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final Jd b(Context context, Sg sg) {
        return new Jd(context, sg, this.f627a, new Rd() { // from class: io.appmetrica.analytics.impl.Id$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.Rd
            public final InterfaceC0127al a(G0 g0) {
                return Id.b(g0);
            }
        }, EnumC0143bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0127al a(G0 g0) {
        return new Gd(g0.f.d);
    }

    public static final InterfaceC0127al b(G0 g0) {
        return new X();
    }
}
