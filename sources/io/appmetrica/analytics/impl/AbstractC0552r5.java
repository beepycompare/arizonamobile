package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.r5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0552r5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0652v5 f1062a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0552r5(C0652v5 c0652v5) {
        this.f1062a = c0652v5;
    }

    public final C0652v5 a() {
        return this.f1062a;
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
