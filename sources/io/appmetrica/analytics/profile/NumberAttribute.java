package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0248fe;
import io.appmetrica.analytics.impl.C0417m4;
import io.appmetrica.analytics.impl.C0524qb;
import io.appmetrica.analytics.impl.C0566s4;
import io.appmetrica.analytics.impl.C0593t6;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.InterfaceC0232eo;
import io.appmetrica.analytics.impl.Xk;
/* loaded from: classes5.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0593t6 f1429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, C0524qb c0524qb, Gb gb) {
        this.f1429a = new C0593t6(str, c0524qb, gb);
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValue(double d) {
        return new UserProfileUpdate<>(new C0248fe(this.f1429a.c, d, new C0524qb(), new C0566s4(new Gb(new C0417m4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0248fe(this.f1429a.c, d, new C0524qb(), new Xk(new Gb(new C0417m4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueReset() {
        return new UserProfileUpdate<>(new Bi(1, this.f1429a.c, new C0524qb(), new Gb(new C0417m4(100))));
    }
}
