package ru.mrlargha.commonui.elements.battlepassWinter2025;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CommonTaskInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateTasks$1", f = "Winter2025BattlePass.kt", i = {}, l = {844, 848, 852}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class Winter2025BattlePassScreen$updateTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Winter2025BattlePassScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen$updateTasks$1(Winter2025BattlePassScreen winter2025BattlePassScreen, Continuation<? super Winter2025BattlePassScreen$updateTasks$1> continuation) {
        super(2, continuation);
        this.this$0 = winter2025BattlePassScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$updateTasks$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Winter2025BattlePassScreen$updateTasks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        if (r8 == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
        if (r8 == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateTasks$1.AnonymousClass1(r7.this$0, r8, null), r7) == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
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
            list = this.this$0._taskUsualData;
            if (list.isEmpty()) {
                winterBattlePassApi = this.this$0.api;
                if (winterBattlePassApi == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("api");
                    winterBattlePassApi = null;
                }
                this.label = 1;
                obj = winterBattlePassApi.getCommonTasks(this);
            }
            list2 = this.this$0._taskPremData;
            if (list2.isEmpty()) {
                winterBattlePassApi2 = this.this$0.api;
                if (winterBattlePassApi2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("api");
                    winterBattlePassApi2 = null;
                }
                this.label = 2;
                obj = winterBattlePassApi2.getPremiumTasks(this);
            }
            list3 = this.this$0._taskUsualData;
            list4 = this.this$0._taskPremData;
            List plus = CollectionsKt.plus((Collection) list3, (Iterable) list4);
            this.label = 3;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0._taskPremData = (List) obj;
            list3 = this.this$0._taskUsualData;
            list4 = this.this$0._taskPremData;
            List plus2 = CollectionsKt.plus((Collection) list3, (Iterable) list4);
            this.label = 3;
        }
        this.this$0._taskUsualData = (List) obj;
        list2 = this.this$0._taskPremData;
        if (list2.isEmpty()) {
        }
        list3 = this.this$0._taskUsualData;
        list4 = this.this$0._taskPremData;
        List plus22 = CollectionsKt.plus((Collection) list3, (Iterable) list4);
        this.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateTasks$1$1", f = "Winter2025BattlePass.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$updateTasks$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<CommonTaskInfo> $commonList;
        int label;
        final /* synthetic */ Winter2025BattlePassScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Winter2025BattlePassScreen winter2025BattlePassScreen, List<CommonTaskInfo> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = winter2025BattlePassScreen;
            this.$commonList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$commonList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.updateCommonTaskItems(this.$commonList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
