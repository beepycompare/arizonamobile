package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.h8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0295h8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1011a;
    public final ProtobufStateStorage b;
    public final AbstractC0346j8 c;
    public final Do d;
    public final InterfaceC0387kn e;
    public final InterfaceC0668vj f;
    public final InterfaceC0616tj g;
    public final R6 h;
    public InterfaceC0321i8 i;

    public AbstractC0295h8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0346j8 abstractC0346j8, Do r4, InterfaceC0387kn interfaceC0387kn, InterfaceC0668vj interfaceC0668vj, InterfaceC0616tj interfaceC0616tj, R6 r6, InterfaceC0321i8 interfaceC0321i8) {
        this.f1011a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0346j8;
        this.d = r4;
        this.e = interfaceC0387kn;
        this.f = interfaceC0668vj;
        this.g = interfaceC0616tj;
        this.h = r6;
        this.i = interfaceC0321i8;
    }

    public final synchronized InterfaceC0321i8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0424m8 interfaceC0424m8) {
        boolean z = false;
        if (interfaceC0424m8.a() == EnumC0398l8.c) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0424m8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0424m8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0424m8, this.i.b())) {
            z = true;
        } else {
            interfaceC0424m8 = (InterfaceC0424m8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0321i8 interfaceC0321i8 = this.i;
            InterfaceC0321i8 interfaceC0321i82 = (InterfaceC0321i8) this.e.invoke(interfaceC0424m8, list);
            this.i = interfaceC0321i82;
            this.b.save(interfaceC0321i82);
            Gj.a("Update distribution data: %s -> %s", interfaceC0321i8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0424m8 c() {
        if (!this.g.a()) {
            InterfaceC0424m8 interfaceC0424m8 = (InterfaceC0424m8) this.f.invoke();
            this.g.b();
            if (interfaceC0424m8 != null) {
                b(interfaceC0424m8);
            }
        }
        return (InterfaceC0424m8) this.i.b();
    }

    public final InterfaceC0424m8 a(InterfaceC0424m8 interfaceC0424m8) {
        InterfaceC0424m8 c;
        this.h.a(this.f1011a);
        synchronized (this) {
            b(interfaceC0424m8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0424m8 b() {
        this.h.a(this.f1011a);
        return c();
    }
}
