package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0261g6;
import io.appmetrica.analytics.impl.C0319ic;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Sb;
/* loaded from: classes5.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Sb sb, C0319ic c0319ic) {
        this.f1416a = new L6(str, sb, c0319ic);
    }

    public UserProfileUpdate<? extends Ho> withDelta(double d) {
        return new UserProfileUpdate<>(new C0261g6(this.f1416a.c, d));
    }
}
