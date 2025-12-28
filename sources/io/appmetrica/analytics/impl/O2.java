package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class O2 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ P2 f712a;

    public O2(P2 p2) {
        this.f712a = p2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f712a) {
            P2 p2 = this.f712a;
            p2.b = intent;
            Iterator it = p2.f728a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
