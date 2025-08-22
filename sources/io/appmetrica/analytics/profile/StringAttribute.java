package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0158bn;
import io.appmetrica.analytics.impl.C0184cn;
import io.appmetrica.analytics.impl.C0208dl;
import io.appmetrica.analytics.impl.InterfaceC0288go;
import io.appmetrica.analytics.impl.InterfaceC0495p2;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Nn;
import io.appmetrica.analytics.impl.P6;
import io.appmetrica.analytics.impl.Ti;
import io.appmetrica.analytics.impl.uo;
/* loaded from: classes4.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final Nn f1271a;
    private final P6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, C0158bn c0158bn, uo uoVar, InterfaceC0495p2 interfaceC0495p2) {
        this.b = new P6(str, uoVar, interfaceC0495p2);
        this.f1271a = c0158bn;
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValue(String str) {
        P6 p6 = this.b;
        return new UserProfileUpdate<>(new C0184cn(p6.c, str, this.f1271a, p6.f600a, new N4(p6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueIfUndefined(String str) {
        P6 p6 = this.b;
        return new UserProfileUpdate<>(new C0184cn(p6.c, str, this.f1271a, p6.f600a, new C0208dl(p6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueReset() {
        P6 p6 = this.b;
        return new UserProfileUpdate<>(new Ti(0, p6.c, p6.f600a, p6.b));
    }
}
