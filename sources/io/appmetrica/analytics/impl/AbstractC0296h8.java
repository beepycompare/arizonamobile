package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.h8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0296h8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1009a;
    public final ProtobufStateStorage b;
    public final AbstractC0347j8 c;
    public final Do d;
    public final InterfaceC0388kn e;
    public final InterfaceC0669vj f;
    public final InterfaceC0617tj g;
    public final R6 h;
    public InterfaceC0322i8 i;

    public AbstractC0296h8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0347j8 abstractC0347j8, Do r4, InterfaceC0388kn interfaceC0388kn, InterfaceC0669vj interfaceC0669vj, InterfaceC0617tj interfaceC0617tj, R6 r6, InterfaceC0322i8 interfaceC0322i8) {
        this.f1009a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0347j8;
        this.d = r4;
        this.e = interfaceC0388kn;
        this.f = interfaceC0669vj;
        this.g = interfaceC0617tj;
        this.h = r6;
        this.i = interfaceC0322i8;
    }

    public final synchronized InterfaceC0322i8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0425m8 interfaceC0425m8) {
        boolean z = false;
        if (interfaceC0425m8.a() == EnumC0399l8.c) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0425m8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0425m8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0425m8, this.i.b())) {
            z = true;
        } else {
            interfaceC0425m8 = (InterfaceC0425m8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0322i8 interfaceC0322i8 = this.i;
            InterfaceC0322i8 interfaceC0322i82 = (InterfaceC0322i8) this.e.invoke(interfaceC0425m8, list);
            this.i = interfaceC0322i82;
            this.b.save(interfaceC0322i82);
            Gj.a("Update distribution data: %s -> %s", interfaceC0322i8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0425m8 c() {
        if (!this.g.a()) {
            InterfaceC0425m8 interfaceC0425m8 = (InterfaceC0425m8) this.f.invoke();
            this.g.b();
            if (interfaceC0425m8 != null) {
                b(interfaceC0425m8);
            }
        }
        return (InterfaceC0425m8) this.i.b();
    }

    public final InterfaceC0425m8 a(InterfaceC0425m8 interfaceC0425m8) {
        InterfaceC0425m8 c;
        this.h.a(this.f1009a);
        synchronized (this) {
            b(interfaceC0425m8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0425m8 b() {
        this.h.a(this.f1009a);
        return c();
    }
}
