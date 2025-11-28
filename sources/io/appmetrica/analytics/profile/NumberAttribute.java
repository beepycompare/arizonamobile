package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.C0175cl;
import io.appmetrica.analytics.impl.C0425me;
import io.appmetrica.analytics.impl.C0589t4;
import io.appmetrica.analytics.impl.C0696xb;
import io.appmetrica.analytics.impl.C0739z4;
import io.appmetrica.analytics.impl.Gi;
import io.appmetrica.analytics.impl.InterfaceC0281go;
import io.appmetrica.analytics.impl.Nb;
/* loaded from: classes5.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final A6 f1321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, C0696xb c0696xb, Nb nb) {
        this.f1321a = new A6(str, c0696xb, nb);
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValue(double d) {
        return new UserProfileUpdate<>(new C0425me(this.f1321a.c, d, new C0696xb(), new C0739z4(new Nb(new C0589t4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0425me(this.f1321a.c, d, new C0696xb(), new C0175cl(new Nb(new C0589t4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueReset() {
        return new UserProfileUpdate<>(new Gi(1, this.f1321a.c, new C0696xb(), new Nb(new C0589t4(100))));
    }
}
