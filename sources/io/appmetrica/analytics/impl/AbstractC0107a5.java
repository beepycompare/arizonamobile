package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.a5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0107a5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f797a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC0107a5(C0210e5 c0210e5) {
        this.f797a = c0210e5;
    }

    public final C0210e5 a() {
        return this.f797a;
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
