package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0334j0 {

    /* renamed from: a  reason: collision with root package name */
    public Mc f942a;
    public long b;
    public boolean c;
    public final C0656vl d;

    public C0334j0(String str, long j, C0656vl c0656vl) {
        this.b = j;
        try {
            this.f942a = new Mc(str);
        } catch (Throwable unused) {
            this.f942a = new Mc();
        }
        this.d = c0656vl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f942a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f942a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0309i0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0309i0(AbstractC0447nb.b(this.f942a), this.b);
    }
}
