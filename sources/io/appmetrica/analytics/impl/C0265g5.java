package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* renamed from: io.appmetrica.analytics.impl.g5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0265g5 implements Bo {

    /* renamed from: a  reason: collision with root package name */
    public final List f1011a;

    public C0265g5(List<? extends Pair<String, ? extends Bo>> list) {
        this.f1011a = list;
    }

    @Override // io.appmetrica.analytics.impl.Bo
    public final String a() {
        for (Pair pair : this.f1011a) {
            String a2 = ((Bo) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Bo
    public final void a(String str) {
        for (Pair pair : this.f1011a) {
            ((Bo) pair.getSecond()).a(str);
        }
    }
}
