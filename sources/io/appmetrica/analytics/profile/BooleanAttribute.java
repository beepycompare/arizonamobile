package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0312hl;
import io.appmetrica.analytics.impl.C0675w3;
import io.appmetrica.analytics.impl.InterfaceC0392ko;
import io.appmetrica.analytics.impl.InterfaceC0549r2;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
import io.appmetrica.analytics.impl.yo;
/* loaded from: classes4.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, yo yoVar, InterfaceC0549r2 interfaceC0549r2) {
        this.f1276a = new S6(str, yoVar, interfaceC0549r2);
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValue(boolean z) {
        S6 s6 = this.f1276a;
        return new UserProfileUpdate<>(new C0675w3(s6.c, z, s6.f667a, new Q4(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueIfUndefined(boolean z) {
        S6 s6 = this.f1276a;
        return new UserProfileUpdate<>(new C0675w3(s6.c, z, s6.f667a, new C0312hl(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueReset() {
        S6 s6 = this.f1276a;
        return new UserProfileUpdate<>(new Xi(3, s6.c, s6.f667a, s6.b));
    }
}
