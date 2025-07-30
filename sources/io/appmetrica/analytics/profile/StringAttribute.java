package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.In;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
import io.appmetrica.analytics.impl.InterfaceC0497p2;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.O6;
import io.appmetrica.analytics.impl.Oi;
import io.appmetrica.analytics.impl.Wm;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.po;
/* loaded from: classes4.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final In f1262a;
    private final O6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Wm wm, po poVar, InterfaceC0497p2 interfaceC0497p2) {
        this.b = new O6(str, poVar, interfaceC0497p2);
        this.f1262a = wm;
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValue(String str) {
        O6 o6 = this.b;
        return new UserProfileUpdate<>(new Xm(o6.c, str, this.f1262a, o6.f574a, new N4(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueIfUndefined(String str) {
        O6 o6 = this.b;
        return new UserProfileUpdate<>(new Xm(o6.c, str, this.f1262a, o6.f574a, new Yk(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueReset() {
        O6 o6 = this.b;
        return new UserProfileUpdate<>(new Oi(0, o6.c, o6.f574a, o6.b));
    }
}
