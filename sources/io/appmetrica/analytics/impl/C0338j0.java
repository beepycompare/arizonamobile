package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0338j0 {

    /* renamed from: a  reason: collision with root package name */
    public Fc f1052a;
    public long b;
    public boolean c;
    public final C0559rl d;

    public C0338j0(String str, long j, C0559rl c0559rl) {
        this.b = j;
        try {
            this.f1052a = new Fc(str);
        } catch (Throwable unused) {
            this.f1052a = new Fc();
        }
        this.d = c0559rl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f1052a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f1052a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0313i0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0313i0(AbstractC0272gb.b(this.f1052a), this.b);
    }
}
