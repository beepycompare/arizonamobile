package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.i8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0330i8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f897a;
    public final ProtobufStateStorage b;
    public final AbstractC0379k8 c;
    public final Yn d;
    public final Jm e;
    public final InterfaceC0316hj f;
    public final InterfaceC0265fj g;
    public final U6 h;
    public InterfaceC0354j8 i;

    public AbstractC0330i8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0379k8 abstractC0379k8, Yn yn, Jm jm, InterfaceC0316hj interfaceC0316hj, InterfaceC0265fj interfaceC0265fj, U6 u6, InterfaceC0354j8 interfaceC0354j8) {
        this.f897a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0379k8;
        this.d = yn;
        this.e = jm;
        this.f = interfaceC0316hj;
        this.g = interfaceC0265fj;
        this.h = u6;
        this.i = interfaceC0354j8;
    }

    public final synchronized InterfaceC0354j8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0429m8 interfaceC0429m8) {
        boolean z = false;
        if (interfaceC0429m8.a() == EnumC0404l8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0429m8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0429m8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0429m8, this.i.b())) {
            z = true;
        } else {
            interfaceC0429m8 = (InterfaceC0429m8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0354j8 interfaceC0354j8 = this.i;
            InterfaceC0354j8 interfaceC0354j82 = (InterfaceC0354j8) this.e.invoke(interfaceC0429m8, list);
            this.i = interfaceC0354j82;
            this.b.save(interfaceC0354j82);
            AbstractC0589sj.a("Update distribution data: %s -> %s", interfaceC0354j8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0429m8 c() {
        if (!this.g.a()) {
            InterfaceC0429m8 interfaceC0429m8 = (InterfaceC0429m8) this.f.invoke();
            this.g.b();
            if (interfaceC0429m8 != null) {
                b(interfaceC0429m8);
            }
        }
        return (InterfaceC0429m8) this.i.b();
    }

    public final InterfaceC0429m8 a(InterfaceC0429m8 interfaceC0429m8) {
        InterfaceC0429m8 c;
        this.h.a(this.f897a);
        synchronized (this) {
            b(interfaceC0429m8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0429m8 b() {
        this.h.a(this.f897a);
        return c();
    }
}
