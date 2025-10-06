package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.qm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0545qm implements InterfaceC0619tm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0494om f1056a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0619tm
    public final void a(C0494om c0494om) {
        this.f1056a = c0494om;
        for (InterfaceC0619tm interfaceC0619tm : this.b) {
            interfaceC0619tm.a(c0494om);
        }
    }

    public final C0494om b() {
        C0494om c0494om = this.f1056a;
        if (c0494om == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0494om;
    }

    public final void b(InterfaceC0619tm interfaceC0619tm) {
        this.b.remove(interfaceC0619tm);
    }

    public final void a(InterfaceC0619tm interfaceC0619tm) {
        this.b.add(interfaceC0619tm);
        if (this.f1056a != null) {
            C0494om c0494om = this.f1056a;
            if (c0494om == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0494om = null;
            }
            interfaceC0619tm.a(c0494om);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Zm.a(C0594sm.class).a(context);
        Co a3 = Na.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f398a.a(), "device_id");
        }
        a(new C0494om(optStringOrNull, a3.a(), (C0594sm) a2.read()));
    }
}
