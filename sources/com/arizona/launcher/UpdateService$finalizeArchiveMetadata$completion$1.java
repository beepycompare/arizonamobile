package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateTransactionLock;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$finalizeArchiveMetadata$completion$1", f = "UpdateService.kt", i = {}, l = {1873}, m = "invokeSuspend", n = {}, nl = {1875}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$finalizeArchiveMetadata$completion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdateCheckDecision.Block>, Object> {
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$finalizeArchiveMetadata$completion$1(UpdateService updateService, Continuation<? super UpdateService$finalizeArchiveMetadata$completion$1> continuation) {
        super(2, continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$finalizeArchiveMetadata$completion$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
        return ((UpdateService$finalizeArchiveMetadata$completion$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.UpdateService$finalizeArchiveMetadata$completion$1$1", f = "UpdateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.UpdateService$finalizeArchiveMetadata$completion$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super ArchiveUpdateCheckDecision.Block>, Object> {
        int label;
        final /* synthetic */ UpdateService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdateService updateService, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = updateService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UpdateService.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* renamed from: com.arizona.launcher.UpdateService$finalizeArchiveMetadata$completion$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class C00451 extends FunctionReferenceImpl implements Function0<Boolean> {
            C00451(Object obj) {
                super(0, obj, UpdateService.class, "resourceLanesReady", "resourceLanesReady()Z", 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean resourceLanesReady;
                resourceLanesReady = ((UpdateService) this.receiver).resourceLanesReady();
                return Boolean.valueOf(resourceLanesReady);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            EngineResourceGenerationController engineResourceGenerationController;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                engineResourceGenerationController = this.this$0.resourceGeneration;
                if (engineResourceGenerationController == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resourceGeneration");
                    engineResourceGenerationController = null;
                }
                return engineResourceGenerationController.markCompletedIfInstallReady(new C00451(this.this$0));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object withLock = ArchiveUpdateTransactionLock.INSTANCE.withLock(new AnonymousClass1(this.this$0, null), this);
        return withLock == coroutine_suspended ? coroutine_suspended : withLock;
    }
}
