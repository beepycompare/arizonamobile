package com.arizona.launcher;

import com.arizona.launcher.UpdateService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$checkUpdateAndDownload$stringRequest$1$1", f = "UpdateService.kt", i = {1}, l = {1322, 1323}, m = "invokeSuspend", n = {"gameDataInfo"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class UpdateService$checkUpdateAndDownload$stringRequest$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFinish;
    Object L$0;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$checkUpdateAndDownload$stringRequest$1$1(UpdateService updateService, Function0<Unit> function0, Continuation<? super UpdateService$checkUpdateAndDownload$stringRequest$1$1> continuation) {
        super(2, continuation);
        this.this$0 = updateService;
        this.$onFinish = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$checkUpdateAndDownload$stringRequest$1$1(this.this$0, this.$onFinish, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateService$checkUpdateAndDownload$stringRequest$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r8 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizona.launcher.UpdateService$checkUpdateAndDownload$stringRequest$1$1.AnonymousClass1(r7.this$0, r8, r7.$onFinish, null), r7) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        JSONArray jSONArray;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateService updateService = this.this$0;
            jSONArray = updateService.mDataInfo;
            this.label = 1;
            obj = updateService.checkGameDataUpdate(jSONArray, this);
        } else if (i != 1) {
            if (i == 2) {
                Pair pair = (Pair) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Pair pair2 = (Pair) obj;
        this.L$0 = SpillingKt.nullOutSpilledVariable(pair2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.UpdateService$checkUpdateAndDownload$stringRequest$1$1$1", f = "UpdateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.arizona.launcher.UpdateService$checkUpdateAndDownload$stringRequest$1$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Pair<List<String>, Long> $gameDataInfo;
        final /* synthetic */ Function0<Unit> $onFinish;
        int label;
        final /* synthetic */ UpdateService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(UpdateService updateService, Pair<? extends List<String>, Long> pair, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = updateService;
            this.$gameDataInfo = pair;
            this.$onFinish = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$gameDataInfo, this.$onFinish, continuation);
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
            this.this$0.mUpdateFilesNeedSize = this.$gameDataInfo.getSecond().longValue();
            this.this$0.mUpdateFiles = this.$gameDataInfo.getFirst();
            this.this$0.resetGameStatus();
            this.this$0.setUpdateStatus(UpdateService.UpdateStatus.Undefined);
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C00661(this.$onFinish, null), 2, null);
            this.this$0.stopForegroundService();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UpdateService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.arizona.launcher.UpdateService$checkUpdateAndDownload$stringRequest$1$1$1$1", f = "UpdateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.arizona.launcher.UpdateService$checkUpdateAndDownload$stringRequest$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onFinish;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00661(Function0<Unit> function0, Continuation<? super C00661> continuation) {
                super(2, continuation);
                this.$onFinish = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00661(this.$onFinish, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onFinish.invoke();
                return Unit.INSTANCE;
            }
        }
    }
}
