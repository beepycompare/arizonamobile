package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0308hm implements InterfaceC0385km {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0256fm f1038a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0385km
    public final void a(C0256fm c0256fm) {
        this.f1038a = c0256fm;
        for (InterfaceC0385km interfaceC0385km : this.b) {
            interfaceC0385km.a(c0256fm);
        }
    }

    public final C0256fm b() {
        C0256fm c0256fm = this.f1038a;
        if (c0256fm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0256fm;
    }

    public final void b(InterfaceC0385km interfaceC0385km) {
        this.b.remove(interfaceC0385km);
    }

    public final void a(InterfaceC0385km interfaceC0385km) {
        this.b.add(interfaceC0385km);
        if (this.f1038a != null) {
            C0256fm c0256fm = this.f1038a;
            if (c0256fm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0256fm = null;
            }
            interfaceC0385km.a(c0256fm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> create = ((Rm) Pm.a(C0359jm.class)).create(context);
        wo a2 = C0448na.k().D().a();
        synchronized (a2) {
            optStringOrNull = JsonUtils.optStringOrNull(a2.f1298a.a(), "device_id");
        }
        a(new C0256fm(optStringOrNull, a2.a(), (C0359jm) create.read()));
    }
}
