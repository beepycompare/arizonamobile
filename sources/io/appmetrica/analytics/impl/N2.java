package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class N2 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ O2 f702a;

    public N2(O2 o2) {
        this.f702a = o2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f702a) {
            O2 o2 = this.f702a;
            o2.b = intent;
            Iterator it = o2.f719a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
