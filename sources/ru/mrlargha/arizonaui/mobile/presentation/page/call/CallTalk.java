package ru.mrlargha.arizonaui.mobile.presentation.page.call;

import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneReceiveCallPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: CallTalk.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/call/CallTalk;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "mpCall", "Landroidx/constraintlayout/widget/ConstraintLayout;", "countDownTimer", "Landroid/os/CountDownTimer;", "mpCallBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneReceiveCallPageBinding;", "countDown", "", "setCompanionName", "name", "", "setCompanionNumber", "number", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallTalk implements MobileController {
    private final Activity context;
    private CountDownTimer countDownTimer;
    private final MobilePhone mobilePhone;
    private final ConstraintLayout mpCall;
    private final MobilePhoneReceiveCallPageBinding mpCallBinding;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;

    public CallTalk() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_receive_call_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.mpCall = constraintLayout;
        MobilePhoneReceiveCallPageBinding bind = MobilePhoneReceiveCallPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.mpCallBinding = bind;
        HistoryManager.Companion.push(MobilePhonePage.CALL_TALK_PAGE.getId());
        binding.phoneBackground.setBackgroundColor(Color.parseColor("#2C2C2C"));
        bind.mpReceiveCallTitle.setText("Вы звоните");
        bind.mpReceiveCallActionAccept.removeAllViews();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(bind.mpReceiveCallActionButtons);
        constraintSet.connect(bind.mpReceiveCallActionDecline.getId(), 1, 0, 1);
        constraintSet.connect(bind.mpReceiveCallActionDecline.getId(), 2, 0, 2);
        constraintSet.applyTo(bind.mpReceiveCallActionButtons);
        binding.phoneCaseContainer.addView(bind.mpReceiveCallPage);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(binding.phoneCaseContainer);
        constraintSet2.connect(bind.mpReceiveCallPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet2.connect(bind.mpReceiveCallPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet2.connect(bind.mpReceiveCallPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet2.applyTo(binding.phoneCaseContainer);
        bind.mpReceiveCallUser.setText(mobilePhone.getCompanionName());
        bind.mpReceiveCallTelephone.setText(mobilePhone.getCompanionNumber());
        bind.mpReceiveCallTime.setVisibility(0);
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(bind.mpReceiveCallInfo);
        constraintSet3.connect(bind.mpReceiveCallTitle.getId(), 1, 0, 1);
        constraintSet3.connect(bind.mpReceiveCallTitle.getId(), 2, bind.mpReceiveCallTime.getId(), 1);
        constraintSet3.connect(bind.mpReceiveCallTime.getId(), 1, bind.mpReceiveCallTitle.getId(), 2);
        constraintSet3.connect(bind.mpReceiveCallTime.getId(), 2, 0, 2);
        constraintSet3.applyTo(bind.mpReceiveCallInfo);
        countDown();
        bind.mpReceiveCallActionDecline.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallTalk._init_$lambda$0(CallTalk.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CallTalk callTalk, View view) {
        callTalk.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 3);
    }

    private final void countDown() {
        CountDownTimer countDownTimer = new CountDownTimer(CalendarModelKt.MillisecondsIn24Hours, this) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk$countDown$1
            final /* synthetic */ long $day;
            final /* synthetic */ CallTalk this$0;

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r3, 1000L);
                this.$day = r3;
                this.this$0 = this;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                MobilePhoneReceiveCallPageBinding mobilePhoneReceiveCallPageBinding;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                long j2 = 60;
                String format = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(this.$day - j) % j2), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.$day - j) % j2)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                System.out.println("Time : " + format);
                mobilePhoneReceiveCallPageBinding = this.this$0.mpCallBinding;
                mobilePhoneReceiveCallPageBinding.mpReceiveCallTime.setText(format);
            }
        };
        this.countDownTimer = countDownTimer;
        countDownTimer.start();
    }

    public final void setCompanionName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TextView textView = this.mpCallBinding.mpReceiveCallUser;
        String str = name;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                sb.append(charAt);
            }
        }
        textView.setText(sb.toString());
    }

    public final void setCompanionNumber(String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.mpCallBinding.mpReceiveCallTelephone.setText(number);
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countDownTimer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        HistoryManager.Companion.clearThisPage(MobilePhonePage.CALL_TALK_PAGE.getId());
        HistoryManager.Companion.clearHistoryByKey(MobilePhonePage.CALL_TALK_PAGE.getId());
        this.mpCall.removeAllViews();
    }
}
