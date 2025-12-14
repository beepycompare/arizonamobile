package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0333j0 {

    /* renamed from: a  reason: collision with root package name */
    public Gc f1044a;
    public long b;
    public boolean c;
    public final C0580sl d;

    public C0333j0(String str, long j, C0580sl c0580sl) {
        this.b = j;
        try {
            this.f1044a = new Gc(str);
        } catch (Throwable unused) {
            this.f1044a = new Gc();
        }
        this.d = c0580sl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f1044a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f1044a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0308i0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0308i0(AbstractC0293hb.b(this.f1044a), this.b);
    }
}
