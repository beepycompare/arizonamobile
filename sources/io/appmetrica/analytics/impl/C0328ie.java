package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0328ie {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1034a;

    public C0328ie(C0457ne c0457ne) {
        this.f1034a = c0457ne;
    }

    public final C0353je a(Context context, C0330ih c0330ih) {
        return new C0353je(context, c0330ih, this.f1034a, new InterfaceC0586se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0586se
            public final Fl a(I0 i0) {
                return C0328ie.a(i0);
            }
        }, Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual", new G6());
    }

    public final C0353je b(Context context, C0330ih c0330ih) {
        return new C0353je(context, c0330ih, this.f1034a, new InterfaceC0586se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0586se
            public final Fl a(I0 i0) {
                return C0328ie.b(i0);
            }
        }, Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session", new G6());
    }

    public static final Fl a(I0 i0) {
        return new C0276ge(i0.f.d);
    }

    public static final Fl b(I0 i0) {
        return new Z();
    }
}
