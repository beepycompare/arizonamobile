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
import com.airbnb.lottie.LottieAnimationView;
import com.arizona.common.ui.AvatarView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
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
    public final LinearLayout overlay;
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

    private HudPageBinding(ConstraintLayout rootView, ConstraintLayout actionButton, ImageView actionButtonIc, TextView actionButtonTxt, LinearLayout actionNoticeWithDescriptionButton, ConstraintLayout actionNoticeWithDescriptionButtonClick, TextView actionNoticeWithDescriptionButtonText, TextView actionNoticeWithDescriptionDescription, TextView actionNoticeWithDescriptionTitle, LinearLayout actionNoticeWithoutDescriptionButton, ConstraintLayout actionNoticeWithoutDescriptionButtonClick, TextView actionNoticeWithoutDescriptionButtonText, TextView actionNoticeWithoutDescriptionButtonTitle, BannerElementBinding banner, FrameLayout bgForLocation, Guideline botGuideline, Guideline bottomQuestButtonLine, LinearLayout buttonsContainer, ImageView endPointIc, LinearLayout groupButton, RecyclerView groupRv, Guideline halfHudeGuideline, LinearLayout hudButtonsContainer, ConstraintLayout hudContainer, ConstraintLayout hudDonateButton, AppCompatImageView hudDonateButtonIcon, ConstraintLayout hudInfoContainer, TextView hudInfoIdIcon, TextView hudInfoIdValue, TextView hudInfoMoneyValue, AppCompatImageView hudInfoPersonIcon, TextView hudInfoPersonValue, ConstraintLayout hudInventoryButton, AppCompatImageView hudInventoryButtonIcon, RodinaKaptScreenBinding hudKaptScreen, ConstraintLayout hudMenuButton, AppCompatImageView hudMenuButtonIcon, ImageView hudMoneyIcon, ConstraintLayout hudPage, ConstraintLayout hudPhoneButton, AppCompatImageView hudPhoneButtonIcon, HudProgressBarContainerBinding hudProgressBarLayout, HudProposalScreenBinding hudProposalScreen, ConstraintLayout hudServerInfoContainer, ConstraintLayout hudServerInfoMultiply, TextView hudServerInfoMultiplyValue, ConstraintLayout hudServerShieldContainer, AppCompatImageView hudServerShieldLogo, TextView hudServerShieldName, TextView hudServerShieldSite, ConstraintLayout hudStreamerButton, AppCompatImageView hudStreamerButtonIcon, HudTaximeterBinding hudTaximeterLayout, ImageView imageButtonInteraction, HudImprovingSkillsBinding improvingSkills, TextView income, ImageView incomeIc, Guideline incomeIcLeftLine, LinearLayout interactionButtonContainer, ImageView ivDoors, ImageView ivDoorsState, ImageView ivHorn, ImageView ivHornState, HudLeftMenuBinding leftMenu, Guideline leftQuestButtonLine, TextView locationCity, LinearLayout locationContainer, TextView locationText, TextView maxKm, AvatarView messageAvatar, TextView messageName, RelativeLayout messageNotificationContainer, TextView messageText, Guideline middleButtonLine, Guideline missionProgressBottomLine, LinearLayout missionProgressContainer, Guideline missionProgressGuideline, RecyclerView missionProgressList, TextView missionTitle, CardView newMessageContainer, Guideline noticeTopLine, LinearLayout noticeWithDescriptionButton, TextView noticeWithDescriptionDescription, TextView noticeWithDescriptionTitle, LinearLayout noticeWithoutDescriptionButton, TextView noticeWithoutDescriptionButtonTitle, Guideline notificationMessageGuideline, LinearLayout overlay, Guideline rightQuestButtonLine, ConstraintLayout rouletteContainer, ImageView rouletteIc, TextView rouletteText, TextView rouletteTime, ConstraintLayout rouletteTimeContainer, ConstraintLayout routeContainer, LottieAnimationView routeProgress, Guideline routeTopLine, TextView speedLimit, ImageView startPointIc, Guideline taximeterTopLine, TextView textInteraction, HudTimerBinding timer, ImageView timerIc, Guideline timerIcLeftLine, Guideline topGuideline, Guideline topQuestButtonLine, TextView trainCurrentTime, ConstraintLayout trainDriverContainer, ConstraintLayout trainInfoContainer, Guideline trainInfoTopLine, TextView trainMaxTime, ConstraintLayout trainSettings, TextView tvMessageCount, FrameLayout unreadMeassageContainer, ConstraintLayout vipContainer, TextView vipDays, TextView vipTitle, HudWalkieTalkieBinding walkieTalkie, ImageView warningIc, TextView warningsCount, TextView warningsCountTitle) {
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

    public static HudPageBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        View findChildViewById6;
        View findChildViewById7;
        View findChildViewById8;
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
                                                        if (frameLayout != null) {
                                                            i = R.id.botGuideline;
                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline != null) {
                                                                i = R.id.bottom_quest_button_line;
                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline2 != null) {
                                                                    i = R.id.buttons_container;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.end_point_ic;
                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (imageView2 != null) {
                                                                            i = R.id.group_button;
                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (linearLayout4 != null) {
                                                                                i = R.id.group_rv;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (recyclerView != null) {
                                                                                    i = R.id.half_hude_guideline;
                                                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (guideline3 != null) {
                                                                                        i = R.id.hud_buttons_container;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.hud_container;
                                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (constraintLayout4 != null) {
                                                                                                i = R.id.hud_donate_button;
                                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (constraintLayout5 != null) {
                                                                                                    i = R.id.hud_donate_button_icon;
                                                                                                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (appCompatImageView != null) {
                                                                                                        i = R.id.hud_info_container;
                                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (constraintLayout6 != null) {
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
                                                                                                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (appCompatImageView2 != null) {
                                                                                                                            i = R.id.hud_info_person_value;
                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = R.id.hud_inventory_button;
                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                    i = R.id.hud_inventory_button_icon;
                                                                                                                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (appCompatImageView3 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.hud_kapt_screen))) != null) {
                                                                                                                                        RodinaKaptScreenBinding bind2 = RodinaKaptScreenBinding.bind(findChildViewById2);
                                                                                                                                        i = R.id.hud_menu_button;
                                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                                            i = R.id.hud_menu_button_icon;
                                                                                                                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (appCompatImageView4 != null) {
                                                                                                                                                i = R.id.hud_money_icon;
                                                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (imageView3 != null) {
                                                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) rootView;
                                                                                                                                                    i = R.id.hud_phone_button;
                                                                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (constraintLayout10 != null) {
                                                                                                                                                        i = R.id.hud_phone_button_icon;
                                                                                                                                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (appCompatImageView5 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.hud_progress_bar_layout))) != null) {
                                                                                                                                                            HudProgressBarContainerBinding bind3 = HudProgressBarContainerBinding.bind(findChildViewById3);
                                                                                                                                                            i = R.id.hud_proposal_screen;
                                                                                                                                                            View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (findChildViewById9 != null) {
                                                                                                                                                                HudProposalScreenBinding bind4 = HudProposalScreenBinding.bind(findChildViewById9);
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
                                                                                                                                                                                AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (appCompatImageView6 != null) {
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
                                                                                                                                                                                                AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                if (appCompatImageView7 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.hud_taximeter_layout))) != null) {
                                                                                                                                                                                                    HudTaximeterBinding bind5 = HudTaximeterBinding.bind(findChildViewById4);
                                                                                                                                                                                                    i = R.id.image_button_interaction;
                                                                                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                    if (imageView4 != null && (findChildViewById5 = ViewBindings.findChildViewById(rootView, (i = R.id.improving_skills))) != null) {
                                                                                                                                                                                                        HudImprovingSkillsBinding bind6 = HudImprovingSkillsBinding.bind(findChildViewById5);
                                                                                                                                                                                                        i = R.id.income;
                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                            i = R.id.income_ic;
                                                                                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                                                                                i = R.id.income_ic_left_line;
                                                                                                                                                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                if (guideline4 != null) {
                                                                                                                                                                                                                    i = R.id.interaction_button_container;
                                                                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                                                                        i = R.id.ivDoors;
                                                                                                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                        if (imageView6 != null) {
                                                                                                                                                                                                                            i = R.id.ivDoorsState;
                                                                                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                                                                                i = R.id.ivHorn;
                                                                                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                                                                                    i = R.id.ivHornState;
                                                                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                    if (imageView9 != null && (findChildViewById6 = ViewBindings.findChildViewById(rootView, (i = R.id.left_menu))) != null) {
                                                                                                                                                                                                                                        HudLeftMenuBinding bind7 = HudLeftMenuBinding.bind(findChildViewById6);
                                                                                                                                                                                                                                        i = R.id.left_quest_button_line;
                                                                                                                                                                                                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                        if (guideline5 != null) {
                                                                                                                                                                                                                                            i = R.id.location_city;
                                                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                                                i = R.id.location_container;
                                                                                                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                                                                                                    i = R.id.location_text;
                                                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                                                        i = R.id.max_km;
                                                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                                                            i = R.id.message_avatar;
                                                                                                                                                                                                                                                            AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                            if (avatarView != null) {
                                                                                                                                                                                                                                                                i = R.id.message_name;
                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                    i = R.id.message_notification_container;
                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                                                                                                                                                        i = R.id.message_text;
                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                            i = R.id.middle_button_line;
                                                                                                                                                                                                                                                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                            if (guideline6 != null) {
                                                                                                                                                                                                                                                                                i = R.id.mission_progress_bottom_line;
                                                                                                                                                                                                                                                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                if (guideline7 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.mission_progress_container;
                                                                                                                                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.mission_progress_guideline;
                                                                                                                                                                                                                                                                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                        if (guideline8 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.mission_progress_list;
                                                                                                                                                                                                                                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.mission_title;
                                                                                                                                                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.new_message_container;
                                                                                                                                                                                                                                                                                                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                    if (cardView != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.notice_top_line;
                                                                                                                                                                                                                                                                                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                        if (guideline9 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.notice_with_description_button;
                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.notice_with_description_description;
                                                                                                                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.notice_with_description_title;
                                                                                                                                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.notice_without_description_button;
                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.notice_without_description_button_title;
                                                                                                                                                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.notification_message_guideline;
                                                                                                                                                                                                                                                                                                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                if (guideline10 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.overlay;
                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                    if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.right_quest_button_line;
                                                                                                                                                                                                                                                                                                                                        Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                        if (guideline11 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.roulette_container;
                                                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                            if (constraintLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.roulette_ic;
                                                                                                                                                                                                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.roulette_text;
                                                                                                                                                                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.roulette_time;
                                                                                                                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.roulette_time_container;
                                                                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                            if (constraintLayout16 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.route_container;
                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.route_progress;
                                                                                                                                                                                                                                                                                                                                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                    if (lottieAnimationView != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.route_top_line;
                                                                                                                                                                                                                                                                                                                                                                        Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                        if (guideline12 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.speed_limit;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.start_point_ic;
                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                if (imageView11 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.taximeter_top_line;
                                                                                                                                                                                                                                                                                                                                                                                    Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                    if (guideline13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.text_interaction;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView27 != null && (findChildViewById7 = ViewBindings.findChildViewById(rootView, (i = R.id.timer))) != null) {
                                                                                                                                                                                                                                                                                                                                                                                            HudTimerBinding bind8 = HudTimerBinding.bind(findChildViewById7);
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timer_ic;
                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.timer_ic_left_line;
                                                                                                                                                                                                                                                                                                                                                                                                Guideline guideline14 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                if (guideline14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.topGuideline;
                                                                                                                                                                                                                                                                                                                                                                                                    Guideline guideline15 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                    if (guideline15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.top_quest_button_line;
                                                                                                                                                                                                                                                                                                                                                                                                        Guideline guideline16 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                        if (guideline16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.train_current_time;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.train_driver_container;
                                                                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout18 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.train_info_container;
                                                                                                                                                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout19 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (constraintLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.train_info_top_line;
                                                                                                                                                                                                                                                                                                                                                                                                                        Guideline guideline17 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (guideline17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.train_max_time;
                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.trainSettings;
                                                                                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout20 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.tv_message_count;
                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.unread_meassage_container;
                                                                                                                                                                                                                                                                                                                                                                                                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (frameLayout2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.vip_container;
                                                                                                                                                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout21 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (constraintLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.vip_days;
                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.vip_title;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView32 != null && (findChildViewById8 = ViewBindings.findChildViewById(rootView, (i = R.id.walkie_talkie))) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        HudWalkieTalkieBinding bind9 = HudWalkieTalkieBinding.bind(findChildViewById8);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.warning_ic;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (imageView13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.warnings_count;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.warnings_count_title;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return new HudPageBinding(constraintLayout9, constraintLayout, imageView, textView, linearLayout, constraintLayout2, textView2, textView3, textView4, linearLayout2, constraintLayout3, textView5, textView6, bind, frameLayout, guideline, guideline2, linearLayout3, imageView2, linearLayout4, recyclerView, guideline3, linearLayout5, constraintLayout4, constraintLayout5, appCompatImageView, constraintLayout6, textView7, textView8, textView9, appCompatImageView2, textView10, constraintLayout7, appCompatImageView3, bind2, constraintLayout8, appCompatImageView4, imageView3, constraintLayout9, constraintLayout10, appCompatImageView5, bind3, bind4, constraintLayout11, constraintLayout12, textView11, constraintLayout13, appCompatImageView6, textView12, textView13, constraintLayout14, appCompatImageView7, bind5, imageView4, bind6, textView14, imageView5, guideline4, linearLayout6, imageView6, imageView7, imageView8, imageView9, bind7, guideline5, textView15, linearLayout7, textView16, textView17, avatarView, textView18, relativeLayout, textView19, guideline6, guideline7, linearLayout8, guideline8, recyclerView2, textView20, cardView, guideline9, linearLayout9, textView21, textView22, linearLayout10, textView23, guideline10, linearLayout11, guideline11, constraintLayout15, imageView10, textView24, textView25, constraintLayout16, constraintLayout17, lottieAnimationView, guideline12, textView26, imageView11, guideline13, textView27, bind8, imageView12, guideline14, guideline15, guideline16, textView28, constraintLayout18, constraintLayout19, guideline17, textView29, constraintLayout20, textView30, frameLayout2, constraintLayout21, textView31, textView32, bind9, imageView13, textView33, textView34);
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
