package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0267g6;
import io.appmetrica.analytics.impl.C0325ic;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Sb;
/* loaded from: classes5.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Sb sb, C0325ic c0325ic) {
        this.f1413a = new L6(str, sb, c0325ic);
    }

    public UserProfileUpdate<? extends Ho> withDelta(double d) {
        return new UserProfileUpdate<>(new C0267g6(this.f1413a.c, d));
    }
}
