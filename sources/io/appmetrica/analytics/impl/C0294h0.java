package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0294h0 {

    /* renamed from: a  reason: collision with root package name */
    public Yc f860a;
    public long b;
    public boolean c;
    public final C0489ol d;

    public C0294h0(String str, long j, C0489ol c0489ol) {
        this.b = j;
        try {
            this.f860a = new Yc(str);
        } catch (Throwable unused) {
            this.f860a = new Yc();
        }
        this.d = c0489ol;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f860a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f860a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0269g0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0269g0(AbstractC0753zb.b(this.f860a), this.b);
    }
}
