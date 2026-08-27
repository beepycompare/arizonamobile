package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeStreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolverKt$asBufferedStreamer$1 implements ArchiveByteRangeStreamer {
    final /* synthetic */ ArchiveByteRangeSource $this_asBufferedStreamer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchiveManifestResolverKt$asBufferedStreamer$1(ArchiveByteRangeSource archiveByteRangeSource) {
        this.$this_asBufferedStreamer = archiveByteRangeSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeStreamer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stream(ArchiveByteRangeRequest archiveByteRangeRequest, Function1<? super InputStream, Unit> function1, Continuation<? super ArchiveByteRangeStreamResult> continuation) {
        ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1 archiveManifestResolverKt$asBufferedStreamer$1$stream$1;
        int i;
        ArchiveByteRangeResult archiveByteRangeResult;
        if (continuation instanceof ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1) {
            archiveManifestResolverKt$asBufferedStreamer$1$stream$1 = (ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1) continuation;
            if ((archiveManifestResolverKt$asBufferedStreamer$1$stream$1.label & Integer.MIN_VALUE) != 0) {
                archiveManifestResolverKt$asBufferedStreamer$1$stream$1.label -= Integer.MIN_VALUE;
                Object obj = archiveManifestResolverKt$asBufferedStreamer$1$stream$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveManifestResolverKt$asBufferedStreamer$1$stream$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArchiveByteRangeSource archiveByteRangeSource = this.$this_asBufferedStreamer;
                    archiveManifestResolverKt$asBufferedStreamer$1$stream$1.L$0 = SpillingKt.nullOutSpilledVariable(archiveByteRangeRequest);
                    archiveManifestResolverKt$asBufferedStreamer$1$stream$1.L$1 = function1;
                    archiveManifestResolverKt$asBufferedStreamer$1$stream$1.label = 1;
                    obj = archiveByteRangeSource.fetch(archiveByteRangeRequest, archiveManifestResolverKt$asBufferedStreamer$1$stream$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    function1 = (Function1) archiveManifestResolverKt$asBufferedStreamer$1$stream$1.L$1;
                    ArchiveByteRangeRequest archiveByteRangeRequest2 = (ArchiveByteRangeRequest) archiveManifestResolverKt$asBufferedStreamer$1$stream$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Success)) {
                    ArchiveByteRangeResult.Success success = (ArchiveByteRangeResult.Success) archiveByteRangeResult;
                    function1.invoke(new ByteArrayInputStream(success.getResponse().getBytes()));
                    return new ArchiveByteRangeStreamResult.Success(success.getResponse().getStrongEtag(), success.getResponse().getEffectiveUrl(), success.getResponse().getBytes().length);
                } else if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ArchiveByteRangeResult.Failure failure = (ArchiveByteRangeResult.Failure) archiveByteRangeResult;
                    return new ArchiveByteRangeStreamResult.Failure(failure.getCode(), failure.getHttpStatus(), failure.getDetail());
                }
            }
        }
        archiveManifestResolverKt$asBufferedStreamer$1$stream$1 = new ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1(this, continuation);
        Object obj2 = archiveManifestResolverKt$asBufferedStreamer$1$stream$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveManifestResolverKt$asBufferedStreamer$1$stream$1.label;
        if (i != 0) {
        }
        archiveByteRangeResult = (ArchiveByteRangeResult) obj2;
        if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Success)) {
        }
    }
}
