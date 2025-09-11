package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class Mo {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f584a = new ArrayList();
    public PublicLogger b;

    public final synchronized void a(Consumer consumer) {
        PublicLogger publicLogger = this.b;
        if (publicLogger == null) {
            this.f584a.add(consumer);
        } else {
            consumer.consume(publicLogger);
        }
    }
}
