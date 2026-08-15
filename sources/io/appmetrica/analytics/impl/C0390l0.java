package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.l0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0390l0 {

    /* renamed from: a  reason: collision with root package name */
    public C0274gd f1074a;
    public long b;
    public boolean c;
    public final Wl d;

    public C0390l0(String str, long j, Wl wl) {
        this.b = j;
        try {
            this.f1074a = new C0274gd(str);
        } catch (Throwable unused) {
            this.f1074a = new C0274gd();
        }
        this.d = wl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f1074a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f1074a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0364k0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0364k0(Ib.b(this.f1074a), this.b);
    }
}
