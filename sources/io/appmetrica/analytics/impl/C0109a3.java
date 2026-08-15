package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.a3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0109a3 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0135b3 f882a;

    public C0109a3(C0135b3 c0135b3) {
        this.f882a = c0135b3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Context context = (Context) obj;
        Intent intent = (Intent) obj2;
        synchronized (this.f882a) {
            C0135b3 c0135b3 = this.f882a;
            c0135b3.b = intent;
            Iterator it = c0135b3.f901a.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(intent);
            }
        }
    }
}
