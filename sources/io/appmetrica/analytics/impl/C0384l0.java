package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.l0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0384l0 {

    /* renamed from: a  reason: collision with root package name */
    public C0268gd f1077a;
    public long b;
    public boolean c;
    public final Wl d;

    public C0384l0(String str, long j, Wl wl) {
        this.b = j;
        try {
            this.f1077a = new C0268gd(str);
        } catch (Throwable unused) {
            this.f1077a = new C0268gd();
        }
        this.d = wl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f1077a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f1077a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0358k0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0358k0(Ib.b(this.f1077a), this.b);
    }
}
