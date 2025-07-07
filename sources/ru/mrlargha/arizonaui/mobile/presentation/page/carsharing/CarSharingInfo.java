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
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneArizonamobilCarInfoPageBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneAvailableCar;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: CarSharingInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/carsharing/CarSharingInfo;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "carInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneAvailableCar;", "mpCarSharingInfo", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mpCarSharingInfoBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneArizonamobilCarInfoPageBinding;", "setCarInfo", "", "updateCarInfo", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarSharingInfo implements MobileController {
    private MobilePhoneAvailableCar carInfo;
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final ConstraintLayout mpCarSharingInfo;
    private final MobilePhoneArizonamobilCarInfoPageBinding mpCarSharingInfoBinding;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public CarSharingInfo() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_arizonamobil_car_info_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.mpCarSharingInfo = constraintLayout;
        MobilePhoneArizonamobilCarInfoPageBinding bind = MobilePhoneArizonamobilCarInfoPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.mpCarSharingInfoBinding = bind;
        HistoryManager.Companion.push(MobilePhonePage.ARIZONAMOBIL_CAR_INFO.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mp_arizonamobil_bg));
        bind.mpArizonamobilCarInfoPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        Drawable mutate = bind.mpArizonamobilCarInfo.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(Color.parseColor("#343434"));
        Drawable mutate2 = bind.mpArizonamobilHeaderId.getBackground().mutate();
        Intrinsics.checkNotNull(mutate2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate2).setColor(Color.parseColor("#FF2323"));
        Drawable mutate3 = bind.mpArizonamobilePrice.getBackground().mutate();
        Intrinsics.checkNotNull(mutate3, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate3).setColor(Color.parseColor("#FFFFFF"));
        Drawable mutate4 = bind.mpArizonamobilePriceBurger.getBackground().mutate();
        Intrinsics.checkNotNull(mutate4, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate4).setColor(Color.parseColor("#FF2323"));
        binding.phoneCaseContainer.addView(bind.mpArizonamobilCarInfoPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpArizonamobilCarInfoPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpArizonamobilCarInfoPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpArizonamobilCarInfoPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        MobilePhoneAvailableCar mobilePhoneAvailableCar = this.carInfo;
        if (mobilePhoneAvailableCar != null) {
            bind.mpArizonamobilHeaderTitle.setText(StringsKt.substringBefore$default(mobilePhoneAvailableCar.getName(), " - arizonamobil", (String) null, 2, (Object) null));
            bind.mpArizonamobileHeaderIdText.setText("ID: " + mobilePhoneAvailableCar.getId());
            bind.mpArizonamobileFuelPercent.setText(String.valueOf(mobilePhoneAvailableCar.getFuelValue()));
            bind.mpArizonamobileFuelText.setText(Intrinsics.areEqual(mobilePhoneAvailableCar.getFuelType(), "petrol") ? "ТОПЛИВО" : "ЗАРЯД");
            bind.mpArizonamobilePriceDescription.setText(mobilePhoneAvailableCar.getPrice() + " $ на всю аренду");
            bind.mpFuelIndicator.setLayoutParams(new ConstraintLayout.LayoutParams(ConverterKt.dpToPx(mobilePhoneAvailableCar.getFuelValue(), context), ConverterKt.dpToPx(110, context)));
        }
        bind.mpArizonamobilePayRent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingInfo$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingInfo._init_$lambda$1(CarSharingInfo.this, view);
            }
        });
        bind.mpArizonamobileHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingInfo$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingInfo._init_$lambda$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(CarSharingInfo carSharingInfo, View view) {
        carSharingInfo.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), CollectionsKt.indexOf((List<? extends MobilePhoneAvailableCar>) carSharingInfo.mobilePhone.getAvailableCars(), carSharingInfo.carInfo), 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(View view) {
        HistoryManager.Companion.previousPage();
    }

    public final void setCarInfo(MobilePhoneAvailableCar carInfo) {
        Intrinsics.checkNotNullParameter(carInfo, "carInfo");
        this.carInfo = carInfo;
        updateCarInfo(carInfo);
    }

    public final void updateCarInfo(MobilePhoneAvailableCar carInfo) {
        Intrinsics.checkNotNullParameter(carInfo, "carInfo");
        this.mpCarSharingInfoBinding.mpArizonamobilHeaderTitle.setText(StringsKt.substringBefore$default(carInfo.getName(), " - arizonamobil", (String) null, 2, (Object) null));
        this.mpCarSharingInfoBinding.mpArizonamobileHeaderIdText.setText("ID: " + carInfo.getId());
        this.mpCarSharingInfoBinding.mpArizonamobileFuelPercent.setText(String.valueOf(carInfo.getFuelValue()));
        this.mpCarSharingInfoBinding.mpArizonamobileFuelText.setText(Intrinsics.areEqual(carInfo.getFuelType(), "petrol") ? "ТОПЛИВО" : "ЗАРЯД");
        this.mpCarSharingInfoBinding.mpArizonamobilePriceDescription.setText(carInfo.getPrice() + " $ на всю аренду");
        this.mpCarSharingInfoBinding.mpFuelIndicator.setLayoutParams(new ConstraintLayout.LayoutParams(ConverterKt.dpToPx((ConverterKt.dpToPx(132, this.context) / 100) * carInfo.getFuelValue(), this.context), ConverterKt.dpToPx(110, this.context)));
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.ARIZONAMOBIL_CAR_INFO.getId());
        this.mpCarSharingInfo.removeAllViews();
    }
}
