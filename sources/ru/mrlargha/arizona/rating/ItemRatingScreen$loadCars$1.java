package ru.mrlargha.arizona.rating;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ItemRatingScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizona.rating.ItemRatingScreen$loadCars$1", f = "ItemRatingScreen.kt", i = {}, l = {231, 232}, m = "invokeSuspend", n = {}, nl = {232, 235}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class ItemRatingScreen$loadCars$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ItemRatingScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRatingScreen$loadCars$1(ItemRatingScreen itemRatingScreen, Continuation<? super ItemRatingScreen$loadCars$1> continuation) {
        super(2, continuation);
        this.this$0 = itemRatingScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemRatingScreen$loadCars$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemRatingScreen$loadCars$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r13 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.arizona.rating.ItemRatingScreen$loadCars$1.AnonymousClass1(r12.this$0, null), r12) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ItemRatingScreen itemRatingScreen;
        RatingApi ratingApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            itemRatingScreen = this.this$0;
            ratingApi = itemRatingScreen.api;
            this.L$0 = itemRatingScreen;
            this.label = 1;
            obj = RatingApi.getCarsList$default(ratingApi, 0, false, 0, null, this, 15, null);
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            itemRatingScreen = (ItemRatingScreen) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        itemRatingScreen.apiData = (List) obj;
        this.L$0 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemRatingScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.arizona.rating.ItemRatingScreen$loadCars$1$1", f = "ItemRatingScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.arizona.rating.ItemRatingScreen$loadCars$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ItemRatingScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemRatingScreen itemRatingScreen, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = itemRatingScreen;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ItemRatingScreen itemRatingScreen = this.this$0;
            list = itemRatingScreen.apiData;
            itemRatingScreen.addData(list);
            return Unit.INSTANCE;
        }
    }
}
