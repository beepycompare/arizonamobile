package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0154bc;
import io.appmetrica.analytics.impl.C0426m6;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
import io.appmetrica.analytics.impl.Lb;
import io.appmetrica.analytics.impl.O6;
/* loaded from: classes4.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Lb lb, C0154bc c0154bc) {
        this.f1257a = new O6(str, lb, c0154bc);
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withDelta(double d) {
        return new UserProfileUpdate<>(new C0426m6(this.f1257a.c, d));
    }
}
