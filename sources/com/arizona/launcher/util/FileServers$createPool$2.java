package com.arizona.launcher.util;

import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileServers.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class FileServers$createPool$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FileServers$createPool$2(Object obj) {
        super(1, obj, FirebaseConfigHelper.class, "isServiceAvailable", "isServiceAvailable(Ljava/lang/String;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(((FirebaseConfigHelper) this.receiver).isServiceAvailable(p0));
    }
}
