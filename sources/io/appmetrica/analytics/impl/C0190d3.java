package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0190d3 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0215e3 f836a;

    public C0190d3(C0215e3 c0215e3) {
        this.f836a = c0215e3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f836a) {
            C0215e3 c0215e3 = this.f836a;
            c0215e3.b = intent;
            Iterator it = c0215e3.f856a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
