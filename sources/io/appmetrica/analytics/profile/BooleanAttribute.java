package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0566s4;
import io.appmetrica.analytics.impl.C0593t6;
import io.appmetrica.analytics.impl.InterfaceC0232eo;
import io.appmetrica.analytics.impl.InterfaceC0339j2;
import io.appmetrica.analytics.impl.X2;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.so;
/* loaded from: classes5.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0593t6 f1422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, so soVar, InterfaceC0339j2 interfaceC0339j2) {
        this.f1422a = new C0593t6(str, soVar, interfaceC0339j2);
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValue(boolean z) {
        C0593t6 c0593t6 = this.f1422a;
        return new UserProfileUpdate<>(new X2(c0593t6.c, z, c0593t6.f1231a, new C0566s4(c0593t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueIfUndefined(boolean z) {
        C0593t6 c0593t6 = this.f1422a;
        return new UserProfileUpdate<>(new X2(c0593t6.c, z, c0593t6.f1231a, new Xk(c0593t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueReset() {
        C0593t6 c0593t6 = this.f1422a;
        return new UserProfileUpdate<>(new Bi(3, c0593t6.c, c0593t6.f1231a, c0593t6.b));
    }
}
