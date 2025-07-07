package ru.mrlargha.arizonaui.mobile.presentation.page.driver;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneDriverOrdersPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneDriverOrder;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneDriverWorkInfo;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneDriverOrdersAdapter;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: DriverOrders.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/driver/DriverOrders;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "driverOrders", "Landroidx/constraintlayout/widget/ConstraintLayout;", "driverOrdersBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneDriverOrdersPageBinding;", "driverOrdersAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter;", "addOrders", "", "orders", "", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneDriverOrder;", "clearOrders", "setWorkingButton", "workingButton", "", "setWorkingInfo", "workInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneDriverWorkInfo;", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DriverOrders implements MobileController {
    private final Activity context;
    private final ConstraintLayout driverOrders;
    private final MobilePhoneDriverOrdersAdapter driverOrdersAdapter;
    private final MobilePhoneDriverOrdersPageBinding driverOrdersBinding;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public DriverOrders() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_driver_orders_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.driverOrders = constraintLayout;
        MobilePhoneDriverOrdersPageBinding bind = MobilePhoneDriverOrdersPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.driverOrdersBinding = bind;
        MobilePhoneDriverOrdersAdapter mobilePhoneDriverOrdersAdapter = new MobilePhoneDriverOrdersAdapter();
        this.driverOrdersAdapter = mobilePhoneDriverOrdersAdapter;
        HistoryManager.Companion.push(MobilePhonePage.DRIVER_ORDERS.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mobile_driver_orders_bg));
        binding.phoneCaseContainer.addView(bind.mpDriverOrdersPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpDriverOrdersPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4, 8);
        constraintSet.connect(bind.mpDriverOrdersPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpDriverOrdersPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.driverOrders.setAdapter(mobilePhoneDriverOrdersAdapter);
        bind.driverOrders.setLayoutManager(new GridLayoutManager((Context) context, 1, 1, false));
        mobilePhoneDriverOrdersAdapter.setOnChoseOrderClickListener(new MobilePhoneDriverOrdersAdapter.OnChoseOrderClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders.1
            @Override // ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneDriverOrdersAdapter.OnChoseOrderClickListener
            public void callback(int i) {
                DriverOrders.this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 16);
            }
        });
        bind.driverActionContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverOrders._init_$lambda$0(DriverOrders.this, view);
            }
        });
        bind.mpDriverHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverOrders._init_$lambda$1(DriverOrders.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(DriverOrders driverOrders, View view) {
        driverOrders.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(DriverOrders driverOrders, View view) {
        HistoryManager.Companion.clearAllHistory();
        HistoryManager.Companion.clearThisPage(MobilePhonePage.DRIVER_ORDER.getId());
        HistoryManager.Companion.clearThisPage(MobilePhonePage.DRIVER_ORDERS.getId());
        driverOrders.driverOrders.removeAllViews();
        HistoryManager.Companion.getOrCreatePage(0);
    }

    public final void addOrders(List<MobilePhoneDriverOrder> orders) {
        Intrinsics.checkNotNullParameter(orders, "orders");
        this.driverOrdersAdapter.addOrders(orders);
    }

    public final void clearOrders() {
        this.driverOrdersAdapter.clearOrders();
    }

    public final void setWorkingButton(String workingButton) {
        Intrinsics.checkNotNullParameter(workingButton, "workingButton");
        TextView textView = this.driverOrdersBinding.driverJobButton;
        String str = workingButton;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        textView.setText(sb.toString());
    }

    public final void setWorkingInfo(MobilePhoneDriverWorkInfo workInfo) {
        Intrinsics.checkNotNullParameter(workInfo, "workInfo");
        this.driverOrdersBinding.driverName.setText(workInfo.getName());
        this.driverOrdersBinding.driverRate.setText(String.valueOf(workInfo.getRating()));
        this.driverOrdersBinding.driverOrderCount.setText(String.valueOf(workInfo.getOrdersCount()));
        this.driverOrdersBinding.driverPriorityName.setText(workInfo.getTariff());
        this.driverOrdersBinding.driverCarName.setText(workInfo.getCar());
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.DRIVER_ORDERS.getId());
        this.driverOrders.removeAllViews();
    }
}
