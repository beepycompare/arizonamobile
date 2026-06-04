package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudChickenGameItemBinding;
import ru.mrlargha.commonui.databinding.HudChickenGameToolsItemBinding;
import ru.mrlargha.commonui.databinding.HudElementChickenGameBinding;
import ru.mrlargha.commonui.databinding.HudPageBinding;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models.HudChickenGameModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models.HudChickenGameRatingModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models.HudChickenGameToolsModel;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: HudChickenGame.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020&J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGame;", "", "binding", "Lru/mrlargha/commonui/databinding/HudPageBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "hudListener", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;", "<init>", "(Lru/mrlargha/commonui/databinding/HudPageBinding;Lru/mrlargha/commonui/core/SAMPUIElement;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudPageBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "getHudListener", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudListener;", "chickenGameBinding", "Lru/mrlargha/commonui/databinding/HudElementChickenGameBinding;", "chickenGameAdapter", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter;", "isVisible", "", "", "setRatingList", "list", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameRatingModel;", "setToolsInfo", "gameModel", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameModel;", "setKilledChicken", "count", "", "setOnline", "setPlayerRating", CommonUrlParts.MODEL, "setMoney", "money", "", "setSize", "size", "setZone", "zone", "startTimer", "data", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenGame {
    private final HudPageBinding binding;
    private final HudChickenGameRatingAdapter chickenGameAdapter;
    private final HudElementChickenGameBinding chickenGameBinding;
    private final HudListener hudListener;
    private final SAMPUIElement notifier;

    public HudChickenGame(HudPageBinding binding, SAMPUIElement notifier, HudListener hudListener) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        Intrinsics.checkNotNullParameter(hudListener, "hudListener");
        this.binding = binding;
        this.notifier = notifier;
        this.hudListener = hudListener;
        HudElementChickenGameBinding chickenGame = binding.chickenGame;
        Intrinsics.checkNotNullExpressionValue(chickenGame, "chickenGame");
        this.chickenGameBinding = chickenGame;
        HudChickenGameRatingAdapter hudChickenGameRatingAdapter = new HudChickenGameRatingAdapter();
        this.chickenGameAdapter = hudChickenGameRatingAdapter;
        chickenGame.rvGamerList.setAdapter(hudChickenGameRatingAdapter);
        chickenGame.hudImposterGameTasks.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.HudChickenGame$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(HudChickenGame.this.notifier, 12, 0, null, 4, null);
            }
        });
    }

    public final HudPageBinding getBinding() {
        return this.binding;
    }

    public final HudListener getHudListener() {
        return this.hudListener;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final void isVisible(boolean z) {
        ConstraintLayout hideAll = this.binding.hideAll;
        Intrinsics.checkNotNullExpressionValue(hideAll, "hideAll");
        hideAll.setVisibility(!z ? 0 : 8);
        FrameLayout root = this.chickenGameBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(z ? 0 : 8);
        if (z) {
            return;
        }
        this.hudListener.hudSetTimer(0);
    }

    public final void setRatingList(List<HudChickenGameRatingModel> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.chickenGameAdapter.submitList(CollectionsKt.sortedWith(list, new Comparator() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.HudChickenGame$setRatingList$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((HudChickenGameRatingModel) t).getPosition()), Integer.valueOf(((HudChickenGameRatingModel) t2).getPosition()));
            }
        }));
    }

    public final void setToolsInfo(HudChickenGameModel gameModel) {
        Intrinsics.checkNotNullParameter(gameModel, "gameModel");
        HudElementChickenGameBinding hudElementChickenGameBinding = this.chickenGameBinding;
        List<HudChickenGameToolsItemBinding> listOf = CollectionsKt.listOf((Object[]) new HudChickenGameToolsItemBinding[]{hudElementChickenGameBinding.firstTools, hudElementChickenGameBinding.secondTools, hudElementChickenGameBinding.thirdTools});
        for (HudChickenGameToolsItemBinding hudChickenGameToolsItemBinding : listOf) {
            hudChickenGameToolsItemBinding.ivItem.setImageDrawable(null);
            CustomCardView hudImposterGameItem1 = hudChickenGameToolsItemBinding.hudImposterGameItem1;
            Intrinsics.checkNotNullExpressionValue(hudImposterGameItem1, "hudImposterGameItem1");
            CustomCardView.setBorder$default(hudImposterGameItem1, Color.parseColor("#1AFFFFFF"), 0, null, 4, null);
        }
        int i = 0;
        for (Object obj : gameModel.getTools()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final HudChickenGameToolsModel hudChickenGameToolsModel = (HudChickenGameToolsModel) obj;
            HudChickenGameToolsItemBinding hudChickenGameToolsItemBinding2 = (HudChickenGameToolsItemBinding) CollectionsKt.getOrNull(listOf, i);
            if (hudChickenGameToolsItemBinding2 != null) {
                Picasso.get().load(FirebaseConfigHelper.INSTANCE.getProjectResourceUrl(false) + "systems/pirate-event/chickengrad/bonuses/" + hudChickenGameToolsModel.getImage()).into(hudChickenGameToolsItemBinding2.ivItem);
                hudChickenGameToolsItemBinding2.tvCount.setText(String.valueOf(hudChickenGameToolsModel.getCount()));
                ImageView ivIc = hudChickenGameToolsItemBinding2.ivIc;
                Intrinsics.checkNotNullExpressionValue(ivIc, "ivIc");
                ivIc.setVisibility(hudChickenGameToolsModel.getLocked() == 1 || hudChickenGameToolsModel.getSelected() == 1 ? 0 : 8);
                if (hudChickenGameToolsModel.getSelected() == 1) {
                    CustomCardView hudImposterGameItem12 = hudChickenGameToolsItemBinding2.hudImposterGameItem1;
                    Intrinsics.checkNotNullExpressionValue(hudImposterGameItem12, "hudImposterGameItem1");
                    CustomCardView.setBorder$default(hudImposterGameItem12, Color.parseColor("#B331FF2D"), 0, null, 4, null);
                    hudChickenGameToolsItemBinding2.ivIc.setImageResource(R.drawable.rodina_quest_done_icon);
                }
                if (hudChickenGameToolsModel.getLocked() == 1) {
                    CustomCardView hudImposterGameItem13 = hudChickenGameToolsItemBinding2.hudImposterGameItem1;
                    Intrinsics.checkNotNullExpressionValue(hudImposterGameItem13, "hudImposterGameItem1");
                    CustomCardView.setBorder$default(hudImposterGameItem13, Color.parseColor("#B3FF1D38"), 0, null, 4, null);
                    hudChickenGameToolsItemBinding2.ivIc.setImageResource(R.drawable.hud_chicken_game_ic_lock);
                }
                hudChickenGameToolsItemBinding2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.HudChickenGame$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HudChickenGame.setToolsInfo$lambda$0$1$0$0(HudChickenGame.this, hudChickenGameToolsModel, view);
                    }
                });
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolsInfo$lambda$0$1$0$0(HudChickenGame hudChickenGame, HudChickenGameToolsModel hudChickenGameToolsModel, View view) {
        SAMPUIElement.notifyClick$default(hudChickenGame.notifier, 11, hudChickenGameToolsModel.getId(), null, 4, null);
    }

    public final void setKilledChicken(int i) {
        this.chickenGameBinding.hudImposterGameImposterValue.setText(String.valueOf(i));
    }

    public final void setOnline(int i) {
        this.chickenGameBinding.hudImposterGamePersonValue.setText(String.valueOf(i));
    }

    public final void setPlayerRating(HudChickenGameRatingModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        HudChickenGameItemBinding hudChickenGameItemBinding = this.chickenGameBinding.userRating;
        TextView textView = hudChickenGameItemBinding.tvGamerName;
        int position = model.getPosition();
        textView.setText(position + ". " + model.getName());
        hudChickenGameItemBinding.tvHeartCount.setText(String.valueOf(model.getPoints()));
    }

    public final void setMoney(String money) {
        Intrinsics.checkNotNullParameter(money, "money");
        this.chickenGameBinding.tvMoney.setText(money);
    }

    public final void setSize(String size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.chickenGameBinding.hudImposterGameRoleText.setText(StringsKt.replace$default(size, "\"", "", false, 4, (Object) null));
    }

    public final void setZone(String zone) {
        int i;
        Intrinsics.checkNotNullParameter(zone, "zone");
        if (Intrinsics.areEqual(zone, "1")) {
            i = R.drawable.hud_chichen_zone_green;
        } else {
            i = R.drawable.hud_chichen_zone_red;
        }
        this.chickenGameBinding.zoneType.setImageResource(i);
    }

    public final void startTimer(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Integer intOrNull = StringsKt.toIntOrNull(data);
        this.hudListener.hudSetTimer(intOrNull != null ? intOrNull.intValue() : 0);
    }
}
