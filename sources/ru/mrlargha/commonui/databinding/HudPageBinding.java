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
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.AvatarView;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
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
    public final HudBodycamBinding bodycam;
    public final Guideline botGuideline;
    public final Guideline bottomQuestButtonLine;
    public final LinearLayout buttonsContainer;
    public final HudCaptBinding capt;
    public final HudElementCasesTimerBinding casesTimer;
    public final HudElementChickenChargeBinding chargeChiken;
    public final HudElementChickenGameBinding chickenGame;
    public final HudElementDamageInformerBinding damageInformer;
    public final HudDriftCounterBinding driftCounter;
    public final HudFactionCaptureBinding factionCapture;
    public final HudFootballBinding football;
    public final HudGathersCountBinding gatherCount;
    public final LinearLayout groupButton;
    public final RecyclerView groupRv;
    public final Guideline halfHudeGuideline;
    public final ConstraintLayout hideAll;
    public final LinearLayout hudButtonsContainer;
    public final ConstraintLayout hudContainer;
    public final ConstraintLayout hudDonateButton;
    public final AppCompatImageView hudDonateButtonIcon;
    public final LinearLayout hudInfoContainer;
    public final TextView hudInfoIdIcon;
    public final TextView hudInfoIdValue;
    public final TextView hudInfoMoneyValue;
    public final ImageView hudInfoPersonIcon;
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
    public final HudTrainJobBinding hudTrainJob;
    public final ImageView imageButtonInteraction;
    public final HudElementImposterGameBinding imposterGame;
    public final HudImprovingSkillsBinding improvingSkills;
    public final LinearLayout interactionButtonContainer;
    public final HudLeftMenuBinding leftMenu;
    public final Guideline leftQuestButtonLine;
    public final TextView locationCity;
    public final LinearLayout locationContainer;
    public final TextView locationText;
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
    public final HudElementMoneyBinding newMoney;
    public final Guideline noticeTopLine;
    public final HudNoticeWarningBinding noticeWarning;
    public final LinearLayout noticeWithDescriptionButton;
    public final TextView noticeWithDescriptionDescription;
    public final TextView noticeWithDescriptionTitle;
    public final LinearLayout noticeWithoutDescriptionButton;
    public final TextView noticeWithoutDescriptionButtonTitle;
    public final Guideline notificationMessageGuideline;
    public final LinearLayout oldMoney;
    public final View overlay;
    public final HudElementPaydayBinding paydayElement;
    public final HudElementPiratesBinding pirates;
    public final LinearLayout playersVariant;
    public final HudElementPromoBinding promo;
    public final HudRadarScreenBinding radar;
    public final Guideline rightQuestButtonLine;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rouletteContainer;
    public final ImageView rouletteIc;
    public final TextView rouletteText;
    public final TextView rouletteTime;
    public final ConstraintLayout rouletteTimeContainer;
    public final HudTargetPlatePageBinding targetPlate;
    public final Guideline taximeterTopLine;
    public final TextView textInteraction;
    public final HudElementTimeBinding timeElement;
    public final HudTimerBinding timer;
    public final Guideline topGuideline;
    public final Guideline topQuestButtonLine;
    public final TextView tvMessageCount;
    public final FrameLayout unreadMeassageContainer;
    public final ConstraintLayout vipContainer;
    public final TextView vipDays;
    public final TextView vipTitle;
    public final HudWalkieTalkieBinding walkieTalkie;
    public final Guideline warningNoticeTopLine;

    private HudPageBinding(ConstraintLayout rootView, ConstraintLayout actionButton, ImageView actionButtonIc, TextView actionButtonTxt, LinearLayout actionNoticeWithDescriptionButton, ConstraintLayout actionNoticeWithDescriptionButtonClick, TextView actionNoticeWithDescriptionButtonText, TextView actionNoticeWithDescriptionDescription, TextView actionNoticeWithDescriptionTitle, LinearLayout actionNoticeWithoutDescriptionButton, ConstraintLayout actionNoticeWithoutDescriptionButtonClick, TextView actionNoticeWithoutDescriptionButtonText, TextView actionNoticeWithoutDescriptionButtonTitle, BannerElementBinding banner, FrameLayout bgForLocation, HudBodycamBinding bodycam, Guideline botGuideline, Guideline bottomQuestButtonLine, LinearLayout buttonsContainer, HudCaptBinding capt, HudElementCasesTimerBinding casesTimer, HudElementChickenChargeBinding chargeChiken, HudElementChickenGameBinding chickenGame, HudElementDamageInformerBinding damageInformer, HudDriftCounterBinding driftCounter, HudFactionCaptureBinding factionCapture, HudFootballBinding football, HudGathersCountBinding gatherCount, LinearLayout groupButton, RecyclerView groupRv, Guideline halfHudeGuideline, ConstraintLayout hideAll, LinearLayout hudButtonsContainer, ConstraintLayout hudContainer, ConstraintLayout hudDonateButton, AppCompatImageView hudDonateButtonIcon, LinearLayout hudInfoContainer, TextView hudInfoIdIcon, TextView hudInfoIdValue, TextView hudInfoMoneyValue, ImageView hudInfoPersonIcon, TextView hudInfoPersonValue, ConstraintLayout hudInventoryButton, AppCompatImageView hudInventoryButtonIcon, RodinaKaptScreenBinding hudKaptScreen, ConstraintLayout hudMenuButton, AppCompatImageView hudMenuButtonIcon, ImageView hudMoneyIcon, ConstraintLayout hudPage, ConstraintLayout hudPhoneButton, AppCompatImageView hudPhoneButtonIcon, HudProgressBarContainerBinding hudProgressBarLayout, HudProposalScreenBinding hudProposalScreen, ConstraintLayout hudServerInfoContainer, ConstraintLayout hudServerInfoMultiply, TextView hudServerInfoMultiplyValue, ConstraintLayout hudServerShieldContainer, AppCompatImageView hudServerShieldLogo, TextView hudServerShieldName, TextView hudServerShieldSite, ConstraintLayout hudStreamerButton, AppCompatImageView hudStreamerButtonIcon, HudTaximeterBinding hudTaximeterLayout, HudTrainJobBinding hudTrainJob, ImageView imageButtonInteraction, HudElementImposterGameBinding imposterGame, HudImprovingSkillsBinding improvingSkills, LinearLayout interactionButtonContainer, HudLeftMenuBinding leftMenu, Guideline leftQuestButtonLine, TextView locationCity, LinearLayout locationContainer, TextView locationText, AvatarView messageAvatar, TextView messageName, RelativeLayout messageNotificationContainer, TextView messageText, Guideline middleButtonLine, Guideline missionProgressBottomLine, LinearLayout missionProgressContainer, Guideline missionProgressGuideline, RecyclerView missionProgressList, TextView missionTitle, CardView newMessageContainer, HudElementMoneyBinding newMoney, Guideline noticeTopLine, HudNoticeWarningBinding noticeWarning, LinearLayout noticeWithDescriptionButton, TextView noticeWithDescriptionDescription, TextView noticeWithDescriptionTitle, LinearLayout noticeWithoutDescriptionButton, TextView noticeWithoutDescriptionButtonTitle, Guideline notificationMessageGuideline, LinearLayout oldMoney, View overlay, HudElementPaydayBinding paydayElement, HudElementPiratesBinding pirates, LinearLayout playersVariant, HudElementPromoBinding promo, HudRadarScreenBinding radar, Guideline rightQuestButtonLine, ConstraintLayout rouletteContainer, ImageView rouletteIc, TextView rouletteText, TextView rouletteTime, ConstraintLayout rouletteTimeContainer, HudTargetPlatePageBinding targetPlate, Guideline taximeterTopLine, TextView textInteraction, HudElementTimeBinding timeElement, HudTimerBinding timer, Guideline topGuideline, Guideline topQuestButtonLine, TextView tvMessageCount, FrameLayout unreadMeassageContainer, ConstraintLayout vipContainer, TextView vipDays, TextView vipTitle, HudWalkieTalkieBinding walkieTalkie, Guideline warningNoticeTopLine) {
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
        this.bodycam = bodycam;
        this.botGuideline = botGuideline;
        this.bottomQuestButtonLine = bottomQuestButtonLine;
        this.buttonsContainer = buttonsContainer;
        this.capt = capt;
        this.casesTimer = casesTimer;
        this.chargeChiken = chargeChiken;
        this.chickenGame = chickenGame;
        this.damageInformer = damageInformer;
        this.driftCounter = driftCounter;
        this.factionCapture = factionCapture;
        this.football = football;
        this.gatherCount = gatherCount;
        this.groupButton = groupButton;
        this.groupRv = groupRv;
        this.halfHudeGuideline = halfHudeGuideline;
        this.hideAll = hideAll;
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
        this.hudTrainJob = hudTrainJob;
        this.imageButtonInteraction = imageButtonInteraction;
        this.imposterGame = imposterGame;
        this.improvingSkills = improvingSkills;
        this.interactionButtonContainer = interactionButtonContainer;
        this.leftMenu = leftMenu;
        this.leftQuestButtonLine = leftQuestButtonLine;
        this.locationCity = locationCity;
        this.locationContainer = locationContainer;
        this.locationText = locationText;
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
        this.newMoney = newMoney;
        this.noticeTopLine = noticeTopLine;
        this.noticeWarning = noticeWarning;
        this.noticeWithDescriptionButton = noticeWithDescriptionButton;
        this.noticeWithDescriptionDescription = noticeWithDescriptionDescription;
        this.noticeWithDescriptionTitle = noticeWithDescriptionTitle;
        this.noticeWithoutDescriptionButton = noticeWithoutDescriptionButton;
        this.noticeWithoutDescriptionButtonTitle = noticeWithoutDescriptionButtonTitle;
        this.notificationMessageGuideline = notificationMessageGuideline;
        this.oldMoney = oldMoney;
        this.overlay = overlay;
        this.paydayElement = paydayElement;
        this.pirates = pirates;
        this.playersVariant = playersVariant;
        this.promo = promo;
        this.radar = radar;
        this.rightQuestButtonLine = rightQuestButtonLine;
        this.rouletteContainer = rouletteContainer;
        this.rouletteIc = rouletteIc;
        this.rouletteText = rouletteText;
        this.rouletteTime = rouletteTime;
        this.rouletteTimeContainer = rouletteTimeContainer;
        this.targetPlate = targetPlate;
        this.taximeterTopLine = taximeterTopLine;
        this.textInteraction = textInteraction;
        this.timeElement = timeElement;
        this.timer = timer;
        this.topGuideline = topGuideline;
        this.topQuestButtonLine = topQuestButtonLine;
        this.tvMessageCount = tvMessageCount;
        this.unreadMeassageContainer = unreadMeassageContainer;
        this.vipContainer = vipContainer;
        this.vipDays = vipDays;
        this.vipTitle = vipTitle;
        this.walkieTalkie = walkieTalkie;
        this.warningNoticeTopLine = warningNoticeTopLine;
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

    public static HudPageBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        View findChildViewById6;
        View findChildViewById7;
        View findChildViewById8;
        View findChildViewById9;
        View findChildViewById10;
        View findChildViewById11;
        View findChildViewById12;
        View findChildViewById13;
        View findChildViewById14;
        View findChildViewById15;
        View findChildViewById16;
        int i = R.id.action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.action_button_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.action_button_txt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.action_notice_with_description_button;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.action_notice_with_description_button_click;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.action_notice_with_description_button_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.action_notice_with_description_description;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.action_notice_with_description_title;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.action_notice_without_description_button;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.action_notice_without_description_button_click;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.action_notice_without_description_button_text;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.action_notice_without_description_button_title;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView6 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.banner))) != null) {
                                                        BannerElementBinding bind = BannerElementBinding.bind(findChildViewById);
                                                        i = R.id.bg_for_location;
                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (frameLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.bodycam))) != null) {
                                                            HudBodycamBinding bind2 = HudBodycamBinding.bind(findChildViewById2);
                                                            i = R.id.botGuideline;
                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline != null) {
                                                                i = R.id.bottom_quest_button_line;
                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline2 != null) {
                                                                    i = R.id.buttons_container;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout3 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.capt))) != null) {
                                                                        HudCaptBinding bind3 = HudCaptBinding.bind(findChildViewById3);
                                                                        i = R.id.cases_timer;
                                                                        View findChildViewById17 = ViewBindings.findChildViewById(rootView, i);
                                                                        if (findChildViewById17 != null) {
                                                                            HudElementCasesTimerBinding bind4 = HudElementCasesTimerBinding.bind(findChildViewById17);
                                                                            i = R.id.charge_chiken;
                                                                            View findChildViewById18 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById18 != null) {
                                                                                HudElementChickenChargeBinding bind5 = HudElementChickenChargeBinding.bind(findChildViewById18);
                                                                                i = R.id.chicken_game;
                                                                                View findChildViewById19 = ViewBindings.findChildViewById(rootView, i);
                                                                                if (findChildViewById19 != null) {
                                                                                    HudElementChickenGameBinding bind6 = HudElementChickenGameBinding.bind(findChildViewById19);
                                                                                    i = R.id.damage_informer;
                                                                                    View findChildViewById20 = ViewBindings.findChildViewById(rootView, i);
                                                                                    if (findChildViewById20 != null) {
                                                                                        HudElementDamageInformerBinding bind7 = HudElementDamageInformerBinding.bind(findChildViewById20);
                                                                                        i = R.id.drift_counter;
                                                                                        View findChildViewById21 = ViewBindings.findChildViewById(rootView, i);
                                                                                        if (findChildViewById21 != null) {
                                                                                            HudDriftCounterBinding bind8 = HudDriftCounterBinding.bind(findChildViewById21);
                                                                                            i = R.id.faction_capture;
                                                                                            View findChildViewById22 = ViewBindings.findChildViewById(rootView, i);
                                                                                            if (findChildViewById22 != null) {
                                                                                                HudFactionCaptureBinding bind9 = HudFactionCaptureBinding.bind(findChildViewById22);
                                                                                                i = R.id.football;
                                                                                                View findChildViewById23 = ViewBindings.findChildViewById(rootView, i);
                                                                                                if (findChildViewById23 != null) {
                                                                                                    HudFootballBinding bind10 = HudFootballBinding.bind(findChildViewById23);
                                                                                                    i = R.id.gather_count;
                                                                                                    View findChildViewById24 = ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (findChildViewById24 != null) {
                                                                                                        HudGathersCountBinding bind11 = HudGathersCountBinding.bind(findChildViewById24);
                                                                                                        i = R.id.group_button;
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i = R.id.group_rv;
                                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (recyclerView != null) {
                                                                                                                i = R.id.half_hude_guideline;
                                                                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (guideline3 != null) {
                                                                                                                    i = R.id.hide_all;
                                                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (constraintLayout4 != null) {
                                                                                                                        i = R.id.hud_buttons_container;
                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (linearLayout5 != null) {
                                                                                                                            i = R.id.hud_container;
                                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (constraintLayout5 != null) {
                                                                                                                                i = R.id.hud_donate_button;
                                                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (constraintLayout6 != null) {
                                                                                                                                    i = R.id.hud_donate_button_icon;
                                                                                                                                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (appCompatImageView != null) {
                                                                                                                                        i = R.id.hud_info_container;
                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                            i = R.id.hud_info_id_icon;
                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (textView7 != null) {
                                                                                                                                                i = R.id.hud_info_id_value;
                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (textView8 != null) {
                                                                                                                                                    i = R.id.hud_info_money_value;
                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                        i = R.id.hud_info_person_icon;
                                                                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (imageView2 != null) {
                                                                                                                                                            i = R.id.hud_info_person_value;
                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                i = R.id.hud_inventory_button;
                                                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                                                    i = R.id.hud_inventory_button_icon;
                                                                                                                                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (appCompatImageView2 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.hud_kapt_screen))) != null) {
                                                                                                                                                                        RodinaKaptScreenBinding bind12 = RodinaKaptScreenBinding.bind(findChildViewById4);
                                                                                                                                                                        i = R.id.hud_menu_button;
                                                                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                                                                            i = R.id.hud_menu_button_icon;
                                                                                                                                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (appCompatImageView3 != null) {
                                                                                                                                                                                i = R.id.hud_money_icon;
                                                                                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (imageView3 != null) {
                                                                                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) rootView;
                                                                                                                                                                                    i = R.id.hud_phone_button;
                                                                                                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                    if (constraintLayout10 != null) {
                                                                                                                                                                                        i = R.id.hud_phone_button_icon;
                                                                                                                                                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                        if (appCompatImageView4 != null && (findChildViewById5 = ViewBindings.findChildViewById(rootView, (i = R.id.hud_progress_bar_layout))) != null) {
                                                                                                                                                                                            HudProgressBarContainerBinding bind13 = HudProgressBarContainerBinding.bind(findChildViewById5);
                                                                                                                                                                                            i = R.id.hud_proposal_screen;
                                                                                                                                                                                            View findChildViewById25 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                            if (findChildViewById25 != null) {
                                                                                                                                                                                                HudProposalScreenBinding bind14 = HudProposalScreenBinding.bind(findChildViewById25);
                                                                                                                                                                                                i = R.id.hud_server_info_container;
                                                                                                                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                if (constraintLayout11 != null) {
                                                                                                                                                                                                    i = R.id.hud_server_info_multiply;
                                                                                                                                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                    if (constraintLayout12 != null) {
                                                                                                                                                                                                        i = R.id.hud_server_info_multiply_value;
                                                                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                                                            i = R.id.hud_server_shield_container;
                                                                                                                                                                                                            ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                            if (constraintLayout13 != null) {
                                                                                                                                                                                                                i = R.id.hud_server_shield_logo;
                                                                                                                                                                                                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                if (appCompatImageView5 != null) {
                                                                                                                                                                                                                    i = R.id.hud_server_shield_name;
                                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                                        i = R.id.hud_server_shield_site;
                                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                            i = R.id.hud_streamer_button;
                                                                                                                                                                                                                            ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                            if (constraintLayout14 != null) {
                                                                                                                                                                                                                                i = R.id.hud_streamer_button_icon;
                                                                                                                                                                                                                                AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                if (appCompatImageView6 != null && (findChildViewById6 = ViewBindings.findChildViewById(rootView, (i = R.id.hud_taximeter_layout))) != null) {
                                                                                                                                                                                                                                    HudTaximeterBinding bind15 = HudTaximeterBinding.bind(findChildViewById6);
                                                                                                                                                                                                                                    i = R.id.hud_train_job;
                                                                                                                                                                                                                                    View findChildViewById26 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                    if (findChildViewById26 != null) {
                                                                                                                                                                                                                                        HudTrainJobBinding bind16 = HudTrainJobBinding.bind(findChildViewById26);
                                                                                                                                                                                                                                        i = R.id.image_button_interaction;
                                                                                                                                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                        if (imageView4 != null && (findChildViewById7 = ViewBindings.findChildViewById(rootView, (i = R.id.imposter_game))) != null) {
                                                                                                                                                                                                                                            HudElementImposterGameBinding bind17 = HudElementImposterGameBinding.bind(findChildViewById7);
                                                                                                                                                                                                                                            i = R.id.improving_skills;
                                                                                                                                                                                                                                            View findChildViewById27 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                            if (findChildViewById27 != null) {
                                                                                                                                                                                                                                                HudImprovingSkillsBinding bind18 = HudImprovingSkillsBinding.bind(findChildViewById27);
                                                                                                                                                                                                                                                i = R.id.interaction_button_container;
                                                                                                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                if (linearLayout7 != null && (findChildViewById8 = ViewBindings.findChildViewById(rootView, (i = R.id.left_menu))) != null) {
                                                                                                                                                                                                                                                    HudLeftMenuBinding bind19 = HudLeftMenuBinding.bind(findChildViewById8);
                                                                                                                                                                                                                                                    i = R.id.left_quest_button_line;
                                                                                                                                                                                                                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                    if (guideline4 != null) {
                                                                                                                                                                                                                                                        i = R.id.location_city;
                                                                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                                                                            i = R.id.location_container;
                                                                                                                                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                                                                                                                                i = R.id.location_text;
                                                                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                                                                    i = R.id.message_avatar;
                                                                                                                                                                                                                                                                    AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                    if (avatarView != null) {
                                                                                                                                                                                                                                                                        i = R.id.message_name;
                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                            i = R.id.message_notification_container;
                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                            if (relativeLayout != null) {
                                                                                                                                                                                                                                                                                i = R.id.message_text;
                                                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.middle_button_line;
                                                                                                                                                                                                                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                    if (guideline5 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.mission_progress_bottom_line;
                                                                                                                                                                                                                                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                        if (guideline6 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.mission_progress_container;
                                                                                                                                                                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.mission_progress_guideline;
                                                                                                                                                                                                                                                                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                if (guideline7 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.mission_progress_list;
                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.mission_title;
                                                                                                                                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.new_message_container;
                                                                                                                                                                                                                                                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                            if (cardView != null && (findChildViewById9 = ViewBindings.findChildViewById(rootView, (i = R.id.new_money))) != null) {
                                                                                                                                                                                                                                                                                                                HudElementMoneyBinding bind20 = HudElementMoneyBinding.bind(findChildViewById9);
                                                                                                                                                                                                                                                                                                                i = R.id.notice_top_line;
                                                                                                                                                                                                                                                                                                                Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                if (guideline8 != null && (findChildViewById10 = ViewBindings.findChildViewById(rootView, (i = R.id.notice_warning))) != null) {
                                                                                                                                                                                                                                                                                                                    HudNoticeWarningBinding bind21 = HudNoticeWarningBinding.bind(findChildViewById10);
                                                                                                                                                                                                                                                                                                                    i = R.id.notice_with_description_button;
                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.notice_with_description_description;
                                                                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.notice_with_description_title;
                                                                                                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.notice_without_description_button;
                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.notice_without_description_button_title;
                                                                                                                                                                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.notification_message_guideline;
                                                                                                                                                                                                                                                                                                                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                        if (guideline9 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.old_money;
                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                            if (linearLayout12 != null && (findChildViewById11 = ViewBindings.findChildViewById(rootView, (i = R.id.overlay))) != null && (findChildViewById12 = ViewBindings.findChildViewById(rootView, (i = R.id.payday_element))) != null) {
                                                                                                                                                                                                                                                                                                                                                HudElementPaydayBinding bind22 = HudElementPaydayBinding.bind(findChildViewById12);
                                                                                                                                                                                                                                                                                                                                                i = R.id.pirates;
                                                                                                                                                                                                                                                                                                                                                View findChildViewById28 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                if (findChildViewById28 != null) {
                                                                                                                                                                                                                                                                                                                                                    HudElementPiratesBinding bind23 = HudElementPiratesBinding.bind(findChildViewById28);
                                                                                                                                                                                                                                                                                                                                                    i = R.id.players_variant;
                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                    if (linearLayout13 != null && (findChildViewById13 = ViewBindings.findChildViewById(rootView, (i = R.id.promo))) != null) {
                                                                                                                                                                                                                                                                                                                                                        HudElementPromoBinding bind24 = HudElementPromoBinding.bind(findChildViewById13);
                                                                                                                                                                                                                                                                                                                                                        i = R.id.radar;
                                                                                                                                                                                                                                                                                                                                                        View findChildViewById29 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                        if (findChildViewById29 != null) {
                                                                                                                                                                                                                                                                                                                                                            HudRadarScreenBinding bind25 = HudRadarScreenBinding.bind(findChildViewById29);
                                                                                                                                                                                                                                                                                                                                                            i = R.id.right_quest_button_line;
                                                                                                                                                                                                                                                                                                                                                            Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                            if (guideline10 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.roulette_container;
                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.roulette_ic;
                                                                                                                                                                                                                                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.roulette_text;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.roulette_time;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.roulette_time_container;
                                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout16 != null && (findChildViewById14 = ViewBindings.findChildViewById(rootView, (i = R.id.target_plate))) != null) {
                                                                                                                                                                                                                                                                                                                                                                                    HudTargetPlatePageBinding bind26 = HudTargetPlatePageBinding.bind(findChildViewById14);
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.taximeter_top_line;
                                                                                                                                                                                                                                                                                                                                                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                    if (guideline11 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.text_interaction;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView24 != null && (findChildViewById15 = ViewBindings.findChildViewById(rootView, (i = R.id.time_element))) != null) {
                                                                                                                                                                                                                                                                                                                                                                                            HudElementTimeBinding bind27 = HudElementTimeBinding.bind(findChildViewById15);
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timer;
                                                                                                                                                                                                                                                                                                                                                                                            View findChildViewById30 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                            if (findChildViewById30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                HudTimerBinding bind28 = HudTimerBinding.bind(findChildViewById30);
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.topGuideline;
                                                                                                                                                                                                                                                                                                                                                                                                Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                if (guideline12 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.top_quest_button_line;
                                                                                                                                                                                                                                                                                                                                                                                                    Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                    if (guideline13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.tv_message_count;
                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.unread_meassage_container;
                                                                                                                                                                                                                                                                                                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                            if (frameLayout2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.vip_container;
                                                                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.vip_days;
                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.vip_title;
                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView27 != null && (findChildViewById16 = ViewBindings.findChildViewById(rootView, (i = R.id.walkie_talkie))) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            HudWalkieTalkieBinding bind29 = HudWalkieTalkieBinding.bind(findChildViewById16);
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.warning_notice_top_line;
                                                                                                                                                                                                                                                                                                                                                                                                                            Guideline guideline14 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (guideline14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                return new HudPageBinding(constraintLayout9, constraintLayout, imageView, textView, linearLayout, constraintLayout2, textView2, textView3, textView4, linearLayout2, constraintLayout3, textView5, textView6, bind, frameLayout, bind2, guideline, guideline2, linearLayout3, bind3, bind4, bind5, bind6, bind7, bind8, bind9, bind10, bind11, linearLayout4, recyclerView, guideline3, constraintLayout4, linearLayout5, constraintLayout5, constraintLayout6, appCompatImageView, linearLayout6, textView7, textView8, textView9, imageView2, textView10, constraintLayout7, appCompatImageView2, bind12, constraintLayout8, appCompatImageView3, imageView3, constraintLayout9, constraintLayout10, appCompatImageView4, bind13, bind14, constraintLayout11, constraintLayout12, textView11, constraintLayout13, appCompatImageView5, textView12, textView13, constraintLayout14, appCompatImageView6, bind15, bind16, imageView4, bind17, bind18, linearLayout7, bind19, guideline4, textView14, linearLayout8, textView15, avatarView, textView16, relativeLayout, textView17, guideline5, guideline6, linearLayout9, guideline7, recyclerView2, textView18, cardView, bind20, guideline8, bind21, linearLayout10, textView19, textView20, linearLayout11, textView21, guideline9, linearLayout12, findChildViewById11, bind22, bind23, linearLayout13, bind24, bind25, guideline10, constraintLayout15, imageView5, textView22, textView23, constraintLayout16, bind26, guideline11, textView24, bind27, bind28, guideline12, guideline13, textView25, frameLayout2, constraintLayout17, textView26, textView27, bind29, guideline14);
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
