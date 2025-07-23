package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.i8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0329i8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f897a;
    public final ProtobufStateStorage b;
    public final AbstractC0378k8 c;
    public final Yn d;
    public final Jm e;
    public final InterfaceC0315hj f;
    public final InterfaceC0264fj g;
    public final U6 h;
    public InterfaceC0353j8 i;

    public AbstractC0329i8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0378k8 abstractC0378k8, Yn yn, Jm jm, InterfaceC0315hj interfaceC0315hj, InterfaceC0264fj interfaceC0264fj, U6 u6, InterfaceC0353j8 interfaceC0353j8) {
        this.f897a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0378k8;
        this.d = yn;
        this.e = jm;
        this.f = interfaceC0315hj;
        this.g = interfaceC0264fj;
        this.h = u6;
        this.i = interfaceC0353j8;
    }

    public final synchronized InterfaceC0353j8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0428m8 interfaceC0428m8) {
        boolean z = false;
        if (interfaceC0428m8.a() == EnumC0403l8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0428m8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0428m8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0428m8, this.i.b())) {
            z = true;
        } else {
            interfaceC0428m8 = (InterfaceC0428m8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0353j8 interfaceC0353j8 = this.i;
            InterfaceC0353j8 interfaceC0353j82 = (InterfaceC0353j8) this.e.invoke(interfaceC0428m8, list);
            this.i = interfaceC0353j82;
            this.b.save(interfaceC0353j82);
            AbstractC0588sj.a("Update distribution data: %s -> %s", interfaceC0353j8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0428m8 c() {
        if (!this.g.a()) {
            InterfaceC0428m8 interfaceC0428m8 = (InterfaceC0428m8) this.f.invoke();
            this.g.b();
            if (interfaceC0428m8 != null) {
                b(interfaceC0428m8);
            }
        }
        return (InterfaceC0428m8) this.i.b();
    }

    public final InterfaceC0428m8 a(InterfaceC0428m8 interfaceC0428m8) {
        InterfaceC0428m8 c;
        this.h.a(this.f897a);
        synchronized (this) {
            b(interfaceC0428m8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0428m8 b() {
        this.h.a(this.f897a);
        return c();
    }
}
