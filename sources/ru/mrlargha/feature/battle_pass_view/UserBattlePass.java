package ru.mrlargha.feature.battle_pass_view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.UserBattlepassBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.GsonStore;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/UserBattlepassBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "rewardItemAdapter", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "setVisible", "", "visible", "onBackendMessage", "data", "", "subId", "closeScreen", "Spawner", "battle-pass-view_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserBattlePass extends SAMPUIElement implements InterfaceController {
    private final UserBattlepassBinding binding;
    private final IBackendNotifier frontendNotifier;
    private final boolean isArizonaType;
    private final RewardItemAdapter rewardItemAdapter;
    private final ConstraintLayout screen;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBattlePass(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(ru.mrlargha.commonui.R.layout.user_battlepass, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screen = constraintLayout;
        UserBattlepassBinding bind = UserBattlepassBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        RewardItemAdapter rewardItemAdapter = new RewardItemAdapter(targetActivity);
        this.rewardItemAdapter = rewardItemAdapter;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.rvRewardsLinear.setAdapter(rewardItemAdapter);
        bind.rvRewardsGrid.setAdapter(rewardItemAdapter);
        bind.btnGetInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserBattlePass._init_$lambda$0(UserBattlePass.this, i, view);
            }
        });
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserBattlePass.this.closeScreen();
            }
        });
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(UserBattlePass userBattlePass, int i, View view) {
        userBattlePass.frontendNotifier.clickedWrapper(i, -1, 0);
        userBattlePass.closeScreen();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("UserBattlePass", "onBackendMessage: subId= " + i + " data = " + data);
        try {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) DataResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            DataResponse dataResponse = (DataResponse) fromJson;
            this.binding.tvTitleText.setText(dataResponse.getHeaders());
            this.binding.tvDescriptionText.setText(dataResponse.getDesc());
            this.rewardItemAdapter.setType(dataResponse.getType());
            if (dataResponse.getRewards() != null && dataResponse.getRewards().size() > 3) {
                this.binding.rvRewardsLinear.setVisibility(8);
                this.binding.rvRewardsGrid.setVisibility(0);
            } else {
                this.binding.rvRewardsLinear.setVisibility(0);
                this.binding.rvRewardsGrid.setVisibility(8);
            }
            this.rewardItemAdapter.submitList(dataResponse.getRewards());
            int type = dataResponse.getType();
            if (type == 1) {
                this.binding.tvTitleText.setTextColor(ContextCompat.getColor(getTargetActivity(), ru.mrlargha.feature.battlepassWinter2025.R.color.battlepass5));
                this.binding.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.ic_battlepass_title_2));
            } else if (type == 2) {
                this.binding.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.background_notify_other));
            } else if (type == 3) {
                this.binding.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.logo_path_of_dragon));
            } else if (type == 9) {
                this.binding.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.item_ticket_gift));
            } else if (type != 13) {
                if (type == 14) {
                    UserBattlepassBinding userBattlepassBinding = this.binding;
                    userBattlepassBinding.ivMainImage.setImageResource(ru.mrlargha.commonui.R.drawable.user_battle_pass_may_calendar_icon);
                    userBattlepassBinding.tvTitleText.setTextColor(Color.parseColor("#A5AB53"));
                    return;
                }
                if (this.isArizonaType) {
                    i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo;
                } else {
                    i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo;
                }
                this.binding.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), i2));
            } else {
                try {
                    UserBattlepassBinding userBattlepassBinding2 = this.binding;
                    if (this.isArizonaType) {
                        userBattlepassBinding2.tvTitleText.setTextColor(Color.parseColor("#59BCEB"));
                    } else {
                        userBattlepassBinding2.tvTitleText.setTextColor(Color.parseColor("#59BCEB"));
                    }
                    this.binding.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.feature.event.R.drawable.event_icon));
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    Integer.valueOf(Log.e("Exception", String.valueOf(e.getMessage())));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.USER_BATTLE_PASS.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: UserBattlePass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "battle-pass-view_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.USER_BATTLE_PASS);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new UserBattlePass(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
