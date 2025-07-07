package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SnapshotFlow.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {142, 146, 169}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes.dex */
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0138, code lost:
        if (r14 == r0) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec A[Catch: all -> 0x0052, TryCatch #3 {all -> 0x0052, blocks: (B:30:0x00e8, B:32:0x00ec, B:37:0x00f6, B:40:0x0104, B:44:0x011a, B:46:0x0123, B:13:0x004d, B:41:0x010f, B:43:0x0117, B:42:0x0113), top: B:68:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0104 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #3 {all -> 0x0052, blocks: (B:30:0x00e8, B:32:0x00ec, B:37:0x00f6, B:40:0x0104, B:44:0x011a, B:46:0x0123, B:13:0x004d, B:41:0x010f, B:43:0x0117, B:42:0x0113), top: B:68:0x004d }] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0146 -> B:26:0x00c7). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ObserverHandle observerHandle;
        FlowCollector flowCollector;
        final MutableScatterSet mutableScatterSet;
        Function1<Object, Unit> function1;
        final Channel Channel$default;
        ObserverHandle observerHandle2;
        FlowCollector flowCollector2;
        MutableScatterSet mutableScatterSet2;
        Function1<Object, Unit> function12;
        Channel channel;
        ?? r6;
        int i;
        Set set;
        T t;
        boolean intersects$SnapshotStateKt__SnapshotFlowKt;
        T t2;
        T t3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ?? r1 = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    mutableScatterSet = (MutableScatterSet) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                    t3 = r1;
                } else if (i2 == 2) {
                    i = this.I$0;
                    r6 = this.L$5;
                    observerHandle2 = (ObserverHandle) this.L$4;
                    channel = (Channel) this.L$3;
                    function12 = (Function1) this.L$2;
                    mutableScatterSet2 = (MutableScatterSet) this.L$1;
                    flowCollector2 = (FlowCollector) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        set = (Set) obj;
                        do {
                            if (i == 0) {
                                intersects$SnapshotStateKt__SnapshotFlowKt = SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(mutableScatterSet2, set);
                                if (!intersects$SnapshotStateKt__SnapshotFlowKt) {
                                    i = 0;
                                    set = (Set) ChannelResult.m9971getOrNullimpl(channel.mo9959tryReceivePtdJZtk());
                                }
                            }
                            i = 1;
                            set = (Set) ChannelResult.m9971getOrNullimpl(channel.mo9959tryReceivePtdJZtk());
                        } while (set != null);
                        if (i != 0) {
                            mutableScatterSet2.clear();
                            Snapshot takeSnapshot = Snapshot.Companion.takeSnapshot(function12);
                            Function0<T> function0 = this.$block;
                            Snapshot makeCurrent = takeSnapshot.makeCurrent();
                            T invoke = function0.invoke();
                            takeSnapshot.restoreCurrent(makeCurrent);
                            takeSnapshot.dispose();
                            if (!Intrinsics.areEqual(invoke, (Object) r6)) {
                                this.L$0 = flowCollector2;
                                this.L$1 = mutableScatterSet2;
                                this.L$2 = function12;
                                this.L$3 = channel;
                                this.L$4 = observerHandle2;
                                this.L$5 = invoke;
                                this.label = 3;
                                Object emit = flowCollector2.emit(invoke, this);
                                t = invoke;
                            }
                        }
                        t = r6;
                        observerHandle = observerHandle2;
                        Channel$default = channel;
                        function1 = function12;
                        mutableScatterSet = mutableScatterSet2;
                        flowCollector = flowCollector2;
                        t2 = t;
                    } catch (Throwable th) {
                        th = th;
                        observerHandle = observerHandle2;
                        observerHandle.dispose();
                        throw th;
                    }
                } else if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    mutableScatterSet = (MutableScatterSet) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                    t3 = (T) this.L$5;
                }
                ResultKt.throwOnFailure(obj);
                t2 = t3;
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                mutableScatterSet = new MutableScatterSet(0, 1, null);
                function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke2(obj2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj2) {
                        if (obj2 instanceof StateObjectImpl) {
                            ReaderKind.Companion companion = ReaderKind.Companion;
                            ((StateObjectImpl) obj2).m3653recordReadInh_f27i8$runtime_release(ReaderKind.m3640constructorimpl(4));
                        }
                        mutableScatterSet.add(obj2);
                    }
                };
                Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                observerHandle = Snapshot.Companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set2, Snapshot snapshot) {
                        invoke2(set2, snapshot);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Set<? extends Object> set2, Snapshot snapshot) {
                        if (!(set2 instanceof ScatterSetWrapper)) {
                            Set<? extends Object> set3 = set2;
                            if ((set3 instanceof Collection) && set3.isEmpty()) {
                                return;
                            }
                            for (Object obj2 : set3) {
                                if (obj2 instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion = ReaderKind.Companion;
                                    if (((StateObjectImpl) obj2).m3652isReadInh_f27i8$runtime_release(ReaderKind.m3640constructorimpl(4))) {
                                    }
                                }
                            }
                            return;
                        }
                        ScatterSet set$runtime_release = ((ScatterSetWrapper) set2).getSet$runtime_release();
                        Object[] objArr = set$runtime_release.elements;
                        long[] jArr = set$runtime_release.metadata;
                        int length = jArr.length - 2;
                        if (length < 0) {
                            return;
                        }
                        int i3 = 0;
                        loop0: while (true) {
                            long j = jArr[i3];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i4 = 8 - ((~(i3 - length)) >>> 31);
                                for (int i5 = 0; i5 < i4; i5++) {
                                    if ((255 & j) < 128) {
                                        Object obj3 = objArr[(i3 << 3) + i5];
                                        if (!(obj3 instanceof StateObjectImpl)) {
                                            break loop0;
                                        }
                                        ReaderKind.Companion companion2 = ReaderKind.Companion;
                                        if (((StateObjectImpl) obj3).m3652isReadInh_f27i8$runtime_release(ReaderKind.m3640constructorimpl(4))) {
                                            break loop0;
                                        }
                                    }
                                    j >>= 8;
                                }
                                if (i4 != 8) {
                                    return;
                                }
                            }
                            if (i3 == length) {
                                return;
                            }
                            i3++;
                        }
                        Channel$default.mo7544trySendJP2dKIU(set2);
                    }
                });
                Snapshot takeSnapshot2 = Snapshot.Companion.takeSnapshot(function1);
                Function0<T> function02 = this.$block;
                Snapshot makeCurrent2 = takeSnapshot2.makeCurrent();
                T invoke2 = function02.invoke();
                takeSnapshot2.restoreCurrent(makeCurrent2);
                takeSnapshot2.dispose();
                this.L$0 = flowCollector;
                this.L$1 = mutableScatterSet;
                this.L$2 = function1;
                this.L$3 = Channel$default;
                this.L$4 = observerHandle;
                this.L$5 = invoke2;
                this.label = 1;
                Object emit2 = flowCollector.emit(invoke2, this);
                t2 = invoke2;
                if (emit2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.L$0 = flowCollector;
            this.L$1 = mutableScatterSet;
            this.L$2 = function1;
            this.L$3 = Channel$default;
            this.L$4 = observerHandle;
            this.L$5 = t2;
            this.I$0 = 0;
            this.label = 2;
            obj = Channel$default.receive(this);
            if (obj != coroutine_suspended) {
                flowCollector2 = flowCollector;
                mutableScatterSet2 = mutableScatterSet;
                function12 = function1;
                channel = Channel$default;
                observerHandle2 = observerHandle;
                r6 = t2;
                i = 0;
                set = (Set) obj;
                do {
                    if (i == 0) {
                    }
                    i = 1;
                    set = (Set) ChannelResult.m9971getOrNullimpl(channel.mo9959tryReceivePtdJZtk());
                } while (set != null);
                if (i != 0) {
                }
                t = r6;
                observerHandle = observerHandle2;
                Channel$default = channel;
                function1 = function12;
                mutableScatterSet = mutableScatterSet2;
                flowCollector = flowCollector2;
                t2 = t;
                this.L$0 = flowCollector;
                this.L$1 = mutableScatterSet;
                this.L$2 = function1;
                this.L$3 = Channel$default;
                this.L$4 = observerHandle;
                this.L$5 = t2;
                this.I$0 = 0;
                this.label = 2;
                obj = Channel$default.receive(this);
                if (obj != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
