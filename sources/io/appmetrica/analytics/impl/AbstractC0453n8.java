package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.n8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0453n8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f998a;
    public final ProtobufStateStorage b;
    public final AbstractC0505p8 c;
    public final InterfaceC0314ho d;
    public final Sm e;
    public final InterfaceC0541qj f;
    public final InterfaceC0490oj g;
    public final Y6 h;
    public InterfaceC0479o8 i;

    public AbstractC0453n8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0505p8 abstractC0505p8, InterfaceC0314ho interfaceC0314ho, Sm sm, InterfaceC0541qj interfaceC0541qj, InterfaceC0490oj interfaceC0490oj, Y6 y6, InterfaceC0479o8 interfaceC0479o8) {
        this.f998a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0505p8;
        this.d = interfaceC0314ho;
        this.e = sm;
        this.f = interfaceC0541qj;
        this.g = interfaceC0490oj;
        this.h = y6;
        this.i = interfaceC0479o8;
    }

    public final synchronized InterfaceC0479o8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0554r8 interfaceC0554r8) {
        boolean z = false;
        if (interfaceC0554r8.a() == EnumC0530q8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0554r8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0554r8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0554r8, this.i.b())) {
            z = true;
        } else {
            interfaceC0554r8 = (InterfaceC0554r8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0479o8 interfaceC0479o8 = this.i;
            InterfaceC0479o8 interfaceC0479o82 = (InterfaceC0479o8) this.e.invoke(interfaceC0554r8, list);
            this.i = interfaceC0479o82;
            this.b.save(interfaceC0479o82);
            Bj.a("Update distribution data: %s -> %s", interfaceC0479o8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0554r8 c() {
        if (!this.g.a()) {
            InterfaceC0554r8 interfaceC0554r8 = (InterfaceC0554r8) this.f.invoke();
            this.g.b();
            if (interfaceC0554r8 != null) {
                b(interfaceC0554r8);
            }
        }
        return (InterfaceC0554r8) this.i.b();
    }

    public final InterfaceC0554r8 a(InterfaceC0554r8 interfaceC0554r8) {
        InterfaceC0554r8 c;
        this.h.a(this.f998a);
        synchronized (this) {
            b(interfaceC0554r8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0554r8 b() {
        this.h.a(this.f998a);
        return c();
    }
}
