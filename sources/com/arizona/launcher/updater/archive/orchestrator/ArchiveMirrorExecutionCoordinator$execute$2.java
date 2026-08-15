package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$execute$2", f = "ArchiveMirrorExecutionCoordinator.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, nl = {86}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveMirrorExecutionCoordinator$execute$2 extends SuspendLambda implements Function1<Continuation<? super ArchiveUpdaterResult>, Object> {
    final /* synthetic */ Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> $executeAttempt;
    final /* synthetic */ String $initialServer;
    final /* synthetic */ ArchiveUpdatePlan $plan;
    int label;
    final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveMirrorExecutionCoordinator$execute$2(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, String str, Function3<? super String, ? super ArchiveUpdaterListener, ? super Continuation<? super ArchiveUpdaterResult>, ? extends Object> function3, ArchiveUpdatePlan archiveUpdatePlan, Continuation<? super ArchiveMirrorExecutionCoordinator$execute$2> continuation) {
        super(1, continuation);
        this.this$0 = archiveMirrorExecutionCoordinator;
        this.$initialServer = str;
        this.$executeAttempt = function3;
        this.$plan = archiveUpdatePlan;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ArchiveMirrorExecutionCoordinator$execute$2(this.this$0, this.$initialServer, this.$executeAttempt, this.$plan, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchiveUpdaterResult> continuation) {
        return ((ArchiveMirrorExecutionCoordinator$execute$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveMirrorExecutionCoordinator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$execute$2$1", f = "ArchiveMirrorExecutionCoordinator.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {68, 79}, m = "invokeSuspend", n = {ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "server", "mirrorsRemaining", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "server", "result", "failure", "mirrorsRemaining", "shouldRotateMirror"}, nl = {69, 80}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "Z$0"}, v = 2)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$execute$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdaterResult>, Object> {
        final /* synthetic */ Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> $executeAttempt;
        final /* synthetic */ String $initialServer;
        final /* synthetic */ ArchiveUpdatePlan $plan;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, String str, Function3<? super String, ? super ArchiveUpdaterListener, ? super Continuation<? super ArchiveUpdaterResult>, ? extends Object> function3, ArchiveUpdatePlan archiveUpdatePlan, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = archiveMirrorExecutionCoordinator;
            this.$initialServer = str;
            this.$executeAttempt = function3;
            this.$plan = archiveUpdatePlan;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$initialServer, this.$executeAttempt, this.$plan, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdaterResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ca A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c3 -> B:29:0x00c6). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ArchiveUpdaterListener listener;
            Function0 function0;
            String str;
            int i;
            ArchiveUpdaterListener archiveUpdaterListener;
            ArchiveUpdaterResult.Failure failure;
            Function0 function02;
            Object prepareMirrorRetry;
            Object invoke;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                listener = this.this$0.listener();
                String str2 = this.$initialServer;
                function0 = this.this$0.mirrorCount;
                int coerceAtLeast = RangesKt.coerceAtLeast(((Number) function0.invoke()).intValue(), 1);
                str = str2;
                i = coerceAtLeast;
                Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> function3 = this.$executeAttempt;
                this.L$0 = listener;
                this.L$1 = str;
                this.L$2 = null;
                this.L$3 = null;
                this.I$0 = i;
                this.label = 1;
                invoke = function3.invoke(str, listener, this);
                if (invoke != coroutine_suspended) {
                }
                return coroutine_suspended;
            } else if (i2 == 1) {
                i = this.I$0;
                str = (String) this.L$1;
                archiveUpdaterListener = (ArchiveUpdaterListener) this.L$0;
                ResultKt.throwOnFailure(obj);
                ArchiveUpdaterResult archiveUpdaterResult = (ArchiveUpdaterResult) obj;
                if (!(archiveUpdaterResult instanceof ArchiveUpdaterResult.Failure)) {
                }
                if (failure != null) {
                }
                return archiveUpdaterResult;
            } else if (i2 == 2) {
                i = this.I$0;
                ArchiveUpdaterResult.Failure failure2 = (ArchiveUpdaterResult.Failure) this.L$3;
                ArchiveUpdaterResult archiveUpdaterResult2 = (ArchiveUpdaterResult) this.L$2;
                String str3 = (String) this.L$1;
                archiveUpdaterListener = (ArchiveUpdaterListener) this.L$0;
                ResultKt.throwOnFailure(obj);
                String str4 = (String) obj;
                if (str4 != null) {
                    return archiveUpdaterResult2;
                }
                i--;
                str = str4;
                listener = archiveUpdaterListener;
                Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> function32 = this.$executeAttempt;
                this.L$0 = listener;
                this.L$1 = str;
                this.L$2 = null;
                this.L$3 = null;
                this.I$0 = i;
                this.label = 1;
                invoke = function32.invoke(str, listener, this);
                if (invoke != coroutine_suspended) {
                    archiveUpdaterListener = listener;
                    obj = invoke;
                    ArchiveUpdaterResult archiveUpdaterResult3 = (ArchiveUpdaterResult) obj;
                    failure = !(archiveUpdaterResult3 instanceof ArchiveUpdaterResult.Failure) ? (ArchiveUpdaterResult.Failure) archiveUpdaterResult3 : null;
                    if (failure != null) {
                        ArchiveMirrorRetryPolicy archiveMirrorRetryPolicy = ArchiveMirrorRetryPolicy.INSTANCE;
                        function02 = this.this$0.hasValidatedNetwork;
                        boolean shouldRotateDownloadMirror = archiveMirrorRetryPolicy.shouldRotateDownloadMirror(failure, ((Boolean) function02.invoke()).booleanValue());
                        if (shouldRotateDownloadMirror && i > 1) {
                            this.L$0 = archiveUpdaterListener;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            this.L$2 = archiveUpdaterResult3;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(failure);
                            this.I$0 = i;
                            this.Z$0 = shouldRotateDownloadMirror;
                            this.label = 2;
                            prepareMirrorRetry = this.this$0.prepareMirrorRetry(this.$plan, failure, str, this);
                            if (prepareMirrorRetry != coroutine_suspended) {
                                archiveUpdaterResult2 = archiveUpdaterResult3;
                                obj = prepareMirrorRetry;
                                String str42 = (String) obj;
                                if (str42 != null) {
                                }
                            }
                        }
                    }
                    return archiveUpdaterResult3;
                }
                return coroutine_suspended;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineDispatcher coroutineDispatcher;
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
        coroutineDispatcher = this.this$0.ioDispatcher;
        this.label = 1;
        Object withContext = BuildersKt.withContext(coroutineDispatcher, new AnonymousClass1(this.this$0, this.$initialServer, this.$executeAttempt, this.$plan, null), this);
        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
    }
}
