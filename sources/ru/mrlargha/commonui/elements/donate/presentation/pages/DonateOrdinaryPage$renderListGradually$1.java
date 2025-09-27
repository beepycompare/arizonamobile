package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.util.Log;
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
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1", f = "DonateOrdinaryPage.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {107, 128, 131}, m = "invokeSuspend", n = {"sortedList", "chunks", "addedList", "readyShown", "chunk", "itemsShown", "totalChunks", "percent", "sortedList", "chunks", "addedList", "readyShown", "itemsShown", "totalChunks"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "I$1", "F$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
/* loaded from: classes6.dex */
public final class DonateOrdinaryPage$renderListGradually$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DonateItemModelUi> $list;
    float F$0;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ DonateOrdinaryPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateOrdinaryPage$renderListGradually$1(DonateOrdinaryPage donateOrdinaryPage, List<DonateItemModelUi> list, Continuation<? super DonateOrdinaryPage$renderListGradually$1> continuation) {
        super(2, continuation);
        this.this$0 = donateOrdinaryPage;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateOrdinaryPage$renderListGradually$1(this.this$0, this.$list, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateOrdinaryPage$renderListGradually$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0075, code lost:
        if (r2 == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x012e, code lost:
        if (kotlinx.coroutines.DelayKt.delay(100, r18) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0170, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1.AnonymousClass1(r10, r18.this$0, null), r18) == r1) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0136  */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x012e -> B:26:0x0131). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object withContext;
        DonateAdapter donateAdapter;
        List list;
        int i;
        Ref.BooleanRef booleanRef;
        ArrayList arrayList;
        Iterator it;
        List list2;
        int i2;
        DonateAdapter donateAdapter2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i4 = 2;
        boolean z = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            withContext = BuildersKt.withContext(Dispatchers.getDefault(), new DonateOrdinaryPage$renderListGradually$1$sortedList$1(this.$list, null), this);
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$3;
                    List list3 = (List) this.L$2;
                    List list4 = (List) this.L$1;
                    List list5 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$1;
            i2 = this.I$0;
            List list6 = (List) this.L$5;
            it = (Iterator) this.L$4;
            booleanRef = (Ref.BooleanRef) this.L$3;
            list2 = (List) this.L$1;
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList2 = (List) this.L$2;
            i4 = 2;
            z = true;
            arrayList = arrayList2;
            if (it.hasNext()) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(arrayList);
                this.L$3 = SpillingKt.nullOutSpilledVariable(booleanRef);
                this.L$4 = null;
                this.L$5 = null;
                this.I$0 = i2;
                this.I$1 = i;
                this.label = 3;
            } else {
                List list7 = (List) it.next();
                arrayList.addAll(list7);
                donateAdapter2 = this.this$0.itemAdapter;
                donateAdapter2.submitList(CollectionsKt.toList(arrayList));
                i2++;
                float f = i2 / i;
                if (!booleanRef.element && f >= 0.6f) {
                    booleanRef.element = z;
                    Log.i(DonateUtilsKt.DONATE_TAG, "renderListGradually: ");
                    this.this$0.getOnItemCompleteListeners().itemReadyToShow();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                this.L$2 = arrayList;
                this.L$3 = booleanRef;
                this.L$4 = it;
                this.L$5 = SpillingKt.nullOutSpilledVariable(list7);
                this.I$0 = i2;
                this.I$1 = i;
                this.F$0 = f;
                this.label = i4;
                arrayList2 = arrayList;
            }
            return coroutine_suspended;
        } else {
            ResultKt.throwOnFailure(obj);
            withContext = obj;
        }
        List list8 = (List) withContext;
        List chunked = CollectionsKt.chunked(list8, 4);
        int size = chunked.size();
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        donateAdapter = this.this$0.itemAdapter;
        Log.i(DonateUtilsKt.DONATE_TAG, "itemAdapterSize: " + donateAdapter.getCurrentList().size());
        list = list8;
        i = size;
        booleanRef = booleanRef3;
        arrayList = new ArrayList();
        it = chunked.iterator();
        list2 = chunked;
        i2 = 0;
        if (it.hasNext()) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateOrdinaryPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$1", f = "DonateOrdinaryPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $readyShown;
        int label;
        final /* synthetic */ DonateOrdinaryPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, DonateOrdinaryPage donateOrdinaryPage, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$readyShown = booleanRef;
            this.this$0 = donateOrdinaryPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$readyShown, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
