package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0318hm implements InterfaceC0392km {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0267fm f890a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0392km
    public final void a(C0267fm c0267fm) {
        this.f890a = c0267fm;
        for (InterfaceC0392km interfaceC0392km : this.b) {
            interfaceC0392km.a(c0267fm);
        }
    }

    public final C0267fm b() {
        C0267fm c0267fm = this.f890a;
        if (c0267fm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0267fm;
    }

    public final void b(InterfaceC0392km interfaceC0392km) {
        this.b.remove(interfaceC0392km);
    }

    public final void a(InterfaceC0392km interfaceC0392km) {
        this.b.add(interfaceC0392km);
        if (this.f890a != null) {
            C0267fm c0267fm = this.f890a;
            if (c0267fm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0267fm = null;
            }
            interfaceC0392km.a(c0267fm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Qm.a(C0367jm.class).a(context);
        to a3 = Ia.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f1073a.a(), "device_id");
        }
        a(new C0267fm(optStringOrNull, a3.a(), (C0367jm) a2.read()));
    }
}
