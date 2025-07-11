package ru.mrlargha.commonui.elements.casino;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.CasinoLayoutBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CasinoScreen.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/casino/CasinoScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/CasinoLayoutBinding;", "timer", "Landroid/os/CountDownTimer;", "setCasinoType", "", "info", "", "setBalance", "updateBet", "setWinScreen", "Lru/mrlargha/commonui/elements/casino/CasinoScreen$Companion$WinInfo;", "setBackground", "type", "onBackendMessage", "data", "subId", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CasinoScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final CasinoLayoutBinding binding;
    private final ConstraintLayout layout;
    private CountDownTimer timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasinoScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.casino_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        CasinoLayoutBinding bind = CasinoLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$0(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ConstraintLayout actionButton = bind.actionButton;
        Intrinsics.checkNotNullExpressionValue(actionButton, "actionButton");
        EasyAnimation.animateClick$default(easyAnimation2, actionButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$1(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ImageView minusButton = bind.minusButton;
        Intrinsics.checkNotNullExpressionValue(minusButton, "minusButton");
        EasyAnimation.animateClick$default(easyAnimation3, minusButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$2(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation4 = EasyAnimation.INSTANCE;
        ImageView plusButton = bind.plusButton;
        Intrinsics.checkNotNullExpressionValue(plusButton, "plusButton");
        EasyAnimation.animateClick$default(easyAnimation4, plusButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$3(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation5 = EasyAnimation.INSTANCE;
        ImageView leftButton = bind.leftButton;
        Intrinsics.checkNotNullExpressionValue(leftButton, "leftButton");
        EasyAnimation.animateClick$default(easyAnimation5, leftButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$4(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation6 = EasyAnimation.INSTANCE;
        ImageView rightButton = bind.rightButton;
        Intrinsics.checkNotNullExpressionValue(rightButton, "rightButton");
        EasyAnimation.animateClick$default(easyAnimation6, rightButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$5(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation7 = EasyAnimation.INSTANCE;
        ImageView upButton = bind.upButton;
        Intrinsics.checkNotNullExpressionValue(upButton, "upButton");
        EasyAnimation.animateClick$default(easyAnimation7, upButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$6(CasinoScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation8 = EasyAnimation.INSTANCE;
        ImageView bottomButton = bind.bottomButton;
        Intrinsics.checkNotNullExpressionValue(bottomButton, "bottomButton");
        EasyAnimation.animateClick$default(easyAnimation8, bottomButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CasinoScreen.lambda$8$lambda$7(CasinoScreen.this);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$0(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$1(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$2(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 2, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$3(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 3, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$4(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 4, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$5(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 5, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$6(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 6, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$8$lambda$7(CasinoScreen casinoScreen) {
        SAMPUIElement.notifyClick$default(casinoScreen, 0, 7, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setCasinoType(String str) {
        CasinoLayoutBinding casinoLayoutBinding = this.binding;
        int hashCode = str.hashCode();
        if (hashCode == -1396352480) {
            if (str.equals("bandit")) {
                casinoLayoutBinding.gameName.setText("Однорукий бандит");
            }
        } else if (hashCode == -1948940) {
            if (str.equals("roulette")) {
                casinoLayoutBinding.gameName.setText("Американская рулетка");
            }
        } else if (hashCode == 96634189 && str.equals("empty")) {
            casinoLayoutBinding.gameName.setText("");
        }
    }

    private final void setBalance(String str) {
        this.binding.balance.setText(str);
    }

    private final void updateBet(String str) {
        this.binding.bet.setText("Ставка " + str);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [ru.mrlargha.commonui.elements.casino.CasinoScreen$setWinScreen$1$1] */
    private final void setWinScreen(Companion.WinInfo winInfo) {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        final CasinoLayoutBinding casinoLayoutBinding = this.binding;
        casinoLayoutBinding.casinoWinScreen.setVisibility(0);
        casinoLayoutBinding.winTitle.setText(winInfo.getText());
        casinoLayoutBinding.winCount.setText(String.valueOf(winInfo.getChips()));
        final long timeout = winInfo.getTimeout() * 1000;
        CountDownTimer start = new CountDownTimer(timeout) { // from class: ru.mrlargha.commonui.elements.casino.CasinoScreen$setWinScreen$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                CasinoLayoutBinding.this.casinoWinScreen.setVisibility(8);
                cancel();
            }
        }.start();
        Intrinsics.checkNotNullExpressionValue(start, "start(...)");
        this.timer = start;
    }

    private final void setBackground(String str) {
        if (Intrinsics.areEqual(str, "purple")) {
            this.binding.casinoWinScreen.setBackgroundResource(R.drawable.casino_win_bg);
        } else if (Intrinsics.areEqual(str, "red")) {
            this.binding.casinoWinScreen.setBackgroundResource(R.drawable.casino_loose_bg);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (i) {
            case 0:
                setCasinoType(data);
                return;
            case 1:
                setBalance(data);
                return;
            case 2:
                updateBet(data);
                return;
            case 3:
                this.binding.actionButtonTxt.setText(data);
                return;
            case 4:
                if (Intrinsics.areEqual(data, "true")) {
                    this.binding.controlContainer.setVisibility(0);
                    return;
                } else if (Intrinsics.areEqual(data, "false")) {
                    this.binding.controlContainer.setVisibility(8);
                    return;
                } else {
                    return;
                }
            case 5:
                setWinScreen((Companion.WinInfo) MapperKt.toModel(data, Companion.WinInfo.class));
                return;
            case 6:
                setBackground(data);
                return;
            default:
                return;
        }
    }

    /* compiled from: CasinoScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/commonui/elements/casino/CasinoScreen$Companion;", "", "<init>", "()V", "WinInfo", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: CasinoScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/casino/CasinoScreen$Companion$WinInfo;", "", "text", "", "chips", "", "timeout", "<init>", "(Ljava/lang/String;II)V", "getText", "()Ljava/lang/String;", "getChips", "()I", "getTimeout", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class WinInfo {
            private final int chips;
            private final String text;
            private final int timeout;

            public static /* synthetic */ WinInfo copy$default(WinInfo winInfo, String str, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = winInfo.text;
                }
                if ((i3 & 2) != 0) {
                    i = winInfo.chips;
                }
                if ((i3 & 4) != 0) {
                    i2 = winInfo.timeout;
                }
                return winInfo.copy(str, i, i2);
            }

            public final String component1() {
                return this.text;
            }

            public final int component2() {
                return this.chips;
            }

            public final int component3() {
                return this.timeout;
            }

            public final WinInfo copy(String text, int i, int i2) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new WinInfo(text, i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof WinInfo) {
                    WinInfo winInfo = (WinInfo) obj;
                    return Intrinsics.areEqual(this.text, winInfo.text) && this.chips == winInfo.chips && this.timeout == winInfo.timeout;
                }
                return false;
            }

            public int hashCode() {
                return (((this.text.hashCode() * 31) + Integer.hashCode(this.chips)) * 31) + Integer.hashCode(this.timeout);
            }

            public String toString() {
                String str = this.text;
                int i = this.chips;
                return "WinInfo(text=" + str + ", chips=" + i + ", timeout=" + this.timeout + ")";
            }

            public WinInfo(String text, int i, int i2) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
                this.chips = i;
                this.timeout = i2;
            }

            public final int getChips() {
                return this.chips;
            }

            public final String getText() {
                return this.text;
            }

            public final int getTimeout() {
                return this.timeout;
            }
        }

        private Companion() {
        }
    }

    /* compiled from: CasinoScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/casino/CasinoScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CasinoScreen(targetActivity, i);
        }
    }
}
