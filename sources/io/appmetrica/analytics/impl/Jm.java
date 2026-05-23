package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Jm implements Mm {

    /* renamed from: a  reason: collision with root package name */
    public volatile Hm f617a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Mm
    public final void a(Hm hm) {
        this.f617a = hm;
        for (Mm mm : this.b) {
            mm.a(hm);
        }
    }

    public final void b(Mm mm) {
        this.b.remove(mm);
    }

    public final Hm a() {
        Hm hm = this.f617a;
        if (hm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return hm;
    }

    public final void a(Mm mm) {
        this.b.add(mm);
        if (this.f617a != null) {
            Hm hm = this.f617a;
            if (hm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                hm = null;
            }
            mm.a(hm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> create = ((AbstractC0621tn) C0569rn.a(Lm.class)).create(context);
        Zo a2 = Na.k().D().a();
        synchronized (a2) {
            optStringOrNull = JsonUtils.optStringOrNull(a2.f875a.a(), "device_id");
        }
        a(new Hm(optStringOrNull, a2.a(), (Lm) create.read()));
    }
}
