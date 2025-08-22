package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0199dc;
import io.appmetrica.analytics.impl.C0208dl;
import io.appmetrica.analytics.impl.C0681we;
import io.appmetrica.analytics.impl.H4;
import io.appmetrica.analytics.impl.InterfaceC0288go;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Nb;
import io.appmetrica.analytics.impl.P6;
import io.appmetrica.analytics.impl.Ti;
/* loaded from: classes4.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final P6 f1270a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, Nb nb, C0199dc c0199dc) {
        this.f1270a = new P6(str, nb, c0199dc);
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValue(double d) {
        return new UserProfileUpdate<>(new C0681we(this.f1270a.c, d, new Nb(), new N4(new C0199dc(new H4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C0681we(this.f1270a.c, d, new Nb(), new C0208dl(new C0199dc(new H4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueReset() {
        return new UserProfileUpdate<>(new Ti(1, this.f1270a.c, new Nb(), new C0199dc(new H4(100))));
    }
}
