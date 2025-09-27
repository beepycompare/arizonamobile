package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0276gc;
import io.appmetrica.analytics.impl.C0503p6;
import io.appmetrica.analytics.impl.InterfaceC0391ko;
import io.appmetrica.analytics.impl.Qb;
import io.appmetrica.analytics.impl.S6;
/* loaded from: classes4.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Qb qb, C0276gc c0276gc) {
        this.f1277a = new S6(str, qb, c0276gc);
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withDelta(double d) {
        return new UserProfileUpdate<>(new C0503p6(this.f1277a.c, d));
    }
}
