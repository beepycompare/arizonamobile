package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0249fe;
import io.appmetrica.analytics.impl.C0418m4;
import io.appmetrica.analytics.impl.C0525qb;
import io.appmetrica.analytics.impl.C0567s4;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.Xk;
/* loaded from: classes5.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0594t6 f1429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, C0525qb c0525qb, Gb gb) {
        this.f1429a = new C0594t6(str, c0525qb, gb);
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValue(double d) {
        return new UserProfileUpdate<>(new C0249fe(this.f1429a.c, d, new C0525qb(), new C0567s4(new Gb(new C0418m4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0249fe(this.f1429a.c, d, new C0525qb(), new Xk(new Gb(new C0418m4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueReset() {
        return new UserProfileUpdate<>(new Bi(1, this.f1429a.c, new C0525qb(), new Gb(new C0418m4(100))));
    }
}
