package ru.mrlargha.commonui.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UIElementStore.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class UIElementStore$getInventoryCompanionPayloadTarget$1 extends FunctionReferenceImpl implements Function1<UIElementID, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UIElementStore$getInventoryCompanionPayloadTarget$1(Object obj) {
        super(1, obj, UIElementStore.class, "isElementExist", "isElementExist(Lru/mrlargha/commonui/core/UIElementID;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(UIElementID p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(((UIElementStore) this.receiver).isElementExist(p0));
    }
}
