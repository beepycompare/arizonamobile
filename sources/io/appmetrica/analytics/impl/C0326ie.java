package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0326ie {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1034a;

    public C0326ie(C0455ne c0455ne) {
        this.f1034a = c0455ne;
    }

    public final C0351je a(Context context, C0328ih c0328ih) {
        return new C0351je(context, c0328ih, this.f1034a, new InterfaceC0584se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0584se
            public final Fl a(I0 i0) {
                return C0326ie.a(i0);
            }
        }, Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual", new G6());
    }

    public final C0351je b(Context context, C0328ih c0328ih) {
        return new C0351je(context, c0328ih, this.f1034a, new InterfaceC0584se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0584se
            public final Fl a(I0 i0) {
                return C0326ie.b(i0);
            }
        }, Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session", new G6());
    }

    public static final Fl a(I0 i0) {
        return new C0274ge(i0.f.d);
    }

    public static final Fl b(I0 i0) {
        return new Z();
    }
}
