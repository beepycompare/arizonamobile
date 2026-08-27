package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1", f = "ArchiveUpdateCheckCoordinator.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, nl = {286}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArchiveBootstrapPrefetcher $bootstrapPrefetcher;
    final /* synthetic */ OriginalTzArchiveManifestDescriptor $descriptor;
    final /* synthetic */ String $serverBaseUrl;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1(ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, String str, Continuation<? super ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1> continuation) {
        super(2, continuation);
        this.$bootstrapPrefetcher = archiveBootstrapPrefetcher;
        this.$descriptor = originalTzArchiveManifestDescriptor;
        this.$serverBaseUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1(this.$bootstrapPrefetcher, this.$descriptor, this.$serverBaseUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$bootstrapPrefetcher.prefetch(this.$descriptor.getPackages(), this.$serverBaseUrl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
