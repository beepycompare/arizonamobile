package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0261fn;
import io.appmetrica.analytics.impl.C0287gn;
import io.appmetrica.analytics.impl.C0311hl;
import io.appmetrica.analytics.impl.InterfaceC0391ko;
import io.appmetrica.analytics.impl.InterfaceC0548r2;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.Rn;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
import io.appmetrica.analytics.impl.yo;
/* loaded from: classes4.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Rn f1280a;
    private final S6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, C0261fn c0261fn, yo yoVar, InterfaceC0548r2 interfaceC0548r2) {
        this.b = new S6(str, yoVar, interfaceC0548r2);
        this.f1280a = c0261fn;
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValue(String str) {
        S6 s6 = this.b;
        return new UserProfileUpdate<>(new C0287gn(s6.c, str, this.f1280a, s6.f666a, new Q4(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueIfUndefined(String str) {
        S6 s6 = this.b;
        return new UserProfileUpdate<>(new C0287gn(s6.c, str, this.f1280a, s6.f666a, new C0311hl(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueReset() {
        S6 s6 = this.b;
        return new UserProfileUpdate<>(new Xi(0, s6.c, s6.f666a, s6.b));
    }
}
