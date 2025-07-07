package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0302h0 {

    /* renamed from: a  reason: collision with root package name */
    public Yc f859a;
    public long b;
    public boolean c;
    public final C0497ol d;

    public C0302h0(String str, long j, C0497ol c0497ol) {
        this.b = j;
        try {
            this.f859a = new Yc(str);
        } catch (Throwable unused) {
            this.f859a = new Yc();
        }
        this.d = c0497ol;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f859a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f859a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0277g0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0277g0(AbstractC0761zb.b(this.f859a), this.b);
    }
}
