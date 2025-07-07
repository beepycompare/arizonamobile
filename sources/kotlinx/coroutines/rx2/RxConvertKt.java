package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.reactive.ReactiveFlowKt;
/* compiled from: RxConvert.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a&\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\u0006\u0010\u0003\u001a\u00020\u0004\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010\u0003\u001a\u00020\u0004\u001a \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\u000e\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0010\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0012\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0010\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a1\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0012\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0015\u001a1\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0010\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0015¨\u0006\u0017"}, d2 = {"asCompletable", "Lio/reactivex/Completable;", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "asMaybe", "Lio/reactivex/Maybe;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "asSingle", "Lio/reactivex/Single;", "", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "Lio/reactivex/ObservableSource;", "asObservable", "Lio/reactivex/Observable;", "asFlowable", "Lio/reactivex/Flowable;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "_asFlowable", "from", "_asObservable", "kotlinx-coroutines-rx2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxConvertKt {
    public static final Completable asCompletable(Job job, CoroutineContext coroutineContext) {
        return RxCompletableKt.rxCompletable(coroutineContext, new RxConvertKt$asCompletable$1(job, null));
    }

    public static final <T> Maybe<T> asMaybe(Deferred<? extends T> deferred, CoroutineContext coroutineContext) {
        return RxMaybeKt.rxMaybe(coroutineContext, new RxConvertKt$asMaybe$1(deferred, null));
    }

    public static final <T> Single<T> asSingle(Deferred<? extends T> deferred, CoroutineContext coroutineContext) {
        return RxSingleKt.rxSingle(coroutineContext, new RxConvertKt$asSingle$1(deferred, null));
    }

    public static final <T> Flow<T> asFlow(ObservableSource<T> observableSource) {
        return FlowKt.callbackFlow(new RxConvertKt$asFlow$1(observableSource, null));
    }

    public static final <T> Observable<T> asObservable(final Flow<? extends T> flow, final CoroutineContext coroutineContext) {
        return Observable.create(new ObservableOnSubscribe() { // from class: kotlinx.coroutines.rx2.RxConvertKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RxConvertKt.asObservable$lambda$0(CoroutineContext.this, flow, observableEmitter);
            }
        });
    }

    public static /* synthetic */ Observable asObservable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asObservable$lambda$0(CoroutineContext coroutineContext, Flow flow, ObservableEmitter observableEmitter) {
        observableEmitter.setCancellable(new RxCancellable(BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), CoroutineStart.ATOMIC, new RxConvertKt$asObservable$1$job$1(flow, observableEmitter, null))));
    }

    public static /* synthetic */ Flowable asFlowable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    public static final <T> Flowable<T> asFlowable(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        return Flowable.fromPublisher(ReactiveFlowKt.asPublisher(flow, coroutineContext));
    }

    public static /* synthetic */ Flowable from$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    /* renamed from: from$default  reason: collision with other method in class */
    public static /* synthetic */ Observable m10040from$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }
}
