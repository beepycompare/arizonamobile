package ru.mrlargha.commonui.elements.donate.presentation.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateOrdinaryPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1", f = "DonateOrdinaryPage.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {69, 80, 83}, m = "invokeSuspend", n = {"sortedList", "chunks", "addedList", "itemsShown", "readyShown", "chunk", "totalChunks", "sortedList", "chunks", "addedList", "itemsShown", "readyShown", "chunk", "totalChunks", "sortedList", "chunks", "addedList", "itemsShown", "readyShown", "totalChunks"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes5.dex */
public final class DonateOrdinaryPage$renderListGradually$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DonateItemModelUi> $list;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DonateOrdinaryPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateOrdinaryPage$renderListGradually$1(List<DonateItemModelUi> list, DonateOrdinaryPage donateOrdinaryPage, Continuation<? super DonateOrdinaryPage$renderListGradually$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = donateOrdinaryPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateOrdinaryPage$renderListGradually$1(this.$list, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateOrdinaryPage$renderListGradually$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0137, code lost:
        if (kotlinx.coroutines.DelayKt.delay(100, r17) != r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x017b, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1.AnonymousClass2(r12, r17.this$0, null), r17) == r1) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x013d  */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0137 -> B:11:0x0055). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List<DonateItemModelUi> sortForLines;
        List chunked;
        Ref.BooleanRef booleanRef;
        Iterator it;
        Ref.IntRef intRef;
        int i;
        ArrayList arrayList;
        List list;
        List<DonateItemModelUi> list2;
        List list3;
        ArrayList arrayList2;
        Ref.IntRef intRef2;
        Ref.BooleanRef booleanRef2;
        Iterator it2;
        int i2;
        ArrayList arrayList3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            sortForLines = DonateUtilsKt.sortForLines(this.$list);
            chunked = CollectionsKt.chunked(sortForLines, 4);
            Ref.IntRef intRef3 = new Ref.IntRef();
            int size = chunked.size();
            booleanRef = new Ref.BooleanRef();
            it = chunked.iterator();
            intRef = intRef3;
            i = size;
            arrayList = new ArrayList();
            if (it.hasNext()) {
            }
            return coroutine_suspended;
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) this.L$4;
                    Ref.IntRef intRef4 = (Ref.IntRef) this.L$3;
                    List list4 = (List) this.L$2;
                    List list5 = (List) this.L$1;
                    List list6 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.I$0;
            List list7 = (List) this.L$6;
            it2 = (Iterator) this.L$5;
            booleanRef2 = (Ref.BooleanRef) this.L$4;
            intRef2 = (Ref.IntRef) this.L$3;
            list3 = (List) this.L$1;
            list2 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            arrayList3 = (List) this.L$2;
            List<DonateItemModelUi> list8 = list2;
            i = i2;
            sortForLines = list8;
            it = it2;
            booleanRef = booleanRef2;
            chunked = list3;
            intRef = intRef2;
            arrayList = arrayList3;
            if (it.hasNext()) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(sortForLines);
                this.L$1 = SpillingKt.nullOutSpilledVariable(chunked);
                this.L$2 = SpillingKt.nullOutSpilledVariable(arrayList);
                this.L$3 = SpillingKt.nullOutSpilledVariable(intRef);
                this.L$4 = SpillingKt.nullOutSpilledVariable(booleanRef);
                this.L$5 = null;
                this.L$6 = null;
                this.I$0 = i;
                this.label = 3;
            } else {
                list = (List) it.next();
                arrayList.addAll(list);
                this.L$0 = SpillingKt.nullOutSpilledVariable(sortForLines);
                this.L$1 = SpillingKt.nullOutSpilledVariable(chunked);
                this.L$2 = arrayList;
                this.L$3 = intRef;
                this.L$4 = booleanRef;
                this.L$5 = it;
                this.L$6 = SpillingKt.nullOutSpilledVariable(list);
                this.I$0 = i;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, arrayList, intRef, i, booleanRef, null), this) != coroutine_suspended) {
                    int i4 = i;
                    list2 = sortForLines;
                    i2 = i4;
                    intRef2 = intRef;
                    booleanRef2 = booleanRef;
                    list3 = chunked;
                    it2 = it;
                    arrayList2 = arrayList;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list3);
                    this.L$2 = arrayList2;
                    this.L$3 = intRef2;
                    this.L$4 = booleanRef2;
                    this.L$5 = it2;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(list);
                    this.I$0 = i2;
                    this.label = 2;
                    arrayList3 = arrayList2;
                }
            }
            return coroutine_suspended;
        } else {
            i2 = this.I$0;
            ResultKt.throwOnFailure(obj);
            list = (List) this.L$6;
            it2 = (Iterator) this.L$5;
            booleanRef2 = (Ref.BooleanRef) this.L$4;
            intRef2 = (Ref.IntRef) this.L$3;
            arrayList2 = (List) this.L$2;
            list3 = (List) this.L$1;
            list2 = (List) this.L$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(list3);
            this.L$2 = arrayList2;
            this.L$3 = intRef2;
            this.L$4 = booleanRef2;
            this.L$5 = it2;
            this.L$6 = SpillingKt.nullOutSpilledVariable(list);
            this.I$0 = i2;
            this.label = 2;
            arrayList3 = arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateOrdinaryPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$1", f = "DonateOrdinaryPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DonateItemModelUi> $addedList;
        final /* synthetic */ Ref.IntRef $itemsShown;
        final /* synthetic */ Ref.BooleanRef $readyShown;
        final /* synthetic */ int $totalChunks;
        int label;
        final /* synthetic */ DonateOrdinaryPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DonateOrdinaryPage donateOrdinaryPage, List<DonateItemModelUi> list, Ref.IntRef intRef, int i, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = donateOrdinaryPage;
            this.$addedList = list;
            this.$itemsShown = intRef;
            this.$totalChunks = i;
            this.$readyShown = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$addedList, this.$itemsShown, this.$totalChunks, this.$readyShown, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DonateAdapter donateAdapter;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                donateAdapter = this.this$0.itemAdapter;
                donateAdapter.submitList(CollectionsKt.toList(this.$addedList));
                this.$itemsShown.element++;
                float f = this.$itemsShown.element / this.$totalChunks;
                if (!this.$readyShown.element && f >= 0.6f) {
                    this.$readyShown.element = true;
                    this.this$0.getOnItemCompleteListeners().itemReadyToShow();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateOrdinaryPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$2", f = "DonateOrdinaryPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $readyShown;
        int label;
        final /* synthetic */ DonateOrdinaryPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.BooleanRef booleanRef, DonateOrdinaryPage donateOrdinaryPage, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$readyShown = booleanRef;
            this.this$0 = donateOrdinaryPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$readyShown, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!this.$readyShown.element) {
                this.this$0.getOnItemCompleteListeners().itemReadyToShow();
            }
            return Unit.INSTANCE;
        }
    }
}
