package com.arizona.launcher.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: FileServers.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class FileServers$gamePool$1 extends FunctionReferenceImpl implements Function0<String[]> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FileServers$gamePool$1(Object obj) {
        super(0, obj, FileServers.class, "buildGameServers", "buildGameServers()[Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String[] invoke() {
        String[] buildGameServers;
        buildGameServers = ((FileServers) this.receiver).buildGameServers();
        return buildGameServers;
    }
}
