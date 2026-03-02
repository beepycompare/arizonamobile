package ru.mrlargha.feature.mobile.presentation;

import android.app.Activity;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.feature.mobile.domain.enums.MobilePhonePage;
/* compiled from: MobilePage.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0004J\b\u0010\u001f\u001a\u00020\u001eH\u0004J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$J\b\u0010'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/MobilePage;", "Lru/mrlargha/feature/mobile/presentation/MobileController;", "pageId", "", "<init>", "(I)V", "getPageId", "()I", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "getMobilePhone", "()Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "getBackendNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "isOpen", "", "()Z", "setOpen", "(Z)V", "navigateTo", "", "closeApp", "sendEvent", "subId", "Lru/mrlargha/feature/mobile/presentation/MobilePhoneGetSubIds;", "data", "", "sendFrontendMessage", "id", "renderPage", "removePage", "hidePage", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class MobilePage implements MobileController {
    private final IBackendNotifier backendNotifier;
    private final Activity context;
    private boolean isOpen;
    private final MobilePhone mobilePhone;
    private final int pageId;

    public abstract View getView();

    public void sendEvent(MobilePhoneGetSubIds subId, String data) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public MobilePage(int i) {
        this.pageId = i;
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobilePhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.context = context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.backendNotifier = (IBackendNotifier) context;
    }

    public final int getPageId() {
        return this.pageId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MobilePhone getMobilePhone() {
        return this.mobilePhone;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity getContext() {
        return this.context;
    }

    protected final IBackendNotifier getBackendNotifier() {
        return this.backendNotifier;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isOpen() {
        return this.isOpen;
    }

    protected final void setOpen(boolean z) {
        this.isOpen = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void navigateTo(int i) {
        HistoryManager.Companion.getOrCreatePage(i).renderPage();
        hidePage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void closeApp() {
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MAIN_PAGE.getId());
        removePage();
    }

    public static /* synthetic */ void sendFrontendMessage$default(MobilePage mobilePage, int i, int i2, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFrontendMessage");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        mobilePage.sendFrontendMessage(i, i2, str);
    }

    public final void sendFrontendMessage(int i, int i2, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IBackendNotifier iBackendNotifier = this.backendNotifier;
        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, i2, i, bytes);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobileController
    public void renderPage() {
        this.isOpen = true;
        ConstraintLayout phoneCaseContainer = this.mobilePhone.getBinding().phoneCaseContainer;
        Intrinsics.checkNotNullExpressionValue(phoneCaseContainer, "phoneCaseContainer");
        if (phoneCaseContainer.indexOfChild(getView()) != -1) {
            return;
        }
        this.mobilePhone.getBinding().phoneCaseContainer.addView(getView());
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobileController
    public void removePage() {
        this.isOpen = false;
        this.mobilePhone.getBinding().phoneCaseContainer.removeView(getView());
        HistoryManager.Companion.clearThisPage(this.pageId);
    }

    public void hidePage() {
        this.isOpen = false;
    }
}
