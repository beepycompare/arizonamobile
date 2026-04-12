package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementDamageFeedItemLeftBinding;
import ru.mrlargha.commonui.databinding.HudElementDamageFeedItemRightBinding;
import ru.mrlargha.commonui.databinding.HudElementDamageInformerBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.StrokeTextView;
import ru.mrlargha.ui.kit.DamageInformerIconsKt;
/* compiled from: DamageInformerElement.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 N2\u00020\u0001:\u0002NOB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010+\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020#H\u0002J \u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002J \u00105\u001a\u00020#2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002JT\u00106\u001a\u00020#2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020 2\u0006\u00102\u001a\u00020&2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020#0CJ\u0018\u0010D\u001a\u00020#2\u0006\u0010A\u001a\u00020 2\u0006\u00102\u001a\u00020&H\u0002J\u0018\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u0002082\u0006\u00103\u001a\u000204H\u0002J\u0018\u0010G\u001a\u00020#2\u0006\u0010F\u001a\u0002082\u0006\u00103\u001a\u000204H\u0002J\b\u0010H\u001a\u00020#H\u0002J\b\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020#H\u0002J\u001a\u0010K\u001a\u0002042\b\u0010L\u001a\u0004\u0018\u00010)2\u0006\u0010M\u001a\u000204H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00150\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\r\u0012\t\u0012\u00070\u001b¢\u0006\u0002\b\u00150\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageFeedElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementDamageInformerBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementDamageInformerBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementDamageInformerBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "tokenGenerator", "Ljava/util/concurrent/atomic/AtomicLong;", "outgoingItems", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageFeedElement$ActiveDamageItem;", "incomingItems", "leftRows", "", "Lru/mrlargha/commonui/databinding/HudElementDamageFeedItemLeftBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getLeftRows", "()Ljava/util/List;", "leftRows$delegate", "Lkotlin/Lazy;", "rightRows", "Lru/mrlargha/commonui/databinding/HudElementDamageFeedItemRightBinding;", "getRightRows", "rightRows$delegate", "imageJobs", "Ljava/util/WeakHashMap;", "Landroid/widget/ImageView;", "Lkotlinx/coroutines/Job;", "clear", "", "addItem", "itemDto", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageLogItem;", "setInfo", "data", "", "removeByToken", "type", "token", "", "getTargetList", "bindAll", "bindLeftRow", "itemBinding", "item", FirebaseAnalytics.Param.INDEX, "", "bindRightRow", "bindRow", "root", "Landroid/view/View;", "tvName", "Lru/mrlargha/commonui/utils/ui/StrokeTextView;", "tvId", "Landroid/widget/TextView;", "tvValue", "tvValueTotal", "cardId", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "ivWeapon", "animate", "Lkotlin/Function0;", "bindWeapon", "animateLeftItem", "view", "animateRightItem", "showRootIfNeeded", "hideRoot", "hideRootImmediately", "parseColorSafe", "colorString", "fallback", "Companion", "ActiveDamageItem", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DamageFeedElement {
    public static final Companion Companion = new Companion(null);
    private static final long ITEM_ANIM_DURATION = 180;
    private static final float ITEM_TRANSLATION_X = 20.0f;
    private static final int MAX_ITEMS_PER_GROUP = 7;
    private static final long ROOT_ANIM_DURATION = 180;
    private final HudElementDamageInformerBinding binding;
    private final WeakHashMap<ImageView, Job> imageJobs;
    private final List<ActiveDamageItem> incomingItems;
    private final Lazy leftRows$delegate;
    private final SAMPUIElement notifier;
    private final List<ActiveDamageItem> outgoingItems;
    private final Lazy rightRows$delegate;
    private final AtomicLong tokenGenerator;

    public DamageFeedElement(HudElementDamageInformerBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
        this.tokenGenerator = new AtomicLong(0L);
        this.outgoingItems = new ArrayList();
        this.incomingItems = new ArrayList();
        this.leftRows$delegate = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List listOf;
                listOf = CollectionsKt.listOf((Object[]) new HudElementDamageFeedItemLeftBinding[]{r0.binding.leftItem0, r0.binding.leftItem1, r0.binding.leftItem2, r0.binding.leftItem3, r0.binding.leftItem4, r0.binding.leftItem5, DamageFeedElement.this.binding.leftItem6});
                return listOf;
            }
        });
        this.rightRows$delegate = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List listOf;
                listOf = CollectionsKt.listOf((Object[]) new HudElementDamageFeedItemRightBinding[]{r0.binding.rightItem0, r0.binding.rightItem1, r0.binding.rightItem2, r0.binding.rightItem3, r0.binding.rightItem4, r0.binding.rightItem5, DamageFeedElement.this.binding.rightItem6});
                return listOf;
            }
        });
        this.imageJobs = new WeakHashMap<>();
        binding.root.setVisibility(8);
    }

    public final HudElementDamageInformerBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    /* compiled from: DamageInformerElement.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageFeedElement$Companion;", "", "<init>", "()V", "MAX_ITEMS_PER_GROUP", "", "ROOT_ANIM_DURATION", "", "ITEM_ANIM_DURATION", "ITEM_TRANSLATION_X", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DamageInformerElement.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageFeedElement$ActiveDamageItem;", "", "token", "", "data", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageLogItem;", "removeJob", "Lkotlinx/coroutines/Job;", "<init>", "(JLru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageLogItem;Lkotlinx/coroutines/Job;)V", "getToken", "()J", "getData", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/damage_informer/DamageLogItem;", "getRemoveJob", "()Lkotlinx/coroutines/Job;", "setRemoveJob", "(Lkotlinx/coroutines/Job;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ActiveDamageItem {
        private final DamageLogItem data;
        private Job removeJob;
        private final long token;

        public static /* synthetic */ ActiveDamageItem copy$default(ActiveDamageItem activeDamageItem, long j, DamageLogItem damageLogItem, Job job, int i, Object obj) {
            if ((i & 1) != 0) {
                j = activeDamageItem.token;
            }
            if ((i & 2) != 0) {
                damageLogItem = activeDamageItem.data;
            }
            if ((i & 4) != 0) {
                job = activeDamageItem.removeJob;
            }
            return activeDamageItem.copy(j, damageLogItem, job);
        }

        public final long component1() {
            return this.token;
        }

        public final DamageLogItem component2() {
            return this.data;
        }

        public final Job component3() {
            return this.removeJob;
        }

        public final ActiveDamageItem copy(long j, DamageLogItem data, Job job) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new ActiveDamageItem(j, data, job);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActiveDamageItem) {
                ActiveDamageItem activeDamageItem = (ActiveDamageItem) obj;
                return this.token == activeDamageItem.token && Intrinsics.areEqual(this.data, activeDamageItem.data) && Intrinsics.areEqual(this.removeJob, activeDamageItem.removeJob);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((Long.hashCode(this.token) * 31) + this.data.hashCode()) * 31;
            Job job = this.removeJob;
            return hashCode + (job == null ? 0 : job.hashCode());
        }

        public String toString() {
            long j = this.token;
            DamageLogItem damageLogItem = this.data;
            return "ActiveDamageItem(token=" + j + ", data=" + damageLogItem + ", removeJob=" + this.removeJob + ")";
        }

        public ActiveDamageItem(long j, DamageLogItem data, Job job) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.token = j;
            this.data = data;
            this.removeJob = job;
        }

        public /* synthetic */ ActiveDamageItem(long j, DamageLogItem damageLogItem, Job job, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, damageLogItem, (i & 4) != 0 ? null : job);
        }

        public final long getToken() {
            return this.token;
        }

        public final DamageLogItem getData() {
            return this.data;
        }

        public final Job getRemoveJob() {
            return this.removeJob;
        }

        public final void setRemoveJob(Job job) {
            this.removeJob = job;
        }
    }

    private final List<HudElementDamageFeedItemLeftBinding> getLeftRows() {
        return (List) this.leftRows$delegate.getValue();
    }

    private final List<HudElementDamageFeedItemRightBinding> getRightRows() {
        return (List) this.rightRows$delegate.getValue();
    }

    public final void clear() {
        for (ActiveDamageItem activeDamageItem : this.outgoingItems) {
            Job removeJob = activeDamageItem.getRemoveJob();
            if (removeJob != null) {
                Job.DefaultImpls.cancel$default(removeJob, (CancellationException) null, 1, (Object) null);
            }
        }
        for (ActiveDamageItem activeDamageItem2 : this.incomingItems) {
            Job removeJob2 = activeDamageItem2.getRemoveJob();
            if (removeJob2 != null) {
                Job.DefaultImpls.cancel$default(removeJob2, (CancellationException) null, 1, (Object) null);
            }
        }
        this.outgoingItems.clear();
        this.incomingItems.clear();
        bindAll();
        hideRootImmediately();
    }

    public final void addItem(DamageLogItem damageLogItem) {
        Job launch$default;
        Job removeJob;
        if (damageLogItem == null) {
            return;
        }
        showRootIfNeeded();
        List<ActiveDamageItem> targetList = getTargetList(damageLogItem.getType());
        Iterator<ActiveDamageItem> it = targetList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getData().getId() == damageLogItem.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            ActiveDamageItem activeDamageItem = (ActiveDamageItem) CollectionsKt.getOrNull(targetList, i);
            if (activeDamageItem != null && (removeJob = activeDamageItem.getRemoveJob()) != null) {
                Job.DefaultImpls.cancel$default(removeJob, (CancellationException) null, 1, (Object) null);
            }
            targetList.remove(i);
        }
        ActiveDamageItem activeDamageItem2 = new ActiveDamageItem(this.tokenGenerator.incrementAndGet(), damageLogItem, null, 4, null);
        targetList.add(0, activeDamageItem2);
        while (targetList.size() > 7) {
            Job removeJob2 = targetList.remove(CollectionsKt.getLastIndex(targetList)).getRemoveJob();
            if (removeJob2 != null) {
                Job.DefaultImpls.cancel$default(removeJob2, (CancellationException) null, 1, (Object) null);
            }
        }
        bindAll();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())), null, null, new DamageFeedElement$addItem$1(damageLogItem, this, activeDamageItem2, null), 3, null);
        activeDamageItem2.setRemoveJob(launch$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeByToken(String str, long j) {
        Job removeJob;
        List<ActiveDamageItem> targetList = getTargetList(str);
        Iterator<ActiveDamageItem> it = targetList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getToken() == j) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        ActiveDamageItem activeDamageItem = (ActiveDamageItem) CollectionsKt.getOrNull(targetList, i);
        if (activeDamageItem != null && (removeJob = activeDamageItem.getRemoveJob()) != null) {
            Job.DefaultImpls.cancel$default(removeJob, (CancellationException) null, 1, (Object) null);
        }
        targetList.remove(i);
        bindAll();
        if (this.outgoingItems.isEmpty() && this.incomingItems.isEmpty()) {
            hideRoot();
        }
    }

    private final List<ActiveDamageItem> getTargetList(String str) {
        return Intrinsics.areEqual(str, "outgoing") ? this.outgoingItems : this.incomingItems;
    }

    private final void bindAll() {
        int i = 0;
        int i2 = 0;
        for (Object obj : getLeftRows()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HudElementDamageFeedItemLeftBinding hudElementDamageFeedItemLeftBinding = (HudElementDamageFeedItemLeftBinding) obj;
            ActiveDamageItem activeDamageItem = (ActiveDamageItem) CollectionsKt.getOrNull(this.outgoingItems, i2);
            if (activeDamageItem == null) {
                hudElementDamageFeedItemLeftBinding.root.setVisibility(8);
            } else {
                Intrinsics.checkNotNull(hudElementDamageFeedItemLeftBinding);
                bindLeftRow(hudElementDamageFeedItemLeftBinding, activeDamageItem.getData(), i2);
            }
            i2 = i3;
        }
        for (Object obj2 : getRightRows()) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HudElementDamageFeedItemRightBinding hudElementDamageFeedItemRightBinding = (HudElementDamageFeedItemRightBinding) obj2;
            ActiveDamageItem activeDamageItem2 = (ActiveDamageItem) CollectionsKt.getOrNull(this.incomingItems, i);
            if (activeDamageItem2 == null) {
                hudElementDamageFeedItemRightBinding.root.setVisibility(8);
            } else {
                Intrinsics.checkNotNull(hudElementDamageFeedItemRightBinding);
                bindRightRow(hudElementDamageFeedItemRightBinding, activeDamageItem2.getData(), i);
            }
            i = i4;
        }
    }

    private final void bindLeftRow(final HudElementDamageFeedItemLeftBinding hudElementDamageFeedItemLeftBinding, DamageLogItem damageLogItem, final int i) {
        FrameLayout root = hudElementDamageFeedItemLeftBinding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        StrokeTextView tvName = hudElementDamageFeedItemLeftBinding.tvName;
        Intrinsics.checkNotNullExpressionValue(tvName, "tvName");
        TextView tvId = hudElementDamageFeedItemLeftBinding.tvId;
        Intrinsics.checkNotNullExpressionValue(tvId, "tvId");
        StrokeTextView tvValue = hudElementDamageFeedItemLeftBinding.tvValue;
        Intrinsics.checkNotNullExpressionValue(tvValue, "tvValue");
        StrokeTextView tvValueTotal = hudElementDamageFeedItemLeftBinding.tvValueTotal;
        Intrinsics.checkNotNullExpressionValue(tvValueTotal, "tvValueTotal");
        CustomCardView cardId = hudElementDamageFeedItemLeftBinding.cardId;
        Intrinsics.checkNotNullExpressionValue(cardId, "cardId");
        ImageView ivWeapon = hudElementDamageFeedItemLeftBinding.ivWeapon;
        Intrinsics.checkNotNullExpressionValue(ivWeapon, "ivWeapon");
        bindRow(root, tvName, tvId, tvValue, tvValueTotal, cardId, ivWeapon, damageLogItem, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindLeftRow$lambda$0$0;
                bindLeftRow$lambda$0$0 = DamageFeedElement.bindLeftRow$lambda$0$0(DamageFeedElement.this, hudElementDamageFeedItemLeftBinding, i);
                return bindLeftRow$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLeftRow$lambda$0$0(DamageFeedElement damageFeedElement, HudElementDamageFeedItemLeftBinding hudElementDamageFeedItemLeftBinding, int i) {
        FrameLayout root = hudElementDamageFeedItemLeftBinding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        damageFeedElement.animateLeftItem(root, i);
        return Unit.INSTANCE;
    }

    private final void bindRightRow(final HudElementDamageFeedItemRightBinding hudElementDamageFeedItemRightBinding, DamageLogItem damageLogItem, final int i) {
        FrameLayout root = hudElementDamageFeedItemRightBinding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        StrokeTextView tvName = hudElementDamageFeedItemRightBinding.tvName;
        Intrinsics.checkNotNullExpressionValue(tvName, "tvName");
        TextView tvId = hudElementDamageFeedItemRightBinding.tvId;
        Intrinsics.checkNotNullExpressionValue(tvId, "tvId");
        StrokeTextView tvValue = hudElementDamageFeedItemRightBinding.tvValue;
        Intrinsics.checkNotNullExpressionValue(tvValue, "tvValue");
        StrokeTextView tvValueTotal = hudElementDamageFeedItemRightBinding.tvValueTotal;
        Intrinsics.checkNotNullExpressionValue(tvValueTotal, "tvValueTotal");
        CustomCardView cardId = hudElementDamageFeedItemRightBinding.cardId;
        Intrinsics.checkNotNullExpressionValue(cardId, "cardId");
        ImageView ivWeapon = hudElementDamageFeedItemRightBinding.ivWeapon;
        Intrinsics.checkNotNullExpressionValue(ivWeapon, "ivWeapon");
        bindRow(root, tvName, tvId, tvValue, tvValueTotal, cardId, ivWeapon, damageLogItem, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindRightRow$lambda$0$0;
                bindRightRow$lambda$0$0 = DamageFeedElement.bindRightRow$lambda$0$0(DamageFeedElement.this, hudElementDamageFeedItemRightBinding, i);
                return bindRightRow$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRightRow$lambda$0$0(DamageFeedElement damageFeedElement, HudElementDamageFeedItemRightBinding hudElementDamageFeedItemRightBinding, int i) {
        FrameLayout root = hudElementDamageFeedItemRightBinding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        damageFeedElement.animateRightItem(root, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindRow(View root, StrokeTextView tvName, TextView tvId, StrokeTextView tvValue, StrokeTextView tvValueTotal, CustomCardView cardId, ImageView ivWeapon, DamageLogItem item, Function0<Unit> animate) {
        boolean z;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tvName, "tvName");
        Intrinsics.checkNotNullParameter(tvId, "tvId");
        Intrinsics.checkNotNullParameter(tvValue, "tvValue");
        Intrinsics.checkNotNullParameter(tvValueTotal, "tvValueTotal");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(ivWeapon, "ivWeapon");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(animate, "animate");
        boolean z2 = root.getVisibility() != 0;
        root.setVisibility(0);
        String name = item.getName();
        if (name != null) {
            z = z2;
            SpannableString spannable$default = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, name, 0.0f, 1, null);
            if (spannable$default != null) {
                charSequence = spannable$default;
                tvName.setText(charSequence);
                tvId.setText(String.valueOf(item.getId()));
                tvValue.setText((item.getValue() != null || item.getValue().floatValue() < 0.0f) ? "" : String.valueOf(item.getValue().floatValue()));
                tvValueTotal.setText((item.getTotalValue() != null || item.getTotalValue().floatValue() <= 0.0f) ? "" : "(" + item.getTotalValue() + ")");
                CustomCardView customCardView = cardId;
                customCardView.setVisibility(8);
                if (item.getTag() != null) {
                    customCardView.setVisibility(item.getTag().length() == 0 ? 8 : 0);
                    if (item.getTag().length() > 0) {
                        cardId.setVisibility(0);
                        cardId.setBackground(Color.parseColor(item.getTagBackgroundColor()));
                        tvId.setTextColor(Color.parseColor(item.getTagTextColor()));
                        tvId.setText(item.getTag());
                    }
                }
                tvName.setTextColor(parseColorSafe(item.getNameColor(), -1));
                tvValue.setTextColor(parseColorSafe(item.getValueColor(), -1));
                tvName.setStroke(-16777216, 3.0f);
                tvValue.setStroke(-16777216, 3.0f);
                tvValueTotal.setStroke(-16777216, 3.0f);
                bindWeapon(ivWeapon, item);
                if (!z) {
                    animate.invoke();
                    return;
                }
                root.setAlpha(1.0f);
                root.setTranslationX(0.0f);
                return;
            }
        } else {
            z = z2;
        }
        tvName.setText(charSequence);
        tvId.setText(String.valueOf(item.getId()));
        tvValue.setText((item.getValue() != null || item.getValue().floatValue() < 0.0f) ? "" : String.valueOf(item.getValue().floatValue()));
        tvValueTotal.setText((item.getTotalValue() != null || item.getTotalValue().floatValue() <= 0.0f) ? "" : "(" + item.getTotalValue() + ")");
        CustomCardView customCardView2 = cardId;
        customCardView2.setVisibility(8);
        if (item.getTag() != null) {
        }
        tvName.setTextColor(parseColorSafe(item.getNameColor(), -1));
        tvValue.setTextColor(parseColorSafe(item.getValueColor(), -1));
        tvName.setStroke(-16777216, 3.0f);
        tvValue.setStroke(-16777216, 3.0f);
        tvValueTotal.setStroke(-16777216, 3.0f);
        bindWeapon(ivWeapon, item);
        if (!z) {
        }
    }

    private final void bindWeapon(ImageView imageView, DamageLogItem damageLogItem) {
        int intValue;
        Job launch$default;
        ImageView imageView2 = imageView;
        Glide.with(imageView2).clear(imageView2);
        Job remove = this.imageJobs.remove(imageView);
        if (remove != null) {
            Job.DefaultImpls.cancel$default(remove, (CancellationException) null, 1, (Object) null);
        }
        imageView.setImageDrawable(null);
        imageView.setVisibility(4);
        Integer imageId = damageLogItem.getImageId();
        if (imageId == null || (intValue = imageId.intValue()) == -1) {
            return;
        }
        imageView.setVisibility(0);
        Integer imageType = damageLogItem.getImageType();
        if (imageType != null) {
            if (imageType.intValue() != 0) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new DamageFeedElement$bindWeapon$1$job$1(imageView, intValue, null), 3, null);
                this.imageJobs.put(imageView, launch$default);
                return;
            }
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            imageView.setImageResource(DamageInformerIconsKt.damageInformerIcons(intValue, context));
        }
    }

    private final void animateLeftItem(View view, int i) {
        view.clearAnimation();
        view.setAlpha(0.0f);
        view.setTranslationX(-20.0f);
        view.animate().alpha(1.0f).translationX(0.0f).setDuration(180L).setStartDelay(i * 20).setInterpolator(new DecelerateInterpolator()).start();
    }

    private final void animateRightItem(View view, int i) {
        view.clearAnimation();
        view.setAlpha(0.0f);
        view.setTranslationX(20.0f);
        view.animate().alpha(1.0f).translationX(0.0f).setDuration(180L).setStartDelay(i * 20).setInterpolator(new DecelerateInterpolator()).start();
    }

    private final void showRootIfNeeded() {
        FrameLayout root = this.binding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        if (root.getVisibility() == 0) {
            return;
        }
        this.binding.root.clearAnimation();
        this.binding.root.setAlpha(0.0f);
        this.binding.root.setVisibility(0);
        this.binding.root.animate().alpha(1.0f).setDuration(180L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
    }

    private final void hideRoot() {
        FrameLayout root = this.binding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        if (root.getVisibility() == 0) {
            this.binding.root.clearAnimation();
            this.binding.root.animate().alpha(0.0f).setDuration(180L).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.damage_informer.DamageFeedElement$hideRoot$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    List list;
                    List list2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    list = DamageFeedElement.this.outgoingItems;
                    if (list.isEmpty()) {
                        list2 = DamageFeedElement.this.incomingItems;
                        if (list2.isEmpty()) {
                            DamageFeedElement.this.getBinding().root.setVisibility(8);
                            DamageFeedElement.this.getBinding().root.setAlpha(1.0f);
                        }
                    }
                    DamageFeedElement.this.getBinding().root.animate().setListener(null);
                }
            }).start();
        }
    }

    private final void hideRootImmediately() {
        this.binding.root.clearAnimation();
        this.binding.root.setVisibility(8);
        this.binding.root.setAlpha(1.0f);
    }

    private final int parseColorSafe(String str, int i) {
        try {
            String str2 = str;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                return Color.parseColor(str);
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public final void setInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        addItem((DamageLogItem) ((!MapperKt.isJsonValid(data) || Intrinsics.areEqual(data, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(data, "{}") || data.length() == 0) ? null : MapperKt.getGson().fromJson(data, (Class<Object>) DamageLogItem.class)));
    }
}
