package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class V2 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ W2 f727a;

    public V2(W2 w2) {
        this.f727a = w2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f727a) {
            W2 w2 = this.f727a;
            w2.b = intent;
            Iterator it = w2.f740a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
