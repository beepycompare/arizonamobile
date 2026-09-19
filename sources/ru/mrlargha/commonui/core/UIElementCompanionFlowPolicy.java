package ru.mrlargha.commonui.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UIElementCompanionFlowPolicy.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/core/UIElementCompanionFlowPolicy;", "", "<init>", "()V", "isTarget", "", "elementID", "Lru/mrlargha/commonui/core/UIElementID;", "startsPendingOpen", "subId", "", "OPEN_FLOW_SUB_ID", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UIElementCompanionFlowPolicy {
    public static final UIElementCompanionFlowPolicy INSTANCE = new UIElementCompanionFlowPolicy();
    private static final int OPEN_FLOW_SUB_ID = 0;

    private UIElementCompanionFlowPolicy() {
    }

    public final boolean isTarget(UIElementID elementID) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        return elementID == UIElementID.TRADE || elementID == UIElementID.ARIZONA_GLOVO || elementID == UIElementID.WORKSHOP;
    }

    public final boolean startsPendingOpen(UIElementID elementID, int i) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        if (i == 0) {
            return elementID == UIElementID.TRADE || elementID == UIElementID.ARIZONA_GLOVO;
        }
        return false;
    }
}
