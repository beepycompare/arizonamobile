package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0249em implements InterfaceC0324hm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0198cm f825a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0324hm
    public final void a(C0198cm c0198cm) {
        this.f825a = c0198cm;
        for (InterfaceC0324hm interfaceC0324hm : this.b) {
            interfaceC0324hm.a(c0198cm);
        }
    }

    public final C0198cm b() {
        C0198cm c0198cm = this.f825a;
        if (c0198cm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0198cm;
    }

    public final void b(InterfaceC0324hm interfaceC0324hm) {
        this.b.remove(interfaceC0324hm);
    }

    public final void a(InterfaceC0324hm interfaceC0324hm) {
        this.b.add(interfaceC0324hm);
        if (this.f825a != null) {
            C0198cm c0198cm = this.f825a;
            if (c0198cm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0198cm = null;
            }
            interfaceC0324hm.a(c0198cm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Nm.a(C0299gm.class).a(context);
        qo a3 = Ga.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f1012a.a(), "device_id");
        }
        a(new C0198cm(optStringOrNull, a3.a(), (C0299gm) a2.read()));
    }
}
