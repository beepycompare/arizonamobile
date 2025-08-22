package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* loaded from: classes4.dex */
public final class B5 implements Do {

    /* renamed from: a  reason: collision with root package name */
    public final List f357a;

    public B5(List<? extends Pair<String, ? extends Do>> list) {
        this.f357a = list;
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final String a() {
        for (Pair pair : this.f357a) {
            String a2 = ((Do) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final void a(String str) {
        for (Pair pair : this.f357a) {
            ((Do) pair.getSecond()).a(str);
        }
    }
}
