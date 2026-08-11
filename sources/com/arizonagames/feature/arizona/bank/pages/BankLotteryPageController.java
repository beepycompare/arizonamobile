package com.arizonagames.feature.arizona.bank.pages;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankContractKt;
import com.arizonagames.feature.arizona.bank.BankLotteryInfo;
import com.arizonagames.feature.arizona.bank.BankLotteryResultState;
import com.arizonagames.feature.arizona.bank.BankLotteryResultStateKt;
import com.arizonagames.feature.arizona.bank.BankLotteryRewardInfo;
import com.arizonagames.feature.arizona.bank.BankLotteryTaskInfo;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.BankSendSubId;
import com.arizonagames.feature.arizona.bank.databinding.BankLotteryPageBinding;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankSlidingTabIndicator;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.recycle_view.GridSpacingItemDecoration;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001#\b\u0000\u0018\u0000 S2\u00020\u0001:\u0001SBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u000202H\u0016J\u0014\u00103\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020+0*J\b\u00105\u001a\u00020\u000eH\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u00020(H\u0002J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020/H\u0002J\b\u0010;\u001a\u00020\u000eH\u0002J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010=\u001a\u00020\u0016H\u0002J \u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020?H\u0002J\u001a\u0010F\u001a\u00020\u000e2\u0006\u00107\u001a\u00020(2\b\b\u0002\u0010G\u001a\u00020?H\u0002J\u0010\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020\u000eH\u0002J\u0010\u0010L\u001a\u00020\u000e2\u0006\u00107\u001a\u00020(H\u0002J\u0010\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020-H\u0002J\u0010\u0010O\u001a\u00020\b2\u0006\u00107\u001a\u00020(H\u0002J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryPageController;", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "targetActivity", "Landroid/app/Activity;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankLotteryPageBinding;", "onAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "targetId", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "subId", "", "<init>", "(Landroid/app/Activity;Lcom/arizonagames/feature/arizona/bank/databinding/BankLotteryPageBinding;Lkotlin/jvm/functions/Function2;)V", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tasksAdapter", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryTasksAdapter;", "rewardsAdapter", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryRewardsAdapter;", "sectionIndicator", "Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;", "pendingSectionIndicatorTarget", "sectionIndicatorLayoutListener", "com/arizonagames/feature/arizona/bank/pages/BankLotteryPageController$sectionIndicatorLayoutListener$1", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryPageController$sectionIndicatorLayoutListener$1;", "timerJob", "Lkotlinx/coroutines/Job;", "currentLottery", "Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;", "currentPrizes", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "ticketsTimerStartedAtMs", "", "selectedSection", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotterySection;", "bind", "payload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "bindPrizes", "prizes", "resetState", "renderStatic", "lottery", "renderDynamic", "selectSection", "section", "renderSelectedSection", "moveSectionIndicator", TypedValues.AttributesType.S_TARGET, "canMoveSectionIndicator", "", "bindSectionButton", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "text", "Landroid/widget/TextView;", "selected", "renderRewards", "showWinners", "bindStreamButton", NotificationStatsPayloadFactory.KEY_PLATFORM, "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryStreamPlatform;", "bindUnavailableStreamButton", "restartTimer", "secondsUntil", "endTime", "ticketsLeftSeconds", "formatLotteryDuration", "", "seconds", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryPageController implements BankPageController {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int REWARD_SPAN_COUNT = 3;
    @Deprecated
    public static final int SECONDS_PER_DAY = 86400;
    @Deprecated
    public static final int SECONDS_PER_HOUR = 3600;
    @Deprecated
    public static final int SECONDS_PER_MINUTE = 60;
    private final BankLotteryPageBinding binding;
    private BankLotteryInfo currentLottery;
    private List<BankLotteryRewardInfo> currentPrizes;
    private final Function2<Integer, BankSendSubId, Unit> onAction;
    private final BankPage page;
    private View pendingSectionIndicatorTarget;
    private final BankLotteryRewardsAdapter rewardsAdapter;
    private final View root;
    private final CoroutineScope scope;
    private final BankSlidingTabIndicator sectionIndicator;
    private final BankLotteryPageController$sectionIndicatorLayoutListener$1 sectionIndicatorLayoutListener;
    private BankLotterySection selectedSection;
    private final Activity targetActivity;
    private final BankLotteryTasksAdapter tasksAdapter;
    private long ticketsTimerStartedAtMs;
    private Job timerJob;

    /* compiled from: BankLotteryPageController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[BankLotteryResultState.values().length];
            try {
                iArr[BankLotteryResultState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BankLotteryResultState.AWAITING_RESULTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BankLotteryResultState.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BankLotterySection.values().length];
            try {
                iArr2[BankLotterySection.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BankLotterySection.TASKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BankLotterySection.REWARDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BankLotteryStreamPlatform.values().length];
            try {
                iArr3[BankLotteryStreamPlatform.YOUTUBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[BankLotteryStreamPlatform.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[BankLotteryStreamPlatform.TWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$sectionIndicatorLayoutListener$1] */
    public BankLotteryPageController(Activity targetActivity, BankLotteryPageBinding binding, Function2<? super Integer, ? super BankSendSubId, Unit> onAction) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.onAction = onAction;
        this.page = BankPage.LOTTERY;
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.root = root;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        BankLotteryTasksAdapter bankLotteryTasksAdapter = new BankLotteryTasksAdapter(new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankLotteryPageController.tasksAdapter$lambda$0(BankLotteryPageController.this, ((Integer) obj).intValue());
            }
        });
        this.tasksAdapter = bankLotteryTasksAdapter;
        BankLotteryRewardsAdapter bankLotteryRewardsAdapter = new BankLotteryRewardsAdapter();
        this.rewardsAdapter = bankLotteryRewardsAdapter;
        CustomCardView bankLotterySectionIndicator = binding.bankLotterySectionIndicator;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionIndicator, "bankLotterySectionIndicator");
        this.sectionIndicator = new BankSlidingTabIndicator(bankLotterySectionIndicator);
        this.sectionIndicatorLayoutListener = new View.OnLayoutChangeListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$sectionIndicatorLayoutListener$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                View view2;
                boolean canMoveSectionIndicator;
                BankLotteryPageBinding bankLotteryPageBinding;
                BankSlidingTabIndicator bankSlidingTabIndicator;
                Intrinsics.checkNotNullParameter(view, "view");
                view2 = BankLotteryPageController.this.pendingSectionIndicatorTarget;
                if (view2 == null) {
                    return;
                }
                canMoveSectionIndicator = BankLotteryPageController.this.canMoveSectionIndicator(view2);
                if (canMoveSectionIndicator) {
                    bankLotteryPageBinding = BankLotteryPageController.this.binding;
                    bankLotteryPageBinding.getRoot().removeOnLayoutChangeListener(this);
                    BankLotteryPageController.this.pendingSectionIndicatorTarget = null;
                    bankSlidingTabIndicator = BankLotteryPageController.this.sectionIndicator;
                    bankSlidingTabIndicator.moveTo(view2, false);
                }
            }
        };
        this.currentPrizes = CollectionsKt.emptyList();
        this.selectedSection = BankLotterySection.HOME;
        RecyclerView recyclerView = binding.bankLotteryTasksList;
        recyclerView.setLayoutManager(new LinearLayoutManager(targetActivity, 1, false));
        recyclerView.setAdapter(bankLotteryTasksAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setHasFixedSize(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) targetActivity, 3, 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$rewardsLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                BankLotteryRewardsAdapter bankLotteryRewardsAdapter2;
                bankLotteryRewardsAdapter2 = BankLotteryPageController.this.rewardsAdapter;
                return bankLotteryRewardsAdapter2.getSpanSize(i);
            }
        });
        RecyclerView recyclerView2 = binding.bankLotteryRewardsList;
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setAdapter(bankLotteryRewardsAdapter);
        recyclerView2.setItemAnimator(null);
        recyclerView2.setHasFixedSize(false);
        recyclerView2.addItemDecoration(new GridSpacingItemDecoration(3, recyclerView2.getResources().getDimensionPixelSize(R.dimen._6sdp), false));
        binding.bankLotterySectionHome.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankLotteryPageController.this.selectSection(BankLotterySection.HOME);
            }
        });
        binding.bankLotterySectionTasks.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankLotteryPageController.this.selectSection(BankLotterySection.TASKS);
            }
        });
        binding.bankLotterySectionRewards.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankLotteryPageController.this.selectSection(BankLotterySection.REWARDS);
            }
        });
        renderSelectedSection();
        binding.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController.6
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = BankLotteryPageController.this.timerJob;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        });
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit tasksAdapter$lambda$0(BankLotteryPageController bankLotteryPageController, int i) {
        bankLotteryPageController.onAction.invoke(Integer.valueOf(i), BankSendSubId.GIVEAWAY_TASK);
        return Unit.INSTANCE;
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void bind(BankScreenPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BankLotteryInfo lottery = payload.getLottery();
        if (lottery == null || !BankContractKt.isAvailable(lottery)) {
            lottery = null;
        }
        this.currentLottery = lottery;
        this.ticketsTimerStartedAtMs = System.currentTimeMillis();
        if (lottery == null) {
            this.selectedSection = BankLotterySection.HOME;
            BankLotteryTasksAdapter.submitList$default(this.tasksAdapter, CollectionsKt.emptyList(), false, 2, null);
            this.rewardsAdapter.submitList(CollectionsKt.emptyList(), false);
            Job job = this.timerJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            renderSelectedSection();
            return;
        }
        renderStatic(lottery);
        renderDynamic(lottery);
        restartTimer(lottery);
    }

    public final void bindPrizes(List<BankLotteryRewardInfo> prizes) {
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        this.currentPrizes = prizes;
        BankLotteryInfo bankLotteryInfo = this.currentLottery;
        if (bankLotteryInfo != null) {
            renderDynamic(bankLotteryInfo);
        }
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void resetState() {
        this.currentLottery = null;
        this.currentPrizes = CollectionsKt.emptyList();
        this.ticketsTimerStartedAtMs = 0L;
        this.selectedSection = BankLotterySection.HOME;
        Job job = this.timerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        BankLotteryTasksAdapter.submitList$default(this.tasksAdapter, CollectionsKt.emptyList(), false, 2, null);
        this.rewardsAdapter.submitList(CollectionsKt.emptyList(), false);
        renderSelectedSection();
    }

    private final void renderStatic(final BankLotteryInfo bankLotteryInfo) {
        BankLotteryStreamPlatform resolveStreamPlatform;
        BankLotteryPageBinding bankLotteryPageBinding = this.binding;
        TextView textView = bankLotteryPageBinding.bankLotteryTitle;
        String title = bankLotteryInfo.getTitle();
        if (StringsKt.isBlank(title)) {
            title = this.targetActivity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_default_title);
            Intrinsics.checkNotNullExpressionValue(title, "getString(...)");
        }
        textView.setText(title);
        TextView textView2 = bankLotteryPageBinding.bankLotteryDescription;
        String desc = bankLotteryInfo.getDesc();
        if (StringsKt.isBlank(desc)) {
            desc = this.targetActivity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_default_description);
            Intrinsics.checkNotNullExpressionValue(desc, "getString(...)");
        }
        textView2.setText(desc);
        bankLotteryPageBinding.bankLotteryTicketsBalance.setText(BankUiFormatterKt.toBankPlainAmountText(bankLotteryInfo.getTicketsBalance()));
        resolveStreamPlatform = BankLotteryPageControllerKt.resolveStreamPlatform(bankLotteryInfo.getStreamUrl());
        boolean z = resolveStreamPlatform != null;
        bankLotteryPageBinding.bankLotteryStreamButton.setVisibility(0);
        CustomCardView bankLotteryStreamButton = bankLotteryPageBinding.bankLotteryStreamButton;
        Intrinsics.checkNotNullExpressionValue(bankLotteryStreamButton, "bankLotteryStreamButton");
        CustomCardView.changeValidate$default(bankLotteryStreamButton, z, 0.0f, 2, null);
        if (resolveStreamPlatform == null) {
            bindUnavailableStreamButton();
        } else {
            bindStreamButton(resolveStreamPlatform);
        }
        CustomCardView bankLotteryStreamButton2 = bankLotteryPageBinding.bankLotteryStreamButton;
        Intrinsics.checkNotNullExpressionValue(bankLotteryStreamButton2, "bankLotteryStreamButton");
        BankClickAnimationKt.setAnimatedClickListener(bankLotteryStreamButton2, z ? new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit renderStatic$lambda$0$2;
                renderStatic$lambda$0$2 = BankLotteryPageController.renderStatic$lambda$0$2(BankLotteryInfo.this, this);
                return renderStatic$lambda$0$2;
            }
        } : null);
        boolean isEmpty = bankLotteryInfo.getTasks().isEmpty();
        bankLotteryPageBinding.bankLotteryTasksEmpty.setVisibility(!isEmpty ? 8 : 0);
        bankLotteryPageBinding.bankLotteryTasksList.setVisibility(isEmpty ? 8 : 0);
        this.tasksAdapter.submitList(bankLotteryInfo.getTasks(), true ^ BankLotteryResultStateKt.hasBankLotteryEnded$default(bankLotteryInfo, 0L, 2, null));
        renderRewards$default(this, bankLotteryInfo, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderStatic$lambda$0$2(BankLotteryInfo bankLotteryInfo, BankLotteryPageController bankLotteryPageController) {
        StringKt.openLink(bankLotteryInfo.getStreamUrl(), bankLotteryPageController.targetActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderDynamic(BankLotteryInfo bankLotteryInfo) {
        int i;
        int i2;
        int i3;
        boolean z;
        String string;
        BankLotteryPageBinding bankLotteryPageBinding = this.binding;
        int secondsUntil = secondsUntil(bankLotteryInfo.getEndTime());
        BankLotteryResultState resolveBankLotteryResultState$default = BankLotteryResultStateKt.resolveBankLotteryResultState$default(bankLotteryInfo, this.currentPrizes, 0L, 4, null);
        boolean z2 = true;
        boolean z3 = resolveBankLotteryResultState$default != BankLotteryResultState.ACTIVE;
        boolean z4 = resolveBankLotteryResultState$default == BankLotteryResultState.FINISHED;
        bankLotteryPageBinding.bankLotteryHeroCard.setVisibility(z3 ? 8 : 0);
        bankLotteryPageBinding.bankLotteryFinishedContent.getRoot().setVisibility(z3 ? 0 : 8);
        bankLotteryPageBinding.bankLotteryTimerContainer.setVisibility(z3 ? 8 : 0);
        bankLotteryPageBinding.bankLotteryTimer.setText(formatLotteryDuration(secondsUntil));
        bankLotteryPageBinding.bankLotteryStatusBadge.setVisibility(0);
        bankLotteryPageBinding.bankLotteryStatusBadge.setBackground(Color.parseColor(z3 ? "#22223C" : "#183D55"));
        bankLotteryPageBinding.bankLotteryStatusBadge.setBorder(Color.parseColor(z3 ? "#8B3147" : "#32674B"));
        TextView textView = bankLotteryPageBinding.bankLotteryStatusText;
        int i4 = WhenMappings.$EnumSwitchMapping$0[resolveBankLotteryResultState$default.ordinal()];
        if (i4 == 1) {
            i = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_active;
        } else if (i4 == 2) {
            i = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_results_pending;
        } else if (i4 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_finished;
        }
        textView.setText(i);
        String str = "#FF4059";
        bankLotteryPageBinding.bankLotteryStatusText.setTextColor(Color.parseColor(z3 ? "#FF4059" : "#B6FF00"));
        CustomCardView customCardView = bankLotteryPageBinding.bankLotteryStatusIndicator;
        if (!z3) {
            str = "#9CFF00";
        }
        customCardView.setBackground(Color.parseColor(str));
        bankLotteryPageBinding.bankLotteryStatusIndicator.setVisibility(z3 ? 8 : 0);
        TextView textView2 = bankLotteryPageBinding.bankLotteryFinishedContent.bankLotteryFinishedTitle;
        if (z4) {
            i2 = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_finished;
        } else {
            i2 = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_results_pending;
        }
        textView2.setText(i2);
        TextView textView3 = bankLotteryPageBinding.bankLotteryFinishedContent.bankLotteryFinishedDescription;
        if (z4) {
            i3 = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_finished_description;
        } else {
            i3 = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_results_pending_description;
        }
        textView3.setText(i3);
        this.tasksAdapter.submitList(bankLotteryInfo.getTasks(), !z3);
        renderRewards(bankLotteryInfo, z3);
        List<BankLotteryTaskInfo> tasks = bankLotteryInfo.getTasks();
        if (!(tasks instanceof Collection) || !tasks.isEmpty()) {
            for (BankLotteryTaskInfo bankLotteryTaskInfo : tasks) {
                if (!bankLotteryTaskInfo.getCompleted()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        bankLotteryPageBinding.bankLotteryBalanceContent.setVisibility(z ? 0 : 8);
        bankLotteryPageBinding.bankLotteryConditionsContent.setVisibility(z ? 8 : 0);
        int ticketsLeftSeconds = ticketsLeftSeconds(bankLotteryInfo);
        z2 = (z3 || !z || bankLotteryInfo.getTicketsAvailableCount() <= 0) ? false : false;
        bankLotteryPageBinding.bankLotteryClaimButton.changeValidate(z2, 1.0f);
        CustomCardView bankLotteryClaimButton = bankLotteryPageBinding.bankLotteryClaimButton;
        Intrinsics.checkNotNullExpressionValue(bankLotteryClaimButton, "bankLotteryClaimButton");
        BankClickAnimationKt.setAnimatedClickListener(bankLotteryClaimButton, z2 ? new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit renderDynamic$lambda$0$1;
                renderDynamic$lambda$0$1 = BankLotteryPageController.renderDynamic$lambda$0$1(BankLotteryPageController.this);
                return renderDynamic$lambda$0$1;
            }
        } : null);
        if (z2) {
            bankLotteryPageBinding.bankLotteryClaimButton.setBackground(Color.parseColor("#FFE600"));
            bankLotteryPageBinding.bankLotteryClaimButtonText.setText(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_claim_title);
            bankLotteryPageBinding.bankLotteryClaimButtonText.setTextColor(Color.parseColor("#080911"));
            bankLotteryPageBinding.bankLotteryClaimCountCard.setVisibility(0);
            bankLotteryPageBinding.bankLotteryClaimCountText.setText(String.valueOf(bankLotteryInfo.getTicketsAvailableCount()));
            bankLotteryPageBinding.bankLotteryClaimTimerBadge.setVisibility(8);
        } else if (ticketsLeftSeconds > 0 && !z3 && z) {
            bankLotteryPageBinding.bankLotteryClaimButton.setBackground(Color.parseColor("#0A071B"));
            bankLotteryPageBinding.bankLotteryClaimButtonText.setText(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_claim_title);
            bankLotteryPageBinding.bankLotteryClaimButtonText.setTextColor(Color.parseColor("#66FFFFFF"));
            bankLotteryPageBinding.bankLotteryClaimCountCard.setVisibility(8);
            bankLotteryPageBinding.bankLotteryClaimTimerBadge.setVisibility(0);
            TextView textView4 = bankLotteryPageBinding.bankLotteryClaimTimerText;
            String formatLotteryDuration = formatLotteryDuration(ticketsLeftSeconds);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = formatLotteryDuration.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            textView4.setText(upperCase);
        } else {
            bankLotteryPageBinding.bankLotteryClaimButton.setBackground(Color.parseColor("#0A071B"));
            TextView textView5 = bankLotteryPageBinding.bankLotteryClaimButtonText;
            if (z4) {
                string = this.targetActivity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_claim_finished);
            } else if (z3) {
                string = this.targetActivity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_results_pending);
            } else if (!z) {
                string = this.targetActivity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_claim_unavailable);
            } else {
                int ticketsAvailableCount = bankLotteryInfo.getTicketsAvailableCount();
                Activity activity = this.targetActivity;
                if (ticketsAvailableCount <= 0) {
                    string = activity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_claim_empty);
                } else {
                    string = activity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_claim_title);
                }
            }
            textView5.setText(string);
            bankLotteryPageBinding.bankLotteryClaimButtonText.setTextColor(Color.parseColor("#66FFFFFF"));
            bankLotteryPageBinding.bankLotteryClaimCountCard.setVisibility(8);
            bankLotteryPageBinding.bankLotteryClaimTimerBadge.setVisibility(8);
        }
        renderSelectedSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderDynamic$lambda$0$1(BankLotteryPageController bankLotteryPageController) {
        bankLotteryPageController.onAction.invoke(0, BankSendSubId.GIVEAWAY_CLAIM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectSection(BankLotterySection bankLotterySection) {
        if (this.selectedSection == bankLotterySection) {
            return;
        }
        this.selectedSection = bankLotterySection;
        renderSelectedSection();
    }

    private final void renderSelectedSection() {
        CustomCardView customCardView;
        BankLotteryPageBinding bankLotteryPageBinding = this.binding;
        boolean z = this.selectedSection == BankLotterySection.HOME;
        BankLotteryInfo bankLotteryInfo = this.currentLottery;
        boolean z2 = bankLotteryInfo != null && BankLotteryResultStateKt.hasBankLotteryEnded$default(bankLotteryInfo, 0L, 2, null);
        bankLotteryPageBinding.bankLotteryActiveContent.setVisibility((!z || z2) ? 8 : 0);
        bankLotteryPageBinding.bankLotteryFinishedContent.getRoot().setVisibility((z && z2) ? 0 : 8);
        bankLotteryPageBinding.bankLotteryTasksContent.setVisibility(this.selectedSection == BankLotterySection.TASKS ? 0 : 8);
        bankLotteryPageBinding.bankLotteryRewardsCard.setVisibility(this.selectedSection == BankLotterySection.REWARDS ? 0 : 8);
        CustomCardView bankLotterySectionHome = bankLotteryPageBinding.bankLotterySectionHome;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionHome, "bankLotterySectionHome");
        TextView bankLotterySectionHomeText = bankLotteryPageBinding.bankLotterySectionHomeText;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionHomeText, "bankLotterySectionHomeText");
        bindSectionButton(bankLotterySectionHome, bankLotterySectionHomeText, this.selectedSection == BankLotterySection.HOME);
        CustomCardView bankLotterySectionTasks = bankLotteryPageBinding.bankLotterySectionTasks;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionTasks, "bankLotterySectionTasks");
        TextView bankLotterySectionTasksText = bankLotteryPageBinding.bankLotterySectionTasksText;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionTasksText, "bankLotterySectionTasksText");
        bindSectionButton(bankLotterySectionTasks, bankLotterySectionTasksText, this.selectedSection == BankLotterySection.TASKS);
        CustomCardView bankLotterySectionRewards = bankLotteryPageBinding.bankLotterySectionRewards;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionRewards, "bankLotterySectionRewards");
        TextView bankLotterySectionRewardsText = bankLotteryPageBinding.bankLotterySectionRewardsText;
        Intrinsics.checkNotNullExpressionValue(bankLotterySectionRewardsText, "bankLotterySectionRewardsText");
        bindSectionButton(bankLotterySectionRewards, bankLotterySectionRewardsText, this.selectedSection == BankLotterySection.REWARDS);
        int i = WhenMappings.$EnumSwitchMapping$1[this.selectedSection.ordinal()];
        if (i == 1) {
            customCardView = bankLotteryPageBinding.bankLotterySectionHome;
        } else if (i == 2) {
            customCardView = bankLotteryPageBinding.bankLotterySectionTasks;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            customCardView = bankLotteryPageBinding.bankLotterySectionRewards;
        }
        Intrinsics.checkNotNull(customCardView);
        moveSectionIndicator(customCardView);
    }

    private final void moveSectionIndicator(View view) {
        if (canMoveSectionIndicator(view)) {
            this.binding.getRoot().removeOnLayoutChangeListener(this.sectionIndicatorLayoutListener);
            this.pendingSectionIndicatorTarget = null;
            BankSlidingTabIndicator.moveTo$default(this.sectionIndicator, view, false, 2, null);
            return;
        }
        this.pendingSectionIndicatorTarget = view;
        this.binding.getRoot().removeOnLayoutChangeListener(this.sectionIndicatorLayoutListener);
        this.binding.getRoot().addOnLayoutChangeListener(this.sectionIndicatorLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canMoveSectionIndicator(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0 && this.binding.bankLotterySectionIndicator.getWidth() > 0;
    }

    private final void bindSectionButton(CustomCardView customCardView, TextView textView, boolean z) {
        customCardView.setBackground(-1);
        customCardView.setBackgroundAlpha(0);
        textView.setTextColor(Color.parseColor(z ? "#15182A" : "#FFFFFF"));
    }

    static /* synthetic */ void renderRewards$default(BankLotteryPageController bankLotteryPageController, BankLotteryInfo bankLotteryInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = BankLotteryResultStateKt.hasBankLotteryEnded$default(bankLotteryInfo, 0L, 2, null);
        }
        bankLotteryPageController.renderRewards(bankLotteryInfo, z);
    }

    private final void renderRewards(BankLotteryInfo bankLotteryInfo, boolean z) {
        int i;
        BankLotteryPageBinding bankLotteryPageBinding = this.binding;
        boolean isEmpty = this.currentPrizes.isEmpty();
        bankLotteryPageBinding.bankLotteryRewardsEmpty.setVisibility(!isEmpty ? 8 : 0);
        bankLotteryPageBinding.bankLotteryRewardsList.setVisibility(isEmpty ? 8 : 0);
        TextView textView = bankLotteryPageBinding.bankLotteryRewardsTitle;
        if (z) {
            i = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_winners_title;
        } else {
            i = com.arizonagames.feature.arizona.bank.R.string.bank_lottery_rewards_title;
        }
        textView.setText(i);
        this.rewardsAdapter.submitList(this.currentPrizes, z);
    }

    private final void bindStreamButton(BankLotteryStreamPlatform bankLotteryStreamPlatform) {
        Pair pair;
        int i;
        BankLotteryPageBinding bankLotteryPageBinding = this.binding;
        int i2 = WhenMappings.$EnumSwitchMapping$2[bankLotteryStreamPlatform.ordinal()];
        if (i2 == 1) {
            pair = TuplesKt.to("#D91515", "#701010");
        } else if (i2 == 2) {
            pair = TuplesKt.to("#2787F5", "#14539A");
        } else if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            pair = TuplesKt.to("#9146FF", "#4E238D");
        }
        CustomCardView bankLotteryStreamButton = bankLotteryPageBinding.bankLotteryStreamButton;
        Intrinsics.checkNotNullExpressionValue(bankLotteryStreamButton, "bankLotteryStreamButton");
        CustomCardView.setBackground$default(bankLotteryStreamButton, Color.parseColor((String) pair.component1()), Color.parseColor((String) pair.component2()), 0, null, 8, null);
        ImageView imageView = bankLotteryPageBinding.bankLotteryStreamIcon;
        int i3 = WhenMappings.$EnumSwitchMapping$2[bankLotteryStreamPlatform.ordinal()];
        if (i3 == 1) {
            i = com.arizonagames.feature.arizona.bank.R.drawable.bank_lottery_stream_youtube;
        } else if (i3 == 2) {
            i = com.arizonagames.feature.arizona.bank.R.drawable.bank_lottery_stream_vk;
        } else if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = com.arizonagames.feature.arizona.bank.R.drawable.bank_lottery_stream_twitch;
        }
        imageView.setImageResource(i);
        bankLotteryPageBinding.bankLotteryStreamText.setText(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_stream);
    }

    private final void bindUnavailableStreamButton() {
        BankLotteryPageBinding bankLotteryPageBinding = this.binding;
        CustomCardView bankLotteryStreamButton = bankLotteryPageBinding.bankLotteryStreamButton;
        Intrinsics.checkNotNullExpressionValue(bankLotteryStreamButton, "bankLotteryStreamButton");
        CustomCardView.setBackground$default(bankLotteryStreamButton, Color.parseColor("#22223C"), Color.parseColor("#12131F"), 0, null, 8, null);
        bankLotteryPageBinding.bankLotteryStreamIcon.setImageResource(R.drawable.background_video_ic_play);
        bankLotteryPageBinding.bankLotteryStreamText.setText(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_stream);
    }

    private final void restartTimer(BankLotteryInfo bankLotteryInfo) {
        Job launch$default;
        Job job = this.timerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (BankLotteryResultStateKt.hasBankLotteryEnded$default(bankLotteryInfo, 0L, 2, null)) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BankLotteryPageController$restartTimer$1(this, null), 3, null);
        this.timerJob = launch$default;
    }

    private final int secondsUntil(long j) {
        if (j <= 0) {
            return 0;
        }
        return (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(j - (System.currentTimeMillis() / 1000), 0L), (long) SieveCacheKt.NodeLinkMask);
    }

    private final int ticketsLeftSeconds(BankLotteryInfo bankLotteryInfo) {
        if (bankLotteryInfo.getTicketsLeftTime() <= 0 || this.ticketsTimerStartedAtMs <= 0) {
            return RangesKt.coerceAtLeast(bankLotteryInfo.getTicketsLeftTime(), 0);
        }
        return RangesKt.coerceAtLeast(bankLotteryInfo.getTicketsLeftTime() - ((int) ((System.currentTimeMillis() - this.ticketsTimerStartedAtMs) / 1000)), 0);
    }

    private final String formatLotteryDuration(int i) {
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int i2 = coerceAtLeast / 86400;
        int i3 = (coerceAtLeast % 86400) / 3600;
        int i4 = (coerceAtLeast % 3600) / 60;
        int i5 = coerceAtLeast % 60;
        if (i2 > 0) {
            String string = this.targetActivity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_duration_days_hours, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        Activity activity = this.targetActivity;
        if (i3 > 0) {
            String string2 = activity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_duration_hours_minutes, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String string3 = activity.getString(com.arizonagames.feature.arizona.bank.R.string.bank_lottery_duration_minutes_seconds, new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    /* compiled from: BankLotteryPageController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryPageController$Companion;", "", "<init>", "()V", "REWARD_SPAN_COUNT", "", "SECONDS_PER_MINUTE", "SECONDS_PER_HOUR", "SECONDS_PER_DAY", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
