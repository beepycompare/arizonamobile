package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
/* compiled from: SuspendingPagingSourceFactory.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B)\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0096\u0082\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/paging/SuspendingPagingSourceFactory;", "Key", "", "Value", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "delegate", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;)V", "create", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SuspendingPagingSourceFactory<Key, Value> implements Function0<PagingSource<Key, Value>> {
    private final Function0<PagingSource<Key, Value>> delegate;
    private final CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public SuspendingPagingSourceFactory(CoroutineDispatcher dispatcher, Function0<? extends PagingSource<Key, Value>> delegate) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.dispatcher = dispatcher;
        this.delegate = delegate;
    }

    public final Object create(Continuation<? super PagingSource<Key, Value>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new SuspendingPagingSourceFactory$create$2(this, null), continuation);
    }

    @Override // kotlin.jvm.functions.Function0
    public PagingSource<Key, Value> invoke() {
        return this.delegate.invoke();
    }
}
