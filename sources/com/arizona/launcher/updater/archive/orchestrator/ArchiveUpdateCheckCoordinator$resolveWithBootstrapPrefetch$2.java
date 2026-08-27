package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolutionResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2", f = "ArchiveUpdateCheckCoordinator.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {295, 301, 301}, m = "invokeSuspend", n = {"$this$coroutineScope", "prefetch", "resolution", "$this$coroutineScope", "prefetch", "resolution", "$this$coroutineScope", "prefetch", "resolution"}, nl = {296, 304, 304}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveManifestResolutionResult>, Object> {
    final /* synthetic */ ArchiveBootstrapPrefetcher $bootstrapPrefetcher;
    final /* synthetic */ ArchiveManifestCandidate $candidate;
    final /* synthetic */ OriginalTzArchiveManifestDescriptor $descriptor;
    final /* synthetic */ ArchiveUpdaterState $loadedState;
    final /* synthetic */ String $serverBaseUrl;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ArchiveUpdateCheckCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, ArchiveManifestCandidate archiveManifestCandidate, String str, ArchiveUpdaterState archiveUpdaterState, OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, Continuation<? super ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2> continuation) {
        super(2, continuation);
        this.this$0 = archiveUpdateCheckCoordinator;
        this.$candidate = archiveManifestCandidate;
        this.$serverBaseUrl = str;
        this.$loadedState = archiveUpdaterState;
        this.$descriptor = originalTzArchiveManifestDescriptor;
        this.$bootstrapPrefetcher = archiveBootstrapPrefetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2 archiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2 = new ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2(this.this$0, this.$candidate, this.$serverBaseUrl, this.$loadedState, this.$descriptor, this.$bootstrapPrefetcher, continuation);
        archiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2.L$0 = obj;
        return archiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveManifestResolutionResult> continuation) {
        return ((ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cf  */
    /* JADX WARN: Type inference failed for: r5v11, types: [T, com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolutionResult] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        File file;
        ArchivePackageArtifactCleaner archivePackageArtifactCleaner;
        File file2;
        File file3;
        Job launch$default;
        Ref.ObjectRef objectRef2;
        ArchiveManifestResolver archiveManifestResolver;
        Object resolve;
        ArchiveManifestResolutionResult archiveManifestResolutionResult;
        Ref.ObjectRef objectRef3;
        File file4;
        ArchivePackageArtifactCleaner archivePackageArtifactCleaner2;
        File file5;
        File file6;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            th = th;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(launch$default);
            this.L$2 = objectRef2;
            this.L$3 = th;
            this.label = 3;
            if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass2(launch$default, null), this) != coroutine_suspended) {
                objectRef = objectRef2;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$prefetch$1(this.$bootstrapPrefetcher, this.$descriptor, this.$serverBaseUrl, null), 1, null);
            objectRef2 = new Ref.ObjectRef();
            archiveManifestResolver = this.this$0.manifestResolver;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = launch$default;
            this.L$2 = objectRef2;
            this.label = 1;
            resolve = archiveManifestResolver.resolve(this.$candidate, this.$serverBaseUrl, this.$loadedState, this);
            if (resolve == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                archiveManifestResolutionResult = (ArchiveManifestResolutionResult) this.L$3;
                objectRef3 = (Ref.ObjectRef) this.L$2;
                Job job = (Job) this.L$1;
                ResultKt.throwOnFailure(obj);
                if (objectRef3.element instanceof ArchiveManifestResolutionResult.Failure) {
                    file4 = this.this$0.downloadRoot;
                    if (file4 != null) {
                        try {
                            archivePackageArtifactCleaner2 = this.this$0.artifactCleaner;
                            file5 = this.this$0.gameRoot;
                            if (file5 != null) {
                                file6 = this.this$0.downloadRoot;
                                List<OriginalTzArchivePackageDescriptor> packages = this.$descriptor.getPackages();
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
                                for (OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor : packages) {
                                    arrayList.add(new ArchivePackageIdentity(originalTzArchivePackageDescriptor.getId(), originalTzArchivePackageDescriptor.getArchiveSize(), originalTzArchivePackageDescriptor.getCrc32()));
                                }
                                archivePackageArtifactCleaner2.cleanup(file5, file6, arrayList);
                                return archiveManifestResolutionResult;
                            }
                            throw new IllegalStateException("Required value was null.".toString());
                        } catch (Exception e) {
                            throw new ArchiveUpdateCheckCoordinator.ArchiveBootstrapPrefetchCleanupException(e);
                        }
                    }
                }
                return archiveManifestResolutionResult;
            } else if (i == 3) {
                th = (Throwable) this.L$3;
                objectRef = (Ref.ObjectRef) this.L$2;
                Job job2 = (Job) this.L$1;
                ResultKt.throwOnFailure(obj);
                if (objectRef.element instanceof ArchiveManifestResolutionResult.Failure) {
                    file = this.this$0.downloadRoot;
                    if (file != null) {
                        try {
                            archivePackageArtifactCleaner = this.this$0.artifactCleaner;
                            file2 = this.this$0.gameRoot;
                            if (file2 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            file3 = this.this$0.downloadRoot;
                            List<OriginalTzArchivePackageDescriptor> packages2 = this.$descriptor.getPackages();
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages2, 10));
                            for (OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor2 : packages2) {
                                arrayList2.add(new ArchivePackageIdentity(originalTzArchivePackageDescriptor2.getId(), originalTzArchivePackageDescriptor2.getArchiveSize(), originalTzArchivePackageDescriptor2.getCrc32()));
                            }
                            archivePackageArtifactCleaner.cleanup(file2, file3, arrayList2);
                        } catch (Exception e2) {
                            throw new ArchiveUpdateCheckCoordinator.ArchiveBootstrapPrefetchCleanupException(e2);
                        }
                    }
                }
                throw th;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            objectRef2 = (Ref.ObjectRef) this.L$2;
            launch$default = (Job) this.L$1;
            ResultKt.throwOnFailure(obj);
            resolve = obj;
        }
        objectRef2.element = (ArchiveManifestResolutionResult) resolve;
        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) resolve;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(launch$default);
        this.L$2 = objectRef2;
        this.L$3 = archiveManifestResolutionResult;
        this.label = 2;
        if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass2(launch$default, null), this) != coroutine_suspended) {
            objectRef3 = objectRef2;
            if (objectRef3.element instanceof ArchiveManifestResolutionResult.Failure) {
            }
            return archiveManifestResolutionResult;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$2", f = "ArchiveUpdateCheckCoordinator.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, nl = {303}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $prefetch;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Job job, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$prefetch = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$prefetch, continuation);
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
                if (JobKt.cancelAndJoin(this.$prefetch, this) == coroutine_suspended) {
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
