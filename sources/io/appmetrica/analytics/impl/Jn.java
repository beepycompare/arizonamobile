package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public class Jn implements Gi {

    /* renamed from: a  reason: collision with root package name */
    public final int f649a;
    public final int b;
    public int c = 0;

    public Jn(int i, int i2) {
        this.f649a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f649a;
    }

    public final void c() {
        this.c = 0;
    }
}
