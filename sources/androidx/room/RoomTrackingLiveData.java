package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.InvalidationTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: RoomTrackingLiveData.android.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001bH\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0000H¦@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002!\"¨\u0006#"}, d2 = {"Landroidx/room/RoomTrackingLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", TtmlNode.RUBY_CONTAINER, "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "tableNames", "", "", "<init>", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;Z[Ljava/lang/String;)V", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "observer", "Landroidx/room/InvalidationTracker$Observer;", "invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "computing", "registeredObserver", "launchContext", "Lkotlin/coroutines/CoroutineContext;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidated", "compute", "onActive", "onInactive", "Landroidx/room/RoomCallableTrackingLiveData;", "Landroidx/room/RoomLambdaTrackingLiveData;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RoomTrackingLiveData<T> extends LiveData<T> {
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final CoroutineContext launchContext;
    private final InvalidationTracker.Observer observer;
    private final AtomicBoolean registeredObserver;

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(roomDatabase, invalidationLiveDataContainer, z, strArr);
    }

    public abstract Object compute(Continuation<? super T> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, String[] strArr) {
        EmptyCoroutineContext emptyCoroutineContext;
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        if (!roomDatabase.inCompatibilityMode()) {
            emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        } else if (z) {
            emptyCoroutineContext = roomDatabase.getTransactionContext$room_runtime();
        } else {
            emptyCoroutineContext = roomDatabase.getQueryContext();
        }
        this.launchContext = emptyCoroutineContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[Catch: all -> 0x002d, Exception -> 0x002f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x0029, B:28:0x0061), top: B:45:0x0029, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #1 {all -> 0x002d, blocks: (B:12:0x0029, B:26:0x0059, B:28:0x0061, B:35:0x007a, B:32:0x006e, B:33:0x0077), top: B:45:0x0029, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0057 -> B:26:0x0059). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0089 -> B:40:0x008a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refresh(Continuation<? super Unit> continuation) {
        RoomTrackingLiveData$refresh$1 roomTrackingLiveData$refresh$1;
        int i;
        if (continuation instanceof RoomTrackingLiveData$refresh$1) {
            roomTrackingLiveData$refresh$1 = (RoomTrackingLiveData$refresh$1) continuation;
            if ((roomTrackingLiveData$refresh$1.label & Integer.MIN_VALUE) != 0) {
                roomTrackingLiveData$refresh$1.label -= Integer.MIN_VALUE;
                Object obj = roomTrackingLiveData$refresh$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = roomTrackingLiveData$refresh$1.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = roomTrackingLiveData$refresh$1.I$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                                while (this.invalid.compareAndSet(true, false)) {
                                    roomTrackingLiveData$refresh$1.I$0 = 1;
                                    roomTrackingLiveData$refresh$1.label = 1;
                                    obj = compute(roomTrackingLiveData$refresh$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i2 = 1;
                                }
                                if (i2 != 0) {
                                    postValue(obj);
                                }
                                if (i2 != 0 || !this.invalid.get()) {
                                    return Unit.INSTANCE;
                                }
                                if (!this.computing.compareAndSet(false, true)) {
                                    obj = null;
                                    i2 = 0;
                                    while (this.invalid.compareAndSet(true, false)) {
                                    }
                                    if (i2 != 0) {
                                    }
                                    if (i2 != 0) {
                                    }
                                    return Unit.INSTANCE;
                                }
                                i2 = 0;
                                if (i2 != 0) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e) {
                                throw new RuntimeException("Exception while computing database live data.", e);
                            }
                        } finally {
                            this.computing.set(false);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.registeredObserver.compareAndSet(false, true)) {
                    this.database.getInvalidationTracker().addWeakObserver(this.observer);
                }
                if (!this.computing.compareAndSet(false, true)) {
                }
            }
        }
        roomTrackingLiveData$refresh$1 = new RoomTrackingLiveData$refresh$1(this, continuation);
        Object obj2 = roomTrackingLiveData$refresh$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = roomTrackingLiveData$refresh$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidated() {
        boolean hasActiveObservers = hasActiveObservers();
        if (this.invalid.compareAndSet(false, true) && hasActiveObservers) {
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), this.launchContext, null, new RoomTrackingLiveData$invalidated$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), this.launchContext, null, new RoomTrackingLiveData$onActive$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }
}
