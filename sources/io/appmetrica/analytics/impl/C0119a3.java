package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.a3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0119a3 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0145b3 f750a;

    public C0119a3(C0145b3 c0145b3) {
        this.f750a = c0145b3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f750a) {
            C0145b3 c0145b3 = this.f750a;
            c0145b3.b = intent;
            Iterator it = c0145b3.f765a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
