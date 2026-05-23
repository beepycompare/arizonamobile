package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.l0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0391l0 {

    /* renamed from: a  reason: collision with root package name */
    public C0275gd f1071a;
    public long b;
    public boolean c;
    public final Wl d;

    public C0391l0(String str, long j, Wl wl) {
        this.b = j;
        try {
            this.f1071a = new C0275gd(str);
        } catch (Throwable unused) {
            this.f1071a = new C0275gd();
        }
        this.d = wl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f1071a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f1071a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0365k0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0365k0(Ib.b(this.f1071a), this.b);
    }
}
