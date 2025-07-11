package ru.mrlargha.arizonaui.mobile.presentation.page.uber;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneUberOrderPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.enums.UberPriority;
import ru.mrlargha.arizonaui.mobile.domain.obj.DriverInfo;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: UberOrder.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/uber/UberOrder;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "uberOrder", "Landroidx/constraintlayout/widget/ConstraintLayout;", "uberOrderBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneUberOrderPageBinding;", "sendDriverInfo", "", "driverInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/DriverInfo;", "updateStatus", NotificationCompat.CATEGORY_STATUS, "", "sendPriority", "priority", "Lru/mrlargha/arizonaui/mobile/domain/enums/UberPriority;", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UberOrder implements MobileController {
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;
    private final ConstraintLayout uberOrder;
    private final MobilePhoneUberOrderPageBinding uberOrderBinding;

    public UberOrder() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_uber_order_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.uberOrder = constraintLayout;
        MobilePhoneUberOrderPageBinding bind = MobilePhoneUberOrderPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.uberOrderBinding = bind;
        HistoryManager.Companion.push(MobilePhonePage.UBER_ORDER.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mobile_phone_uber_other_bg));
        bind.mpUberOrderPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        Drawable mutate = bind.mpUberActionButton.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(ViewCompat.MEASURED_STATE_MASK);
        binding.phoneCaseContainer.addView(bind.mpUberOrderPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpUberOrderPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpUberOrderPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpUberOrderPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.mpUberOrderTitle.setText("Поиск водителя");
        bind.mpUberDriverContainer.setVisibility(4);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(bind.mpUberOrderPage);
        constraintSet2.connect(bind.mpUberOrderTitle.getId(), 3, bind.mpUberHeader.getId(), 4);
        constraintSet2.connect(bind.mpUberOrderTitle.getId(), 4, bind.mpUberPriority.getId(), 3);
        constraintSet2.connect(bind.mpUberPriority.getId(), 3, bind.mpUberOrderTitle.getId(), 4);
        constraintSet2.connect(bind.mpUberOrderTitle.getId(), 4, bind.mpUberPriority.getId(), 3);
        constraintSet2.applyTo(bind.mpUberOrderPage);
        bind.mpUberActionButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UberOrder._init_$lambda$0(UberOrder.this, view);
            }
        });
        bind.mpUberHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UberOrder._init_$lambda$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(UberOrder uberOrder, View view) {
        uberOrder.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(View view) {
        HistoryManager.Companion.previousPage();
    }

    public final void sendDriverInfo(DriverInfo driverInfo) {
        Intrinsics.checkNotNullParameter(driverInfo, "driverInfo");
        this.uberOrderBinding.mpUberDriverContainer.setVisibility(0);
        this.uberOrderBinding.mpUberDriverName.setText(driverInfo.getName());
        this.uberOrderBinding.mpUberDriverReviewCount.setText(String.valueOf(driverInfo.getRating()));
        this.uberOrderBinding.mpUberPriorityDescription.setText("от " + driverInfo.getCount() + "$");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.uberOrderBinding.mpUberOrderPage);
        constraintSet.connect(this.uberOrderBinding.mpUberOrderTitle.getId(), 3, this.uberOrderBinding.mpUberHeader.getId(), 4);
        constraintSet.connect(this.uberOrderBinding.mpUberOrderTitle.getId(), 4, this.uberOrderBinding.mpUberPriority.getId(), -1);
        constraintSet.connect(this.uberOrderBinding.mpUberPriority.getId(), 3, this.uberOrderBinding.mpUberDriverContainer.getId(), 4);
        constraintSet.connect(this.uberOrderBinding.mpUberOrderTitle.getId(), 4, this.uberOrderBinding.mpUberPriority.getId(), -1);
        constraintSet.applyTo(this.uberOrderBinding.mpUberOrderPage);
    }

    public final void updateStatus(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        TextView textView = this.uberOrderBinding.mpUberOrderTitle;
        String str = status;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        textView.setText(sb.toString());
    }

    public final void sendPriority(UberPriority uberPriority) {
        String str;
        String name;
        if (uberPriority == null || (name = uberPriority.name()) == null) {
            str = null;
        } else {
            str = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -1911224770) {
                if (str.equals("economy")) {
                    this.uberOrderBinding.mpUberPriorityTitle.setText("Эконом");
                    this.uberOrderBinding.mpUberPriorityImage.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_uber_econom_car));
                    this.uberOrderBinding.mpUberPriorityDescription.setText("от 1000$");
                }
            } else if (hashCode == -1146830912) {
                if (str.equals("business")) {
                    this.uberOrderBinding.mpUberPriorityTitle.setText("Бизнес");
                    this.uberOrderBinding.mpUberPriorityImage.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_uber_business_car));
                    this.uberOrderBinding.mpUberPriorityDescription.setText("от 10000$");
                }
            } else if (hashCode == 950199756 && str.equals("comfort")) {
                this.uberOrderBinding.mpUberPriorityTitle.setText("Комфорт");
                this.uberOrderBinding.mpUberPriorityImage.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_uber_comfort_car));
                this.uberOrderBinding.mpUberPriorityDescription.setText("от 2000$");
            }
        }
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.UBER_ORDER.getId());
        this.uberOrder.removeAllViews();
    }
}
