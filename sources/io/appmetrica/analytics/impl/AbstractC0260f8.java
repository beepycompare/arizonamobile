package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.f8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0260f8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f833a;
    public final ProtobufStateStorage b;
    public final AbstractC0310h8 c;
    public final Vn d;
    public final Gm e;
    public final InterfaceC0246ej f;
    public final InterfaceC0195cj g;
    public final R6 h;
    public InterfaceC0285g8 i;

    public AbstractC0260f8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0310h8 abstractC0310h8, Vn vn, Gm gm, InterfaceC0246ej interfaceC0246ej, InterfaceC0195cj interfaceC0195cj, R6 r6, InterfaceC0285g8 interfaceC0285g8) {
        this.f833a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0310h8;
        this.d = vn;
        this.e = gm;
        this.f = interfaceC0246ej;
        this.g = interfaceC0195cj;
        this.h = r6;
        this.i = interfaceC0285g8;
    }

    public final synchronized InterfaceC0285g8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0359j8 interfaceC0359j8) {
        boolean z = false;
        if (interfaceC0359j8.a() == EnumC0335i8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0359j8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0359j8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0359j8, this.i.b())) {
            z = true;
        } else {
            interfaceC0359j8 = (InterfaceC0359j8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0285g8 interfaceC0285g8 = this.i;
            InterfaceC0285g8 interfaceC0285g82 = (InterfaceC0285g8) this.e.invoke(interfaceC0359j8, list);
            this.i = interfaceC0285g82;
            this.b.save(interfaceC0285g82);
            AbstractC0520pj.a("Update distribution data: %s -> %s", interfaceC0285g8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0359j8 c() {
        if (!this.g.a()) {
            InterfaceC0359j8 interfaceC0359j8 = (InterfaceC0359j8) this.f.invoke();
            this.g.b();
            if (interfaceC0359j8 != null) {
                b(interfaceC0359j8);
            }
        }
        return (InterfaceC0359j8) this.i.b();
    }

    public final InterfaceC0359j8 a(InterfaceC0359j8 interfaceC0359j8) {
        InterfaceC0359j8 c;
        this.h.a(this.f833a);
        synchronized (this) {
            b(interfaceC0359j8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0359j8 b() {
        this.h.a(this.f833a);
        return c();
    }
}
