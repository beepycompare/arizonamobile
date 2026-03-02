package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0566s4;
import io.appmetrica.analytics.impl.C0593t6;
import io.appmetrica.analytics.impl.InterfaceC0232eo;
import io.appmetrica.analytics.impl.InterfaceC0339j2;
import io.appmetrica.analytics.impl.Ln;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.so;
/* loaded from: classes5.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Ln f1430a;
    private final C0593t6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Xm xm, so soVar, InterfaceC0339j2 interfaceC0339j2) {
        this.b = new C0593t6(str, soVar, interfaceC0339j2);
        this.f1430a = xm;
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValue(String str) {
        C0593t6 c0593t6 = this.b;
        return new UserProfileUpdate<>(new Ym(c0593t6.c, str, this.f1430a, c0593t6.f1231a, new C0566s4(c0593t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueIfUndefined(String str) {
        C0593t6 c0593t6 = this.b;
        return new UserProfileUpdate<>(new Ym(c0593t6.c, str, this.f1430a, c0593t6.f1231a, new Xk(c0593t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueReset() {
        C0593t6 c0593t6 = this.b;
        return new UserProfileUpdate<>(new Bi(0, c0593t6.c, c0593t6.f1231a, c0593t6.b));
    }
}
