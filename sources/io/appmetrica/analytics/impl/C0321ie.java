package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0321ie {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1037a;

    public C0321ie(C0450ne c0450ne) {
        this.f1037a = c0450ne;
    }

    public final C0346je a(Context context, C0323ih c0323ih) {
        return new C0346je(context, c0323ih, this.f1037a, new InterfaceC0579se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0579se
            public final Fl a(I0 i0) {
                return C0321ie.a(i0);
            }
        }, Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual", new G6());
    }

    public final C0346je b(Context context, C0323ih c0323ih) {
        return new C0346je(context, c0323ih, this.f1037a, new InterfaceC0579se() { // from class: io.appmetrica.analytics.impl.ie$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0579se
            public final Fl a(I0 i0) {
                return C0321ie.b(i0);
            }
        }, Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session", new G6());
    }

    public static final Fl a(I0 i0) {
        return new C0269ge(i0.f.d);
    }

    public static final Fl b(I0 i0) {
        return new Z();
    }
}
