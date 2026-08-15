package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0327ie {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1034a;

    public C0327ie(C0456ne c0456ne) {
        this.f1034a = c0456ne;
    }

    public final C0352je a(Context context, C0329ih c0329ih) {
        return new C0352je(context, c0329ih, this.f1034a, new InterfaceC0585se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0585se
            public final Fl a(I0 i0) {
                return C0327ie.a(i0);
            }
        }, Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual", new G6());
    }

    public final C0352je b(Context context, C0329ih c0329ih) {
        return new C0352je(context, c0329ih, this.f1034a, new InterfaceC0585se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0585se
            public final Fl a(I0 i0) {
                return C0327ie.b(i0);
            }
        }, Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session", new G6());
    }

    public static final Fl a(I0 i0) {
        return new C0275ge(i0.f.d);
    }

    public static final Fl b(I0 i0) {
        return new Z();
    }
}
