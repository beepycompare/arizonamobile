package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0567s4;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.InterfaceC0340j2;
import io.appmetrica.analytics.impl.Ln;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.so;
/* loaded from: classes5.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Ln f1431a;
    private final C0594t6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, Xm xm, so soVar, InterfaceC0340j2 interfaceC0340j2) {
        this.b = new C0594t6(str, soVar, interfaceC0340j2);
        this.f1431a = xm;
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValue(String str) {
        C0594t6 c0594t6 = this.b;
        return new UserProfileUpdate<>(new Ym(c0594t6.c, str, this.f1431a, c0594t6.f1232a, new C0567s4(c0594t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueIfUndefined(String str) {
        C0594t6 c0594t6 = this.b;
        return new UserProfileUpdate<>(new Ym(c0594t6.c, str, this.f1431a, c0594t6.f1232a, new Xk(c0594t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueReset() {
        C0594t6 c0594t6 = this.b;
        return new UserProfileUpdate<>(new Bi(0, c0594t6.c, c0594t6.f1232a, c0594t6.b));
    }
}
