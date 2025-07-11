package ru.mrlargha.arizonaui.mobile.presentation.page.uber;

import android.app.Activity;
import android.content.Context;
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
import ru.mrlargha.arizonaui.databinding.MobilePhoneUberCompletePageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneRateAdapter;
/* compiled from: UberComplete.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/uber/UberComplete;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "uberComplete", "Landroidx/constraintlayout/widget/ConstraintLayout;", "uberCompleteBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneUberCompletePageBinding;", "uberRateAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneRateAdapter;", "renderPage", "", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UberComplete implements MobileController {
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final ConstraintLayout uberComplete;
    private final MobilePhoneUberCompletePageBinding uberCompleteBinding;
    private final MobilePhoneRateAdapter uberRateAdapter;

    public UberComplete() {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobilePhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.context = context;
        MobilePhoneBinding binding = mobilePhone.getBinding();
        this.phoneBinding = binding;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_uber_complete_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.uberComplete = constraintLayout;
        MobilePhoneUberCompletePageBinding bind = MobilePhoneUberCompletePageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.uberCompleteBinding = bind;
        MobilePhoneRateAdapter mobilePhoneRateAdapter = new MobilePhoneRateAdapter(context);
        this.uberRateAdapter = mobilePhoneRateAdapter;
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.mobile_phone_uber_other_bg));
        bind.mpUberCompletePage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        Drawable mutate = bind.mpUberActionButton.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(ViewCompat.MEASURED_STATE_MASK);
        bind.mpUberRates.setAdapter(mobilePhoneRateAdapter);
        bind.mpUberRates.setLayoutManager(new GridLayoutManager((Context) context, 1, 0, false));
        binding.phoneCaseContainer.addView(bind.mpUberCompletePage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpUberCompletePage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpUberCompletePage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpUberCompletePage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        bind.mpUberHeaderBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberComplete$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UberComplete._init_$lambda$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View view) {
        HistoryManager.Companion.previousPage();
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        this.uberComplete.removeAllViews();
    }
}
