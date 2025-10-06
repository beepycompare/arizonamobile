package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0317i0 {

    /* renamed from: a  reason: collision with root package name */
    public C0252fd f915a;
    public long b;
    public boolean c;
    public final Al d;

    public C0317i0(String str, long j, Al al) {
        this.b = j;
        try {
            this.f915a = new C0252fd(str);
        } catch (Throwable unused) {
            this.f915a = new C0252fd();
        }
        this.d = al;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f915a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f915a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0291h0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0291h0(Gb.b(this.f915a), this.b);
    }
}
