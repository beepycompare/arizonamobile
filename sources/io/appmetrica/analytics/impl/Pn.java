package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Pn implements InterfaceC0181cj {

    /* renamed from: a  reason: collision with root package name */
    public final int f631a;
    public final int b;
    public int c = 0;

    public Pn(int i, int i2) {
        this.f631a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f631a;
    }

    public final void c() {
        this.c = 0;
    }
}
