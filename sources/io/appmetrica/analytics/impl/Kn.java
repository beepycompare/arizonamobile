package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public class Kn implements Hi {

    /* renamed from: a  reason: collision with root package name */
    public final int f643a;
    public final int b;
    public int c = 0;

    public Kn(int i, int i2) {
        this.f643a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f643a;
    }

    public final void c() {
        this.c = 0;
    }
}
