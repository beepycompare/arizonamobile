package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherApkCleanupResult;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LauncherApkDownloader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherApkDownloader$cleanupTemporaryArtifacts$2", f = "LauncherApkDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class LauncherApkDownloader$cleanupTemporaryArtifacts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LauncherApkCleanupResult>, Object> {
    final /* synthetic */ File $destination;
    int label;
    final /* synthetic */ LauncherApkDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherApkDownloader$cleanupTemporaryArtifacts$2(File file, LauncherApkDownloader launcherApkDownloader, Continuation<? super LauncherApkDownloader$cleanupTemporaryArtifacts$2> continuation) {
        super(2, continuation);
        this.$destination = file;
        this.this$0 = launcherApkDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherApkDownloader$cleanupTemporaryArtifacts$2(this.$destination, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LauncherApkCleanupResult> continuation) {
        return ((LauncherApkDownloader$cleanupTemporaryArtifacts$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LauncherApkResumeStore launcherApkResumeStore;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            File canonicalFile = this.$destination.getCanonicalFile();
            File parentFile = canonicalFile.getParentFile();
            if (parentFile == null) {
                return new LauncherApkCleanupResult.Failure(new IOException("Launcher APK destination has no parent directory"));
            }
            String path = canonicalFile.getPath();
            Object obj2 = new Object();
            LauncherApkDestinationRegistry launcherApkDestinationRegistry = LauncherApkDestinationRegistry.INSTANCE;
            Intrinsics.checkNotNull(path);
            try {
                if (!launcherApkDestinationRegistry.tryAcquire(path, obj2)) {
                    return LauncherApkCleanupResult.DestinationBusy.INSTANCE;
                }
                File file = new File(parentFile, canonicalFile.getName() + LauncherApkDownloader.PARTIAL_SUFFIX);
                launcherApkResumeStore = this.this$0.resumeStore;
                boolean delete = launcherApkResumeStore.delete(file);
                boolean exists = file.exists();
                if (exists && !file.delete()) {
                    throw new IOException("Unable to delete partial launcher APK");
                }
                return new LauncherApkCleanupResult.Success(exists, delete);
            } catch (IOException e) {
                return new LauncherApkCleanupResult.Failure(e);
            } finally {
                LauncherApkDestinationRegistry.INSTANCE.release(path, obj2);
            }
        } catch (IOException e2) {
            return new LauncherApkCleanupResult.Failure(e2);
        }
    }
}
