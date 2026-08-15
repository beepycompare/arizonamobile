package com.arizona.launcher.updater.archive.download;

import androidx.exifinterface.media.ExifInterface;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1", f = "ArchivePackageDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Function0<Unit>, T> $execute;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1(Function1<? super Function0<Unit>, ? extends T> function1, Continuation<? super ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1> continuation) {
        super(2, continuation);
        this.$execute = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1(this.$execute, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final Job job = JobKt.getJob(getContext());
        return this.$execute.invoke(new Function0() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchivePackageDownloaderKt$runDrainedOwnedBlockingTask$2$execution$1.invokeSuspend$lambda$0(Job.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$0(Job job) {
        if (!job.isActive()) {
            throw new InterruptedException("Owned download was cancelled before task start");
        }
        return Unit.INSTANCE;
    }
}
