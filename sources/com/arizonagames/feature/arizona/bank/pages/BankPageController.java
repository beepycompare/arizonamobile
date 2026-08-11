package com.arizonagames.feature.arizona.bank.pages;

import android.content.Context;
import android.view.View;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.ui.BankContentTransitionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
/* compiled from: BankPageController.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "bind", "", "payload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "resetState", "setVisible", "visible", "", "animate", "direction", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BankPageController {
    default void bind(BankScreenPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
    }

    BankPage getPage();

    View getRoot();

    default void resetState() {
    }

    /* compiled from: BankPageController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static IBackendNotifier getNotifier(BankPageController bankPageController) {
            return BankPageController.super.getNotifier();
        }

        @Deprecated
        public static void bind(BankPageController bankPageController, BankScreenPayload payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            BankPageController.super.bind(payload);
        }

        @Deprecated
        public static void resetState(BankPageController bankPageController) {
            BankPageController.super.resetState();
        }

        @Deprecated
        public static void setVisible(BankPageController bankPageController, boolean z, boolean z2, int i) {
            BankPageController.super.setVisible(z, z2, i);
        }
    }

    default IBackendNotifier getNotifier() {
        Context context = getRoot().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        return (IBackendNotifier) context;
    }

    static /* synthetic */ void setVisible$default(BankPageController bankPageController, boolean z, boolean z2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVisible");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        bankPageController.setVisible(z, z2, i);
    }

    default void setVisible(boolean z, boolean z2, int i) {
        if (z) {
            BankContentTransitionKt.showBankContentTransition(getRoot(), i, z2);
        } else {
            BankContentTransitionKt.hideBankContentTransition(getRoot(), i, z2);
        }
    }
}
