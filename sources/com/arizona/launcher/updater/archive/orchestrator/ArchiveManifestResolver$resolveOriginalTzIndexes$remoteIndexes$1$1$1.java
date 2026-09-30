package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.Semaphore;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndex;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1", f = "ArchiveManifestResolver.kt", i = {0, 1, 1}, l = {1003, 210}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "packageDescriptor"}, nl = {1004, 209}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
final class ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends OriginalTzArchivePackageIndex>>, Object> {
    final /* synthetic */ OriginalTzArchiveManifestDescriptor $descriptor;
    final /* synthetic */ Semaphore $limiter;
    final /* synthetic */ String $serverBaseUrl;
    final /* synthetic */ int $slot;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ArchiveManifestResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1(Semaphore semaphore, OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, int i, ArchiveManifestResolver archiveManifestResolver, String str, Continuation<? super ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1> continuation) {
        super(2, continuation);
        this.$limiter = semaphore;
        this.$descriptor = originalTzArchiveManifestDescriptor;
        this.$slot = i;
        this.this$0 = archiveManifestResolver;
        this.$serverBaseUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1(this.$limiter, this.$descriptor, this.$slot, this.this$0, this.$serverBaseUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends OriginalTzArchivePackageIndex>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, OriginalTzArchivePackageIndex>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, OriginalTzArchivePackageIndex>> continuation) {
        return ((ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #1 {all -> 0x001d, blocks: (B:7:0x0018, B:22:0x008d, B:24:0x0093, B:27:0x00a5, B:29:0x00a9, B:30:0x00bf, B:31:0x00c0, B:32:0x00c5), top: B:39:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5 A[Catch: all -> 0x001d, TRY_ENTER, TryCatch #1 {all -> 0x001d, blocks: (B:7:0x0018, B:22:0x008d, B:24:0x0093, B:27:0x00a5, B:29:0x00a9, B:30:0x00bf, B:31:0x00c0, B:32:0x00c5), top: B:39:0x0018 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Semaphore semaphore;
        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor;
        int i;
        ArchiveManifestResolver archiveManifestResolver;
        String str;
        Throwable th;
        Semaphore semaphore2;
        Object readRemoteIndex;
        int i2;
        OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor;
        OriginalTzArchivePackageIndexResult originalTzArchivePackageIndexResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                semaphore = this.$limiter;
                originalTzArchiveManifestDescriptor = this.$descriptor;
                i = this.$slot;
                archiveManifestResolver = this.this$0;
                String str2 = this.$serverBaseUrl;
                this.L$0 = semaphore;
                this.L$1 = originalTzArchiveManifestDescriptor;
                this.L$2 = archiveManifestResolver;
                this.L$3 = str2;
                this.I$0 = i;
                this.label = 1;
                if (semaphore.acquire(this) != coroutine_suspended) {
                    str = str2;
                }
                return coroutine_suspended;
            } else if (i3 != 1) {
                if (i3 == 2) {
                    i2 = this.I$0;
                    originalTzArchivePackageDescriptor = (OriginalTzArchivePackageDescriptor) this.L$1;
                    semaphore2 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        originalTzArchivePackageIndexResult = (OriginalTzArchivePackageIndexResult) obj;
                        if (!(originalTzArchivePackageIndexResult instanceof OriginalTzArchivePackageIndexResult.Success)) {
                            Pair pair = TuplesKt.to(Boxing.boxInt(i2), ((OriginalTzArchivePackageIndexResult.Success) originalTzArchivePackageIndexResult).getIndex());
                            semaphore2.release();
                            return pair;
                        } else if (!(originalTzArchivePackageIndexResult instanceof OriginalTzArchivePackageIndexResult.Failure)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            throw new OriginalTzRemoteIndexException(originalTzArchivePackageDescriptor.getId(), ((OriginalTzArchivePackageIndexResult.Failure) originalTzArchivePackageIndexResult).getCode(), ((OriginalTzArchivePackageIndexResult.Failure) originalTzArchivePackageIndexResult).getDetail());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        semaphore2.release();
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i = this.I$0;
                str = (String) this.L$3;
                archiveManifestResolver = (ArchiveManifestResolver) this.L$2;
                originalTzArchiveManifestDescriptor = (OriginalTzArchiveManifestDescriptor) this.L$1;
                ResultKt.throwOnFailure(obj);
                semaphore = (Semaphore) this.L$0;
            }
            JobKt.ensureActive(getContext());
            OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor2 = originalTzArchiveManifestDescriptor.getPackages().get(i);
            this.L$0 = semaphore;
            this.L$1 = originalTzArchivePackageDescriptor2;
            this.L$2 = null;
            this.L$3 = null;
            this.I$0 = i;
            this.label = 2;
            readRemoteIndex = archiveManifestResolver.readRemoteIndex(originalTzArchivePackageDescriptor2, str, this);
            if (readRemoteIndex != coroutine_suspended) {
                Semaphore semaphore3 = semaphore;
                obj = readRemoteIndex;
                semaphore2 = semaphore3;
                i2 = i;
                originalTzArchivePackageDescriptor = originalTzArchivePackageDescriptor2;
                originalTzArchivePackageIndexResult = (OriginalTzArchivePackageIndexResult) obj;
                if (!(originalTzArchivePackageIndexResult instanceof OriginalTzArchivePackageIndexResult.Success)) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Semaphore semaphore4 = semaphore;
            th = th3;
            semaphore2 = semaphore4;
            semaphore2.release();
            throw th;
        }
    }
}
