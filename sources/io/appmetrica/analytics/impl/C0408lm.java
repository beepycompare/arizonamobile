package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.lm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0408lm implements InterfaceC0483om {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0356jm f995a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0483om
    public final void a(C0356jm c0356jm) {
        this.f995a = c0356jm;
        for (InterfaceC0483om interfaceC0483om : this.b) {
            interfaceC0483om.a(c0356jm);
        }
    }

    public final C0356jm b() {
        C0356jm c0356jm = this.f995a;
        if (c0356jm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0356jm;
    }

    public final void b(InterfaceC0483om interfaceC0483om) {
        this.b.remove(interfaceC0483om);
    }

    public final void a(InterfaceC0483om interfaceC0483om) {
        this.b.add(interfaceC0483om);
        if (this.f995a != null) {
            C0356jm c0356jm = this.f995a;
            if (c0356jm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0356jm = null;
            }
            interfaceC0483om.a(c0356jm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> create = ((Vm) Tm.a(C0458nm.class)).create(context);
        yo a2 = C0620ua.k().D().a();
        synchronized (a2) {
            optStringOrNull = JsonUtils.optStringOrNull(a2.f1220a.a(), "device_id");
        }
        a(new C0356jm(optStringOrNull, a2.a(), (C0458nm) create.read()));
    }
}
