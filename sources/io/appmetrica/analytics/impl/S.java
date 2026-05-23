package io.appmetrica.analytics.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class S extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ W f752a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(W w) {
        super(0);
        this.f752a = w;
    }

    public static final Void a(W w) {
        w.b();
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final FutureTask invoke() {
        final W w = this.f752a;
        return new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.S$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return S.a(W.this);
            }
        });
    }
}
