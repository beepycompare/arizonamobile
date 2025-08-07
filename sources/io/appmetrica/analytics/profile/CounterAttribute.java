package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0155bc;
import io.appmetrica.analytics.impl.C0427m6;
import io.appmetrica.analytics.impl.InterfaceC0167bo;
import io.appmetrica.analytics.impl.Lb;
import io.appmetrica.analytics.impl.O6;
/* loaded from: classes4.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Lb lb, C0155bc c0155bc) {
        this.f1257a = new O6(str, lb, c0155bc);
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withDelta(double d) {
        return new UserProfileUpdate<>(new C0427m6(this.f1257a.c, d));
    }
}
