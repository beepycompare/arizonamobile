package com.arizona.launcher;

import com.arizona.launcher.util.FileServers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$onCreate$9 extends FunctionReferenceImpl implements Function0<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$onCreate$9(Object obj) {
        super(0, obj, FileServers.class, "getCurrentLauncherServer", "getCurrentLauncherServer()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return ((FileServers) this.receiver).getCurrentLauncherServer();
    }
}
