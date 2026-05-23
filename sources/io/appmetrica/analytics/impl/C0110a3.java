package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.a3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0110a3 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0136b3 f879a;

    public C0110a3(C0136b3 c0136b3) {
        this.f879a = c0136b3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f879a) {
            C0136b3 c0136b3 = this.f879a;
            c0136b3.b = intent;
            Iterator it = c0136b3.f898a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
