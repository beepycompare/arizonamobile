package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0524qb;
import io.appmetrica.analytics.impl.C0593t6;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.InterfaceC0232eo;
import io.appmetrica.analytics.impl.Q5;
/* loaded from: classes5.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0593t6 f1423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, C0524qb c0524qb, Gb gb) {
        this.f1423a = new C0593t6(str, c0524qb, gb);
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withDelta(double d) {
        return new UserProfileUpdate<>(new Q5(this.f1423a.c, d));
    }
}
