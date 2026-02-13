package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0567s4;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.InterfaceC0340j2;
import io.appmetrica.analytics.impl.X2;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.so;
/* loaded from: classes5.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0594t6 f1422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, so soVar, InterfaceC0340j2 interfaceC0340j2) {
        this.f1422a = new C0594t6(str, soVar, interfaceC0340j2);
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValue(boolean z) {
        C0594t6 c0594t6 = this.f1422a;
        return new UserProfileUpdate<>(new X2(c0594t6.c, z, c0594t6.f1231a, new C0567s4(c0594t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueIfUndefined(boolean z) {
        C0594t6 c0594t6 = this.f1422a;
        return new UserProfileUpdate<>(new X2(c0594t6.c, z, c0594t6.f1231a, new Xk(c0594t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueReset() {
        C0594t6 c0594t6 = this.f1422a;
        return new UserProfileUpdate<>(new Bi(3, c0594t6.c, c0594t6.f1231a, c0594t6.b));
    }
}
