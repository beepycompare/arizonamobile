package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* renamed from: io.appmetrica.analytics.impl.n5  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0441n5 implements Do {

    /* renamed from: a  reason: collision with root package name */
    public final List f1019a;

    public C0441n5(List<? extends Pair<String, ? extends Do>> list) {
        this.f1019a = list;
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final String a() {
        for (Pair pair : this.f1019a) {
            String a2 = ((Do) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final void a(String str) {
        for (Pair pair : this.f1019a) {
            ((Do) pair.getSecond()).a(str);
        }
    }
}
