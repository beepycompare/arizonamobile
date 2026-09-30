package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver$readRemoteIndex$result$1", f = "ArchiveManifestResolver.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolver$readRemoteIndex$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OriginalTzArchivePackageIndexResult>, Object> {
    final /* synthetic */ OriginalTzArchivePackageDescriptor $packageDescriptor;
    final /* synthetic */ String $serverBaseUrl;
    int label;
    final /* synthetic */ ArchiveManifestResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveManifestResolver$readRemoteIndex$result$1(ArchiveManifestResolver archiveManifestResolver, OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, Continuation<? super ArchiveManifestResolver$readRemoteIndex$result$1> continuation) {
        super(2, continuation);
        this.this$0 = archiveManifestResolver;
        this.$packageDescriptor = originalTzArchivePackageDescriptor;
        this.$serverBaseUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveManifestResolver$readRemoteIndex$result$1(this.this$0, this.$packageDescriptor, this.$serverBaseUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OriginalTzArchivePackageIndexResult> continuation) {
        return ((ArchiveManifestResolver$readRemoteIndex$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OriginalTzArchivePackageIndexSource originalTzArchivePackageIndexSource;
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
        originalTzArchivePackageIndexSource = this.this$0.packageIndexSource;
        this.label = 1;
        Object read = originalTzArchivePackageIndexSource.read(this.$packageDescriptor, this.$serverBaseUrl, this);
        return read == coroutine_suspended ? coroutine_suspended : read;
    }
}
