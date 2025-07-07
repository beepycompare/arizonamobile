package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
/* compiled from: MultiInstanceInvalidationClient.android.kt */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u001d\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020$J'\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b0*2\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050,¢\u0006\u0002\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/room/MultiInstanceInvalidationClient;", "", "context", "Landroid/content/Context;", "name", "", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroidx/room/InvalidationTracker;)V", "getName", "()Ljava/lang/String;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "clientId", "", "invalidationService", "Landroidx/room/IMultiInstanceInvalidationService;", "invalidatedTables", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "observer", "androidx/room/MultiInstanceInvalidationClient$observer$1", "Landroidx/room/MultiInstanceInvalidationClient$observer$1;", "invalidationCallback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "serviceConnection", "Landroid/content/ServiceConnection;", "registerCallback", "", TtmlNode.START, "serviceIntent", "Landroid/content/Intent;", "stop", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "resolvedTableNames", "", "([Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private int clientId;
    private final CoroutineScope coroutineScope;
    private final MutableSharedFlow<Set<String>> invalidatedTables;
    private final IMultiInstanceInvalidationCallback invalidationCallback;
    private IMultiInstanceInvalidationService invalidationService;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    private final MultiInstanceInvalidationClient$observer$1 observer;
    private final ServiceConnection serviceConnection;
    private final AtomicBoolean stopped;

    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.room.MultiInstanceInvalidationClient$observer$1] */
    public MultiInstanceInvalidationClient(Context context, String name, InvalidationTracker invalidationTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(invalidationTracker, "invalidationTracker");
        this.name = name;
        this.invalidationTracker = invalidationTracker;
        this.appContext = context.getApplicationContext();
        this.coroutineScope = invalidationTracker.getDatabase$room_runtime_release().getCoroutineScope();
        this.stopped = new AtomicBoolean(true);
        this.invalidatedTables = SharedFlowKt.MutableSharedFlow(0, 0, BufferOverflow.SUSPEND);
        final String[] tableNames$room_runtime_release = invalidationTracker.getTableNames$room_runtime_release();
        this.observer = new InvalidationTracker.Observer(tableNames$room_runtime_release) { // from class: androidx.room.MultiInstanceInvalidationClient$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean isRemote$room_runtime_release() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> tables) {
                AtomicBoolean atomicBoolean;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService;
                int i;
                Intrinsics.checkNotNullParameter(tables, "tables");
                atomicBoolean = MultiInstanceInvalidationClient.this.stopped;
                if (atomicBoolean.get()) {
                    return;
                }
                try {
                    iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.invalidationService;
                    if (iMultiInstanceInvalidationService != null) {
                        i = MultiInstanceInvalidationClient.this.clientId;
                        iMultiInstanceInvalidationService.broadcastInvalidation(i, (String[]) tables.toArray(new String[0]));
                    }
                } catch (RemoteException e) {
                    Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
                }
            }
        };
        this.invalidationCallback = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] tables) {
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(tables, "tables");
                coroutineScope = MultiInstanceInvalidationClient.this.coroutineScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(tables, MultiInstanceInvalidationClient.this, null), 3, null);
            }
        };
        this.serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name2, IBinder service) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(service, "service");
                MultiInstanceInvalidationClient.this.invalidationService = IMultiInstanceInvalidationService.Stub.asInterface(service);
                MultiInstanceInvalidationClient.this.registerCallback();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name2) {
                Intrinsics.checkNotNullParameter(name2, "name");
                MultiInstanceInvalidationClient.this.invalidationService = null;
            }
        };
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerCallback() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
            if (iMultiInstanceInvalidationService != null) {
                this.clientId = iMultiInstanceInvalidationService.registerCallback(this.invalidationCallback, this.name);
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
        }
    }

    public final void start(Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        if (this.stopped.compareAndSet(true, false)) {
            this.appContext.bindService(serviceIntent, this.serviceConnection, 1);
            this.invalidationTracker.addRemoteObserver$room_runtime_release(this.observer);
        }
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(this.observer);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.invalidationCallback, this.clientId);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }

    public final Flow<Set<String>> createFlow(final String[] resolvedTableNames) {
        Intrinsics.checkNotNullParameter(resolvedTableNames, "resolvedTableNames");
        final MutableSharedFlow<Set<String>> mutableSharedFlow = this.invalidatedTables;
        return (Flow) new Flow<Set<? extends String>>() { // from class: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String[] $resolvedTableNames$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", i = {}, l = {239}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String[] strArr) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$resolvedTableNames$inlined = strArr;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    String[] strArr;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Set<String> set = (Set) obj;
                                Set createSetBuilder = SetsKt.createSetBuilder();
                                for (String str : this.$resolvedTableNames$inlined) {
                                    for (String str2 : set) {
                                        if (StringsKt.equals(str, str2, true)) {
                                            createSetBuilder.add(str);
                                        }
                                    }
                                }
                                Set build = SetsKt.build(createSetBuilder);
                                if (build.isEmpty()) {
                                    build = null;
                                }
                                if (build != null) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(build, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Set<? extends String>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, resolvedTableNames), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
