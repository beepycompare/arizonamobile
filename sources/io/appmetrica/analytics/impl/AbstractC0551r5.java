package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.r5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0551r5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0651v5 f1061a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0551r5(C0651v5 c0651v5) {
        this.f1061a = c0651v5;
    }

    public final C0651v5 a() {
        return this.f1061a;
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
