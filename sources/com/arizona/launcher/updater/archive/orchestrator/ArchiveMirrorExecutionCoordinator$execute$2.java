package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$execute$2", f = "ArchiveMirrorExecutionCoordinator.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, nl = {102}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$execute$2$1", f = "ArchiveMirrorExecutionCoordinator.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {76, 84, 95}, m = "invokeSuspend", n = {"server", "mirrorsRemaining", "progressToken", "server", "result", "mirrorsRemaining", "progressToken", "server", "result", "failure", "mirrorsRemaining", "progressToken", "shouldRotateMirror"}, nl = {77, 85, 96}, s = {"L$0", "I$0", "J$0", "L$0", "L$1", "I$0", "J$0", "L$0", "L$1", "L$2", "I$0", "J$0", "Z$0"}, v = 2)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$execute$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdaterResult>, Object> {
        final /* synthetic */ Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> $executeAttempt;
        final /* synthetic */ String $initialServer;
        final /* synthetic */ ArchiveUpdatePlan $plan;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, Function3<? super String, ? super ArchiveUpdaterListener, ? super Continuation<? super ArchiveUpdaterResult>, ? extends Object> function3, ArchiveUpdatePlan archiveUpdatePlan, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$initialServer = str;
            this.this$0 = archiveMirrorExecutionCoordinator;
            this.$executeAttempt = function3;
            this.$plan = archiveUpdatePlan;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$initialServer, this.this$0, this.$executeAttempt, this.$plan, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdaterResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0117, code lost:
            if (r4 == r0) goto L39;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00db  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0117 -> B:42:0x011a). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String str;
            Function0 function0;
            int coerceAtLeast;
            long j;
            Exception e;
            ArchiveProgressPublicationCoalescer archiveProgressPublicationCoalescer;
            CancellationException e2;
            ArchiveProgressPublicationCoalescer archiveProgressPublicationCoalescer2;
            String str2;
            long j2;
            ArchiveUpdaterResult archiveUpdaterResult;
            int i;
            ArchiveUpdaterResult.Failure failure;
            Function0 function02;
            Object obj2;
            String str3;
            Object publishTerminalProgress;
            long j3;
            long j4;
            ArchiveProgressPublicationCoalescer archiveProgressPublicationCoalescer3;
            ArchiveUpdaterListener listener;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 2;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                str = this.$initialServer;
                function0 = this.this$0.mirrorCount;
                coerceAtLeast = RangesKt.coerceAtLeast(((Number) function0.invoke()).intValue(), 1);
                ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator = this.this$0;
                j3 = archiveMirrorExecutionCoordinator.nextProgressToken;
                archiveMirrorExecutionCoordinator.nextProgressToken = j3 + 1;
                j4 = this.this$0.nextProgressToken;
                archiveProgressPublicationCoalescer3 = this.this$0.progressPublication;
                archiveProgressPublicationCoalescer3.begin(j4);
                Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> function3 = this.$executeAttempt;
                listener = this.this$0.listener(j4);
                this.L$0 = str;
                this.L$1 = null;
                this.L$2 = null;
                this.I$0 = coerceAtLeast;
                this.J$0 = j4;
                this.label = 1;
                obj2 = function3.invoke(str, listener, this);
                if (obj2 != coroutine_suspended) {
                }
                return coroutine_suspended;
            } else if (i2 == 1) {
                j = this.J$0;
                i = this.I$0;
                str3 = (String) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    ArchiveUpdaterResult archiveUpdaterResult2 = (ArchiveUpdaterResult) obj2;
                    this.L$0 = str3;
                    this.L$1 = archiveUpdaterResult2;
                    this.I$0 = i;
                    this.J$0 = j;
                    this.label = i3;
                    publishTerminalProgress = this.this$0.publishTerminalProgress(j, this);
                    if (publishTerminalProgress != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (CancellationException e3) {
                    e2 = e3;
                    archiveProgressPublicationCoalescer2 = this.this$0.progressPublication;
                    archiveProgressPublicationCoalescer2.finish(j);
                    throw e2;
                } catch (Exception e4) {
                    e = e4;
                    archiveProgressPublicationCoalescer = this.this$0.progressPublication;
                    archiveProgressPublicationCoalescer.finish(j);
                    throw e;
                }
            } else if (i2 == 2) {
                long j5 = this.J$0;
                i = this.I$0;
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                archiveUpdaterResult = (ArchiveUpdaterResult) this.L$1;
                j2 = j5;
                if (!(archiveUpdaterResult instanceof ArchiveUpdaterResult.Failure)) {
                }
                if (failure != null) {
                }
                return archiveUpdaterResult;
            } else if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i = this.I$0;
                ArchiveUpdaterResult.Failure failure2 = (ArchiveUpdaterResult.Failure) this.L$2;
                archiveUpdaterResult = (ArchiveUpdaterResult) this.L$1;
                String str4 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object prepareMirrorRetry = obj;
                String str5 = (String) prepareMirrorRetry;
                if (str5 == null) {
                    return archiveUpdaterResult;
                }
                try {
                    coerceAtLeast = i - 1;
                    str = str5;
                    i3 = 2;
                    Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> function32 = this.$executeAttempt;
                    listener = this.this$0.listener(j4);
                    this.L$0 = str;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = coerceAtLeast;
                    this.J$0 = j4;
                    this.label = 1;
                    obj2 = function32.invoke(str, listener, this);
                    if (obj2 != coroutine_suspended) {
                        str3 = str;
                        i = coerceAtLeast;
                        j = j4;
                        ArchiveUpdaterResult archiveUpdaterResult22 = (ArchiveUpdaterResult) obj2;
                        this.L$0 = str3;
                        this.L$1 = archiveUpdaterResult22;
                        this.I$0 = i;
                        this.J$0 = j;
                        this.label = i3;
                        publishTerminalProgress = this.this$0.publishTerminalProgress(j, this);
                        if (publishTerminalProgress != coroutine_suspended) {
                            str2 = str3;
                            j2 = j;
                            archiveUpdaterResult = archiveUpdaterResult22;
                            failure = !(archiveUpdaterResult instanceof ArchiveUpdaterResult.Failure) ? (ArchiveUpdaterResult.Failure) archiveUpdaterResult : null;
                            if (failure != null) {
                                ArchiveMirrorRetryPolicy archiveMirrorRetryPolicy = ArchiveMirrorRetryPolicy.INSTANCE;
                                function02 = this.this$0.hasValidatedNetwork;
                                boolean shouldRotateDownloadMirror = archiveMirrorRetryPolicy.shouldRotateDownloadMirror(failure, ((Boolean) function02.invoke()).booleanValue());
                                if (shouldRotateDownloadMirror && i > 1) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                                    this.L$1 = archiveUpdaterResult;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(failure);
                                    this.I$0 = i;
                                    this.J$0 = j2;
                                    this.Z$0 = shouldRotateDownloadMirror;
                                    this.label = 3;
                                    prepareMirrorRetry = this.this$0.prepareMirrorRetry(this.$plan, failure, str2, this);
                                }
                            }
                            return archiveUpdaterResult;
                        }
                    }
                    return coroutine_suspended;
                } catch (CancellationException e5) {
                    e2 = e5;
                    j = j4;
                    archiveProgressPublicationCoalescer2 = this.this$0.progressPublication;
                    archiveProgressPublicationCoalescer2.finish(j);
                    throw e2;
                } catch (Exception e6) {
                    e = e6;
                    j = j4;
                    archiveProgressPublicationCoalescer = this.this$0.progressPublication;
                    archiveProgressPublicationCoalescer.finish(j);
                    throw e;
                }
                ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator2 = this.this$0;
                j3 = archiveMirrorExecutionCoordinator2.nextProgressToken;
                archiveMirrorExecutionCoordinator2.nextProgressToken = j3 + 1;
                j4 = this.this$0.nextProgressToken;
                archiveProgressPublicationCoalescer3 = this.this$0.progressPublication;
                archiveProgressPublicationCoalescer3.begin(j4);
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
        Object withContext = BuildersKt.withContext(coroutineDispatcher, new AnonymousClass1(this.$initialServer, this.this$0, this.$executeAttempt, this.$plan, null), this);
        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
    }
}
