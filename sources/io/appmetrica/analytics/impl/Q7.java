package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class Q7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f649a;
    public final ProtobufStateStorage b;
    public final S7 c;
    public final InterfaceC0178co d;
    public final Jm e;
    public final Vi f;
    public final Ti g;
    public final A6 h;
    public R7 i;

    public Q7(Context context, ProtobufStateStorage protobufStateStorage, S7 s7, InterfaceC0178co interfaceC0178co, Jm jm, Vi vi, Ti ti, A6 a6, R7 r7) {
        this.f649a = context;
        this.b = protobufStateStorage;
        this.c = s7;
        this.d = interfaceC0178co;
        this.e = jm;
        this.f = vi;
        this.g = ti;
        this.h = a6;
        this.i = r7;
    }

    public final synchronized R7 a() {
        return this.i;
    }

    public final synchronized boolean b(U7 u7) {
        boolean z = false;
        if (u7.a() == T7.b) {
            return false;
        }
        if (Intrinsics.areEqual(u7, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), u7);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(u7, this.i.b())) {
            z = true;
        } else {
            u7 = (U7) this.i.b();
        }
        if (z || z2) {
            R7 r7 = this.i;
            R7 r72 = (R7) this.e.invoke(u7, list);
            this.i = r72;
            this.b.save(r72);
            AbstractC0276gj.a("Update distribution data: %s -> %s", r7, this.i);
        }
        return z;
    }

    public final synchronized U7 c() {
        if (!this.g.a()) {
            U7 u7 = (U7) this.f.invoke();
            this.g.b();
            if (u7 != null) {
                b(u7);
            }
        }
        return (U7) this.i.b();
    }

    public final U7 a(U7 u7) {
        U7 c;
        this.h.a(this.f649a);
        synchronized (this) {
            b(u7);
            c = c();
        }
        return c;
    }

    public final U7 b() {
        this.h.a(this.f649a);
        return c();
    }
}
