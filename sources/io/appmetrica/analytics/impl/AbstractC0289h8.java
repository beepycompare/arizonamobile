package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.h8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0289h8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1014a;
    public final ProtobufStateStorage b;
    public final AbstractC0340j8 c;
    public final Do d;
    public final InterfaceC0381kn e;
    public final InterfaceC0662vj f;
    public final InterfaceC0610tj g;
    public final R6 h;
    public InterfaceC0315i8 i;

    public AbstractC0289h8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0340j8 abstractC0340j8, Do r4, InterfaceC0381kn interfaceC0381kn, InterfaceC0662vj interfaceC0662vj, InterfaceC0610tj interfaceC0610tj, R6 r6, InterfaceC0315i8 interfaceC0315i8) {
        this.f1014a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0340j8;
        this.d = r4;
        this.e = interfaceC0381kn;
        this.f = interfaceC0662vj;
        this.g = interfaceC0610tj;
        this.h = r6;
        this.i = interfaceC0315i8;
    }

    public final synchronized InterfaceC0315i8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0418m8 interfaceC0418m8) {
        boolean z = false;
        if (interfaceC0418m8.a() == EnumC0392l8.c) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0418m8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0418m8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0418m8, this.i.b())) {
            z = true;
        } else {
            interfaceC0418m8 = (InterfaceC0418m8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0315i8 interfaceC0315i8 = this.i;
            InterfaceC0315i8 interfaceC0315i82 = (InterfaceC0315i8) this.e.invoke(interfaceC0418m8, list);
            this.i = interfaceC0315i82;
            this.b.save(interfaceC0315i82);
            Gj.a("Update distribution data: %s -> %s", interfaceC0315i8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0418m8 c() {
        if (!this.g.a()) {
            InterfaceC0418m8 interfaceC0418m8 = (InterfaceC0418m8) this.f.invoke();
            this.g.b();
            if (interfaceC0418m8 != null) {
                b(interfaceC0418m8);
            }
        }
        return (InterfaceC0418m8) this.i.b();
    }

    public final InterfaceC0418m8 a(InterfaceC0418m8 interfaceC0418m8) {
        InterfaceC0418m8 c;
        this.h.a(this.f1014a);
        synchronized (this) {
            b(interfaceC0418m8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0418m8 b() {
        this.h.a(this.f1014a);
        return c();
    }
}
