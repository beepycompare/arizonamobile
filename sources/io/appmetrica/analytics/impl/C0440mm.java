package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.mm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0440mm implements InterfaceC0515pm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0389km f973a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0515pm
    public final void a(C0389km c0389km) {
        this.f973a = c0389km;
        for (InterfaceC0515pm interfaceC0515pm : this.b) {
            interfaceC0515pm.a(c0389km);
        }
    }

    public final C0389km b() {
        C0389km c0389km = this.f973a;
        if (c0389km == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0389km;
    }

    public final void b(InterfaceC0515pm interfaceC0515pm) {
        this.b.remove(interfaceC0515pm);
    }

    public final void a(InterfaceC0515pm interfaceC0515pm) {
        this.b.add(interfaceC0515pm);
        if (this.f973a != null) {
            C0389km c0389km = this.f973a;
            if (c0389km == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0389km = null;
            }
            interfaceC0515pm.a(c0389km);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Vm.a(C0490om.class).a(context);
        yo a3 = Ka.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f1167a.a(), "device_id");
        }
        a(new C0389km(optStringOrNull, a3.a(), (C0490om) a2.read()));
    }
}
