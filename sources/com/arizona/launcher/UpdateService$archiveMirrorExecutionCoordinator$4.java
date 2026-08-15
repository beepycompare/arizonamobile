package com.arizona.launcher;

import com.arizona.launcher.util.FileServers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$archiveMirrorExecutionCoordinator$4 extends AdaptedFunctionReference implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$archiveMirrorExecutionCoordinator$4(Object obj) {
        super(1, obj, FileServers.class, "currentGameServerIsUnreachable", "currentGameServerIsUnreachable(Ljava/lang/String;)Ljava/lang/String;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((FileServers) this.receiver).currentGameServerIsUnreachable(p0);
    }
}
