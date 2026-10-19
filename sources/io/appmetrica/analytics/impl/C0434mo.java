package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.mo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0434mo implements InterfaceC0145bj {

    /* renamed from: a  reason: collision with root package name */
    public final int f1106a;
    public final int b;
    public int c = 0;

    public C0434mo(int i, int i2) {
        this.f1106a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f1106a;
    }

    public final void c() {
        this.c = 0;
    }
}
