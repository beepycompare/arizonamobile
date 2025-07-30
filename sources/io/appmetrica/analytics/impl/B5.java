package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* loaded from: classes4.dex */
public final class B5 implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final List f352a;

    public B5(List<? extends Pair<String, ? extends yo>> list) {
        this.f352a = list;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final String a() {
        for (Pair pair : this.f352a) {
            String a2 = ((yo) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final void a(String str) {
        for (Pair pair : this.f352a) {
            ((yo) pair.getSecond()).a(str);
        }
    }
}
