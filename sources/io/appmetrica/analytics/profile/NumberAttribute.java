package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Ae;
import io.appmetrica.analytics.impl.C0276gc;
import io.appmetrica.analytics.impl.C0311hl;
import io.appmetrica.analytics.impl.InterfaceC0391ko;
import io.appmetrica.analytics.impl.K4;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.Qb;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
/* loaded from: classes4.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1275a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, Qb qb, C0276gc c0276gc) {
        this.f1275a = new S6(str, qb, c0276gc);
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValue(double d) {
        return new UserProfileUpdate<>(new Ae(this.f1275a.c, d, new Qb(), new Q4(new C0276gc(new K4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new Ae(this.f1275a.c, d, new Qb(), new C0311hl(new C0276gc(new K4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueReset() {
        return new UserProfileUpdate<>(new Xi(1, this.f1275a.c, new Qb(), new C0276gc(new K4(100))));
    }
}
