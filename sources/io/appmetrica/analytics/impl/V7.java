package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public abstract class V7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f730a;
    public final ProtobufStateStorage b;
    public final X7 c;
    public final Cdo d;
    public final Mm e;
    public final Zi f;
    public final Xi g;
    public final G6 h;
    public W7 i;

    public V7(Context context, ProtobufStateStorage protobufStateStorage, X7 x7, Cdo cdo, Mm mm, Zi zi, Xi xi, G6 g6, W7 w7) {
        this.f730a = context;
        this.b = protobufStateStorage;
        this.c = x7;
        this.d = cdo;
        this.e = mm;
        this.f = zi;
        this.g = xi;
        this.h = g6;
        this.i = w7;
    }

    public final synchronized W7 a() {
        return this.i;
    }

    public final synchronized boolean b(Z7 z7) {
        boolean z = false;
        if (z7.a() == Y7.b) {
            return false;
        }
        if (Intrinsics.areEqual(z7, this.i.b())) {
            return false;
        }
        List list = (List) this.d.invoke(this.i.a(), z7);
        boolean z2 = list != null;
        if (list == null) {
            list = this.i.a();
        }
        if (this.c.a(z7, this.i.b())) {
            z = true;
        } else {
            z7 = (Z7) this.i.b();
        }
        if (z || z2) {
            W7 w7 = this.i;
            W7 w72 = (W7) this.e.invoke(z7, list);
            this.i = w72;
            this.b.save(w72);
            AbstractC0379kj.a("Update distribution data: %s -> %s", w7, this.i);
        }
        return z;
    }

    public final synchronized Z7 c() {
        if (!this.g.a()) {
            Z7 z7 = (Z7) this.f.invoke();
            this.g.b();
            if (z7 != null) {
                b(z7);
            }
        }
        return (Z7) this.i.b();
    }

    public final Z7 a(Z7 z7) {
        Z7 c;
        this.h.a(this.f730a);
        synchronized (this) {
            b(z7);
            c = c();
        }
        return c;
    }

    public final Z7 b() {
        this.h.a(this.f730a);
        return c();
    }
}
