package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateOrdinaryPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1", f = "DonateOrdinaryPage.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {106, 131, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO}, m = "invokeSuspend", n = {"sortedList", "chunks", "addedList", "readyShown", "chunk", "chunkSize", "loadingPercent", "itemsShown", "totalChunks", "percent", "sortedList", "chunks", "addedList", "readyShown", "chunkSize", "loadingPercent", "itemsShown", "totalChunks"}, nl = {109, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, TsExtractor.TS_STREAM_TYPE_DTS_UHD}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "D$0", "I$1", "I$2", "F$0", "L$0", "L$1", "L$2", "L$3", "I$0", "D$0", "I$1", "I$2"}, v = 2)
/* loaded from: classes6.dex */
public final class DonateOrdinaryPage$renderListGradually$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DonateItemModelUi> $list;
    double D$0;
    float F$0;
    int I$0;
    int I$1;
    int I$2;
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007c, code lost:
        if (r2 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01bd, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1.AnonymousClass1(r13, r18.this$0, null), r18) == r1) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017b  */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0174 -> B:38:0x0175). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object withContext;
        Ref.BooleanRef booleanRef;
        DonateAdapter donateAdapter;
        List list;
        int i;
        Iterator it;
        int i2;
        ArrayList arrayList;
        int i3;
        List list2;
        double d;
        DonateAdapter donateAdapter2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            withContext = BuildersKt.withContext(Dispatchers.getDefault(), new DonateOrdinaryPage$renderListGradually$1$sortedList$1(this.$list, null), this);
        } else if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$3;
                    List list3 = (List) this.L$2;
                    List list4 = (List) this.L$1;
                    List list5 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$2;
            int i5 = this.I$1;
            double d2 = this.D$0;
            i3 = this.I$0;
            List list6 = (List) this.L$5;
            it = (Iterator) this.L$4;
            booleanRef = (Ref.BooleanRef) this.L$3;
            list2 = (List) this.L$1;
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i5;
            double d3 = d2;
            ArrayList arrayList2 = (List) this.L$2;
            d = d3;
            arrayList = arrayList2;
            if (it.hasNext()) {
                List list7 = (List) it.next();
                arrayList.addAll(list7);
                donateAdapter2 = this.this$0.itemAdapter;
                donateAdapter2.submitList(CollectionsKt.toList(arrayList));
                int i6 = i2 + 1;
                float f = i6 / i;
                if (!booleanRef.element && f >= d) {
                    booleanRef.element = true;
                    Log.i(DonateUtilsKt.DONATE_TAG, "renderListGradually: ");
                    this.this$0.getOnItemCompleteListeners().itemReadyToShow();
                } else if (this.$list.size() <= 10) {
                    this.this$0.getOnItemCompleteListeners().itemReadyToShow();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                this.L$2 = arrayList;
                this.L$3 = booleanRef;
                this.L$4 = it;
                this.L$5 = SpillingKt.nullOutSpilledVariable(list7);
                this.I$0 = i3;
                this.D$0 = d;
                this.I$1 = i6;
                this.I$2 = i;
                this.F$0 = f;
                this.label = 2;
                d3 = d;
                if (DelayKt.delay(100L, this) != coroutine_suspended) {
                    i2 = i6;
                    arrayList2 = arrayList;
                    d = d3;
                    arrayList = arrayList2;
                    if (it.hasNext()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(arrayList);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(booleanRef);
                        this.L$4 = null;
                        this.L$5 = null;
                        this.I$0 = i3;
                        this.D$0 = d;
                        this.I$1 = i2;
                        this.I$2 = i;
                        this.label = 3;
                    }
                }
            }
            return coroutine_suspended;
        } else {
            ResultKt.throwOnFailure(obj);
            withContext = obj;
        }
        List list8 = (List) withContext;
        int i7 = this.$list.size() > 150 ? 8 : 4;
        double d4 = this.$list.size() > 150 ? 0.8d : 0.6d;
        List chunked = CollectionsKt.chunked(list8, i7);
        int size = chunked.size();
        booleanRef = new Ref.BooleanRef();
        donateAdapter = this.this$0.itemAdapter;
        Log.i(DonateUtilsKt.DONATE_TAG, "itemAdapterSize: " + donateAdapter.getCurrentList().size());
        int i8 = i7;
        list = list8;
        i = size;
        it = chunked.iterator();
        i2 = 0;
        arrayList = new ArrayList();
        i3 = i8;
        list2 = chunked;
        d = d4;
        if (it.hasNext()) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateOrdinaryPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$renderListGradually$1$1", f = "DonateOrdinaryPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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
