package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.h8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0294h8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1011a;
    public final ProtobufStateStorage b;
    public final AbstractC0345j8 c;
    public final Do d;
    public final InterfaceC0386kn e;
    public final InterfaceC0667vj f;
    public final InterfaceC0615tj g;
    public final R6 h;
    public InterfaceC0320i8 i;

    public AbstractC0294h8(Context context, ProtobufStateStorage protobufStateStorage, AbstractC0345j8 abstractC0345j8, Do r4, InterfaceC0386kn interfaceC0386kn, InterfaceC0667vj interfaceC0667vj, InterfaceC0615tj interfaceC0615tj, R6 r6, InterfaceC0320i8 interfaceC0320i8) {
        this.f1011a = context;
        this.b = protobufStateStorage;
        this.c = abstractC0345j8;
        this.d = r4;
        this.e = interfaceC0386kn;
        this.f = interfaceC0667vj;
        this.g = interfaceC0615tj;
        this.h = r6;
        this.i = interfaceC0320i8;
    }

    public final synchronized InterfaceC0320i8 a() {
        return this.i;
    }

    public final synchronized boolean b(InterfaceC0423m8 interfaceC0423m8) {
        boolean z = false;
        if (interfaceC0423m8.a() == EnumC0397l8.c) {
            return false;
        }
        if (Intrinsics.areEqual(interfaceC0423m8, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), interfaceC0423m8);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(interfaceC0423m8, this.i.b())) {
            z = true;
        } else {
            interfaceC0423m8 = (InterfaceC0423m8) this.i.b();
        }
        if (z || z2) {
            InterfaceC0320i8 interfaceC0320i8 = this.i;
            InterfaceC0320i8 interfaceC0320i82 = (InterfaceC0320i8) this.e.invoke(interfaceC0423m8, list);
            this.i = interfaceC0320i82;
            this.b.save(interfaceC0320i82);
            Gj.a("Update distribution data: %s -> %s", interfaceC0320i8, this.i);
        }
        return z;
    }

    public final synchronized InterfaceC0423m8 c() {
        if (!this.g.a()) {
            InterfaceC0423m8 interfaceC0423m8 = (InterfaceC0423m8) this.f.invoke();
            this.g.b();
            if (interfaceC0423m8 != null) {
                b(interfaceC0423m8);
            }
        }
        return (InterfaceC0423m8) this.i.b();
    }

    public final InterfaceC0423m8 a(InterfaceC0423m8 interfaceC0423m8) {
        InterfaceC0423m8 c;
        this.h.a(this.f1011a);
        synchronized (this) {
            b(interfaceC0423m8);
            c = c();
        }
        return c;
    }

    public final InterfaceC0423m8 b() {
        this.h.a(this.f1011a);
        return c();
    }
}
