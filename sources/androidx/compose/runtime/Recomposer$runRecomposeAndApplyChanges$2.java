package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {598, TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 1)
/* loaded from: classes.dex */
public final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0130  */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0110 -> B:24:0x0118). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0127 -> B:12:0x00b5). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MonotonicFrameClock monotonicFrameClock;
        MutableScatterSet mutableScatterSetOf;
        MutableScatterSet mutableScatterSetOf2;
        ArrayList arrayList;
        Set set;
        ArrayList arrayList2;
        MutableScatterSet mutableScatterSet;
        ArrayList arrayList3;
        MutableScatterSet mutableScatterSet2;
        final ArrayList arrayList4;
        final MutableScatterSet mutableScatterSet3;
        final ArrayList arrayList5;
        final ArrayList arrayList6;
        final MutableScatterSet mutableScatterSet4;
        boolean recordComposerModifications;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        NextFrameEndCallbackQueue nextFrameEndCallbackQueue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            monotonicFrameClock = (MonotonicFrameClock) this.L$0;
            mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            MutableScatterSet mutableScatterSetOf3 = ScatterSetKt.mutableScatterSetOf();
            MutableScatterSet mutableScatterSet5 = new MutableScatterSet(0, 1, null);
            Set wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet5);
            mutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
            arrayList = new ArrayList();
            set = wrapIntoSet;
            arrayList2 = new ArrayList();
            mutableScatterSet = mutableScatterSet5;
            arrayList3 = new ArrayList();
            mutableScatterSet2 = mutableScatterSetOf3;
            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
            }
        } else if (i == 1) {
            set = (Set) this.L$7;
            mutableScatterSet = (MutableScatterSet) this.L$6;
            mutableScatterSet2 = (MutableScatterSet) this.L$5;
            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) this.L$4;
            ResultKt.throwOnFailure(obj);
            mutableScatterSet4 = (MutableScatterSet) this.L$8;
            monotonicFrameClock = (MonotonicFrameClock) this.L$0;
            arrayList4 = (List) this.L$3;
            arrayList6 = (List) this.L$1;
            mutableScatterSet3 = mutableScatterSet6;
            arrayList5 = (List) this.L$2;
            final Set set2 = set;
            final MutableScatterSet mutableScatterSet7 = mutableScatterSet2;
            final MutableScatterSet mutableScatterSet8 = mutableScatterSet;
            recordComposerModifications = this.this$0.recordComposerModifications();
            if (recordComposerModifications) {
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            set = (Set) this.L$7;
            mutableScatterSet = (MutableScatterSet) this.L$6;
            mutableScatterSet2 = (MutableScatterSet) this.L$5;
            mutableScatterSetOf = (MutableScatterSet) this.L$4;
            MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutableScatterSetOf2 = (MutableScatterSet) this.L$8;
            monotonicFrameClock = monotonicFrameClock2;
            ArrayList arrayList7 = (List) this.L$3;
            ArrayList arrayList8 = (List) this.L$2;
            ArrayList arrayList9 = (List) this.L$1;
            this.this$0.discardUnusedMovableContentState();
            nextFrameEndCallbackQueue = this.this$0.nextFrameEndCallbackQueue;
            nextFrameEndCallbackQueue.markFrameComplete();
            arrayList3 = arrayList7;
            arrayList2 = arrayList8;
            arrayList = arrayList9;
            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
                this.L$0 = monotonicFrameClock;
                this.L$1 = arrayList;
                this.L$2 = arrayList2;
                this.L$3 = arrayList3;
                this.L$4 = mutableScatterSetOf;
                this.L$5 = mutableScatterSet2;
                this.L$6 = mutableScatterSet;
                this.L$7 = set;
                this.L$8 = mutableScatterSetOf2;
                this.label = 1;
                awaitWorkAvailable = this.this$0.awaitWorkAvailable(this);
                if (awaitWorkAvailable != coroutine_suspended) {
                    ArrayList arrayList10 = arrayList;
                    mutableScatterSet3 = mutableScatterSetOf;
                    mutableScatterSet4 = mutableScatterSetOf2;
                    arrayList4 = arrayList3;
                    arrayList6 = arrayList10;
                    arrayList5 = arrayList2;
                    final Set set22 = set;
                    final MutableScatterSet mutableScatterSet72 = mutableScatterSet2;
                    final MutableScatterSet mutableScatterSet82 = mutableScatterSet;
                    recordComposerModifications = this.this$0.recordComposerModifications();
                    if (recordComposerModifications) {
                        ArrayList arrayList11 = arrayList4;
                        mutableScatterSetOf2 = mutableScatterSet4;
                        mutableScatterSetOf = mutableScatterSet3;
                        arrayList = arrayList6;
                        arrayList3 = arrayList11;
                        mutableScatterSet = mutableScatterSet82;
                        mutableScatterSet2 = mutableScatterSet72;
                        set = set22;
                        arrayList2 = arrayList5;
                        shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
                        if (!shouldKeepRecomposing) {
                        }
                    } else {
                        final Recomposer recomposer = this.this$0;
                        this.L$0 = monotonicFrameClock;
                        this.L$1 = arrayList6;
                        this.L$2 = arrayList5;
                        this.L$3 = arrayList4;
                        this.L$4 = mutableScatterSet3;
                        this.L$5 = mutableScatterSet72;
                        this.L$6 = mutableScatterSet82;
                        this.L$7 = set22;
                        this.L$8 = mutableScatterSet4;
                        this.label = 2;
                        if (monotonicFrameClock.withFrameNanos(new Function1() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$lambda$2(Recomposer.this, mutableScatterSet82, mutableScatterSet4, arrayList6, arrayList5, mutableScatterSet3, arrayList4, mutableScatterSet72, set22, ((Long) obj2).longValue());
                            }
                        }, this) != coroutine_suspended) {
                            ArrayList arrayList12 = arrayList4;
                            mutableScatterSetOf2 = mutableScatterSet4;
                            mutableScatterSetOf = mutableScatterSet3;
                            arrayList9 = arrayList6;
                            arrayList7 = arrayList12;
                            mutableScatterSet = mutableScatterSet82;
                            mutableScatterSet2 = mutableScatterSet72;
                            set = set22;
                            arrayList8 = arrayList5;
                            this.this$0.discardUnusedMovableContentState();
                            nextFrameEndCallbackQueue = this.this$0.nextFrameEndCallbackQueue;
                            nextFrameEndCallbackQueue.markFrameComplete();
                            arrayList3 = arrayList7;
                            arrayList2 = arrayList8;
                            arrayList = arrayList9;
                            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
                            if (!shouldKeepRecomposing) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
        }
    }

    private static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
        long j;
        synchronized (recomposer.stateLock) {
            list.clear();
            list2.clear();
            int size = list3.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = list3.get(i);
                controlledComposition.abandonChanges();
                recomposer.recordFailedCompositionLocked(controlledComposition);
            }
            list3.clear();
            MutableScatterSet<ControlledComposition> mutableScatterSet5 = mutableScatterSet;
            Object[] objArr = mutableScatterSet5.elements;
            long[] jArr = mutableScatterSet5.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j2 = jArr[i2];
                    j = 255;
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        for (int i4 = 0; i4 < i3; i4++) {
                            if ((j2 & 255) < 128) {
                                ControlledComposition controlledComposition2 = (ControlledComposition) objArr[(i2 << 3) + i4];
                                controlledComposition2.abandonChanges();
                                recomposer.recordFailedCompositionLocked(controlledComposition2);
                            }
                            j2 >>= 8;
                        }
                        if (i3 != 8) {
                            break;
                        }
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            } else {
                j = 255;
            }
            mutableScatterSet.clear();
            MutableScatterSet<ControlledComposition> mutableScatterSet6 = mutableScatterSet2;
            Object[] objArr2 = mutableScatterSet6.elements;
            long[] jArr2 = mutableScatterSet6.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i5 = 0;
                while (true) {
                    long j3 = jArr2[i5];
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length2)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((j3 & j) < 128) {
                                ((ControlledComposition) objArr2[(i5 << 3) + i7]).changesApplied();
                            }
                            j3 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length2) {
                        break;
                    }
                    i5++;
                }
            }
            mutableScatterSet2.clear();
            mutableScatterSet3.clear();
            MutableScatterSet<ControlledComposition> mutableScatterSet7 = mutableScatterSet4;
            Object[] objArr3 = mutableScatterSet7.elements;
            long[] jArr3 = mutableScatterSet7.metadata;
            int length3 = jArr3.length - 2;
            if (length3 >= 0) {
                int i8 = 0;
                while (true) {
                    long j4 = jArr3[i8];
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8 - ((~(i8 - length3)) >>> 31);
                        for (int i10 = 0; i10 < i9; i10++) {
                            if ((j4 & j) < 128) {
                                ControlledComposition controlledComposition3 = (ControlledComposition) objArr3[(i8 << 3) + i10];
                                controlledComposition3.abandonChanges();
                                recomposer.recordFailedCompositionLocked(controlledComposition3);
                            }
                            j4 >>= 8;
                        }
                        if (i9 != 8) {
                            break;
                        }
                    }
                    if (i8 == length3) {
                        break;
                    }
                    i8++;
                }
            }
            mutableScatterSet4.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        List list2;
        List list3;
        list.clear();
        synchronized (recomposer.stateLock) {
            list2 = recomposer.movableContentAwaitingInsert;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                list.add((MovableContentStateReference) list2.get(i));
            }
            list3 = recomposer.movableContentAwaitingInsert;
            list3.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0331 A[Catch: all -> 0x034a, TRY_ENTER, TryCatch #4 {all -> 0x03a2, blocks: (B:11:0x0039, B:12:0x0040, B:17:0x0066, B:18:0x0067, B:19:0x006d, B:21:0x0078, B:24:0x0084, B:26:0x008e, B:114:0x0237, B:115:0x023e, B:117:0x0242, B:118:0x0243, B:27:0x009d, B:138:0x0299, B:140:0x02a2, B:167:0x032b, B:144:0x02b1, B:145:0x02b5, B:166:0x032a, B:28:0x00a6, B:113:0x0234, B:125:0x025f, B:126:0x0262, B:169:0x0331, B:170:0x0334, B:172:0x033d, B:32:0x00bd, B:34:0x00c7, B:35:0x00d3, B:37:0x00dd, B:146:0x02b6, B:148:0x02c4, B:150:0x02d0, B:152:0x02d8, B:154:0x02e1, B:155:0x02e4, B:157:0x02f2, B:159:0x02fe, B:161:0x0304, B:164:0x0319, B:163:0x030f, B:165:0x031d, B:131:0x0272, B:133:0x027c, B:135:0x0288, B:136:0x0293, B:85:0x01b8, B:88:0x01c6, B:90:0x01d1, B:92:0x01db, B:94:0x01e1, B:116:0x023f, B:55:0x012a, B:57:0x0142, B:59:0x014f, B:61:0x0159, B:63:0x015f, B:13:0x0041, B:15:0x004f, B:16:0x005d), top: B:203:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0367  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit invokeSuspend$lambda$2(Recomposer recomposer, MutableScatterSet mutableScatterSet, MutableScatterSet mutableScatterSet2, List list, List list2, MutableScatterSet mutableScatterSet3, List list3, MutableScatterSet mutableScatterSet4, Set set, long j) {
        boolean hasBroadcastFrameClockAwaiters;
        boolean z;
        List performInsertValues;
        ControlledComposition performRecompose;
        char c;
        long j2;
        long j3;
        BroadcastFrameClock broadcastFrameClock;
        Recomposer recomposer2 = recomposer;
        List list4 = list3;
        MutableScatterSet mutableScatterSet5 = mutableScatterSet4;
        hasBroadcastFrameClockAwaiters = recomposer2.getHasBroadcastFrameClockAwaiters();
        if (hasBroadcastFrameClockAwaiters) {
            Object beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
            try {
                broadcastFrameClock = recomposer2.broadcastFrameClock;
                broadcastFrameClock.sendFrame(j);
                Snapshot.Companion.sendApplyNotifications();
                Unit unit = Unit.INSTANCE;
            } finally {
            }
        }
        Object beginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
        try {
            recomposer2.recordComposerModifications();
            synchronized (recomposer2.stateLock) {
                MutableVector mutableVector = recomposer2.compositionInvalidations;
                Object[] objArr = mutableVector.content;
                int size = mutableVector.getSize();
                z = 0;
                for (int i = 0; i < size; i++) {
                    list.add((ControlledComposition) objArr[i]);
                }
                recomposer2.compositionInvalidations.clear();
                Unit unit2 = Unit.INSTANCE;
            }
            mutableScatterSet.clear();
            mutableScatterSet2.clear();
            while (true) {
                if (list.isEmpty() && list2.isEmpty()) {
                    break;
                }
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ControlledComposition controlledComposition = (ControlledComposition) list.get(i2);
                    performRecompose = recomposer2.performRecompose(controlledComposition, mutableScatterSet);
                    if (performRecompose != null) {
                        list3.add(performRecompose);
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    mutableScatterSet2.add(controlledComposition);
                }
                list.clear();
                if (!mutableScatterSet.isNotEmpty() && recomposer2.compositionInvalidations.getSize() == 0) {
                    if (list.isEmpty()) {
                        recomposer2 = recomposer;
                    } else {
                        invokeSuspend$fillToInsert(list2, recomposer2);
                        while (!list2.isEmpty()) {
                            performInsertValues = recomposer2.performInsertValues(list2, mutableScatterSet);
                            mutableScatterSet3.plusAssign((Iterable) performInsertValues);
                            invokeSuspend$fillToInsert(list2, recomposer2);
                        }
                    }
                    list4 = list3;
                    mutableScatterSet5 = mutableScatterSet4;
                    z = 0;
                }
                synchronized (recomposer2.stateLock) {
                    List knownCompositionsLocked = recomposer2.knownCompositionsLocked();
                    int size3 = knownCompositionsLocked.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        ControlledComposition controlledComposition2 = (ControlledComposition) knownCompositionsLocked.get(i3);
                        if (!mutableScatterSet2.contains(controlledComposition2) && controlledComposition2.observesAnyOf(set)) {
                            list.add(controlledComposition2);
                        }
                    }
                    MutableVector mutableVector2 = recomposer2.compositionInvalidations;
                    int size4 = mutableVector2.getSize();
                    int i4 = 0;
                    for (int i5 = 0; i5 < size4; i5++) {
                        ControlledComposition controlledComposition3 = (ControlledComposition) mutableVector2.content[i5];
                        if (!mutableScatterSet2.contains(controlledComposition3) && !list.contains(controlledComposition3)) {
                            list.add(controlledComposition3);
                            i4++;
                        } else if (i4 > 0) {
                            mutableVector2.content[i5 - i4] = mutableVector2.content[i5];
                        }
                    }
                    int i6 = size4 - i4;
                    ArraysKt.fill(mutableVector2.content, (Object) null, i6, size4);
                    mutableVector2.setSize(i6);
                    Unit unit5 = Unit.INSTANCE;
                }
                if (list.isEmpty()) {
                }
                list4 = list3;
                mutableScatterSet5 = mutableScatterSet4;
                z = 0;
            }
            Snapshot current = Snapshot.Companion.getCurrent();
            TransparentObserverSnapshot transparentObserverMutableSnapshot = current instanceof MutableSnapshot ? new TransparentObserverMutableSnapshot((MutableSnapshot) current, null, null, true, false) : new TransparentObserverSnapshot(current, null, true, z);
            Snapshot makeCurrent = transparentObserverMutableSnapshot.makeCurrent();
            try {
                if (!list4.isEmpty()) {
                    recomposer2.changeCount = recomposer2.getChangeCount() + 1;
                    int size5 = list4.size();
                    for (int i7 = z; i7 < size5; i7++) {
                        mutableScatterSet5.add((ControlledComposition) list4.get(i7));
                    }
                    int size6 = list4.size();
                    for (int i8 = z; i8 < size6; i8++) {
                        ((ControlledComposition) list4.get(i8)).applyChanges();
                    }
                    list4.clear();
                }
                if (mutableScatterSet3.isNotEmpty()) {
                    mutableScatterSet5.plusAssign((ScatterSet) mutableScatterSet3);
                    MutableScatterSet mutableScatterSet6 = mutableScatterSet3;
                    Object[] objArr2 = mutableScatterSet6.elements;
                    long[] jArr = mutableScatterSet6.metadata;
                    c = 7;
                    int length = jArr.length - 2;
                    j2 = 128;
                    int i9 = z;
                    if (length >= 0) {
                        while (true) {
                            long j4 = jArr[i9];
                            j3 = 255;
                            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i10 = 8 - ((~(i9 - length)) >>> 31);
                                for (int i11 = 0; i11 < i10; i11++) {
                                    if ((j4 & 255) < 128) {
                                        ((ControlledComposition) objArr2[(i9 << 3) + i11]).applyLateChanges();
                                    }
                                    j4 >>= 8;
                                }
                                if (i10 != 8) {
                                    break;
                                }
                            }
                            if (i9 == length) {
                                break;
                            }
                            i9++;
                        }
                    } else {
                        j3 = 255;
                    }
                    mutableScatterSet3.clear();
                } else {
                    c = 7;
                    j2 = 128;
                    j3 = 255;
                }
                if (mutableScatterSet4.isNotEmpty()) {
                    MutableScatterSet mutableScatterSet7 = mutableScatterSet4;
                    Object[] objArr3 = mutableScatterSet7.elements;
                    long[] jArr2 = mutableScatterSet7.metadata;
                    int length2 = jArr2.length - 2;
                    if (length2 >= 0) {
                        int i12 = 0;
                        while (true) {
                            long j5 = jArr2[i12];
                            if ((((~j5) << c) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                for (int i14 = 0; i14 < i13; i14++) {
                                    if ((j5 & j3) < j2) {
                                        ((ControlledComposition) objArr3[(i12 << 3) + i14]).changesApplied();
                                    }
                                    j5 >>= 8;
                                }
                                if (i13 != 8) {
                                    break;
                                }
                            }
                            if (i12 == length2) {
                                break;
                            }
                            i12++;
                        }
                    }
                    mutableScatterSet4.clear();
                }
                Unit unit6 = Unit.INSTANCE;
                transparentObserverMutableSnapshot.dispose();
                synchronized (recomposer.stateLock) {
                    recomposer.deriveStateLocked();
                }
                Snapshot.Companion.notifyObjectsInitialized();
                mutableScatterSet2.clear();
                mutableScatterSet.clear();
                recomposer.compositionsRemoved = null;
                Unit unit7 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection2);
                return Unit.INSTANCE;
            } finally {
                transparentObserverMutableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
        }
    }
}
