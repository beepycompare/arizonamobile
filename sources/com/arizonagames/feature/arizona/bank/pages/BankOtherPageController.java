package com.arizonagames.feature.arizona.bank.pages;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizonagames.feature.arizona.bank.BankChestInfo;
import com.arizonagames.feature.arizona.bank.BankMobileInfo;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankPropertyBalanceInfo;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.BankSendSubId;
import com.arizonagames.feature.arizona.bank.BankVehicleInfo;
import com.arizonagames.feature.arizona.bank.BankVipCardInfo;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.databinding.BankOtherBusinessChipItemBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankOtherIdChipItemBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankOtherPageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankOtherRewardsSectionBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankOtherVehicleItemBinding;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankSlidingTabIndicator;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankOtherPageController.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ~2\u00020\u0001:\u0002}~B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020*H\u0016J\b\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\bH\u0002J\u0012\u00103\u001a\u00020\b2\b\b\u0002\u00104\u001a\u000205H\u0002J\"\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010,2\u0006\u00104\u001a\u000205H\u0002J\b\u00109\u001a\u00020\bH\u0002J\u0010\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0006H\u0002J\u0014\u0010<\u001a\u000205*\u00020,2\u0006\u00104\u001a\u000205H\u0002J\u0014\u0010=\u001a\u00020>*\u00020,2\u0006\u00104\u001a\u000205H\u0002J\u0014\u0010?\u001a\u00020>*\u00020,2\u0006\u00104\u001a\u000205H\u0002J\b\u0010@\u001a\u000205H\u0002J\u0010\u0010A\u001a\u00020\b2\u0006\u00100\u001a\u00020*H\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u00100\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\u0010\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0006H\u0002J\u0010\u0010G\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0006H\u0002J\b\u0010H\u001a\u00020\bH\u0002J\u0016\u0010I\u001a\u00020\b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u001eH\u0002Jm\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010R\u001a\u00020S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010XH\u0002¢\u0006\u0002\u0010YJa\u0010Z\u001a\u00020\b2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010R\u001a\u00020S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010XH\u0002¢\u0006\u0002\u0010[J×\u0001\u0010\\\u001a\u00020\b2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u00062\b\u0010]\u001a\u0004\u0018\u00010'2\u0006\u0010^\u001a\u00020P2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020P2\u0006\u0010c\u001a\u00020P2\u0006\u0010d\u001a\u00020S2\u0006\u0010e\u001a\u00020S2\b\b\u0002\u0010f\u001a\u00020>2\b\b\u0002\u0010g\u001a\u00020>2\b\b\u0002\u0010h\u001a\u00020>2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010P2\b\b\u0002\u0010U\u001a\u00020\u00062\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010XH\u0002¢\u0006\u0002\u0010jJ \u0010k\u001a\u00020\b2\b\u0010l\u001a\u0004\u0018\u00010P2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0002J\u0010\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u000205H\u0002J\b\u0010p\u001a\u00020\bH\u0002J\u0010\u0010q\u001a\u00020\b2\u0006\u0010o\u001a\u000205H\u0002J\b\u0010r\u001a\u00020\bH\u0002J\u001e\u0010s\u001a\u00020\b2\u0006\u0010l\u001a\u00020P2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0002J\b\u0010t\u001a\u00020>H\u0002J\u0010\u0010u\u001a\u00020\b2\u0006\u0010v\u001a\u00020\u0006H\u0002J\u001a\u0010w\u001a\u00020S*\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010x\u001a\u00020yH\u0002J\u0014\u0010z\u001a\u00020\b*\u00020N2\u0006\u0010{\u001a\u00020\u0006H\u0002J\u0012\u0010|\u001a\u00020S*\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0012\u0010#\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0012\u0010$\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u007f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankOtherPageController;", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankOtherPageBinding;", "onAction", "Lkotlin/Function2;", "", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankOtherPageBinding;Lkotlin/jvm/functions/Function2;)V", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "businessTabsIndicator", "Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;", "electricTabsIndicator", "rewardsBinding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankOtherRewardsSectionBinding;", "oligarchChestViews", "Lcom/arizonagames/feature/arizona/bank/pages/BankOtherPageController$BankChestViews;", "organizationChestViews", "scope", "Lkotlinx/coroutines/CoroutineScope;", "businessIds", "", "electricIds", "selectedBusinessId", "Ljava/lang/Integer;", "selectedElectricId", "autoRequestedBusinessId", "autoRequestedElectricId", "businessBalancesById", "", "Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;", "electricBalancesById", "currentPayload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "currentChests", "Lcom/arizonagames/feature/arizona/bank/BankChestInfo;", "chestTimerJob", "Lkotlinx/coroutines/Job;", "bind", "payload", "resetState", "setupChestSection", "renderChestSection", "nowEpochSeconds", "", "renderChest", "chestViews", "chest", "restartChestTimer", "claimChest", "chestId", "remainingSeconds", "hasActiveTimer", "", "isAvailable", "currentEpochSeconds", "bindVip", "bindMobile", "bindBusinesses", "bindElectric", "selectBusiness", "id", "selectElectric", "bindClicks", "bindVehicles", "vehicles", "Lcom/arizonagames/feature/arizona/bank/BankVehicleInfo;", "bindBusinessIdList", TtmlNode.RUBY_CONTAINER, "Landroid/widget/LinearLayout;", "emptyView", "Landroid/widget/TextView;", "values", "prefix", "", "selectedId", "idLabelResId", "indicator", "onIdSelected", "Lkotlin/Function1;", "(Landroid/widget/LinearLayout;Landroid/widget/TextView;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;ILcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;Lkotlin/jvm/functions/Function1;)V", "bindIdList", "(Landroid/widget/LinearLayout;Landroid/widget/TextView;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/functions/Function1;)V", "bindSelectedPropertyState", "selectedProperty", "hintView", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "titleView", "balanceView", "percentsView", "cardMainColor", "cardSecondColor", "useBusinessChips", "decorateSelectedCard", "showPercentsView", "percentsBadgeView", "(Landroid/widget/LinearLayout;Landroid/widget/TextView;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;Landroid/widget/TextView;Lru/mrlargha/commonui/utils/ui/CustomCardView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;ZZZLandroid/widget/TextView;ILcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;Lkotlin/jvm/functions/Function1;)V", "bindPercentsBadge", "badgeView", "percents", "bindBusinessMoneyParts", "value", "hideBusinessMoneyParts", "bindElectricMoneyParts", "hideElectricMoneyParts", "bindBusinessCommissionBadge", "setupScrollProgress", "updateScrollProgress", "scrollY", "toPercentsText", "context", "Landroid/content/Context;", "setChipContainerVisibility", "visibility", "toPercentsBadgeText", "BankChestViews", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankOtherPageController implements BankPageController {
    @Deprecated
    public static final float CHEST_DISABLED_ALPHA = 0.45f;
    @Deprecated
    public static final long CHEST_TIMER_TICK_MS = 1000;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int OLIGARCH_CHEST_ID = 1;
    @Deprecated
    public static final int ORGANIZATION_CHEST_ID = 2;
    private Integer autoRequestedBusinessId;
    private Integer autoRequestedElectricId;
    private final BankOtherPageBinding binding;
    private final Map<Integer, BankPropertyBalanceInfo> businessBalancesById;
    private List<Integer> businessIds;
    private final BankSlidingTabIndicator businessTabsIndicator;
    private Job chestTimerJob;
    private List<BankChestInfo> currentChests;
    private BankScreenPayload currentPayload;
    private final Map<Integer, BankPropertyBalanceInfo> electricBalancesById;
    private List<Integer> electricIds;
    private final BankSlidingTabIndicator electricTabsIndicator;
    private final BankChestViews oligarchChestViews;
    private final Function2<Integer, BankSendSubId, Unit> onAction;
    private final BankChestViews organizationChestViews;
    private final BankPage page;
    private final BankOtherRewardsSectionBinding rewardsBinding;
    private final View root;
    private final CoroutineScope scope;
    private Integer selectedBusinessId;
    private Integer selectedElectricId;

    /* JADX WARN: Multi-variable type inference failed */
    public BankOtherPageController(BankOtherPageBinding binding, Function2<? super Integer, ? super BankSendSubId, Unit> onAction) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.binding = binding;
        this.onAction = onAction;
        this.page = BankPage.OTHER;
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.root = root;
        CustomCardView bankOtherBusinessesIndicator = binding.bankOtherBusinessesIndicator;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessesIndicator, "bankOtherBusinessesIndicator");
        this.businessTabsIndicator = new BankSlidingTabIndicator(bankOtherBusinessesIndicator);
        CustomCardView bankOtherElectricIndicator = binding.bankOtherElectricIndicator;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricIndicator, "bankOtherElectricIndicator");
        this.electricTabsIndicator = new BankSlidingTabIndicator(bankOtherElectricIndicator);
        View findViewById = binding.getRoot().findViewById(R.id.bank_other_rewards_section);
        if (findViewById != null) {
            BankOtherRewardsSectionBinding bind = BankOtherRewardsSectionBinding.bind(findViewById);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.rewardsBinding = bind;
            CustomCardView bankOtherOligarchChest = bind.bankOtherOligarchChest;
            Intrinsics.checkNotNullExpressionValue(bankOtherOligarchChest, "bankOtherOligarchChest");
            CustomCardView bankOtherOligarchChestActionButton = bind.bankOtherOligarchChestActionButton;
            Intrinsics.checkNotNullExpressionValue(bankOtherOligarchChestActionButton, "bankOtherOligarchChestActionButton");
            TextView bankOtherOligarchChestActionText = bind.bankOtherOligarchChestActionText;
            Intrinsics.checkNotNullExpressionValue(bankOtherOligarchChestActionText, "bankOtherOligarchChestActionText");
            this.oligarchChestViews = new BankChestViews(bankOtherOligarchChest, bankOtherOligarchChestActionButton, bankOtherOligarchChestActionText);
            CustomCardView bankOtherOrganizationChest = bind.bankOtherOrganizationChest;
            Intrinsics.checkNotNullExpressionValue(bankOtherOrganizationChest, "bankOtherOrganizationChest");
            CustomCardView bankOtherOrganizationChestActionButton = bind.bankOtherOrganizationChestActionButton;
            Intrinsics.checkNotNullExpressionValue(bankOtherOrganizationChestActionButton, "bankOtherOrganizationChestActionButton");
            TextView bankOtherOrganizationChestActionText = bind.bankOtherOrganizationChestActionText;
            Intrinsics.checkNotNullExpressionValue(bankOtherOrganizationChestActionText, "bankOtherOrganizationChestActionText");
            this.organizationChestViews = new BankChestViews(bankOtherOrganizationChest, bankOtherOrganizationChestActionButton, bankOtherOrganizationChestActionText);
            this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
            this.businessIds = CollectionsKt.emptyList();
            this.electricIds = CollectionsKt.emptyList();
            this.businessBalancesById = new LinkedHashMap();
            this.electricBalancesById = new LinkedHashMap();
            this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
            this.currentChests = CollectionsKt.emptyList();
            setupChestSection();
            bindClicks();
            setupScrollProgress();
            binding.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Job job = BankOtherPageController.this.chestTimerJob;
                    if (job != null) {
                        Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    CoroutineScopeKt.cancel$default(BankOtherPageController.this.scope, null, 1, null);
                }
            });
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public /* bridge */ IBackendNotifier getNotifier() {
        return super.getNotifier();
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public /* bridge */ void setVisible(boolean z, boolean z2, int i) {
        super.setVisible(z, z2, i);
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public BankPage getPage() {
        return this.page;
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public View getRoot() {
        return this.root;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f4, code lost:
        if (r7 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0127, code lost:
        if (r7.intValue() != r8) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0175, code lost:
        if (r3 != null) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ab  */
    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bind(BankScreenPayload payload) {
        boolean z;
        boolean z2;
        BankPropertyBalanceInfo selectedBusiness;
        Integer num;
        Integer num2;
        BankPropertyBalanceInfo selectedElectric;
        Integer num3;
        Intrinsics.checkNotNullParameter(payload, "payload");
        final BankOtherPageBinding bankOtherPageBinding = this.binding;
        this.currentPayload = payload;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = payload.getChests().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            BankChestInfo bankChestInfo = (BankChestInfo) next;
            if (bankChestInfo.getId() == 1 || bankChestInfo.getId() == 2) {
                arrayList.add(next);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Integer.valueOf(((BankChestInfo) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        this.currentChests = arrayList2;
        renderChestSection$default(this, 0L, 1, null);
        restartChestTimer();
        bindVip(payload);
        bindMobile(payload);
        bindVehicles(payload.getVehicles());
        List<Integer> businesses = payload.getBusinesses();
        this.businessIds = businesses;
        Integer num4 = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) businesses);
        if (num4 == null) {
            this.autoRequestedBusinessId = null;
        }
        if (num4 != null) {
            Integer num5 = this.autoRequestedBusinessId;
            int intValue = num4.intValue();
            if (num5 == null || num5.intValue() != intValue) {
                z2 = true;
                selectedBusiness = payload.getSelectedBusiness();
                selectedBusiness = (selectedBusiness == null && this.businessIds.contains(Integer.valueOf(selectedBusiness.getId()))) ? null : null;
                if (selectedBusiness != null) {
                    this.businessBalancesById.put(Integer.valueOf(selectedBusiness.getId()), selectedBusiness);
                }
                if (!z2) {
                    num = this.selectedBusinessId;
                    if (num != null) {
                        if (!Boolean.valueOf(this.businessIds.contains(Integer.valueOf(num.intValue()))).booleanValue()) {
                            num = null;
                        }
                    }
                    if (selectedBusiness != null) {
                        num = Integer.valueOf(selectedBusiness.getId());
                        this.selectedBusinessId = num;
                        bindBusinesses();
                        List<Integer> electric = payload.getElectric();
                        this.electricIds = electric;
                        num2 = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) electric);
                        if (num2 == null) {
                            this.autoRequestedElectricId = null;
                        }
                        if (num2 != null) {
                            Integer num6 = this.autoRequestedElectricId;
                            int intValue2 = num2.intValue();
                            if (num6 != null) {
                            }
                            selectedElectric = payload.getSelectedElectric();
                            selectedElectric = (selectedElectric == null && this.electricIds.contains(Integer.valueOf(selectedElectric.getId()))) ? null : null;
                            if (selectedElectric != null) {
                                this.electricBalancesById.put(Integer.valueOf(selectedElectric.getId()), selectedElectric);
                            }
                            if (!z) {
                                Integer num7 = this.selectedElectricId;
                                if (num7 != null) {
                                    num3 = Boolean.valueOf(this.electricIds.contains(Integer.valueOf(num7.intValue()))).booleanValue() ? num7 : null;
                                }
                                if (selectedElectric != null) {
                                    num3 = Integer.valueOf(selectedElectric.getId());
                                    this.selectedElectricId = num3;
                                    bindElectric();
                                    if (z2) {
                                        this.autoRequestedBusinessId = num4;
                                    }
                                    if (z) {
                                        this.autoRequestedElectricId = num2;
                                    }
                                    if (z2) {
                                        Function2<Integer, BankSendSubId, Unit> function2 = this.onAction;
                                        if (num4 == null) {
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                        function2.invoke(num4, BankSendSubId.BUSINESS_SELECT);
                                    }
                                    if (z) {
                                        Function2<Integer, BankSendSubId, Unit> function22 = this.onAction;
                                        if (num2 == null) {
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                        function22.invoke(num2, BankSendSubId.ELECTRIC_SELECT);
                                    }
                                    bankOtherPageBinding.bankOtherScroll.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            BankOtherPageController.bind$lambda$0$8(BankOtherPageController.this, bankOtherPageBinding);
                                        }
                                    });
                                }
                            }
                            num3 = num2;
                            this.selectedElectricId = num3;
                            bindElectric();
                            if (z2) {
                            }
                            if (z) {
                            }
                            if (z2) {
                            }
                            if (z) {
                            }
                            bankOtherPageBinding.bankOtherScroll.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BankOtherPageController.bind$lambda$0$8(BankOtherPageController.this, bankOtherPageBinding);
                                }
                            });
                        }
                        z = false;
                        selectedElectric = payload.getSelectedElectric();
                        if (selectedElectric == null) {
                        }
                        if (selectedElectric != null) {
                        }
                        if (!z) {
                        }
                        num3 = num2;
                        this.selectedElectricId = num3;
                        bindElectric();
                        if (z2) {
                        }
                        if (z) {
                        }
                        if (z2) {
                        }
                        if (z) {
                        }
                        bankOtherPageBinding.bankOtherScroll.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                BankOtherPageController.bind$lambda$0$8(BankOtherPageController.this, bankOtherPageBinding);
                            }
                        });
                    }
                }
                num = num4;
                this.selectedBusinessId = num;
                bindBusinesses();
                List<Integer> electric2 = payload.getElectric();
                this.electricIds = electric2;
                num2 = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) electric2);
                if (num2 == null) {
                }
                if (num2 != null) {
                }
                z = false;
                selectedElectric = payload.getSelectedElectric();
                if (selectedElectric == null) {
                }
                if (selectedElectric != null) {
                }
                if (!z) {
                }
                num3 = num2;
                this.selectedElectricId = num3;
                bindElectric();
                if (z2) {
                }
                if (z) {
                }
                if (z2) {
                }
                if (z) {
                }
                bankOtherPageBinding.bankOtherScroll.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        BankOtherPageController.bind$lambda$0$8(BankOtherPageController.this, bankOtherPageBinding);
                    }
                });
            }
        }
        z2 = false;
        selectedBusiness = payload.getSelectedBusiness();
        if (selectedBusiness == null) {
        }
        if (selectedBusiness != null) {
        }
        if (!z2) {
        }
        num = num4;
        this.selectedBusinessId = num;
        bindBusinesses();
        List<Integer> electric22 = payload.getElectric();
        this.electricIds = electric22;
        num2 = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) electric22);
        if (num2 == null) {
        }
        if (num2 != null) {
        }
        z = false;
        selectedElectric = payload.getSelectedElectric();
        if (selectedElectric == null) {
        }
        if (selectedElectric != null) {
        }
        if (!z) {
        }
        num3 = num2;
        this.selectedElectricId = num3;
        bindElectric();
        if (z2) {
        }
        if (z) {
        }
        if (z2) {
        }
        if (z) {
        }
        bankOtherPageBinding.bankOtherScroll.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BankOtherPageController.bind$lambda$0$8(BankOtherPageController.this, bankOtherPageBinding);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$8(BankOtherPageController bankOtherPageController, BankOtherPageBinding bankOtherPageBinding) {
        bankOtherPageController.updateScrollProgress(bankOtherPageBinding.bankOtherScroll.getScrollY());
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void resetState() {
        Job job = this.chestTimerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.businessIds = CollectionsKt.emptyList();
        this.electricIds = CollectionsKt.emptyList();
        this.selectedBusinessId = null;
        this.selectedElectricId = null;
        this.autoRequestedBusinessId = null;
        this.autoRequestedElectricId = null;
        this.businessBalancesById.clear();
        this.electricBalancesById.clear();
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        this.currentChests = CollectionsKt.emptyList();
        this.binding.bankOtherScroll.scrollTo(0, 0);
        bind(new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null));
    }

    private final void setupChestSection() {
        BankOtherRewardsSectionBinding bankOtherRewardsSectionBinding = this.rewardsBinding;
        bankOtherRewardsSectionBinding.bankOtherOligarchChestTitle.setText(R.string.bank_chest_oligarch_title);
        bankOtherRewardsSectionBinding.bankOtherOrganizationChestTitle.setText(R.string.bank_chest_organization_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BankOtherPageController.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankOtherPageController$BankChestViews;", "", "root", "Landroid/view/View;", "actionButton", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "actionText", "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;Lru/mrlargha/commonui/utils/ui/CustomCardView;Landroid/widget/TextView;)V", "getRoot", "()Landroid/view/View;", "getActionButton", "()Lru/mrlargha/commonui/utils/ui/CustomCardView;", "getActionText", "()Landroid/widget/TextView;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BankChestViews {
        private final CustomCardView actionButton;
        private final TextView actionText;
        private final View root;

        public static /* synthetic */ BankChestViews copy$default(BankChestViews bankChestViews, View view, CustomCardView customCardView, TextView textView, int i, Object obj) {
            if ((i & 1) != 0) {
                view = bankChestViews.root;
            }
            if ((i & 2) != 0) {
                customCardView = bankChestViews.actionButton;
            }
            if ((i & 4) != 0) {
                textView = bankChestViews.actionText;
            }
            return bankChestViews.copy(view, customCardView, textView);
        }

        public final View component1() {
            return this.root;
        }

        public final CustomCardView component2() {
            return this.actionButton;
        }

        public final TextView component3() {
            return this.actionText;
        }

        public final BankChestViews copy(View root, CustomCardView actionButton, TextView actionText) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(actionButton, "actionButton");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            return new BankChestViews(root, actionButton, actionText);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BankChestViews) {
                BankChestViews bankChestViews = (BankChestViews) obj;
                return Intrinsics.areEqual(this.root, bankChestViews.root) && Intrinsics.areEqual(this.actionButton, bankChestViews.actionButton) && Intrinsics.areEqual(this.actionText, bankChestViews.actionText);
            }
            return false;
        }

        public int hashCode() {
            return (((this.root.hashCode() * 31) + this.actionButton.hashCode()) * 31) + this.actionText.hashCode();
        }

        public String toString() {
            View view = this.root;
            CustomCardView customCardView = this.actionButton;
            return "BankChestViews(root=" + view + ", actionButton=" + customCardView + ", actionText=" + this.actionText + ")";
        }

        public BankChestViews(View root, CustomCardView actionButton, TextView actionText) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(actionButton, "actionButton");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            this.root = root;
            this.actionButton = actionButton;
            this.actionText = actionText;
        }

        public final View getRoot() {
            return this.root;
        }

        public final CustomCardView getActionButton() {
            return this.actionButton;
        }

        public final TextView getActionText() {
            return this.actionText;
        }
    }

    static /* synthetic */ void renderChestSection$default(BankOtherPageController bankOtherPageController, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = bankOtherPageController.currentEpochSeconds();
        }
        bankOtherPageController.renderChestSection(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderChestSection(long j) {
        Object obj;
        Object obj2;
        Iterator<T> it = this.currentChests.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((BankChestInfo) obj2).getId() == 1) {
                break;
            }
        }
        BankChestInfo bankChestInfo = (BankChestInfo) obj2;
        Iterator<T> it2 = this.currentChests.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((BankChestInfo) next).getId() == 2) {
                obj = next;
                break;
            }
        }
        BankChestInfo bankChestInfo2 = (BankChestInfo) obj;
        int i = 0;
        this.rewardsBinding.getRoot().setVisibility(0);
        LinearLayout linearLayout = this.rewardsBinding.bankOtherChestsContainer;
        if (bankChestInfo == null && bankChestInfo2 == null) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        renderChest(this.oligarchChestViews, bankChestInfo, j);
        renderChest(this.organizationChestViews, bankChestInfo2, j);
    }

    private final void renderChest(BankChestViews bankChestViews, BankChestInfo bankChestInfo, long j) {
        String string;
        boolean z = false;
        bankChestViews.getRoot().setVisibility(bankChestInfo == null ? 8 : 0);
        if (bankChestInfo != null) {
            long remainingSeconds = remainingSeconds(bankChestInfo, j);
            if (bankChestInfo.getError().length() == 0 && remainingSeconds == 0) {
                z = true;
            }
            TextView actionText = bankChestViews.getActionText();
            if (bankChestInfo.getError().length() > 0) {
                string = bankChestInfo.getError();
            } else if (remainingSeconds > 0) {
                string = BankOtherPageControllerKt.formatBankChestCountdown(remainingSeconds);
            } else {
                string = bankChestViews.getRoot().getContext().getString(R.string.bank_chest_claim);
            }
            actionText.setText(string);
            bankChestViews.getActionButton().changeValidate(z, 0.45f);
        }
    }

    private final void restartChestTimer() {
        Job launch$default;
        Job job = this.chestTimerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        List<BankChestInfo> list = this.currentChests;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        for (BankChestInfo bankChestInfo : list) {
            if (hasActiveTimer(bankChestInfo, currentEpochSeconds())) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BankOtherPageController$restartChestTimer$2(this, null), 3, null);
                this.chestTimerJob = launch$default;
                return;
            }
        }
    }

    private final void claimChest(int i) {
        Object obj;
        BankSendSubId bankSendSubId;
        Iterator<T> it = this.currentChests.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((BankChestInfo) obj).getId() == i) {
                break;
            }
        }
        BankChestInfo bankChestInfo = (BankChestInfo) obj;
        if (bankChestInfo != null && isAvailable(bankChestInfo, currentEpochSeconds())) {
            int id = bankChestInfo.getId();
            if (id == 1) {
                bankSendSubId = BankSendSubId.OLIGARCH_CHEST_REWARD;
            } else if (id != 2) {
                return;
            } else {
                bankSendSubId = BankSendSubId.ORGANIZATION_CHEST_REWARD;
            }
            this.onAction.invoke(Integer.valueOf(bankChestInfo.getId()), bankSendSubId);
        }
    }

    private final long remainingSeconds(BankChestInfo bankChestInfo, long j) {
        return RangesKt.coerceAtLeast(bankChestInfo.getDisabledTime() - j, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasActiveTimer(BankChestInfo bankChestInfo, long j) {
        return bankChestInfo.getError().length() == 0 && remainingSeconds(bankChestInfo, j) > 0;
    }

    private final boolean isAvailable(BankChestInfo bankChestInfo, long j) {
        return bankChestInfo.getError().length() == 0 && remainingSeconds(bankChestInfo, j) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentEpochSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    private final void bindVip(BankScreenPayload bankScreenPayload) {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        BankVipCardInfo vipCard = bankScreenPayload.getVipCard();
        CustomCardView bankOtherVipButton = bankOtherPageBinding.bankOtherVipButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherVipButton, "bankOtherVipButton");
        CustomCardView.changeValidate$default(bankOtherVipButton, vipCard != null, 0.0f, 2, null);
        if (vipCard == null) {
            return;
        }
        if (vipCard.getAvailable()) {
            bankOtherPageBinding.bankOtherVipTitle.setText(R.string.bank_other_vip_title_active);
            bankOtherPageBinding.bankOtherVipButtonText.setText(R.string.bank_other_vip_button_active);
            bankOtherPageBinding.bankOtherVipButtonCost.setVisibility(8);
            return;
        }
        bankOtherPageBinding.bankOtherVipTitle.setText(R.string.bank_other_vip_title_buy);
        bankOtherPageBinding.bankOtherVipButtonText.setText(R.string.bank_other_vip_button_buy);
        bankOtherPageBinding.bankOtherVipButtonCost.setVisibility(0);
        TextView textView = bankOtherPageBinding.bankOtherVipButtonCost;
        long buyCost = vipCard.getBuyCost();
        Context context = bankOtherPageBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(BankUiFormatterKt.toBankMoneyText(buyCost, context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r7.getAvailable() == true) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bindMobile(BankScreenPayload bankScreenPayload) {
        boolean z;
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        BankMobileInfo mobile = bankScreenPayload.getMobile();
        CustomCardView bankOtherMobileButton = bankOtherPageBinding.bankOtherMobileButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherMobileButton, "bankOtherMobileButton");
        if (mobile != null) {
            z = true;
        }
        z = false;
        CustomCardView.changeValidate$default(bankOtherMobileButton, z, 0.0f, 2, null);
        if (mobile == null) {
            return;
        }
        if (mobile.getAvailable()) {
            bankOtherPageBinding.bankOtherMobileState.setVisibility(8);
            bankOtherPageBinding.bankOtherMobileAmounts.setVisibility(0);
            bankOtherPageBinding.bankOtherMobileButton.setVisibility(0);
            TextView textView = bankOtherPageBinding.bankOtherMobileBalance;
            long balance = mobile.getBalance();
            Context context = bankOtherPageBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(BankUiFormatterKt.toBankMoneyText(balance, context));
            TextView textView2 = bankOtherPageBinding.bankOtherMobileMax;
            long max = mobile.getMax();
            Context context2 = bankOtherPageBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView2.setText(BankUiFormatterKt.toBankMoneyText(max, context2));
            bankOtherPageBinding.bankOtherMobileButtonText.setText(R.string.bank_other_mobile_replenish);
            return;
        }
        bankOtherPageBinding.bankOtherMobileState.setVisibility(0);
        bankOtherPageBinding.bankOtherMobileAmounts.setVisibility(8);
        bankOtherPageBinding.bankOtherMobileButton.setVisibility(8);
        bankOtherPageBinding.bankOtherMobileState.setText(R.string.bank_other_mobile_no_phone);
    }

    private final void bindBusinesses() {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        bankOtherPageBinding.bankOtherBusinessesCard.setVisibility(this.businessIds.isEmpty() ? 8 : 0);
        if (this.businessIds.isEmpty()) {
            this.businessTabsIndicator.hide();
            return;
        }
        Integer num = this.selectedBusinessId;
        if (num == null) {
            num = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) this.businessIds);
        }
        BankPropertyBalanceInfo bankPropertyBalanceInfo = num != null ? this.businessBalancesById.get(Integer.valueOf(num.intValue())) : null;
        LinearLayout bankOtherBusinessesContainer = bankOtherPageBinding.bankOtherBusinessesContainer;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessesContainer, "bankOtherBusinessesContainer");
        Integer num2 = num;
        TextView bankOtherBusinessesEmpty = bankOtherPageBinding.bankOtherBusinessesEmpty;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessesEmpty, "bankOtherBusinessesEmpty");
        List<Integer> list = this.businessIds;
        String string = bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_business_prefix);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView bankOtherBusinessSelectedHint = bankOtherPageBinding.bankOtherBusinessSelectedHint;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessSelectedHint, "bankOtherBusinessSelectedHint");
        CustomCardView bankOtherBusinessSelectedCard = bankOtherPageBinding.bankOtherBusinessSelectedCard;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessSelectedCard, "bankOtherBusinessSelectedCard");
        TextView bankOtherBusinessSelectedTitle = bankOtherPageBinding.bankOtherBusinessSelectedTitle;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessSelectedTitle, "bankOtherBusinessSelectedTitle");
        TextView bankOtherBusinessSelectedBalance = bankOtherPageBinding.bankOtherBusinessSelectedBalance;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessSelectedBalance, "bankOtherBusinessSelectedBalance");
        TextView bankOtherBusinessSelectedPercents = bankOtherPageBinding.bankOtherBusinessSelectedPercents;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessSelectedPercents, "bankOtherBusinessSelectedPercents");
        bindSelectedPropertyState$default(this, bankOtherBusinessesContainer, bankOtherBusinessesEmpty, list, string, num2, bankPropertyBalanceInfo, bankOtherBusinessSelectedHint, bankOtherBusinessSelectedCard, bankOtherBusinessSelectedTitle, bankOtherBusinessSelectedBalance, bankOtherBusinessSelectedPercents, "#29436B", "#3E699E", true, false, false, bankOtherPageBinding.bankOtherBusinessWithdrawCommission, 0, this.businessTabsIndicator, new BankOtherPageController$bindBusinesses$1$1(this), 131072, null);
        if (this.businessIds.isEmpty()) {
            return;
        }
        bankOtherPageBinding.bankOtherBusinessSelectedHint.setVisibility(8);
        bankOtherPageBinding.bankOtherBusinessSelectedCard.setVisibility(0);
        bankOtherPageBinding.bankOtherBusinessSelectedTitle.setText(bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_id_label, bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_business_prefix), Integer.valueOf(num2 != null ? num2.intValue() : ((Number) CollectionsKt.first((List<? extends Object>) this.businessIds)).intValue())));
        if (bankPropertyBalanceInfo == null) {
            hideBusinessMoneyParts();
            bankOtherPageBinding.bankOtherBusinessWithdrawCommission.setVisibility(8);
            return;
        }
        bindBusinessMoneyParts(bankPropertyBalanceInfo.getMoney());
        TextView bankOtherBusinessWithdrawCommission = bankOtherPageBinding.bankOtherBusinessWithdrawCommission;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessWithdrawCommission, "bankOtherBusinessWithdrawCommission");
        bindBusinessCommissionBadge(bankOtherBusinessWithdrawCommission, bankPropertyBalanceInfo.getPercents());
    }

    private final void bindElectric() {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        bankOtherPageBinding.bankOtherElectricCard.setVisibility(this.electricIds.isEmpty() ? 8 : 0);
        if (this.electricIds.isEmpty()) {
            this.electricTabsIndicator.hide();
            return;
        }
        Integer num = this.selectedElectricId;
        if (num == null) {
            num = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) this.electricIds);
        }
        BankPropertyBalanceInfo bankPropertyBalanceInfo = num != null ? this.electricBalancesById.get(Integer.valueOf(num.intValue())) : null;
        LinearLayout bankOtherElectricContainer = bankOtherPageBinding.bankOtherElectricContainer;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricContainer, "bankOtherElectricContainer");
        Integer num2 = num;
        TextView bankOtherElectricEmpty = bankOtherPageBinding.bankOtherElectricEmpty;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricEmpty, "bankOtherElectricEmpty");
        List<Integer> list = this.electricIds;
        String string = bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_electric_prefix);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView bankOtherElectricSelectedHint = bankOtherPageBinding.bankOtherElectricSelectedHint;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricSelectedHint, "bankOtherElectricSelectedHint");
        CustomCardView bankOtherElectricSelectedCard = bankOtherPageBinding.bankOtherElectricSelectedCard;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricSelectedCard, "bankOtherElectricSelectedCard");
        TextView bankOtherElectricSelectedTitle = bankOtherPageBinding.bankOtherElectricSelectedTitle;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricSelectedTitle, "bankOtherElectricSelectedTitle");
        TextView bankOtherElectricSelectedBalance = bankOtherPageBinding.bankOtherElectricSelectedBalance;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricSelectedBalance, "bankOtherElectricSelectedBalance");
        TextView bankOtherElectricSelectedPercents = bankOtherPageBinding.bankOtherElectricSelectedPercents;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricSelectedPercents, "bankOtherElectricSelectedPercents");
        bindSelectedPropertyState$default(this, bankOtherElectricContainer, bankOtherElectricEmpty, list, string, num2, bankPropertyBalanceInfo, bankOtherElectricSelectedHint, bankOtherElectricSelectedCard, bankOtherElectricSelectedTitle, bankOtherElectricSelectedBalance, bankOtherElectricSelectedPercents, "#255C56", "#39A394", true, false, false, null, R.string.bank_other_electric_id_label, this.electricTabsIndicator, new BankOtherPageController$bindElectric$1$1(this), 65536, null);
        if (this.electricIds.isEmpty()) {
            return;
        }
        bankOtherPageBinding.bankOtherElectricSelectedHint.setVisibility(8);
        bankOtherPageBinding.bankOtherElectricSelectedCard.setVisibility(0);
        bankOtherPageBinding.bankOtherElectricSelectedTitle.setText(bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_electric_id_label, bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_electric_prefix), Integer.valueOf(num2 != null ? num2.intValue() : ((Number) CollectionsKt.first((List<? extends Object>) this.electricIds)).intValue())));
        if (bankPropertyBalanceInfo == null) {
            hideElectricMoneyParts();
        } else {
            bindElectricMoneyParts(bankPropertyBalanceInfo.getMoney());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectBusiness(int i) {
        Integer num = this.selectedBusinessId;
        if (num == null || num.intValue() != i) {
            this.selectedBusinessId = Integer.valueOf(i);
            bindBusinesses();
        }
        this.onAction.invoke(Integer.valueOf(i), BankSendSubId.BUSINESS_SELECT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectElectric(int i) {
        Integer num = this.selectedElectricId;
        if (num == null || num.intValue() != i) {
            this.selectedElectricId = Integer.valueOf(i);
            bindElectric();
        }
        this.onAction.invoke(Integer.valueOf(i), BankSendSubId.ELECTRIC_SELECT);
    }

    private final void bindClicks() {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        CustomCardView bankOtherStatisticsButton = this.rewardsBinding.bankOtherStatisticsButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherStatisticsButton, "bankOtherStatisticsButton");
        BankClickAnimationKt.setAnimatedClickListener(bankOtherStatisticsButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$0;
                bindClicks$lambda$0$0 = BankOtherPageController.bindClicks$lambda$0$0(BankOtherPageController.this);
                return bindClicks$lambda$0$0;
            }
        });
        BankClickAnimationKt.setAnimatedClickListener(this.oligarchChestViews.getActionButton(), new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$1;
                bindClicks$lambda$0$1 = BankOtherPageController.bindClicks$lambda$0$1(BankOtherPageController.this);
                return bindClicks$lambda$0$1;
            }
        });
        BankClickAnimationKt.setAnimatedClickListener(this.organizationChestViews.getActionButton(), new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$2;
                bindClicks$lambda$0$2 = BankOtherPageController.bindClicks$lambda$0$2(BankOtherPageController.this);
                return bindClicks$lambda$0$2;
            }
        });
        CustomCardView bankOtherVipButton = bankOtherPageBinding.bankOtherVipButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherVipButton, "bankOtherVipButton");
        BankClickAnimationKt.setAnimatedClickListener(bankOtherVipButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$3;
                bindClicks$lambda$0$3 = BankOtherPageController.bindClicks$lambda$0$3(BankOtherPageController.this);
                return bindClicks$lambda$0$3;
            }
        });
        CustomCardView bankOtherMobileButton = bankOtherPageBinding.bankOtherMobileButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherMobileButton, "bankOtherMobileButton");
        BankClickAnimationKt.setAnimatedClickListener(bankOtherMobileButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$4;
                bindClicks$lambda$0$4 = BankOtherPageController.bindClicks$lambda$0$4(BankOtherPageController.this);
                return bindClicks$lambda$0$4;
            }
        });
        CustomCardView bankOtherBusinessWithdrawButton = bankOtherPageBinding.bankOtherBusinessWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessWithdrawButton, "bankOtherBusinessWithdrawButton");
        BankClickAnimationKt.setAnimatedClickListener(bankOtherBusinessWithdrawButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$5;
                bindClicks$lambda$0$5 = BankOtherPageController.bindClicks$lambda$0$5(BankOtherPageController.this);
                return bindClicks$lambda$0$5;
            }
        });
        CustomCardView bankOtherBusinessTopUpButton = bankOtherPageBinding.bankOtherBusinessTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessTopUpButton, "bankOtherBusinessTopUpButton");
        BankClickAnimationKt.setAnimatedClickListener(bankOtherBusinessTopUpButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$6;
                bindClicks$lambda$0$6 = BankOtherPageController.bindClicks$lambda$0$6(BankOtherPageController.this);
                return bindClicks$lambda$0$6;
            }
        });
        CustomCardView bankOtherElectricTopUpButton = bankOtherPageBinding.bankOtherElectricTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricTopUpButton, "bankOtherElectricTopUpButton");
        BankClickAnimationKt.setAnimatedClickListener(bankOtherElectricTopUpButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$7;
                bindClicks$lambda$0$7 = BankOtherPageController.bindClicks$lambda$0$7(BankOtherPageController.this);
                return bindClicks$lambda$0$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$0(BankOtherPageController bankOtherPageController) {
        bankOtherPageController.onAction.invoke(0, BankSendSubId.MAIN_STATISTICS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$1(BankOtherPageController bankOtherPageController) {
        bankOtherPageController.claimChest(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$2(BankOtherPageController bankOtherPageController) {
        bankOtherPageController.claimChest(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$3(BankOtherPageController bankOtherPageController) {
        BankVipCardInfo vipCard = bankOtherPageController.currentPayload.getVipCard();
        if (vipCard != null) {
            bankOtherPageController.onAction.invoke(0, vipCard.getAvailable() ? BankSendSubId.VIP_INFO : BankSendSubId.VIP_BUY);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$4(BankOtherPageController bankOtherPageController) {
        BankMobileInfo mobile = bankOtherPageController.currentPayload.getMobile();
        if (mobile != null && mobile.getAvailable()) {
            bankOtherPageController.onAction.invoke(0, BankSendSubId.MOBILE_TOP_UP);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$5(BankOtherPageController bankOtherPageController) {
        Integer num = bankOtherPageController.selectedBusinessId;
        if (num != null) {
            bankOtherPageController.onAction.invoke(Integer.valueOf(num.intValue()), BankSendSubId.BUSINESS_WITHDRAW);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$6(BankOtherPageController bankOtherPageController) {
        Integer num = bankOtherPageController.selectedBusinessId;
        if (num != null) {
            bankOtherPageController.onAction.invoke(Integer.valueOf(num.intValue()), BankSendSubId.BUSINESS_DEPOSIT);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$7(BankOtherPageController bankOtherPageController) {
        Integer num = bankOtherPageController.selectedElectricId;
        if (num != null) {
            bankOtherPageController.onAction.invoke(Integer.valueOf(num.intValue()), BankSendSubId.ELECTRIC_DEPOSIT);
        }
        return Unit.INSTANCE;
    }

    private final void bindVehicles(List<BankVehicleInfo> list) {
        String reason;
        String bankMoneyText;
        int i;
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        bankOtherPageBinding.bankOtherVehiclesCard.setVisibility(0);
        bankOtherPageBinding.bankOtherVehiclesEmpty.setVisibility(list.isEmpty() ? 0 : 8);
        bankOtherPageBinding.bankOtherVehiclesContainer.setVisibility(list.isEmpty() ? 8 : 0);
        bankOtherPageBinding.bankOtherVehiclesContainer.removeAllViews();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final BankVehicleInfo bankVehicleInfo = (BankVehicleInfo) obj;
            BankOtherVehicleItemBinding inflate = BankOtherVehicleItemBinding.inflate(LayoutInflater.from(bankOtherPageBinding.getRoot().getContext()), bankOtherPageBinding.bankOtherVehiclesContainer, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            if (i2 == 0) {
                ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            TextView textView = inflate.bankOtherVehicleName;
            String name = bankVehicleInfo.getName();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = name.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            textView.setText(upperCase);
            TextView textView2 = inflate.bankOtherVehicleReason;
            if (bankVehicleInfo.getStolen()) {
                reason = bankOtherPageBinding.getRoot().getContext().getString(R.string.bank_other_vehicle_stolen_reason);
            } else {
                reason = bankVehicleInfo.getReason();
            }
            Intrinsics.checkNotNull(reason);
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String upperCase2 = reason.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            textView2.setText(upperCase2);
            TextView textView3 = inflate.bankOtherVehicleCost;
            if (!bankVehicleInfo.getStolen()) {
                long cost = bankVehicleInfo.getCost();
                Context context = bankOtherPageBinding.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                bankMoneyText = BankUiFormatterKt.toBankMoneyText(cost, context);
            }
            textView3.setText(bankMoneyText);
            TextView textView4 = inflate.bankOtherVehicleBuyText;
            if (bankVehicleInfo.getStolen()) {
                i = R.string.bank_other_vehicle_find;
            } else {
                i = R.string.bank_other_vehicle_buy;
            }
            textView4.setText(i);
            if (bankVehicleInfo.getStolen()) {
                CustomCardView bankOtherVehicleBuyButton = inflate.bankOtherVehicleBuyButton;
                Intrinsics.checkNotNullExpressionValue(bankOtherVehicleBuyButton, "bankOtherVehicleBuyButton");
                CustomCardView.setBackground$default(bankOtherVehicleBuyButton, Color.parseColor("#4C7DFF"), Color.parseColor("#224BB8"), 90, null, 8, null);
                inflate.bankOtherVehicleBuyText.setTextColor(-1);
            }
            CustomCardView bankOtherVehicleBuyButton2 = inflate.bankOtherVehicleBuyButton;
            Intrinsics.checkNotNullExpressionValue(bankOtherVehicleBuyButton2, "bankOtherVehicleBuyButton");
            BankClickAnimationKt.setAnimatedClickListener(bankOtherVehicleBuyButton2, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit bindVehicles$lambda$0$0$0;
                    bindVehicles$lambda$0$0$0 = BankOtherPageController.bindVehicles$lambda$0$0$0(BankOtherPageController.this, bankVehicleInfo);
                    return bindVehicles$lambda$0$0$0;
                }
            });
            bankOtherPageBinding.bankOtherVehiclesContainer.addView(inflate.getRoot());
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindVehicles$lambda$0$0$0(BankOtherPageController bankOtherPageController, BankVehicleInfo bankVehicleInfo) {
        bankOtherPageController.onAction.invoke(Integer.valueOf(bankVehicleInfo.getId()), BankSendSubId.VEHICLE_PICK_UP);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void bindBusinessIdList$default(BankOtherPageController bankOtherPageController, LinearLayout linearLayout, TextView textView, List list, String str, Integer num, int i, BankSlidingTabIndicator bankSlidingTabIndicator, Function1 function1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        if ((i2 & 32) != 0) {
            i = R.string.bank_other_id_label;
        }
        if ((i2 & 64) != 0) {
            bankSlidingTabIndicator = null;
        }
        if ((i2 & 128) != 0) {
            function1 = null;
        }
        bankOtherPageController.bindBusinessIdList(linearLayout, textView, list, str, num, i, bankSlidingTabIndicator, function1);
    }

    private final void bindBusinessIdList(LinearLayout linearLayout, TextView textView, List<Integer> list, String str, Integer num, int i, BankSlidingTabIndicator bankSlidingTabIndicator, final Function1<? super Integer, Unit> function1) {
        String str2;
        textView.setVisibility(list.isEmpty() ? 0 : 8);
        linearLayout.setVisibility(list.isEmpty() ? 8 : 0);
        setChipContainerVisibility(linearLayout, linearLayout.getVisibility());
        linearLayout.removeAllViews();
        for (Number number : list) {
            final int intValue = number.intValue();
            BankOtherBusinessChipItemBinding inflate = BankOtherBusinessChipItemBinding.inflate(LayoutInflater.from(getRoot().getContext()), linearLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            boolean z = num != null && num.intValue() == intValue;
            inflate.bankOtherIdChipText.setText(getRoot().getContext().getString(i, str, Integer.valueOf(intValue)));
            inflate.getRoot().setBackground(-1);
            inflate.getRoot().setBackgroundAlpha(z ? 100 : 35);
            TextView textView2 = inflate.bankOtherIdChipText;
            if (z) {
                str2 = "#D91C1C1C";
            } else {
                str2 = "#991C1C1C";
            }
            textView2.setTextColor(Color.parseColor(str2));
            if (function1 == null) {
                inflate.getRoot().setClickable(false);
                inflate.getRoot().setOnClickListener(null);
            } else {
                inflate.getRoot().setClickable(true);
                inflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BankOtherPageController.bindBusinessIdList$lambda$0$0(Function1.this, intValue, view);
                    }
                });
            }
            linearLayout.addView(inflate.getRoot());
        }
        if (bankSlidingTabIndicator != null) {
            bankSlidingTabIndicator.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBusinessIdList$lambda$0$0(Function1 function1, int i, View view) {
        function1.invoke(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void bindIdList$default(BankOtherPageController bankOtherPageController, LinearLayout linearLayout, TextView textView, List list, String str, Integer num, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        if ((i2 & 32) != 0) {
            i = R.string.bank_other_id_label;
        }
        if ((i2 & 64) != 0) {
            function1 = null;
        }
        bankOtherPageController.bindIdList(linearLayout, textView, list, str, num, i, function1);
    }

    private final void bindIdList(LinearLayout linearLayout, TextView textView, List<Integer> list, String str, Integer num, int i, final Function1<? super Integer, Unit> function1) {
        String str2;
        textView.setVisibility(list.isEmpty() ? 0 : 8);
        linearLayout.setVisibility(list.isEmpty() ? 8 : 0);
        setChipContainerVisibility(linearLayout, linearLayout.getVisibility());
        linearLayout.removeAllViews();
        for (Number number : list) {
            final int intValue = number.intValue();
            BankOtherIdChipItemBinding inflate = BankOtherIdChipItemBinding.inflate(LayoutInflater.from(getRoot().getContext()), linearLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            boolean z = num != null && num.intValue() == intValue;
            inflate.bankOtherIdChipText.setText(getRoot().getContext().getString(i, str, Integer.valueOf(intValue)));
            inflate.getRoot().setBackground(z ? Color.parseColor("#FFF000") : -1);
            inflate.getRoot().setBackgroundAlpha(z ? 100 : 18);
            TextView textView2 = inflate.bankOtherIdChipText;
            if (z) {
                str2 = "#181818";
            } else {
                str2 = "#D1D7EA";
            }
            textView2.setTextColor(Color.parseColor(str2));
            if (function1 == null) {
                inflate.getRoot().setClickable(false);
                inflate.getRoot().setOnClickListener(null);
            } else {
                inflate.getRoot().setClickable(true);
                inflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BankOtherPageController.bindIdList$lambda$0$0(Function1.this, intValue, view);
                    }
                });
            }
            linearLayout.addView(inflate.getRoot());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindIdList$lambda$0$0(Function1 function1, int i, View view) {
        function1.invoke(Integer.valueOf(i));
    }

    static /* synthetic */ void bindSelectedPropertyState$default(BankOtherPageController bankOtherPageController, LinearLayout linearLayout, TextView textView, List list, String str, Integer num, BankPropertyBalanceInfo bankPropertyBalanceInfo, TextView textView2, CustomCardView customCardView, TextView textView3, TextView textView4, TextView textView5, String str2, String str3, boolean z, boolean z2, boolean z3, TextView textView6, int i, BankSlidingTabIndicator bankSlidingTabIndicator, Function1 function1, int i2, Object obj) {
        Function1 function12;
        BankOtherPageController bankOtherPageController2;
        LinearLayout linearLayout2;
        TextView textView7;
        List list2;
        String str4;
        Integer num2;
        BankPropertyBalanceInfo bankPropertyBalanceInfo2;
        TextView textView8;
        CustomCardView customCardView2;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        String str5;
        String str6;
        boolean z4 = (i2 & 8192) != 0 ? false : z;
        boolean z5 = (i2 & 16384) != 0 ? true : z2;
        boolean z6 = (32768 & i2) != 0 ? true : z3;
        TextView textView12 = (65536 & i2) != 0 ? null : textView6;
        int i3 = (131072 & i2) != 0 ? R.string.bank_other_id_label : i;
        BankSlidingTabIndicator bankSlidingTabIndicator2 = (262144 & i2) != 0 ? null : bankSlidingTabIndicator;
        if ((i2 & 524288) != 0) {
            function12 = null;
            linearLayout2 = linearLayout;
            textView7 = textView;
            list2 = list;
            str4 = str;
            num2 = num;
            bankPropertyBalanceInfo2 = bankPropertyBalanceInfo;
            textView8 = textView2;
            customCardView2 = customCardView;
            textView9 = textView3;
            textView10 = textView4;
            textView11 = textView5;
            str5 = str2;
            str6 = str3;
            bankOtherPageController2 = bankOtherPageController;
        } else {
            function12 = function1;
            bankOtherPageController2 = bankOtherPageController;
            linearLayout2 = linearLayout;
            textView7 = textView;
            list2 = list;
            str4 = str;
            num2 = num;
            bankPropertyBalanceInfo2 = bankPropertyBalanceInfo;
            textView8 = textView2;
            customCardView2 = customCardView;
            textView9 = textView3;
            textView10 = textView4;
            textView11 = textView5;
            str5 = str2;
            str6 = str3;
        }
        bankOtherPageController2.bindSelectedPropertyState(linearLayout2, textView7, list2, str4, num2, bankPropertyBalanceInfo2, textView8, customCardView2, textView9, textView10, textView11, str5, str6, z4, z5, z6, textView12, i3, bankSlidingTabIndicator2, function12);
    }

    private final void bindSelectedPropertyState(LinearLayout linearLayout, TextView textView, List<Integer> list, String str, Integer num, BankPropertyBalanceInfo bankPropertyBalanceInfo, TextView textView2, CustomCardView customCardView, TextView textView3, TextView textView4, TextView textView5, String str2, String str3, boolean z, boolean z2, boolean z3, TextView textView6, int i, BankSlidingTabIndicator bankSlidingTabIndicator, Function1<? super Integer, Unit> function1) {
        if (z) {
            bindBusinessIdList(linearLayout, textView, list, str, num, i, bankSlidingTabIndicator, function1);
        } else {
            bindIdList(linearLayout, textView, list, str, num, i, function1);
        }
        if (list.isEmpty()) {
            textView2.setVisibility(8);
            customCardView.setVisibility(8);
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        } else if (bankPropertyBalanceInfo == null) {
            textView2.setVisibility(0);
            customCardView.setVisibility(8);
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        } else {
            textView2.setVisibility(8);
            customCardView.setVisibility(0);
            if (z2) {
                CustomCardView.setBackground$default(customCardView, Color.parseColor(str2), Color.parseColor(str3), 340, null, 8, null);
                customCardView.setBackgroundAlpha(100);
            } else {
                customCardView.setBackgroundAlpha(0);
            }
            textView3.setText(getRoot().getContext().getString(i, str, Integer.valueOf(bankPropertyBalanceInfo.getId())));
            long money = bankPropertyBalanceInfo.getMoney();
            Context context = getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView4.setText(BankUiFormatterKt.toBankMoneyText(money, context));
            List<Integer> percents = bankPropertyBalanceInfo.getPercents();
            Context context2 = getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView5.setText(toPercentsText(percents, context2));
            textView5.setVisibility(z3 ? 0 : 8);
            bindPercentsBadge(textView6, bankPropertyBalanceInfo.getPercents());
        }
    }

    private final void bindPercentsBadge(TextView textView, List<Integer> list) {
        if (textView == null) {
            return;
        }
        textView.setVisibility(list.isEmpty() ? 8 : 0);
        if (list.isEmpty()) {
            return;
        }
        textView.setText(toPercentsBadgeText(list));
    }

    private final void bindBusinessMoneyParts(long j) {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        TextView bankOtherBusinessBalanceM = bankOtherPageBinding.bankOtherBusinessBalanceM;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessBalanceM, "bankOtherBusinessBalanceM");
        TextView bankOtherBusinessBalanceKk = bankOtherPageBinding.bankOtherBusinessBalanceKk;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessBalanceKk, "bankOtherBusinessBalanceKk");
        TextView bankOtherBusinessBalanceK = bankOtherPageBinding.bankOtherBusinessBalanceK;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessBalanceK, "bankOtherBusinessBalanceK");
        BankUiFormatterKt.bindBankMoneyParts(bankOtherBusinessBalanceM, bankOtherBusinessBalanceKk, bankOtherBusinessBalanceK, j);
    }

    private final void hideBusinessMoneyParts() {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        TextView bankOtherBusinessBalanceM = bankOtherPageBinding.bankOtherBusinessBalanceM;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessBalanceM, "bankOtherBusinessBalanceM");
        TextView bankOtherBusinessBalanceKk = bankOtherPageBinding.bankOtherBusinessBalanceKk;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessBalanceKk, "bankOtherBusinessBalanceKk");
        TextView bankOtherBusinessBalanceK = bankOtherPageBinding.bankOtherBusinessBalanceK;
        Intrinsics.checkNotNullExpressionValue(bankOtherBusinessBalanceK, "bankOtherBusinessBalanceK");
        BankUiFormatterKt.hideBankMoneyParts(bankOtherBusinessBalanceM, bankOtherBusinessBalanceKk, bankOtherBusinessBalanceK);
    }

    private final void bindElectricMoneyParts(long j) {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        TextView bankOtherElectricBalanceM = bankOtherPageBinding.bankOtherElectricBalanceM;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricBalanceM, "bankOtherElectricBalanceM");
        TextView bankOtherElectricBalanceKk = bankOtherPageBinding.bankOtherElectricBalanceKk;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricBalanceKk, "bankOtherElectricBalanceKk");
        TextView bankOtherElectricBalanceK = bankOtherPageBinding.bankOtherElectricBalanceK;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricBalanceK, "bankOtherElectricBalanceK");
        BankUiFormatterKt.bindBankMoneyParts(bankOtherElectricBalanceM, bankOtherElectricBalanceKk, bankOtherElectricBalanceK, j);
    }

    private final void hideElectricMoneyParts() {
        BankOtherPageBinding bankOtherPageBinding = this.binding;
        TextView bankOtherElectricBalanceM = bankOtherPageBinding.bankOtherElectricBalanceM;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricBalanceM, "bankOtherElectricBalanceM");
        TextView bankOtherElectricBalanceKk = bankOtherPageBinding.bankOtherElectricBalanceKk;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricBalanceKk, "bankOtherElectricBalanceKk");
        TextView bankOtherElectricBalanceK = bankOtherPageBinding.bankOtherElectricBalanceK;
        Intrinsics.checkNotNullExpressionValue(bankOtherElectricBalanceK, "bankOtherElectricBalanceK");
        BankUiFormatterKt.hideBankMoneyParts(bankOtherElectricBalanceM, bankOtherElectricBalanceKk, bankOtherElectricBalanceK);
    }

    private final void bindBusinessCommissionBadge(TextView textView, List<Integer> list) {
        String percentsBadgeText;
        textView.setVisibility(0);
        if (!list.isEmpty()) {
            percentsBadgeText = toPercentsBadgeText(list);
        }
        textView.setText(percentsBadgeText);
    }

    private final boolean setupScrollProgress() {
        final BankOtherPageBinding bankOtherPageBinding = this.binding;
        bankOtherPageBinding.bankOtherScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                BankOtherPageController.this.updateScrollProgress(i2);
            }
        });
        return bankOtherPageBinding.bankOtherScroll.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BankOtherPageController.setupScrollProgress$lambda$0$1(BankOtherPageController.this, bankOtherPageBinding);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupScrollProgress$lambda$0$1(BankOtherPageController bankOtherPageController, BankOtherPageBinding bankOtherPageBinding) {
        bankOtherPageController.updateScrollProgress(bankOtherPageBinding.bankOtherScroll.getScrollY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateScrollProgress(int i) {
        final BankOtherPageBinding bankOtherPageBinding = this.binding;
        View childAt = bankOtherPageBinding.bankOtherScroll.getChildAt(0);
        if (childAt == null) {
            return;
        }
        int height = childAt.getHeight() - bankOtherPageBinding.bankOtherScroll.getHeight();
        bankOtherPageBinding.bankOtherScrollProgressTrack.setVisibility(height > 0 ? 0 : 8);
        if (height <= 0) {
            return;
        }
        int height2 = bankOtherPageBinding.bankOtherScrollProgressTrack.getHeight();
        if (height2 <= 0) {
            bankOtherPageBinding.bankOtherScrollProgressTrack.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    BankOtherPageController.updateScrollProgress$lambda$0$0(BankOtherPageController.this, bankOtherPageBinding);
                }
            });
            return;
        }
        int max = Math.max(bankOtherPageBinding.getRoot().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._24sdp), (bankOtherPageBinding.bankOtherScroll.getHeight() * height2) / childAt.getHeight());
        ViewGroup.LayoutParams layoutParams = bankOtherPageBinding.bankOtherScrollProgressThumb.getLayoutParams();
        if (layoutParams.height != max) {
            layoutParams.height = max;
            bankOtherPageBinding.bankOtherScrollProgressThumb.setLayoutParams(layoutParams);
        }
        bankOtherPageBinding.bankOtherScrollProgressThumb.setTranslationY((height2 - max) * (RangesKt.coerceIn(i, 0, height) / height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateScrollProgress$lambda$0$0(BankOtherPageController bankOtherPageController, BankOtherPageBinding bankOtherPageBinding) {
        bankOtherPageController.updateScrollProgress(bankOtherPageBinding.bankOtherScroll.getScrollY());
    }

    private final String toPercentsText(List<Integer> list, Context context) {
        if (list.isEmpty()) {
            String string = context.getString(R.string.bank_other_commission_unknown);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = context.getString(R.string.bank_other_commission_format, CollectionsKt.joinToString$default(list, " / ", null, null, 0, null, new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankOtherPageController.toPercentsText$lambda$0(((Integer) obj).intValue());
            }
        }, 30, null));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toPercentsText$lambda$0(int i) {
        return i + "%";
    }

    private final void setChipContainerVisibility(LinearLayout linearLayout, int i) {
        ViewParent parent = linearLayout.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setVisibility(i);
        }
        if (view instanceof FrameLayout) {
            ViewParent parent2 = ((FrameLayout) view).getParent();
            View view2 = parent2 instanceof View ? (View) parent2 : null;
            if (view2 != null) {
                view2.setVisibility(i);
            }
        }
    }

    private final String toPercentsBadgeText(List<Integer> list) {
        return CollectionsKt.joinToString$default(list, " / ", null, null, 0, null, new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankOtherPageController.toPercentsBadgeText$lambda$0(((Integer) obj).intValue());
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toPercentsBadgeText$lambda$0(int i) {
        return i + "%";
    }

    /* compiled from: BankOtherPageController.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankOtherPageController$Companion;", "", "<init>", "()V", "OLIGARCH_CHEST_ID", "", "ORGANIZATION_CHEST_ID", "CHEST_TIMER_TICK_MS", "", "CHEST_DISABLED_ALPHA", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
