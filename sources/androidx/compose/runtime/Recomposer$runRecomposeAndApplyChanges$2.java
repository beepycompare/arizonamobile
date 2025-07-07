package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.Snapshot;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {580, 591}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
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
    /* JADX WARN: Removed duplicated region for block: B:25:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0129  */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0112 -> B:24:0x011a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0120 -> B:12:0x00b5). Please submit an issue!!! */
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
                        if (monotonicFrameClock.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke(l.longValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Removed duplicated region for block: B:171:0x02ee A[Catch: all -> 0x0307, TRY_ENTER, TryCatch #17 {all -> 0x0344, blocks: (B:11:0x004b, B:12:0x0052, B:17:0x007c, B:18:0x007d, B:19:0x0083, B:21:0x008c, B:24:0x0097, B:26:0x00a0, B:34:0x00d7, B:51:0x00ff, B:85:0x0183, B:89:0x018c, B:90:0x018f, B:76:0x0167, B:92:0x0194, B:111:0x01ec, B:125:0x020f, B:126:0x0213, B:128:0x0217, B:129:0x0218, B:140:0x0254, B:142:0x025d, B:169:0x02e8, B:146:0x026c, B:147:0x0270, B:168:0x02e7, B:148:0x0271, B:150:0x027f, B:152:0x028b, B:154:0x0291, B:155:0x0297, B:156:0x029a, B:158:0x02a6, B:160:0x02b2, B:162:0x02b8, B:166:0x02d3, B:165:0x02c7, B:167:0x02d8, B:13:0x0053, B:15:0x0060, B:16:0x0073, B:133:0x022e, B:135:0x0238, B:137:0x0244, B:138:0x024e, B:171:0x02ee, B:172:0x02f1, B:174:0x02fa, B:127:0x0214, B:94:0x019a, B:97:0x01a7, B:99:0x01b5, B:101:0x01c1, B:103:0x01c7, B:27:0x00ab, B:29:0x00b5, B:30:0x00c1, B:32:0x00cb), top: B:207:0x004b }] */
                            /* JADX WARN: Removed duplicated region for block: B:214:0x031a A[SYNTHETIC] */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke(long j) {
                                boolean hasBroadcastFrameClockAwaiters;
                                Object beginSection;
                                Set<? extends Object> set3;
                                Set<? extends Object> set4;
                                List performInsertValues;
                                ControlledComposition performRecompose;
                                MutableScatterSet<Object> mutableScatterSet9;
                                char c;
                                long j2;
                                BroadcastFrameClock broadcastFrameClock;
                                hasBroadcastFrameClockAwaiters = Recomposer.this.getHasBroadcastFrameClockAwaiters();
                                if (hasBroadcastFrameClockAwaiters) {
                                    Recomposer recomposer2 = Recomposer.this;
                                    beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
                                    try {
                                        broadcastFrameClock = recomposer2.broadcastFrameClock;
                                        broadcastFrameClock.sendFrame(j);
                                        Snapshot.Companion.sendApplyNotifications();
                                        Unit unit = Unit.INSTANCE;
                                    } finally {
                                    }
                                }
                                Recomposer recomposer3 = Recomposer.this;
                                MutableScatterSet<Object> mutableScatterSet10 = mutableScatterSet82;
                                MutableScatterSet<ControlledComposition> mutableScatterSet11 = mutableScatterSet4;
                                List<ControlledComposition> list = arrayList6;
                                List<MovableContentStateReference> list2 = arrayList5;
                                MutableScatterSet<ControlledComposition> mutableScatterSet12 = mutableScatterSet3;
                                List<ControlledComposition> list3 = arrayList4;
                                MutableScatterSet<ControlledComposition> mutableScatterSet13 = mutableScatterSet72;
                                Set<? extends Object> set5 = set22;
                                beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                                try {
                                    recomposer3.recordComposerModifications();
                                    synchronized (recomposer3.stateLock) {
                                        MutableVector mutableVector = recomposer3.compositionInvalidations;
                                        Object[] objArr = mutableVector.content;
                                        int i2 = 0;
                                        for (int size = mutableVector.getSize(); i2 < size; size = size) {
                                            list.add((ControlledComposition) objArr[i2]);
                                            i2++;
                                        }
                                        recomposer3.compositionInvalidations.clear();
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    mutableScatterSet10.clear();
                                    mutableScatterSet11.clear();
                                    while (true) {
                                        if (list.isEmpty() && list2.isEmpty()) {
                                            break;
                                        }
                                        int size2 = list.size();
                                        for (int i3 = 0; i3 < size2; i3++) {
                                            ControlledComposition controlledComposition = list.get(i3);
                                            performRecompose = recomposer3.performRecompose(controlledComposition, mutableScatterSet10);
                                            if (performRecompose != null) {
                                                list3.add(performRecompose);
                                                Unit unit3 = Unit.INSTANCE;
                                                Unit unit4 = Unit.INSTANCE;
                                            }
                                            mutableScatterSet11.add(controlledComposition);
                                        }
                                        list.clear();
                                        if (!mutableScatterSet10.isNotEmpty() && recomposer3.compositionInvalidations.getSize() == 0) {
                                            set3 = set5;
                                            if (!list.isEmpty()) {
                                                Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list2, recomposer3);
                                                while (!list2.isEmpty()) {
                                                    performInsertValues = recomposer3.performInsertValues(list2, mutableScatterSet10);
                                                    mutableScatterSet12.plusAssign(performInsertValues);
                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list2, recomposer3);
                                                }
                                            }
                                            set5 = set3;
                                        }
                                        synchronized (recomposer3.stateLock) {
                                            List knownCompositions = recomposer3.getKnownCompositions();
                                            int size3 = knownCompositions.size();
                                            for (int i4 = 0; i4 < size3; i4++) {
                                                ControlledComposition controlledComposition2 = (ControlledComposition) knownCompositions.get(i4);
                                                if (!mutableScatterSet11.contains(controlledComposition2) && controlledComposition2.observesAnyOf(set5)) {
                                                    list.add(controlledComposition2);
                                                }
                                            }
                                            MutableVector mutableVector2 = recomposer3.compositionInvalidations;
                                            int size4 = mutableVector2.getSize();
                                            int i5 = 0;
                                            int i6 = 0;
                                            while (i5 < size4) {
                                                ControlledComposition controlledComposition3 = (ControlledComposition) mutableVector2.content[i5];
                                                if (mutableScatterSet11.contains(controlledComposition3) || list.contains(controlledComposition3)) {
                                                    set4 = set5;
                                                    if (i6 > 0) {
                                                        mutableVector2.content[i5 - i6] = mutableVector2.content[i5];
                                                    }
                                                } else {
                                                    set4 = set5;
                                                    list.add(controlledComposition3);
                                                    i6++;
                                                }
                                                i5++;
                                                set5 = set4;
                                            }
                                            set3 = set5;
                                            int i7 = size4 - i6;
                                            ArraysKt.fill(mutableVector2.content, (Object) null, i7, size4);
                                            mutableVector2.setSize(i7);
                                            Unit unit5 = Unit.INSTANCE;
                                        }
                                        if (!list.isEmpty()) {
                                        }
                                        set5 = set3;
                                    }
                                    if (!list3.isEmpty()) {
                                        recomposer3.changeCount = recomposer3.getChangeCount() + 1;
                                        int size5 = list3.size();
                                        for (int i8 = 0; i8 < size5; i8++) {
                                            mutableScatterSet13.add(list3.get(i8));
                                        }
                                        int size6 = list3.size();
                                        for (int i9 = 0; i9 < size6; i9++) {
                                            list3.get(i9).applyChanges();
                                        }
                                        list3.clear();
                                    }
                                    if (mutableScatterSet12.isNotEmpty()) {
                                        try {
                                            mutableScatterSet13.plusAssign(mutableScatterSet12);
                                            MutableScatterSet<ControlledComposition> mutableScatterSet14 = mutableScatterSet12;
                                            c = 7;
                                            Object[] objArr2 = mutableScatterSet14.elements;
                                            long[] jArr = mutableScatterSet14.metadata;
                                            j2 = 128;
                                            int length = jArr.length - 2;
                                            if (length >= 0) {
                                                int i10 = 0;
                                                while (true) {
                                                    int i11 = length;
                                                    long j3 = jArr[i10];
                                                    mutableScatterSet9 = mutableScatterSet10;
                                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i12 = 8 - ((~(i10 - i11)) >>> 31);
                                                        for (int i13 = 0; i13 < i12; i13++) {
                                                            if ((j3 & 255) < 128) {
                                                                try {
                                                                    ((ControlledComposition) objArr2[(i10 << 3) + i13]).applyLateChanges();
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    try {
                                                                        Recomposer.processCompositionError$default(recomposer3, th, null, false, 6, null);
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                    }
                                                                    try {
                                                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer3, list, list2, list3, mutableScatterSet12, mutableScatterSet13, mutableScatterSet9, mutableScatterSet11);
                                                                        mutableScatterSet12.clear();
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        mutableScatterSet12 = mutableScatterSet12;
                                                                        mutableScatterSet12.clear();
                                                                        throw th;
                                                                    }
                                                                }
                                                            }
                                                            j3 >>= 8;
                                                        }
                                                        if (i12 != 8) {
                                                            break;
                                                        }
                                                    }
                                                    length = i11;
                                                    if (i10 == length) {
                                                        break;
                                                    }
                                                    i10++;
                                                    mutableScatterSet10 = mutableScatterSet9;
                                                }
                                            } else {
                                                mutableScatterSet9 = mutableScatterSet10;
                                            }
                                            mutableScatterSet12.clear();
                                            mutableScatterSet10 = mutableScatterSet9;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            mutableScatterSet9 = mutableScatterSet10;
                                        }
                                    } else {
                                        c = 7;
                                        j2 = 128;
                                    }
                                    if (mutableScatterSet13.isNotEmpty()) {
                                        MutableScatterSet<ControlledComposition> mutableScatterSet15 = mutableScatterSet13;
                                        Object[] objArr3 = mutableScatterSet15.elements;
                                        long[] jArr2 = mutableScatterSet15.metadata;
                                        int length2 = jArr2.length - 2;
                                        if (length2 >= 0) {
                                            int i14 = 0;
                                            while (true) {
                                                long j4 = jArr2[i14];
                                                long[] jArr3 = jArr2;
                                                if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                                    for (int i16 = 0; i16 < i15; i16++) {
                                                        if ((j4 & 255) < j2) {
                                                            ((ControlledComposition) objArr3[(i14 << 3) + i16]).changesApplied();
                                                        }
                                                        j4 >>= 8;
                                                    }
                                                    if (i15 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i14 == length2) {
                                                    break;
                                                }
                                                i14++;
                                                jArr2 = jArr3;
                                            }
                                        }
                                        mutableScatterSet13.clear();
                                    }
                                    synchronized (recomposer3.stateLock) {
                                        recomposer3.deriveStateLocked();
                                    }
                                    Snapshot.Companion.notifyObjectsInitialized();
                                    mutableScatterSet11.clear();
                                    mutableScatterSet10.clear();
                                    recomposer3.compositionsRemoved = null;
                                    Unit unit6 = Unit.INSTANCE;
                                } finally {
                                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
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
}
