package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndex;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1", f = "ArchiveManifestResolver.kt", i = {0, 0}, l = {223}, m = "invokeSuspend", n = {"$this$coroutineScope", "limiter"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends Integer, ? extends OriginalTzArchivePackageIndex>>>, Object> {
    final /* synthetic */ OriginalTzArchiveManifestDescriptor $descriptor;
    final /* synthetic */ ArrayList<Integer> $remoteSlots;
    final /* synthetic */ String $serverBaseUrl;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ArchiveManifestResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1(ArchiveManifestResolver archiveManifestResolver, ArrayList<Integer> arrayList, OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, String str, Continuation<? super ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1> continuation) {
        super(2, continuation);
        this.this$0 = archiveManifestResolver;
        this.$remoteSlots = arrayList;
        this.$descriptor = originalTzArchiveManifestDescriptor;
        this.$serverBaseUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1 archiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1 = new ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1(this.this$0, this.$remoteSlots, this.$descriptor, this.$serverBaseUrl, continuation);
        archiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1.L$0 = obj;
        return archiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends Integer, ? extends OriginalTzArchivePackageIndex>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Pair<Integer, OriginalTzArchivePackageIndex>>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Pair<Integer, OriginalTzArchivePackageIndex>>> continuation) {
        return ((ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        Deferred async$default;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                Semaphore semaphore = (Semaphore) this.L$1;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        i = this.this$0.indexFetchConcurrency;
        Semaphore Semaphore$default = SemaphoreKt.Semaphore$default(RangesKt.coerceAtLeast(i, 1), 0, 2, null);
        ArrayList<Integer> arrayList = this.$remoteSlots;
        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor = this.$descriptor;
        ArchiveManifestResolver archiveManifestResolver = this.this$0;
        String str = this.$serverBaseUrl;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (Number number : arrayList) {
            ArrayList arrayList3 = arrayList2;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1$1$1(Semaphore$default, originalTzArchiveManifestDescriptor, number.intValue(), archiveManifestResolver, str, null), 3, null);
            arrayList3.add(async$default);
            arrayList2 = arrayList3;
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(Semaphore$default);
        this.label = 1;
        Object awaitAll = AwaitKt.awaitAll(arrayList2, this);
        return awaitAll == coroutine_suspended ? coroutine_suspended : awaitAll;
    }
}
