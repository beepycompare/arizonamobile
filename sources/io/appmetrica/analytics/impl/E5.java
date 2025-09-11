package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* loaded from: classes4.dex */
public final class E5 implements Ho {

    /* renamed from: a  reason: collision with root package name */
    public final List f422a;

    public E5(List<? extends Pair<String, ? extends Ho>> list) {
        this.f422a = list;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final String a() {
        for (Pair pair : this.f422a) {
            String a2 = ((Ho) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(String str) {
        for (Pair pair : this.f422a) {
            ((Ho) pair.getSecond()).a(str);
        }
    }
}
