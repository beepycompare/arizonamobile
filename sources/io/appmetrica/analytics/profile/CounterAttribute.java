package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0277gc;
import io.appmetrica.analytics.impl.C0504p6;
import io.appmetrica.analytics.impl.InterfaceC0392ko;
import io.appmetrica.analytics.impl.Qb;
import io.appmetrica.analytics.impl.S6;
/* loaded from: classes4.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Qb qb, C0277gc c0277gc) {
        this.f1277a = new S6(str, qb, c0277gc);
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withDelta(double d) {
        return new UserProfileUpdate<>(new C0504p6(this.f1277a.c, d));
    }
}
