package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.arizona.common.ui.AvatarView;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudPageBinding implements ViewBinding {
    public final ConstraintLayout actionButton;
    public final ImageView actionButtonIc;
    public final TextView actionButtonTxt;
    public final LinearLayout actionNoticeWithDescriptionButton;
    public final ConstraintLayout actionNoticeWithDescriptionButtonClick;
    public final TextView actionNoticeWithDescriptionButtonText;
    public final TextView actionNoticeWithDescriptionDescription;
    public final TextView actionNoticeWithDescriptionTitle;
    public final LinearLayout actionNoticeWithoutDescriptionButton;
    public final ConstraintLayout actionNoticeWithoutDescriptionButtonClick;
    public final TextView actionNoticeWithoutDescriptionButtonText;
    public final TextView actionNoticeWithoutDescriptionButtonTitle;
    public final BannerElementBinding banner;
    public final FrameLayout bgForLocation;
    public final Guideline botGuideline;
    public final Guideline bottomQuestButtonLine;
    public final LinearLayout buttonsContainer;
    public final HudCaptBinding capt;
    public final ImageView endPointIc;
    public final LinearLayout groupButton;
    public final RecyclerView groupRv;
    public final Guideline halfHudeGuideline;
    public final LinearLayout hudButtonsContainer;
    public final ConstraintLayout hudContainer;
    public final ConstraintLayout hudDonateButton;
    public final AppCompatImageView hudDonateButtonIcon;
    public final ConstraintLayout hudInfoContainer;
    public final TextView hudInfoIdIcon;
    public final TextView hudInfoIdValue;
    public final TextView hudInfoMoneyValue;
    public final AppCompatImageView hudInfoPersonIcon;
    public final TextView hudInfoPersonValue;
    public final ConstraintLayout hudInventoryButton;
    public final AppCompatImageView hudInventoryButtonIcon;
    public final RodinaKaptScreenBinding hudKaptScreen;
    public final ConstraintLayout hudMenuButton;
    public final AppCompatImageView hudMenuButtonIcon;
    public final ImageView hudMoneyIcon;
    public final ConstraintLayout hudPage;
    public final ConstraintLayout hudPhoneButton;
    public final AppCompatImageView hudPhoneButtonIcon;
    public final HudProgressBarContainerBinding hudProgressBarLayout;
    public final HudProposalScreenBinding hudProposalScreen;
    public final ConstraintLayout hudServerInfoContainer;
    public final ConstraintLayout hudServerInfoMultiply;
    public final TextView hudServerInfoMultiplyValue;
    public final ConstraintLayout hudServerShieldContainer;
    public final AppCompatImageView hudServerShieldLogo;
    public final TextView hudServerShieldName;
    public final TextView hudServerShieldSite;
    public final ConstraintLayout hudStreamerButton;
    public final AppCompatImageView hudStreamerButtonIcon;
    public final HudTaximeterBinding hudTaximeterLayout;
    public final ImageView imageButtonInteraction;
    public final HudImprovingSkillsBinding improvingSkills;
    public final TextView income;
    public final ImageView incomeIc;
    public final Guideline incomeIcLeftLine;
    public final LinearLayout interactionButtonContainer;
    public final ImageView ivDoors;
    public final ImageView ivDoorsState;
    public final ImageView ivHorn;
    public final ImageView ivHornState;
    public final HudLeftMenuBinding leftMenu;
    public final Guideline leftQuestButtonLine;
    public final TextView locationCity;
    public final LinearLayout locationContainer;
    public final TextView locationText;
    public final TextView maxKm;
    public final AvatarView messageAvatar;
    public final TextView messageName;
    public final RelativeLayout messageNotificationContainer;
    public final TextView messageText;
    public final Guideline middleButtonLine;
    public final Guideline missionProgressBottomLine;
    public final LinearLayout missionProgressContainer;
    public final Guideline missionProgressGuideline;
    public final RecyclerView missionProgressList;
    public final TextView missionTitle;
    public final CardView newMessageContainer;
    public final Guideline noticeTopLine;
    public final LinearLayout noticeWithDescriptionButton;
    public final TextView noticeWithDescriptionDescription;
    public final TextView noticeWithDescriptionTitle;
    public final LinearLayout noticeWithoutDescriptionButton;
    public final TextView noticeWithoutDescriptionButtonTitle;
    public final Guideline notificationMessageGuideline;
    public final View overlay;
    public final HudElementPiratesBinding pirates;
    public final HudElementPromoBinding promo;
    public final HudRadarScreenBinding radar;
    public final Guideline rightQuestButtonLine;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rouletteContainer;
    public final ImageView rouletteIc;
    public final TextView rouletteText;
    public final TextView rouletteTime;
    public final ConstraintLayout rouletteTimeContainer;
    public final ConstraintLayout routeContainer;
    public final LottieAnimationView routeProgress;
    public final Guideline routeTopLine;
    public final TextView speedLimit;
    public final ImageView startPointIc;
    public final Guideline taximeterTopLine;
    public final TextView textInteraction;
    public final HudTimerBinding timer;
    public final ImageView timerIc;
    public final Guideline timerIcLeftLine;
    public final Guideline topGuideline;
    public final Guideline topQuestButtonLine;
    public final TextView trainCurrentTime;
    public final ConstraintLayout trainDriverContainer;
    public final ConstraintLayout trainInfoContainer;
    public final Guideline trainInfoTopLine;
    public final TextView trainMaxTime;
    public final ConstraintLayout trainSettings;
    public final TextView tvMessageCount;
    public final FrameLayout unreadMeassageContainer;
    public final ConstraintLayout vipContainer;
    public final TextView vipDays;
    public final TextView vipTitle;
    public final HudWalkieTalkieBinding walkieTalkie;
    public final ImageView warningIc;
    public final TextView warningsCount;
    public final TextView warningsCountTitle;

    private HudPageBinding(ConstraintLayout rootView, ConstraintLayout actionButton, ImageView actionButtonIc, TextView actionButtonTxt, LinearLayout actionNoticeWithDescriptionButton, ConstraintLayout actionNoticeWithDescriptionButtonClick, TextView actionNoticeWithDescriptionButtonText, TextView actionNoticeWithDescriptionDescription, TextView actionNoticeWithDescriptionTitle, LinearLayout actionNoticeWithoutDescriptionButton, ConstraintLayout actionNoticeWithoutDescriptionButtonClick, TextView actionNoticeWithoutDescriptionButtonText, TextView actionNoticeWithoutDescriptionButtonTitle, BannerElementBinding banner, FrameLayout bgForLocation, Guideline botGuideline, Guideline bottomQuestButtonLine, LinearLayout buttonsContainer, HudCaptBinding capt, ImageView endPointIc, LinearLayout groupButton, RecyclerView groupRv, Guideline halfHudeGuideline, LinearLayout hudButtonsContainer, ConstraintLayout hudContainer, ConstraintLayout hudDonateButton, AppCompatImageView hudDonateButtonIcon, ConstraintLayout hudInfoContainer, TextView hudInfoIdIcon, TextView hudInfoIdValue, TextView hudInfoMoneyValue, AppCompatImageView hudInfoPersonIcon, TextView hudInfoPersonValue, ConstraintLayout hudInventoryButton, AppCompatImageView hudInventoryButtonIcon, RodinaKaptScreenBinding hudKaptScreen, ConstraintLayout hudMenuButton, AppCompatImageView hudMenuButtonIcon, ImageView hudMoneyIcon, ConstraintLayout hudPage, ConstraintLayout hudPhoneButton, AppCompatImageView hudPhoneButtonIcon, HudProgressBarContainerBinding hudProgressBarLayout, HudProposalScreenBinding hudProposalScreen, ConstraintLayout hudServerInfoContainer, ConstraintLayout hudServerInfoMultiply, TextView hudServerInfoMultiplyValue, ConstraintLayout hudServerShieldContainer, AppCompatImageView hudServerShieldLogo, TextView hudServerShieldName, TextView hudServerShieldSite, ConstraintLayout hudStreamerButton, AppCompatImageView hudStreamerButtonIcon, HudTaximeterBinding hudTaximeterLayout, ImageView imageButtonInteraction, HudImprovingSkillsBinding improvingSkills, TextView income, ImageView incomeIc, Guideline incomeIcLeftLine, LinearLayout interactionButtonContainer, ImageView ivDoors, ImageView ivDoorsState, ImageView ivHorn, ImageView ivHornState, HudLeftMenuBinding leftMenu, Guideline leftQuestButtonLine, TextView locationCity, LinearLayout locationContainer, TextView locationText, TextView maxKm, AvatarView messageAvatar, TextView messageName, RelativeLayout messageNotificationContainer, TextView messageText, Guideline middleButtonLine, Guideline missionProgressBottomLine, LinearLayout missionProgressContainer, Guideline missionProgressGuideline, RecyclerView missionProgressList, TextView missionTitle, CardView newMessageContainer, Guideline noticeTopLine, LinearLayout noticeWithDescriptionButton, TextView noticeWithDescriptionDescription, TextView noticeWithDescriptionTitle, LinearLayout noticeWithoutDescriptionButton, TextView noticeWithoutDescriptionButtonTitle, Guideline notificationMessageGuideline, View overlay, HudElementPiratesBinding pirates, HudElementPromoBinding promo, HudRadarScreenBinding radar, Guideline rightQuestButtonLine, ConstraintLayout rouletteContainer, ImageView rouletteIc, TextView rouletteText, TextView rouletteTime, ConstraintLayout rouletteTimeContainer, ConstraintLayout routeContainer, LottieAnimationView routeProgress, Guideline routeTopLine, TextView speedLimit, ImageView startPointIc, Guideline taximeterTopLine, TextView textInteraction, HudTimerBinding timer, ImageView timerIc, Guideline timerIcLeftLine, Guideline topGuideline, Guideline topQuestButtonLine, TextView trainCurrentTime, ConstraintLayout trainDriverContainer, ConstraintLayout trainInfoContainer, Guideline trainInfoTopLine, TextView trainMaxTime, ConstraintLayout trainSettings, TextView tvMessageCount, FrameLayout unreadMeassageContainer, ConstraintLayout vipContainer, TextView vipDays, TextView vipTitle, HudWalkieTalkieBinding walkieTalkie, ImageView warningIc, TextView warningsCount, TextView warningsCountTitle) {
        this.rootView = rootView;
        this.actionButton = actionButton;
        this.actionButtonIc = actionButtonIc;
        this.actionButtonTxt = actionButtonTxt;
        this.actionNoticeWithDescriptionButton = actionNoticeWithDescriptionButton;
        this.actionNoticeWithDescriptionButtonClick = actionNoticeWithDescriptionButtonClick;
        this.actionNoticeWithDescriptionButtonText = actionNoticeWithDescriptionButtonText;
        this.actionNoticeWithDescriptionDescription = actionNoticeWithDescriptionDescription;
        this.actionNoticeWithDescriptionTitle = actionNoticeWithDescriptionTitle;
        this.actionNoticeWithoutDescriptionButton = actionNoticeWithoutDescriptionButton;
        this.actionNoticeWithoutDescriptionButtonClick = actionNoticeWithoutDescriptionButtonClick;
        this.actionNoticeWithoutDescriptionButtonText = actionNoticeWithoutDescriptionButtonText;
        this.actionNoticeWithoutDescriptionButtonTitle = actionNoticeWithoutDescriptionButtonTitle;
        this.banner = banner;
        this.bgForLocation = bgForLocation;
        this.botGuideline = botGuideline;
        this.bottomQuestButtonLine = bottomQuestButtonLine;
        this.buttonsContainer = buttonsContainer;
        this.capt = capt;
        this.endPointIc = endPointIc;
        this.groupButton = groupButton;
        this.groupRv = groupRv;
        this.halfHudeGuideline = halfHudeGuideline;
        this.hudButtonsContainer = hudButtonsContainer;
        this.hudContainer = hudContainer;
        this.hudDonateButton = hudDonateButton;
        this.hudDonateButtonIcon = hudDonateButtonIcon;
        this.hudInfoContainer = hudInfoContainer;
        this.hudInfoIdIcon = hudInfoIdIcon;
        this.hudInfoIdValue = hudInfoIdValue;
        this.hudInfoMoneyValue = hudInfoMoneyValue;
        this.hudInfoPersonIcon = hudInfoPersonIcon;
        this.hudInfoPersonValue = hudInfoPersonValue;
        this.hudInventoryButton = hudInventoryButton;
        this.hudInventoryButtonIcon = hudInventoryButtonIcon;
        this.hudKaptScreen = hudKaptScreen;
        this.hudMenuButton = hudMenuButton;
        this.hudMenuButtonIcon = hudMenuButtonIcon;
        this.hudMoneyIcon = hudMoneyIcon;
        this.hudPage = hudPage;
        this.hudPhoneButton = hudPhoneButton;
        this.hudPhoneButtonIcon = hudPhoneButtonIcon;
        this.hudProgressBarLayout = hudProgressBarLayout;
        this.hudProposalScreen = hudProposalScreen;
        this.hudServerInfoContainer = hudServerInfoContainer;
        this.hudServerInfoMultiply = hudServerInfoMultiply;
        this.hudServerInfoMultiplyValue = hudServerInfoMultiplyValue;
        this.hudServerShieldContainer = hudServerShieldContainer;
        this.hudServerShieldLogo = hudServerShieldLogo;
        this.hudServerShieldName = hudServerShieldName;
        this.hudServerShieldSite = hudServerShieldSite;
        this.hudStreamerButton = hudStreamerButton;
        this.hudStreamerButtonIcon = hudStreamerButtonIcon;
        this.hudTaximeterLayout = hudTaximeterLayout;
        this.imageButtonInteraction = imageButtonInteraction;
        this.improvingSkills = improvingSkills;
        this.income = income;
        this.incomeIc = incomeIc;
        this.incomeIcLeftLine = incomeIcLeftLine;
        this.interactionButtonContainer = interactionButtonContainer;
        this.ivDoors = ivDoors;
        this.ivDoorsState = ivDoorsState;
        this.ivHorn = ivHorn;
        this.ivHornState = ivHornState;
        this.leftMenu = leftMenu;
        this.leftQuestButtonLine = leftQuestButtonLine;
        this.locationCity = locationCity;
        this.locationContainer = locationContainer;
        this.locationText = locationText;
        this.maxKm = maxKm;
        this.messageAvatar = messageAvatar;
        this.messageName = messageName;
        this.messageNotificationContainer = messageNotificationContainer;
        this.messageText = messageText;
        this.middleButtonLine = middleButtonLine;
        this.missionProgressBottomLine = missionProgressBottomLine;
        this.missionProgressContainer = missionProgressContainer;
        this.missionProgressGuideline = missionProgressGuideline;
        this.missionProgressList = missionProgressList;
        this.missionTitle = missionTitle;
        this.newMessageContainer = newMessageContainer;
        this.noticeTopLine = noticeTopLine;
        this.noticeWithDescriptionButton = noticeWithDescriptionButton;
        this.noticeWithDescriptionDescription = noticeWithDescriptionDescription;
        this.noticeWithDescriptionTitle = noticeWithDescriptionTitle;
        this.noticeWithoutDescriptionButton = noticeWithoutDescriptionButton;
        this.noticeWithoutDescriptionButtonTitle = noticeWithoutDescriptionButtonTitle;
        this.notificationMessageGuideline = notificationMessageGuideline;
        this.overlay = overlay;
        this.pirates = pirates;
        this.promo = promo;
        this.radar = radar;
        this.rightQuestButtonLine = rightQuestButtonLine;
        this.rouletteContainer = rouletteContainer;
        this.rouletteIc = rouletteIc;
        this.rouletteText = rouletteText;
        this.rouletteTime = rouletteTime;
        this.rouletteTimeContainer = rouletteTimeContainer;
        this.routeContainer = routeContainer;
        this.routeProgress = routeProgress;
        this.routeTopLine = routeTopLine;
        this.speedLimit = speedLimit;
        this.startPointIc = startPointIc;
        this.taximeterTopLine = taximeterTopLine;
        this.textInteraction = textInteraction;
        this.timer = timer;
        this.timerIc = timerIc;
        this.timerIcLeftLine = timerIcLeftLine;
        this.topGuideline = topGuideline;
        this.topQuestButtonLine = topQuestButtonLine;
        this.trainCurrentTime = trainCurrentTime;
        this.trainDriverContainer = trainDriverContainer;
        this.trainInfoContainer = trainInfoContainer;
        this.trainInfoTopLine = trainInfoTopLine;
        this.trainMaxTime = trainMaxTime;
        this.trainSettings = trainSettings;
        this.tvMessageCount = tvMessageCount;
        this.unreadMeassageContainer = unreadMeassageContainer;
        this.vipContainer = vipContainer;
        this.vipDays = vipDays;
        this.vipTitle = vipTitle;
        this.walkieTalkie = walkieTalkie;
        this.warningIc = warningIc;
        this.warningsCount = warningsCount;
        this.warningsCountTitle = warningsCountTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HudPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -128
        	at java.base/java.util.BitSet.get(BitSet.java:626)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static ru.mrlargha.commonui.databinding.HudPageBinding bind(android.view.View r129) {
        /*
            Method dump skipped, instructions count: 1494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.mrlargha.commonui.databinding.HudPageBinding.bind(android.view.View):ru.mrlargha.commonui.databinding.HudPageBinding");
    }
}
