package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0334j0 {

    /* renamed from: a  reason: collision with root package name */
    public Gc f947a;
    public long b;
    public boolean c;
    public final C0581sl d;

    public C0334j0(String str, long j, C0581sl c0581sl) {
        this.b = j;
        try {
            this.f947a = new Gc(str);
        } catch (Throwable unused) {
            this.f947a = new Gc();
        }
        this.d = c0581sl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f947a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f947a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0309i0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0309i0(AbstractC0294hb.b(this.f947a), this.b);
    }
}
