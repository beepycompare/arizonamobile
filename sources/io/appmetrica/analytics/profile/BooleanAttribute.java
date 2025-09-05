package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0311hl;
import io.appmetrica.analytics.impl.C0674w3;
import io.appmetrica.analytics.impl.InterfaceC0391ko;
import io.appmetrica.analytics.impl.InterfaceC0548r2;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
import io.appmetrica.analytics.impl.yo;
/* loaded from: classes4.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1271a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, yo yoVar, InterfaceC0548r2 interfaceC0548r2) {
        this.f1271a = new S6(str, yoVar, interfaceC0548r2);
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValue(boolean z) {
        S6 s6 = this.f1271a;
        return new UserProfileUpdate<>(new C0674w3(s6.c, z, s6.f662a, new Q4(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueIfUndefined(boolean z) {
        S6 s6 = this.f1271a;
        return new UserProfileUpdate<>(new C0674w3(s6.c, z, s6.f662a, new C0311hl(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueReset() {
        S6 s6 = this.f1271a;
        return new UserProfileUpdate<>(new Xi(3, s6.c, s6.f662a, s6.b));
    }
}
