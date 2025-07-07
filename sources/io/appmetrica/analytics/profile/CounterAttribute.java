package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0357j6;
import io.appmetrica.analytics.impl.Jb;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Yn;
import io.appmetrica.analytics.impl.Zb;
/* loaded from: classes4.dex */
public final class CounterAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CounterAttribute(String str, Jb jb, Zb zb) {
        this.f1253a = new L6(str, jb, zb);
    }

    public UserProfileUpdate<? extends Yn> withDelta(double d) {
        return new UserProfileUpdate<>(new C0357j6(this.f1253a.c, d));
    }
}
