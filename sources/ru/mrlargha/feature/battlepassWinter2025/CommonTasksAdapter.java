package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassCommonTaskItemBinding;
/* compiled from: CommonTasksAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\b\u0001\u0010\u0007\u001a\u00020\u0006:\u0002\b\b\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006J\u0014\u0010#\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0%J\u0006\u0010&\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0083\u0004\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0010j\b\u0012\u0004\u0012\u00020\u000b`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0010j\b\u0012\u0004\u0012\u00020\u000b`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006'"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/CommonTasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/feature/battlepassWinter2025/RodinaBattlePassCommonTaskViewHolder;", "isArizona", "", "colorMaxProgress", "", "itemLayout", "Landroidx/annotation/LayoutRes;", "onSelectTask", "Lkotlin/Function2;", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskInfo;", "", "<init>", "(ZIILkotlin/jvm/functions/Function2;)V", "allTasksList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllTasksList", "()Ljava/util/ArrayList;", "currentTasksList", "getCurrentTasksList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "filterList", "categoryType", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "selectTask", "addAllTasks", "tasks", "", "clearAllTasksList", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CommonTasksAdapter extends RecyclerView.Adapter<RodinaBattlePassCommonTaskViewHolder> {
    private final ArrayList<CommonTaskInfo> allTasksList;
    private final int colorMaxProgress;
    private final ArrayList<CommonTaskInfo> currentTasksList;
    private final boolean isArizona;
    private final int itemLayout;
    private final Function2<CommonTaskInfo, Integer, Unit> onSelectTask;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonTasksAdapter(boolean z, int i, int i2, Function2<? super CommonTaskInfo, ? super Integer, Unit> onSelectTask) {
        Intrinsics.checkNotNullParameter(onSelectTask, "onSelectTask");
        this.isArizona = z;
        this.colorMaxProgress = i;
        this.itemLayout = i2;
        this.onSelectTask = onSelectTask;
        this.allTasksList = new ArrayList<>();
        this.currentTasksList = new ArrayList<>();
    }

    public /* synthetic */ CommonTasksAdapter(boolean z, int i, int i2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, i2, (i3 & 8) != 0 ? new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.CommonTasksAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CommonTasksAdapter._init_$lambda$0((CommonTaskInfo) obj, ((Integer) obj2).intValue());
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(CommonTaskInfo commonTaskInfo, int i) {
        Intrinsics.checkNotNullParameter(commonTaskInfo, "<unused var>");
        return Unit.INSTANCE;
    }

    public final ArrayList<CommonTaskInfo> getAllTasksList() {
        return this.allTasksList;
    }

    public final ArrayList<CommonTaskInfo> getCurrentTasksList() {
        return this.currentTasksList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RodinaBattlePassCommonTaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RodinaBattlePassCommonTaskViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RodinaBattlePassCommonTaskViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CommonTaskInfo commonTaskInfo = this.currentTasksList.get(i);
        Intrinsics.checkNotNullExpressionValue(commonTaskInfo, "get(...)");
        final CommonTaskInfo commonTaskInfo2 = commonTaskInfo;
        WinterBattlepassCommonTaskItemBinding binding = holder.getBinding();
        binding.itemTitle.setText(commonTaskInfo2.getTitle());
        binding.itemDescription.setText(commonTaskInfo2.getDescription());
        TextView textView = binding.itemCount;
        int validCurrentProgress = commonTaskInfo2.validCurrentProgress();
        textView.setText(validCurrentProgress + "/" + commonTaskInfo2.getTotalProgress());
        binding.itemRewardDescription.setText(binding.getRoot().getContext().getString(R.string.battlepass_task_reward_units, Integer.valueOf(commonTaskInfo2.getPrizeValue())));
        binding.dayTaskProgressBar.setMax(commonTaskInfo2.getTotalProgress());
        binding.dayTaskProgressBar.setProgress(commonTaskInfo2.validCurrentProgress());
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int resolveBattlePassColor = BattlePassVisualSkinKt.resolveBattlePassColor(context, R.attr.winterBpTaskSelectedBg, R.color.winter_bp_task_selected_bg);
        Context context2 = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int resolveBattlePassColor2 = BattlePassVisualSkinKt.resolveBattlePassColor(context2, R.attr.winterBpTaskUnselectedBg, R.color.winter_bp_task_unselected_bg);
        Context context3 = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        int resolveBattlePassColor3 = BattlePassVisualSkinKt.resolveBattlePassColor(context3, R.attr.winterBpTaskSurfaceTrack, R.color.winter_bp_white);
        if (commonTaskInfo2.isSelected()) {
            binding.getRoot().setBackground(resolveBattlePassColor);
        } else {
            binding.getRoot().setBackground(resolveBattlePassColor2);
        }
        if (commonTaskInfo2.validCurrentProgress() == commonTaskInfo2.getTotalProgress()) {
            binding.progressInPercentText.setVisibility(8);
            binding.progressDoneContainer.setVisibility(0);
            binding.dayTaskProgressBar.setProgressTintList(ColorStateList.valueOf(this.colorMaxProgress));
            binding.itemRewardDescription.setTextColor(holder.getDefaultRewardDescriptionColor());
            binding.itemCount.setTextColor(this.colorMaxProgress);
        } else {
            binding.progressDoneContainer.setVisibility(8);
            binding.progressInPercentText.setVisibility(0);
            binding.progressInPercentText.setText(((int) ((commonTaskInfo2.validCurrentProgress() / commonTaskInfo2.getTotalProgress()) * 100.0f)) + "%");
            binding.dayTaskProgressBar.setProgressTintList(ColorStateList.valueOf(resolveBattlePassColor3));
            binding.itemRewardDescription.setTextColor(holder.getDefaultRewardDescriptionColor());
            binding.itemCount.setTextColor(holder.getDefaultItemCountColor());
        }
        holder.loadRewardImage(this.isArizona, commonTaskInfo2);
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.CommonTasksAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonTasksAdapter.onBindViewHolder$lambda$0$0(CommonTasksAdapter.this, commonTaskInfo2, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(CommonTasksAdapter commonTasksAdapter, CommonTaskInfo commonTaskInfo, int i, View view) {
        commonTasksAdapter.onSelectTask.invoke(commonTaskInfo, Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RodinaBattlePassCommonTaskViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.cancelImageLoading();
        super.onViewRecycled((CommonTasksAdapter) holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.currentTasksList.size();
    }

    public final void filterList(CategoryType categoryType) {
        Intrinsics.checkNotNullParameter(categoryType, "categoryType");
        for (CommonTaskInfo commonTaskInfo : this.allTasksList) {
            commonTaskInfo.setSelected(false);
        }
        this.currentTasksList.clear();
        ArrayList<CommonTaskInfo> arrayList = this.currentTasksList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.allTasksList) {
            CommonTaskInfo commonTaskInfo2 = (CommonTaskInfo) obj;
            if (commonTaskInfo2.getCategoryType() == categoryType.getValue() && commonTaskInfo2.isVisible()) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        if (!this.currentTasksList.isEmpty()) {
            this.currentTasksList.get(0).setSelected(true);
        }
        notifyDataSetChanged();
    }

    public final void selectTask(int i) {
        for (CommonTaskInfo commonTaskInfo : this.allTasksList) {
            commonTaskInfo.setSelected(false);
        }
        for (CommonTaskInfo commonTaskInfo2 : this.currentTasksList) {
            commonTaskInfo2.setSelected(false);
        }
        CommonTaskInfo commonTaskInfo3 = (CommonTaskInfo) CollectionsKt.getOrNull(this.currentTasksList, i);
        if (commonTaskInfo3 != null) {
            commonTaskInfo3.setSelected(true);
        }
        notifyDataSetChanged();
    }

    public final void addAllTasks(List<CommonTaskInfo> tasks) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CommonTasksAdapter$addAllTasks$1(this, tasks, null), 3, null);
    }

    public final void clearAllTasksList() {
        this.allTasksList.clear();
        this.currentTasksList.clear();
        notifyDataSetChanged();
    }
}
