package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0296h0 {

    /* renamed from: a  reason: collision with root package name */
    public C0129ad f874a;
    public long b;
    public boolean c;
    public final C0565rl d;

    public C0296h0(String str, long j, C0565rl c0565rl) {
        this.b = j;
        try {
            this.f874a = new C0129ad(str);
        } catch (Throwable unused) {
            this.f874a = new C0129ad();
        }
        this.d = c0565rl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f874a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f874a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0271g0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0271g0(Bb.b(this.f874a), this.b);
    }
}
