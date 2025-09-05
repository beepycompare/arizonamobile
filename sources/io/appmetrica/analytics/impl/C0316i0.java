package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0316i0 {

    /* renamed from: a  reason: collision with root package name */
    public C0251fd f910a;
    public long b;
    public boolean c;
    public final Al d;

    public C0316i0(String str, long j, Al al) {
        this.b = j;
        try {
            this.f910a = new C0251fd(str);
        } catch (Throwable unused) {
            this.f910a = new C0251fd();
        }
        this.d = al;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f910a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f910a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0290h0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0290h0(Gb.b(this.f910a), this.b);
    }
}
