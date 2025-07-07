package ru.mrlargha.arizonaui.mobile.presentation.page.carsharing;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneArizonamobilMainPageBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: CarSharingMain.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/carsharing/CarSharingMain;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "arizonaMobilMain", "Landroidx/constraintlayout/widget/ConstraintLayout;", "arizonaMobilBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneArizonamobilMainPageBinding;", "addBalance", "", "balance", "", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarSharingMain implements MobileController {
    private final MobilePhoneArizonamobilMainPageBinding arizonaMobilBinding;
    private final ConstraintLayout arizonaMobilMain;
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public CarSharingMain() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_arizonamobil_main_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.arizonaMobilMain = constraintLayout;
        MobilePhoneArizonamobilMainPageBinding bind = MobilePhoneArizonamobilMainPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.arizonaMobilBinding = bind;
        HistoryManager.Companion.push(MobilePhonePage.ARIZONAMOBIL_MAIN.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mp_arizonamobil_bg));
        bind.mpArizonamobilMainPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        Drawable mutate = bind.mpArizonamobilAddBalance.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(Color.parseColor("#FF2323"));
        binding.phoneCaseContainer.addView(bind.mpArizonamobilMainPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpArizonamobilMainPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpArizonamobilMainPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpArizonamobilMainPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.mpArizonamobileBalanceCount.setText(mobilePhone.getArizonaMobilBalance() + " $");
        bind.mpArizonamobilAddBalance.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingMain$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingMain._init_$lambda$0(CarSharingMain.this, view);
            }
        });
        bind.mpArizonaMobileMyRent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingMain$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingMain._init_$lambda$2(CarSharingMain.this, view);
            }
        });
        bind.mpArizonamobileHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingMain$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarSharingMain._init_$lambda$3(view);
            }
        });
    }

    public final void addBalance(int i) {
        this.arizonaMobilBinding.mpArizonamobileBalanceCount.setText(i + "$");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CarSharingMain carSharingMain, View view) {
        carSharingMain.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(CarSharingMain carSharingMain, View view) {
        CharSequence text = carSharingMain.arizonaMobilBinding.mpArizonamobileBalanceCount.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            if (charAt != '$') {
                sb.append(charAt);
            }
        }
        try {
            if (Integer.parseInt(new Regex("[^0-9]").replace(sb.toString(), "")) <= 0) {
                Toast.makeText(carSharingMain.context, "Пополните баланс!", 0).show();
                return;
            }
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.ARIZONAMOBIL_CARS.getId());
            carSharingMain.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 5);
            carSharingMain.removePage();
        } catch (NumberFormatException unused) {
            System.out.println((Object) "Не удалось распарсить баланс");
        }
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
        HistoryManager.Companion.clearThisPage(MobilePhonePage.ARIZONAMOBIL_MAIN.getId());
        this.arizonaMobilMain.removeAllViews();
    }
}
