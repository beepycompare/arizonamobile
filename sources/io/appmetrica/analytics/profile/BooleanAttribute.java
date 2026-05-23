package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0368k3;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.InterfaceC0678w2;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Vi;
import io.appmetrica.analytics.impl.Vo;
/* loaded from: classes5.dex */
public class BooleanAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanAttribute(String str, Vo vo, InterfaceC0678w2 interfaceC0678w2) {
        this.f1409a = new L6(str, vo, interfaceC0678w2);
    }

    public UserProfileUpdate<? extends Ho> withValue(boolean z) {
        L6 l6 = this.f1409a;
        return new UserProfileUpdate<>(new C0368k3(l6.c, z, l6.f641a, new J4(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueIfUndefined(boolean z) {
        L6 l6 = this.f1409a;
        return new UserProfileUpdate<>(new C0368k3(l6.c, z, l6.f641a, new Cl(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueReset() {
        L6 l6 = this.f1409a;
        return new UserProfileUpdate<>(new Vi(3, l6.c, l6.f641a, l6.b));
    }
}
