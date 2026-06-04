package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudGathersCountItemBinding;
/* compiled from: HudGathersCountAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountBonus;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter$GathersCountViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "GathersCountViewHolder", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCountAdapter extends ListAdapter<HudGathersCountBonus, GathersCountViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final HudGathersCountAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<HudGathersCountBonus>() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count.HudGathersCountAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HudGathersCountBonus oldItem, HudGathersCountBonus newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getIcon(), newItem.getIcon());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HudGathersCountBonus oldItem, HudGathersCountBonus newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public HudGathersCountAdapter() {
        super(diffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GathersCountViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        HudGathersCountItemBinding inflate = HudGathersCountItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new GathersCountViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GathersCountViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HudGathersCountBonus hudGathersCountBonus = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(hudGathersCountBonus, "get(...)");
        holder.onBind(hudGathersCountBonus);
    }

    /* compiled from: HudGathersCountAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter$GathersCountViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/HudGathersCountItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter;Lru/mrlargha/commonui/databinding/HudGathersCountItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudGathersCountItemBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "jobTimer", "Lkotlinx/coroutines/Job;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountBonus;", "startTimer", "time", "", "stopTimer", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class GathersCountViewHolder extends RecyclerView.ViewHolder {
        private final HudGathersCountItemBinding binding;
        private Job jobTimer;
        private final CoroutineScope scope;
        final /* synthetic */ HudGathersCountAdapter this$0;

        /* compiled from: HudGathersCountAdapter.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HudGathersCountBonusType.values().length];
                try {
                    iArr[HudGathersCountBonusType.SPEED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[HudGathersCountBonusType.GIFT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[HudGathersCountBonusType.MAGNET.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GathersCountViewHolder(HudGathersCountAdapter hudGathersCountAdapter, HudGathersCountItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = hudGathersCountAdapter;
            this.binding = binding;
            this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }

        public final HudGathersCountItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(HudGathersCountBonus model) {
            int i;
            Intrinsics.checkNotNullParameter(model, "model");
            HudGathersCountItemBinding hudGathersCountItemBinding = this.binding;
            if (model.getActive()) {
                hudGathersCountItemBinding.ivBg.setImageResource(R.drawable.hud_gather_count_active_item_bg);
                LinearLayout activeContainer = hudGathersCountItemBinding.activeContainer;
                Intrinsics.checkNotNullExpressionValue(activeContainer, "activeContainer");
                activeContainer.setVisibility(0);
                ImageView ivInactiveIc = hudGathersCountItemBinding.ivInactiveIc;
                Intrinsics.checkNotNullExpressionValue(ivInactiveIc, "ivInactiveIc");
                ivInactiveIc.setVisibility(8);
                startTimer(model.getTime());
            } else {
                hudGathersCountItemBinding.ivBg.setImageResource(R.drawable.hud_gather_count_active_item_bg);
                LinearLayout activeContainer2 = hudGathersCountItemBinding.activeContainer;
                Intrinsics.checkNotNullExpressionValue(activeContainer2, "activeContainer");
                activeContainer2.setVisibility(8);
                ImageView ivInactiveIc2 = hudGathersCountItemBinding.ivInactiveIc;
                Intrinsics.checkNotNullExpressionValue(ivInactiveIc2, "ivInactiveIc");
                ivInactiveIc2.setVisibility(0);
                stopTimer();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[model.getType().ordinal()];
            if (i2 == 1) {
                i = R.drawable.hud_gathers_count_ic_run;
            } else if (i2 == 2) {
                i = R.drawable.hud_gathers_count_ic_present;
            } else if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                i = R.drawable.hud_gathers_count_ic_magnet;
            }
            hudGathersCountItemBinding.ivInactiveIc.setImageResource(i);
            hudGathersCountItemBinding.ivActiveIc.setImageResource(i);
        }

        private final void startTimer(int i) {
            Job launch$default;
            HudGathersCountItemBinding hudGathersCountItemBinding = this.binding;
            Job job = this.jobTimer;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new HudGathersCountAdapter$GathersCountViewHolder$startTimer$1$1(i, hudGathersCountItemBinding, this, null), 3, null);
            this.jobTimer = launch$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void stopTimer() {
            Job job = this.jobTimer;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.jobTimer = null;
        }
    }

    /* compiled from: HudGathersCountAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter$Companion$diffUtilCallback$1;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
