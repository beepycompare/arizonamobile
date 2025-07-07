package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0481o5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0580s5 f967a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0481o5(C0580s5 c0580s5) {
        this.f967a = c0580s5;
    }

    public final C0580s5 a() {
        return this.f967a;
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
