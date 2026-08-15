package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherUpdateServiceFlow.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class LauncherUpdateServiceFlow$controller$1 extends FunctionReferenceImpl implements Function1<Long, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LauncherUpdateServiceFlow$controller$1(Object obj) {
        super(1, obj, LauncherUpdateServiceFlow.class, "isCurrentControllerOperation", "isCurrentControllerOperation(J)Z", 0);
    }

    public final Boolean invoke(long j) {
        boolean isCurrentControllerOperation;
        isCurrentControllerOperation = ((LauncherUpdateServiceFlow) this.receiver).isCurrentControllerOperation(j);
        return Boolean.valueOf(isCurrentControllerOperation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return invoke(l.longValue());
    }
}
