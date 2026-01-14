package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class T4 {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f794a;
    public final String b = "[ComponentMigrationToV113]";

    public T4(X4 x4) {
        this.f794a = x4;
    }

    public final X4 a() {
        return this.f794a;
    }

    public final String b() {
        return this.b;
    }

    public abstract boolean b(int i);

    public abstract void c();

    public final void a(int i) {
        if (b(i)) {
            c();
        }
    }
}
