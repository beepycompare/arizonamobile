package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.qm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0544qm implements InterfaceC0618tm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0493om f1055a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0618tm
    public final void a(C0493om c0493om) {
        this.f1055a = c0493om;
        for (InterfaceC0618tm interfaceC0618tm : this.b) {
            interfaceC0618tm.a(c0493om);
        }
    }

    public final C0493om b() {
        C0493om c0493om = this.f1055a;
        if (c0493om == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0493om;
    }

    public final void b(InterfaceC0618tm interfaceC0618tm) {
        this.b.remove(interfaceC0618tm);
    }

    public final void a(InterfaceC0618tm interfaceC0618tm) {
        this.b.add(interfaceC0618tm);
        if (this.f1055a != null) {
            C0493om c0493om = this.f1055a;
            if (c0493om == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0493om = null;
            }
            interfaceC0618tm.a(c0493om);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Zm.a(C0593sm.class).a(context);
        Co a3 = Na.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f397a.a(), "device_id");
        }
        a(new C0493om(optStringOrNull, a3.a(), (C0593sm) a2.read()));
    }
}
