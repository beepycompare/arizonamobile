package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0319hm implements InterfaceC0393km {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0268fm f890a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0393km
    public final void a(C0268fm c0268fm) {
        this.f890a = c0268fm;
        for (InterfaceC0393km interfaceC0393km : this.b) {
            interfaceC0393km.a(c0268fm);
        }
    }

    public final C0268fm b() {
        C0268fm c0268fm = this.f890a;
        if (c0268fm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0268fm;
    }

    public final void b(InterfaceC0393km interfaceC0393km) {
        this.b.remove(interfaceC0393km);
    }

    public final void a(InterfaceC0393km interfaceC0393km) {
        this.b.add(interfaceC0393km);
        if (this.f890a != null) {
            C0268fm c0268fm = this.f890a;
            if (c0268fm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0268fm = null;
            }
            interfaceC0393km.a(c0268fm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Qm.a(C0368jm.class).a(context);
        to a3 = Ia.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f1073a.a(), "device_id");
        }
        a(new C0268fm(optStringOrNull, a3.a(), (C0368jm) a2.read()));
    }
}
