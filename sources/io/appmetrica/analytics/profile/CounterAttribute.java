package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0199dc;
import io.appmetrica.analytics.impl.C0424m6;
import io.appmetrica.analytics.impl.InterfaceC0288go;
import io.appmetrica.analytics.impl.Nb;
import io.appmetrica.analytics.impl.P6;
/* loaded from: classes4.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final P6 f1267a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Nb nb, C0199dc c0199dc) {
        this.f1267a = new P6(str, nb, c0199dc);
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withDelta(double d) {
        return new UserProfileUpdate<>(new C0424m6(this.f1267a.c, d));
    }
}
