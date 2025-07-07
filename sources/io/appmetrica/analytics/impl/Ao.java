package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class Ao {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f343a = new ArrayList();
    public PublicLogger b;

    public final synchronized void a(Consumer consumer) {
        PublicLogger publicLogger = this.b;
        if (publicLogger == null) {
            this.f343a.add(consumer);
        } else {
            consumer.consume(publicLogger);
        }
    }
}
