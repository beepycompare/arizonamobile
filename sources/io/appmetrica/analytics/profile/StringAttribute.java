package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.An;
import io.appmetrica.analytics.impl.C0777zn;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.InterfaceC0493oo;
import io.appmetrica.analytics.impl.InterfaceC0678w2;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Vi;
import io.appmetrica.analytics.impl.Vo;
/* loaded from: classes5.dex */
public class StringAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0493oo f1418a;
    private final L6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringAttribute(String str, C0777zn c0777zn, Vo vo, InterfaceC0678w2 interfaceC0678w2) {
        this.b = new L6(str, vo, interfaceC0678w2);
        this.f1418a = c0777zn;
    }

    public UserProfileUpdate<? extends Ho> withValue(String str) {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new An(l6.c, str, this.f1418a, l6.f642a, new J4(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueIfUndefined(String str) {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new An(l6.c, str, this.f1418a, l6.f642a, new Cl(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueReset() {
        L6 l6 = this.b;
        return new UserProfileUpdate<>(new Vi(0, l6.c, l6.f642a, l6.b));
    }
}
