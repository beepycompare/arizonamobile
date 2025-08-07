package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0297h0 {

    /* renamed from: a  reason: collision with root package name */
    public C0130ad f873a;
    public long b;
    public boolean c;
    public final C0566rl d;

    public C0297h0(String str, long j, C0566rl c0566rl) {
        this.b = j;
        try {
            this.f873a = new C0130ad(str);
        } catch (Throwable unused) {
            this.f873a = new C0130ad();
        }
        this.d = c0566rl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f873a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f873a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0272g0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0272g0(Bb.b(this.f873a), this.b);
    }
}
