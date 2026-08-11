package ru.mrlargha.feature.battlepassWinter2025;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaMissionsState;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$loadArizonaMissionTable$1", f = "Winter2025BattlePass.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3}, l = {1091, 1097, 1103, 1107}, m = "invokeSuspend", n = {"missions", "attempt", "missions", "response", "attempt", "missions", "<unused var>", "attempt", "missions"}, nl = {1092, 1099, 1086, 1125}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class Winter2025BattlePassScreen$loadArizonaMissionTable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $tableKey;
    final /* synthetic */ int $token;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Winter2025BattlePassScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen$loadArizonaMissionTable$1(Winter2025BattlePassScreen winter2025BattlePassScreen, int i, String str, Continuation<? super Winter2025BattlePassScreen$loadArizonaMissionTable$1> continuation) {
        super(2, continuation);
        this.this$0 = winter2025BattlePassScreen;
        this.$token = i;
        this.$tableKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$loadArizonaMissionTable$1(this.this$0, this.$token, this.$tableKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Winter2025BattlePassScreen$loadArizonaMissionTable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r13) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r13) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fb, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$loadArizonaMissionTable$1.AnonymousClass2(r14, r13.this$0, r13.$token, null), r13) == r0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c A[Catch: Exception -> 0x0050, CancellationException -> 0x00d7, TryCatch #0 {Exception -> 0x0050, blocks: (B:30:0x0091, B:32:0x009c, B:34:0x00a2, B:13:0x0041, B:16:0x004c), top: B:51:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.util.List, T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a0 -> B:43:0x00d4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b5 -> B:43:0x00d4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00bc -> B:43:0x00d4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d1 -> B:43:0x00d4). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        ?? r14;
        ArizonaMissionsState arizonaMissionsState;
        WinterBattlePassApi winterBattlePassApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                e = e;
                if (i < 2) {
                    this.L$0 = objectRef2;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    this.I$0 = i;
                    this.label = 3;
                }
                objectRef = objectRef2;
                i++;
                if (i < 3) {
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.L$1 = null;
                this.label = 4;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                i = 0;
                if (i < 3) {
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.L$1 = null;
                this.label = 4;
            } else if (i != 1) {
                if (i == 2) {
                    i = this.I$0;
                    List list = (List) this.L$1;
                    objectRef2 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i != 3) {
                    if (i == 4) {
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i = this.I$0;
                    Exception exc = (Exception) this.L$1;
                    objectRef2 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                objectRef = objectRef2;
                i++;
                if (i < 3) {
                    arizonaMissionsState = this.this$0.arizonaMissionsState;
                    if (arizonaMissionsState.getLoadGeneration().isCurrent(this.$token)) {
                        try {
                        } catch (Exception e2) {
                            objectRef2 = objectRef;
                            e = e2;
                            if (i < 2) {
                            }
                            objectRef = objectRef2;
                            i++;
                            if (i < 3) {
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objectRef);
                            this.L$1 = null;
                            this.label = 4;
                        }
                        winterBattlePassApi = this.this$0.api;
                        this.L$0 = objectRef;
                        this.L$1 = null;
                        this.I$0 = i;
                        this.label = 1;
                        Object commonTasks = winterBattlePassApi.getCommonTasks(this.$tableKey, this);
                        if (commonTasks != coroutine_suspended) {
                            objectRef2 = objectRef;
                            obj = commonTasks;
                            r14 = (List) obj;
                            if (((Collection) r14).isEmpty()) {
                                if (i < 2) {
                                    this.L$0 = objectRef2;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(r14);
                                    this.I$0 = i;
                                    this.label = 2;
                                }
                                objectRef = objectRef2;
                                i++;
                                if (i < 3) {
                                }
                            } else {
                                objectRef2.element = r14;
                                objectRef = objectRef2;
                            }
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.L$1 = null;
                this.label = 4;
            } else {
                i = this.I$0;
                objectRef2 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                r14 = (List) obj;
                if (((Collection) r14).isEmpty()) {
                }
            }
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$loadArizonaMissionTable$1$2", f = "Winter2025BattlePass.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$loadArizonaMissionTable$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<CommonTaskInfo>> $missions;
        final /* synthetic */ int $token;
        int label;
        final /* synthetic */ Winter2025BattlePassScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<List<CommonTaskInfo>> objectRef, Winter2025BattlePassScreen winter2025BattlePassScreen, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$missions = objectRef;
            this.this$0 = winter2025BattlePassScreen;
            this.$token = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$missions, this.this$0, this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArizonaMissionsState arizonaMissionsState;
            ArizonaMissionsState arizonaMissionsState2;
            ArizonaMissionsState arizonaMissionsState3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<CommonTaskInfo> list = this.$missions.element;
            Winter2025BattlePassScreen winter2025BattlePassScreen = this.this$0;
            if (list == null) {
                arizonaMissionsState3 = winter2025BattlePassScreen.arizonaMissionsState;
                if (arizonaMissionsState3.failLoad(this.$token)) {
                    this.this$0.showTasksEmptySafeState();
                }
                return Unit.INSTANCE;
            }
            arizonaMissionsState = winter2025BattlePassScreen.arizonaMissionsState;
            if (arizonaMissionsState.acceptTable(this.$token, list)) {
                this.this$0._taskUsualData = list;
                this.this$0._taskPremData = CollectionsKt.emptyList();
                Winter2025BattlePassScreen winter2025BattlePassScreen2 = this.this$0;
                arizonaMissionsState2 = winter2025BattlePassScreen2.arizonaMissionsState;
                winter2025BattlePassScreen2._usualTasks = arizonaMissionsState2.getProgress();
                this.this$0.publishArizonaMissionsToUi(false);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }
}
