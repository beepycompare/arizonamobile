package ru.rustore.sdk.appupdate;

import android.content.ServiceConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutCancellationException;
import ru.rustore.sdk.core.exception.RuStoreConnectionTimeout;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1<TimeoutCancellationException, Exception> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f1328a;
    public final /* synthetic */ Ref.ObjectRef<ServiceConnection> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(j jVar, Ref.ObjectRef<ServiceConnection> objectRef) {
        super(1);
        this.f1328a = jVar;
        this.b = objectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Exception invoke(TimeoutCancellationException timeoutCancellationException) {
        TimeoutCancellationException it = timeoutCancellationException;
        Intrinsics.checkNotNullParameter(it, "it");
        ContextExtKt.unbindServiceSafely(this.f1328a.f1351a, this.b.element);
        return new RuStoreConnectionTimeout();
    }
}
