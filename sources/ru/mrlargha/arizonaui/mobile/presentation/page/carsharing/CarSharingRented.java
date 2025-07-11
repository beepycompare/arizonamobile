package ru.mrlargha.arizonaui.mobile.presentation.page.carsharing;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneArizonamobilCarRentedPageBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneRentInfo;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
/* compiled from: CarSharingRented.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/carsharing/CarSharingRented;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "carRented", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCarRented", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "carRentedBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneArizonamobilCarRentedPageBinding;", "setRentInfo", "", "rentInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneRentInfo;", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarSharingRented implements MobileController {
    private final ConstraintLayout carRented;
    private final MobilePhoneArizonamobilCarRentedPageBinding carRentedBinding;
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public CarSharingRented() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_arizonamobil_car_rented_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.carRented = constraintLayout;
        MobilePhoneArizonamobilCarRentedPageBinding bind = MobilePhoneArizonamobilCarRentedPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.carRentedBinding = bind;
        HistoryManager.Companion.push(MobilePhonePage.ARIZONAMOBIL_RENTED.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mp_arizonamobil_bg));
        bind.mpArizonamobilCarRentedPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        Drawable mutate = bind.mpArizonamobilCarInfo.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(Color.parseColor("#343434"));
        Drawable mutate2 = bind.mpArizonamobilHeaderId.getBackground().mutate();
        Intrinsics.checkNotNull(mutate2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate2).setColor(Color.parseColor("#FF2323"));
        binding.phoneCaseContainer.addView(bind.mpArizonamobilCarRentedPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpArizonamobilCarRentedPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpArizonamobilCarRentedPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpArizonamobilCarRentedPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.mpArizonamobileHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingRented$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingRented._init_$lambda$0(view);
            }
        });
    }

    public final ConstraintLayout getCarRented() {
        return this.carRented;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View view) {
        HistoryManager.Companion.previousPage();
    }

    public final void setRentInfo(MobilePhoneRentInfo rentInfo) {
        Intrinsics.checkNotNullParameter(rentInfo, "rentInfo");
        this.carRentedBinding.mpArizonamobilHeaderTitle.setText(StringsKt.substringBefore$default(rentInfo.getName(), " - arizonamobil", (String) null, 2, (Object) null));
        this.carRentedBinding.mpArizonamobileHeaderIdText.setText("ID: " + rentInfo.getId());
        this.carRentedBinding.mpArizonamobileDateTill.setText(rentInfo.getUnixTime());
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.ARIZONAMOBIL_RENTED.getId());
        this.carRented.removeAllViews();
    }
}
