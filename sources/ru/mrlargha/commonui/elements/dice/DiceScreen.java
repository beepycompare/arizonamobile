package ru.mrlargha.commonui.elements.dice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.DiceGameBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DiceScreen.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0017\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u0010#\u001a\u00020\u00182\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u001aH\u0002J\u001a\u0010(\u001a\u00020\u00182\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010%H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0005H\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050%H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \n*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "diceGame", "Landroid/view/View;", "kotlin.jvm.PlatformType", "diceGameBinding", "Lru/mrlargha/commonui/databinding/DiceGameBinding;", "dicePlayerAdapter", "Lru/mrlargha/commonui/elements/dice/DicePlayerAdapter;", "diceChatAdapter", "Lru/mrlargha/commonui/elements/dice/DiceChatAdapter;", "dec", "Ljava/text/DecimalFormat;", "sharedPref", "Landroid/content/SharedPreferences;", "isArizonaType", "", "onBackendMessage", "", "data", "", "subId", "updateTimer", "time", "(Ljava/lang/Integer;)V", "setClockInvisible", "makeBet", "setVisibilityBetButton", "text", "setCubes", "cubes", "", "setStatus", NotificationCompat.CATEGORY_STATUS, "setReadyBets", "bets", "setCurrentBet", "bet", "setSumBet", "getDicesList", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiceScreen extends SAMPUIElement {
    private final DecimalFormat dec;
    private final DiceChatAdapter diceChatAdapter;
    private final View diceGame;
    private final DiceGameBinding diceGameBinding;
    private final DicePlayerAdapter dicePlayerAdapter;
    private final boolean isArizonaType;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiceScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View diceGame = targetActivity.getLayoutInflater().inflate(R.layout.dice_game, (ViewGroup) null);
        this.diceGame = diceGame;
        final DiceGameBinding bind = DiceGameBinding.bind(diceGame);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.diceGameBinding = bind;
        DicePlayerAdapter dicePlayerAdapter = new DicePlayerAdapter();
        this.dicePlayerAdapter = dicePlayerAdapter;
        DiceChatAdapter diceChatAdapter = new DiceChatAdapter();
        this.diceChatAdapter = diceChatAdapter;
        this.dec = new DecimalFormat("###,###,###,###,###", new DecimalFormatSymbols(Locale.ENGLISH));
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        Intrinsics.checkNotNullExpressionValue(diceGame, "diceGame");
        addViewToConstraintLayout(diceGame, -1, -1);
        bind.gamerRecycler.setAdapter(dicePlayerAdapter);
        Activity activity = targetActivity;
        bind.gamerRecycler.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        bind.chatRecycler.setAdapter(diceChatAdapter);
        bind.chatRecycler.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        bind.sendButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiceScreen.this.notifyClick(1, -1, bind.enterMessage.getText().toString());
            }
        });
        bind.exitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(DiceScreen.this, 0, -1, null, 4, null);
            }
        });
        bind.clockIcon.setVisibility(8);
        bind.timer.setVisibility(8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (i) {
            case 0:
                DiceChatMessageData diceChatMessageData = (DiceChatMessageData) MapperKt.jsonToModel(data, DiceChatMessageData.class, getBackendID(), getTargetActivity(), getNotifier());
                if (diceChatMessageData != null) {
                    this.diceChatAdapter.addMessages(diceChatMessageData);
                    return;
                }
                return;
            case 1:
                DicePlayerData dicePlayerData = (DicePlayerData) MapperKt.jsonToModel(data, DicePlayerData.class, getBackendID(), getTargetActivity(), getNotifier());
                if (dicePlayerData != null) {
                    this.dicePlayerAdapter.addGamer(dicePlayerData);
                    return;
                }
                return;
            case 2:
                DiceUpdatePlayerData diceUpdatePlayerData = (DiceUpdatePlayerData) MapperKt.jsonToModel(data, DiceUpdatePlayerData.class, getBackendID(), getTargetActivity(), getNotifier());
                if (diceUpdatePlayerData != null) {
                    this.dicePlayerAdapter.updateGamer(diceUpdatePlayerData);
                    return;
                }
                return;
            case 3:
                DiceDeletePlayerData diceDeletePlayerData = (DiceDeletePlayerData) MapperKt.jsonToModel(data, DiceDeletePlayerData.class, getBackendID(), getTargetActivity(), getNotifier());
                if (diceDeletePlayerData != null) {
                    this.dicePlayerAdapter.deleteGamer(diceDeletePlayerData);
                    return;
                }
                return;
            case 4:
                DiceSession diceSession = (DiceSession) MapperKt.jsonToModel(data, DiceSession.class, getBackendID(), getTargetActivity(), getNotifier());
                if ((diceSession != null ? diceSession.getStatus() : null) != null) {
                    setStatus(diceSession.getStatus());
                }
                if ((diceSession != null ? diceSession.getSeconds() : null) != null) {
                    updateTimer(diceSession.getSeconds());
                } else {
                    setClockInvisible();
                }
                setVisibilityBetButton(diceSession != null ? diceSession.getButtonText() : null);
                if ((diceSession != null ? diceSession.getBet() : null) != null) {
                    setCurrentBet(diceSession.getBet().intValue());
                }
                if ((diceSession != null ? diceSession.getSumBet() : null) != null) {
                    setSumBet(diceSession.getSumBet().intValue());
                }
                List<Integer> readyBets = diceSession != null ? diceSession.getReadyBets() : null;
                if (readyBets != null && !readyBets.isEmpty()) {
                    setReadyBets(diceSession != null ? diceSession.getReadyBets() : null);
                }
                makeBet();
                setCubes(diceSession != null ? diceSession.getCubes() : null);
                return;
            case 5:
                this.dicePlayerAdapter.removeAllPlayers();
                this.diceChatAdapter.clearChat();
                return;
            case 6:
                this.dicePlayerAdapter.sortGamers();
                return;
            default:
                return;
        }
    }

    private final void updateTimer(Integer num) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        diceGameBinding.clockIcon.setVisibility(0);
        diceGameBinding.timer.setVisibility(0);
        diceGameBinding.timer.setText(String.valueOf(num));
    }

    private final void setClockInvisible() {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        diceGameBinding.clockIcon.setVisibility(8);
        diceGameBinding.timer.setVisibility(8);
    }

    private final void makeBet() {
        final DiceGameBinding diceGameBinding = this.diceGameBinding;
        if (diceGameBinding.betWhiteButton.getVisibility() == 0) {
            diceGameBinding.betWhiteButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DiceScreen.makeBet$lambda$14$lambda$13(DiceGameBinding.this, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeBet$lambda$14$lambda$13(final DiceGameBinding diceGameBinding, final DiceScreen diceScreen, View view) {
        if (Intrinsics.areEqual("Сделать ставку", diceGameBinding.makeBidText.getText())) {
            diceGameBinding.diceBetScreen.setVisibility(0);
            diceGameBinding.bet50kButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiceScreen.makeBet$lambda$14$lambda$13$lambda$8(DiceGameBinding.this, view2);
                }
            });
            diceGameBinding.bet100kButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiceScreen.makeBet$lambda$14$lambda$13$lambda$9(DiceGameBinding.this, view2);
                }
            });
            diceGameBinding.bet500kButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiceScreen.makeBet$lambda$14$lambda$13$lambda$10(DiceGameBinding.this, view2);
                }
            });
            diceGameBinding.bet1kkButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiceScreen.makeBet$lambda$14$lambda$13$lambda$11(DiceGameBinding.this, view2);
                }
            });
            diceGameBinding.betButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dice.DiceScreen$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiceScreen.makeBet$lambda$14$lambda$13$lambda$12(DiceScreen.this, diceGameBinding, view2);
                }
            });
            return;
        }
        SAMPUIElement.notifyClick$default(diceScreen, 2, -1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeBet$lambda$14$lambda$13$lambda$8(DiceGameBinding diceGameBinding, View view) {
        diceGameBinding.enterBet.setText(diceGameBinding.bet50kButtonText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeBet$lambda$14$lambda$13$lambda$9(DiceGameBinding diceGameBinding, View view) {
        diceGameBinding.enterBet.setText(diceGameBinding.bet100kButtonText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeBet$lambda$14$lambda$13$lambda$10(DiceGameBinding diceGameBinding, View view) {
        diceGameBinding.enterBet.setText(diceGameBinding.bet500kButtonText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeBet$lambda$14$lambda$13$lambda$11(DiceGameBinding diceGameBinding, View view) {
        diceGameBinding.enterBet.setText(diceGameBinding.bet1kkButtonText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeBet$lambda$14$lambda$13$lambda$12(DiceScreen diceScreen, DiceGameBinding diceGameBinding, View view) {
        diceScreen.notifyClick(2, -1, diceGameBinding.enterBet.getText().toString());
        diceGameBinding.diceBetScreen.setVisibility(8);
    }

    private final void setVisibilityBetButton(String str) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        if (str != null) {
            String str2 = str;
            if (str2.length() == 0) {
                diceGameBinding.betWhiteButton.setVisibility(8);
                return;
            }
            diceGameBinding.betWhiteButton.setVisibility(0);
            diceGameBinding.makeBidText.setText(str2);
        }
    }

    private final void setCubes(List<Integer> list) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        if (list != null) {
            List<Integer> dicesList = getDicesList();
            if (list.get(0) == null && list.get(1) == null) {
                List<Integer> list2 = dicesList;
                diceGameBinding.leftDice.setImageResource(dicesList.get(RangesKt.random(CollectionsKt.getIndices(list2), Random.Default)).intValue());
                diceGameBinding.rightDice.setImageResource(dicesList.get(RangesKt.random(CollectionsKt.getIndices(list2), Random.Default)).intValue());
            } else {
                AppCompatImageView appCompatImageView = diceGameBinding.leftDice;
                Integer num = list.get(0);
                Integer valueOf = num != null ? Integer.valueOf(num.intValue() - 1) : null;
                Intrinsics.checkNotNull(valueOf);
                appCompatImageView.setImageResource(dicesList.get(valueOf.intValue()).intValue());
                AppCompatImageView appCompatImageView2 = diceGameBinding.rightDice;
                Integer num2 = list.get(1);
                Integer valueOf2 = num2 != null ? Integer.valueOf(num2.intValue() - 1) : null;
                Intrinsics.checkNotNull(valueOf2);
                appCompatImageView2.setImageResource(dicesList.get(valueOf2.intValue()).intValue());
            }
            diceGameBinding.leftDice.setVisibility(0);
            diceGameBinding.rightDice.setVisibility(0);
            return;
        }
        diceGameBinding.leftDice.setVisibility(8);
        diceGameBinding.rightDice.setVisibility(8);
    }

    private final void setStatus(String str) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        String str2 = str;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "Настройка сессии", false, 2, (Object) null)) {
            diceGameBinding.currentBetHeader.setVisibility(4);
            diceGameBinding.currentBet.setVisibility(4);
            diceGameBinding.sumOfBetHeader.setVisibility(4);
            diceGameBinding.sumOfBet.setVisibility(4);
            diceGameBinding.sumOfBet.setText("0");
        } else {
            diceGameBinding.currentBetHeader.setVisibility(0);
            diceGameBinding.currentBet.setVisibility(0);
            diceGameBinding.sumOfBetHeader.setVisibility(0);
            diceGameBinding.sumOfBet.setVisibility(0);
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "Ход игрока:", false, 2, (Object) null)) {
            diceGameBinding.turnTitle.setVisibility(0);
            diceGameBinding.gamerTurn.setVisibility(0);
            diceGameBinding.turnTitle.setText("Ход игрока: ");
            diceGameBinding.gamerTurn.setText((CharSequence) StringsKt.split$default((CharSequence) str2, new String[]{"Ход игрока: "}, false, 0, 6, (Object) null).get(1));
        } else if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "Победил:", false, 2, (Object) null)) {
            diceGameBinding.turnTitle.setVisibility(0);
            diceGameBinding.gamerTurn.setVisibility(0);
            diceGameBinding.turnTitle.setText("Победил: ");
            diceGameBinding.gamerTurn.setText((CharSequence) StringsKt.split$default((CharSequence) str2, new String[]{"Победил: "}, false, 0, 6, (Object) null).get(1));
        } else {
            diceGameBinding.turnTitle.setVisibility(8);
            diceGameBinding.gamerTurn.setVisibility(0);
            diceGameBinding.gamerTurn.setText(str2);
        }
    }

    private final void setReadyBets(List<Integer> list) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        if (list != null) {
            if (list.get(0) != null) {
                diceGameBinding.bet50kButtonText.setText(String.valueOf(list.get(0)));
            }
            if (list.get(1) != null) {
                diceGameBinding.bet100kButtonText.setText(String.valueOf(list.get(1)));
            }
            if (list.get(2) != null) {
                diceGameBinding.bet500kButtonText.setText(String.valueOf(list.get(2)));
            }
            if (list.get(3) != null) {
                diceGameBinding.bet1kkButtonText.setText(String.valueOf(list.get(3)));
            }
        }
    }

    private final void setCurrentBet(int i) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        if (this.isArizonaType) {
            diceGameBinding.currentBet.setText(this.dec.format(Integer.valueOf(i)) + " $");
            return;
        }
        diceGameBinding.currentBet.setText(this.dec.format(Integer.valueOf(i)) + " ₽");
    }

    private final void setSumBet(int i) {
        DiceGameBinding diceGameBinding = this.diceGameBinding;
        if (this.isArizonaType) {
            diceGameBinding.sumOfBet.setText(this.dec.format(Integer.valueOf(i)) + " $");
            return;
        }
        diceGameBinding.sumOfBet.setText(this.dec.format(Integer.valueOf(i)) + " ₽");
    }

    private final List<Integer> getDicesList() {
        return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.dice_1_ic), Integer.valueOf(R.drawable.dice_2_ic), Integer.valueOf(R.drawable.dice_3_ic), Integer.valueOf(R.drawable.dice_4_ic), Integer.valueOf(R.drawable.dice_5_ic), Integer.valueOf(R.drawable.dice_6_ic)});
    }

    /* compiled from: DiceScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DiceScreen(targetActivity, i);
        }
    }
}
