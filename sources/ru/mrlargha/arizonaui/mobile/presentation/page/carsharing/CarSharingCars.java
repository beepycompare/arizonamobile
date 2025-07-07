package ru.mrlargha.arizonaui.mobile.presentation.page.carsharing;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneArizonamobilCarsPageBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneAvailableCar;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneCarsAdapter;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: CarSharingCars.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/carsharing/CarSharingCars;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "cars", "Landroidx/constraintlayout/widget/ConstraintLayout;", "carsBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneArizonamobilCarsPageBinding;", "carsAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCarsAdapter;", "addCars", "", "", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneAvailableCar;", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarSharingCars implements MobileController {
    private final ConstraintLayout cars;
    private final MobilePhoneCarsAdapter carsAdapter;
    private final MobilePhoneArizonamobilCarsPageBinding carsBinding;
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public CarSharingCars() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_arizonamobil_cars_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.cars = constraintLayout;
        MobilePhoneArizonamobilCarsPageBinding bind = MobilePhoneArizonamobilCarsPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.carsBinding = bind;
        MobilePhoneCarsAdapter mobilePhoneCarsAdapter = new MobilePhoneCarsAdapter();
        this.carsAdapter = mobilePhoneCarsAdapter;
        HistoryManager.Companion.push(MobilePhonePage.ARIZONAMOBIL_CARS.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mp_arizonamobil_bg));
        bind.mpArizonamobilCarsPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        bind.mpArizonamobileCars.setAdapter(mobilePhoneCarsAdapter);
        bind.mpArizonamobileCars.setLayoutManager(new GridLayoutManager(context, 1));
        binding.phoneCaseContainer.addView(bind.mpArizonamobilCarsPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpArizonamobilCarsPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpArizonamobilCarsPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpArizonamobilCarsPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        addCars(mobilePhone.getAvailableCars());
        mobilePhoneCarsAdapter.setOnChoseCarClickListener(new MobilePhoneCarsAdapter.OnChoseCarClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingCars.1
            @Override // ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneCarsAdapter.OnChoseCarClickListener
            public void callback(int i) {
                MobileController orCreatePage2 = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.ARIZONAMOBIL_CAR_INFO.getId());
                Intrinsics.checkNotNull(orCreatePage2, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingInfo");
                CarSharingCars.this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 6);
                MobilePhoneAvailableCar mobilePhoneAvailableCar = CarSharingCars.this.mobilePhone.getAvailableCars().get(i);
                Intrinsics.checkNotNullExpressionValue(mobilePhoneAvailableCar, "get(...)");
                ((CarSharingInfo) orCreatePage2).setCarInfo(mobilePhoneAvailableCar);
                MobilePhone mobilePhone2 = CarSharingCars.this.mobilePhone;
                MobilePhoneAvailableCar mobilePhoneAvailableCar2 = CarSharingCars.this.mobilePhone.getAvailableCars().get(i);
                Intrinsics.checkNotNullExpressionValue(mobilePhoneAvailableCar2, "get(...)");
                mobilePhone2.setAvailableCar(mobilePhoneAvailableCar2);
                CarSharingCars.this.removePage();
            }
        });
        bind.mpArizonamobileHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingCars$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingCars._init_$lambda$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View view) {
        HistoryManager.Companion.previousPage();
    }

    public final void addCars(List<MobilePhoneAvailableCar> cars) {
        Intrinsics.checkNotNullParameter(cars, "cars");
        this.carsAdapter.addAdapterCars(cars);
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.ARIZONAMOBIL_CARS.getId());
        this.cars.removeAllViews();
    }
}
