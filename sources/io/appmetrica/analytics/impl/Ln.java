package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public class Ln implements Li {

    /* renamed from: a  reason: collision with root package name */
    public final int f581a;
    public final int b;
    public int c = 0;

    public Ln(int i, int i2) {
        this.f581a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f581a;
    }

    public final void c() {
        this.c = 0;
    }
}
