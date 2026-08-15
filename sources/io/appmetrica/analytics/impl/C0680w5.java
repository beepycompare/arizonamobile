package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Pair;
/* renamed from: io.appmetrica.analytics.impl.w5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0680w5 implements ep {

    /* renamed from: a  reason: collision with root package name */
    public final List f1260a;

    public C0680w5(List<? extends Pair<String, ? extends ep>> list) {
        this.f1260a = list;
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a(String str) {
        for (Pair pair : this.f1260a) {
            ((ep) pair.getSecond()).a(str);
        }
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final String b() {
        for (Pair pair : this.f1260a) {
            String b = ((ep) pair.getSecond()).b();
            if (b != null && b.length() > 0) {
                return b;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void flushAsync() {
        for (Pair pair : this.f1260a) {
            ((ep) pair.getSecond()).flushAsync();
        }
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a() {
        for (Pair pair : this.f1260a) {
            ((ep) pair.getSecond()).a();
        }
    }
}
