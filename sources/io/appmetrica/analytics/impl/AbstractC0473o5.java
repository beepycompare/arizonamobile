package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0473o5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f968a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0473o5(C0572s5 c0572s5) {
        this.f968a = c0572s5;
    }

    public final C0572s5 a() {
        return this.f968a;
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
