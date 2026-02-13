package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0309hm implements InterfaceC0386km {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0257fm f1033a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0386km
    public final void a(C0257fm c0257fm) {
        this.f1033a = c0257fm;
        for (InterfaceC0386km interfaceC0386km : this.b) {
            interfaceC0386km.a(c0257fm);
        }
    }

    public final C0257fm b() {
        C0257fm c0257fm = this.f1033a;
        if (c0257fm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0257fm;
    }

    public final void b(InterfaceC0386km interfaceC0386km) {
        this.b.remove(interfaceC0386km);
    }

    public final void a(InterfaceC0386km interfaceC0386km) {
        this.b.add(interfaceC0386km);
        if (this.f1033a != null) {
            C0257fm c0257fm = this.f1033a;
            if (c0257fm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0257fm = null;
            }
            interfaceC0386km.a(c0257fm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> create = ((Rm) Pm.a(C0360jm.class)).create(context);
        wo a2 = C0449na.k().D().a();
        synchronized (a2) {
            optStringOrNull = JsonUtils.optStringOrNull(a2.f1293a.a(), "device_id");
        }
        a(new C0257fm(optStringOrNull, a2.a(), (C0360jm) create.read()));
    }
}
