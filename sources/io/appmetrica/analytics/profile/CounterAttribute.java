package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0525qb;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.Q5;
/* loaded from: classes5.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0594t6 f1423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, C0525qb c0525qb, Gb gb) {
        this.f1423a = new C0594t6(str, c0525qb, gb);
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withDelta(double d) {
        return new UserProfileUpdate<>(new Q5(this.f1423a.c, d));
    }
}
