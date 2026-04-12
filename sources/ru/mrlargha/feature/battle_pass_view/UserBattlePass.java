package ru.mrlargha.feature.battle_pass_view;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battle_pass_view.databinding.UserBattlepassBinding;
import ru.mrlargha.feature.battle_pass_view.databinding.UserBattlepassRodinaBinding;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020 H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/battle_pass_view/databinding/UserBattlepassBinding;", "screenRodina", "bindingRodina", "Lru/mrlargha/feature/battle_pass_view/databinding/UserBattlepassRodinaBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "rewardItemAdapter", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;", "rvRewardsLinear", "Landroidx/recyclerview/widget/RecyclerView;", "rvRewardsGrid", "btnGetInfo", "Landroid/widget/Button;", "btnClose", "tvTitleText", "Landroidx/appcompat/widget/AppCompatTextView;", "ivMainImage", "Landroidx/appcompat/widget/AppCompatImageView;", "setVisibility", "", "visible", "", "onBackendMessage", "data", "", "subId", "closeScreen", "setVisible", "Spawner", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserBattlePass extends SAMPUIElement implements InterfaceController {
    private final UserBattlepassBinding binding;
    private final UserBattlepassRodinaBinding bindingRodina;
    private final View btnClose;
    private final Button btnGetInfo;
    private final IBackendNotifier frontendNotifier;
    private final AppCompatImageView ivMainImage;
    private final RewardItemAdapter rewardItemAdapter;
    private final RecyclerView rvRewardsGrid;
    private final RecyclerView rvRewardsLinear;
    private final View screen;
    private final View screenRodina;
    private final AppCompatTextView tvTitleText;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setVisibility$lambda$0() {
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBattlePass(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.user_battlepass, (ViewGroup) null);
        this.screen = inflate;
        UserBattlepassBinding bind = UserBattlepassBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        View inflate2 = targetActivity.getLayoutInflater().inflate(R.layout.user_battlepass_rodina, (ViewGroup) null);
        this.screenRodina = inflate2;
        UserBattlepassRodinaBinding bind2 = UserBattlepassRodinaBinding.bind(inflate2);
        Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
        this.bindingRodina = bind2;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        RewardItemAdapter rewardItemAdapter = new RewardItemAdapter(targetActivity);
        this.rewardItemAdapter = rewardItemAdapter;
        RecyclerView recyclerView = UtilsKt.isArizonaType() ? bind.rvRewardsLinear : bind2.rvRewardsLinear;
        Intrinsics.checkNotNull(recyclerView);
        this.rvRewardsLinear = recyclerView;
        RecyclerView recyclerView2 = UtilsKt.isArizonaType() ? bind.rvRewardsGrid : bind2.rvRewardsGrid;
        Intrinsics.checkNotNull(recyclerView2);
        this.rvRewardsGrid = recyclerView2;
        Button btnGetInfo = bind2.btnGetInfo;
        Intrinsics.checkNotNullExpressionValue(btnGetInfo, "btnGetInfo");
        this.btnGetInfo = btnGetInfo;
        View btnClose = UtilsKt.isArizonaType() ? bind.btnClose : bind2.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        this.btnClose = btnClose;
        AppCompatTextView appCompatTextView = UtilsKt.isArizonaType() ? bind.tvTitleText : bind2.tvTitleText;
        Intrinsics.checkNotNull(appCompatTextView);
        this.tvTitleText = appCompatTextView;
        AppCompatImageView appCompatImageView = UtilsKt.isArizonaType() ? bind.ivMainImage : bind2.ivMainImage;
        Intrinsics.checkNotNull(appCompatImageView);
        this.ivMainImage = appCompatImageView;
        inflate = UtilsKt.isArizonaType() ? inflate : inflate2;
        Log.d(getCLASS_TAG(), ":currentScreen: " + inflate + " ");
        Intrinsics.checkNotNull(inflate);
        addViewToConstraintLayout(inflate, -1, -1);
        recyclerView.setAdapter(rewardItemAdapter);
        recyclerView2.setAdapter(rewardItemAdapter);
        bind2.btnGetInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda0
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
        bind2.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserBattlePass.this.closeScreen();
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        ConstraintLayout root = this.bindingRodina.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(z ? 0 : 8);
        UserBattlepassBinding userBattlepassBinding = this.binding;
        if (z) {
            userBattlepassBinding.linearLayout.setTranslationX(800.0f);
            this.binding.linearLayout.animate().translationX(0.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }
        userBattlepassBinding.linearLayout.animate().translationX(800.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                UserBattlePass.setVisibility$lambda$0();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
            this.rewardItemAdapter.setPath(dataResponse.getPath());
            this.tvTitleText.setText(dataResponse.getHeaders());
            this.bindingRodina.tvDescriptionText.setText(dataResponse.getDesc());
            this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo));
            this.rewardItemAdapter.setType(dataResponse.getType());
            if (dataResponse.getRewards() != null && dataResponse.getRewards().size() > 3) {
                this.rvRewardsLinear.setVisibility(8);
                this.rvRewardsGrid.setVisibility(0);
            } else {
                this.rvRewardsLinear.setVisibility(0);
                this.rvRewardsGrid.setVisibility(8);
            }
            this.rewardItemAdapter.submitList(dataResponse.getRewards());
            int type = dataResponse.getType();
            if (type == 1) {
                UserBattlePass userBattlePass = this;
                this.tvTitleText.setTextColor(ContextCompat.getColor(getTargetActivity(), ru.mrlargha.feature.battlepassWinter2025.R.color.battlepass5));
            } else if (type == 2) {
                this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.background_notify_other));
            } else if (type == 9) {
                this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.item_ticket_gift));
            } else if (type != 13) {
                if (type == 14) {
                    this.ivMainImage.setImageResource(ru.mrlargha.commonui.R.drawable.user_battle_pass_may_calendar_icon);
                    this.tvTitleText.setTextColor(Color.parseColor("#A5AB53"));
                    return;
                }
                if (UtilsKt.isArizonaType()) {
                    i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo;
                } else {
                    i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo;
                }
                this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), i2));
            } else {
                try {
                    UserBattlePass userBattlePass2 = this;
                    boolean isArizonaType = UtilsKt.isArizonaType();
                    AppCompatTextView appCompatTextView = this.tvTitleText;
                    if (isArizonaType) {
                        appCompatTextView.setTextColor(Color.parseColor("#59BCEB"));
                    } else {
                        appCompatTextView.setTextColor(Color.parseColor("#59BCEB"));
                    }
                    this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.feature.event.R.drawable.event_icon));
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
        setVisibility(false);
    }

    /* compiled from: UserBattlePass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
