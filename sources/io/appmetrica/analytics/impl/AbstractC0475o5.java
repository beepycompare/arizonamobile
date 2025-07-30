package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0475o5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0574s5 f982a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0475o5(C0574s5 c0574s5) {
        this.f982a = c0574s5;
    }

    public final C0574s5 a() {
        return this.f982a;
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
