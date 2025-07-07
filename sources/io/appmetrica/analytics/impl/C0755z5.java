package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* renamed from: io.appmetrica.analytics.impl.z5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0755z5 implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final List f1158a;

    public C0755z5(List<? extends Pair<String, ? extends vo>> list) {
        this.f1158a = list;
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final String a() {
        for (Pair pair : this.f1158a) {
            String a2 = ((vo) pair.getSecond()).a();
            if (a2 != null && a2.length() > 0) {
                return a2;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final void a(String str) {
        for (Pair pair : this.f1158a) {
            ((vo) pair.getSecond()).a(str);
        }
    }
}
