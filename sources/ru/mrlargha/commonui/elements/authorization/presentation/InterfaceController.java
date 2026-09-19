package ru.mrlargha.commonui.elements.authorization.presentation;

import kotlin.Metadata;
/* compiled from: InterfaceController.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "", "setVisible", "", "visible", "", "onRemovedFromAuthorizationFlow", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface InterfaceController {
    default void onRemovedFromAuthorizationFlow() {
    }

    void setVisible(boolean z);

    /* compiled from: InterfaceController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onRemovedFromAuthorizationFlow(InterfaceController interfaceController) {
            InterfaceController.super.onRemovedFromAuthorizationFlow();
        }
    }
}
