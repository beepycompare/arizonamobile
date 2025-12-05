package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* renamed from: io.appmetrica.analytics.impl.h5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0287h5 implements Co {

    /* renamed from: a  reason: collision with root package name */
    public final List f1000a;

    public C0287h5(List<? extends Pair<String, ? extends Co>> list) {
        this.f1000a = list;
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final String a() {
        for (Pair pair : this.f1000a) {
            String a2 = ((Co) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final void a(String str) {
        for (Pair pair : this.f1000a) {
            ((Co) pair.getSecond()).a(str);
        }
    }
}
