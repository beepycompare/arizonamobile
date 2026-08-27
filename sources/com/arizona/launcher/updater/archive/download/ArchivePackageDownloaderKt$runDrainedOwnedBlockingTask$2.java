package com.arizona.launcher.updater.archive.download;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.NonCancellable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2", f = "ArchivePackageDownloader.kt", i = {0, 0, 1, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS, 92}, m = "invokeSuspend", n = {"$this$supervisorScope", "execution", "$this$supervisorScope", "execution", "cancelled"}, nl = {90, 95}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function0<Unit> $cancelIfOwned;
    final /* synthetic */ CoroutineDispatcher $dispatcher;
    final /* synthetic */ Function1<Function0<Unit>, T> $execute;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2(CoroutineDispatcher coroutineDispatcher, Function0<Unit> function0, Function1<? super Function0<Unit>, ? extends T> function1, Continuation<? super ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2> continuation) {
        super(2, continuation);
        this.$dispatcher = coroutineDispatcher;
        this.$cancelIfOwned = function0;
        this.$execute = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2 archivePackageDownloaderKt$runDrainedOwnedBlockingTask$2 = new ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2(this.$dispatcher, this.$cancelIfOwned, this.$execute, continuation);
        archivePackageDownloaderKt$runDrainedOwnedBlockingTask$2.L$0 = obj;
        return archivePackageDownloaderKt$runDrainedOwnedBlockingTask$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0089: INVOKE  
      (r3v1 ?? I:com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$2)
      (r2 I:kotlinx.coroutines.Deferred)
      (r8 I:kotlin.coroutines.Continuation)
     type: DIRECT call: com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2.2.<init>(kotlinx.coroutines.Deferred, kotlin.coroutines.Continuation):void, block:B:26:0x0083 */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlinx.coroutines.Deferred, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9919constructorimpl;
        ?? anonymousClass2;
        Deferred async$default;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            Function0<Unit> function0 = this.$cancelIfOwned;
            try {
                Result.Companion companion = Result.Companion;
                m9919constructorimpl = Result.m9919constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m9922exceptionOrNullimpl = Result.m9922exceptionOrNullimpl(m9919constructorimpl);
            if (m9922exceptionOrNullimpl != null) {
                e.addSuppressed(m9922exceptionOrNullimpl);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass2);
            this.L$2 = e;
            this.label = 2;
            if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass2(anonymousClass2, null), this) != coroutine_suspended) {
                throw e;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, this.$dispatcher, null, new ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1(this.$execute, null), 2, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = async$default;
            this.label = 1;
            Object await = async$default.await(this);
            return await == coroutine_suspended ? coroutine_suspended : await;
        } else if (i == 1) {
            Deferred deferred = (Deferred) this.L$1;
            ResultKt.throwOnFailure(obj);
            return obj;
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            CancellationException cancellationException = (CancellationException) this.L$2;
            Deferred deferred2 = (Deferred) this.L$1;
            ResultKt.throwOnFailure(obj);
            throw cancellationException;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchivePackageDownloader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$2", f = "ArchivePackageDownloader.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, nl = {94}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Deferred<T> $execution;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Deferred<? extends T> deferred, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$execution = deferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$execution, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$execution.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
