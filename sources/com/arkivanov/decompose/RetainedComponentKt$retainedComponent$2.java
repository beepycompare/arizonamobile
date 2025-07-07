package com.arkivanov.decompose;

import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetainedComponent.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class RetainedComponentKt$retainedComponent$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RetainedComponentKt$retainedComponent$2(Object obj) {
        super(0, obj, ComponentActivity.class, "isChangingConfigurations", "isChangingConfigurations()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((ComponentActivity) this.receiver).isChangingConfigurations());
    }
}
