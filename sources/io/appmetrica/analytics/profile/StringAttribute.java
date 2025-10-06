package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0262fn;
import io.appmetrica.analytics.impl.C0288gn;
import io.appmetrica.analytics.impl.C0312hl;
import io.appmetrica.analytics.impl.InterfaceC0392ko;
import io.appmetrica.analytics.impl.InterfaceC0549r2;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.Rn;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
import io.appmetrica.analytics.impl.yo;
/* loaded from: classes4.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Rn f1281a;
    private final S6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, C0262fn c0262fn, yo yoVar, InterfaceC0549r2 interfaceC0549r2) {
        this.b = new S6(str, yoVar, interfaceC0549r2);
        this.f1281a = c0262fn;
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValue(String str) {
        S6 s6 = this.b;
        return new UserProfileUpdate<>(new C0288gn(s6.c, str, this.f1281a, s6.f667a, new Q4(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueIfUndefined(String str) {
        S6 s6 = this.b;
        return new UserProfileUpdate<>(new C0288gn(s6.c, str, this.f1281a, s6.f667a, new C0312hl(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueReset() {
        S6 s6 = this.b;
        return new UserProfileUpdate<>(new Xi(0, s6.c, s6.f667a, s6.b));
    }
}
