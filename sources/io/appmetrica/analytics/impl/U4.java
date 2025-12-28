package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f803a;
    public final String b = "[ComponentMigrationToV113]";

    public U4(Y4 y4) {
        this.f803a = y4;
    }

    public final Y4 a() {
        return this.f803a;
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
