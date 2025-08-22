package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.k8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0375k8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f935a;
    public final ProtobufStateStorage b;
    public final AbstractC0426m8 c;
    public final Cdo d;
    public final Om e;
    public final InterfaceC0437mj f;
    public final InterfaceC0386kj g;
    public final V6 h;
    public InterfaceC0401l8 i;

    public AbstractC0375k8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0426m8 abstractC0426m8, Cdo cdo, Om om, InterfaceC0437mj interfaceC0437mj, InterfaceC0386kj interfaceC0386kj, V6 v6, InterfaceC0401l8 interfaceC0401l8) {
        this.f935a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0426m8;
        this.d = cdo;
        this.e = om;
        this.f = interfaceC0437mj;
        this.g = interfaceC0386kj;
        this.h = v6;
        this.i = interfaceC0401l8;
    }

    public final synchronized InterfaceC0401l8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0476o8 interfaceC0476o8) {
        boolean z = false;
        if (interfaceC0476o8.a() == EnumC0451n8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0476o8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0476o8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0476o8, this.i.b())) {
            z = true;
        } else {
            interfaceC0476o8 = (InterfaceC0476o8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0401l8 interfaceC0401l8 = this.i;
            InterfaceC0401l8 interfaceC0401l82 = (InterfaceC0401l8) this.e.invoke(interfaceC0476o8, list);
            this.i = interfaceC0401l82;
            this.b.save(interfaceC0401l82);
            AbstractC0711xj.a("Update distribution data: %s -> %s", interfaceC0401l8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0476o8 c() {
        if (!this.g.a()) {
            InterfaceC0476o8 interfaceC0476o8 = (InterfaceC0476o8) this.f.invoke();
            this.g.b();
            if (interfaceC0476o8 != null) {
                b(interfaceC0476o8);
            }
        }
        return (InterfaceC0476o8) this.i.b();
    }

    public final InterfaceC0476o8 a(InterfaceC0476o8 interfaceC0476o8) {
        InterfaceC0476o8 c;
        this.h.a(this.f935a);
        synchronized (this) {
            b(interfaceC0476o8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0476o8 b() {
        this.h.a(this.f935a);
        return c();
    }
}
