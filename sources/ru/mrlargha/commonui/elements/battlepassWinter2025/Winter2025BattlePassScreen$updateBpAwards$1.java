package ru.mrlargha.commonui.elements.battlepassWinter2025;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.AwardItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateBpAwards$1", f = "Winter2025BattlePass.kt", i = {2}, l = {293, 297, 307}, m = "invokeSuspend", n = {"pairList"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class Winter2025BattlePassScreen$updateBpAwards$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<List<Integer>> $awardsStatusList;
    Object L$0;
    int label;
    final /* synthetic */ Winter2025BattlePassScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Winter2025BattlePassScreen$updateBpAwards$1(Winter2025BattlePassScreen winter2025BattlePassScreen, List<? extends List<Integer>> list, Continuation<? super Winter2025BattlePassScreen$updateBpAwards$1> continuation) {
        super(2, continuation);
        this.this$0 = winter2025BattlePassScreen;
        this.$awardsStatusList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$updateBpAwards$1(this.this$0, this.$awardsStatusList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Winter2025BattlePassScreen$updateBpAwards$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r13 == r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
        if (r13 == r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0116, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateBpAwards$1.AnonymousClass2(r12.this$0, r13, null), r12) == r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0118, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        WinterBattlePassApi winterBattlePassApi;
        List list2;
        WinterBattlePassApi winterBattlePassApi2;
        List list3;
        List list4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0._bpUsualData;
            if (list.isEmpty()) {
                winterBattlePassApi = this.this$0.api;
                if (winterBattlePassApi == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("api");
                    winterBattlePassApi = null;
                }
                this.label = 1;
                obj = winterBattlePassApi.getDefaultBP(this);
            }
            list2 = this.this$0._bpPremData;
            if (list2.isEmpty()) {
                winterBattlePassApi2 = this.this$0.api;
                if (winterBattlePassApi2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("api");
                    winterBattlePassApi2 = null;
                }
                this.label = 2;
                obj = winterBattlePassApi2.getGoldBP(this);
            }
            list3 = this.this$0._bpUsualData;
            list4 = this.this$0._bpPremData;
            List zip = CollectionsKt.zip(list3, list4);
            List<List<Integer>> list5 = this.$awardsStatusList;
            int i2 = 0;
            while (r1.hasNext()) {
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(zip);
            this.label = 3;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                List list6 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0._bpPremData = (List) obj;
            list3 = this.this$0._bpUsualData;
            list4 = this.this$0._bpPremData;
            List zip2 = CollectionsKt.zip(list3, list4);
            List<List<Integer>> list52 = this.$awardsStatusList;
            int i22 = 0;
            for (Object obj2 : zip2) {
                int i3 = i22 + 1;
                if (i22 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj2;
                try {
                    ((AwardItemData) pair.getFirst()).setAvailableToReceive(list52.get(i22).get(0).intValue() == 0);
                    ((AwardItemData) pair.getSecond()).setAvailableToReceive(list52.get(i22).get(1).intValue() == 0);
                } catch (Exception unused) {
                }
                i22 = i3;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(zip2);
            this.label = 3;
        }
        this.this$0._bpUsualData = (List) obj;
        list2 = this.this$0._bpPremData;
        if (list2.isEmpty()) {
        }
        list3 = this.this$0._bpUsualData;
        list4 = this.this$0._bpPremData;
        List zip22 = CollectionsKt.zip(list3, list4);
        List<List<Integer>> list522 = this.$awardsStatusList;
        int i222 = 0;
        while (r1.hasNext()) {
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(zip22);
        this.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateBpAwards$1$2", f = "Winter2025BattlePass.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateBpAwards$1$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Pair<AwardItemData, AwardItemData>> $pairList;
        int label;
        final /* synthetic */ Winter2025BattlePassScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Winter2025BattlePassScreen winter2025BattlePassScreen, List<Pair<AwardItemData, AwardItemData>> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = winter2025BattlePassScreen;
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
