package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.install.WholeFileCrc32Verifier;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationResult;
import java.io.File;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class ArchivePackageUpdater$Companion$create$2 implements ArchiveVerifier, FunctionAdapter {
    final /* synthetic */ WholeFileCrc32Verifier $tmp0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchivePackageUpdater$Companion$create$2(WholeFileCrc32Verifier wholeFileCrc32Verifier) {
        this.$tmp0 = wholeFileCrc32Verifier;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ArchiveVerifier) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(3, this.$tmp0, WholeFileCrc32Verifier.class, "verify", "verify(Ljava/io/File;JJ)Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveVerifier
    public final WholeFileVerificationResult verify(File p0, long j, long j2) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return this.$tmp0.verify(p0, j, j2);
    }
}
