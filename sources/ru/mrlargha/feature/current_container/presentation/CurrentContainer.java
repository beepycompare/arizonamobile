package ru.mrlargha.feature.current_container.presentation;

import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.current_container.R;
import ru.mrlargha.feature.current_container.databinding.AuctionCurrentContainerBinding;
import ru.mrlargha.feature.current_container.domain.obj.Container;
import ru.mrlargha.feature.current_container.domain.obj.ContainerRewards;
/* compiled from: CurrentContainer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/mrlargha/feature/current_container/presentation/CurrentContainer;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "activity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "currentContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "timer", "Landroid/os/CountDownTimer;", "binding", "Lru/mrlargha/feature/current_container/databinding/AuctionCurrentContainerBinding;", "currentContainerAdapter", "Lru/mrlargha/feature/current_container/presentation/CurrentContainerAdapter;", FirebaseAnalytics.Param.CURRENCY, "", "createCurrentContainerItems", "", "showSetBetMenu", "hiddenSetBetMenu", "addContainer", "message", "onBackendMessageHandled", "data", "subId", "addRewards", "Spawner", "Companion", "current-container"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CurrentContainer extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CurrentContainer";
    private final AuctionCurrentContainerBinding binding;
    private final String currency;
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
        this.binding = bind;
        this.currentContainerAdapter = new CurrentContainerAdapter();
        String str = UtilsKt.isArizonaType() ? "$" : "₽";
        this.currency = str;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(false);
        createCurrentContainerItems();
        bind.ccInputForm.setHint("10 000 " + str);
    }

    private final void createCurrentContainerItems() {
        int i = UtilsKt.isArizonaType() ? R.drawable.auction_button_exit : ru.mrlargha.commonui.R.drawable.rodina_cross;
        this.binding.acExitButton.setImageResource(i);
        this.binding.acGeneralExit.setImageResource(i);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.binding.acGeneralExit.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.createCurrentContainerItems$lambda$1(CurrentContainer.this, view);
            }
        });
        boolean isArizonaType = UtilsKt.isArizonaType();
        AuctionCurrentContainerBinding auctionCurrentContainerBinding = this.binding;
        if (isArizonaType) {
            auctionCurrentContainerBinding.ccItemImage.startAnimation(alphaAnimation);
        } else {
            AppCompatImageView appCompatImageView = auctionCurrentContainerBinding.ccItemImage;
            ViewGroup.LayoutParams layoutParams = this.binding.ccItemImage.getLayoutParams();
            layoutParams.width = MathKt.roundToInt(layoutParams.width / 1.8f);
            layoutParams.height = MathKt.roundToInt(layoutParams.height / 1.8f);
            appCompatImageView.setLayoutParams(layoutParams);
        }
        this.binding.acRun.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.createCurrentContainerItems$lambda$3(CurrentContainer.this, view);
            }
        });
        this.binding.acExitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.this.hiddenSetBetMenu();
            }
        });
        this.binding.acSetBetButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainer$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainer.createCurrentContainerItems$lambda$5(CurrentContainer.this, view);
            }
        });
        this.binding.ccRcView.setLayoutManager(new GridLayoutManager(this.currentContainer.getContext(), 6));
        this.binding.ccRcView.setAdapter(this.currentContainerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void createCurrentContainerItems$lambda$1(CurrentContainer currentContainer, View view) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void createCurrentContainerItems$lambda$3(CurrentContainer currentContainer, View view) {
        CharSequence text = currentContainer.binding.ccItemTimeLeftTimer.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        String string = currentContainer.currentContainer.getContext().getString(R.string.auction_start_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (StringsKt.startsWith$default(text, (CharSequence) string, false, 2, (Object) null) || currentContainer.currentContainerAdapter.getItemCount() <= 0) {
            Toast.makeText(currentContainer.currentContainer.getContext(), currentContainer.currentContainer.getContext().getString(R.string.auction_cannot_bid_now), 0).show();
        } else {
            currentContainer.showSetBetMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|(1:8)(1:38)|(1:10)|11|12|(1:14)(1:35)|(7:18|(2:(1:21)|22)|23|24|(3:26|(1:28)|(1:30))|31|32)|34|24|(0)|31|32))|39|6|(0)(0)|(0)|11|12|(0)(0)|(7:18|(0)|23|24|(0)|31|32)|34|24|(0)|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0133, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0134, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e2 A[Catch: NumberFormatException -> 0x0133, TryCatch #0 {NumberFormatException -> 0x0133, blocks: (B:14:0x00cd, B:16:0x00e2, B:21:0x00ed, B:24:0x0105, B:25:0x010b, B:26:0x010e, B:27:0x0117), top: B:40:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void createCurrentContainerItems$lambda$5(CurrentContainer currentContainer, View view) {
        int parseInt;
        String str;
        int parseInt2;
        CountDownTimer countDownTimer;
        CharSequence text = currentContainer.binding.ccItemLastBetPrice.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (StringsKt.endsWith$default(text, (CharSequence) currentContainer.currency, false, 2, (Object) null)) {
            CharSequence text2 = currentContainer.binding.ccItemTimeLeftTimer.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            if (!StringsKt.isBlank(text2)) {
                CharSequence text3 = currentContainer.binding.ccItemLastBetPrice.getText();
                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                parseInt = Integer.parseInt((String) StringsKt.split$default(text3, new String[]{" " + currentContainer.currency}, false, 0, 6, (Object) null).get(0));
                CharSequence text4 = currentContainer.binding.ccItemTimeLeftTimer.getText();
                Intrinsics.checkNotNullExpressionValue(text4, "getText(...)");
                str = (String) StringsKt.split$default(text4, new String[]{StringUtils.PROCESS_POSTFIX_DELIMITER}, false, 0, 6, (Object) null).get(0);
                if ((StringsKt.isBlank(str) ? Integer.parseInt(str) : 0) <= 0) {
                    Toast.makeText(currentContainer.currentContainer.getContext(), currentContainer.currentContainer.getContext().getString(R.string.auction_finished_cannot_bid), 0).show();
                }
                String obj = currentContainer.binding.ccInputForm.getText().toString();
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
                Toast.makeText(currentContainer.currentContainer.getContext(), currentContainer.currentContainer.getContext().getString(R.string.auction_new_bid_must_be_higher), 0).show();
                if (currentContainer.getTargetActivity().getCurrentFocus() != null) {
                }
                currentContainer.hiddenSetBetMenu();
            }
        }
        CharSequence text5 = currentContainer.binding.ccItemLastBetPrice.getText();
        Intrinsics.checkNotNullExpressionValue(text5, "getText(...)");
        parseInt = Integer.parseInt((String) StringsKt.split$default(text5, new String[]{" AZ"}, false, 0, 6, (Object) null).get(0));
        CharSequence text42 = currentContainer.binding.ccItemTimeLeftTimer.getText();
        Intrinsics.checkNotNullExpressionValue(text42, "getText(...)");
        str = (String) StringsKt.split$default(text42, new String[]{StringUtils.PROCESS_POSTFIX_DELIMITER}, false, 0, 6, (Object) null).get(0);
        if ((StringsKt.isBlank(str) ? Integer.parseInt(str) : 0) <= 0) {
        }
        String obj2 = currentContainer.binding.ccInputForm.getText().toString();
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
        Toast.makeText(currentContainer.currentContainer.getContext(), currentContainer.currentContainer.getContext().getString(R.string.auction_new_bid_must_be_higher), 0).show();
        if (currentContainer.getTargetActivity().getCurrentFocus() != null) {
        }
        currentContainer.hiddenSetBetMenu();
    }

    private final void showSetBetMenu() {
        this.binding.acBetBg.setVisibility(0);
        this.binding.acSetBetButton.setVisibility(0);
        this.binding.ccInputBetPrice.setVisibility(0);
        this.binding.ccInputBetName.setVisibility(0);
        this.binding.ccInputBetTittle.setVisibility(0);
        this.binding.ccInputBetBg.setVisibility(0);
        this.binding.ccInputBetTittle.setVisibility(0);
        this.binding.ccInputForm.setVisibility(0);
        this.binding.acExitButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hiddenSetBetMenu() {
        this.binding.acBetBg.setVisibility(4);
        this.binding.acSetBetButton.setVisibility(4);
        this.binding.ccInputBetPrice.setVisibility(4);
        this.binding.ccInputBetName.setVisibility(4);
        this.binding.ccInputBetTittle.setVisibility(4);
        this.binding.ccInputBetBg.setVisibility(4);
        this.binding.ccInputBetTittle.setVisibility(4);
        this.binding.ccInputForm.setVisibility(4);
        this.binding.acExitButton.setVisibility(4);
    }

    public final void addContainer(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Container container = (Container) MapperKt.toModel(message, Container.class);
        int typePrice = container.getTypePrice();
        AuctionCurrentContainerBinding auctionCurrentContainerBinding = this.binding;
        if (typePrice == 0) {
            auctionCurrentContainerBinding.ccItemPriceIcone.setText(this.currency);
            TextView textView = this.binding.ccItemLastBetPrice;
            int currentBet = container.getCurrentBet();
            textView.setText(currentBet + " " + this.currency);
            TextView textView2 = this.binding.ccInputBetPrice;
            int currentBet2 = container.getCurrentBet();
            textView2.setText(currentBet2 + " " + this.currency);
            this.binding.ccInputForm.setHint(this.currentContainer.getContext().getString(R.string.auction_bid_hint_cash));
        } else {
            auctionCurrentContainerBinding.ccItemLastBetPrice.setText(container.getCurrentBet() + " AZ");
            this.binding.ccInputBetPrice.setText(container.getCurrentBet() + " AZ");
            this.binding.ccItemPriceIcone.setText("AZ");
            this.binding.ccInputForm.setHint(this.currentContainer.getContext().getString(R.string.auction_bid_hint_az));
        }
        this.binding.ccItemDescription.setText(container.getTitle());
        this.binding.ccItemPrice.setText(String.valueOf(container.getStartPrice()));
        this.binding.ccItemLastBetName.setText(container.getCurrentBetUser());
        this.binding.ccInputBetName.setText(container.getCurrentBetUser());
        Picasso.get().load(CurrentContainerCdnKt.getContainerImageUrl(container.getImage())).placeholder(R.drawable.auction_container_item).error(R.drawable.auction_container_item).into(this.binding.ccItemImage);
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        int time = container.getTime();
        AuctionCurrentContainerBinding auctionCurrentContainerBinding2 = this.binding;
        if (time > 0) {
            auctionCurrentContainerBinding2.ccItemTimeLeftTittle.setText(this.currentContainer.getContext().getString(R.string.auction_time_left));
            final long time2 = container.getTime() * 1000;
            getTargetActivity().runOnUiThread(new Runnable() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainer$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CurrentContainer.addContainer$lambda$0(CurrentContainer.this, time2);
                }
            });
            return;
        }
        auctionCurrentContainerBinding2.ccItemTimeLeftTittle.setText(this.currentContainer.getContext().getString(R.string.auction_not_held));
        this.binding.ccItemTimeLeftTimer.setText(this.currentContainer.getContext().getString(R.string.auction_start_time, Integer.valueOf(container.getHourStartTime())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void addContainer$lambda$0(final CurrentContainer currentContainer, final long j) {
        CountDownTimer countDownTimer = new CountDownTimer(j) { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainer$addContainer$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                AuctionCurrentContainerBinding auctionCurrentContainerBinding;
                long j3 = j2 / 1000;
                auctionCurrentContainerBinding = currentContainer.binding;
                auctionCurrentContainerBinding.ccItemTimeLeftTimer.setText((j3 / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + (j3 % 60));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                AuctionCurrentContainerBinding auctionCurrentContainerBinding;
                auctionCurrentContainerBinding = currentContainer.binding;
                auctionCurrentContainerBinding.ccItemTimeLeftTimer.setText("00:00");
                cancel();
            }
        };
        currentContainer.timer = countDownTimer;
        countDownTimer.start();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addContainer(data);
        } else if (i == 1) {
            addRewards(data);
        } else {
            Log.w(TAG, "Incorrect SUB_ID=" + i + ", msg=" + data);
        }
    }

    public final synchronized void addRewards(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.currentContainerAdapter.addItems(MapperKt.toListModel(message, ContainerRewards.class));
        this.binding.ccRcView.smoothScrollToPosition(0);
    }

    /* compiled from: CurrentContainer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/current_container/presentation/CurrentContainer$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "current-container"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_CURRENT_CONTAINER);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CurrentContainer(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    /* compiled from: CurrentContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/current_container/presentation/CurrentContainer$Companion;", "", "<init>", "()V", "TAG", "", "current-container"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
