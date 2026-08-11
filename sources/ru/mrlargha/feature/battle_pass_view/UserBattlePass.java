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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.hud.presentation.RodinaHudSubwindowEvents;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battle_pass_view.databinding.UserBattlepassBinding;
import ru.mrlargha.feature.battle_pass_view.databinding.UserBattlepassRodinaBinding;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002/0B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\u00020\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/battle_pass_view/databinding/UserBattlepassBinding;", "screenRodina", "bindingRodina", "Lru/mrlargha/feature/battle_pass_view/databinding/UserBattlepassRodinaBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "rewardItemAdapter", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;", "rvRewardsLinear", "Landroidx/recyclerview/widget/RecyclerView;", "linearLayout", "Landroid/widget/LinearLayout;", "rvRewardsGrid", "tvTitleText", "Landroidx/appcompat/widget/AppCompatTextView;", "ivMainImage", "Landroidx/appcompat/widget/AppCompatImageView;", "setVisibility", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "showDynamicReward", "response", "Lru/mrlargha/feature/battle_pass_view/DynamicRewardResponse;", "showRewards", "rewards", "", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "closeScreen", "setVisible", "Companion", "Spawner", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserBattlePass extends SAMPUIElement implements InterfaceController {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int DYNAMIC_REWARD_SUB_ID = 1;
    @Deprecated
    public static final String MAIN_IMAGE_PATH = "systems/hud_notification/";
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

    /* compiled from: UserBattlePass.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass$Companion;", "", "<init>", "()V", "DYNAMIC_REWARD_SUB_ID", "", "MAIN_IMAGE_PATH", "", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!UtilsKt.isArizonaType()) {
            RodinaHudSubwindowEvents.INSTANCE.setBattlePassRewardsBannerVisible(z);
        }
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

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        String str;
        String str2;
        int intValue;
        int i2;
        String title;
        String description;
        String info;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 1) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) DynamicRewardResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            showDynamicReward((DynamicRewardResponse) fromJson);
            return;
        }
        Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) DataResponse.class);
        Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
        DataResponse dataResponse = (DataResponse) fromJson2;
        this.rewardItemAdapter.setDynamicContract(false);
        this.rewardItemAdapter.setPath(dataResponse.getPath());
        this.tvTitleText.setTextColor(-1);
        AppCompatTextView appCompatTextView = this.tvTitleText;
        str = "";
        if (UtilsKt.isArizonaType()) {
            String headers = dataResponse.getHeaders();
            str2 = headers != null ? headers : "";
        } else {
            String title2 = dataResponse.getTitle();
            if (title2 != null || (title2 = dataResponse.getHeaders()) != null) {
                str = title2;
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
        ArrayList rewards = dataResponse.getRewards();
        if (rewards == null) {
            rewards = CollectionsKt.emptyList();
        }
        if (!UtilsKt.isArizonaType()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : rewards) {
                RewardResponse rewardResponse = (RewardResponse) obj;
                if (rewardResponse.getSysName() > 0 || (((title = rewardResponse.getTitle()) != null && !StringsKt.isBlank(title)) || (((description = rewardResponse.getDescription()) != null && !StringsKt.isBlank(description)) || ((info = rewardResponse.getInfo()) != null && !StringsKt.isBlank(info))))) {
                    arrayList.add(obj);
                }
            }
            rewards = arrayList;
        }
        showRewards(rewards);
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
                i2 = ru.mrlargha.feature.battlepassWinter2025.R.drawable.winter_bp_skin_pink_logo;
            }
            this.ivMainImage.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), i2));
        }
        if (UtilsKt.isArizonaType()) {
            return;
        }
        if (dataResponse.getImageType() == 3) {
            int parseColor = Color.parseColor("#E26804");
            int parseColor2 = Color.parseColor("#FDBA08");
            this.bindingRodina.ivTopbarBackground.setImageResource(R.drawable.user_battlepass_topbar_bg_rodina);
            this.bindingRodina.ivMainImage.setImageResource(R.drawable.user_battlepass_logo10);
            CustomCardView contentCard = this.bindingRodina.contentCard;
            Intrinsics.checkNotNullExpressionValue(contentCard, "contentCard");
            CustomCardView.setBackground$default(contentCard, parseColor, parseColor2, 90, null, 8, null);
            this.bindingRodina.contentCard.setBorder(parseColor2, Color.parseColor("#004E375E"), 90);
            return;
        }
        int parseColor3 = Color.parseColor("#7E1F24");
        int parseColor4 = Color.parseColor("#9F3937");
        this.bindingRodina.ivTopbarBackground.setImageResource(R.drawable.user_battlepass_topbar_bg_rodina_old);
        this.bindingRodina.ivMainImage.setImageResource(R.drawable.user_battlepass_rodina_usual);
        CustomCardView contentCard2 = this.bindingRodina.contentCard;
        Intrinsics.checkNotNullExpressionValue(contentCard2, "contentCard");
        CustomCardView.setBackground$default(contentCard2, parseColor3, parseColor4, 90, null, 8, null);
        this.bindingRodina.contentCard.setBorder(parseColor4, Color.parseColor("#004E375E"), 90);
    }

    private final void showDynamicReward(DynamicRewardResponse dynamicRewardResponse) {
        this.rewardItemAdapter.setDynamicContract(true);
        this.rewardItemAdapter.setPath(dynamicRewardResponse.getPath());
        this.rewardItemAdapter.setType(dynamicRewardResponse.getImageType());
        this.tvTitleText.setTextColor(-1);
        AppCompatTextView appCompatTextView = this.tvTitleText;
        String title = dynamicRewardResponse.getTitle();
        if (title == null) {
            title = "";
        }
        appCompatTextView.setText(title);
        List<RewardResponse> rewards = dynamicRewardResponse.getRewards();
        if (rewards == null) {
            rewards = CollectionsKt.emptyList();
        }
        showRewards(rewards);
        Glide.with(this.ivMainImage).load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + MAIN_IMAGE_PATH + dynamicRewardResponse.getImageType() + ".webp").fitCenter().into(this.ivMainImage);
        List<String> mainColors = dynamicRewardResponse.getMainColors();
        if (mainColors == null) {
            mainColors = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : mainColors) {
            Integer backendColorOrNull = RewardItemAdapterKt.toBackendColorOrNull(str);
            if (backendColorOrNull != null) {
                arrayList.add(backendColorOrNull);
            }
        }
        ArrayList arrayList2 = arrayList;
        CustomCardView customCardView = UtilsKt.isArizonaType() ? this.binding.contentCard : this.bindingRodina.contentCard;
        Intrinsics.checkNotNull(customCardView);
        if (arrayList2.size() >= 6) {
            if (UtilsKt.isArizonaType()) {
                CustomCardView topbarBackground = this.binding.topbarBackground;
                Intrinsics.checkNotNullExpressionValue(topbarBackground, "topbarBackground");
                CustomCardView.setBackground$default(topbarBackground, ((Number) arrayList2.get(0)).intValue(), ((Number) arrayList2.get(1)).intValue(), 90, null, 8, null);
                CustomCardView headerGradient = this.binding.headerGradient;
                Intrinsics.checkNotNullExpressionValue(headerGradient, "headerGradient");
                CustomCardView.setBackground$default(headerGradient, 0, ((Number) arrayList2.get(1)).intValue(), 90, null, 8, null);
            }
            CustomCardView.setBackground$default(customCardView, ((Number) arrayList2.get(2)).intValue(), ((Number) arrayList2.get(3)).intValue(), 90, null, 8, null);
            customCardView.setBorder(((Number) arrayList2.get(4)).intValue(), ((Number) arrayList2.get(5)).intValue(), 90);
        } else if (arrayList2.size() >= 2) {
            CustomCardView.setBackground$default(customCardView, CollectionsKt.toIntArray(arrayList2), 90, null, 4, null);
        } else if (arrayList2.size() == 1) {
            customCardView.setBackground(((Number) arrayList2.get(0)).intValue());
        }
    }

    private final void showRewards(List<RewardResponse> list) {
        boolean z = list.size() > 3;
        this.rvRewardsLinear.setVisibility(!z ? 0 : 8);
        this.rvRewardsGrid.setVisibility(z ? 0 : 8);
        this.rewardItemAdapter.submitList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.USER_BATTLE_PASS.getId(), false);
        setVisibility(false);
    }

    /* compiled from: UserBattlePass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/UserBattlePass$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
