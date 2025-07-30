package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0597t3;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
import io.appmetrica.analytics.impl.InterfaceC0497p2;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.O6;
import io.appmetrica.analytics.impl.Oi;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.po;
/* loaded from: classes4.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, po poVar, InterfaceC0497p2 interfaceC0497p2) {
        this.f1257a = new O6(str, poVar, interfaceC0497p2);
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValue(boolean z) {
        O6 o6 = this.f1257a;
        return new UserProfileUpdate<>(new C0597t3(o6.c, z, o6.f574a, new N4(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueIfUndefined(boolean z) {
        O6 o6 = this.f1257a;
        return new UserProfileUpdate<>(new C0597t3(o6.c, z, o6.f574a, new Yk(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueReset() {
        O6 o6 = this.f1257a;
        return new UserProfileUpdate<>(new Oi(3, o6.c, o6.f574a, o6.b));
    }
}
