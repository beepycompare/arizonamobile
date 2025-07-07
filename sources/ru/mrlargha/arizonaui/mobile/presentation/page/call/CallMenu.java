package ru.mrlargha.arizonaui.mobile.presentation.page.call;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneCallPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.GridSpacingItemDecoration;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneCallAdapter;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: CallMenu.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/call/CallMenu;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "callPage", "Landroidx/constraintlayout/widget/ConstraintLayout;", "callPageBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneCallPageBinding;", "mobilePhoneCallAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCallAdapter;", "renderPage", "", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallMenu implements MobileController {
    private final ConstraintLayout callPage;
    private final MobilePhoneCallPageBinding callPageBinding;
    private final Activity context;
    private final MobilePhone mobilePhone;
    private final MobilePhoneCallAdapter mobilePhoneCallAdapter;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public CallMenu() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_call_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.callPage = constraintLayout;
        MobilePhoneCallPageBinding bind = MobilePhoneCallPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.callPageBinding = bind;
        MobilePhoneCallAdapter mobilePhoneCallAdapter = new MobilePhoneCallAdapter(context);
        this.mobilePhoneCallAdapter = mobilePhoneCallAdapter;
        HistoryManager.Companion.push(MobilePhonePage.CALL_TYPE_PAGE.getId());
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.color.white));
        bind.mpCallMenuRc.setAdapter(mobilePhoneCallAdapter);
        bind.mpCallMenuRc.setLayoutManager(new GridLayoutManager((Context) context, 3, 1, false));
        bind.mpCallMenuRc.addItemDecoration(new GridSpacingItemDecoration(3, 20, false));
        binding.phoneCaseContainer.addView(bind.mpCallPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpCallPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpCallPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpCallPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        mobilePhoneCallAdapter.setOnCallButtonClickListener(new MobilePhoneCallAdapter.OnCallButtonClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.call.CallMenu.1
            @Override // ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneCallAdapter.OnCallButtonClickListener
            public void callback(String number) {
                Intrinsics.checkNotNullParameter(number, "number");
                TextView mpTypePhoneTitle = CallMenu.this.callPageBinding.mpTypePhoneTitle;
                Intrinsics.checkNotNullExpressionValue(mpTypePhoneTitle, "mpTypePhoneTitle");
                if (Intrinsics.areEqual(number, NotificationCompat.CATEGORY_CALL)) {
                    if (Intrinsics.areEqual(mpTypePhoneTitle.getText(), "Введите номер") || mpTypePhoneTitle.length() < 1) {
                        Toast.makeText(CallMenu.this.context, "Введите номер", 0).show();
                        return;
                    }
                    CallMenu.this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), Integer.parseInt(mpTypePhoneTitle.getText().toString()), 1);
                } else if (Intrinsics.areEqual(number, "decline")) {
                    mpTypePhoneTitle.setText("Введите номер");
                } else if (Intrinsics.areEqual(mpTypePhoneTitle.getText(), "Введите номер")) {
                    mpTypePhoneTitle.setText(number);
                } else if (mpTypePhoneTitle.getText().length() <= 8) {
                    mpTypePhoneTitle.setText(((Object) mpTypePhoneTitle.getText()) + number);
                } else {
                    Toast.makeText(CallMenu.this.context, "Номер слишком длинный", 0).show();
                }
            }
        });
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.CALL_TYPE_PAGE.getId());
        this.callPage.removeAllViews();
    }
}
