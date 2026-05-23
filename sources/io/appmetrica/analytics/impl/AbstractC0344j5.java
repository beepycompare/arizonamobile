package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0344j5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f1045a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0344j5(C0448n5 c0448n5) {
        this.f1045a = c0448n5;
    }

    public final C0448n5 a() {
        return this.f1045a;
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
