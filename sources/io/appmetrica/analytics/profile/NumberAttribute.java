package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0154bc;
import io.appmetrica.analytics.impl.C0633ue;
import io.appmetrica.analytics.impl.H4;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
import io.appmetrica.analytics.impl.Lb;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.O6;
import io.appmetrica.analytics.impl.Oi;
import io.appmetrica.analytics.impl.Yk;
/* loaded from: classes4.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1260a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, Lb lb, C0154bc c0154bc) {
        this.f1260a = new O6(str, lb, c0154bc);
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValue(double d) {
        return new UserProfileUpdate<>(new C0633ue(this.f1260a.c, d, new Lb(), new N4(new C0154bc(new H4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0633ue(this.f1260a.c, d, new Lb(), new Yk(new C0154bc(new H4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueReset() {
        return new UserProfileUpdate<>(new Oi(1, this.f1260a.c, new Lb(), new C0154bc(new H4(100))));
    }
}
