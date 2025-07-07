package ru.mrlargha.arizonaui.mobile.presentation.page.driver;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneDriverOrderPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneDriverOrder;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: DriverOrder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/driver/DriverOrder;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "driverOrder", "Landroidx/constraintlayout/widget/ConstraintLayout;", "driverOrderBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneDriverOrderPageBinding;", "updateOrderInfo", "", "orderInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneDriverOrder;", "setGreenButtonText", "text", "", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DriverOrder implements MobileController {
    private final Activity context;
    private final ConstraintLayout driverOrder;
    private final MobilePhoneDriverOrderPageBinding driverOrderBinding;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public DriverOrder() {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobilePhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.context = context;
        MobilePhoneBinding binding = mobilePhone.getBinding();
        this.phoneBinding = binding;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.sendFrontedMessage = (IBackendNotifier) context;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_driver_order_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.driverOrder = constraintLayout;
        MobilePhoneDriverOrderPageBinding bind = MobilePhoneDriverOrderPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.driverOrderBinding = bind;
        HistoryManager.Companion.push(MobilePhonePage.DRIVER_ORDER.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mobile_driver_order_bg));
        binding.phoneCaseContainer.addView(bind.mpDriverOrderPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpDriverOrderPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4, 8);
        constraintSet.connect(bind.mpDriverOrderPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpDriverOrderPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.driverAcceptButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverOrder._init_$lambda$0(DriverOrder.this, view);
            }
        });
        bind.driverDeclineButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverOrder._init_$lambda$1(DriverOrder.this, view);
            }
        });
        bind.mpDriverHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverOrder._init_$lambda$2(DriverOrder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(DriverOrder driverOrder, View view) {
        driverOrder.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(DriverOrder driverOrder, View view) {
        driverOrder.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(DriverOrder driverOrder, View view) {
        HistoryManager.Companion.clearAllHistory();
        HistoryManager.Companion.clearThisPage(MobilePhonePage.DRIVER_ORDER.getId());
        HistoryManager.Companion.clearThisPage(MobilePhonePage.DRIVER_ORDERS.getId());
        driverOrder.driverOrder.removeAllViews();
        HistoryManager.Companion.getOrCreatePage(0);
    }

    public final void updateOrderInfo(MobilePhoneDriverOrder orderInfo) {
        Intrinsics.checkNotNullParameter(orderInfo, "orderInfo");
        TextView textView = this.driverOrderBinding.driverCurrentOrderClientName;
        String name = orderInfo.getName();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        textView.setText(sb.toString());
        this.driverOrderBinding.driverRate.setText(String.valueOf(orderInfo.getDriverRating()));
        this.driverOrderBinding.driverCurrentOrderRate.setText(String.valueOf(orderInfo.getRating()));
        this.driverOrderBinding.driverDistnace.setText(orderInfo.getDistance() + " м");
        this.driverOrderBinding.driverName.setText(StringsKt.replace$default(orderInfo.getDriverName(), "_", " ", false, 4, (Object) null));
    }

    public final void setGreenButtonText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.driverOrderBinding.driverAcceptButtonText;
        String str = text;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        textView.setText(sb.toString());
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.DRIVER_ORDER.getId());
        this.driverOrder.removeAllViews();
    }
}
