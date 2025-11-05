package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.C0696xb;
import io.appmetrica.analytics.impl.InterfaceC0281go;
import io.appmetrica.analytics.impl.Nb;
import io.appmetrica.analytics.impl.X5;
/* loaded from: classes3.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final A6 f1318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, C0696xb c0696xb, Nb nb) {
        this.f1318a = new A6(str, c0696xb, nb);
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withDelta(double d) {
        return new UserProfileUpdate<>(new X5(this.f1318a.c, d));
    }
}
