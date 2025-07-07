package ru.mrlargha.arizonaui.container.presentation;

import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import androidx.recyclerview.widget.GridLayoutManager;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.container.domain.obj.Container;
import ru.mrlargha.arizonaui.container.domain.obj.ContainerRewards;
import ru.mrlargha.arizonaui.databinding.AuctionCurrentContainerBinding;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CurrentContainer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainer;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "activity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "currentContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "timer", "Landroid/os/CountDownTimer;", "auctionCurrentContainerBinding", "Lru/mrlargha/arizonaui/databinding/AuctionCurrentContainerBinding;", "currentContainerAdapter", "Lru/mrlargha/arizonaui/container/presentation/CurrentContainerAdapter;", "createCurrentContainerItems", "", "showSetBetMenu", "hiddenSetBetMenu", "addContainer", "message", "", "onBackendMessage", "data", "subId", "addRewards", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentContainer extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CurrentContainer";
    private final AuctionCurrentContainerBinding auctionCurrentContainerBinding;
    private final ConstraintLayout currentContainer;
    private final CurrentContainerAdapter currentContainerAdapter;
    private final IBackendNotifier sendServerEvent;
    private CountDownTimer timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentContainer(Activity activity, int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.sendServerEvent = (IBackendNotifier) activity;
        View inflate = activity.getLayoutInflater().inflate(R.layout.auction_current_container, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.currentContainer = constraintLayout;
        AuctionCurrentContainerBinding bind = AuctionCurrentContainerBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.auctionCurrentContainerBinding = bind;
        this.currentContainerAdapter = new CurrentContainerAdapter();
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(false);
        createCurrentContainerItems();
    }

    private final void createCurrentContainerItems() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.auctionCurrentContainerBinding.acGeneralExit.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.createCurrentContainerItems$lambda$0(CurrentContainer.this, view);
            }
        });
        this.auctionCurrentContainerBinding.ccItemImage.startAnimation(alphaAnimation);
        this.auctionCurrentContainerBinding.acRun.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.createCurrentContainerItems$lambda$1(CurrentContainer.this, view);
            }
        });
        this.auctionCurrentContainerBinding.acExitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.this.hiddenSetBetMenu();
            }
        });
        this.auctionCurrentContainerBinding.acSetBetButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainer$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.createCurrentContainerItems$lambda$5(CurrentContainer.this, view);
            }
        });
        this.auctionCurrentContainerBinding.ccRcView.setLayoutManager(new GridLayoutManager(this.currentContainer.getContext(), 6));
        this.auctionCurrentContainerBinding.ccRcView.setAdapter(this.currentContainerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCurrentContainerItems$lambda$0(CurrentContainer currentContainer, View view) {
        currentContainer.sendServerEvent.clickedWrapper(currentContainer.getBackendID(), 0, 1);
        CountDownTimer countDownTimer = currentContainer.timer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        currentContainer.currentContainerAdapter.clearItems();
        currentContainer.getNotifier().requestRemoveUIElement(currentContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCurrentContainerItems$lambda$1(CurrentContainer currentContainer, View view) {
        CharSequence text = currentContainer.auctionCurrentContainerBinding.ccItemTimeLeftTimer.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (StringsKt.startsWith$default(text, (CharSequence) "Начало", false, 2, (Object) null) || currentContainer.currentContainerAdapter.getItemCount() <= 0) {
            Toast.makeText(currentContainer.currentContainer.getContext(), "Сейчас нельзя делать ставки!", 0).show();
        } else {
            currentContainer.showSetBetMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|(1:8)(1:38)|(1:10)|11|12|(1:14)(1:35)|(7:18|(2:(1:21)|22)|23|24|(3:26|(1:28)|(1:30))|31|32)|34|24|(0)|31|32))|39|6|(0)(0)|(0)|11|12|(0)(0)|(7:18|(0)|23|24|(0)|31|32)|34|24|(0)|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0110, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0111, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c9 A[Catch: NumberFormatException -> 0x0110, TryCatch #0 {NumberFormatException -> 0x0110, blocks: (B:14:0x00b4, B:16:0x00c9, B:21:0x00d4, B:24:0x00ec, B:25:0x00f2, B:26:0x00f5, B:27:0x00fe), top: B:40:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void createCurrentContainerItems$lambda$5(CurrentContainer currentContainer, View view) {
        int parseInt;
        String str;
        int parseInt2;
        CountDownTimer countDownTimer;
        CharSequence text = currentContainer.auctionCurrentContainerBinding.ccItemLastBetPrice.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (StringsKt.endsWith$default(text, (CharSequence) "$", false, 2, (Object) null)) {
            CharSequence text2 = currentContainer.auctionCurrentContainerBinding.ccItemTimeLeftTimer.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            if (!StringsKt.isBlank(text2)) {
                CharSequence text3 = currentContainer.auctionCurrentContainerBinding.ccItemLastBetPrice.getText();
                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                parseInt = Integer.parseInt((String) StringsKt.split$default(text3, new String[]{" $"}, false, 0, 6, (Object) null).get(0));
                CharSequence text4 = currentContainer.auctionCurrentContainerBinding.ccItemTimeLeftTimer.getText();
                Intrinsics.checkNotNullExpressionValue(text4, "getText(...)");
                str = (String) StringsKt.split$default(text4, new String[]{StringUtils.PROCESS_POSTFIX_DELIMITER}, false, 0, 6, (Object) null).get(0);
                if ((StringsKt.isBlank(str) ? Integer.parseInt(str) : 0) <= 0) {
                    Toast.makeText(currentContainer.currentContainer.getContext(), "Аукцион окончен, сделать ставку нельзя!", 0).show();
                }
                String obj = currentContainer.auctionCurrentContainerBinding.ccInputForm.getText().toString();
                parseInt2 = StringsKt.isBlank(obj) ? Integer.parseInt(obj) : 0;
                if (parseInt2 > 0 && parseInt2 >= parseInt) {
                    currentContainer.sendServerEvent.clickedWrapper(currentContainer.getBackendID(), parseInt2, 0);
                    currentContainer.sendServerEvent.clickedWrapper(currentContainer.getBackendID(), 0, 1);
                    countDownTimer = currentContainer.timer;
                    if (countDownTimer != null) {
                        if (countDownTimer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                            countDownTimer = null;
                        }
                        countDownTimer.cancel();
                    }
                    currentContainer.setVisibility(false);
                    currentContainer.currentContainerAdapter.clearItems();
                    if (currentContainer.getTargetActivity().getCurrentFocus() != null) {
                        Object systemService = currentContainer.getTargetActivity().getSystemService("input_method");
                        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(currentContainer.currentContainer.getWindowToken(), 0);
                        }
                    }
                    currentContainer.hiddenSetBetMenu();
                }
                Toast.makeText(currentContainer.currentContainer.getContext(), "Новая ставка должна быть выше текущей!", 0).show();
                if (currentContainer.getTargetActivity().getCurrentFocus() != null) {
                }
                currentContainer.hiddenSetBetMenu();
            }
        }
        CharSequence text5 = currentContainer.auctionCurrentContainerBinding.ccItemLastBetPrice.getText();
        Intrinsics.checkNotNullExpressionValue(text5, "getText(...)");
        parseInt = Integer.parseInt((String) StringsKt.split$default(text5, new String[]{" AZ"}, false, 0, 6, (Object) null).get(0));
        CharSequence text42 = currentContainer.auctionCurrentContainerBinding.ccItemTimeLeftTimer.getText();
        Intrinsics.checkNotNullExpressionValue(text42, "getText(...)");
        str = (String) StringsKt.split$default(text42, new String[]{StringUtils.PROCESS_POSTFIX_DELIMITER}, false, 0, 6, (Object) null).get(0);
        if ((StringsKt.isBlank(str) ? Integer.parseInt(str) : 0) <= 0) {
        }
        String obj2 = currentContainer.auctionCurrentContainerBinding.ccInputForm.getText().toString();
        if (StringsKt.isBlank(obj2)) {
        }
        if (parseInt2 > 0) {
            currentContainer.sendServerEvent.clickedWrapper(currentContainer.getBackendID(), parseInt2, 0);
            currentContainer.sendServerEvent.clickedWrapper(currentContainer.getBackendID(), 0, 1);
            countDownTimer = currentContainer.timer;
            if (countDownTimer != null) {
            }
            currentContainer.setVisibility(false);
            currentContainer.currentContainerAdapter.clearItems();
            if (currentContainer.getTargetActivity().getCurrentFocus() != null) {
            }
            currentContainer.hiddenSetBetMenu();
        }
        Toast.makeText(currentContainer.currentContainer.getContext(), "Новая ставка должна быть выше текущей!", 0).show();
        if (currentContainer.getTargetActivity().getCurrentFocus() != null) {
        }
        currentContainer.hiddenSetBetMenu();
    }

    private final void showSetBetMenu() {
        this.auctionCurrentContainerBinding.acBetBg.setVisibility(0);
        this.auctionCurrentContainerBinding.acSetBetButton.setVisibility(0);
        this.auctionCurrentContainerBinding.ccInputBetPrice.setVisibility(0);
        this.auctionCurrentContainerBinding.ccInputBetName.setVisibility(0);
        this.auctionCurrentContainerBinding.ccInputBetTittle.setVisibility(0);
        this.auctionCurrentContainerBinding.ccInputBetBg.setVisibility(0);
        this.auctionCurrentContainerBinding.ccInputBetTittle.setVisibility(0);
        this.auctionCurrentContainerBinding.ccInputForm.setVisibility(0);
        this.auctionCurrentContainerBinding.acExitButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hiddenSetBetMenu() {
        this.auctionCurrentContainerBinding.acBetBg.setVisibility(4);
        this.auctionCurrentContainerBinding.acSetBetButton.setVisibility(4);
        this.auctionCurrentContainerBinding.ccInputBetPrice.setVisibility(4);
        this.auctionCurrentContainerBinding.ccInputBetName.setVisibility(4);
        this.auctionCurrentContainerBinding.ccInputBetTittle.setVisibility(4);
        this.auctionCurrentContainerBinding.ccInputBetBg.setVisibility(4);
        this.auctionCurrentContainerBinding.ccInputBetTittle.setVisibility(4);
        this.auctionCurrentContainerBinding.ccInputForm.setVisibility(4);
        this.auctionCurrentContainerBinding.acExitButton.setVisibility(4);
    }

    public final void addContainer(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Container container = (Container) MapperKt.toModel(message, Container.class);
        if (container.getTypePrice() == 0) {
            this.auctionCurrentContainerBinding.ccItemPriceIcone.setText("$");
            this.auctionCurrentContainerBinding.ccItemLastBetPrice.setText(container.getCurrentBet() + " $");
            this.auctionCurrentContainerBinding.ccInputBetPrice.setText(container.getCurrentBet() + " $");
            this.auctionCurrentContainerBinding.ccInputForm.setHint("10 000 $");
        } else {
            this.auctionCurrentContainerBinding.ccItemLastBetPrice.setText(container.getCurrentBet() + " AZ");
            this.auctionCurrentContainerBinding.ccInputBetPrice.setText(container.getCurrentBet() + " AZ");
            this.auctionCurrentContainerBinding.ccItemPriceIcone.setText("AZ");
            this.auctionCurrentContainerBinding.ccInputForm.setHint("2 000 AZ");
        }
        this.auctionCurrentContainerBinding.ccItemDescription.setText(container.getTitle());
        this.auctionCurrentContainerBinding.ccItemPrice.setText(String.valueOf(container.getStartPrice()));
        this.auctionCurrentContainerBinding.ccItemLastBetName.setText(container.getCurrentBetUser());
        this.auctionCurrentContainerBinding.ccInputBetName.setText(container.getCurrentBetUser());
        if (container.getTime() > 0) {
            this.auctionCurrentContainerBinding.ccItemTimeLeftTittle.setText("Времени осталось");
            final long time = container.getTime() * 1000;
            getTargetActivity().runOnUiThread(new Runnable() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainer$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CurrentContainer.addContainer$lambda$6(CurrentContainer.this, time);
                }
            });
            return;
        }
        this.auctionCurrentContainerBinding.ccItemTimeLeftTittle.setText("Аукцион не проводится");
        this.auctionCurrentContainerBinding.ccItemTimeLeftTimer.setText("Начало: " + container.getHourStartTime() + ":00");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addContainer$lambda$6(final CurrentContainer currentContainer, final long j) {
        CountDownTimer countDownTimer = new CountDownTimer(j) { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainer$addContainer$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                long j3;
                long j4;
                AuctionCurrentContainerBinding auctionCurrentContainerBinding;
                auctionCurrentContainerBinding = currentContainer.auctionCurrentContainerBinding;
                auctionCurrentContainerBinding.ccItemTimeLeftTimer.setText(((j2 / 1000) / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + (j3 % j4));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                AuctionCurrentContainerBinding auctionCurrentContainerBinding;
                auctionCurrentContainerBinding = currentContainer.auctionCurrentContainerBinding;
                auctionCurrentContainerBinding.ccItemTimeLeftTimer.setText("00:00");
                cancel();
            }
        };
        currentContainer.timer = countDownTimer;
        countDownTimer.start();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addContainer(data);
        } else if (i == 1) {
            addRewards(data);
        } else {
            Log.w(TAG, "Incorrect SUB_ID=" + i + ", msg=" + data);
        }
    }

    /* compiled from: CurrentContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainer$Companion;", "", "<init>", "()V", "TAG", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final synchronized void addRewards(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.currentContainerAdapter.addItems(MapperKt.toListModel(message, ContainerRewards.class));
        this.auctionCurrentContainerBinding.ccRcView.smoothScrollToPosition(0);
    }

    /* compiled from: CurrentContainer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainer$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CurrentContainer(targetActivity, i);
        }
    }
}
