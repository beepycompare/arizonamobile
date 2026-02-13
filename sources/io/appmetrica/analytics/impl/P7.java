package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class P7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f737a;
    public final ProtobufStateStorage b;
    public final R7 c;
    public final InterfaceC0156bo d;
    public final Im e;
    public final Ui f;
    public final Si g;
    public final InterfaceC0744z6 h;
    public Q7 i;

    public P7(Context context, ProtobufStateStorage protobufStateStorage, R7 r7, InterfaceC0156bo interfaceC0156bo, Im im, Ui ui, Si si, InterfaceC0744z6 interfaceC0744z6, Q7 q7) {
        this.f737a = context;
        this.b = protobufStateStorage;
        this.c = r7;
        this.d = interfaceC0156bo;
        this.e = im;
        this.f = ui;
        this.g = si;
        this.h = interfaceC0744z6;
        this.i = q7;
    }

    public final synchronized Q7 a() {
        return this.i;
    }

    public final synchronized boolean b(T7 t7) {
        boolean z = false;
        if (t7.a() == S7.b) {
            return false;
        }
        if (Intrinsics.areEqual(t7, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), t7);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(t7, this.i.b())) {
            z = true;
        } else {
            t7 = (T7) this.i.b();
        }
        if (z || z2) {
            Q7 q7 = this.i;
            Q7 q72 = (Q7) this.e.invoke(t7, list);
            this.i = q72;
            this.b.save(q72);
            AbstractC0254fj.a("Update distribution data: %s -> %s", q7, this.i);
        }
        return z;
    }

    public final synchronized T7 c() {
        if (!this.g.a()) {
            T7 t7 = (T7) this.f.invoke();
            this.g.b();
            if (t7 != null) {
                b(t7);
            }
        }
        return (T7) this.i.b();
    }

    public final T7 a(T7 t7) {
        T7 c;
        this.h.a(this.f737a);
        synchronized (this) {
            b(t7);
            c = c();
        }
        return c;
    }

    public final T7 b() {
        this.h.a(this.f737a);
        return c();
    }
}
