package ru.mrlargha.event;

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
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.event.data.AwardItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.event.EventScreen$updateBpAwards$1", f = "EventScreen.kt", i = {1}, l = {392, 401}, m = "invokeSuspend", n = {"pairList"}, nl = {393, 404}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class EventScreen$updateBpAwards$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $awardsStatusList;
    Object L$0;
    int label;
    final /* synthetic */ EventScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventScreen$updateBpAwards$1(EventScreen eventScreen, List<Integer> list, Continuation<? super EventScreen$updateBpAwards$1> continuation) {
        super(2, continuation);
        this.this$0 = eventScreen;
        this.$awardsStatusList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventScreen$updateBpAwards$1(this.this$0, this.$awardsStatusList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventScreen$updateBpAwards$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r10 == r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.event.EventScreen$updateBpAwards$1.AnonymousClass2(r9.this$0, r10, null), r9) != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        EventApi eventApi;
        List list2;
        Integer num;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0._bpUsualData;
            if (list.isEmpty()) {
                eventApi = this.this$0.api;
                this.label = 1;
                obj = eventApi.getDefaultBP(this);
            }
            list2 = this.this$0._bpUsualData;
            List<Integer> list3 = this.$awardsStatusList;
            int i2 = 0;
            for (Object obj2 : list2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AwardItemData awardItemData = (AwardItemData) obj2;
                try {
                    num = (Integer) CollectionsKt.getOrNull(list3, i2);
                } catch (Exception unused) {
                }
                if (num != null && num.intValue() == 0) {
                    z = true;
                    awardItemData.setAvailableToReceive(z);
                    i2 = i3;
                }
                z = false;
                awardItemData.setAvailableToReceive(z);
                i2 = i3;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
            this.label = 2;
        } else if (i != 1) {
            if (i == 2) {
                List list4 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.this$0._bpUsualData = (List) obj;
        list2 = this.this$0._bpUsualData;
        List<Integer> list32 = this.$awardsStatusList;
        int i22 = 0;
        while (r1.hasNext()) {
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.event.EventScreen$updateBpAwards$1$2", f = "EventScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.event.EventScreen$updateBpAwards$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AwardItemData> $pairList;
        int label;
        final /* synthetic */ EventScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EventScreen eventScreen, List<AwardItemData> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = eventScreen;
            this.$pairList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$pairList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.updateLevelItems(this.$pairList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
