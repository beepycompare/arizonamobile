package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.f8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0252f8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f834a;
    public final ProtobufStateStorage b;
    public final AbstractC0302h8 c;
    public final Vn d;
    public final Gm e;
    public final InterfaceC0238ej f;
    public final InterfaceC0187cj g;
    public final R6 h;
    public InterfaceC0277g8 i;

    public AbstractC0252f8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0302h8 abstractC0302h8, Vn vn, Gm gm, InterfaceC0238ej interfaceC0238ej, InterfaceC0187cj interfaceC0187cj, R6 r6, InterfaceC0277g8 interfaceC0277g8) {
        this.f834a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0302h8;
        this.d = vn;
        this.e = gm;
        this.f = interfaceC0238ej;
        this.g = interfaceC0187cj;
        this.h = r6;
        this.i = interfaceC0277g8;
    }

    public final synchronized InterfaceC0277g8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0351j8 interfaceC0351j8) {
        boolean z = false;
        if (interfaceC0351j8.a() == EnumC0327i8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0351j8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0351j8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0351j8, this.i.b())) {
            z = true;
        } else {
            interfaceC0351j8 = (InterfaceC0351j8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0277g8 interfaceC0277g8 = this.i;
            InterfaceC0277g8 interfaceC0277g82 = (InterfaceC0277g8) this.e.invoke(interfaceC0351j8, list);
            this.i = interfaceC0277g82;
            this.b.save(interfaceC0277g82);
            AbstractC0512pj.a("Update distribution data: %s -> %s", interfaceC0277g8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0351j8 c() {
        if (!this.g.a()) {
            InterfaceC0351j8 interfaceC0351j8 = (InterfaceC0351j8) this.f.invoke();
            this.g.b();
            if (interfaceC0351j8 != null) {
                b(interfaceC0351j8);
            }
        }
        return (InterfaceC0351j8) this.i.b();
    }

    public final InterfaceC0351j8 a(InterfaceC0351j8 interfaceC0351j8) {
        InterfaceC0351j8 c;
        this.h.a(this.f834a);
        synchronized (this) {
            b(interfaceC0351j8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0351j8 b() {
        this.h.a(this.f834a);
        return c();
    }
}
