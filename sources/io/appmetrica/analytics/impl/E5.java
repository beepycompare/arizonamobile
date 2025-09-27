package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* loaded from: classes4.dex */
public final class E5 implements Ho {

    /* renamed from: a  reason: collision with root package name */
    public final List f423a;

    public E5(List<? extends Pair<String, ? extends Ho>> list) {
        this.f423a = list;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final String a() {
        for (Pair pair : this.f423a) {
            String a2 = ((Ho) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(String str) {
        for (Pair pair : this.f423a) {
            ((Ho) pair.getSecond()).a(str);
        }
    }
}
