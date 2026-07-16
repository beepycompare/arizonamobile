package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.mo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0441mo implements InterfaceC0152bj {

    /* renamed from: a  reason: collision with root package name */
    public final int f1103a;
    public final int b;
    public int c = 0;

    public C0441mo(int i, int i2) {
        this.f1103a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f1103a;
    }

    public final void c() {
        this.c = 0;
    }
}
