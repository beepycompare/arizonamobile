package ru.mrlargha.arizonaui.mobile.presentation.page.uber;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneUberChoseTaxiPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneUberAdapter;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: UberChoseTaxi.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/uber/UberChoseTaxi;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "priority", "", "uberChoseTaxi", "Landroidx/constraintlayout/widget/ConstraintLayout;", "uberChoseTaxiBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneUberChoseTaxiPageBinding;", "uberAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneUberAdapter;", "renderPage", "", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UberChoseTaxi implements MobileController {
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private int priority;
    private final IBackendNotifier sendFrontedMessage;
    private final MobilePhoneUberAdapter uberAdapter;
    private final ConstraintLayout uberChoseTaxi;
    private final MobilePhoneUberChoseTaxiPageBinding uberChoseTaxiBinding;

    public UberChoseTaxi() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_uber_chose_taxi_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.uberChoseTaxi = constraintLayout;
        MobilePhoneUberChoseTaxiPageBinding bind = MobilePhoneUberChoseTaxiPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.uberChoseTaxiBinding = bind;
        MobilePhoneUberAdapter mobilePhoneUberAdapter = new MobilePhoneUberAdapter(context);
        this.uberAdapter = mobilePhoneUberAdapter;
        HistoryManager.Companion.push(MobilePhonePage.UBER_CHOSE_TAXI.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mobile_phone_uber_order_bg));
        bind.mpUberChoseTaxiPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        Drawable mutate = bind.mpUberMyLocationContainer.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(Color.parseColor("#E8E8E8"));
        Drawable mutate2 = bind.mpUberFinalLocationContainer.getBackground().mutate();
        Intrinsics.checkNotNull(mutate2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate2).setColor(ViewCompat.MEASURED_STATE_MASK);
        Drawable mutate3 = bind.mpUberActionButton.getBackground().mutate();
        Intrinsics.checkNotNull(mutate3, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate3).setColor(ViewCompat.MEASURED_STATE_MASK);
        bind.mpUberChosePriorityList.setAdapter(mobilePhoneUberAdapter);
        bind.mpUberChosePriorityList.setLayoutManager(new GridLayoutManager((Context) context, 1, 0, false));
        binding.phoneCaseContainer.addView(bind.mpUberChoseTaxiPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpUberChoseTaxiPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpUberChoseTaxiPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpUberChoseTaxiPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        mobilePhoneUberAdapter.setOnChoseCarClickListener(new MobilePhoneUberAdapter.OnChosePriorityClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberChoseTaxi.1
            @Override // ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneUberAdapter.OnChosePriorityClickListener
            public void callback(int i) {
                UberChoseTaxi.this.priority = i;
            }
        });
        bind.mpUberFinalLocationContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberChoseTaxi$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UberChoseTaxi._init_$lambda$0(UberChoseTaxi.this, view);
            }
        });
        bind.mpUberActionButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberChoseTaxi$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UberChoseTaxi._init_$lambda$2(UberChoseTaxi.this, view);
            }
        });
        bind.mpUberHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberChoseTaxi$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UberChoseTaxi._init_$lambda$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(UberChoseTaxi uberChoseTaxi, View view) {
        uberChoseTaxi.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(UberChoseTaxi uberChoseTaxi, View view) {
        uberChoseTaxi.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), uberChoseTaxi.priority, 8);
        uberChoseTaxi.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(View view) {
        HistoryManager.Companion.previousPage();
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.UBER_CHOSE_TAXI.getId());
        this.uberChoseTaxi.removeAllViews();
    }
}
