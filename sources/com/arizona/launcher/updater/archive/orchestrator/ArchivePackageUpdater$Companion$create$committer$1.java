package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.io.AndroidArchiveLivePayloadAccess;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class ArchivePackageUpdater$Companion$create$committer$1 extends FunctionReferenceImpl implements Function2<File, File, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchivePackageUpdater$Companion$create$committer$1(Object obj) {
        super(2, obj, AndroidArchiveLivePayloadAccess.class, "apply", "apply(Ljava/io/File;Ljava/io/File;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(File file, File file2) {
        invoke2(file, file2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(File p0, File p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((AndroidArchiveLivePayloadAccess) this.receiver).apply(p0, p1);
    }
}
