package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.n8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0454n8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1003a;
    public final ProtobufStateStorage b;
    public final AbstractC0506p8 c;
    public final InterfaceC0315ho d;
    public final Sm e;
    public final InterfaceC0542qj f;
    public final InterfaceC0491oj g;
    public final Y6 h;
    public InterfaceC0480o8 i;

    public AbstractC0454n8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0506p8 abstractC0506p8, InterfaceC0315ho interfaceC0315ho, Sm sm, InterfaceC0542qj interfaceC0542qj, InterfaceC0491oj interfaceC0491oj, Y6 y6, InterfaceC0480o8 interfaceC0480o8) {
        this.f1003a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0506p8;
        this.d = interfaceC0315ho;
        this.e = sm;
        this.f = interfaceC0542qj;
        this.g = interfaceC0491oj;
        this.h = y6;
        this.i = interfaceC0480o8;
    }

    public final synchronized InterfaceC0480o8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0555r8 interfaceC0555r8) {
        boolean z = false;
        if (interfaceC0555r8.a() == EnumC0531q8.b) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0555r8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0555r8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0555r8, this.i.b())) {
            z = true;
        } else {
            interfaceC0555r8 = (InterfaceC0555r8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0480o8 interfaceC0480o8 = this.i;
            InterfaceC0480o8 interfaceC0480o82 = (InterfaceC0480o8) this.e.invoke(interfaceC0555r8, list);
            this.i = interfaceC0480o82;
            this.b.save(interfaceC0480o82);
            Bj.a("Update distribution data: %s -> %s", interfaceC0480o8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0555r8 c() {
        if (!this.g.a()) {
            InterfaceC0555r8 interfaceC0555r8 = (InterfaceC0555r8) this.f.invoke();
            this.g.b();
            if (interfaceC0555r8 != null) {
                b(interfaceC0555r8);
            }
        }
        return (InterfaceC0555r8) this.i.b();
    }

    public final InterfaceC0555r8 a(InterfaceC0555r8 interfaceC0555r8) {
        InterfaceC0555r8 c;
        this.h.a(this.f1003a);
        synchronized (this) {
            b(interfaceC0555r8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0555r8 b() {
        this.h.a(this.f1003a);
        return c();
    }
}
