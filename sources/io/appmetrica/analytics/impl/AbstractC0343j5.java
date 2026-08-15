package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0343j5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n5 f1048a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0343j5(C0447n5 c0447n5) {
        this.f1048a = c0447n5;
    }

    public final C0447n5 a() {
        return this.f1048a;
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
