package io.appmetrica.analytics.impl;

import android.util.Pair;
/* renamed from: io.appmetrica.analytics.impl.h0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0290h0 {

    /* renamed from: a  reason: collision with root package name */
    public C0174cd f877a;
    public long b;
    public boolean c;
    public final C0688wl d;

    public C0290h0(String str, long j, C0688wl c0688wl) {
        this.b = j;
        try {
            this.f877a = new C0174cd(str);
        } catch (Throwable unused) {
            this.f877a = new C0174cd();
        }
        this.d = c0688wl;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f877a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f877a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C0264g0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C0264g0(Db.b(this.f877a), this.b);
    }
}
