package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.In;
import io.appmetrica.analytics.impl.InterfaceC0167bo;
import io.appmetrica.analytics.impl.InterfaceC0498p2;
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
    private final In f1261a;
    private final O6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Wm wm, po poVar, InterfaceC0498p2 interfaceC0498p2) {
        this.b = new O6(str, poVar, interfaceC0498p2);
        this.f1261a = wm;
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValue(String str) {
        O6 o6 = this.b;
        return new UserProfileUpdate<>(new Xm(o6.c, str, this.f1261a, o6.f573a, new N4(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValueIfUndefined(String str) {
        O6 o6 = this.b;
        return new UserProfileUpdate<>(new Xm(o6.c, str, this.f1261a, o6.f573a, new Yk(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValueReset() {
        O6 o6 = this.b;
        return new UserProfileUpdate<>(new Oi(0, o6.c, o6.f573a, o6.b));
    }
}
