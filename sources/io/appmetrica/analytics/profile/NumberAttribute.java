package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0326ic;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.He;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Sb;
import io.appmetrica.analytics.impl.Vi;
/* loaded from: classes5.dex */
public final class NumberAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberAttribute(String str, Sb sb, C0326ic c0326ic) {
        this.f1417a = new L6(str, sb, c0326ic);
    }

    public UserProfileUpdate<? extends Ho> withValue(double d) {
        return new UserProfileUpdate<>(new He(this.f1417a.c, d, new Sb(), new J4(new C0326ic(new D4(100)))));
    }

    public UserProfileUpdate<? extends Ho> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new He(this.f1417a.c, d, new Sb(), new Cl(new C0326ic(new D4(100)))));
    }

    public UserProfileUpdate<? extends Ho> withValueReset() {
        return new UserProfileUpdate<>(new Vi(1, this.f1417a.c, new Sb(), new C0326ic(new D4(100))));
    }
}
