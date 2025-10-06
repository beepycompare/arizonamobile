package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Ae;
import io.appmetrica.analytics.impl.C0277gc;
import io.appmetrica.analytics.impl.C0312hl;
import io.appmetrica.analytics.impl.InterfaceC0392ko;
import io.appmetrica.analytics.impl.K4;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.Qb;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
/* loaded from: classes4.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1280a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, Qb qb, C0277gc c0277gc) {
        this.f1280a = new S6(str, qb, c0277gc);
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValue(double d) {
        return new UserProfileUpdate<>(new Ae(this.f1280a.c, d, new Qb(), new Q4(new C0277gc(new K4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new Ae(this.f1280a.c, d, new Qb(), new C0312hl(new C0277gc(new K4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueReset() {
        return new UserProfileUpdate<>(new Xi(1, this.f1280a.c, new Qb(), new C0277gc(new K4(100))));
    }
}
