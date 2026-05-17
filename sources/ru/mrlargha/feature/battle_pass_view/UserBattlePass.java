package ru.mrlargha.feature.battle_pass_view;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/battle_pass_view/databinding/UserBattlepassBinding;", "screenRodina", "bindingRodina", "Lru/mrlargha/feature/battle_pass_view/databinding/UserBattlepassRodinaBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "rewardItemAdapter", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;", "rvRewardsLinear", "Landroidx/recyclerview/widget/RecyclerView;", "linearLayout", "Landroid/widget/LinearLayout;", "rvRewardsGrid", "tvTitleText", "Landroidx/appcompat/widget/AppCompatTextView;", "ivMainImage", "Landroidx/appcompat/widget/AppCompatImageView;", "setVisibility", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "closeScreen", "setVisible", "Spawner", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserBattlePass extends SAMPUIElement implements InterfaceController {
    private final UserBattlepassBinding binding;
    private final UserBattlepassRodinaBinding bindingRodina;
    private final IBackendNotifier frontendNotifier;
    private final AppCompatImageView ivMainImage;
    private final LinearLayout linearLayout;
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
    public UserBattlePass(Activity targetActivity, int i) {
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
        LinearLayout linearLayout = UtilsKt.isArizonaType() ? bind.linearLayout : bind2.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        this.linearLayout = linearLayout;
        RecyclerView recyclerView2 = UtilsKt.isArizonaType() ? bind.rvRewardsGrid : bind2.rvRewardsGrid;
        Intrinsics.checkNotNull(recyclerView2);
        this.rvRewardsGrid = recyclerView2;
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
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserBattlePass.this.closeScreen();
            }
        });
        bind2.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserBattlePass.this.closeScreen();
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        LinearLayout linearLayout = this.linearLayout;
        if (z) {
            linearLayout.setTranslationX(800.0f);
            this.linearLayout.animate().translationX(0.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }
        linearLayout.animate().translationX(800.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: ru.mrlargha.feature.battle_pass_view.UserBattlePass$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                UserBattlePass.setVisibility$lambda$0();
            }
        }).start();
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

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        String str;
        String str2;
        int intValue;
        int i2;
        Intrinsics.checkNotNullParameter(data, "data");
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) DataResponse.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        DataResponse dataResponse = (DataResponse) fromJson;
        this.rewardItemAdapter.setPath(dataResponse.getPath());
        AppCompatTextView appCompatTextView = this.tvTitleText;
        str = "";
        if (UtilsKt.isArizonaType()) {
            String headers = dataResponse.getHeaders();
            str2 = headers != null ? headers : "";
        } else {
            String title = dataResponse.getTitle();
            if (title != null || (title = dataResponse.getHeaders()) != null) {
                str = title;
            }
            str2 = str;
        }
        appCompatTextView.setText(str2);
        this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo));
        if (UtilsKt.isArizonaType()) {
            intValue = dataResponse.getType();
        } else {
            Integer valueOf = Integer.valueOf(dataResponse.getImageType());
            if (valueOf.intValue() == 0) {
                valueOf = null;
            }
            intValue = valueOf != null ? valueOf.intValue() : dataResponse.getType();
        }
        this.rewardItemAdapter.setType(intValue);
        List<RewardResponse> rewards = dataResponse.getRewards();
        if (rewards == null) {
            rewards = CollectionsKt.emptyList();
        }
        int size = rewards.size();
        RecyclerView recyclerView = this.rvRewardsLinear;
        if (size > 3) {
            recyclerView.setVisibility(8);
            this.rvRewardsGrid.setVisibility(0);
        } else {
            recyclerView.setVisibility(0);
            this.rvRewardsGrid.setVisibility(8);
        }
        this.rewardItemAdapter.submitList(rewards);
        if (intValue == 1) {
            this.tvTitleText.setTextColor(ContextCompat.getColor(getTargetActivity(), ru.mrlargha.feature.battlepassWinter2025.R.color.battlepass5));
        } else if (intValue == 2) {
            this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.background_notify_other));
        } else if (intValue == 9) {
            this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.commonui.R.drawable.item_ticket_gift));
        } else if (intValue == 13) {
            try {
                UserBattlePass userBattlePass = this;
                boolean isArizonaType = UtilsKt.isArizonaType();
                AppCompatTextView appCompatTextView2 = this.tvTitleText;
                if (isArizonaType) {
                    appCompatTextView2.setTextColor(Color.parseColor("#59BCEB"));
                } else {
                    appCompatTextView2.setTextColor(Color.parseColor("#59BCEB"));
                }
                this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), ru.mrlargha.feature.event.R.drawable.event_icon));
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                Integer.valueOf(Log.e("Exception", String.valueOf(e.getMessage())));
            }
        } else if (intValue == 14) {
            this.ivMainImage.setImageResource(ru.mrlargha.commonui.R.drawable.user_battle_pass_may_calendar_icon);
            this.tvTitleText.setTextColor(Color.parseColor("#A5AB53"));
        } else {
            if (UtilsKt.isArizonaType()) {
                i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo;
            } else {
                i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.battlepass_logo;
            }
            this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), i2));
        }
        if (UtilsKt.isArizonaType()) {
            return;
        }
        Glide.with(getTargetActivity()).load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "/systems/hud_notification/" + intValue + ".webp").into(this.ivMainImage);
    }
}
