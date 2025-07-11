package ru.mrlargha.arizonaui.mobile.presentation.page.catch_app;

import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.datetime.internal.DateCalculationsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneCatchAppPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.CatchAppInfo;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: CatchApp.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/catch_app/CatchApp;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "timerr", "Landroid/os/CountDownTimer;", "binding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneCatchAppPageBinding;", "setCatchAppInfo", "", "info", "Lru/mrlargha/arizonaui/mobile/domain/obj/CatchAppInfo;", "setDefaultScreens", "setBattleArmsInfo", CommonUrlParts.MODEL, "startTimer", "timeLeft", "", "renderPage", "removePage", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CatchApp implements MobileController {
    private final MobilePhoneCatchAppPageBinding binding;
    private final Activity context;
    private final ConstraintLayout layout;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private final IBackendNotifier sendFrontedMessage;
    private CountDownTimer timerr;

    public CatchApp() {
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
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_catch_app_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        MobilePhoneCatchAppPageBinding bind = MobilePhoneCatchAppPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        HistoryManager.Companion.push(MobilePhonePage.CATCH_APP.getId());
        constraintLayout.setVisibility(8);
        bind.mpCatchAppPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        binding.phoneCaseContainer.addView(bind.mpCatchAppPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpCatchAppPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpCatchAppPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpCatchAppPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView backButton = bind.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        EasyAnimation.animateClick$default(easyAnimation, backButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CatchApp.lambda$4$lambda$0();
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView infoButton = bind.infoButton;
        Intrinsics.checkNotNullExpressionValue(infoButton, "infoButton");
        EasyAnimation.animateClick$default(easyAnimation2, infoButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CatchApp.lambda$4$lambda$1(CatchApp.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ConstraintLayout permissionButton = bind.permissionButton;
        Intrinsics.checkNotNullExpressionValue(permissionButton, "permissionButton");
        EasyAnimation.animateClick$default(easyAnimation3, permissionButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CatchApp.lambda$4$lambda$2(CatchApp.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation4 = EasyAnimation.INSTANCE;
        ConstraintLayout catchButton = bind.catchButton;
        Intrinsics.checkNotNullExpressionValue(catchButton, "catchButton");
        EasyAnimation.animateClick$default(easyAnimation4, catchButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CatchApp.lambda$4$lambda$3(CatchApp.this);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$4$lambda$0() {
        HistoryManager.Companion.previousPage();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$4$lambda$1(CatchApp catchApp) {
        catchApp.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 25);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$4$lambda$2(CatchApp catchApp) {
        catchApp.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 26);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$4$lambda$3(CatchApp catchApp) {
        catchApp.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 27);
        return Unit.INSTANCE;
    }

    public final void setCatchAppInfo(CatchAppInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        CountDownTimer countDownTimer = this.timerr;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timerr");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        MobilePhoneCatchAppPageBinding mobilePhoneCatchAppPageBinding = this.binding;
        setDefaultScreens();
        mobilePhoneCatchAppPageBinding.bizCount.setText(String.valueOf(info.getBusinessesCount()));
        mobilePhoneCatchAppPageBinding.homeCount.setText(String.valueOf(info.getHousesCount()));
        if (info.getStatusButtonPermission() != 0) {
            mobilePhoneCatchAppPageBinding.permissionButton.setVisibility(0);
        } else {
            mobilePhoneCatchAppPageBinding.permissionButton.setVisibility(8);
        }
        String type = info.getType();
        switch (type.hashCode()) {
            case -1375280731:
                if (type.equals("byInfo")) {
                    mobilePhoneCatchAppPageBinding.seasonName.setText("«ловля по инфе»");
                    mobilePhoneCatchAppPageBinding.seasonName.setTextColor(Color.parseColor("#A594FD"));
                    mobilePhoneCatchAppPageBinding.permissionButtonText.setTextColor(Color.parseColor("#A594FD"));
                    mobilePhoneCatchAppPageBinding.locationIc.setColorFilter(Color.parseColor("#A594FD"));
                    mobilePhoneCatchAppPageBinding.homeIc.setColorFilter(Color.parseColor("#A594FD"));
                    mobilePhoneCatchAppPageBinding.bizIc.setColorFilter(Color.parseColor("#A594FD"));
                    mobilePhoneCatchAppPageBinding.catchText.setTextColor(Color.parseColor("#FFFFFF"));
                    mobilePhoneCatchAppPageBinding.permissionButton.setBackgroundResource(R.drawable.catch_app_permission_button_second_type_bg);
                    mobilePhoneCatchAppPageBinding.catchButton.setBackgroundResource(R.drawable.catch_app_button_second_type_bg);
                    this.phoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.context, R.drawable.catch_app_second_bg));
                    break;
                }
                break;
            case -1048853201:
                if (type.equals("newWay")) {
                    mobilePhoneCatchAppPageBinding.seasonName.setText("«по новому»");
                    mobilePhoneCatchAppPageBinding.seasonName.setTextColor(Color.parseColor("#B7FFCF"));
                    mobilePhoneCatchAppPageBinding.permissionButtonText.setTextColor(Color.parseColor("#B7FFCF"));
                    mobilePhoneCatchAppPageBinding.locationIc.setColorFilter(Color.parseColor("#B7FFCF"));
                    mobilePhoneCatchAppPageBinding.homeIc.setColorFilter(Color.parseColor("#B7FFCF"));
                    mobilePhoneCatchAppPageBinding.bizIc.setColorFilter(Color.parseColor("#B7FFCF"));
                    mobilePhoneCatchAppPageBinding.catchText.setTextColor(Color.parseColor("#000000"));
                    mobilePhoneCatchAppPageBinding.permissionButton.setBackgroundResource(R.drawable.catch_app_permission_button_fourth_type_bg);
                    mobilePhoneCatchAppPageBinding.catchButton.setBackgroundResource(R.drawable.catch_app_button_fourth_type_bg);
                    this.phoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.context, R.drawable.catch_app_fourth_bg));
                    break;
                }
                break;
            case -938608818:
                if (type.equals("racing")) {
                    mobilePhoneCatchAppPageBinding.seasonName.setText("«автогонки»");
                    mobilePhoneCatchAppPageBinding.seasonName.setTextColor(Color.parseColor("#94E4FD"));
                    mobilePhoneCatchAppPageBinding.permissionButtonText.setTextColor(Color.parseColor("#94E4FD"));
                    mobilePhoneCatchAppPageBinding.locationIc.setColorFilter(Color.parseColor("#94E4FD"));
                    mobilePhoneCatchAppPageBinding.homeIc.setColorFilter(Color.parseColor("#94E4FD"));
                    mobilePhoneCatchAppPageBinding.bizIc.setColorFilter(Color.parseColor("#94E4FD"));
                    mobilePhoneCatchAppPageBinding.catchText.setTextColor(Color.parseColor("#000000"));
                    mobilePhoneCatchAppPageBinding.permissionButton.setBackgroundResource(R.drawable.catch_app_permission_button_third_type_bg);
                    mobilePhoneCatchAppPageBinding.catchButton.setBackgroundResource(R.drawable.catch_app_button_third_type_bg);
                    this.phoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.context, R.drawable.catch_app_third_bg));
                    break;
                }
                break;
            case 1079299410:
                if (type.equals("rapidFire")) {
                    mobilePhoneCatchAppPageBinding.seasonName.setText("«СКОРОСТРЕЛЫ»");
                    mobilePhoneCatchAppPageBinding.seasonName.setTextColor(Color.parseColor("#FFD66C"));
                    mobilePhoneCatchAppPageBinding.permissionButtonText.setTextColor(Color.parseColor("#FFD66C"));
                    mobilePhoneCatchAppPageBinding.locationIc.setColorFilter(Color.parseColor("#FFD66C"));
                    mobilePhoneCatchAppPageBinding.homeIc.setColorFilter(Color.parseColor("#FFD66C"));
                    mobilePhoneCatchAppPageBinding.bizIc.setColorFilter(Color.parseColor("#FFD66C"));
                    mobilePhoneCatchAppPageBinding.catchText.setTextColor(Color.parseColor("#000000"));
                    mobilePhoneCatchAppPageBinding.permissionButton.setBackgroundResource(R.drawable.catch_app_permission_button_first_type_bg);
                    mobilePhoneCatchAppPageBinding.catchButton.setBackgroundResource(R.drawable.catch_app_button_first_type_bg);
                    this.phoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.context, R.drawable.catch_app_first_bg));
                    break;
                }
                break;
            case 2053143151:
                if (type.equals("battleArms")) {
                    setBattleArmsInfo(info);
                    break;
                }
                break;
        }
        if (Intrinsics.areEqual(info.getType(), "battleArms")) {
            return;
        }
        startTimer(info.getTimeLeft());
    }

    private final void setDefaultScreens() {
        MobilePhoneCatchAppPageBinding mobilePhoneCatchAppPageBinding = this.binding;
        ConstraintLayout permissionButton = mobilePhoneCatchAppPageBinding.permissionButton;
        Intrinsics.checkNotNullExpressionValue(permissionButton, "permissionButton");
        permissionButton.setVisibility(0);
        mobilePhoneCatchAppPageBinding.seasonTitle.setText("СЕЗОН");
        mobilePhoneCatchAppPageBinding.statTitle.setText("за текущий сезон поймано:");
        mobilePhoneCatchAppPageBinding.catchText.setText("Ловить");
        mobilePhoneCatchAppPageBinding.endOfSeasonTitle.setText("до конца сезона");
        mobilePhoneCatchAppPageBinding.clockIc.setImageResource(R.drawable.catch_app_clock_ic);
        mobilePhoneCatchAppPageBinding.homeIc.setImageResource(R.drawable.catch_app_home_ic);
        mobilePhoneCatchAppPageBinding.bizIc.setImageResource(R.drawable.catch_app_biz_ic);
    }

    private final void setBattleArmsInfo(CatchAppInfo catchAppInfo) {
        MobilePhoneCatchAppPageBinding mobilePhoneCatchAppPageBinding = this.binding;
        mobilePhoneCatchAppPageBinding.seasonName.setText("«БИТВА ВООРУЖЕНИЙ»");
        this.phoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.context, R.drawable.mobile_catch_app_fivth_type_bg));
        mobilePhoneCatchAppPageBinding.seasonName.setTextColor(Color.parseColor("#FF7878"));
        mobilePhoneCatchAppPageBinding.permissionButtonText.setTextColor(Color.parseColor("#FF7878"));
        mobilePhoneCatchAppPageBinding.locationIc.setColorFilter(Color.parseColor("#FF7878"));
        mobilePhoneCatchAppPageBinding.homeIc.setColorFilter(Color.parseColor("#FFFFFF"));
        mobilePhoneCatchAppPageBinding.bizIc.setColorFilter(Color.parseColor("#FFFFFF"));
        mobilePhoneCatchAppPageBinding.catchText.setTextColor(Color.parseColor("#000000"));
        mobilePhoneCatchAppPageBinding.catchText.setText(catchAppInfo.getButtonText());
        mobilePhoneCatchAppPageBinding.catchButton.setBackgroundResource(R.drawable.mobile_catch_app_button_fiveth_type_bg);
        ConstraintLayout permissionButton = mobilePhoneCatchAppPageBinding.permissionButton;
        Intrinsics.checkNotNullExpressionValue(permissionButton, "permissionButton");
        permissionButton.setVisibility(8);
        mobilePhoneCatchAppPageBinding.seasonTitle.setText("МЕРОПРИЯТИЕ");
        mobilePhoneCatchAppPageBinding.statTitle.setText("прогресс за текущий день");
        mobilePhoneCatchAppPageBinding.homeIc.setImageResource(R.drawable.mobile_catch_app_cursor_ic);
        mobilePhoneCatchAppPageBinding.bizIc.setImageResource(R.drawable.mobile_catch_app_cup_ic);
        mobilePhoneCatchAppPageBinding.endOfSeasonTitle.setText("Участников");
        mobilePhoneCatchAppPageBinding.clockIc.setImageResource(R.drawable.mobile_catch_app_pepels_ic);
        mobilePhoneCatchAppPageBinding.leftTime.setText(String.valueOf(catchAppInfo.getTotalCount()));
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp$startTimer$1$1] */
    private final void startTimer(int i) {
        final MobilePhoneCatchAppPageBinding mobilePhoneCatchAppPageBinding = this.binding;
        final long j = i * 1000;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = (int) (j / 1000);
        CountDownTimer start = new CountDownTimer(j) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp$startTimer$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (intRef.element != 0) {
                    Ref.IntRef intRef2 = intRef;
                    intRef2.element -= 60;
                    mobilePhoneCatchAppPageBinding.leftTime.setText((intRef.element / 86400) + " д. " + ((intRef.element % 86400) / DateCalculationsKt.SECONDS_PER_HOUR) + " ч. " + ((intRef.element % DateCalculationsKt.SECONDS_PER_HOUR) / 60) + " м.");
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                mobilePhoneCatchAppPageBinding.leftTime.setText("0 д. 0 ч. 0 м.");
                cancel();
            }
        }.start();
        Intrinsics.checkNotNullExpressionValue(start, "start(...)");
        this.timerr = start;
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        this.layout.setVisibility(0);
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.CATCH_APP.getId());
        this.layout.removeAllViews();
    }
}
