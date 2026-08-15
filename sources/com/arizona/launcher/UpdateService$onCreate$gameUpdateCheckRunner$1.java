package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$onCreate$gameUpdateCheckRunner$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$onCreate$gameUpdateCheckRunner$1(Object obj) {
        super(0, obj, UpdateService.class, "isDeviceOnline", "isDeviceOnline()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        boolean isDeviceOnline;
        isDeviceOnline = ((UpdateService) this.receiver).isDeviceOnline();
        return Boolean.valueOf(isDeviceOnline);
    }
}
